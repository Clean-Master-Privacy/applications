#pragma once

#include <boost/optional.hpp>
#include <stdexcept>
#include <regex>

class Description {
    public:
    Description() = default;
    virtual ~Description() = default;

    private:
    std::string en_us;
    std::string zh_cn;
    std::string zh_tw;
    std::string ru_ru;
    std::string es_es;
    std::string pt_br;
    std::string fr_fr;
    std::string ja_jp;
    std::string ko_kr;
    std::string in_id;
    std::string de_de;

    public:
    const std::string & get_en_us() const { return en_us; }
    std::string & get_mutable_en_us() { return en_us; }
    void set_en_us(const std::string & value) { this->en_us = value; }

    const std::string & get_zh_cn() const { return zh_cn; }
    std::string & get_mutable_zh_cn() { return zh_cn; }
    void set_zh_cn(const std::string & value) { this->zh_cn = value; }

    const std::string & get_zh_tw() const { return zh_tw; }
    std::string & get_mutable_zh_tw() { return zh_tw; }
    void set_zh_tw(const std::string & value) { this->zh_tw = value; }

    const std::string & get_ru_ru() const { return ru_ru; }
    std::string & get_mutable_ru_ru() { return ru_ru; }
    void set_ru_ru(const std::string & value) { this->ru_ru = value; }

    const std::string & get_es_es() const { return es_es; }
    std::string & get_mutable_es_es() { return es_es; }
    void set_es_es(const std::string & value) { this->es_es = value; }

    const std::string & get_pt_br() const { return pt_br; }
    std::string & get_mutable_pt_br() { return pt_br; }
    void set_pt_br(const std::string & value) { this->pt_br = value; }

    const std::string & get_fr_fr() const { return fr_fr; }
    std::string & get_mutable_fr_fr() { return fr_fr; }
    void set_fr_fr(const std::string & value) { this->fr_fr = value; }

    const std::string & get_ja_jp() const { return ja_jp; }
    std::string & get_mutable_ja_jp() { return ja_jp; }
    void set_ja_jp(const std::string & value) { this->ja_jp = value; }

    const std::string & get_ko_kr() const { return ko_kr; }
    std::string & get_mutable_ko_kr() { return ko_kr; }
    void set_ko_kr(const std::string & value) { this->ko_kr = value; }

    const std::string & get_in_id() const { return in_id; }
    std::string & get_mutable_in_id() { return in_id; }
    void set_in_id(const std::string & value) { this->in_id = value; }

    const std::string & get_de_de() const { return de_de; }
    std::string & get_mutable_de_de() { return de_de; }
    void set_de_de(const std::string & value) { this->de_de = value; }
};

class RecomendDesc {
    public:
    RecomendDesc() = default;
    virtual ~RecomendDesc() = default;

    private:
    std::string en_us;
    std::string zh_cn;
    std::string zh_tw;
    std::string es_es;
    std::string pt_br;

    public:
    const std::string & get_en_us() const { return en_us; }
    std::string & get_mutable_en_us() { return en_us; }
    void set_en_us(const std::string & value) { this->en_us = value; }

    const std::string & get_zh_cn() const { return zh_cn; }
    std::string & get_mutable_zh_cn() { return zh_cn; }
    void set_zh_cn(const std::string & value) { this->zh_cn = value; }

    const std::string & get_zh_tw() const { return zh_tw; }
    std::string & get_mutable_zh_tw() { return zh_tw; }
    void set_zh_tw(const std::string & value) { this->zh_tw = value; }

    const std::string & get_es_es() const { return es_es; }
    std::string & get_mutable_es_es() { return es_es; }
    void set_es_es(const std::string & value) { this->es_es = value; }

    const std::string & get_pt_br() const { return pt_br; }
    std::string & get_mutable_pt_br() { return pt_br; }
    void set_pt_br(const std::string & value) { this->pt_br = value; }
};

class Theme {
    public:
    Theme() = default;
    virtual ~Theme() = default;

    private:
    int64_t id;
    Description name;
    Description description;
    std::string big_pic_url;
    std::string btn_color;
    std::string btn_pre_color;
    std::string btn_big_start_color;
    std::string btn_big_end_color;
    std::string setting_bg_color;
    int64_t type;
    std::string setting_pic_url;
    std::shared_ptr<std::string> mcc;
    std::shared_ptr<std::string> download_url;
    std::shared_ptr<bool> is_new;
    std::shared_ptr<std::string> recomend_start_time;
    std::shared_ptr<std::string> recomend_end_time;
    std::shared_ptr<std::string> recomend_pic;
    std::shared_ptr<RecomendDesc> recomend_desc;

    public:
    const int64_t & get_id() const { return id; }
    int64_t & get_mutable_id() { return id; }
    void set_id(const int64_t & value) { this->id = value; }

    const Description & get_name() const { return name; }
    Description & get_mutable_name() { return name; }
    void set_name(const Description & value) { this->name = value; }

    const Description & get_description() const { return description; }
    Description & get_mutable_description() { return description; }
    void set_description(const Description & value) { this->description = value; }

    const std::string & get_big_pic_url() const { return big_pic_url; }
    std::string & get_mutable_big_pic_url() { return big_pic_url; }
    void set_big_pic_url(const std::string & value) { this->big_pic_url = value; }

    const std::string & get_btn_color() const { return btn_color; }
    std::string & get_mutable_btn_color() { return btn_color; }
    void set_btn_color(const std::string & value) { this->btn_color = value; }

    const std::string & get_btn_pre_color() const { return btn_pre_color; }
    std::string & get_mutable_btn_pre_color() { return btn_pre_color; }
    void set_btn_pre_color(const std::string & value) { this->btn_pre_color = value; }

    const std::string & get_btn_big_start_color() const { return btn_big_start_color; }
    std::string & get_mutable_btn_big_start_color() { return btn_big_start_color; }
    void set_btn_big_start_color(const std::string & value) { this->btn_big_start_color = value; }

    const std::string & get_btn_big_end_color() const { return btn_big_end_color; }
    std::string & get_mutable_btn_big_end_color() { return btn_big_end_color; }
    void set_btn_big_end_color(const std::string & value) { this->btn_big_end_color = value; }

    const std::string & get_setting_bg_color() const { return setting_bg_color; }
    std::string & get_mutable_setting_bg_color() { return setting_bg_color; }
    void set_setting_bg_color(const std::string & value) { this->setting_bg_color = value; }

    const int64_t & get_type() const { return type; }
    int64_t & get_mutable_type() { return type; }
    void set_type(const int64_t & value) { this->type = value; }

    const std::string & get_setting_pic_url() const { return setting_pic_url; }
    std::string & get_mutable_setting_pic_url() { return setting_pic_url; }
    void set_setting_pic_url(const std::string & value) { this->setting_pic_url = value; }

    std::shared_ptr<std::string> get_mcc() const { return mcc; }
    void set_mcc(std::shared_ptr<std::string> value) { this->mcc = value; }

    std::shared_ptr<std::string> get_download_url() const { return download_url; }
    void set_download_url(std::shared_ptr<std::string> value) { this->download_url = value; }

    std::shared_ptr<bool> get_is_new() const { return is_new; }
    void set_is_new(std::shared_ptr<bool> value) { this->is_new = value; }

    std::shared_ptr<std::string> get_recomend_start_time() const { return recomend_start_time; }
    void set_recomend_start_time(std::shared_ptr<std::string> value) { this->recomend_start_time = value; }

    std::shared_ptr<std::string> get_recomend_end_time() const { return recomend_end_time; }
    void set_recomend_end_time(std::shared_ptr<std::string> value) { this->recomend_end_time = value; }

    std::shared_ptr<std::string> get_recomend_pic() const { return recomend_pic; }
    void set_recomend_pic(std::shared_ptr<std::string> value) { this->recomend_pic = value; }

    std::shared_ptr<RecomendDesc> get_recomend_desc() const { return recomend_desc; }
    void set_recomend_desc(std::shared_ptr<RecomendDesc> value) { this->recomend_desc = value; }
};

class Welcome1 {
    public:
    Welcome1() = default;
    virtual ~Welcome1() = default;

    private:
    std::vector<int64_t> theme_orders_for_settings;
    std::vector<int64_t> theme_orders_for_popup_window;
    std::vector<Theme> themes;

    public:
    const std::vector<int64_t> & get_theme_orders_for_settings() const { return theme_orders_for_settings; }
    std::vector<int64_t> & get_mutable_theme_orders_for_settings() { return theme_orders_for_settings; }
    void set_theme_orders_for_settings(const std::vector<int64_t> & value) { this->theme_orders_for_settings = value; }

    const std::vector<int64_t> & get_theme_orders_for_popup_window() const { return theme_orders_for_popup_window; }
    std::vector<int64_t> & get_mutable_theme_orders_for_popup_window() { return theme_orders_for_popup_window; }
    void set_theme_orders_for_popup_window(const std::vector<int64_t> & value) { this->theme_orders_for_popup_window = value; }

    const std::vector<Theme> & get_themes() const { return themes; }
    std::vector<Theme> & get_mutable_themes() { return themes; }
    void set_themes(const std::vector<Theme> & value) { this->themes = value; }
};
