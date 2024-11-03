#pragma once

#include <boost/optional.hpp>
#include <stdexcept>
#include <regex>

enum class Describe : int { EMPTY, MERRIAMWEBSTER, U_C };

class ProcessItem {
    public:
    ProcessItem() = default;
    virtual ~ProcessItem() = default;

    private:
    int64_t id;
    Describe describe;
    int64_t intent_id;
    std::vector<int64_t> action_id;

    public:
    const int64_t & get_id() const { return id; }
    int64_t & get_mutable_id() { return id; }
    void set_id(const int64_t & value) { this->id = value; }

    const Describe & get_describe() const { return describe; }
    Describe & get_mutable_describe() { return describe; }
    void set_describe(const Describe & value) { this->describe = value; }

    const int64_t & get_intent_id() const { return intent_id; }
    int64_t & get_mutable_intent_id() { return intent_id; }
    void set_intent_id(const int64_t & value) { this->intent_id = value; }

    const std::vector<int64_t> & get_action_id() const { return action_id; }
    std::vector<int64_t> & get_mutable_action_id() { return action_id; }
    void set_action_id(const std::vector<int64_t> & value) { this->action_id = value; }
};

class Welcome10 {
    public:
    Welcome10() = default;
    virtual ~Welcome10() = default;

    private:
    int64_t version;
    std::vector<ProcessItem> process_items;

    public:
    const int64_t & get_version() const { return version; }
    int64_t & get_mutable_version() { return version; }
    void set_version(const int64_t & value) { this->version = value; }

    const std::vector<ProcessItem> & get_process_items() const { return process_items; }
    std::vector<ProcessItem> & get_mutable_process_items() { return process_items; }
    void set_process_items(const std::vector<ProcessItem> & value) { this->process_items = value; }
};
