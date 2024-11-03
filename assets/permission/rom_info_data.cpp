#pragma once

#include <boost/optional.hpp>
#include <stdexcept>
#include <regex>

enum class Condition : int { EQUAL, GE };

enum class Key : int { BRAND, RO_BUILD_PRODUCT, RO_PRODUCT_MODEL, SDK_INT, SECOND_SD };

class FeatureItem {
    public:
    FeatureItem() = default;
    virtual ~FeatureItem() = default;

    private:
    Key key;
    std::string value;
    Condition condition;

    public:
    const Key & get_key() const { return key; }
    Key & get_mutable_key() { return key; }
    void set_key(const Key & value) { this->key = value; }

    const std::string & get_value() const { return value; }
    std::string & get_mutable_value() { return value; }
    void set_value(const std::string & value) { this->value = value; }

    const Condition & get_condition() const { return condition; }
    Condition & get_mutable_condition() { return condition; }
    void set_condition(const Condition & value) { this->condition = value; }
};

class RomItem {
    public:
    RomItem() = default;
    virtual ~RomItem() = default;

    private:
    int64_t rom_id;
    std::string rom_name;
    std::vector<FeatureItem> feature_items;

    public:
    const int64_t & get_rom_id() const { return rom_id; }
    int64_t & get_mutable_rom_id() { return rom_id; }
    void set_rom_id(const int64_t & value) { this->rom_id = value; }

    const std::string & get_rom_name() const { return rom_name; }
    std::string & get_mutable_rom_name() { return rom_name; }
    void set_rom_name(const std::string & value) { this->rom_name = value; }

    const std::vector<FeatureItem> & get_feature_items() const { return feature_items; }
    std::vector<FeatureItem> & get_mutable_feature_items() { return feature_items; }
    void set_feature_items(const std::vector<FeatureItem> & value) { this->feature_items = value; }
};

class Welcome2 {
    public:
    Welcome2() = default;
    virtual ~Welcome2() = default;

    private:
    int64_t version;
    std::vector<RomItem> rom_items;

    public:
    const int64_t & get_version() const { return version; }
    int64_t & get_mutable_version() { return version; }
    void set_version(const int64_t & value) { this->version = value; }

    const std::vector<RomItem> & get_rom_items() const { return rom_items; }
    std::vector<RomItem> & get_mutable_rom_items() { return rom_items; }
    void set_rom_items(const std::vector<RomItem> & value) { this->rom_items = value; }
};
