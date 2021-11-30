#include "tokenizer.h"

bool SymbolToken::operator==(const SymbolToken& other) const {
    return (name_ == other.name_);
}
bool QuoteToken::operator==(const QuoteToken&) const {
    return true;
}
bool DotToken::operator==(const DotToken&) const {
    return true;
}
bool ConstantToken::operator==(const ConstantToken& other) const {
    return value_ == other.value_;
}
bool BooleanToken::operator==(const BooleanToken&) const {
    return true;
}
bool Tokenizer::IsEnd() {
    from_is_end_ = true;
    Next();
    from_is_end_ = false;
    return is_end_;
}
void Tokenizer::Next() {
    if (!from_is_end_) {
        ++n_next_;
        if (n_next_ > n_get_) {
            while (n_next_ != n_get_) {
                GetToken();
            }
        }
    }
    while (true) {
        str_ = "";
        is_symbol_ = false;
        is_digit_ = false;
        if (in_.peek() != EOF) {
            if (std::isspace(in_.peek())) {
                in_.get();
                continue;
            } else {
                char curr_el = in_.peek();
                if (!std::isalnum(in_.peek()) && in_.peek() != '(' && in_.peek() != ')' &&
                    in_.peek() != '<' && in_.peek() != '=' && in_.peek() != '>' &&
                    in_.peek() != '*' && in_.peek() != '\'' && in_.peek() != '.' &&
                    in_.peek() != '#' && in_.peek() != '?' && in_.peek() != '!' &&
                    in_.peek() != '-' && in_.peek() != '+') {
                    throw SyntaxError("s_error");
                } else {
                    is_end_ = false;
                    return;
                }
            }
        } else {
            is_end_ = true;
            return;
        }
    }
}
Token Tokenizer::GetToken() {
    ++n_get_;
    if (!str_.empty()) {
        if (is_symbol_ || ((str_[0] == '-' || str_[0] == '+') && !is_digit_)) {
            Token token = SymbolToken(str_);
            return token;
        } else {
            std::string tmp = str_;
            if (str_[0] == '+') {
                tmp.erase(0, 1);
            }
            Token token = ConstantToken(std::stoi(tmp));
            return token;
        }
    }

    while (true) {
        if (str_.empty() && in_.peek() == '#'){
            str_.push_back(in_.get());
            if(in_.peek() == 't'){
                Token token = SymbolToken("#t");
                return token;
            } else if(in_.peek() == 'f'){
                Token token = SymbolToken("#f");
                return token;
            }
        }
        if (in_.peek() == '(') {
            if (str_.empty()) {
                str_.push_back(in_.get());
                return Token{BracketToken::OPEN};
            }
            break;
        } else if (in_.peek() == ')') {
            if (str_.empty()) {
                str_.push_back(in_.get());
                return Token{BracketToken::CLOSE};
            }
            break;
        } else if (in_.peek() == '.') {
            if (str_.empty()) {
                str_.push_back(in_.get());
                return Token{DotToken()};
            }
            break;
        } else if (in_.peek() == '\'') {
            if (str_.empty()) {
                str_.push_back(in_.get());
                return Token{QuoteToken()};
            }
            break;
        } else if (str_.empty() && (std::isalpha(in_.peek()) || in_.peek() == '<' ||
                                    in_.peek() == '=' || in_.peek() == '>' || in_.peek() == '*' ||
                                    in_.peek() == '/' || in_.peek() == '#')) {
            is_symbol_ = true;
            str_.push_back(in_.get());
            continue;
        } else if (is_symbol_ &&
                   (std::isalpha(in_.peek()) || in_.peek() == '<' || in_.peek() == '=' ||
                    in_.peek() == '>' || in_.peek() == '*' || in_.peek() == '/' ||
                    in_.peek() == '#' || std::isdigit(in_.peek()) || in_.peek() == '?' ||
                    in_.peek() == '!' || in_.peek() == '-')) {
            str_.push_back(in_.get());
            continue;
        } else if (str_.empty() && std::isdigit(in_.peek())) {
            is_digit_ = true;
            str_.push_back(in_.get());
            continue;
        } else if (str_.empty() && (in_.peek() == '+' || in_.peek() == '-')) {
            str_.push_back(in_.get());
            continue;
        } else if (is_digit_ && (std::isdigit(in_.peek()))) {
            str_.push_back(in_.get());
            continue;
        } else if ((str_[0] == '-' || str_[0] == '+') && (std::isdigit(in_.peek()))) {
            is_digit_ = true;
            str_.push_back(in_.get());
            continue;
        } else if ((str_[0] == '-' || str_[0] == '+') && str_.size() == 1) {
            auto tmp = str_;
            //                str_ = "";
            return Token{SymbolToken(tmp)};
        }
        break;
    }
    if (is_symbol_ || ((str_[0] == '-' || str_[0] == '+') && !is_digit_)) {
        Token token = SymbolToken(str_);
        //            str_ = "";
        return token;
    } else {
        std::string tmp = str_;
        if (str_[0] == '+') {
            tmp.erase(0, 1);
        }
        Token token = ConstantToken(std::stoi(tmp));
        //            str_ = "";
        return token;
    }
}
std::string& Tokenizer::GetString() {
    return str_;
}

