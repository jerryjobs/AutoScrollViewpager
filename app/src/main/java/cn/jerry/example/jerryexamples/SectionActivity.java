package cn.jerry.example.jerryexamples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import cn.jerry.example.jerryexamples.adapter.SectionAdapter;
import cn.jerry.example.jerryexamples.bean.Section;
import cn.jerry.views.componets.SwipeRecyclerViewWithStatusView;

/**
 *
 * Created by JieGuo on 2017/4/17.
 */

public class SectionActivity extends AppCompatActivity {


    private SwipeRecyclerViewWithStatusView swipeRecyclerViewWithStatusView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_section);

        swipeRecyclerViewWithStatusView =
                (SwipeRecyclerViewWithStatusView) findViewById(R.id.swipe_status_view);

        swipeRecyclerViewWithStatusView.showLoading();

        swipeRecyclerViewWithStatusView.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeRecyclerViewWithStatusView.finishLoading();
            }
        }, 3000);

        SectionAdapter adapter = new SectionAdapter(this);
        swipeRecyclerViewWithStatusView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        swipeRecyclerViewWithStatusView.setAdapter(adapter);
        adapter.getSections().addAll(getSections());
        adapter.notifyDataSetChanged();

        swipeRecyclerViewWithStatusView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRecyclerViewWithStatusView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRecyclerViewWithStatusView.finishRefresh();
                    }
                }, 2000);
            }
        });
    }

    private List<Section> getSections() {
        List<Section> sections = new ArrayList<>();

        sections.add(new Section("", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1492429073461&di=05ebbbb937792f7e1d82d5c9ce01be2c&imgtype=0&src=http%3A%2F%2Fimg01.jituwang.com%2F160526%2F257701-1605260R03163.jpg"));
        sections.add(new Section("", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1492429073461&di=49588fb5327456a03907657d0e37b23f&imgtype=0&src=http%3A%2F%2Fimg5.duitang.com%2Fuploads%2Fitem%2F201510%2F08%2F20151008142500_5iF3w.thumb.700_0.jpeg"));
        sections.add(new Section("", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1492429073460&di=6e6e85ddd7779d99653d1070013a3931&imgtype=0&src=http%3A%2F%2Fimg4.duitang.com%2Fuploads%2Fitem%2F201408%2F28%2F20140828201115_tH3fr.thumb.700_0.png"));
        sections.add(new Section("", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1492429073460&di=781283fc0832a467d8be183f015dd39b&imgtype=0&src=http%3A%2F%2Fimg3.duitang.com%2Fuploads%2Fitem%2F201408%2F02%2F20140802163013_r2nPC.thumb.700_0.jpeg"));
        sections.add(new Section("", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1492429073460&di=781283fc0832a467d8be183f015dd39b&imgtype=0&src=http%3A%2F%2Fimg3.duitang.com%2Fuploads%2Fitem%2F201408%2F02%2F20140802163013_r2nPC.thumb.700_0.jpeg"));
        sections.add(new Section("", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1492429073460&di=992d6ed406cd68bd693713dc69cf7ab3&imgtype=0&src=http%3A%2F%2Fpic118.nipic.com%2Ffile%2F20161217%2F13057068_202302992000_2.jpg"));
        sections.add(new Section("", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1492429073460&di=0d19bb012b9241d37a9059fa5c39342a&imgtype=0&src=http%3A%2F%2Fscimg.158sucai.com%2Fallimg%2F140508%2F10-14050Q43TRQ.jpg"));
        sections.add(new Section("", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1492429073460&di=6ccf55c63a30809ffb176e508684fae4&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F17%2F16%2F41%2F06G58PICfVz_1024.jpg"));
        sections.add(new Section("", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1492429073460&di=95b7a13ab0f09212bf63e4a06375b184&imgtype=0&src=http%3A%2F%2Fdl.bizhi.sogou.com%2Fimages%2F2013%2F11%2F21%2F415675.jpg"));
        sections.add(new Section("", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1492429073460&di=08513a95f41d04489446c2f73a0f5add&imgtype=0&src=http%3A%2F%2Ffile06.16sucai.com%2F2016%2F0303%2F6b7f7a3c5ccbe9900094add1d8b5cbc8.jpg"));
        sections.add(new Section("", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1492429073460&di=0e3a2aaebd5a20f2a6aad66e05509f26&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F11%2F16%2F02%2F32H58PICPre.jpg"));
        sections.add(new Section("", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1492429073459&di=42fe7936e00f8dd04f8f18dd3fbce957&imgtype=0&src=http%3A%2F%2Fcdn.duitang.com%2Fuploads%2Fitem%2F201508%2F04%2F20150804050438_CPnQu.jpeg"));
        return sections;
    }
}
