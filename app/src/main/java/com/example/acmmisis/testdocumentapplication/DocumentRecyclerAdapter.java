package com.example.acmmisis.testdocumentapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DocumentRecyclerAdapter extends RecyclerView.Adapter<DocumentRecyclerAdapter.ViewHolder> {
    private final List<DocumentData> documentDataList;
    private final Context context;
    private final LayoutInflater inflater;
    private final OnItemClickListener onItemClickListener;

    public DocumentRecyclerAdapter(Context context, List<DocumentData> documentDataList, OnItemClickListener onItemClickListener) {
        this.documentDataList = documentDataList;
        this.context = context;
        this.onItemClickListener = onItemClickListener;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public DocumentRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                inflater.inflate(R.layout.document_list_item, parent, false), onItemClickListener
        );

    }

    @Override
    public void onBindViewHolder(@NonNull DocumentRecyclerAdapter.ViewHolder holder, int position) {
        DocumentData documentData = documentDataList.get(position);
        holder.bind(documentDataList.get(position));
        holder.nameView.setText(documentData.getName());
        holder.avatarView.setImageBitmap(DocumentFragment.createRotatedBitmap(
                documentData.getImage(), documentData.getPath()));
    }

    @Override
    public int getItemCount() {
        return documentDataList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public final ImageView avatarView;
        public final TextView nameView;
        public String path;

        public ViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            avatarView = itemView.findViewById(R.id.document_item_image_view);
            nameView = itemView.findViewById(R.id.document_item_text);
            itemView.setOnClickListener(view -> {
                int position = getAdapterPosition();
                listener.onItemClick(path);
            });
        }

        public void bind(DocumentData documentData) {
            path = documentData.getPath();
        }
    }


    public interface OnItemClickListener {
        void onItemClick(String image);
    }
}
