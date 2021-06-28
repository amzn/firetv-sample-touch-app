package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RowAdapter rowAdapter;
    MenuItemsAdapter menuItemsAdapter;
    String[] rowDataSet ={"Movie 1","Movie 2", "Movie 3","Movie 4", "Movie 5","Movie 6","Movie 7", "Movie 8","Movie 9","Movie 10" };
    String[] menuitemsDataSet ={"Category 1","Category 2", "Category 3", "Category 4"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        //set the menu items

        RecyclerView recyclerViewMenu = findViewById(R.id.recyclerViewMenu);
        recyclerViewMenu.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL,false));
        menuItemsAdapter = new MenuItemsAdapter(menuitemsDataSet);
        recyclerViewMenu.setAdapter(menuItemsAdapter);


        //set the rows of content

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false));
        rowAdapter = new RowAdapter(rowDataSet);
        recyclerView.setAdapter(rowAdapter);

        RecyclerView recyclerView2 = findViewById(R.id.recyclerView2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false));
        rowAdapter = new RowAdapter(rowDataSet);
        recyclerView2.setAdapter(rowAdapter);

        RecyclerView recyclerView3 = findViewById(R.id.recyclerView3);
        recyclerView3.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false));
        rowAdapter = new RowAdapter(rowDataSet);
        recyclerView3.setAdapter(rowAdapter);

        RecyclerView recyclerView4 = findViewById(R.id.recyclerView4);
        recyclerView4.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false));
        rowAdapter = new RowAdapter(rowDataSet);
        recyclerView4.setAdapter(rowAdapter);


    }




    public class RowAdapter extends RecyclerView.Adapter<RowAdapter.ViewHolder> {

        private String[] localDataSet;

        /**
         * Provide a reference to the type of views that you are using
         * (custom ViewHolder).
         */
        public class ViewHolder extends RecyclerView.ViewHolder {
            private final TextView textView;
            private final ConstraintLayout cardConstraintLayout;

            public ViewHolder(View view) {
                super(view);
                // Define click listener for the ViewHolder's View
                textView = (TextView) view.findViewById(R.id.textView);
                cardConstraintLayout = view.findViewById(R.id.cardconstraintLayout);
            }

            public TextView getTextView() {
                return textView;
            }


            public ConstraintLayout getCardConstraintLayout() {
                return cardConstraintLayout;
            }
        }

        /**
         * Initialize the dataset of the Adapter.
         *
         * @param dataSet String[] containing the data to populate views to be used
         * by RecyclerView.
         */
        public RowAdapter(String[] dataSet) {
            localDataSet = dataSet;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            // Create a new view, which defines the UI of the list item
            View view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.cardlayout, viewGroup, false);

            return new ViewHolder(view);
        }



        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(ViewHolder viewHolder, final int position) {

            // Get element from your dataset at this position and replace the
            // contents of the view with that element
            viewHolder.getTextView().setText(localDataSet[position]);
            viewHolder.getCardConstraintLayout().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e("Click ", "Clicked "+localDataSet[position]);
                }
            });
        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return localDataSet.length;
        }
    }





    public class MenuItemsAdapter extends RecyclerView.Adapter<MenuItemsAdapter.ViewHolder> {

        private String[] localDataSet;

        /**
         * Provide a reference to the type of views that you are using
         * (custom ViewHolder).
         */
        public class ViewHolder extends RecyclerView.ViewHolder {
            private final TextView textView;
            private final ConstraintLayout menuConstraintLayout;

            public ViewHolder(View view) {
                super(view);
                // Define click listener for the ViewHolder's View
                textView = (TextView) view.findViewById(R.id.textView);
                menuConstraintLayout = view.findViewById(R.id.menuconstraintLayout);
            }

            public TextView getTextView() {
                return textView;
            }

            public ConstraintLayout getMenuConstraintLayout() {
                return menuConstraintLayout;
            }
        }

        /**
         * Initialize the dataset of the Adapter.
         *
         * @param dataSet String[] containing the data to populate views to be used
         * by RecyclerView.
         */
        public MenuItemsAdapter(String[] dataSet) {
            localDataSet = dataSet;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            // Create a new view, which defines the UI of the list item
            View view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.menulayout, viewGroup, false);

            return new ViewHolder(view);
        }



        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(ViewHolder viewHolder, final int position) {

            // Get element from your dataset at this position and replace the
            // contents of the view with that element
            viewHolder.getTextView().setText(localDataSet[position]);
            viewHolder.getMenuConstraintLayout().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e("Click ", "Clicked "+localDataSet[position]);
                }
            });
        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return localDataSet.length;
        }
    }


}