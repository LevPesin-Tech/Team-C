package com.example.foundit;

        import android.os.Bundle;

        import androidx.fragment.app.Fragment;
        import androidx.recyclerview.widget.GridLayoutManager;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;

        import java.lang.reflect.Array;
        import java.util.ArrayList;


public class SoldFragment extends Fragment {

    public SoldFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ArrayList<Product> products = new ArrayList<>();

        //TODO: add products from database to the arraylist for display
        //Sample code below. Uncomment to see output.
        /*
        products.add(new Product("title1","author1", "isbn1","seller1","condition1",12));
        products.add(new Product("title2","author2", "isbn2","seller2","condition2",30,"https://www.bookbaby.com/Images/textbook-thumb-ustrade.webp"));
        products.add(new Product("title3","author3", "isbn3","seller3","condition3",25,"https://www.apologia.com/wp-content/uploads/2021/01/GeneralSci3-Softcover.jpg"));
        products.add(new Product("title4","author4", "isbn4","seller4","condition4",31,"https://shop.aap.org/globalassets/inriver/resources/11212-NRP336_Paperback.png"));
        products.add(new Product("title5","author5", "isbn5","seller5","condition5",14,"https://cdn-tp2.mozu.com/16833-25855/cms/25855/files/30fe59d6-1a88-4ab7-9f08-832f5cdec8f2?max=350&quality=75&_mzcb=_1639638525565"));
        */
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_sold, container, false);
        RecyclerView soldView = view.findViewById(R.id.soldRecView);

        RecViewAdapter adapter = new RecViewAdapter(view.getContext());
        adapter.setProducts(products);

        soldView.setAdapter(adapter);
        soldView.setLayoutManager(new GridLayoutManager(this.getContext(), 2));
        return view;
    }

}