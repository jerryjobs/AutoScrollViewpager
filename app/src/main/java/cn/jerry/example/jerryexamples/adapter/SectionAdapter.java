package cn.jerry.example.jerryexamples.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import cn.jerry.example.jerryexamples.R;
import cn.jerry.example.jerryexamples.bean.Section;


/**
 * Created by JieGuo on 2017/4/17.
 */

public class SectionAdapter extends RecyclerView.Adapter<SectionAdapter.SectionViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    private List<Section> sections = new ArrayList<>();

    public SectionAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public List<Section> getSections() {
        return sections;
    }

    @Override
    public SectionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item_section, parent, false);
        return new SectionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SectionViewHolder holder, int position) {
        Glide.with(context)
                .load(sections.get(position).image)
                .centerCrop()
                .into(holder.ivImage);
    }

    @Override
    public int getItemCount() {
        return sections.size();
    }

    public static class SectionViewHolder extends RecyclerView.ViewHolder {

        ImageView ivImage;

        public SectionViewHolder(View itemView) {
            super(itemView);
            ivImage = (ImageView) itemView.findViewById(R.id.iv_image);
        }
    }
}
