package com.example.dell.endterm;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>

{
         Context context;
         List<Information> mdata ;

    public RecyclerViewAdapter(Context context, List<Information> mdata) {
             this.context = context;
             this.mdata = mdata;
    }
      public class MyViewHolder extends RecyclerView.ViewHolder
          {

              TextView tv_name;
              TextView tv_phone;
              ImageView image;

              public MyViewHolder(View itemView) {
                  super(itemView);
                  tv_name= itemView.findViewById(R.id.name_donnor);
                  tv_phone=itemView.findViewById(R.id.contactno);
                  image=itemView.findViewById(R.id.donnor_id);
              }
          }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
           View v;
           v= LayoutInflater.from(context).inflate(R.layout.peoplelist,parent,false);
           MyViewHolder vholder =new MyViewHolder(v);
             return vholder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
      holder.tv_name.setText(mdata.get(position).getName());
      holder.tv_phone.setText(mdata.get(position).getPhone());
      holder.image.setImageResource(mdata.get(position).getPhoto());

    }

    @Override
    public int getItemCount()
     {
         mdata =new ArrayList<>();
        return mdata.size();
    }




}
