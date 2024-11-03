#pragma once

#include <boost/optional.hpp>
#include <stdexcept>
#include <regex>

enum class Title : int { APP, EMPTY, TITLE };

class RuleItem {
    public:
    RuleItem() = default;
    virtual ~RuleItem() = default;

    private:
    int64_t rom;
    Title title;
    int64_t process_id;
    int64_t type;
    int64_t priority;
    std::shared_ptr<int64_t> app;

    public:
    const int64_t & get_rom() const { return rom; }
    int64_t & get_mutable_rom() { return rom; }
    void set_rom(const int64_t & value) { this->rom = value; }

    const Title & get_title() const { return title; }
    Title & get_mutable_title() { return title; }
    void set_title(const Title & value) { this->title = value; }

    const int64_t & get_process_id() const { return process_id; }
    int64_t & get_mutable_process_id() { return process_id; }
    void set_process_id(const int64_t & value) { this->process_id = value; }

    const int64_t & get_type() const { return type; }
    int64_t & get_mutable_type() { return type; }
    void set_type(const int64_t & value) { this->type = value; }

    const int64_t & get_priority() const { return priority; }
    int64_t & get_mutable_priority() { return priority; }
    void set_priority(const int64_t & value) { this->priority = value; }

    std::shared_ptr<int64_t> get_app() const { return app; }
    void set_app(std::shared_ptr<int64_t> value) { this->app = value; }
};

class Welcome9 {
    public:
    Welcome9() = default;
    virtual ~Welcome9() = default;

    private:
    int64_t version;
    std::vector<RuleItem> rule_items;

    public:
    const int64_t & get_version() const { return version; }
    int64_t & get_mutable_version() { return version; }
    void set_version(const int64_t & value) { this->version = value; }

    const std::vector<RuleItem> & get_rule_items() const { return rule_items; }
    std::vector<RuleItem> & get_mutable_rule_items() { return rule_items; }
    void set_rule_items(const std::vector<RuleItem> & value) { this->rule_items = value; }
};
