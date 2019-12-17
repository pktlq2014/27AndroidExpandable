package com.example.a27androidexpandable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity
{
    ExpandableListView expandableListView;
    ArrayList<String> arrayList;
    HashMap<String, ArrayList<String>> hashMap;
    CustomExpandableListView customExpandableListView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        customExpandableListView = new CustomExpandableListView(MainActivity.this, arrayList, hashMap);
        expandableListView.setAdapter(customExpandableListView);
        customExpandableListView.notifyDataSetChanged();
    }

    private void addControl()
    {
        expandableListView = findViewById(R.id.expandableListView);
        arrayList = new ArrayList<>();
        hashMap = new HashMap<String, ArrayList<String>>();

        arrayList.add("Phim Tháng 10");
        arrayList.add("Phim Tháng 11");
        arrayList.add("Phim Tháng 12");

        ArrayList<String> phimThang10 = new ArrayList<String>();
        phimThang10.add("AAA");
        phimThang10.add("AAA");
        phimThang10.add("AAA");
        phimThang10.add("AAA");

        ArrayList<String> phimThang11 = new ArrayList<String>();
        phimThang11.add("BBB");
        phimThang11.add("BBB");
        phimThang11.add("BBB");
        phimThang11.add("BBB");

        ArrayList<String> phimThang12 = new ArrayList<String>();
        phimThang12.add("CCC");
        phimThang12.add("CCC");
        phimThang12.add("CCC");
        phimThang12.add("CCC");

        hashMap.put(arrayList.get(0),  phimThang10);
        hashMap.put(arrayList.get(1),  phimThang11);
        hashMap.put(arrayList.get(2),  phimThang12);
    }

}
