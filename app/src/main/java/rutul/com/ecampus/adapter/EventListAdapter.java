package rutul.com.ecampus.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import rutul.com.ecampus.R;
import rutul.com.ecampus.components.CustomTextView;

public class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.ViewHolder> {
    private Context mContext;
    private ItemCommentClickListener itemCommentClickListener;

    public EventListAdapter(Context mContext, ItemCommentClickListener itemCommentClickListener) {
        this.mContext = mContext;
        this.itemCommentClickListener = itemCommentClickListener;
    }


    @NonNull
    @Override
    public EventListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.row_event_news, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull EventListAdapter.ViewHolder viewHolder, int position) {
        viewHolder.itemView.setOnClickListener(view -> itemCommentClickListener.actionRequest(position));
        viewHolder.tv_date.setText("11 Aug 2018");
        viewHolder.tv_description.setText("Labore irure excepteur deserunt qui. Occaecat do consequat velit adipisicing consequat reprehenderit incididunt duis irure ea consequat ipsum Lorem dolor");
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    public interface ItemCommentClickListener {
        void actionRequest(int position);

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_slider_img;
        CustomTextView tv_date,
                tv_description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_slider_img = itemView.findViewById(R.id.iv_slider_img);
            tv_date = itemView.findViewById(R.id.tv_date);
            tv_description = itemView.findViewById(R.id.tv_description);
        }
    }
}
