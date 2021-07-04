package com.example.adminapp;

import android.content.Context;
import android.service.autofill.UserData;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    ArrayList<Userdata> list= new ArrayList<Userdata>();


    public MyAdapter(Context context, ArrayList<Userdata> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.item, parent,false);
       return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Userdata userdata = list.get(position);

        holder.nm.setText(userdata.getMname());
        holder.mobile.setText(String.valueOf(userdata.getMnumber()));
        holder.service.setText(userdata.getSpinner());
        //holder.rate.setText( userdata.getRating());
        holder.remark.setText(userdata.getMremarks());


    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nm,mobile,service,rate,remark;

         public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nm = itemView.findViewById(R.id.listname);
            mobile = itemView.findViewById(R.id.listmob);
            service = itemView.findViewById(R.id.listservice);
           // rate= itemView.findViewById(R.id.listrating);
            remark = itemView.findViewById(R.id.listremark);
        }
    }
}
