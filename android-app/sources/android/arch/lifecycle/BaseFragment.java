package android.arch.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public final class BaseFragment
  extends Fragment
{
  public BaseFragment() {}
  
  private void i(Lifecycle.Event paramEvent)
  {
    Object localObject = getActivity();
    if ((localObject instanceof Logger))
    {
      ((Logger)localObject).getLocation().toString(paramEvent);
      return;
    }
    if ((localObject instanceof h))
    {
      localObject = ((h)localObject).getLifecycle();
      if ((localObject instanceof m)) {
        ((m)localObject).toString(paramEvent);
      }
    }
  }
  
  public static void showDialog(Activity paramActivity)
  {
    paramActivity = paramActivity.getFragmentManager();
    if (paramActivity.findFragmentByTag("android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag") == null)
    {
      paramActivity.beginTransaction().add(new BaseFragment(), "android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
      paramActivity.executePendingTransactions();
    }
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    i(Lifecycle.Event.ON_CREATE);
  }
  
  public final void onDestroy()
  {
    super.onDestroy();
    i(Lifecycle.Event.ON_DESTROY);
  }
  
  public final void onPause()
  {
    super.onPause();
    i(Lifecycle.Event.ON_PAUSE);
  }
  
  public final void onResume()
  {
    super.onResume();
    i(Lifecycle.Event.ON_RESUME);
  }
  
  public final void onStart()
  {
    super.onStart();
    i(Lifecycle.Event.ON_START);
  }
  
  public final void onStop()
  {
    super.onStop();
    i(Lifecycle.Event.ON_STOP);
  }
}
