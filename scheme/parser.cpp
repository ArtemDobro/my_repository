#include "parser.h"

std::shared_ptr<Object> Read(Tokenizer* tokenizer) {
    auto str_before = tokenizer->GetString();
    if (tokenizer->IsEnd()) {
        throw SyntaxError("s_error");
    }

    auto token = tokenizer->GetToken();

    if (token == Token{QuoteToken()} && str_before.empty()) {
        throw SyntaxError("s_error");
    }

    if (std::holds_alternative<BracketToken>(token)) {
        if (token == Token{BracketToken::OPEN}) {
            tokenizer->count_open_brackets_++;
            if (tokenizer->IsEnd() &&
                tokenizer->count_open_brackets_ != tokenizer->count_close_brackets_) {
                throw SyntaxError("s_error");
            }
            tokenizer->GetString() = "(";
            return ReadList(tokenizer);
        }
        if (token == Token{BracketToken::CLOSE}) {
            tokenizer->count_close_brackets_++;
            if (tokenizer->count_open_brackets_ < tokenizer->count_close_brackets_) {
                throw SyntaxError("s_error");
            }
            if (tokenizer->IsEnd() &&
                tokenizer->count_open_brackets_ != tokenizer->count_close_brackets_) {
                throw SyntaxError("s_error");
            }
            tokenizer->GetString() = ")";
            return std::make_shared<Symbol>(")");
        }
    }
    if (!tokenizer->IsEnd() &&
        tokenizer->count_open_brackets_ <= tokenizer->count_close_brackets_) {  // if "1 5 anc"
        throw SyntaxError("s_error");
    }
    if (tokenizer->IsEnd() && tokenizer->count_open_brackets_ != tokenizer->count_close_brackets_) {
        throw SyntaxError("s_error");
    }
    if (tokenizer->count_open_brackets_ != 0 &&
        tokenizer->count_open_brackets_ == tokenizer->count_close_brackets_) {  // if "() -"
        throw SyntaxError("s_error");
    } else if (std::holds_alternative<ConstantToken>(token)) {
        tokenizer->GetString() = std::to_string(std::get<ConstantToken>(token).value_);
        return std::make_shared<Number>(std::get<ConstantToken>(token).value_);
    } else if (std::holds_alternative<DotToken>(token)) {
        if (tokenizer->count_open_brackets_ <= tokenizer->count_close_brackets_) {
            throw SyntaxError("s_error");
        }
        return std::make_shared<Symbol>(".");
    } else if (std::holds_alternative<QuoteToken>(token)) {
        tokenizer->GetString() = "'";
        return std::make_shared<Symbol>("'");
    } else if (std::holds_alternative<SymbolToken>(token)) {
        tokenizer->GetString() = std::get<SymbolToken>(token).name_;
        return std::make_shared<Symbol>(std::get<SymbolToken>(token).name_);
    }
    return std::shared_ptr<Object>();
}
bool IsSym(std::shared_ptr<Object> node) {
    std::shared_ptr<Object> sym = std::make_shared<Symbol>();
    //    Object* sym = new Symbol;
    if (typeid((*(node.get()))) == typeid(*sym.get())) {
        return true;
    }
    return false;
}

std::shared_ptr<Object> ReadList(Tokenizer* tokenizer) {
    std::shared_ptr<Cell> cell = std::make_shared<Cell>();
    while (true) {
        std::string str_before = tokenizer->GetString();
        tokenizer->Next();
        std::shared_ptr<Object> node = Read(tokenizer);
        if (node && IsSym(node) && (As<Symbol>(node)->GetName() == ".")) {
            if (str_before == "(") {
                throw SyntaxError("s_error");
            }
            if (tokenizer->count_open_brackets_ <= tokenizer->count_close_brackets_) {
                throw SyntaxError("s_error");
            }
            tokenizer->Next();
            auto token = Read(tokenizer);
            if (token && IsSym(token) &&
                ((As<Symbol>(token)->GetName() == ")") || (As<Symbol>(token)->GetName() == "."))) {
                throw SyntaxError("s_error");
            }
            tokenizer->Next();
            tokenizer->GetToken();
            if (tokenizer->GetString() != ")") {
                throw SyntaxError("s_error");
            }
            return token;
        }
        if (node && IsSym(node) && (As<Symbol>(node)->GetName() == ")")) {
            if (cell->GetFirst() == nullptr && cell->GetSecond() == nullptr) {
                return nullptr;
            }
            return cell;
        }
        cell->GetFirst() = node;
        str_before = tokenizer->GetString();
        tokenizer->Next();
        auto sec_node = Read(tokenizer);
        if (sec_node && IsSym(sec_node) && (As<Symbol>(sec_node)->GetName() == ".")) {
            if (str_before == "(") {
                throw SyntaxError("s_error");
            }
            if (tokenizer->count_open_brackets_ <= tokenizer->count_close_brackets_) {
                throw SyntaxError("s_error");
            }
            tokenizer->Next();
            auto token = Read(tokenizer);
            if (token && IsSym(token) &&
                ((As<Symbol>(token)->GetName() == ")") || (As<Symbol>(token)->GetName() == "."))) {
                throw SyntaxError("s_error");
            }
            //            if (token && !tokenizer->IsEnd()){
            //                throw SyntaxError("s_error");
            //            }
            cell->GetSecond() = token;
            tokenizer->Next();
            tokenizer->GetToken();
            if (tokenizer->GetString() != ")") {
                throw SyntaxError("s_error");
            }
            return cell;
        }
        if (sec_node && IsSym(sec_node) && (As<Symbol>(sec_node)->GetName() == ")")) {
            return cell;
        } else {
            std::shared_ptr<Cell> sec_cell = std::make_shared<Cell>();
            sec_cell->GetFirst() = sec_node;
            sec_cell->GetSecond() = ReadList(tokenizer);
            cell->GetSecond() = sec_cell;
            return cell;
        }
    }
}
