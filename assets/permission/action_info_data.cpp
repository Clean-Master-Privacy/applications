#pragma once

#include <boost/optional.hpp>
#include <stdexcept>
#include <regex>

class LocateNode {
    public:
    LocateNode() = default;
    virtual ~LocateNode() = default;

    private:
    std::shared_ptr<std::string> string_id;
    std::shared_ptr<std::vector<std::string>> find_texts;
    std::shared_ptr<std::string> id_name;
    std::shared_ptr<std::string> class_name;
    std::shared_ptr<std::string> item_index;

    public:
    std::shared_ptr<std::string> get_string_id() const { return string_id; }
    void set_string_id(std::shared_ptr<std::string> value) { this->string_id = value; }

    std::shared_ptr<std::vector<std::string>> get_find_texts() const { return find_texts; }
    void set_find_texts(std::shared_ptr<std::vector<std::string>> value) { this->find_texts = value; }

    std::shared_ptr<std::string> get_id_name() const { return id_name; }
    void set_id_name(std::shared_ptr<std::string> value) { this->id_name = value; }

    std::shared_ptr<std::string> get_class_name() const { return class_name; }
    void set_class_name(std::shared_ptr<std::string> value) { this->class_name = value; }

    std::shared_ptr<std::string> get_item_index() const { return item_index; }
    void set_item_index(std::shared_ptr<std::string> value) { this->item_index = value; }
};

enum class Behavior : int { CLICK };

class OperationNode {
    public:
    OperationNode() = default;
    virtual ~OperationNode() = default;

    private:
    Behavior behavior;

    public:
    const Behavior & get_behavior() const { return behavior; }
    Behavior & get_mutable_behavior() { return behavior; }
    void set_behavior(const Behavior & value) { this->behavior = value; }
};

class ScrollNode {
    public:
    ScrollNode() = default;
    virtual ~ScrollNode() = default;

    private:
    std::string class_name;

    public:
    const std::string & get_class_name() const { return class_name; }
    std::string & get_mutable_class_name() { return class_name; }
    void set_class_name(const std::string & value) { this->class_name = value; }
};

class ActionItem {
    public:
    ActionItem() = default;
    virtual ~ActionItem() = default;

    private:
    int64_t id;
    std::string describe;
    bool need_wait_window;
    int64_t need_wait_time;
    LocateNode locate_node;
    OperationNode operation_node;
    std::shared_ptr<ScrollNode> scroll_node;

    public:
    const int64_t & get_id() const { return id; }
    int64_t & get_mutable_id() { return id; }
    void set_id(const int64_t & value) { this->id = value; }

    const std::string & get_describe() const { return describe; }
    std::string & get_mutable_describe() { return describe; }
    void set_describe(const std::string & value) { this->describe = value; }

    const bool & get_need_wait_window() const { return need_wait_window; }
    bool & get_mutable_need_wait_window() { return need_wait_window; }
    void set_need_wait_window(const bool & value) { this->need_wait_window = value; }

    const int64_t & get_need_wait_time() const { return need_wait_time; }
    int64_t & get_mutable_need_wait_time() { return need_wait_time; }
    void set_need_wait_time(const int64_t & value) { this->need_wait_time = value; }

    const LocateNode & get_locate_node() const { return locate_node; }
    LocateNode & get_mutable_locate_node() { return locate_node; }
    void set_locate_node(const LocateNode & value) { this->locate_node = value; }

    const OperationNode & get_operation_node() const { return operation_node; }
    OperationNode & get_mutable_operation_node() { return operation_node; }
    void set_operation_node(const OperationNode & value) { this->operation_node = value; }

    std::shared_ptr<ScrollNode> get_scroll_node() const { return scroll_node; }
    void set_scroll_node(std::shared_ptr<ScrollNode> value) { this->scroll_node = value; }
};

class Welcome10 {
    public:
    Welcome10() = default;
    virtual ~Welcome10() = default;

    private:
    int64_t version;
    std::vector<ActionItem> action_items;

    public:
    const int64_t & get_version() const { return version; }
    int64_t & get_mutable_version() { return version; }
    void set_version(const int64_t & value) { this->version = value; }

    const std::vector<ActionItem> & get_action_items() const { return action_items; }
    std::vector<ActionItem> & get_mutable_action_items() { return action_items; }
    void set_action_items(const std::vector<ActionItem> & value) { this->action_items = value; }
};
