package com.example.wsu.cs.drugsimpledic;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class ListviewAdapter extends BaseAdapter {

    ArrayList<Drug> drugList = new ArrayList<>();

    public void setList(ArrayList<Drug> list) {
        this.drugList = list;
    }
    @Override
    public int getCount() {
        return drugList.size();
    }

    @Override
    public Object getItem(int position) {
        return drugList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
