package com.desgin.srdz.desgindemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by SRDZ on 2016/7/8.
 */
public class MyRecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<String> listl;

    public MyRecycleAdapter(Context context, List<String> listl) {
        this.context = context;
        this.listl = listl;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView tv = new TextView(context);
        return new RecyclerView.ViewHolder(tv){ };
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((TextView)holder.itemView).setText(listl.get(position));
    }

    @Override
    public int getItemCount() {
        return listl.size();
    }
}
