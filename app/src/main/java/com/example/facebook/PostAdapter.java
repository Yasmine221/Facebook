package com.example.facebook;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder> {

    private List<PostData> data;

    public PostAdapter(List<PostData> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item,parent,false);
        return new PostHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {

        PostData postData = data.get(position);

        holder.user_name.setText(postData.getUserName());
        holder.post_txt.setText(postData.getPostText());
        holder.post_img.setImageResource(postData.getPostImage());
        holder.user_img.setImageResource(postData.getUserImage());
    }

    @Override
    public int getItemCount() {
        if (data != null)
            return data.size();
        else
            return 0;
    }

    static class PostHolder extends RecyclerView.ViewHolder {

        CircleImageView user_img;
        ImageView post_img;
        TextView user_name;
        TextView post_txt;

        public PostHolder(@NonNull View itemView) {
            super(itemView);

            user_img = itemView.findViewById(R.id.img_item);
            user_name = itemView.findViewById(R.id.user_name);
            post_img = itemView.findViewById(R.id.img_post);
            post_txt = itemView.findViewById(R.id.post_txt);

        }
    }
}
