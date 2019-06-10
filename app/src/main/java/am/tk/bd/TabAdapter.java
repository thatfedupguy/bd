package am.tk.bd;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class TabAdapter extends RecyclerView.Adapter<TabAdapter.TabViewHolder> {
    ArrayList<Tab> tabs;

    public TabAdapter(ArrayList<Tab> tabs) {
        this.tabs = tabs;
    }

    @NonNull
    @Override
    public TabViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater li = (LayoutInflater) viewGroup.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_tabs, viewGroup, false);

        return new TabViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TabViewHolder tabViewHolder, int i) {
        Tab tab = tabs.get(i);
        tabViewHolder.tv_tab.setText(tab.getName());
        tabViewHolder.iv_tab.setImageResource(tab.getId());
    }

    @Override
    public int getItemCount() {
        return tabs.size();
    }

    class TabViewHolder extends RecyclerView.ViewHolder {
        TextView tv_tab;
        ImageView iv_tab;
        public TabViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_tab = itemView.findViewById(R.id.tv_tab);
            iv_tab = itemView.findViewById(R.id.iv_tab);
        }
    }
}
