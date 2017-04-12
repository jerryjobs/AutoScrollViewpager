package cn.jerry.views.statusview;

import android.content.Context;
import android.os.Build;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.StyleRes;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 *
 * Created by JieGuo on 2017/4/5.
 */

public class SampleStatusView extends StatusView {

    private static final String TAG = "SampleStatusView";

    TextView tvTitle;

    public SampleStatusView(@NonNull Context context) {
        super(context);
    }

    public SampleStatusView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SampleStatusView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @SuppressWarnings("unused")
    public SampleStatusView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected int getContentResource() {
        return R.layout.view_status;
    }

    public void setTitle(String title) {

        tvTitle = (TextView) findViewById(R.id.tv_title);
        tvTitle.setText(title);
    }

    @Override
    public void showError(Throwable throwable) {
        super.showError(throwable);
    }

    public void setOnRetryListener(final SwipeRefreshLayout.OnRefreshListener onRetryListener) {
        tvTitle.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (onRetryListener != null) {
                        onRetryListener.onRefresh();
                    }
                } catch (Throwable throwable) {
                    Log.e(TAG, "error", throwable);
                }
            }
        });
    }

    public void showEmpty(@Nullable String emptyMessage) {
        if (TextUtils.isEmpty(emptyMessage)) {
            tvTitle.setText("空空如也");
        } else {
            tvTitle.setText(emptyMessage);
        }
    }
}
