  package butterknife.a;

import android.view.View;

public abstract class a implements View.OnClickListener {
    /* access modifiers changed from: private */
    public static boolean enabled = true;
    private static final Runnable iS = $$Lambda$a$7nGtXXVpICrA2Jb86duYJmQpcE.INSTANCE;

    public abstract void e(View view);

    public final void onClick(View view) {
        if (enabled) {
            enabled = false;
            view.post(iS);
            e(view);
        }
    }
}
