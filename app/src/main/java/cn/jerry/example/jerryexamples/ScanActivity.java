package cn.jerry.example.jerryexamples;

import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;

import push.jerry.cn.scan.CaptureActivity;

/**
 * Created by JieGuo on 2017/4/27.
 */

public class ScanActivity extends CaptureActivity {

    private static final String TAG = "ScanActivity";

    @Override
    protected int getScreenHeight() {
        WindowManager wm = this.getWindowManager();
        DisplayMetrics metrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(metrics);
        return metrics.heightPixels;
    }

    @Override
    protected void doAnalysisResult(String result) {
        Log.e(TAG, "scan result is : " + result);
        finish();
    }

}
