package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;
import java.util.ArrayList;


public class AddUserActivity extends AppCompatActivity {
    EditText mNameField;
    EditText mLocationField;
    EditText mAgeField;
    DatabaseReference databaseTest;
    private ArrayList<DataClass> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        Intent i = getIntent();

        mNameField = (EditText) findViewById(R.id.Name);
        mAgeField = (EditText) findViewById(R.id.Age);
        mLocationField = (EditText) findViewById(R.id.Location);

        databaseTest = FirebaseDatabase.getInstance().getReference();
        mData = (ArrayList<DataClass>) i.getSerializableExtra("List");
    }

    public void OnClickAddFunc(View view) {
        String name = mNameField.getText().toString();
        String ageS = mAgeField.getText().toString();
        int age = Integer.parseInt(ageS);
        String location = mLocationField.getText().toString();
        String id = databaseTest.push().getKey();

        DataClass newUser = new DataClass(id, name,age,location);
        databaseTest.child("users").setValue(newUser);
        mData.add(newUser);





//        Intent mIntent = new Intent(this, MainActivity.class);
//        mIntent.putExtra("List", (Serializable) mData);
//        startActivity(mIntent);
    }
}
