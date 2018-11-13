package rutul.com.ecampus.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import rutul.com.ecampus.R;
import rutul.com.ecampus.model.DashBoardIconModel;
import rutul.com.ecampus.utils.Constants;

public class DashBoardIconAdapter extends RecyclerView.Adapter<DashBoardIconAdapter.ViewHolder> {
    Context mContext;
    private List<DashBoardIconModel> itemList;

    private float width, height;

    private ItemClickListner itemClickListner;

    private Constants.SCREEN screen;

    public DashBoardIconAdapter(List<DashBoardIconModel> itemList, Context mContext) {
        this.itemList = itemList;
        this.mContext = mContext;
    }

    public  DashBoardIconAdapter(List<DashBoardIconModel> rowListItem, Context mContext, float width, float height, ItemClickListner itemClickListner) {
        this.itemList = rowListItem;
        this.mContext = mContext;
        this.width = width;
        this.height = height;
        this.itemClickListner = itemClickListner;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_grid_layout, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.tv_label.setText(itemList.get(position).getLabel());
        holder.iv_icons.setImageResource(itemList.get(position).getImage());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListner.actionRequest(itemList.get(position).getMypost(), position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

    public interface ItemClickListner {
        void actionRequest(Constants.SCREEN SCREEN, int position);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_label;
        private ImageView iv_icons;

        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setMinimumWidth((int) width);
            itemView.setMinimumHeight((int) height);

            tv_label = itemView.findViewById(R.id.tv_dash_label);
            iv_icons = itemView.findViewById(R.id.iv_dash_logo);
        }
    }
}
