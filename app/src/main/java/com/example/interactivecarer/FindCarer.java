package com.example.interactivecarer;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FindCarer extends AppCompatActivity {

    DatabaseHelperC dbcc;

    ListView carerList;

    ArrayList<String> listItem;
    ArrayAdapter adapter;

    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_carer);

        dbcc = new DatabaseHelperC(this);
        listItem = new ArrayList<>();
        carerList = findViewById(R.id.carer_list);

        viewData();
        carerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long ID) {
                String text = carerList.getItemAtPosition(i).toString();
                Toast.makeText(FindCarer.this,""+text,Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void viewData() {
        Cursor cursor =dbcc.viewData();

        if (cursor.getCount() == 0){
            Toast.makeText(this,"No Data",Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()){
                listItem.add(cursor.getString(1)+ cursor.getString(2));

            }

            adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listItem);
            carerList.setAdapter(adapter);
        }

    }
}
