package android.support.constraint;

import android.content.res.TypedArray;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.b;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class a {
    private static final int[] cb = {0, 4, 8};
    private static SparseIntArray cd;
    HashMap<Integer, C0004a> cc = new HashMap<>();

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        cd = sparseIntArray;
        sparseIntArray.append(b.a.ConstraintSet_layout_constraintLeft_toLeftOf, 25);
        cd.append(b.a.ConstraintSet_layout_constraintLeft_toRightOf, 26);
        cd.append(b.a.ConstraintSet_layout_constraintRight_toLeftOf, 29);
        cd.append(b.a.ConstraintSet_layout_constraintRight_toRightOf, 30);
        cd.append(b.a.ConstraintSet_layout_constraintTop_toTopOf, 36);
        cd.append(b.a.ConstraintSet_layout_constraintTop_toBottomOf, 35);
        cd.append(b.a.ConstraintSet_layout_constraintBottom_toTopOf, 4);
        cd.append(b.a.ConstraintSet_layout_constraintBottom_toBottomOf, 3);
        cd.append(b.a.ConstraintSet_layout_constraintBaseline_toBaselineOf, 1);
        cd.append(b.a.ConstraintSet_layout_editor_absoluteX, 6);
        cd.append(b.a.ConstraintSet_layout_editor_absoluteY, 7);
        cd.append(b.a.ConstraintSet_layout_constraintGuide_begin, 17);
        cd.append(b.a.ConstraintSet_layout_constraintGuide_end, 18);
        cd.append(b.a.ConstraintSet_layout_constraintGuide_percent, 19);
        cd.append(b.a.ConstraintSet_android_orientation, 27);
        cd.append(b.a.ConstraintSet_layout_constraintStart_toEndOf, 32);
        cd.append(b.a.ConstraintSet_layout_constraintStart_toStartOf, 33);
        cd.append(b.a.ConstraintSet_layout_constraintEnd_toStartOf, 10);
        cd.append(b.a.ConstraintSet_layout_constraintEnd_toEndOf, 9);
        cd.append(b.a.ConstraintSet_layout_goneMarginLeft, 13);
        cd.append(b.a.ConstraintSet_layout_goneMarginTop, 16);
        cd.append(b.a.ConstraintSet_layout_goneMarginRight, 14);
        cd.append(b.a.ConstraintSet_layout_goneMarginBottom, 11);
        cd.append(b.a.ConstraintSet_layout_goneMarginStart, 15);
        cd.append(b.a.ConstraintSet_layout_goneMarginEnd, 12);
        cd.append(b.a.ConstraintSet_layout_constraintVertical_weight, 40);
        cd.append(b.a.ConstraintSet_layout_constraintHorizontal_weight, 39);
        cd.append(b.a.ConstraintSet_layout_constraintHorizontal_chainStyle, 41);
        cd.append(b.a.ConstraintSet_layout_constraintVertical_chainStyle, 42);
        cd.append(b.a.ConstraintSet_layout_constraintHorizontal_bias, 20);
        cd.append(b.a.ConstraintSet_layout_constraintVertical_bias, 37);
        cd.append(b.a.ConstraintSet_layout_constraintDimensionRatio, 5);
        cd.append(b.a.ConstraintSet_layout_constraintLeft_creator, 60);
        cd.append(b.a.ConstraintSet_layout_constraintTop_creator, 60);
        cd.append(b.a.ConstraintSet_layout_constraintRight_creator, 60);
        cd.append(b.a.ConstraintSet_layout_constraintBottom_creator, 60);
        cd.append(b.a.ConstraintSet_layout_constraintBaseline_creator, 60);
        cd.append(b.a.ConstraintSet_android_layout_marginLeft, 24);
        cd.append(b.a.ConstraintSet_android_layout_marginRight, 28);
        cd.append(b.a.ConstraintSet_android_layout_marginStart, 31);
        cd.append(b.a.ConstraintSet_android_layout_marginEnd, 8);
        cd.append(b.a.ConstraintSet_android_layout_marginTop, 34);
        cd.append(b.a.ConstraintSet_android_layout_marginBottom, 2);
        cd.append(b.a.ConstraintSet_android_layout_width, 23);
        cd.append(b.a.ConstraintSet_android_layout_height, 21);
        cd.append(b.a.ConstraintSet_android_visibility, 22);
        cd.append(b.a.ConstraintSet_android_alpha, 43);
        cd.append(b.a.ConstraintSet_android_elevation, 44);
        cd.append(b.a.ConstraintSet_android_rotationX, 45);
        cd.append(b.a.ConstraintSet_android_rotationY, 46);
        cd.append(b.a.ConstraintSet_android_scaleX, 47);
        cd.append(b.a.ConstraintSet_android_scaleY, 48);
        cd.append(b.a.ConstraintSet_android_transformPivotX, 49);
        cd.append(b.a.ConstraintSet_android_transformPivotY, 50);
        cd.append(b.a.ConstraintSet_android_translationX, 51);
        cd.append(b.a.ConstraintSet_android_translationY, 52);
        cd.append(b.a.ConstraintSet_android_translationZ, 53);
        cd.append(b.a.ConstraintSet_layout_constraintWidth_default, 54);
        cd.append(b.a.ConstraintSet_layout_constraintHeight_default, 55);
        cd.append(b.a.ConstraintSet_layout_constraintWidth_max, 56);
        cd.append(b.a.ConstraintSet_layout_constraintHeight_max, 57);
        cd.append(b.a.ConstraintSet_layout_constraintWidth_min, 58);
        cd.append(b.a.ConstraintSet_layout_constraintHeight_min, 59);
        cd.append(b.a.ConstraintSet_android_id, 38);
    }

    /* renamed from: android.support.constraint.a$a  reason: collision with other inner class name */
    private static class C0004a {
        public float alpha;
        public int bA;
        public float bB;
        public float bC;
        public String bD;
        public int bF;
        public int bG;
        public int bN;
        public int bO;
        public int bd;
        public int be;
        public float bf;
        public int bh;
        public int bi;
        public int bj;
        public int bk;
        public int bl;
        public int bm;
        public int bn;
        public int bo;
        public int bottomMargin;
        public int bq;
        public int br;
        public int bs;
        public int bt;
        public int bu;
        public int bv;
        public int bw;
        public int bx;
        public int by;
        public int bz;
        boolean ce;
        int cf;
        public int cg;
        public int ci;
        public boolean cj;
        public float ck;
        public float cl;

        /* renamed from: cm  reason: collision with root package name */
        public float f343cm;
        private int cn;
        private int co;
        private int cp;
        private int cq;
        private int cr;
        private int cs;
        public float horizontalWeight;
        public int leftMargin;
        public int mHeight;
        public int mWidth;
        public int orientation;
        public int rightMargin;
        public float rotationX;
        public float rotationY;
        public float scaleX;
        public float scaleY;
        public int topMargin;
        public float translationX;
        public float translationY;
        public float translationZ;
        public float verticalWeight;
        public int visibility;

        private C0004a() {
            this.ce = false;
            this.bd = -1;
            this.be = -1;
            this.bf = -1.0f;
            this.bh = -1;
            this.bi = -1;
            this.bj = -1;
            this.bk = -1;
            this.bl = -1;
            this.bm = -1;
            this.bn = -1;
            this.bo = -1;
            this.bq = -1;
            this.br = -1;
            this.bs = -1;
            this.bt = -1;
            this.bu = -1;
            this.bB = 0.5f;
            this.bC = 0.5f;
            this.bD = null;
            this.bN = -1;
            this.bO = -1;
            this.orientation = -1;
            this.leftMargin = -1;
            this.rightMargin = -1;
            this.topMargin = -1;
            this.bottomMargin = -1;
            this.cg = -1;
            this.ci = -1;
            this.visibility = 0;
            this.bv = -1;
            this.bw = -1;
            this.bx = -1;
            this.by = -1;
            this.bA = -1;
            this.bz = -1;
            this.verticalWeight = 0.0f;
            this.horizontalWeight = 0.0f;
            this.bF = 0;
            this.bG = 0;
            this.alpha = 1.0f;
            this.cj = false;
            this.ck = 0.0f;
            this.rotationX = 0.0f;
            this.rotationY = 0.0f;
            this.scaleX = 1.0f;
            this.scaleY = 1.0f;
            this.cl = 0.0f;
            this.f343cm = 0.0f;
            this.translationX = 0.0f;
            this.translationY = 0.0f;
            this.translationZ = 0.0f;
            this.cn = -1;
            this.co = -1;
            this.cp = -1;
            this.cq = -1;
            this.cr = -1;
            this.cs = -1;
        }

        /* synthetic */ C0004a(byte b2) {
            this();
        }

        public final void a(ConstraintLayout.LayoutParams layoutParams) {
            layoutParams.bh = this.bh;
            layoutParams.bi = this.bi;
            layoutParams.bj = this.bj;
            layoutParams.bk = this.bk;
            layoutParams.bl = this.bl;
            layoutParams.bm = this.bm;
            layoutParams.bn = this.bn;
            layoutParams.bo = this.bo;
            layoutParams.bq = this.bq;
            layoutParams.br = this.br;
            layoutParams.bs = this.bs;
            layoutParams.bt = this.bt;
            layoutParams.bu = this.bu;
            layoutParams.leftMargin = this.leftMargin;
            layoutParams.rightMargin = this.rightMargin;
            layoutParams.topMargin = this.topMargin;
            layoutParams.bottomMargin = this.bottomMargin;
            layoutParams.bz = this.bz;
            layoutParams.bA = this.bA;
            layoutParams.bB = this.bB;
            layoutParams.bC = this.bC;
            layoutParams.bD = this.bD;
            layoutParams.bN = this.bN;
            layoutParams.bO = this.bO;
            layoutParams.verticalWeight = this.verticalWeight;
            layoutParams.horizontalWeight = this.horizontalWeight;
            layoutParams.bG = this.bG;
            layoutParams.bF = this.bF;
            layoutParams.bH = this.cn;
            layoutParams.bI = this.co;
            layoutParams.bL = this.cp;
            layoutParams.bM = this.cq;
            layoutParams.bJ = this.cr;
            layoutParams.bK = this.cs;
            layoutParams.orientation = this.orientation;
            layoutParams.bf = this.bf;
            layoutParams.bd = this.bd;
            layoutParams.be = this.be;
            layoutParams.width = this.mWidth;
            layoutParams.height = this.mHeight;
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.setMarginStart(this.ci);
                layoutParams.setMarginEnd(this.cg);
            }
            layoutParams.validate();
        }

        public final /* synthetic */ Object clone() throws CloneNotSupportedException {
            C0004a aVar = new C0004a();
            aVar.ce = this.ce;
            aVar.mWidth = this.mWidth;
            aVar.mHeight = this.mHeight;
            aVar.bd = this.bd;
            aVar.be = this.be;
            aVar.bf = this.bf;
            aVar.bh = this.bh;
            aVar.bi = this.bi;
            aVar.bj = this.bj;
            aVar.bk = this.bk;
            aVar.bl = this.bl;
            aVar.bm = this.bm;
            aVar.bn = this.bn;
            aVar.bo = this.bo;
            aVar.bq = this.bq;
            aVar.br = this.br;
            aVar.bs = this.bs;
            aVar.bt = this.bt;
            aVar.bu = this.bu;
            aVar.bB = this.bB;
            aVar.bC = this.bC;
            aVar.bD = this.bD;
            aVar.bN = this.bN;
            aVar.bO = this.bO;
            aVar.bB = this.bB;
            aVar.bB = this.bB;
            aVar.bB = this.bB;
            aVar.bB = this.bB;
            aVar.bB = this.bB;
            aVar.orientation = this.orientation;
            aVar.leftMargin = this.leftMargin;
            aVar.rightMargin = this.rightMargin;
            aVar.topMargin = this.topMargin;
            aVar.bottomMargin = this.bottomMargin;
            aVar.cg = this.cg;
            aVar.ci = this.ci;
            aVar.visibility = this.visibility;
            aVar.bv = this.bv;
            aVar.bw = this.bw;
            aVar.bx = this.bx;
            aVar.by = this.by;
            aVar.bA = this.bA;
            aVar.bz = this.bz;
            aVar.verticalWeight = this.verticalWeight;
            aVar.horizontalWeight = this.horizontalWeight;
            aVar.bF = this.bF;
            aVar.bG = this.bG;
            aVar.alpha = this.alpha;
            aVar.cj = this.cj;
            aVar.ck = this.ck;
            aVar.rotationX = this.rotationX;
            aVar.rotationY = this.rotationY;
            aVar.scaleX = this.scaleX;
            aVar.scaleY = this.scaleY;
            aVar.cl = this.cl;
            aVar.f343cm = this.f343cm;
            aVar.translationX = this.translationX;
            aVar.translationY = this.translationY;
            aVar.translationZ = this.translationZ;
            aVar.cn = this.cn;
            aVar.co = this.co;
            aVar.cp = this.cp;
            aVar.cq = this.cq;
            aVar.cr = this.cr;
            aVar.cs = this.cs;
            return aVar;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.cc.keySet());
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            int id = childAt.getId();
            if (this.cc.containsKey(Integer.valueOf(id))) {
                hashSet.remove(Integer.valueOf(id));
                C0004a aVar = this.cc.get(Integer.valueOf(id));
                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
                aVar.a(layoutParams);
                childAt.setLayoutParams(layoutParams);
                childAt.setVisibility(aVar.visibility);
                if (Build.VERSION.SDK_INT >= 17) {
                    childAt.setAlpha(aVar.alpha);
                    childAt.setRotationX(aVar.rotationX);
                    childAt.setRotationY(aVar.rotationY);
                    childAt.setScaleX(aVar.scaleX);
                    childAt.setScaleY(aVar.scaleY);
                    childAt.setPivotX(aVar.cl);
                    childAt.setPivotY(aVar.f343cm);
                    childAt.setTranslationX(aVar.translationX);
                    childAt.setTranslationY(aVar.translationY);
                    if (Build.VERSION.SDK_INT >= 21) {
                        childAt.setTranslationZ(aVar.translationZ);
                        if (aVar.cj) {
                            childAt.setElevation(aVar.ck);
                        }
                    }
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            C0004a aVar2 = this.cc.get(num);
            if (aVar2.ce) {
                Guideline guideline = new Guideline(constraintLayout.getContext());
                guideline.setId(num.intValue());
                ConstraintLayout.LayoutParams U = ConstraintLayout.U();
                aVar2.a(U);
                constraintLayout.addView(guideline, U);
            }
        }
    }

    private static int a(TypedArray typedArray, int i, int i2) {
        int resourceId = typedArray.getResourceId(i, i2);
        return resourceId == -1 ? typedArray.getInt(i, -1) : resourceId;
    }

    static void a(C0004a aVar, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArray.getIndex(i);
            int i2 = cd.get(index);
            if (i2 != 60) {
                switch (i2) {
                    case 1:
                        aVar.bq = a(typedArray, index, aVar.bq);
                        break;
                    case 2:
                        aVar.bottomMargin = typedArray.getDimensionPixelSize(index, aVar.bottomMargin);
                        break;
                    case 3:
                        aVar.bo = a(typedArray, index, aVar.bo);
                        break;
                    case 4:
                        aVar.bn = a(typedArray, index, aVar.bn);
                        break;
                    case 5:
                        aVar.bD = typedArray.getString(index);
                        break;
                    case 6:
                        aVar.bN = typedArray.getDimensionPixelOffset(index, aVar.bN);
                        break;
                    case 7:
                        aVar.bO = typedArray.getDimensionPixelOffset(index, aVar.bO);
                        break;
                    case 8:
                        aVar.cg = typedArray.getDimensionPixelSize(index, aVar.cg);
                        break;
                    case 9:
                        aVar.bn = a(typedArray, index, aVar.bu);
                        break;
                    case 10:
                        aVar.bt = a(typedArray, index, aVar.bt);
                        break;
                    case 11:
                        aVar.by = typedArray.getDimensionPixelSize(index, aVar.by);
                        break;
                    case 12:
                        aVar.bA = typedArray.getDimensionPixelSize(index, aVar.bA);
                        break;
                    case 13:
                        aVar.bv = typedArray.getDimensionPixelSize(index, aVar.bv);
                        break;
                    case 14:
                        aVar.bx = typedArray.getDimensionPixelSize(index, aVar.bx);
                        break;
                    case 15:
                        aVar.bz = typedArray.getDimensionPixelSize(index, aVar.bz);
                        break;
                    case 16:
                        aVar.bw = typedArray.getDimensionPixelSize(index, aVar.bw);
                        break;
                    case 17:
                        aVar.bd = typedArray.getDimensionPixelOffset(index, aVar.bd);
                        break;
                    case 18:
                        aVar.be = typedArray.getDimensionPixelOffset(index, aVar.be);
                        break;
                    case 19:
                        aVar.bf = typedArray.getFloat(index, aVar.bf);
                        break;
                    case 20:
                        aVar.bB = typedArray.getFloat(index, aVar.bB);
                        break;
                    case 21:
                        aVar.mHeight = typedArray.getLayoutDimension(index, aVar.mHeight);
                        break;
                    case 22:
                        aVar.visibility = typedArray.getInt(index, aVar.visibility);
                        aVar.visibility = cb[aVar.visibility];
                        break;
                    case 23:
                        aVar.mWidth = typedArray.getLayoutDimension(index, aVar.mWidth);
                        break;
                    case 24:
                        aVar.leftMargin = typedArray.getDimensionPixelSize(index, aVar.leftMargin);
                        break;
                    case 25:
                        aVar.bh = a(typedArray, index, aVar.bh);
                        break;
                    case 26:
                        aVar.bi = a(typedArray, index, aVar.bi);
                        break;
                    case 27:
                        aVar.orientation = typedArray.getInt(index, aVar.orientation);
                        break;
                    case 28:
                        aVar.rightMargin = typedArray.getDimensionPixelSize(index, aVar.rightMargin);
                        break;
                    case 29:
                        aVar.bj = a(typedArray, index, aVar.bj);
                        break;
                    case 30:
                        aVar.bk = a(typedArray, index, aVar.bk);
                        break;
                    case 31:
                        aVar.ci = typedArray.getDimensionPixelSize(index, aVar.ci);
                        break;
                    case 32:
                        aVar.br = a(typedArray, index, aVar.br);
                        break;
                    case 33:
                        aVar.bs = a(typedArray, index, aVar.bs);
                        break;
                    case 34:
                        aVar.topMargin = typedArray.getDimensionPixelSize(index, aVar.topMargin);
                        break;
                    case 35:
                        aVar.bm = a(typedArray, index, aVar.bm);
                        break;
                    case 36:
                        aVar.bl = a(typedArray, index, aVar.bl);
                        break;
                    case 37:
                        aVar.bC = typedArray.getFloat(index, aVar.bC);
                        break;
                    case 38:
                        aVar.cf = typedArray.getResourceId(index, aVar.cf);
                        break;
                    case 39:
                        aVar.horizontalWeight = typedArray.getFloat(index, aVar.horizontalWeight);
                        break;
                    case 40:
                        aVar.verticalWeight = typedArray.getFloat(index, aVar.verticalWeight);
                        break;
                    case 41:
                        aVar.bF = typedArray.getInt(index, aVar.bF);
                        break;
                    case 42:
                        aVar.bG = typedArray.getInt(index, aVar.bG);
                        break;
                    case 43:
                        aVar.alpha = typedArray.getFloat(index, aVar.alpha);
                        break;
                    case 44:
                        aVar.cj = true;
                        aVar.ck = typedArray.getFloat(index, aVar.ck);
                        break;
                    case 45:
                        aVar.rotationX = typedArray.getFloat(index, aVar.rotationX);
                        break;
                    case 46:
                        aVar.rotationY = typedArray.getFloat(index, aVar.rotationY);
                        break;
                    case 47:
                        aVar.scaleX = typedArray.getFloat(index, aVar.scaleX);
                        break;
                    case 48:
                        aVar.scaleY = typedArray.getFloat(index, aVar.scaleY);
                        break;
                    case 49:
                        aVar.cl = typedArray.getFloat(index, aVar.cl);
                        break;
                    case 50:
                        aVar.f343cm = typedArray.getFloat(index, aVar.f343cm);
                        break;
                    case 51:
                        aVar.translationX = typedArray.getFloat(index, aVar.translationX);
                        break;
                    case 52:
                        aVar.translationY = typedArray.getFloat(index, aVar.translationY);
                        break;
                    case 53:
                        aVar.translationZ = typedArray.getFloat(index, aVar.translationZ);
                        break;
                    default:
                        Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + cd.get(index));
                        break;
                }
            } else {
                Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + cd.get(index));
            }
        }
    }
}
