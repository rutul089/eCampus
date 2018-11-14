package rutul.com.ecampus.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import rutul.com.ecampus.R;
import rutul.com.ecampus.components.CustomTextView;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {
    private Context mContext;
    private ItemCommentClickListener itemCommentClickListener;

    public NotificationAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public NotificationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.row_notification, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationAdapter.ViewHolder viewHolder, int position) {
        viewHolder.itemView.setOnClickListener(view -> itemCommentClickListener.actionRequest(position));
        viewHolder.tv_date.setText("11 Aug 2018");
        viewHolder.tv_label.setText("Dummy Label");
        viewHolder.tv_message.setText("Labore irure excepteur deserunt qui. Occaecat do consequat velit adipisicing consequat reprehenderit incididunt duis irure ea consequat ipsum Lorem dolor");
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    public interface ItemCommentClickListener {
        void actionRequest(int position);

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CustomTextView tv_date, tv_message,
                tv_label;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_label = itemView.findViewById(R.id.tv_label);
            tv_date = itemView.findViewById(R.id.tv_date);
            tv_message = itemView.findViewById(R.id.tv_message);
        }
    }
}
