#pragma once

#include <boost/variant.hpp>

#include <boost/optional.hpp>
#include <stdexcept>
#include <regex>

class CClass {
    public:
    CClass() = default;
    virtual ~CClass() = default;

    private:
    int64_t a;
    std::vector<double> k;

    public:
    const int64_t & get_a() const { return a; }
    int64_t & get_mutable_a() { return a; }
    void set_a(const int64_t & value) { this->a = value; }

    const std::vector<double> & get_k() const { return k; }
    std::vector<double> & get_mutable_k() { return k; }
    void set_k(const std::vector<double> & value) { this->k = value; }
};

class XClass {
    public:
    XClass() = default;
    virtual ~XClass() = default;

    private:
    int64_t a;
    int64_t k;

    public:
    const int64_t & get_a() const { return a; }
    int64_t & get_mutable_a() { return a; }
    void set_a(const int64_t & value) { this->a = value; }

    const int64_t & get_k() const { return k; }
    int64_t & get_mutable_k() { return k; }
    void set_k(const int64_t & value) { this->k = value; }
};

class I {
    public:
    I() = default;
    virtual ~I() = default;

    private:
    double x;
    int64_t y;

    public:
    const double & get_x() const { return x; }
    double & get_mutable_x() { return x; }
    void set_x(const double & value) { this->x = value; }

    const int64_t & get_y() const { return y; }
    int64_t & get_mutable_y() { return y; }
    void set_y(const int64_t & value) { this->y = value; }
};

class PurpleK {
    public:
    PurpleK() = default;
    virtual ~PurpleK() = default;

    private:
    std::shared_ptr<I> i;
    std::shared_ptr<I> o;
    std::shared_ptr<std::string> n;
    double t;
    std::shared_ptr<std::vector<double>> s;
    std::shared_ptr<std::vector<double>> e;
    std::shared_ptr<std::vector<double>> to;
    std::shared_ptr<std::vector<double>> ti;

    public:
    std::shared_ptr<I> get_i() const { return i; }
    void set_i(std::shared_ptr<I> value) { this->i = value; }

    std::shared_ptr<I> get_o() const { return o; }
    void set_o(std::shared_ptr<I> value) { this->o = value; }

    std::shared_ptr<std::string> get_n() const { return n; }
    void set_n(std::shared_ptr<std::string> value) { this->n = value; }

    const double & get_t() const { return t; }
    double & get_mutable_t() { return t; }
    void set_t(const double & value) { this->t = value; }

    std::shared_ptr<std::vector<double>> get_s() const { return s; }
    void set_s(std::shared_ptr<std::vector<double>> value) { this->s = value; }

    std::shared_ptr<std::vector<double>> get_e() const { return e; }
    void set_e(std::shared_ptr<std::vector<double>> value) { this->e = value; }

    std::shared_ptr<std::vector<double>> get_to() const { return to; }
    void set_to(std::shared_ptr<std::vector<double>> value) { this->to = value; }

    std::shared_ptr<std::vector<double>> get_ti() const { return ti; }
    void set_ti(std::shared_ptr<std::vector<double>> value) { this->ti = value; }
};

using PK = boost::variant<PurpleK, double>;

class KsP {
    public:
    KsP() = default;
    virtual ~KsP() = default;

    private:
    int64_t a;
    std::vector<PK> k;

    public:
    const int64_t & get_a() const { return a; }
    int64_t & get_mutable_a() { return a; }
    void set_a(const int64_t & value) { this->a = value; }

    const std::vector<PK> & get_k() const { return k; }
    std::vector<PK> & get_mutable_k() { return k; }
    void set_k(const std::vector<PK> & value) { this->k = value; }
};

class LayerKs {
    public:
    LayerKs() = default;
    virtual ~LayerKs() = default;

    private:
    XClass o;
    XClass r;
    KsP p;
    CClass a;
    CClass s;

    public:
    const XClass & get_o() const { return o; }
    XClass & get_mutable_o() { return o; }
    void set_o(const XClass & value) { this->o = value; }

    const XClass & get_r() const { return r; }
    XClass & get_mutable_r() { return r; }
    void set_r(const XClass & value) { this->r = value; }

    const KsP & get_p() const { return p; }
    KsP & get_mutable_p() { return p; }
    void set_p(const KsP & value) { this->p = value; }

    const CClass & get_a() const { return a; }
    CClass & get_mutable_a() { return a; }
    void set_a(const CClass & value) { this->a = value; }

    const CClass & get_s() const { return s; }
    CClass & get_mutable_s() { return s; }
    void set_s(const CClass & value) { this->s = value; }
};

class EElement {
    public:
    EElement() = default;
    virtual ~EElement() = default;

    private:
    std::vector<std::vector<double>> i;
    std::vector<std::vector<double>> o;
    std::vector<std::vector<double>> v;
    bool c;

    public:
    const std::vector<std::vector<double>> & get_i() const { return i; }
    std::vector<std::vector<double>> & get_mutable_i() { return i; }
    void set_i(const std::vector<std::vector<double>> & value) { this->i = value; }

    const std::vector<std::vector<double>> & get_o() const { return o; }
    std::vector<std::vector<double>> & get_mutable_o() { return o; }
    void set_o(const std::vector<std::vector<double>> & value) { this->o = value; }

    const std::vector<std::vector<double>> & get_v() const { return v; }
    std::vector<std::vector<double>> & get_mutable_v() { return v; }
    void set_v(const std::vector<std::vector<double>> & value) { this->v = value; }

    const bool & get_c() const { return c; }
    bool & get_mutable_c() { return c; }
    void set_c(const bool & value) { this->c = value; }
};

class Pt {
    public:
    Pt() = default;
    virtual ~Pt() = default;

    private:
    int64_t a;
    EElement k;

    public:
    const int64_t & get_a() const { return a; }
    int64_t & get_mutable_a() { return a; }
    void set_a(const int64_t & value) { this->a = value; }

    const EElement & get_k() const { return k; }
    EElement & get_mutable_k() { return k; }
    void set_k(const EElement & value) { this->k = value; }
};

class MasksProperty {
    public:
    MasksProperty() = default;
    virtual ~MasksProperty() = default;

    private:
    bool inv;
    std::string mode;
    Pt pt;
    XClass o;
    XClass x;
    std::string nm;

    public:
    const bool & get_inv() const { return inv; }
    bool & get_mutable_inv() { return inv; }
    void set_inv(const bool & value) { this->inv = value; }

    const std::string & get_mode() const { return mode; }
    std::string & get_mutable_mode() { return mode; }
    void set_mode(const std::string & value) { this->mode = value; }

    const Pt & get_pt() const { return pt; }
    Pt & get_mutable_pt() { return pt; }
    void set_pt(const Pt & value) { this->pt = value; }

    const XClass & get_o() const { return o; }
    XClass & get_mutable_o() { return o; }
    void set_o(const XClass & value) { this->o = value; }

    const XClass & get_x() const { return x; }
    XClass & get_mutable_x() { return x; }
    void set_x(const XClass & value) { this->x = value; }

    const std::string & get_nm() const { return nm; }
    std::string & get_mutable_nm() { return nm; }
    void set_nm(const std::string & value) { this->nm = value; }
};

class PurpleA {
    public:
    PurpleA() = default;
    virtual ~PurpleA() = default;

    private:
    int64_t a;
    std::vector<int64_t> k;
    int64_t ix;

    public:
    const int64_t & get_a() const { return a; }
    int64_t & get_mutable_a() { return a; }
    void set_a(const int64_t & value) { this->a = value; }

    const std::vector<int64_t> & get_k() const { return k; }
    std::vector<int64_t> & get_mutable_k() { return k; }
    void set_k(const std::vector<int64_t> & value) { this->k = value; }

    const int64_t & get_ix() const { return ix; }
    int64_t & get_mutable_ix() { return ix; }
    void set_ix(const int64_t & value) { this->ix = value; }
};

enum class Mn : int { ADBE_VECTOR_FILTER_MERGE, ADBE_VECTOR_GRAPHIC_FILL, ADBE_VECTOR_SHAPE_GROUP };

class SaClass {
    public:
    SaClass() = default;
    virtual ~SaClass() = default;

    private:
    int64_t a;
    int64_t k;
    std::shared_ptr<int64_t> ix;

    public:
    const int64_t & get_a() const { return a; }
    int64_t & get_mutable_a() { return a; }
    void set_a(const int64_t & value) { this->a = value; }

    const int64_t & get_k() const { return k; }
    int64_t & get_mutable_k() { return k; }
    void set_k(const int64_t & value) { this->k = value; }

    std::shared_ptr<int64_t> get_ix() const { return ix; }
    void set_ix(std::shared_ptr<int64_t> value) { this->ix = value; }
};

class ItP {
    public:
    ItP() = default;
    virtual ~ItP() = default;

    private:
    int64_t a;
    std::vector<PK> k;
    int64_t ix;

    public:
    const int64_t & get_a() const { return a; }
    int64_t & get_mutable_a() { return a; }
    void set_a(const int64_t & value) { this->a = value; }

    const std::vector<PK> & get_k() const { return k; }
    std::vector<PK> & get_mutable_k() { return k; }
    void set_k(const std::vector<PK> & value) { this->k = value; }

    const int64_t & get_ix() const { return ix; }
    int64_t & get_mutable_ix() { return ix; }
    void set_ix(const int64_t & value) { this->ix = value; }
};

using R = boost::variant<SaClass, int64_t>;

enum class Ty : int { FL, MM, SH, TR };

class It {
    public:
    It() = default;
    virtual ~It() = default;

    private:
    std::shared_ptr<int64_t> ind;
    Ty ty;
    std::shared_ptr<int64_t> ix;
    std::shared_ptr<Pt> ks;
    std::string nm;
    std::shared_ptr<Mn> mn;
    std::shared_ptr<CClass> c;
    std::shared_ptr<SaClass> o;
    std::shared_ptr<R> r;
    std::shared_ptr<ItP> p;
    std::shared_ptr<PurpleA> a;
    std::shared_ptr<PurpleA> s;
    std::shared_ptr<SaClass> sk;
    std::shared_ptr<SaClass> sa;
    std::shared_ptr<int64_t> mm;

    public:
    std::shared_ptr<int64_t> get_ind() const { return ind; }
    void set_ind(std::shared_ptr<int64_t> value) { this->ind = value; }

    const Ty & get_ty() const { return ty; }
    Ty & get_mutable_ty() { return ty; }
    void set_ty(const Ty & value) { this->ty = value; }

    std::shared_ptr<int64_t> get_ix() const { return ix; }
    void set_ix(std::shared_ptr<int64_t> value) { this->ix = value; }

    std::shared_ptr<Pt> get_ks() const { return ks; }
    void set_ks(std::shared_ptr<Pt> value) { this->ks = value; }

    const std::string & get_nm() const { return nm; }
    std::string & get_mutable_nm() { return nm; }
    void set_nm(const std::string & value) { this->nm = value; }

    std::shared_ptr<Mn> get_mn() const { return mn; }
    void set_mn(std::shared_ptr<Mn> value) { this->mn = value; }

    std::shared_ptr<CClass> get_c() const { return c; }
    void set_c(std::shared_ptr<CClass> value) { this->c = value; }

    std::shared_ptr<SaClass> get_o() const { return o; }
    void set_o(std::shared_ptr<SaClass> value) { this->o = value; }

    std::shared_ptr<R> get_r() const { return r; }
    void set_r(std::shared_ptr<R> value) { this->r = value; }

    std::shared_ptr<ItP> get_p() const { return p; }
    void set_p(std::shared_ptr<ItP> value) { this->p = value; }

    std::shared_ptr<PurpleA> get_a() const { return a; }
    void set_a(std::shared_ptr<PurpleA> value) { this->a = value; }

    std::shared_ptr<PurpleA> get_s() const { return s; }
    void set_s(std::shared_ptr<PurpleA> value) { this->s = value; }

    std::shared_ptr<SaClass> get_sk() const { return sk; }
    void set_sk(std::shared_ptr<SaClass> value) { this->sk = value; }

    std::shared_ptr<SaClass> get_sa() const { return sa; }
    void set_sa(std::shared_ptr<SaClass> value) { this->sa = value; }

    std::shared_ptr<int64_t> get_mm() const { return mm; }
    void set_mm(std::shared_ptr<int64_t> value) { this->mm = value; }
};

class FluffyK {
    public:
    FluffyK() = default;
    virtual ~FluffyK() = default;

    private:
    std::shared_ptr<I> i;
    std::shared_ptr<I> o;
    std::shared_ptr<std::string> n;
    int64_t t;
    std::shared_ptr<std::vector<EElement>> s;
    std::shared_ptr<std::vector<EElement>> e;

    public:
    std::shared_ptr<I> get_i() const { return i; }
    void set_i(std::shared_ptr<I> value) { this->i = value; }

    std::shared_ptr<I> get_o() const { return o; }
    void set_o(std::shared_ptr<I> value) { this->o = value; }

    std::shared_ptr<std::string> get_n() const { return n; }
    void set_n(std::shared_ptr<std::string> value) { this->n = value; }

    const int64_t & get_t() const { return t; }
    int64_t & get_mutable_t() { return t; }
    void set_t(const int64_t & value) { this->t = value; }

    std::shared_ptr<std::vector<EElement>> get_s() const { return s; }
    void set_s(std::shared_ptr<std::vector<EElement>> value) { this->s = value; }

    std::shared_ptr<std::vector<EElement>> get_e() const { return e; }
    void set_e(std::shared_ptr<std::vector<EElement>> value) { this->e = value; }
};

using KsKUnion = boost::variant<std::vector<FluffyK>, EElement>;

class ShapeKs {
    public:
    ShapeKs() = default;
    virtual ~ShapeKs() = default;

    private:
    int64_t a;
    KsKUnion k;

    public:
    const int64_t & get_a() const { return a; }
    int64_t & get_mutable_a() { return a; }
    void set_a(const int64_t & value) { this->a = value; }

    const KsKUnion & get_k() const { return k; }
    KsKUnion & get_mutable_k() { return k; }
    void set_k(const KsKUnion & value) { this->k = value; }
};

class Shape {
    public:
    Shape() = default;
    virtual ~Shape() = default;

    private:
    std::string ty;
    std::shared_ptr<std::vector<It>> it;
    std::string nm;
    std::shared_ptr<int64_t> np;
    std::shared_ptr<int64_t> cix;
    std::shared_ptr<int64_t> ix;
    std::string mn;
    std::shared_ptr<int64_t> ind;
    std::shared_ptr<ShapeKs> ks;
    std::shared_ptr<CClass> c;
    std::shared_ptr<XClass> o;
    std::shared_ptr<int64_t> r;
    std::shared_ptr<XClass> w;
    std::shared_ptr<int64_t> lc;
    std::shared_ptr<int64_t> lj;
    std::shared_ptr<int64_t> ml;

    public:
    const std::string & get_ty() const { return ty; }
    std::string & get_mutable_ty() { return ty; }
    void set_ty(const std::string & value) { this->ty = value; }

    std::shared_ptr<std::vector<It>> get_it() const { return it; }
    void set_it(std::shared_ptr<std::vector<It>> value) { this->it = value; }

    const std::string & get_nm() const { return nm; }
    std::string & get_mutable_nm() { return nm; }
    void set_nm(const std::string & value) { this->nm = value; }

    std::shared_ptr<int64_t> get_np() const { return np; }
    void set_np(std::shared_ptr<int64_t> value) { this->np = value; }

    std::shared_ptr<int64_t> get_cix() const { return cix; }
    void set_cix(std::shared_ptr<int64_t> value) { this->cix = value; }

    std::shared_ptr<int64_t> get_ix() const { return ix; }
    void set_ix(std::shared_ptr<int64_t> value) { this->ix = value; }

    const std::string & get_mn() const { return mn; }
    std::string & get_mutable_mn() { return mn; }
    void set_mn(const std::string & value) { this->mn = value; }

    std::shared_ptr<int64_t> get_ind() const { return ind; }
    void set_ind(std::shared_ptr<int64_t> value) { this->ind = value; }

    std::shared_ptr<ShapeKs> get_ks() const { return ks; }
    void set_ks(std::shared_ptr<ShapeKs> value) { this->ks = value; }

    std::shared_ptr<CClass> get_c() const { return c; }
    void set_c(std::shared_ptr<CClass> value) { this->c = value; }

    std::shared_ptr<XClass> get_o() const { return o; }
    void set_o(std::shared_ptr<XClass> value) { this->o = value; }

    std::shared_ptr<int64_t> get_r() const { return r; }
    void set_r(std::shared_ptr<int64_t> value) { this->r = value; }

    std::shared_ptr<XClass> get_w() const { return w; }
    void set_w(std::shared_ptr<XClass> value) { this->w = value; }

    std::shared_ptr<int64_t> get_lc() const { return lc; }
    void set_lc(std::shared_ptr<int64_t> value) { this->lc = value; }

    std::shared_ptr<int64_t> get_lj() const { return lj; }
    void set_lj(std::shared_ptr<int64_t> value) { this->lj = value; }

    std::shared_ptr<int64_t> get_ml() const { return ml; }
    void set_ml(std::shared_ptr<int64_t> value) { this->ml = value; }
};

class Layer {
    public:
    Layer() = default;
    virtual ~Layer() = default;

    private:
    int64_t ddd;
    int64_t ind;
    int64_t ty;
    std::string nm;
    LayerKs ks;
    int64_t ao;
    std::shared_ptr<bool> has_mask;
    std::shared_ptr<std::vector<MasksProperty>> masks_properties;
    std::vector<Shape> shapes;
    int64_t ip;
    int64_t op;
    int64_t st;
    int64_t bm;
    double sr;

    public:
    const int64_t & get_ddd() const { return ddd; }
    int64_t & get_mutable_ddd() { return ddd; }
    void set_ddd(const int64_t & value) { this->ddd = value; }

    const int64_t & get_ind() const { return ind; }
    int64_t & get_mutable_ind() { return ind; }
    void set_ind(const int64_t & value) { this->ind = value; }

    const int64_t & get_ty() const { return ty; }
    int64_t & get_mutable_ty() { return ty; }
    void set_ty(const int64_t & value) { this->ty = value; }

    const std::string & get_nm() const { return nm; }
    std::string & get_mutable_nm() { return nm; }
    void set_nm(const std::string & value) { this->nm = value; }

    const LayerKs & get_ks() const { return ks; }
    LayerKs & get_mutable_ks() { return ks; }
    void set_ks(const LayerKs & value) { this->ks = value; }

    const int64_t & get_ao() const { return ao; }
    int64_t & get_mutable_ao() { return ao; }
    void set_ao(const int64_t & value) { this->ao = value; }

    std::shared_ptr<bool> get_has_mask() const { return has_mask; }
    void set_has_mask(std::shared_ptr<bool> value) { this->has_mask = value; }

    std::shared_ptr<std::vector<MasksProperty>> get_masks_properties() const { return masks_properties; }
    void set_masks_properties(std::shared_ptr<std::vector<MasksProperty>> value) { this->masks_properties = value; }

    const std::vector<Shape> & get_shapes() const { return shapes; }
    std::vector<Shape> & get_mutable_shapes() { return shapes; }
    void set_shapes(const std::vector<Shape> & value) { this->shapes = value; }

    const int64_t & get_ip() const { return ip; }
    int64_t & get_mutable_ip() { return ip; }
    void set_ip(const int64_t & value) { this->ip = value; }

    const int64_t & get_op() const { return op; }
    int64_t & get_mutable_op() { return op; }
    void set_op(const int64_t & value) { this->op = value; }

    const int64_t & get_st() const { return st; }
    int64_t & get_mutable_st() { return st; }
    void set_st(const int64_t & value) { this->st = value; }

    const int64_t & get_bm() const { return bm; }
    int64_t & get_mutable_bm() { return bm; }
    void set_bm(const int64_t & value) { this->bm = value; }

    const double & get_sr() const { return sr; }
    double & get_mutable_sr() { return sr; }
    void set_sr(const double & value) { this->sr = value; }
};

class Welcome5 {
    public:
    Welcome5() = default;
    virtual ~Welcome5() = default;

    private:
    std::string v;
    int64_t fr;
    int64_t ip;
    int64_t op;
    int64_t w;
    int64_t h;
    std::string nm;
    int64_t ddd;
    std::vector<nlohmann::json> assets;
    std::vector<Layer> layers;

    public:
    const std::string & get_v() const { return v; }
    std::string & get_mutable_v() { return v; }
    void set_v(const std::string & value) { this->v = value; }

    const int64_t & get_fr() const { return fr; }
    int64_t & get_mutable_fr() { return fr; }
    void set_fr(const int64_t & value) { this->fr = value; }

    const int64_t & get_ip() const { return ip; }
    int64_t & get_mutable_ip() { return ip; }
    void set_ip(const int64_t & value) { this->ip = value; }

    const int64_t & get_op() const { return op; }
    int64_t & get_mutable_op() { return op; }
    void set_op(const int64_t & value) { this->op = value; }

    const int64_t & get_w() const { return w; }
    int64_t & get_mutable_w() { return w; }
    void set_w(const int64_t & value) { this->w = value; }

    const int64_t & get_h() const { return h; }
    int64_t & get_mutable_h() { return h; }
    void set_h(const int64_t & value) { this->h = value; }

    const std::string & get_nm() const { return nm; }
    std::string & get_mutable_nm() { return nm; }
    void set_nm(const std::string & value) { this->nm = value; }

    const int64_t & get_ddd() const { return ddd; }
    int64_t & get_mutable_ddd() { return ddd; }
    void set_ddd(const int64_t & value) { this->ddd = value; }

    const std::vector<nlohmann::json> & get_assets() const { return assets; }
    std::vector<nlohmann::json> & get_mutable_assets() { return assets; }
    void set_assets(const std::vector<nlohmann::json> & value) { this->assets = value; }

    const std::vector<Layer> & get_layers() const { return layers; }
    std::vector<Layer> & get_mutable_layers() { return layers; }
    void set_layers(const std::vector<Layer> & value) { this->layers = value; }
};
