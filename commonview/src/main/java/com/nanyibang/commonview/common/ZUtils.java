package com.nanyibang.commonview.common;

import android.content.Context;
import android.content.res.Resources;
import android.view.WindowManager;

/**
 * @Package: com.nanyibang.commonview.common
 * @Description:
 * @Author: zyh
 * @CreateDate: 2019-09-2019/9/19
 * @company: 上海若美科技有限公司
 */
public class ZUtils {
    public static int getWindowWidth(Context context) {
        return ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getWidth();
    }

    public static int getWindowHeight(Context context) {
        return ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getHeight();
    }

    public static int dp2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    public static int getStatusBarHeight() {
        Resources resources = Resources.getSystem();
        int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
        return resources.getDimensionPixelSize(resourceId);
    }
}
