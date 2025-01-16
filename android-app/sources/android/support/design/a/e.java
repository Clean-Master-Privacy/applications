package android.support.design.a;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Property;
import java.util.WeakHashMap;

public final class e extends Property<Drawable, Integer> {
    public static final Property<Drawable, Integer> eV = new e();
    private final WeakHashMap<Drawable, Integer> eW = new WeakHashMap<>();

    public final /* synthetic */ Object get(Object obj) {
        Drawable drawable = (Drawable) obj;
        if (Build.VERSION.SDK_INT >= 19) {
            return Integer.valueOf(drawable.getAlpha());
        }
        if (this.eW.containsKey(drawable)) {
            return this.eW.get(drawable);
        }
        return 255;
    }

    public final /* synthetic */ void set(Object obj, Object obj2) {
        Drawable drawable = (Drawable) obj;
        Integer num = (Integer) obj2;
        if (Build.VERSION.SDK_INT < 19) {
            this.eW.put(drawable, num);
        }
        drawable.setAlpha(num.intValue());
    }

    private e() {
        super(Integer.class, "drawableAlphaCompat");
    }
}
