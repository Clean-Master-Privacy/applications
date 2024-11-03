#pragma once

#include <boost/variant.hpp>

#include <boost/optional.hpp>
#include <stdexcept>
#include <regex>

class A {
    public:
    A() = default;
    virtual ~A() = default;

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

class O {
    public:
    O() = default;
    virtual ~O() = default;

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

class R {
    public:
    R() = default;
    virtual ~R() = default;

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

using SK = boost::variant<KK, int64_t>;

class S {
    public:
    S() = default;
    virtual ~S() = default;

    private:
    int64_t a;
    std::vector<SK> k;

    public:
    const int64_t & get_a() const { return a; }
    int64_t & get_mutable_a() { return a; }
    void set_a(const int64_t & value) { this->a = value; }

    const std::vector<SK> & get_k() const { return k; }
    std::vector<SK> & get_mutable_k() { return k; }
    void set_k(const std::vector<SK> & value) { this->k = value; }
};

class LayerKs {
    public:
    LayerKs() = default;
    virtual ~LayerKs() = default;

    private:
    O o;
    R r;
    A p;
    A a;
    S s;

    public:
    const O & get_o() const { return o; }
    O & get_mutable_o() { return o; }
    void set_o(const O & value) { this->o = value; }

    const R & get_r() const { return r; }
    R & get_mutable_r() { return r; }
    void set_r(const R & value) { this->r = value; }

    const A & get_p() const { return p; }
    A & get_mutable_p() { return p; }
    void set_p(const A & value) { this->p = value; }

    const A & get_a() const { return a; }
    A & get_mutable_a() { return a; }
    void set_a(const A & value) { this->a = value; }

    const S & get_s() const { return s; }
    S & get_mutable_s() { return s; }
    void set_s(const S & value) { this->s = value; }
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

class ShapeKs {
    public:
    ShapeKs() = default;
    virtual ~ShapeKs() = default;

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

enum class Mn : int { ADBE_VECTOR_GRAPHIC_FILL, ADBE_VECTOR_GRAPHIC_STROKE, ADBE_VECTOR_SHAPE_GROUP };

enum class Ty : int { FL, SH, ST };

class W {
    public:
    W() = default;
    virtual ~W() = default;

    private:
    int64_t a;
    std::vector<KK> k;

    public:
    const int64_t & get_a() const { return a; }
    int64_t & get_mutable_a() { return a; }
    void set_a(const int64_t & value) { this->a = value; }

    const std::vector<KK> & get_k() const { return k; }
    std::vector<KK> & get_mutable_k() { return k; }
    void set_k(const std::vector<KK> & value) { this->k = value; }
};

class Shape {
    public:
    Shape() = default;
    virtual ~Shape() = default;

    private:
    std::shared_ptr<int64_t> ind;
    Ty ty;
    std::shared_ptr<int64_t> ix;
    std::shared_ptr<ShapeKs> ks;
    std::string nm;
    Mn mn;
    std::shared_ptr<A> c;
    std::shared_ptr<R> o;
    std::shared_ptr<int64_t> r;
    std::shared_ptr<W> w;
    std::shared_ptr<int64_t> lc;
    std::shared_ptr<int64_t> lj;

    public:
    std::shared_ptr<int64_t> get_ind() const { return ind; }
    void set_ind(std::shared_ptr<int64_t> value) { this->ind = value; }

    const Ty & get_ty() const { return ty; }
    Ty & get_mutable_ty() { return ty; }
    void set_ty(const Ty & value) { this->ty = value; }

    std::shared_ptr<int64_t> get_ix() const { return ix; }
    void set_ix(std::shared_ptr<int64_t> value) { this->ix = value; }

    std::shared_ptr<ShapeKs> get_ks() const { return ks; }
    void set_ks(std::shared_ptr<ShapeKs> value) { this->ks = value; }

    const std::string & get_nm() const { return nm; }
    std::string & get_mutable_nm() { return nm; }
    void set_nm(const std::string & value) { this->nm = value; }

    const Mn & get_mn() const { return mn; }
    Mn & get_mutable_mn() { return mn; }
    void set_mn(const Mn & value) { this->mn = value; }

    std::shared_ptr<A> get_c() const { return c; }
    void set_c(std::shared_ptr<A> value) { this->c = value; }

    std::shared_ptr<R> get_o() const { return o; }
    void set_o(std::shared_ptr<R> value) { this->o = value; }

    std::shared_ptr<int64_t> get_r() const { return r; }
    void set_r(std::shared_ptr<int64_t> value) { this->r = value; }

    std::shared_ptr<W> get_w() const { return w; }
    void set_w(std::shared_ptr<W> value) { this->w = value; }

    std::shared_ptr<int64_t> get_lc() const { return lc; }
    void set_lc(std::shared_ptr<int64_t> value) { this->lc = value; }

    std::shared_ptr<int64_t> get_lj() const { return lj; }
    void set_lj(std::shared_ptr<int64_t> value) { this->lj = value; }
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

    const LayerKs & get_ks() const { return ks; }
    LayerKs & get_mutable_ks() { return ks; }
    void set_ks(const LayerKs & value) { this->ks = value; }

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

class Welcome2 {
    public:
    Welcome2() = default;
    virtual ~Welcome2() = default;

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
