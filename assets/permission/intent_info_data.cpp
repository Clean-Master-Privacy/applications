#pragma once

#include <boost/optional.hpp>
#include <stdexcept>
#include <regex>

class IntentItem {
    public:
    IntentItem() = default;
    virtual ~IntentItem() = default;

    private:
    int64_t id;
    std::string describe;
    std::shared_ptr<std::string> package;
    std::shared_ptr<std::string> action;
    std::shared_ptr<std::string> activity;
    std::shared_ptr<std::string> package1;
    std::shared_ptr<std::string> data;

    public:
    const int64_t & get_id() const { return id; }
    int64_t & get_mutable_id() { return id; }
    void set_id(const int64_t & value) { this->id = value; }

    const std::string & get_describe() const { return describe; }
    std::string & get_mutable_describe() { return describe; }
    void set_describe(const std::string & value) { this->describe = value; }

    std::shared_ptr<std::string> get_package() const { return package; }
    void set_package(std::shared_ptr<std::string> value) { this->package = value; }

    std::shared_ptr<std::string> get_action() const { return action; }
    void set_action(std::shared_ptr<std::string> value) { this->action = value; }

    std::shared_ptr<std::string> get_activity() const { return activity; }
    void set_activity(std::shared_ptr<std::string> value) { this->activity = value; }

    std::shared_ptr<std::string> get_package1() const { return package1; }
    void set_package1(std::shared_ptr<std::string> value) { this->package1 = value; }

    std::shared_ptr<std::string> get_data() const { return data; }
    void set_data(std::shared_ptr<std::string> value) { this->data = value; }
};

class Welcome1 {
    public:
    Welcome1() = default;
    virtual ~Welcome1() = default;

    private:
    int64_t version;
    std::vector<IntentItem> intent_items;

    public:
    const int64_t & get_version() const { return version; }
    int64_t & get_mutable_version() { return version; }
    void set_version(const int64_t & value) { this->version = value; }

    const std::vector<IntentItem> & get_intent_items() const { return intent_items; }
    std::vector<IntentItem> & get_mutable_intent_items() { return intent_items; }
    void set_intent_items(const std::vector<IntentItem> & value) { this->intent_items = value; }
};
