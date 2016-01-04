package cn.jerry.example.jerryexamples;

import android.app.Activity;
import android.os.Bundle;
import cn.jerry.autoscroll.AutoScrollViewPager;
import cn.jerry.example.jerryexamples.adapter.PagerAdapter;

/**
 * Created by JieGuo on 15/12/18.
 */
public class ViewPagerActivity extends Activity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.view_pager);

    AutoScrollViewPager autoScrollViewPager = (AutoScrollViewPager) findViewById(R.id.viewPager);
    autoScrollViewPager.setAdapter(new PagerAdapter(this));
  }
}
