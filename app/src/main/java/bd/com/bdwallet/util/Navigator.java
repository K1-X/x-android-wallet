package bd.com.bdwallet.util;

import android.app.Activity;

import bd.com.bdwallet.module.user.lockpattern.LockPatternCloseActivity;
import bd.com.bdwallet.module.user.lockpattern.LockPatternResetActivity;
import bd.com.bdwallet.module.user.lockpattern.LockPatternSetUpActivity;
import bd.com.bdwallet.module.user.lockpattern.LockPatternUnlockActivity;

public class Navigator {

    public static void toLockPatternSetUp(Activity activity) {
        activity.startActivity(LockPatternSetUpActivity.getStartIntent(activity));
    }

}
