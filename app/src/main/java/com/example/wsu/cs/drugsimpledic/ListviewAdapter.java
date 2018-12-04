package com.example.wsu.cs.drugsimpledic;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListviewAdapter extends BaseAdapter {

    Context context;

    //받아 온 값은 해당 List에 저장한다.
    ArrayList<Drug> drugList = new ArrayList<>();

    public ListviewAdapter(Context context){
        this.context = context;
    }

    public void setList(ArrayList<Drug> list) {
        this.drugList = list;
    }
    @Override
    public int getCount() {
        return drugList.size();
    }

    @Override
    public Drug getItem(int position) {
        return drugList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        DrugLayout drugLayout;

        //강제사항
        if(convertView == null){
            drugLayout = new DrugLayout(context);
        } else {
            drugLayout = (DrugLayout) convertView;
        }
        //강제사항

        //받아온 값을 화면상에 출력하기 위해 넣어야 하며
        //몇번째 있는 값을 받아 올 지는 입력인자인 position이 결정해 준다.
        drugLayout.inflateName(drugList.get(position).getName());

        return drugLayout;
    }
}
