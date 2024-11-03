#pragma once

#include <boost/optional.hpp>
#include <stdexcept>
#include <regex>

class Native {
    public:
    Native() = default;
    virtual ~Native() = default;

    private:
    std::string pid;

    public:
    const std::string & get_pid() const { return pid; }
    std::string & get_mutable_pid() { return pid; }
    void set_pid(const std::string & value) { this->pid = value; }
};

class Welcome2 {
    public:
    Welcome2() = default;
    virtual ~Welcome2() = default;

    private:
    std::vector<Native> native;

    public:
    const std::vector<Native> & get_native() const { return native; }
    std::vector<Native> & get_mutable_native() { return native; }
    void set_native(const std::vector<Native> & value) { this->native = value; }
};
