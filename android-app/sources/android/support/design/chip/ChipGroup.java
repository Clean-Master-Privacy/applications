package android.support.design.chip;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.design.a;
import android.support.design.internal.FlowLayout;
import android.support.design.internal.f;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

public class ChipGroup extends FlowLayout {
    private int ho;
    private int hp;
    /* access modifiers changed from: private */
    public boolean hq;
    /* access modifiers changed from: private */
    public final a hr;
    private b hs;
    /* access modifiers changed from: private */
    public int ht;
    /* access modifiers changed from: private */
    public boolean hu;

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams() {
            super(-2, -2);
        }
    }

    public ChipGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.b.x);
    }

    public ChipGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hr = new a(this, (byte) 0);
        this.hs = new b(this, (byte) 0);
        this.ht = -1;
        this.hu = false;
        TypedArray a2 = f.a(context, attributeSet, a.k.ChipGroup, i, a.j.se, new int[0]);
        int dimensionPixelOffset = a2.getDimensionPixelOffset(a.k.ChipGroup_chipSpacing, 0);
        setChipSpacingHorizontal(a2.getDimensionPixelOffset(a.k.ChipGroup_chipSpacingHorizontal, dimensionPixelOffset));
        setChipSpacingVertical(a2.getDimensionPixelOffset(a.k.ChipGroup_chipSpacingVertical, dimensionPixelOffset));
        setSingleLine(a2.getBoolean(a.k.ChipGroup_singleLine, false));
        setSingleSelection(a2.getBoolean(a.k.ChipGroup_singleSelection, false));
        int resourceId = a2.getResourceId(a.k.ChipGroup_checkedChip, -1);
        if (resourceId != -1) {
            this.ht = resourceId;
        }
        a2.recycle();
        super.setOnHierarchyChangeListener(this.hs);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        ViewGroup.OnHierarchyChangeListener unused = this.hs.hw = onHierarchyChangeListener;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        if (this.ht != -1) {
            setCheckedStateForView(this.ht, true);
            setCheckedId(this.ht);
        }
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof Chip) {
            Chip chip = (Chip) view;
            if (chip.isChecked()) {
                if (this.ht != -1 && this.hq) {
                    setCheckedStateForView(this.ht, false);
                }
                setCheckedId(chip.getId());
            }
        }
        super.addView(view, i, layoutParams);
    }

    @Deprecated
    public void setShowDividerHorizontal(int i) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int i) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int i) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    public int getCheckedChipId() {
        if (this.hq) {
            return this.ht;
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public void setCheckedId(int i) {
        this.ht = i;
    }

    /* access modifiers changed from: private */
    public void setCheckedStateForView(int i, boolean z) {
        View findViewById = findViewById(i);
        if (findViewById instanceof Chip) {
            this.hu = true;
            ((Chip) findViewById).setChecked(z);
            this.hu = false;
        }
    }

    public void setChipSpacing(int i) {
        setChipSpacingHorizontal(i);
        setChipSpacingVertical(i);
    }

    public void setChipSpacingResource(int i) {
        setChipSpacing(getResources().getDimensionPixelOffset(i));
    }

    public int getChipSpacingHorizontal() {
        return this.ho;
    }

    public void setChipSpacingHorizontal(int i) {
        if (this.ho != i) {
            this.ho = i;
            setItemSpacing(i);
            requestLayout();
        }
    }

    public void setChipSpacingHorizontalResource(int i) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(i));
    }

    public int getChipSpacingVertical() {
        return this.hp;
    }

    public void setChipSpacingVertical(int i) {
        if (this.hp != i) {
            this.hp = i;
            setLineSpacing(i);
            requestLayout();
        }
    }

    public void setChipSpacingVerticalResource(int i) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(i));
    }

    public void setSingleLine(int i) {
        setSingleLine(getResources().getBoolean(i));
    }

    public void setSingleSelection(boolean z) {
        if (this.hq != z) {
            this.hq = z;
            this.hu = true;
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof Chip) {
                    ((Chip) childAt).setChecked(false);
                }
            }
            this.hu = false;
            setCheckedId(-1);
        }
    }

    public void setSingleSelection(int i) {
        setSingleSelection(getResources().getBoolean(i));
    }

    private class a implements CompoundButton.OnCheckedChangeListener {
        private a() {
        }

        /* synthetic */ a(ChipGroup chipGroup, byte b2) {
            this();
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (!ChipGroup.this.hu) {
                int id = compoundButton.getId();
                if (z) {
                    if (!(ChipGroup.this.ht == -1 || ChipGroup.this.ht == id || !ChipGroup.this.hq)) {
                        ChipGroup.this.setCheckedStateForView(ChipGroup.this.ht, false);
                    }
                    ChipGroup.this.setCheckedId(id);
                } else if (ChipGroup.this.ht == id) {
                    ChipGroup.this.setCheckedId(-1);
                }
            }
        }
    }

    private class b implements ViewGroup.OnHierarchyChangeListener {
        /* access modifiers changed from: private */
        public ViewGroup.OnHierarchyChangeListener hw;

        private b() {
        }

        /* synthetic */ b(ChipGroup chipGroup, byte b2) {
            this();
        }

        public final void onChildViewAdded(View view, View view2) {
            int i;
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                if (view2.getId() == -1) {
                    if (Build.VERSION.SDK_INT >= 17) {
                        i = View.generateViewId();
                    } else {
                        i = view2.hashCode();
                    }
                    view2.setId(i);
                }
                ((Chip) view2).ge = ChipGroup.this.hr;
            }
            if (this.hw != null) {
                this.hw.onChildViewAdded(view, view2);
            }
        }

        public final void onChildViewRemoved(View view, View view2) {
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                ((Chip) view2).ge = null;
            }
            if (this.hw != null) {
                this.hw.onChildViewRemoved(view, view2);
            }
        }
    }
}
