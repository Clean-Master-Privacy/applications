#pragma once

#include <boost/optional.hpp>
#include <stdexcept>
#include <regex>

class Welcome10 {
    public:
    Welcome10() = default;
    virtual ~Welcome10() = default;

    private:
    std::string welcome10_module;

    public:
    const std::string & get_welcome10_module() const { return welcome10_module; }
    std::string & get_mutable_welcome10_module() { return welcome10_module; }
    void set_welcome10_module(const std::string & value) { this->welcome10_module = value; }
};
