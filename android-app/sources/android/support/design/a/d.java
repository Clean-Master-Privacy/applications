package android.support.design.a;

import android.support.design.a;
import android.util.Property;
import android.view.ViewGroup;

public final class d extends Property<ViewGroup, Float> {
    public static final Property<ViewGroup, Float> eU = new d("childrenAlpha");

    public final /* synthetic */ Object get(Object obj) {
        Float f = (Float) ((ViewGroup) obj).getTag(a.f.ag);
        if (f != null) {
            return f;
        }
        return Float.valueOf(1.0f);
    }

    public final /* synthetic */ void set(Object obj, Object obj2) {
        ViewGroup viewGroup = (ViewGroup) obj;
        float floatValue = ((Float) obj2).floatValue();
        viewGroup.setTag(a.f.ag, Float.valueOf(floatValue));
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            viewGroup.getChildAt(i).setAlpha(floatValue);
        }
    }

    private d(String str) {
        super(Float.class, str);
    }
