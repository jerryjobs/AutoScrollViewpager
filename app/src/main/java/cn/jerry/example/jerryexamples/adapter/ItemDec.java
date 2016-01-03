package cn.jerry.example.jerryexamples.adapter;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by JieGuo on 15/12/16.
 */
public class ItemDec extends RecyclerView.ItemDecoration {

  private Paint paint;
  private int decoraterSize = 20;

  public ItemDec() {
    paint = new Paint();
    paint.setStyle(Paint.Style.FILL);
    paint.setColor(Color.parseColor("red"));
    paint.setAntiAlias(true);
  }

  @Override public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {

    int left, right, top, bottom;

    left = parent.getPaddingLeft();
    right = parent.getMeasuredWidth() - parent.getPaddingRight();

    for (int i = 0; i < parent.getChildCount(); i++) {

      View child = parent.getChildAt(i);
      RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
      top = child.getBottom() + params.bottomMargin;
      bottom = top + decoraterSize;
      c.drawRect(left, top, right, bottom, paint);
    }
    //super.onDrawOver(c, parent, state);
  }

  @Override public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
      RecyclerView.State state) {

    int left, right, top, bottom;
    left = view.getPaddingLeft() + view.getRight();
    right = view.getPaddingRight() + view.getRight() + view.getMeasuredWidth();
    top = view.getPaddingTop();
    bottom = view.getMeasuredHeight() + 100;
    outRect.set(left, top, right, bottom);
    super.getItemOffsets(outRect, view, parent, state);
  }
}
