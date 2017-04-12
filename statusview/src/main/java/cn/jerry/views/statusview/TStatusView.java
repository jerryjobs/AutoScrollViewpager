package cn.jerry.views.statusview;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.StyleRes;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * 加载占位组件
 * <p>
 * Created by JieGuo on 2017/4/5.
 */

public class TStatusView extends StatusView {

    AppCompatTextView tvTitle;
    ImageView ivLoading;

    private SwipeRefreshLayout.OnRefreshListener onRefreshListener;

    public TStatusView(@NonNull Context context) {
        super(context);
    }

    public TStatusView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TStatusView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @SuppressWarnings("unused")
    public TStatusView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void init(Context context) {
        super.init(context);
        tvTitle = (AppCompatTextView) findViewById(R.id.tv_title);
        ivLoading = (ImageView) findViewById(R.id.iv_loading);
        if (!isInEditMode()) {
            setVisibility(GONE);
        } else {
            setVisibility(VISIBLE);
        }
        tvTitle.setText("正在努力加载……");
//        RxView.clicks(tvTitle)
//                .subscribe(o -> {
//                    if (onRefreshListener != null) {
//                        showLoading();
//                        onRefreshListener.onRefresh();
//                    }
//                }, throwable -> {
//                    Log.e("Error", "error", new Exception(throwable));
//                });
    }

    @Override
    protected int getContentResource() {
        return R.layout.view_tticar_statusview;
    }

    public void setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
        this.onRefreshListener = onRefreshListener;
    }

    @Override
    public void showError(Throwable throwable) {
        super.showError(throwable);
//        if (throwable instanceof HttpException) {
//            if (((HttpException) throwable).code() == 504) {
//
                showEmpty(R.drawable.ic_status_view_not_network, "没有网络连接");
//            } else {
//                showEmpty(R.drawable.ic_status_view_empty_data, "请求出错，请检查网络后重试");
//            }
//        } else {
//
//            showEmpty(R.drawable.ic_status_view_empty_data, "加载失败!");
//        }
    }

    public void showNetworkError() {
        showEmpty(R.drawable.ic_status_view_not_network, "没有网络连接");
    }

    @Override
    public void showLoading() {
        super.showLoading();
        ivLoading.setImageResource(R.drawable.frame_animation_loading);
        AnimationDrawable animationDrawable = (AnimationDrawable) ivLoading.getDrawable();
        animationDrawable.start();
        tvTitle.setText("正在加载……");
    }

    public void showEmpty(String text) {
        setAlpha(1);
        showEmpty(R.drawable.ic_status_view_empty_data, text);
    }

    public void showEmpty(int resource, String text) {
        setAlpha(1);
        setVisibility(VISIBLE);
        postInvalidate();
        ivLoading.setImageResource(resource);
        if (TextUtils.isEmpty(text)) {
            tvTitle.setText("空空如也!");
        } else {
            tvTitle.setText(text);
        }
    }

    public boolean isLoading() {
        return getVisibility() == VISIBLE;
    }
}
