package android.arch.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.arch.lifecycle.Lifecycle;
import android.os.Bundle;

/* compiled from: ReportFragment */
public final class l extends Fragment {
    public static void c(Activity activity) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new l(), "android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        c(Lifecycle.Event.ON_CREATE);
    }

    public final void onStart() {
        super.onStart();
        c(Lifecycle.Event.ON_START);
    }

    public final void onResume() {
        super.onResume();
        c(Lifecycle.Event.ON_RESUME);
    }

    public final void onPause() {
        super.onPause();
        c(Lifecycle.Event.ON_PAUSE);
    }

    public final void onStop() {
        super.onStop();
        c(Lifecycle.Event.ON_STOP);
    }

    public final void onDestroy() {
        super.onDestroy();
        c(Lifecycle.Event.ON_DESTROY);
    }

    private void c(Lifecycle.Event event) {
        Activity activity = getActivity();
        if (activity instanceof f) {
            ((f) activity).N().a(event);
        } else if (activity instanceof d) {
            Lifecycle lifecycle = ((d) activity).getLifecycle();
            if (lifecycle instanceof e) {
                ((e) lifecycle).a(event);
            }
        }
    }
}
