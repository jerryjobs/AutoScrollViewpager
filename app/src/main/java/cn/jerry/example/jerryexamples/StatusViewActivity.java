package cn.jerry.example.jerryexamples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import cn.jerry.views.statusview.SampleStatusView;

/**
 * Created by JieGuo on 2017/4/5.
 */

public class StatusViewActivity extends AppCompatActivity {

    SampleStatusView sampleStatusView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_status_view);

        sampleStatusView = (SampleStatusView) findViewById(R.id.sample_status_view);
        sampleStatusView.setTitle("正在加载。");

        sampleStatusView.postDelayed(new Runnable() {
            @Override
            public void run() {
                sampleStatusView.finishWithAnimation();
            }
        }, 5000);
    }
}
