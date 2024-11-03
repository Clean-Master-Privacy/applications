#pragma once

#include <boost/optional.hpp>
#include <stdexcept>
#include <regex>

class FeatureItem {
    public:
    FeatureItem() = default;
    virtual ~FeatureItem() = default;

    private:
    std::string key;
    std::string value;
    std::string condition;

    public:
    const std::string & get_key() const { return key; }
    std::string & get_mutable_key() { return key; }
    void set_key(const std::string & value) { this->key = value; }

    const std::string & get_value() const { return value; }
    std::string & get_mutable_value() { return value; }
    void set_value(const std::string & value) { this->value = value; }

    const std::string & get_condition() const { return condition; }
    std::string & get_mutable_condition() { return condition; }
    void set_condition(const std::string & value) { this->condition = value; }
};

class AppItem {
    public:
    AppItem() = default;
    virtual ~AppItem() = default;

    private:
    int64_t app_id;
    std::string app_name;
    std::string pkg_name;
    std::vector<FeatureItem> feature_items;

    public:
    const int64_t & get_app_id() const { return app_id; }
    int64_t & get_mutable_app_id() { return app_id; }
    void set_app_id(const int64_t & value) { this->app_id = value; }

    const std::string & get_app_name() const { return app_name; }
    std::string & get_mutable_app_name() { return app_name; }
    void set_app_name(const std::string & value) { this->app_name = value; }

    const std::string & get_pkg_name() const { return pkg_name; }
    std::string & get_mutable_pkg_name() { return pkg_name; }
    void set_pkg_name(const std::string & value) { this->pkg_name = value; }

    const std::vector<FeatureItem> & get_feature_items() const { return feature_items; }
    std::vector<FeatureItem> & get_mutable_feature_items() { return feature_items; }
    void set_feature_items(const std::vector<FeatureItem> & value) { this->feature_items = value; }
};

class Welcome3 {
    public:
    Welcome3() = default;
    virtual ~Welcome3() = default;

    private:
    int64_t version;
    std::vector<AppItem> app_items;

    public:
    const int64_t & get_version() const { return version; }
    int64_t & get_mutable_version() { return version; }
    void set_version(const int64_t & value) { this->version = value; }

    const std::vector<AppItem> & get_app_items() const { return app_items; }
    std::vector<AppItem> & get_mutable_app_items() { return app_items; }
    void set_app_items(const std::vector<AppItem> & value) { this->app_items = value; }
};
