package cn.jerry.views.componets;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.ViewGroup;

import cn.jerry.views.events.OnLoadNextPageListener;
import cn.jerry.views.statusview.R;
import cn.jerry.views.statusview.TestStatusView;

/**
 * 集成刷新，加载状态的 list view
 * Created by JieGuo on 2017/4/11.
 */

public class SwipeRecyclerViewWithStatusView extends CoordinatorLayout {

    protected TestStatusView statusView;
    protected SwipeRefreshLayout swipeRefreshLayout;
    protected RecyclerView recyclerView;
    protected OnLoadNextPageListener nextPageListener;

    public SwipeRecyclerViewWithStatusView(@NonNull Context context) {
        super(context);
        init(context);
    }

    public SwipeRecyclerViewWithStatusView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public SwipeRecyclerViewWithStatusView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    protected void init(Context context) {
        statusView = new TestStatusView(context);
        swipeRefreshLayout = new SwipeRefreshLayout(context);
        swipeRefreshLayout.setEnabled(false);
        recyclerView = new RecyclerView(context);
//        recyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener() {
//            @Override
//            public void onLoadNextPage(View view) {
//                if (nextPageListener != null) {
//                    nextPageListener.onLoadNextPage(view);
//                }
//            }
//        });

        swipeRefreshLayout.setColorSchemeResources(
                R.color.swipe_icon_red, R.color.swipe_icon_blue, R.color.swipe_icon_gray, R.color.swipe_icon_pink
        );
        initSwipeLayoutAndRecyclerView();
    }

    public void showLoading() {
        statusView.showLoading();
    }

    public void showEmpty(String emptyMessage) {
        statusView.showEmpty(emptyMessage);
    }

    public void showError(Throwable throwable) {
        statusView.showError(throwable);
    }

    public void finishLoading() {
        statusView.finishWithAnimation();
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        if (recyclerView.getLayoutManager() == null) {
            throw new RuntimeException("请先设置一个layoutManger");
        }
        recyclerView.setAdapter(adapter);
    }

    public void setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener refreshListener) {
        swipeRefreshLayout.setEnabled(true);
        swipeRefreshLayout.setOnRefreshListener(refreshListener);
        statusView.setOnRefreshListener(refreshListener);
    }

    public void finishRefresh() {
        swipeRefreshLayout.setRefreshing(false);
    }

    public boolean isSwipeLayoutRefreshing() {
        return swipeRefreshLayout.isRefreshing();
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        recyclerView.setLayoutManager(layoutManager);
    }

    public void setNextPageListener(OnLoadNextPageListener nextPageListener) {
        this.nextPageListener = nextPageListener;
    }

    public TestStatusView getStatusView() {
        return statusView;
    }

    public SwipeRefreshLayout getSwipeRefreshLayout() {
        return swipeRefreshLayout;
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    private void initSwipeLayoutAndRecyclerView() {
        swipeRefreshLayout.addView(recyclerView,
                new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                )
        );

        addView(swipeRefreshLayout, new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT
        ));

        addView(statusView, new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT
        ));
    }
}
