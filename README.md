# AutoScrollViewpager

android auto scroll viewpager



use in layout like this:

    <cn.jerry.autoscroll.AutoScrollViewPager
        android:id="@+id/viewPager"
        android:layout_width="match_parent"
        android:layout_height="150dp"
        android:background="@android:color/white"/>


use in java code :

  
    AutoScrollViewPager autoScrollViewPager = (AutoScrollViewPager) findViewById(R.id.viewPager);
    autoScrollViewPager.setAdapter(new PagerAdapter(this));
    
    // set circle radius
    autoScrollViewPager.setRadius(20);
    // set circle color
    autoScrollViewPager.setCircleColor(getResources().getColor(R.color.red));
    
    
    
#####ps:
 
* circle style is not supported
* current item highlight not supported
* jCenter not passed
* etc ...



