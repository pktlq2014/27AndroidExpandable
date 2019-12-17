package com.example.a27androidexpandable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

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

        click_Group();
        click_Child();
        // sự kiện đóng
        close_Group();
        // sự kiện mở
        open_Group();
    }

    private void click_Child()
    {
       expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener()
       {
           @Override
           public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id)
           {
               Toast.makeText(MainActivity.this, hashMap.get(arrayList.get(groupPosition)).get(childPosition), Toast.LENGTH_SHORT).show();
               return false;
           }
       });
    }

    private void open_Group()
    {
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener()
        {
            @Override
            public void onGroupExpand(int groupPosition)
            {
                Toast.makeText(MainActivity.this, arrayList.get(groupPosition) + " Mở", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void close_Group()
    {
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener()
        {
            @Override
            public void onGroupCollapse(int groupPosition)
            {
                Toast.makeText(MainActivity.this, arrayList.get(groupPosition) + " Đóng", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void click_Group()
    {
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener()
        {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id)
            {
                expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener()
                {
                    @Override
                    public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id)
                    {
                        Toast.makeText(MainActivity.this, arrayList.get(groupPosition), Toast.LENGTH_SHORT).show();
                        return false;
                    }
                });
                return false;
            }
        });
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
