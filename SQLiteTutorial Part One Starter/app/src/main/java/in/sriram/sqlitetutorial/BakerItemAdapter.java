package in.sriram.sqlitetutorial;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import in.sriram.sqlitetutorial.model.BakerItem;

public class BakerItemAdapter extends RecyclerView.Adapter<BakerItemAdapter.ViewHolder> {

    private Context context;
    private List<BakerItem> bakerItems;
    private BakerItemListener mListener;

    public BakerItemAdapter(Context context, BakerItemListener listener) {
        this.context = context;
        bakerItems = new ArrayList<>();
        mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_baker, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BakerItem item = bakerItems.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return bakerItems.size();
    }

    public void addItems(List<BakerItem> items) {
        this.bakerItems = items;
        notifyDataSetChanged();
    }

    public interface BakerItemListener {
        void onItemClicked(BakerItem item);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_item_title, tv_item_cost, tv_item_time;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_item_title = itemView.findViewById(R.id.tv_item_title);
            tv_item_cost = itemView.findViewById(R.id.tv_item_cost);
            tv_item_time = itemView.findViewById(R.id.tv_item_time);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.onItemClicked(bakerItems.get(getAdapterPosition()));
                }
            });
        }

        public void bind(BakerItem item) {
            tv_item_title.setText(item.getTitle());
            tv_item_time.setText(item.getTime());
            tv_item_cost.setText(item.getCost());
        }
    }
}
