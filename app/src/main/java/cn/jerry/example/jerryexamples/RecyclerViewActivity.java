package cn.jerry.example.jerryexamples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import cn.jerry.example.jerryexamples.adapter.TestAdapter;

public class RecyclerViewActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_recycler_view);

    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

    RecyclerView.LayoutManager manager =
        new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
    recyclerView.setLayoutManager(manager);
    recyclerView.setAdapter(new TestAdapter());
    //recyclerView.addItemDecoration(new ItemDec());
    //recyclerView.setItemAnimator(new RecyclerItemAnimator());
  }
}
