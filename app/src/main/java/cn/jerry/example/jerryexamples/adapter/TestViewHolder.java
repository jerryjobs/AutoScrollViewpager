package cn.jerry.example.jerryexamples.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import cn.jerry.example.jerryexamples.R;

/**
 * Created by JieGuo on 15/12/16.
 */
public class TestViewHolder extends RecyclerView.ViewHolder {

  protected TextView title;

  public TestViewHolder(View itemView) {
    super(itemView);

    title = (TextView) itemView.findViewById(R.id.title);
  }
}
