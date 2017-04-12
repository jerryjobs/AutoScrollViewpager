package cn.jerry.views.componets;

import android.content.Context;
import android.os.Build;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.StyleRes;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import cn.jerry.views.statusview.SampleStatusView;

/**
 * Created by JieGuo on 2017/4/11.
 */

public class FrameLayoutWithStatusView extends FrameLayout {


    private SampleStatusView statusView;

    public FrameLayoutWithStatusView(@NonNull Context context) {
        super(context);
        init(context);
    }

    public FrameLayoutWithStatusView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public FrameLayoutWithStatusView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @SuppressWarnings("unused")
    public FrameLayoutWithStatusView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    public void init(Context context) {
        statusView = new SampleStatusView(context);
    }

    public void showStatusView() {
        addView(statusView);
        statusView.showLoading();
    }

    public void showEmpty(String emptyMessage) {
        statusView.showEmpty(emptyMessage);
    }

    public void showError(Throwable throwable) {
        statusView.showError(throwable);
    }

    public void loadFinish() {
        statusView.finishWithAnimation();
    }

    public SampleStatusView getStatusView() {
        return statusView;
    }
}
