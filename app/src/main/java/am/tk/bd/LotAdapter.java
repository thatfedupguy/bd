package am.tk.bd;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class LotAdapter extends RecyclerView.Adapter<LotAdapter.LotViewHolder> {
    ArrayList<Lot> lots;

    public LotAdapter(ArrayList<Lot> lots) {
        this.lots = lots;
    }

    @NonNull
    @Override
    public LotViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater li = (LayoutInflater) viewGroup.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = li.inflate(R.layout.list_lots, viewGroup, false);

        return new LotViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(LotViewHolder viewHolder, int i) {
        Lot lot = lots.get(i);
        viewHolder.tv.setText(lot.left);
        viewHolder.et.setText(lot.right);

    }

    @Override
    public int getItemCount() {
        return lots.size();
    }
    class LotViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        EditText et;
        public LotViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
            et = itemView.findViewById(R.id.et);

        }
    }
}
