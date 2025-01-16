package android.support.constraint;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.support.constraint.a;
import android.support.constraint.b;
import android.support.constraint.solver.widgets.ConstraintWidget;
import android.support.constraint.solver.widgets.a;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParserException;

public class ConstraintLayout extends ViewGroup {
    private SparseArray<View> aX = new SparseArray<>();
    private final ArrayList<ConstraintWidget> aY = new ArrayList<>(100);
    private a aZ = new a();
    private boolean ba = true;
    private int bb = 2;
    private a bc = null;
    private int mMaxHeight = Integer.MAX_VALUE;
    private int mMaxWidth = Integer.MAX_VALUE;
    private int mMinHeight = 0;
    private int mMinWidth = 0;

    public ConstraintLayout(Context context) {
        super(context);
        init((AttributeSet) null);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet);
    }

    public void setId(int i) {
        this.aX.remove(getId());
        super.setId(i);
        this.aX.put(getId(), this);
    }

    private void init(AttributeSet attributeSet) {
        this.aZ.ec = this;
        this.aX.put(getId(), this);
        this.bc = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, b.a.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == b.a.ConstraintLayout_Layout_android_minWidth) {
                    this.mMinWidth = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMinWidth);
                } else if (index == b.a.ConstraintLayout_Layout_android_minHeight) {
                    this.mMinHeight = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMinHeight);
                } else if (index == b.a.ConstraintLayout_Layout_android_maxWidth) {
                    this.mMaxWidth = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxWidth);
                } else if (index == b.a.ConstraintLayout_Layout_android_maxHeight) {
                    this.mMaxHeight = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxHeight);
                } else if (index == b.a.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.bb = obtainStyledAttributes.getInt(index, this.bb);
                } else if (index == b.a.ConstraintLayout_Layout_constraintSet) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    this.bc = new a();
                    a aVar = this.bc;
                    Context context = getContext();
                    XmlResourceParser xml = context.getResources().getXml(resourceId);
                    try {
                        for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                            if (eventType == 0) {
                                xml.getName();
                            } else if (eventType == 2) {
                                String name = xml.getName();
                                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                                a.C0004a aVar2 = new a.C0004a((byte) 0);
                                TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(asAttributeSet, b.a.ConstraintSet);
                                a.a(aVar2, obtainStyledAttributes2);
                                obtainStyledAttributes2.recycle();
                                if (name.equalsIgnoreCase("Guideline")) {
                                    aVar2.ce = true;
                                }
                                aVar.cc.put(Integer.valueOf(aVar2.cf), aVar2);
                            }
                        }
                    } catch (XmlPullParserException e2) {
                        e2.printStackTrace();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.aZ.bb = this.bb;
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (Build.VERSION.SDK_INT < 14) {
            onViewAdded(view);
        }
    }

    public void removeView(View view) {
        super.removeView(view);
        if (Build.VERSION.SDK_INT < 14) {
            onViewRemoved(view);
        }
    }

    public void onViewAdded(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onViewAdded(view);
        }
        ConstraintWidget b2 = b(view);
        if ((view instanceof Guideline) && !(b2 instanceof android.support.constraint.solver.widgets.b)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.ca = new android.support.constraint.solver.widgets.b();
            layoutParams.bS = true;
            ((android.support.constraint.solver.widgets.b) layoutParams.ca).setOrientation(layoutParams.orientation);
        }
        this.aX.put(view.getId(), view);
        this.ba = true;
    }

    public void onViewRemoved(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onViewRemoved(view);
        }
        this.aX.remove(view.getId());
        this.aZ.b(b(view));
        this.ba = true;
    }

    public void setMinWidth(int i) {
        if (i != this.mMinWidth) {
            this.mMinWidth = i;
            requestLayout();
        }
    }

    public void setMinHeight(int i) {
        if (i != this.mMinHeight) {
            this.mMinHeight = i;
            requestLayout();
        }
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public void setMaxWidth(int i) {
        if (i != this.mMaxWidth) {
            this.mMaxWidth = i;
            requestLayout();
        }
    }

    public void setMaxHeight(int i) {
        if (i != this.mMaxHeight) {
            this.mMaxHeight = i;
            requestLayout();
        }
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    private final ConstraintWidget h(int i) {
        if (i == 0) {
            return this.aZ;
        }
        View view = this.aX.get(i);
        if (view == this) {
            return this.aZ;
        }
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).ca;
    }

    private final ConstraintWidget b(View view) {
        if (view == this) {
            return this.aZ;
        }
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).ca;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x03ab, code lost:
        if (r9.bH != 1) goto L_0x03af;
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0194  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x01a7 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x01c0  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x01d7  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x01f7  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x020e  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x022e  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x02b7  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x02e0  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x02ee  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x0318  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x0327  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x03c7  */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x03ff  */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x040a  */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x040e  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0138  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r32, int r33) {
        /*
            r31 = this;
            r0 = r31
            r1 = r32
            r2 = r33
            int r3 = r31.getPaddingLeft()
            int r4 = r31.getPaddingTop()
            android.support.constraint.solver.widgets.a r5 = r0.aZ
            r5.setX(r3)
            android.support.constraint.solver.widgets.a r5 = r0.aZ
            r5.setY(r4)
            r31.setSelfDimensionBehaviour(r32, r33)
            boolean r5 = r0.ba
            r6 = 0
            r8 = -1
            if (r5 == 0) goto L_0x0364
            r0.ba = r6
            int r5 = r31.getChildCount()
            r9 = r6
        L_0x0028:
            if (r9 >= r5) goto L_0x0039
            android.view.View r10 = r0.getChildAt(r9)
            boolean r10 = r10.isLayoutRequested()
            if (r10 == 0) goto L_0x0036
            r5 = 1
            goto L_0x003a
        L_0x0036:
            int r9 = r9 + 1
            goto L_0x0028
        L_0x0039:
            r5 = r6
        L_0x003a:
            if (r5 == 0) goto L_0x0364
            java.util.ArrayList<android.support.constraint.solver.widgets.ConstraintWidget> r5 = r0.aY
            r5.clear()
            android.support.constraint.a r5 = r0.bc
            if (r5 == 0) goto L_0x004a
            android.support.constraint.a r5 = r0.bc
            r5.a(r0)
        L_0x004a:
            int r5 = r31.getChildCount()
            android.support.constraint.solver.widgets.a r9 = r0.aZ
            r9.av()
            r9 = r6
        L_0x0054:
            if (r9 >= r5) goto L_0x0364
            android.view.View r10 = r0.getChildAt(r9)
            android.support.constraint.solver.widgets.ConstraintWidget r15 = r0.b(r10)
            if (r15 == 0) goto L_0x0355
            android.view.ViewGroup$LayoutParams r11 = r10.getLayoutParams()
            r14 = r11
            android.support.constraint.ConstraintLayout$LayoutParams r14 = (android.support.constraint.ConstraintLayout.LayoutParams) r14
            r15.reset()
            int r11 = r10.getVisibility()
            r15.mVisibility = r11
            r15.ec = r10
            android.support.constraint.solver.widgets.a r10 = r0.aZ
            r10.a((android.support.constraint.solver.widgets.ConstraintWidget) r15)
            boolean r10 = r14.bQ
            if (r10 == 0) goto L_0x007f
            boolean r10 = r14.bP
            if (r10 != 0) goto L_0x0084
        L_0x007f:
            java.util.ArrayList<android.support.constraint.solver.widgets.ConstraintWidget> r10 = r0.aY
            r10.add(r15)
        L_0x0084:
            boolean r10 = r14.bS
            if (r10 == 0) goto L_0x00bc
            android.support.constraint.solver.widgets.b r15 = (android.support.constraint.solver.widgets.b) r15
            int r10 = r14.bd
            r11 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r10 == r8) goto L_0x009a
            int r10 = r14.bd
            if (r10 < 0) goto L_0x009a
            r15.eH = r11
            r15.eI = r10
            r15.eJ = r8
        L_0x009a:
            int r10 = r14.be
            if (r10 == r8) goto L_0x00a8
            int r10 = r14.be
            if (r10 < 0) goto L_0x00a8
            r15.eH = r11
            r15.eI = r8
            r15.eJ = r10
        L_0x00a8:
            float r10 = r14.bf
            int r10 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r10 == 0) goto L_0x0355
            float r10 = r14.bf
            int r11 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r11 <= 0) goto L_0x0355
            r15.eH = r10
            r15.eI = r8
            r15.eJ = r8
            goto L_0x0355
        L_0x00bc:
            int r10 = r14.bT
            if (r10 != r8) goto L_0x00f0
            int r10 = r14.bU
            if (r10 != r8) goto L_0x00f0
            int r10 = r14.bV
            if (r10 != r8) goto L_0x00f0
            int r10 = r14.bW
            if (r10 != r8) goto L_0x00f0
            int r10 = r14.bl
            if (r10 != r8) goto L_0x00f0
            int r10 = r14.bm
            if (r10 != r8) goto L_0x00f0
            int r10 = r14.bn
            if (r10 != r8) goto L_0x00f0
            int r10 = r14.bo
            if (r10 != r8) goto L_0x00f0
            int r10 = r14.bq
            if (r10 != r8) goto L_0x00f0
            int r10 = r14.bN
            if (r10 != r8) goto L_0x00f0
            int r10 = r14.bO
            if (r10 != r8) goto L_0x00f0
            int r10 = r14.width
            if (r10 == r8) goto L_0x00f0
            int r10 = r14.height
            if (r10 != r8) goto L_0x0355
        L_0x00f0:
            int r10 = r14.bT
            int r11 = r14.bU
            int r12 = r14.bV
            int r13 = r14.bW
            int r6 = r14.bX
            int r7 = r14.bY
            float r8 = r14.bZ
            r17 = r5
            int r5 = android.os.Build.VERSION.SDK_INT
            r18 = r6
            r6 = 17
            if (r5 >= r6) goto L_0x0149
            int r5 = r14.bh
            int r6 = r14.bi
            int r12 = r14.bj
            int r13 = r14.bk
            int r7 = r14.bv
            int r8 = r14.bx
            float r10 = r14.bB
            r11 = -1
            if (r5 != r11) goto L_0x0123
            if (r6 != r11) goto L_0x0123
            r19 = r5
            int r5 = r14.bs
            if (r5 == r11) goto L_0x0126
            int r5 = r14.bs
        L_0x0123:
            r19 = r5
            goto L_0x012d
        L_0x0126:
            int r5 = r14.br
            if (r5 == r11) goto L_0x012d
            int r5 = r14.br
            r6 = r5
        L_0x012d:
            if (r12 != r11) goto L_0x013e
            if (r13 != r11) goto L_0x013e
            int r5 = r14.bt
            if (r5 == r11) goto L_0x0138
            int r12 = r14.bt
            goto L_0x013e
        L_0x0138:
            int r5 = r14.bu
            if (r5 == r11) goto L_0x013e
            int r13 = r14.bu
        L_0x013e:
            r16 = r7
            r18 = r8
            r5 = r11
            r7 = r12
            r8 = r13
            r13 = r10
            r10 = r19
            goto L_0x0155
        L_0x0149:
            r5 = -1
            r6 = r11
            r16 = r18
            r18 = r7
            r7 = r12
            r30 = r13
            r13 = r8
            r8 = r30
        L_0x0155:
            if (r10 == r5) goto L_0x0178
            android.support.constraint.solver.widgets.ConstraintWidget r5 = r0.h(r10)
            if (r5 == 0) goto L_0x0170
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r12 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.LEFT
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r6 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.LEFT
            int r10 = r14.leftMargin
            r11 = r15
            r20 = r3
            r3 = r13
            r13 = r5
            r5 = r14
            r14 = r6
            r6 = r15
            r15 = r10
            r11.a(r12, r13, r14, r15, r16)
            goto L_0x0175
        L_0x0170:
            r20 = r3
            r3 = r13
            r5 = r14
            r6 = r15
        L_0x0175:
            r10 = r6
        L_0x0176:
            r6 = -1
            goto L_0x0192
        L_0x0178:
            r20 = r3
            r11 = r5
            r3 = r13
            r5 = r14
            r10 = r15
            if (r6 == r11) goto L_0x0191
            android.support.constraint.solver.widgets.ConstraintWidget r13 = r0.h(r6)
            if (r13 == 0) goto L_0x0176
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r12 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.LEFT
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r14 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.RIGHT
            int r15 = r5.leftMargin
            r11 = r10
            r11.a(r12, r13, r14, r15, r16)
            goto L_0x0176
        L_0x0191:
            r6 = r11
        L_0x0192:
            if (r7 == r6) goto L_0x01a7
            android.support.constraint.solver.widgets.ConstraintWidget r13 = r0.h(r7)
            if (r13 == 0) goto L_0x01bb
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r12 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.RIGHT
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r14 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.LEFT
            int r15 = r5.rightMargin
            r11 = r10
            r16 = r18
            r11.a(r12, r13, r14, r15, r16)
            goto L_0x01bb
        L_0x01a7:
            if (r8 == r6) goto L_0x01bb
            android.support.constraint.solver.widgets.ConstraintWidget r13 = r0.h(r8)
            if (r13 == 0) goto L_0x01bb
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r12 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.RIGHT
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r14 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.RIGHT
            int r15 = r5.rightMargin
            r11 = r10
            r16 = r18
            r11.a(r12, r13, r14, r15, r16)
        L_0x01bb:
            int r6 = r5.bl
            r7 = -1
            if (r6 == r7) goto L_0x01d7
            int r6 = r5.bl
            android.support.constraint.solver.widgets.ConstraintWidget r13 = r0.h(r6)
            if (r13 == 0) goto L_0x01f2
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r12 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.TOP
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r14 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.TOP
            int r15 = r5.topMargin
            int r6 = r5.bw
            r11 = r10
            r16 = r6
            r11.a(r12, r13, r14, r15, r16)
            goto L_0x01f2
        L_0x01d7:
            int r6 = r5.bm
            r7 = -1
            if (r6 == r7) goto L_0x01f2
            int r6 = r5.bm
            android.support.constraint.solver.widgets.ConstraintWidget r13 = r0.h(r6)
            if (r13 == 0) goto L_0x01f2
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r12 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.TOP
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r14 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.BOTTOM
            int r15 = r5.topMargin
            int r6 = r5.bw
            r11 = r10
            r16 = r6
            r11.a(r12, r13, r14, r15, r16)
        L_0x01f2:
            int r6 = r5.bn
            r7 = -1
            if (r6 == r7) goto L_0x020e
            int r6 = r5.bn
            android.support.constraint.solver.widgets.ConstraintWidget r13 = r0.h(r6)
            if (r13 == 0) goto L_0x0229
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r12 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.BOTTOM
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r14 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.TOP
            int r15 = r5.bottomMargin
            int r6 = r5.by
            r11 = r10
            r16 = r6
            r11.a(r12, r13, r14, r15, r16)
            goto L_0x0229
        L_0x020e:
            int r6 = r5.bo
            r7 = -1
            if (r6 == r7) goto L_0x0229
            int r6 = r5.bo
            android.support.constraint.solver.widgets.ConstraintWidget r13 = r0.h(r6)
            if (r13 == 0) goto L_0x0229
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r12 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.BOTTOM
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r14 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.BOTTOM
            int r15 = r5.bottomMargin
            int r6 = r5.by
            r11 = r10
            r16 = r6
            r11.a(r12, r13, r14, r15, r16)
        L_0x0229:
            int r6 = r5.bq
            r7 = -1
            if (r6 == r7) goto L_0x0280
            android.util.SparseArray<android.view.View> r6 = r0.aX
            int r7 = r5.bq
            java.lang.Object r6 = r6.get(r7)
            android.view.View r6 = (android.view.View) r6
            int r7 = r5.bq
            android.support.constraint.solver.widgets.ConstraintWidget r7 = r0.h(r7)
            if (r7 == 0) goto L_0x0280
            if (r6 == 0) goto L_0x0280
            android.view.ViewGroup$LayoutParams r8 = r6.getLayoutParams()
            boolean r8 = r8 instanceof android.support.constraint.ConstraintLayout.LayoutParams
            if (r8 == 0) goto L_0x0280
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            android.support.constraint.ConstraintLayout$LayoutParams r6 = (android.support.constraint.ConstraintLayout.LayoutParams) r6
            r8 = 1
            r5.bR = r8
            r6.bR = r8
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r6 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.BASELINE
            android.support.constraint.solver.widgets.ConstraintAnchor r21 = r10.a((android.support.constraint.solver.widgets.ConstraintAnchor.Type) r6)
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r6 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.BASELINE
            android.support.constraint.solver.widgets.ConstraintAnchor r22 = r7.a((android.support.constraint.solver.widgets.ConstraintAnchor.Type) r6)
            r23 = 0
            r24 = -1
            android.support.constraint.solver.widgets.ConstraintAnchor$Strength r25 = android.support.constraint.solver.widgets.ConstraintAnchor.Strength.STRONG
            r26 = 0
            r27 = 1
            r21.a(r22, r23, r24, r25, r26, r27)
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r6 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.TOP
            android.support.constraint.solver.widgets.ConstraintAnchor r6 = r10.a((android.support.constraint.solver.widgets.ConstraintAnchor.Type) r6)
            r6.reset()
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r6 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.BOTTOM
            android.support.constraint.solver.widgets.ConstraintAnchor r6 = r10.a((android.support.constraint.solver.widgets.ConstraintAnchor.Type) r6)
            r6.reset()
        L_0x0280:
            r6 = 0
            int r7 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            r8 = 1056964608(0x3f000000, float:0.5)
            if (r7 < 0) goto L_0x028d
            int r7 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r7 == 0) goto L_0x028d
            r10.dX = r3
        L_0x028d:
            float r3 = r5.bC
            int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r3 < 0) goto L_0x029d
            float r3 = r5.bC
            int r3 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r3 == 0) goto L_0x029d
            float r3 = r5.bC
            r10.dY = r3
        L_0x029d:
            boolean r3 = r31.isInEditMode()
            if (r3 == 0) goto L_0x02b3
            int r3 = r5.bN
            r6 = -1
            if (r3 != r6) goto L_0x02ac
            int r3 = r5.bO
            if (r3 == r6) goto L_0x02b3
        L_0x02ac:
            int r3 = r5.bN
            int r6 = r5.bO
            r10.c(r3, r6)
        L_0x02b3:
            boolean r3 = r5.bP
            if (r3 != 0) goto L_0x02e0
            int r3 = r5.width
            r6 = -1
            if (r3 != r6) goto L_0x02d6
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            r10.a((android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour) r3)
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r3 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.LEFT
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.a((android.support.constraint.solver.widgets.ConstraintAnchor.Type) r3)
            int r6 = r5.leftMargin
            r3.mMargin = r6
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r3 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.RIGHT
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.a((android.support.constraint.solver.widgets.ConstraintAnchor.Type) r3)
            int r6 = r5.rightMargin
            r3.mMargin = r6
            goto L_0x02ea
        L_0x02d6:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            r10.a((android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour) r3)
            r3 = 0
            r10.setWidth(r3)
            goto L_0x02ea
        L_0x02e0:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r10.a((android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour) r3)
            int r3 = r5.width
            r10.setWidth(r3)
        L_0x02ea:
            boolean r3 = r5.bQ
            if (r3 != 0) goto L_0x0318
            int r3 = r5.height
            r6 = -1
            if (r3 != r6) goto L_0x030e
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            r10.b((android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour) r3)
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r3 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.TOP
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.a((android.support.constraint.solver.widgets.ConstraintAnchor.Type) r3)
            int r6 = r5.topMargin
            r3.mMargin = r6
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r3 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.BOTTOM
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.a((android.support.constraint.solver.widgets.ConstraintAnchor.Type) r3)
            int r6 = r5.bottomMargin
            r3.mMargin = r6
            r3 = 0
            goto L_0x0323
        L_0x030e:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            r10.b((android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour) r3)
            r3 = 0
            r10.setHeight(r3)
            goto L_0x0323
        L_0x0318:
            r3 = 0
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r6 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r10.b((android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour) r6)
            int r6 = r5.height
            r10.setHeight(r6)
        L_0x0323:
            java.lang.String r6 = r5.bD
            if (r6 == 0) goto L_0x032c
            java.lang.String r6 = r5.bD
            r10.m(r6)
        L_0x032c:
            float r6 = r5.horizontalWeight
            r10.er = r6
            float r6 = r5.verticalWeight
            r10.es = r6
            int r6 = r5.bF
            r10.en = r6
            int r6 = r5.bG
            r10.eo = r6
            int r6 = r5.bH
            int r7 = r5.bJ
            int r8 = r5.bL
            r10.dv = r6
            r10.dx = r7
            r10.dy = r8
            int r6 = r5.bI
            int r7 = r5.bK
            int r5 = r5.bM
            r10.dw = r6
            r10.dz = r7
            r10.dA = r5
            goto L_0x035a
        L_0x0355:
            r20 = r3
            r17 = r5
            r3 = r6
        L_0x035a:
            int r9 = r9 + 1
            r6 = r3
            r5 = r17
            r3 = r20
            r8 = -1
            goto L_0x0054
        L_0x0364:
            r20 = r3
            r3 = r6
            int r5 = r31.getPaddingTop()
            int r6 = r31.getPaddingBottom()
            int r5 = r5 + r6
            int r6 = r31.getPaddingLeft()
            int r7 = r31.getPaddingRight()
            int r6 = r6 + r7
            int r7 = r31.getChildCount()
            r8 = r3
        L_0x037e:
            r9 = 8
            if (r8 >= r7) goto L_0x0424
            android.view.View r11 = r0.getChildAt(r8)
            int r12 = r11.getVisibility()
            if (r12 == r9) goto L_0x041e
            android.view.ViewGroup$LayoutParams r9 = r11.getLayoutParams()
            android.support.constraint.ConstraintLayout$LayoutParams r9 = (android.support.constraint.ConstraintLayout.LayoutParams) r9
            android.support.constraint.solver.widgets.ConstraintWidget r12 = r9.ca
            boolean r13 = r9.bS
            if (r13 != 0) goto L_0x041e
            int r13 = r9.width
            int r14 = r9.height
            boolean r15 = r9.bP
            if (r15 != 0) goto L_0x03c3
            boolean r15 = r9.bQ
            if (r15 != 0) goto L_0x03c3
            boolean r15 = r9.bP
            if (r15 != 0) goto L_0x03ae
            int r15 = r9.bH
            r3 = 1
            if (r15 == r3) goto L_0x03c4
            goto L_0x03af
        L_0x03ae:
            r3 = 1
        L_0x03af:
            int r15 = r9.width
            r10 = -1
            if (r15 == r10) goto L_0x03c4
            boolean r15 = r9.bQ
            if (r15 != 0) goto L_0x03c1
            int r15 = r9.bI
            if (r15 == r3) goto L_0x03c4
            int r15 = r9.height
            if (r15 != r10) goto L_0x03c1
            goto L_0x03c4
        L_0x03c1:
            r10 = 0
            goto L_0x03c5
        L_0x03c3:
            r3 = 1
        L_0x03c4:
            r10 = r3
        L_0x03c5:
            if (r10 == 0) goto L_0x03ff
            if (r13 == 0) goto L_0x03d6
            r10 = -1
            if (r13 != r10) goto L_0x03cd
            goto L_0x03d7
        L_0x03cd:
            int r13 = getChildMeasureSpec(r1, r6, r13)
            r15 = r13
            r13 = -2
            r16 = 0
            goto L_0x03de
        L_0x03d6:
            r10 = -1
        L_0x03d7:
            r13 = -2
            int r15 = getChildMeasureSpec(r1, r6, r13)
            r16 = r3
        L_0x03de:
            if (r14 == 0) goto L_0x03e9
            if (r14 != r10) goto L_0x03e3
            goto L_0x03e9
        L_0x03e3:
            int r10 = getChildMeasureSpec(r2, r5, r14)
            r13 = 0
            goto L_0x03ee
        L_0x03e9:
            int r10 = getChildMeasureSpec(r2, r5, r13)
            r13 = r3
        L_0x03ee:
            r11.measure(r15, r10)
            int r10 = r11.getMeasuredWidth()
            int r14 = r11.getMeasuredHeight()
            r30 = r13
            r13 = r10
            r10 = r30
            goto L_0x0402
        L_0x03ff:
            r10 = 0
            r16 = 0
        L_0x0402:
            r12.setWidth(r13)
            r12.setHeight(r14)
            if (r16 == 0) goto L_0x040c
            r12.dU = r13
        L_0x040c:
            if (r10 == 0) goto L_0x0410
            r12.dV = r14
        L_0x0410:
            boolean r9 = r9.bR
            if (r9 == 0) goto L_0x041f
            int r9 = r11.getBaseline()
            r10 = -1
            if (r9 == r10) goto L_0x041f
            r12.dT = r9
            goto L_0x041f
        L_0x041e:
            r3 = 1
        L_0x041f:
            int r8 = r8 + 1
            r3 = 0
            goto L_0x037e
        L_0x0424:
            r3 = 1
            int r5 = r31.getChildCount()
            if (r5 <= 0) goto L_0x0430
            android.support.constraint.solver.widgets.a r5 = r0.aZ
            r5.ar()
        L_0x0430:
            java.util.ArrayList<android.support.constraint.solver.widgets.ConstraintWidget> r5 = r0.aY
            int r5 = r5.size()
            int r6 = r31.getPaddingBottom()
            int r4 = r4 + r6
            int r6 = r31.getPaddingRight()
            int r6 = r20 + r6
            if (r5 <= 0) goto L_0x055c
            android.support.constraint.solver.widgets.a r8 = r0.aZ
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = r8.dZ
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r10 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r8 != r10) goto L_0x044d
            r8 = r3
            goto L_0x044e
        L_0x044d:
            r8 = 0
        L_0x044e:
            android.support.constraint.solver.widgets.a r10 = r0.aZ
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r10 = r10.eb
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r11 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r10 != r11) goto L_0x0458
            r10 = r3
            goto L_0x0459
        L_0x0458:
            r10 = 0
        L_0x0459:
            r11 = 0
            r12 = 0
            r28 = 0
        L_0x045d:
            if (r11 >= r5) goto L_0x0554
            java.util.ArrayList<android.support.constraint.solver.widgets.ConstraintWidget> r13 = r0.aY
            java.lang.Object r13 = r13.get(r11)
            android.support.constraint.solver.widgets.ConstraintWidget r13 = (android.support.constraint.solver.widgets.ConstraintWidget) r13
            boolean r14 = r13 instanceof android.support.constraint.solver.widgets.b
            if (r14 != 0) goto L_0x0548
            java.lang.Object r14 = r13.ec
            android.view.View r14 = (android.view.View) r14
            if (r14 == 0) goto L_0x0548
            int r15 = r14.getVisibility()
            if (r15 == r9) goto L_0x0548
            android.view.ViewGroup$LayoutParams r15 = r14.getLayoutParams()
            android.support.constraint.ConstraintLayout$LayoutParams r15 = (android.support.constraint.ConstraintLayout.LayoutParams) r15
            int r3 = r15.width
            r9 = 1073741824(0x40000000, float:2.0)
            r7 = -2
            if (r3 != r7) goto L_0x048b
            int r3 = r15.width
            int r3 = getChildMeasureSpec(r1, r6, r3)
            goto L_0x0493
        L_0x048b:
            int r3 = r13.getWidth()
            int r3 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r9)
        L_0x0493:
            int r9 = r15.height
            if (r9 != r7) goto L_0x049e
            int r9 = r15.height
            int r9 = getChildMeasureSpec(r2, r4, r9)
            goto L_0x04a8
        L_0x049e:
            int r9 = r13.getHeight()
            r7 = 1073741824(0x40000000, float:2.0)
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r7)
        L_0x04a8:
            r14.measure(r3, r9)
            int r3 = r14.getMeasuredWidth()
            int r7 = r14.getMeasuredHeight()
            int r9 = r13.getWidth()
            if (r3 == r9) goto L_0x04ec
            r13.setWidth(r3)
            if (r8 == 0) goto L_0x04e7
            int r3 = r13.getRight()
            android.support.constraint.solver.widgets.a r9 = r0.aZ
            int r9 = r9.getWidth()
            if (r3 <= r9) goto L_0x04e7
            int r3 = r13.getRight()
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r9 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.RIGHT
            android.support.constraint.solver.widgets.ConstraintAnchor r9 = r13.a((android.support.constraint.solver.widgets.ConstraintAnchor.Type) r9)
            int r9 = r9.ad()
            int r3 = r3 + r9
            android.support.constraint.solver.widgets.a r9 = r0.aZ
            r29 = r5
            int r5 = r0.mMinWidth
            int r3 = java.lang.Math.max(r5, r3)
            r9.setWidth(r3)
            goto L_0x04e9
        L_0x04e7:
            r29 = r5
        L_0x04e9:
            r28 = 1
            goto L_0x04ee
        L_0x04ec:
            r29 = r5
        L_0x04ee:
            int r3 = r13.getHeight()
            if (r7 == r3) goto L_0x0521
            r13.setHeight(r7)
            if (r10 == 0) goto L_0x051f
            int r3 = r13.getBottom()
            android.support.constraint.solver.widgets.a r5 = r0.aZ
            int r5 = r5.getHeight()
            if (r3 <= r5) goto L_0x051f
            int r3 = r13.getBottom()
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r5 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.BOTTOM
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r13.a((android.support.constraint.solver.widgets.ConstraintAnchor.Type) r5)
            int r5 = r5.ad()
            int r3 = r3 + r5
            android.support.constraint.solver.widgets.a r5 = r0.aZ
            int r7 = r0.mMinHeight
            int r3 = java.lang.Math.max(r7, r3)
            r5.setHeight(r3)
        L_0x051f:
            r7 = 1
            goto L_0x0523
        L_0x0521:
            r7 = r28
        L_0x0523:
            boolean r3 = r15.bR
            if (r3 == 0) goto L_0x0536
            int r3 = r14.getBaseline()
            r5 = -1
            if (r3 == r5) goto L_0x0537
            int r9 = r13.dT
            if (r3 == r9) goto L_0x0537
            r13.dT = r3
            r7 = 1
            goto L_0x0537
        L_0x0536:
            r5 = -1
        L_0x0537:
            int r3 = android.os.Build.VERSION.SDK_INT
            r9 = 11
            if (r3 < r9) goto L_0x0545
            int r3 = r14.getMeasuredState()
            int r12 = combineMeasuredStates(r12, r3)
        L_0x0545:
            r28 = r7
            goto L_0x054b
        L_0x0548:
            r29 = r5
            r5 = -1
        L_0x054b:
            int r11 = r11 + 1
            r5 = r29
            r3 = 1
            r9 = 8
            goto L_0x045d
        L_0x0554:
            if (r28 == 0) goto L_0x055d
            android.support.constraint.solver.widgets.a r3 = r0.aZ
            r3.ar()
            goto L_0x055d
        L_0x055c:
            r12 = 0
        L_0x055d:
            android.support.constraint.solver.widgets.a r3 = r0.aZ
            int r3 = r3.getWidth()
            int r3 = r3 + r6
            android.support.constraint.solver.widgets.a r5 = r0.aZ
            int r5 = r5.getHeight()
            int r5 = r5 + r4
            int r4 = android.os.Build.VERSION.SDK_INT
            r6 = 11
            if (r4 < r6) goto L_0x05a0
            int r1 = resolveSizeAndState(r3, r1, r12)
            int r3 = r12 << 16
            int r2 = resolveSizeAndState(r5, r2, r3)
            int r3 = r0.mMaxWidth
            int r1 = java.lang.Math.min(r3, r1)
            int r3 = r0.mMaxHeight
            int r2 = java.lang.Math.min(r3, r2)
            r3 = 16777215(0xffffff, float:2.3509886E-38)
            r1 = r1 & r3
            r2 = r2 & r3
            android.support.constraint.solver.widgets.a r3 = r0.aZ
            boolean r3 = r3.eF
            r4 = 16777216(0x1000000, float:2.3509887E-38)
            if (r3 == 0) goto L_0x0595
            r1 = r1 | r4
        L_0x0595:
            android.support.constraint.solver.widgets.a r3 = r0.aZ
            boolean r3 = r3.eG
            if (r3 == 0) goto L_0x059c
            r2 = r2 | r4
        L_0x059c:
            r0.setMeasuredDimension(r1, r2)
            return
        L_0x05a0:
            r0.setMeasuredDimension(r3, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.ConstraintLayout.onMeasure(int, int):void");
    }

    private void setSelfDimensionBehaviour(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.FIXED;
        getLayoutParams();
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            } else if (mode == 1073741824) {
                size = Math.min(this.mMaxWidth, size) - paddingLeft;
            }
            size = 0;
        } else {
            dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        }
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 == 0) {
                dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            } else if (mode2 == 1073741824) {
                size2 = Math.min(this.mMaxHeight, size2) - paddingTop;
            }
            size2 = 0;
        } else {
            dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        }
        this.aZ.setMinWidth(0);
        this.aZ.setMinHeight(0);
        this.aZ.a(dimensionBehaviour);
        this.aZ.setWidth(size);
        this.aZ.b(dimensionBehaviour2);
        this.aZ.setHeight(size2);
        this.aZ.setMinWidth((this.mMinWidth - getPaddingLeft()) - getPaddingRight());
        this.aZ.setMinHeight((this.mMinHeight - getPaddingTop()) - getPaddingBottom());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() != 8 || layoutParams.bS || isInEditMode) {
                ConstraintWidget constraintWidget = layoutParams.ca;
                int ah = constraintWidget.ah();
                int ai = constraintWidget.ai();
                childAt.layout(ah, ai, constraintWidget.getWidth() + ah, constraintWidget.getHeight() + ai);
            }
        }
    }

    public void setOptimizationLevel(int i) {
        this.aZ.bb = i;
    }

    protected static LayoutParams U() {
        return new LayoutParams();
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int bA = -1;
        public float bB = 0.5f;
        public float bC = 0.5f;
        public String bD = null;
        private int bE = 1;
        public int bF = 0;
        public int bG = 0;
        public int bH = 0;
        public int bI = 0;
        public int bJ = 0;
        public int bK = 0;
        public int bL = 0;
        public int bM = 0;
        public int bN = -1;
        public int bO = -1;
        boolean bP = true;
        boolean bQ = true;
        boolean bR = false;
        boolean bS = false;
        int bT = -1;
        int bU = -1;
        int bV = -1;
        int bW = -1;
        int bX = -1;
        int bY = -1;
        float bZ = 0.5f;
        public int bd = -1;
        public int be = -1;
        public float bf = -1.0f;
        public int bh = -1;
        public int bi = -1;
        public int bj = -1;
        public int bk = -1;
        public int bl = -1;
        public int bm = -1;
        public int bn = -1;
        public int bo = -1;
        public int bq = -1;
        public int br = -1;
        public int bs = -1;
        public int bt = -1;
        public int bu = -1;
        public int bv = -1;
        public int bw = -1;
        public int bx = -1;
        public int by = -1;
        public int bz = -1;
        ConstraintWidget ca = new ConstraintWidget();
        public float horizontalWeight = 0.0f;
        public int orientation = -1;
        public float verticalWeight = 0.0f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            int i;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.a.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == b.a.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf) {
                    this.bh = obtainStyledAttributes.getResourceId(index, this.bh);
                    if (this.bh == -1) {
                        this.bh = obtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == b.a.ConstraintLayout_Layout_layout_constraintLeft_toRightOf) {
                    this.bi = obtainStyledAttributes.getResourceId(index, this.bi);
                    if (this.bi == -1) {
                        this.bi = obtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == b.a.ConstraintLayout_Layout_layout_constraintRight_toLeftOf) {
                    this.bj = obtainStyledAttributes.getResourceId(index, this.bj);
                    if (this.bj == -1) {
                        this.bj = obtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == b.a.ConstraintLayout_Layout_layout_constraintRight_toRightOf) {
                    this.bk = obtainStyledAttributes.getResourceId(index, this.bk);
                    if (this.bk == -1) {
                        this.bk = obtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == b.a.ConstraintLayout_Layout_layout_constraintTop_toTopOf) {
                    this.bl = obtainStyledAttributes.getResourceId(index, this.bl);
                    if (this.bl == -1) {
                        this.bl = obtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == b.a.ConstraintLayout_Layout_layout_constraintTop_toBottomOf) {
                    this.bm = obtainStyledAttributes.getResourceId(index, this.bm);
                    if (this.bm == -1) {
                        this.bm = obtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == b.a.ConstraintLayout_Layout_layout_constraintBottom_toTopOf) {
                    this.bn = obtainStyledAttributes.getResourceId(index, this.bn);
                    if (this.bn == -1) {
                        this.bn = obtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == b.a.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf) {
                    this.bo = obtainStyledAttributes.getResourceId(index, this.bo);
                    if (this.bo == -1) {
                        this.bo = obtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == b.a.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf) {
                    this.bq = obtainStyledAttributes.getResourceId(index, this.bq);
                    if (this.bq == -1) {
                        this.bq = obtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == b.a.ConstraintLayout_Layout_layout_editor_absoluteX) {
                    this.bN = obtainStyledAttributes.getDimensionPixelOffset(index, this.bN);
                } else if (index == b.a.ConstraintLayout_Layout_layout_editor_absoluteY) {
                    this.bO = obtainStyledAttributes.getDimensionPixelOffset(index, this.bO);
                } else if (index == b.a.ConstraintLayout_Layout_layout_constraintGuide_begin) {
                    this.bd = obtainStyledAttributes.getDimensionPixelOffset(index, this.bd);
                } else if (index == b.a.ConstraintLayout_Layout_layout_constraintGuide_end) {
                    this.be = obtainStyledAttributes.getDimensionPixelOffset(index, this.be);
                } else if (index == b.a.ConstraintLayout_Layout_layout_constraintGuide_percent) {
                    this.bf = obtainStyledAttributes.getFloat(index, this.bf);
                } else if (index == b.a.ConstraintLayout_Layout_android_orientation) {
                    this.orientation = obtainStyledAttributes.getInt(index, this.orientation);
                } else if (index == b.a.ConstraintLayout_Layout_layout_constraintStart_toEndOf) {
                    this.br = obtainStyledAttributes.getResourceId(index, this.br);
                    if (this.br == -1) {
                        this.br = obtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == b.a.ConstraintLayout_Layout_layout_constraintStart_toStartOf) {
                    this.bs = obtainStyledAttributes.getResourceId(index, this.bs);
                    if (this.bs == -1) {
                        this.bs = obtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == b.a.ConstraintLayout_Layout_layout_constraintEnd_toStartOf) {
                    this.bt = obtainStyledAttributes.getResourceId(index, this.bt);
                    if (this.bt == -1) {
                        this.bt = obtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == b.a.ConstraintLayout_Layout_layout_constraintEnd_toEndOf) {
                    this.bu = obtainStyledAttributes.getResourceId(index, this.bu);
                    if (this.bu == -1) {
                        this.bu = obtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == b.a.ConstraintLayout_Layout_layout_goneMarginLeft) {
                    this.bv = obtainStyledAttributes.getDimensionPixelSize(index, this.bv);
                } else if (index == b.a.ConstraintLayout_Layout_layout_goneMarginTop) {
                    this.bw = obtainStyledAttributes.getDimensionPixelSize(index, this.bw);
                } else if (index == b.a.ConstraintLayout_Layout_layout_goneMarginRight) {
                    this.bx = obtainStyledAttributes.getDimensionPixelSize(index, this.bx);
                } else if (index == b.a.ConstraintLayout_Layout_layout_goneMarginBottom) {
                    this.by = obtainStyledAttributes.getDimensionPixelSize(index, this.by);
                } else if (index == b.a.ConstraintLayout_Layout_layout_goneMarginStart) {
                    this.bz = obtainStyledAttributes.getDimensionPixelSize(index, this.bz);
                } else if (index == b.a.ConstraintLayout_Layout_layout_goneMarginEnd) {
                    this.bA = obtainStyledAttributes.getDimensionPixelSize(index, this.bA);
                } else if (index == b.a.ConstraintLayout_Layout_layout_constraintHorizontal_bias) {
                    this.bB = obtainStyledAttributes.getFloat(index, this.bB);
                } else if (index == b.a.ConstraintLayout_Layout_layout_constraintVertical_bias) {
                    this.bC = obtainStyledAttributes.getFloat(index, this.bC);
                } else if (index == b.a.ConstraintLayout_Layout_layout_constraintDimensionRatio) {
                    this.bD = obtainStyledAttributes.getString(index);
                    this.bE = -1;
                    if (this.bD != null) {
                        int length = this.bD.length();
                        int indexOf = this.bD.indexOf(44);
                        if (indexOf <= 0 || indexOf >= length - 1) {
                            i = 0;
                        } else {
                            String substring = this.bD.substring(0, indexOf);
                            if (substring.equalsIgnoreCase("W")) {
                                this.bE = 0;
                            } else if (substring.equalsIgnoreCase("H")) {
                                this.bE = 1;
                            }
                            i = indexOf + 1;
                        }
                        int indexOf2 = this.bD.indexOf(58);
                        if (indexOf2 < 0 || indexOf2 >= length - 1) {
                            String substring2 = this.bD.substring(i);
                            if (substring2.length() > 0) {
                                Float.parseFloat(substring2);
                            }
                        } else {
                            String substring3 = this.bD.substring(i, indexOf2);
                            String substring4 = this.bD.substring(indexOf2 + 1);
                            if (substring3.length() > 0 && substring4.length() > 0) {
                                try {
                                    float parseFloat = Float.parseFloat(substring3);
                                    float parseFloat2 = Float.parseFloat(substring4);
                                    if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                                        if (this.bE == 1) {
                                            Math.abs(parseFloat2 / parseFloat);
                                        } else {
                                            Math.abs(parseFloat / parseFloat2);
                                        }
                                    }
                                } catch (NumberFormatException unused) {
                                }
                            }
                        }
                    }
                } else if (index == b.a.ConstraintLayout_Layout_layout_constraintHorizontal_weight) {
                    this.horizontalWeight = obtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == b.a.ConstraintLayout_Layout_layout_constraintVertical_weight) {
                    this.verticalWeight = obtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == b.a.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle) {
                    this.bF = obtainStyledAttributes.getInt(index, 0);
                } else if (index == b.a.ConstraintLayout_Layout_layout_constraintVertical_chainStyle) {
                    this.bG = obtainStyledAttributes.getInt(index, 0);
                } else if (index == b.a.ConstraintLayout_Layout_layout_constraintWidth_default) {
                    this.bH = obtainStyledAttributes.getInt(index, 0);
                } else if (index == b.a.ConstraintLayout_Layout_layout_constraintHeight_default) {
                    this.bI = obtainStyledAttributes.getInt(index, 0);
                } else if (index == b.a.ConstraintLayout_Layout_layout_constraintWidth_min) {
                    this.bJ = obtainStyledAttributes.getDimensionPixelSize(index, this.bJ);
                } else if (index == b.a.ConstraintLayout_Layout_layout_constraintWidth_max) {
                    this.bL = obtainStyledAttributes.getDimensionPixelSize(index, this.bL);
                } else if (index == b.a.ConstraintLayout_Layout_layout_constraintHeight_min) {
                    this.bK = obtainStyledAttributes.getDimensionPixelSize(index, this.bK);
                } else if (index == b.a.ConstraintLayout_Layout_layout_constraintHeight_max) {
                    this.bM = obtainStyledAttributes.getDimensionPixelSize(index, this.bM);
                } else if (!(index == b.a.ConstraintLayout_Layout_layout_constraintLeft_creator || index == b.a.ConstraintLayout_Layout_layout_constraintTop_creator || index == b.a.ConstraintLayout_Layout_layout_constraintRight_creator || index == b.a.ConstraintLayout_Layout_layout_constraintBottom_creator)) {
                    int i3 = b.a.ConstraintLayout_Layout_layout_constraintBaseline_creator;
                }
            }
            obtainStyledAttributes.recycle();
            validate();
        }

        public final void validate() {
            this.bS = false;
            this.bP = true;
            this.bQ = true;
            if (this.width == 0 || this.width == -1) {
                this.bP = false;
            }
            if (this.height == 0 || this.height == -1) {
                this.bQ = false;
            }
            if (this.bf != -1.0f || this.bd != -1 || this.be != -1) {
                this.bS = true;
                this.bP = true;
                this.bQ = true;
                if (!(this.ca instanceof android.support.constraint.solver.widgets.b)) {
                    this.ca = new android.support.constraint.solver.widgets.b();
                }
                ((android.support.constraint.solver.widgets.b) this.ca).setOrientation(this.orientation);
            }
        }

        public LayoutParams() {
            super(-2, -2);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        @TargetApi(17)
        public void resolveLayoutDirection(int i) {
            super.resolveLayoutDirection(i);
            this.bV = -1;
            this.bW = -1;
            this.bT = -1;
            this.bU = -1;
            this.bX = -1;
            this.bY = -1;
            this.bX = this.bv;
            this.bY = this.bx;
            this.bZ = this.bB;
            boolean z = true;
            if (1 != getLayoutDirection()) {
                z = false;
            }
            if (z) {
                if (this.br != -1) {
                    this.bV = this.br;
                } else if (this.bs != -1) {
                    this.bW = this.bs;
                }
                if (this.bt != -1) {
                    this.bU = this.bt;
                }
                if (this.bu != -1) {
                    this.bT = this.bu;
                }
                if (this.bz != -1) {
                    this.bY = this.bz;
                }
                if (this.bA != -1) {
                    this.bX = this.bA;
                }
                this.bZ = 1.0f - this.bB;
            } else {
                if (this.br != -1) {
                    this.bU = this.br;
                }
                if (this.bs != -1) {
                    this.bT = this.bs;
                }
                if (this.bt != -1) {
                    this.bV = this.bt;
                }
                if (this.bu != -1) {
                    this.bW = this.bu;
                }
                if (this.bz != -1) {
                    this.bX = this.bz;
                }
                if (this.bA != -1) {
                    this.bY = this.bA;
                }
            }
            if (this.bt == -1 && this.bu == -1) {
                if (this.bj != -1) {
                    this.bV = this.bj;
                } else if (this.bk != -1) {
                    this.bW = this.bk;
                }
            }
            if (this.bs != -1 || this.br != -1) {
                return;
            }
            if (this.bh != -1) {
                this.bT = this.bh;
            } else if (this.bi != -1) {
                this.bU = this.bi;
            }
        }
    }

    public void requestLayout() {
        super.requestLayout();
        this.ba = true;
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }
}
