package com.example.test;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private ArrayList<DataClass> mData;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        TextView mField1TextView;
        TextView mField2TextView;
        TextView mIndexTextView;

        MyViewHolder(@NonNull LinearLayout pLinearLayout) {
            super(pLinearLayout);
            mField1TextView = pLinearLayout.findViewById(R.id.field1_text_view);
            mField2TextView = pLinearLayout.findViewById(R.id.field2_text_view);
            mIndexTextView = pLinearLayout.findViewById(R.id.index_text_view);
        }

        void setIndexText(String pString) {
            mIndexTextView.setText(pString);
        }

        void setField1Text(String pString)
        {
            mField1TextView.setText(pString);
        }

        void setField2Text(String pString)
        {
            mField2TextView.setText(pString);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(ArrayList<DataClass> data)
    {
        this.mData = data;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view_layout, parent, false);
        MyViewHolder vh = new MyViewHolder(linearLayout);

        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        DataClass data = mData.get(position);

        holder.setIndexText("Index " + Integer.toString(position));
        holder.setField1Text(data.getName());
        holder.setField2Text(data.getLocation());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mData.size();
    }
}
