package cn.jerry.autoscroll;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JieGuo on 16/1/3.
 */
public class SliderView extends View {

  private static Paint paint;
  private int radius = 10;
  private int count = 5;
  private int circleColor = 0xff000000;
  private int currentIndex = 0;

  public void setCurrentIndex(int currentIndex) {
    this.currentIndex = currentIndex;
  }

  public void setRadius(int radius) {
    this.radius = radius;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public void setCircleColor(int circleColor) {
    this.circleColor = circleColor;
  }

  public SliderView(Context context) {
    super(context);
  }

  public SliderView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public SliderView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @TargetApi(Build.VERSION_CODES.LOLLIPOP)
  public SliderView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
  }

  @Override protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    List<RectF> rectFs = getRectFs();
    for (int i = 0; i < rectFs.size(); i++) {

      RectF rectf = rectFs.get(i);
      if (i == currentIndex) {
        getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
      } else {
        getPaint().setStyle(Paint.Style.STROKE);
      }
        canvas.drawCircle(rectf.centerX(), rectf.centerY(), radius / 2, getPaint());
      //}
    }
  }

  private List<RectF> getRectFs() {
    List<RectF> rectFs = new ArrayList<>();

    int left, right, top, bottom;

    left = getPaddingLeft();
    right = getMeasuredWidth() - getPaddingRight();
    top = getMeasuredHeight() / 2 - radius;
    bottom = getMeasuredHeight() - getPaddingBottom();

    RectF circle =
        new RectF(right - radius * 2, bottom - radius * 2, right - radius, bottom - radius);

    circle.offset(-20, -5);

    for (int i = count -1; i >= 0; i--) {

      if (i == 0) {
        rectFs.add(circle);
      } else {
        RectF rectF = new RectF(circle);
        rectF.offset(-28 * i, 0);
        rectFs.add(rectF);
      }
    }

    return rectFs;
  }

  private Paint getPaint() {

    if (paint == null) {
      paint = new Paint();
      paint.setStyle(Paint.Style.STROKE);
      paint.setAntiAlias(true);
      paint.setColor(circleColor);
      paint.setStrokeWidth(2);
    }
    return paint;
  }
}
