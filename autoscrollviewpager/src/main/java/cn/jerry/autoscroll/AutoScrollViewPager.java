package cn.jerry.autoscroll;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import cn.jerryjobs.viewpager.autoscroll.R;

/**
 * Created by JieGuo on 16/1/3.
 */
public class AutoScrollViewPager extends FrameLayout {

  private static final int sliderBarHeight = 60;
  private static final String TAG = "AutoScroll";

  private ViewPager viewPager;
  private SliderView sliderView;
  private int currentItem = 0;

  private boolean isPressing = false;

  private int radius = 10;
  private int circleColor = 0xFF000000;

  public AutoScrollViewPager(Context context) {
    super(context);
    init();
  }

  public AutoScrollViewPager(Context context, AttributeSet attrs) {
    super(context, attrs);
    setAttrs(attrs);
    init();
  }

  public AutoScrollViewPager(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    setAttrs(attrs);
    init();
  }

  @TargetApi(Build.VERSION_CODES.LOLLIPOP)
  public AutoScrollViewPager(Context context, AttributeSet attrs, int defStyleAttr,
      int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);

    setAttrs(attrs);
    init();
  }

  private void setAttrs(AttributeSet attrs) {
    TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.AutoScrollViewPager);
    circleColor = a.getColor(R.styleable.AutoScrollViewPager_circle_color, 0xff000000);
    radius = a.getDimensionPixelOffset(R.styleable.AutoScrollViewPager_circle_radius, 5);
  }

  private void init() {

    viewPager = new ViewPager(getContext());
    viewPager.setLayoutParams(getParam());
    addView(viewPager, 0);

    addView(getSlider(), 1);

    viewPager.setOnTouchListener(new OnTouchListener() {
      @Override public boolean onTouch(View v, MotionEvent event) {

        switch (event.getAction()) {

          case MotionEvent.ACTION_DOWN:
            isPressing = true;
            break;

          case MotionEvent.ACTION_CANCEL:
          case MotionEvent.ACTION_UP:
            isPressing = false;
            break;
        }

        return false;
      }
    });
  }

  private LayoutParams getParam() {
    LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.MATCH_PARENT);
    return layoutParams;
  }

  public void setAdapter(PagerAdapter adapter) {
    viewPager.setAdapter(adapter);
    sliderView.setCount(adapter.getCount());
    currentItem = viewPager.getAdapter().getCount();
    startTimer();
  }

  public void setAdapter(FragmentPagerAdapter adapter) {
    viewPager.setAdapter(adapter);
    sliderView.setCount(adapter.getCount());
  }

  private SliderView getSlider() {
    sliderView = new SliderView(getContext());
    sliderView.setCircleColor(circleColor);
    sliderView.setRadius(radius);

    LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, sliderBarHeight);
    params.gravity = Gravity.BOTTOM | Gravity.CENTER;
    sliderView.setLayoutParams(params);
    return sliderView;
  }

  private void startTimer() {
    viewPager.postDelayed(new Runnable() {
      @Override public void run() {
        if (!isPressing) {
          viewPager.setCurrentItem(currentItem % viewPager.getAdapter().getCount());
          currentItem += 1;

          sliderView.setCurrentIndex(currentItem % viewPager.getAdapter().getCount());
          sliderView.invalidate();
        }
        startTimer();
      }
    }, 3000);
  }
}
