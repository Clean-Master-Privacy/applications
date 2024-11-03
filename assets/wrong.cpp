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

class I {
    public:
    I() = default;
    virtual ~I() = default;

    private:
    std::vector<double> x;
    std::vector<double> y;

    public:
    const std::vector<double> & get_x() const { return x; }
    std::vector<double> & get_mutable_x() { return x; }
    void set_x(const std::vector<double> & value) { this->x = value; }

    const std::vector<double> & get_y() const { return y; }
    std::vector<double> & get_mutable_y() { return y; }
    void set_y(const std::vector<double> & value) { this->y = value; }
};

class KK {
    public:
    KK() = default;
    virtual ~KK() = default;

    private:
    std::shared_ptr<I> i;
    std::shared_ptr<I> o;
    std::shared_ptr<std::vector<std::string>> n;
    int64_t t;
    std::shared_ptr<std::vector<int64_t>> s;
    std::shared_ptr<std::vector<double>> e;

    public:
    std::shared_ptr<I> get_i() const { return i; }
    void set_i(std::shared_ptr<I> value) { this->i = value; }

    std::shared_ptr<I> get_o() const { return o; }
    void set_o(std::shared_ptr<I> value) { this->o = value; }

    std::shared_ptr<std::vector<std::string>> get_n() const { return n; }
    void set_n(std::shared_ptr<std::vector<std::string>> value) { this->n = value; }

    const int64_t & get_t() const { return t; }
    int64_t & get_mutable_t() { return t; }
    void set_t(const int64_t & value) { this->t = value; }

    std::shared_ptr<std::vector<int64_t>> get_s() const { return s; }
    void set_s(std::shared_ptr<std::vector<int64_t>> value) { this->s = value; }

    std::shared_ptr<std::vector<double>> get_e() const { return e; }
    void set_e(std::shared_ptr<std::vector<double>> value) { this->e = value; }
};

using OK = boost::variant<std::vector<KK>, int64_t>;

class PurpleO {
    public:
    PurpleO() = default;
    virtual ~PurpleO() = default;

    private:
    int64_t a;
    OK k;

    public:
    const int64_t & get_a() const { return a; }
    int64_t & get_mutable_a() { return a; }
    void set_a(const int64_t & value) { this->a = value; }

    const OK & get_k() const { return k; }
    OK & get_mutable_k() { return k; }
    void set_k(const OK & value) { this->k = value; }
};

class PurpleKs {
    public:
    PurpleKs() = default;
    virtual ~PurpleKs() = default;

    private:
    PurpleO o;
    PurpleO r;
    CClass p;
    CClass a;
    CClass s;

    public:
    const PurpleO & get_o() const { return o; }
    PurpleO & get_mutable_o() { return o; }
    void set_o(const PurpleO & value) { this->o = value; }

    const PurpleO & get_r() const { return r; }
    PurpleO & get_mutable_r() { return r; }
    void set_r(const PurpleO & value) { this->r = value; }

    const CClass & get_p() const { return p; }
    CClass & get_mutable_p() { return p; }
    void set_p(const CClass & value) { this->p = value; }

    const CClass & get_a() const { return a; }
    CClass & get_mutable_a() { return a; }
    void set_a(const CClass & value) { this->a = value; }

    const CClass & get_s() const { return s; }
    CClass & get_mutable_s() { return s; }
    void set_s(const CClass & value) { this->s = value; }
};

using CK = boost::variant<KK, double>;

class C {
    public:
    C() = default;
    virtual ~C() = default;

    private:
    int64_t a;
    std::vector<CK> k;

    public:
    const int64_t & get_a() const { return a; }
    int64_t & get_mutable_a() { return a; }
    void set_a(const int64_t & value) { this->a = value; }

    const std::vector<CK> & get_k() const { return k; }
    std::vector<CK> & get_mutable_k() { return k; }
    void set_k(const std::vector<CK> & value) { this->k = value; }
};

class E {
    public:
    E() = default;
    virtual ~E() = default;

    private:
    int64_t a;
    OK k;
    int64_t ix;

    public:
    const int64_t & get_a() const { return a; }
    int64_t & get_mutable_a() { return a; }
    void set_a(const int64_t & value) { this->a = value; }

    const OK & get_k() const { return k; }
    OK & get_mutable_k() { return k; }
    void set_k(const OK & value) { this->k = value; }

    const int64_t & get_ix() const { return ix; }
    int64_t & get_mutable_ix() { return ix; }
    void set_ix(const int64_t & value) { this->ix = value; }
};

class PurpleA {
    public:
    PurpleA() = default;
    virtual ~PurpleA() = default;

    private:
    int64_t a;
    std::vector<double> k;
    int64_t ix;

    public:
    const int64_t & get_a() const { return a; }
    int64_t & get_mutable_a() { return a; }
    void set_a(const int64_t & value) { this->a = value; }

    const std::vector<double> & get_k() const { return k; }
    std::vector<double> & get_mutable_k() { return k; }
    void set_k(const std::vector<double> & value) { this->k = value; }

    const int64_t & get_ix() const { return ix; }
    int64_t & get_mutable_ix() { return ix; }
    void set_ix(const int64_t & value) { this->ix = value; }
};

class KsK {
    public:
    KsK() = default;
    virtual ~KsK() = default;

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

class ItKs {
    public:
    ItKs() = default;
    virtual ~ItKs() = default;

    private:
    int64_t a;
    KsK k;

    public:
    const int64_t & get_a() const { return a; }
    int64_t & get_mutable_a() { return a; }
    void set_a(const int64_t & value) { this->a = value; }

    const KsK & get_k() const { return k; }
    KsK & get_mutable_k() { return k; }
    void set_k(const KsK & value) { this->k = value; }
};

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

using R = boost::variant<SaClass, int64_t>;

class It {
    public:
    It() = default;
    virtual ~It() = default;

    private:
    std::shared_ptr<int64_t> ind;
    std::string ty;
    std::shared_ptr<ItKs> ks;
    std::string nm;
    std::shared_ptr<std::string> mn;
    std::shared_ptr<int64_t> mm;
    std::shared_ptr<CClass> c;
    std::shared_ptr<SaClass> o;
    std::shared_ptr<R> r;
    std::shared_ptr<PurpleA> p;
    std::shared_ptr<PurpleA> a;
    std::shared_ptr<PurpleA> s;
    std::shared_ptr<SaClass> sk;
    std::shared_ptr<SaClass> sa;

    public:
    std::shared_ptr<int64_t> get_ind() const { return ind; }
    void set_ind(std::shared_ptr<int64_t> value) { this->ind = value; }

    const std::string & get_ty() const { return ty; }
    std::string & get_mutable_ty() { return ty; }
    void set_ty(const std::string & value) { this->ty = value; }

    std::shared_ptr<ItKs> get_ks() const { return ks; }
    void set_ks(std::shared_ptr<ItKs> value) { this->ks = value; }

    const std::string & get_nm() const { return nm; }
    std::string & get_mutable_nm() { return nm; }
    void set_nm(const std::string & value) { this->nm = value; }

    std::shared_ptr<std::string> get_mn() const { return mn; }
    void set_mn(std::shared_ptr<std::string> value) { this->mn = value; }

    std::shared_ptr<int64_t> get_mm() const { return mm; }
    void set_mm(std::shared_ptr<int64_t> value) { this->mm = value; }

    std::shared_ptr<CClass> get_c() const { return c; }
    void set_c(std::shared_ptr<CClass> value) { this->c = value; }

    std::shared_ptr<SaClass> get_o() const { return o; }
    void set_o(std::shared_ptr<SaClass> value) { this->o = value; }

    std::shared_ptr<R> get_r() const { return r; }
    void set_r(std::shared_ptr<R> value) { this->r = value; }

    std::shared_ptr<PurpleA> get_p() const { return p; }
    void set_p(std::shared_ptr<PurpleA> value) { this->p = value; }

    std::shared_ptr<PurpleA> get_a() const { return a; }
    void set_a(std::shared_ptr<PurpleA> value) { this->a = value; }

    std::shared_ptr<PurpleA> get_s() const { return s; }
    void set_s(std::shared_ptr<PurpleA> value) { this->s = value; }

    std::shared_ptr<SaClass> get_sk() const { return sk; }
    void set_sk(std::shared_ptr<SaClass> value) { this->sk = value; }

    std::shared_ptr<SaClass> get_sa() const { return sa; }
    void set_sa(std::shared_ptr<SaClass> value) { this->sa = value; }
};

enum class Mn : int { ADBE_VECTOR_FILTER_TRIM, ADBE_VECTOR_GRAPHIC_STROKE, ADBE_VECTOR_GROUP, ADBE_VECTOR_SHAPE_GROUP };

enum class Nm : int { FLUFFY_1, NM_1, PURPLE_1, THE_1 };

enum class Ty : int { GR, SH, ST, TM };

class WClass {
    public:
    WClass() = default;
    virtual ~WClass() = default;

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

class Shape {
    public:
    Shape() = default;
    virtual ~Shape() = default;

    private:
    std::shared_ptr<int64_t> ind;
    Ty ty;
    std::shared_ptr<ItKs> ks;
    Nm nm;
    Mn mn;
    std::shared_ptr<E> s;
    std::shared_ptr<E> e;
    std::shared_ptr<SaClass> o;
    std::shared_ptr<int64_t> m;
    std::shared_ptr<int64_t> ix;
    std::shared_ptr<C> c;
    std::shared_ptr<WClass> w;
    std::shared_ptr<int64_t> lc;
    std::shared_ptr<int64_t> lj;
    std::shared_ptr<std::vector<It>> it;
    std::shared_ptr<int64_t> np;
    std::shared_ptr<int64_t> cix;
    std::shared_ptr<int64_t> ml;

    public:
    std::shared_ptr<int64_t> get_ind() const { return ind; }
    void set_ind(std::shared_ptr<int64_t> value) { this->ind = value; }

    const Ty & get_ty() const { return ty; }
    Ty & get_mutable_ty() { return ty; }
    void set_ty(const Ty & value) { this->ty = value; }

    std::shared_ptr<ItKs> get_ks() const { return ks; }
    void set_ks(std::shared_ptr<ItKs> value) { this->ks = value; }

    const Nm & get_nm() const { return nm; }
    Nm & get_mutable_nm() { return nm; }
    void set_nm(const Nm & value) { this->nm = value; }

    const Mn & get_mn() const { return mn; }
    Mn & get_mutable_mn() { return mn; }
    void set_mn(const Mn & value) { this->mn = value; }

    std::shared_ptr<E> get_s() const { return s; }
    void set_s(std::shared_ptr<E> value) { this->s = value; }

    std::shared_ptr<E> get_e() const { return e; }
    void set_e(std::shared_ptr<E> value) { this->e = value; }

    std::shared_ptr<SaClass> get_o() const { return o; }
    void set_o(std::shared_ptr<SaClass> value) { this->o = value; }

    std::shared_ptr<int64_t> get_m() const { return m; }
    void set_m(std::shared_ptr<int64_t> value) { this->m = value; }

    std::shared_ptr<int64_t> get_ix() const { return ix; }
    void set_ix(std::shared_ptr<int64_t> value) { this->ix = value; }

    std::shared_ptr<C> get_c() const { return c; }
    void set_c(std::shared_ptr<C> value) { this->c = value; }

    std::shared_ptr<WClass> get_w() const { return w; }
    void set_w(std::shared_ptr<WClass> value) { this->w = value; }

    std::shared_ptr<int64_t> get_lc() const { return lc; }
    void set_lc(std::shared_ptr<int64_t> value) { this->lc = value; }

    std::shared_ptr<int64_t> get_lj() const { return lj; }
    void set_lj(std::shared_ptr<int64_t> value) { this->lj = value; }

    std::shared_ptr<std::vector<It>> get_it() const { return it; }
    void set_it(std::shared_ptr<std::vector<It>> value) { this->it = value; }

    std::shared_ptr<int64_t> get_np() const { return np; }
    void set_np(std::shared_ptr<int64_t> value) { this->np = value; }

    std::shared_ptr<int64_t> get_cix() const { return cix; }
    void set_cix(std::shared_ptr<int64_t> value) { this->cix = value; }

    std::shared_ptr<int64_t> get_ml() const { return ml; }
    void set_ml(std::shared_ptr<int64_t> value) { this->ml = value; }
};

class AssetLayer {
    public:
    AssetLayer() = default;
    virtual ~AssetLayer() = default;

    private:
    int64_t ddd;
    int64_t ind;
    int64_t ty;
    std::string nm;
    PurpleKs ks;
    int64_t ao;
    std::vector<Shape> shapes;
    int64_t ip;
    int64_t op;
    int64_t st;
    int64_t bm;
    int64_t sr;

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

    const PurpleKs & get_ks() const { return ks; }
    PurpleKs & get_mutable_ks() { return ks; }
    void set_ks(const PurpleKs & value) { this->ks = value; }

    const int64_t & get_ao() const { return ao; }
    int64_t & get_mutable_ao() { return ao; }
    void set_ao(const int64_t & value) { this->ao = value; }

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

    const int64_t & get_sr() const { return sr; }
    int64_t & get_mutable_sr() { return sr; }
    void set_sr(const int64_t & value) { this->sr = value; }
};

class Asset {
    public:
    Asset() = default;
    virtual ~Asset() = default;

    private:
    std::string id;
    std::vector<AssetLayer> layers;

    public:
    const std::string & get_id() const { return id; }
    std::string & get_mutable_id() { return id; }
    void set_id(const std::string & value) { this->id = value; }

    const std::vector<AssetLayer> & get_layers() const { return layers; }
    std::vector<AssetLayer> & get_mutable_layers() { return layers; }
    void set_layers(const std::vector<AssetLayer> & value) { this->layers = value; }
};

class FluffyKs {
    public:
    FluffyKs() = default;
    virtual ~FluffyKs() = default;

    private:
    WClass o;
    WClass r;
    CClass p;
    CClass a;
    CClass s;

    public:
    const WClass & get_o() const { return o; }
    WClass & get_mutable_o() { return o; }
    void set_o(const WClass & value) { this->o = value; }

    const WClass & get_r() const { return r; }
    WClass & get_mutable_r() { return r; }
    void set_r(const WClass & value) { this->r = value; }

    const CClass & get_p() const { return p; }
    CClass & get_mutable_p() { return p; }
    void set_p(const CClass & value) { this->p = value; }

    const CClass & get_a() const { return a; }
    CClass & get_mutable_a() { return a; }
    void set_a(const CClass & value) { this->a = value; }

    const CClass & get_s() const { return s; }
    CClass & get_mutable_s() { return s; }
    void set_s(const CClass & value) { this->s = value; }
};

class Welcome4Layer {
    public:
    Welcome4Layer() = default;
    virtual ~Welcome4Layer() = default;

    private:
    int64_t ddd;
    int64_t ind;
    int64_t ty;
    std::string nm;
    std::string ref_id;
    FluffyKs ks;
    int64_t ao;
    int64_t w;
    int64_t h;
    int64_t ip;
    int64_t op;
    int64_t st;
    int64_t bm;
    int64_t sr;

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

    const std::string & get_ref_id() const { return ref_id; }
    std::string & get_mutable_ref_id() { return ref_id; }
    void set_ref_id(const std::string & value) { this->ref_id = value; }

    const FluffyKs & get_ks() const { return ks; }
    FluffyKs & get_mutable_ks() { return ks; }
    void set_ks(const FluffyKs & value) { this->ks = value; }

    const int64_t & get_ao() const { return ao; }
    int64_t & get_mutable_ao() { return ao; }
    void set_ao(const int64_t & value) { this->ao = value; }

    const int64_t & get_w() const { return w; }
    int64_t & get_mutable_w() { return w; }
    void set_w(const int64_t & value) { this->w = value; }

    const int64_t & get_h() const { return h; }
    int64_t & get_mutable_h() { return h; }
    void set_h(const int64_t & value) { this->h = value; }

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

    const int64_t & get_sr() const { return sr; }
    int64_t & get_mutable_sr() { return sr; }
    void set_sr(const int64_t & value) { this->sr = value; }
};

class Welcome4 {
    public:
    Welcome4() = default;
    virtual ~Welcome4() = default;

    private:
    std::string v;
    int64_t fr;
    int64_t ip;
    int64_t op;
    int64_t w;
    int64_t h;
    std::string nm;
    int64_t ddd;
    std::vector<Asset> assets;
    std::vector<Welcome4Layer> layers;

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

    const std::vector<Asset> & get_assets() const { return assets; }
    std::vector<Asset> & get_mutable_assets() { return assets; }
    void set_assets(const std::vector<Asset> & value) { this->assets = value; }

    const std::vector<Welcome4Layer> & get_layers() const { return layers; }
    std::vector<Welcome4Layer> & get_mutable_layers() { return layers; }
    void set_layers(const std::vector<Welcome4Layer> & value) { this->layers = value; }
};
