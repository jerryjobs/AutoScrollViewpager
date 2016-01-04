# AutoScrollViewpager

android auto scroll viewpager



use in layout like this:

    <cn.jerry.autoscroll.AutoScrollViewPager
            android:id="@+id/viewPager"
            android:layout_width="match_parent"
            android:layout_height="150dp"
            android:background="@android:color/white"
            app:circle_color="@color/red"
            app:circle_radius="8dp"/>


use in java code :

  
    AutoScrollViewPager autoScrollViewPager = (AutoScrollViewPager) findViewById(R.id.viewPager);
    autoScrollViewPager.setAdapter(new PagerAdapter(this));
    
    
    
#####ps:
 
* circle style is not supported
* current item highlight not supported
* etc ...



