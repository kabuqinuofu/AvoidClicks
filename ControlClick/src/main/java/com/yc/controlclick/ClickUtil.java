package com.yc.controlclick;

import android.view.View;

/**
 * @author by CNKIFU on 2020/6/12.
 */
public class ClickUtil {

    private static long mLastClickTime;

    private static int mLastClickViewId;

    public static boolean isFastDoubleClick(View view, long intervalMillis) {
        int viewId = view.getId();
        long time = System.currentTimeMillis();
        long timeInterval = Math.abs(time - mLastClickTime);
        if (timeInterval < intervalMillis && viewId == mLastClickViewId) {
            return true;
        } else {
            mLastClickTime = time;
            mLastClickViewId = viewId;
            return false;
        }
    }

}