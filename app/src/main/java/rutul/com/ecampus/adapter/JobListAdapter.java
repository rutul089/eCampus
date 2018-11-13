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

public class JobListAdapter extends RecyclerView.Adapter<JobListAdapter.ViewHolder> {
    private Context mContext;
    private ItemCommentClickListener itemCommentClickListener;

    public JobListAdapter(Context mContext, ItemCommentClickListener itemCommentClickListener) {
        this.mContext = mContext;
        this.itemCommentClickListener = itemCommentClickListener;
    }


    @NonNull
    @Override
    public JobListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.row_job_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull JobListAdapter.ViewHolder viewHolder, int position) {
        viewHolder.itemView.setOnClickListener(view -> itemCommentClickListener.actionRequest(position));
    }

    @Override
    public int getItemCount() {
        return 12;
    }

    public interface ItemCommentClickListener {
        void actionRequest(int position);

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CustomTextView tv_job_heading,
                tv_company_name,
                tv_experience,
                tv_address;
        ImageView iv_placeholder;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_job_heading = itemView.findViewById(R.id.tv_job_heading);
            tv_company_name = itemView.findViewById(R.id.tv_company_name);
            tv_experience = itemView.findViewById(R.id.tv_experience);
            tv_address = itemView.findViewById(R.id.tv_address);
            iv_placeholder = itemView.findViewById(R.id.iv_placeholder);
        }
    }
}
