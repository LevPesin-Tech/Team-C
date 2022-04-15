package com.example.foundit;

import android.content.Context;
import android.content.Intent;
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

public class SampleRecViewAdapter extends RecyclerView.Adapter<SampleRecViewAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Product> products = new ArrayList<>();
    private NumberFormat format = NumberFormat.getCurrencyInstance();
    public SampleRecViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bookTitle.setText(products.get(position).getTitle());
        holder.bookAuthor.setText(products.get(position).getAuthor());
        holder.bookIsbn.setText(products.get(position).getIsbn());
        holder.bookSeller.setText(products.get(position).getSeller());
        holder.bookCondition.setText(products.get(position).getCondition());
        holder.bookPrice.setText(String.valueOf(format.format(products.get(position).getPrice())));
        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: connect to product page
                Intent i = new Intent(view.getContext(), TransactionActivity.class);
                view.getContext().startActivity(i);

            }
        });

        Glide.with(this.context).asBitmap().load(products.get(position).getImageUrl()).into(holder.bookImage);

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public void setProducts(ArrayList<Product> products){
        this.products = products;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView bookTitle,bookAuthor, bookIsbn, bookSeller, bookCondition, bookPrice;
        private CardView item;
        private ImageView bookImage;
        public ViewHolder(View itemView){
            super(itemView);
            bookTitle = itemView.findViewById(R.id.bookTitle);
            bookAuthor = itemView.findViewById(R.id.bookAuthor);
            bookIsbn = itemView.findViewById(R.id.ISBN);
            bookSeller = itemView.findViewById(R.id.seller);
            bookCondition = itemView.findViewById(R.id.condition);
            bookPrice = itemView.findViewById(R.id.price);
            item = itemView.findViewById(R.id.item);
            bookImage = itemView.findViewById(R.id.bookImage);
        }
    }
}
