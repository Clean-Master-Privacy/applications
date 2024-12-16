    package com.airbnb.lottie.a.b;

import android.graphics.Path;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.content.h;
import java.util.ArrayList;
import java.util.List;

public final class g {
    public final List<a<h, Path>> nC;
    public final List<a<Integer, Integer>> nD;
    public final List<Mask> nE;

    public g(List<Mask> list) {
        this.nE = list;
        this.nC = new ArrayList(list.size());
        this.nD = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            this.nC.add(list.get(i).pd.cO());
            this.nD.add(list.get(i).oJ.cO());
        }
    }
}
    
