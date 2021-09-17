package bd.com.bdwallet.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;

import java.util.ArrayList;

/**
 * Special TabHost that allows the use of {@link Fragment} objects for
 * its tab content.  When placing this in a view hierarchy, after inflating
 * the hierarchy you must call {@link #setup(Context, FragmentManager, int)}
 * to complete the initialization of the tab host.
 *
 * <p>Here is a simple example of using a FragmentTabHost in an Activity:
 *
 * {@sample development/samples/Support4Demos/src/com/example/android/supportv4/app/FragmentTabs.java
 *      complete}
 *
 * <p>This can also be used inside of a fragment through fragment nesting:
 *
 * {@sample development/samples/Support4Demos/src/com/example/android/supportv4/app/FragmentTabsFragmentSupport.java
 *      complete}
 */
public class MyFragmentTabHost extends TabHost
        implements TabHost.OnTabChangeListener {
    
}
