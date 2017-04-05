package cn.jerry.views.statusview;

import android.content.Context;
import android.os.Build;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.StyleRes;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by JieGuo on 2017/4/5.
 */

public class SampleStatusView extends StatusView {
    public SampleStatusView(@NonNull Context context) {
        super(context);
    }

    public SampleStatusView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SampleStatusView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public SampleStatusView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected int getContentResource() {
        return R.layout.view_status;
    }

    public void setTitle(String title) {
        TextView textView = (TextView) findViewById(R.id.tv_title);
        textView.setText(title);
    }
}
