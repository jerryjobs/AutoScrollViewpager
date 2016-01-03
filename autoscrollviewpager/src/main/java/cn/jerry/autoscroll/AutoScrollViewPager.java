package cn.jerry.autoscroll;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import cn.jerryjobs.viewpager.autoscroll.R;

/**
 * Created by JieGuo on 16/1/3.
 */
public class AutoScrollViewPager extends FrameLayout {

  private static final int sliderBarHeight = 60;

  private ViewPager viewPager;
  private SliderView sliderView;
  private int currentItem = 0;

  private int radius = 10;
  private int circleColor = 0xff000000;

  public void setRadius(int radius) {
    this.radius = radius;
  }

  public void setCircleColor(int circleColor) {
    this.circleColor = circleColor;
  }

  public AutoScrollViewPager(Context context) {
    super(context);
    init();
  }

  public AutoScrollViewPager(Context context, AttributeSet attrs) {
    super(context, attrs);
    init();
  }

  public AutoScrollViewPager(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();
  }

  @TargetApi(Build.VERSION_CODES.LOLLIPOP)
  public AutoScrollViewPager(Context context, AttributeSet attrs, int defStyleAttr,
      int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
    init();
  }

  private void init() {

    viewPager = new ViewPager(getContext());
    viewPager.setLayoutParams(getParam());
    addView(viewPager, 0);

    addView(getSlider(), 1);
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
    sliderView.setCircleColor(getResources().getColor(R.color.red));
    sliderView.setRadius(15);

    LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, sliderBarHeight);
    params.gravity = Gravity.BOTTOM | Gravity.CENTER;
    sliderView.setLayoutParams(params);
    return sliderView;
  }

  private void startTimer() {
    viewPager.postDelayed(new Runnable() {
      @Override public void run() {
        viewPager.setCurrentItem(currentItem % viewPager.getAdapter().getCount());
        currentItem += 1;
        startTimer();
      }
    }, 3000);
  }
}
