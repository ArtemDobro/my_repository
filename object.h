#pragma once

#include <memory>
#include <typeinfo>
#include "tokenizer.h"

class Object : public std::enable_shared_from_this<Object> {
public:
    virtual ~Object() = default;
};

class Number : public Object {
    int value_;

public:
    Number() {
    }
    Number(int value) : value_(value) {
    }
    int GetValue() const {
        return value_;
    }
};

class Symbol : public Object {
    std::string name_;

public:
    Symbol() {
    }
    Symbol(std::string name) : name_(name) {
    }
    const std::string& GetName() const {
        return name_;
    }
};

class Cell : public Object {
    std::shared_ptr<Object> first_ = nullptr;
    std::shared_ptr<Object> second_ = nullptr;

public:
    std::shared_ptr<Object>& GetFirst() {
        return first_;
    }
    std::shared_ptr<Object>& GetSecond() {
        return second_;
    }
};

 template <class T>
 std::shared_ptr<T> As(const std::shared_ptr<Object>& obj){
    T* tmp = dynamic_cast<T*>(obj.get());
    return std::make_shared<T>(*tmp);
}

template <class T>
bool Is(const std::shared_ptr<Object>& obj) {
    Object* tmp = new T;
    if (typeid((*(obj.get()))) == typeid(*tmp)) {
        delete tmp;
        return true;
    } else {
        delete tmp;
        return false;
    }
}
