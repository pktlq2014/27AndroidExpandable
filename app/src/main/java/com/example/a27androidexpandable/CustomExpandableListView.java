package com.example.a27androidexpandable;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class CustomExpandableListView extends BaseExpandableListAdapter
{
    Context context;
    ArrayList<String> arrayList;
    HashMap<String, ArrayList<String>> hashMap;

    public CustomExpandableListView(Context context, ArrayList<String> arrayList, HashMap<String, ArrayList<String>> hashMap) {
        this.context = context;
        this.arrayList = arrayList;
        this.hashMap = hashMap;
    }

    @Override
    public int getGroupCount()
    {
        return arrayList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return hashMap.get(arrayList.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return arrayList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return hashMap.get(arrayList.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent)
    {
        String headerTitle = (String) getGroup(groupPosition);
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView  = layoutInflater.inflate(R.layout.group_view, null);
        TextView textView = convertView.findViewById(R.id.textViewHeader);
        textView.setText(headerTitle);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent)
    {
        String childTitle = (String) getChild(groupPosition, childPosition);
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView  = layoutInflater.inflate(R.layout.child_view, null);
        TextView textView = convertView.findViewById(R.id.textViewChild);
        textView.setText(childTitle);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
