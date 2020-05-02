package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private static final int toastLength = Toast.LENGTH_SHORT;

    private ArrayList<DataClass> mData = new ArrayList<DataClass>();

    DatabaseReference databaseTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseTest = FirebaseDatabase.getInstance().getReference("Users");

        for (int i = 0; i < 5; i++) {
            mData.add(new DataClass());
        }



        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(mData);
        recyclerView.setAdapter(mAdapter);

        recyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
    }

    public void onClickAddItem(View view) {
        String debugMsg = "go to add user";
        Log.d(this.getClass().getSimpleName(), debugMsg);
        Toast.makeText(this, debugMsg, toastLength).show();

        Intent mIntent = new Intent(this, AddUserActivity.class);
        mIntent.putExtra("List", (Serializable) mData);
        startActivity(mIntent);
        mAdapter.notifyDataSetChanged();
    }




//    public void onClickRandomize(View view) {
//        int index = mRandom.nextInt(mData.size());
//        String field1 = Integer.toString(mRandom.nextInt(100000));
//        String field2 = Integer.toString(mRandom.nextInt(100000));
//
//        String debugMsg = "Set item " + index + " value to " + field1 + ", " + field2;
//        Log.d(this.getClass().getSimpleName(), debugMsg);
//        Toast.makeText(this, debugMsg, toastLength).show();
//
//        DataClass data = mData.get(index);
//        data.setName(field1);
//        data.setLocation(field2);
//        mAdapter.notifyDataSetChanged();
//    }
//

//
//    public void onClickRemoveRandom(View view) {
//        int index = mRandom.nextInt(mData.size());
//
//        String debugMsg = "Removed item " + index;
//        Log.d(this.getClass().getSimpleName(), debugMsg);
//        Toast.makeText(this, debugMsg, toastLength).show();
//
//        removeData(index);
//    }
//
//
//    private void removeData(int pIndex)
//    {
//        if (mData.size() > 1) {
//            mData.remove(pIndex);
//            recyclerView.removeViewAt(pIndex);
//            mAdapter.notifyItemRemoved(pIndex);
//            mAdapter.notifyItemRangeChanged(pIndex, mData.size());
//        }
//    }
}
