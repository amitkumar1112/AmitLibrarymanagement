package com.example.amitlibrarymanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {
    Context context;
    ArrayList<infosignup> infolist;
    Adapter(Context context,ArrayList<infosignup>infolist){
        this.context = context;
        this.infolist = infolist;
    }
    @Override
    public int getCount() {
        return infolist.size();
    }

    @Override
    public Object getItem(int position) {
        return infolist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup parent) {
        if(convertview == null){
            LayoutInflater.from(context).inflate(R.layout.activity_signupuser,parent,false);

            infosignup currentinfo = (infosignup)getItem(position);
            TextView nameview = convertview.findViewById(R.id.tv1);
            TextView emailview = convertview.findViewById(R.id.tv2);
            TextView phoneview = convertview.findViewById(R.id.tv3);
            TextView passwordview = convertview.findViewById(R.id.tv4);
            TextView confirmpassview = convertview.findViewById(R.id.tv5);

            nameview.setText(currentinfo.getName());
            emailview.setText(currentinfo.getEmail());
            phoneview.setText(currentinfo.getPhone());
            passwordview.setText(currentinfo.getPassword());
            confirmpassview.setText(currentinfo.getConfirmpass());
        }
        return convertview;
    }
}
