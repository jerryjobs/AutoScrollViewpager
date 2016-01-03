package cn.jerry.example.jerryexamples.adapter;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.jerry.example.jerryexamples.R;
import cn.jerry.example.jerryexamples.bean.User;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JieGuo on 15/12/16.
 */
public class TestAdapter extends RecyclerView.Adapter<TestViewHolder>
    implements View.OnClickListener {

  private List<User> users = new ArrayList<>();
  private int lastPosition = -1;

  public TestAdapter() {

    for (int i = 0; i < 100; i++) {
      User user = new User();
      user.id = i;
      user.name = "this is a test for : " + i;
      users.add(user);
    }
  }

  @Override public TestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.test_recycler_view_item, parent, false);

    return new TestViewHolder(view);
  }

  @Override public void onBindViewHolder(TestViewHolder holder, int position) {
    int color = Color.argb(255, getRandomValue(), getRandomValue(), getRandomValue());
    holder.itemView.setBackgroundColor(color);
    holder.itemView.setOnClickListener(this);
    holder.itemView.setTag(R.id.action0, holder);
    holder.title.setText(users.get(position).name);

    setAnimation(holder.itemView, position);
  }

  private void setAnimation(View itemView, int position) {
    if (position > lastPosition) {
      ObjectAnimator.ofFloat(itemView, "translationY", itemView.getMeasuredHeight(), 0.0f)
          .setDuration(500)
          .start();
      lastPosition = position;
    }
  }

  private int getRandomValue() {
    int value = (int) (Math.random() * 255);
    Log.e("TAG", "color value : " + value);
    return value;
  }

  @Override public int getItemCount() {
    return users.size();
  }

  @Override public void onClick(View v) {

    final TestViewHolder holder = (TestViewHolder) v.getTag(R.id.action0);
    //Toast.makeText(v.getContext(), "index : " + index, Toast.LENGTH_SHORT).show();

    //users.remove(holder.getItemId());
    ObjectAnimator animator = ObjectAnimator.ofFloat(v, "translationX", 0, v.getMeasuredWidth()).setDuration(
        500);
    animator.addListener(new Animator.AnimatorListener() {
      @Override public void onAnimationStart(Animator animation) {

      }

      @Override public void onAnimationEnd(Animator animation) {
        notifyItemRemoved(holder.getLayoutPosition());
      }

      @Override public void onAnimationCancel(Animator animation) {

      }

      @Override public void onAnimationRepeat(Animator animation) {

      }
    });
    animator.start();
  }
}
