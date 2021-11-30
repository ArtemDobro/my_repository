#pragma once

#include <variant>
#include <vector>
#include <optional>
#include <istream>
#include <stdexcept>
#include "error.h"

struct SymbolToken{
    std::string name_;
    SymbolToken(std::string name) : name_(name) {
    }
    bool operator==(const SymbolToken& other) const;

};

struct QuoteToken {
    QuoteToken() {
    }
    bool operator==(const QuoteToken&) const;
};
struct BooleanToken {
    bool my_bool_;
    BooleanToken(bool boolean ):my_bool_(boolean) {
    }
    bool operator==(const BooleanToken&) const;
};

struct DotToken {
    DotToken() {
    }
    bool operator==(const DotToken&) const;
};

enum class BracketToken { OPEN, CLOSE };

struct ConstantToken {
    int value_;
    ConstantToken(int value) : value_(value) {
    }
    bool operator==(const ConstantToken& other) const;
};

using Token = std::variant<ConstantToken, BracketToken, SymbolToken, QuoteToken, DotToken>;

class Tokenizer {

    std::istream& in_;
    bool is_end_ = false;
    std::string str_;
    bool is_symbol_ = false;
    bool is_digit_ = false;
    int n_next_ = 0;
    int n_get_ = 0;
    bool from_is_end_ = false;

public:
    int count_open_brackets_ = 0;
    int count_close_brackets_ = 0;
    Tokenizer(std::istream* in) : in_(*in) {
    }
    std::string& GetString();

    bool IsEnd();

    void Next();
    Token GetToken();
};
bool Foo();