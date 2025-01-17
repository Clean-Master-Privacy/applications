package android.support.design.circularreveal;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.support.design.circularreveal.b;
import android.support.design.widget.j;
import android.util.Property;

public interface c extends b.a {
    void a(d dVar);

    void bc();

    void bd();

    d be();

    int getCircularRevealScrimColor();

    void i(Drawable drawable);

    void setCircularRevealScrimColor(int i);

    public static class d {
        public float centerX;
        public float centerY;
        public float radius;

        /* synthetic */ d(byte b2) {
            this();
        }

        private d() {
        }

        public d(float f, float f2, float f3) {
            this.centerX = f;
            this.centerY = f2;
            this.radius = f3;
        }

        public d(d dVar) {
            this(dVar.centerX, dVar.centerY, dVar.radius);
        }

        public final void a(float f, float f2, float f3) {
            this.centerX = f;
            this.centerY = f2;
            this.radius = f3;
        }

        public final boolean isInvalid() {
            return this.radius == Float.MAX_VALUE;
        }
    }

    public static class b extends Property<c, d> {
        public static final Property<c, d> hJ = new b("circularReveal");

        public final /* synthetic */ Object get(Object obj) {
            return ((c) obj).be();
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            ((c) obj).a((d) obj2);
        }

        private b(String str) {
            super(d.class, str);
        }
    }

    public static class a implements TypeEvaluator<d> {
        public static final TypeEvaluator<d> hI = new a();
        private final d hE = new d((byte) 0);

        public final /* synthetic */ Object evaluate(float f, Object obj, Object obj2) {
            d dVar = (d) obj;
            d dVar2 = (d) obj2;
            this.hE.a(j.lerp(dVar.centerX, dVar2.centerX, f), j.lerp(dVar.centerY, dVar2.centerY, f), j.lerp(dVar.radius, dVar2.radius, f));
            return this.hE;
        }
    }

    /* renamed from: android.support.design.circularreveal.c$c  reason: collision with other inner class name */
    public static class C0007c extends Property<c, Integer> {
        public static final Property<c, Integer> hK = new C0007c("circularRevealScrimColor");

        public final /* synthetic */ Object get(Object obj) {
            return Integer.valueOf(((c) obj).getCircularRevealScrimColor());
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            ((c) obj).setCircularRevealScrimColor(((Integer) obj2).intValue());
        }

        private C0007c(String str) {
            super(Integer.class, str);
        }
    }
}
