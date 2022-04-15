package com.example.foundit;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.text.NumberFormat;
import java.util.ArrayList;

public class RecViewAdapterHorizontal extends RecyclerView.Adapter<RecViewAdapterHorizontal.ViewHolder> {
    private Context context;
    //private ArrayList<Product> products = new ArrayList<>();
    private Product product;
    private NumberFormat format = NumberFormat.getCurrencyInstance();
    public RecViewAdapterHorizontal(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_horizontal_layout, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bookTitle.setText(product.getTitle());
        holder.bookAuthor.setText(product.getAuthor());
        holder.bookIsbn.setText(product.getIsbn());
        holder.bookSeller.setText(product.getSeller());
        holder.bookCondition.setText(product.getCondition());
        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: fill out what would happen if clicked on a book
            }
        });

        Glide.with(this.context).asBitmap().load(product.getImageUrl()).into(holder.bookImage);

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public void setProduct(Product product){
        this.product = product;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView bookTitle,bookAuthor, bookIsbn, bookSeller, bookCondition;
        private CardView item;
        private ImageView bookImage;
        public ViewHolder(View itemView){
            super(itemView);
            bookTitle = itemView.findViewById(R.id.bookTitle);
            bookAuthor = itemView.findViewById(R.id.bookAuthor);
            bookIsbn = itemView.findViewById(R.id.ISBN);
            bookSeller = itemView.findViewById(R.id.seller);
            bookCondition = itemView.findViewById(R.id.condition);
            //bookPrice = itemView.findViewById(R.id.price);
            item = itemView.findViewById(R.id.item);
            bookImage = itemView.findViewById(R.id.bookImage);
        }
    }
}
