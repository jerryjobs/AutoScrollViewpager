package cn.jerry.example.jerryexamples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import cn.jerry.views.statusview.SampleStatusView;
import cn.jerry.views.statusview.TStatusView;

/**
 * Created by JieGuo on 2017/4/5.
 */

public class StatusViewActivity extends AppCompatActivity {

    TStatusView sampleStatusView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_status_view);

        sampleStatusView = (TStatusView) findViewById(R.id.sample_status_view);

        showLoadingStatus();
    }

    public void showLoadingStatus() {
        sampleStatusView.showLoading();
        sampleStatusView.postDelayed(new Runnable() {
            @Override
            public void run() {
                sampleStatusView.finishWithAnimation();
                sampleStatusView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        showEmptyStatus();
                    }
                }, 2000);
            }
        }, 5000);
    }


    public void showEmptyStatus() {

        sampleStatusView.showEmpty(null);
        sampleStatusView.postDelayed(new Runnable() {
            @Override
            public void run() {
                showErrorStatus();
            }
        }, 5000);
    }

    public void showErrorStatus() {
        sampleStatusView.showError(new Throwable("加载出错"));
        sampleStatusView.postDelayed(new Runnable() {
            @Override
            public void run() {
                showLoadingStatus();
            }
        }, 5000);
    }
}
