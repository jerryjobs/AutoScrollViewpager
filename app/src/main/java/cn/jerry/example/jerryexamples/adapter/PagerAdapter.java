package cn.jerry.example.jerryexamples.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JieGuo on 15/12/18.
 */
public class PagerAdapter extends android.support.v4.view.PagerAdapter {

  private List<View> views = new ArrayList<>();

  public PagerAdapter(Context context) {

    for (int i = 0; i < getCount(); i++) {
      TextView view = new TextView(context);
      ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
          ViewGroup.LayoutParams.MATCH_PARENT);
      view.setLayoutParams(params);
      view.setBackgroundColor(Color.argb(100, getIntColor(), getIntColor(), getIntColor()));
      view.setGravity(Gravity.CENTER);
      view.setText(String.valueOf(i + 1));
      view.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
      views.add(view);
    }
  }

  @Override public int getCount() {
    return 5;
  }

  @Override public Object instantiateItem(ViewGroup container, int position) {

    container.addView(views.get(position));
    return views.get(position);
  }

  private int getIntColor() {
    return (int) (Math.random() * 255.0f);
  }

  @Override public boolean isViewFromObject(View view, Object object) {

    return view == object;
  }

  @Override public void destroyItem(ViewGroup container, int position, Object object) {
    container.removeView(views.get(position));
  }
}
