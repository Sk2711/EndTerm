package com.example.dell.endterm;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.annotation.Nullable;

import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Tab extends Fragment {


    View v;
    RecyclerViewAdapter recyclerViewAdapter;
    RecyclerView mrecyclerView;
    List<Information> information ;

    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.findpeople, container, false);
        mrecyclerView = v.findViewById(R.id.fndpeople);

        recyclerViewAdapter = new RecyclerViewAdapter(getContext(),information);
        mrecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
       // RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
       // mrecyclerView.setLayoutManager(layoutManager);
        mrecyclerView.setAdapter(recyclerViewAdapter);
        setData();
        return v;

    }

    public void setData() {
        information= new ArrayList<>();
        information.add(new Information("Gayatri Trivedi", "8564249894", R.drawable.maa));
        information.add(new Information("Mitali Singh", "898562458", R.drawable.mitali));
        information.add(new Information("Ujjwal Kaur", "898479516", R.drawable.ujj));
        information.add(new Information("Aditya Sharma", "8946514572", R.drawable.aditya));
        information.add(new Information("Tarun Runwal", "9424886622", R.drawable.tarun));
        information.add(new Information("Duke Kumar", "8989621211", R.drawable.dukekumar));
        information.add(new Information("Anil Kumar", "9424887784", R.drawable.aniltrivedi));
        information.add(new Information("Mayank Trivedi", "9944775511", R.drawable.mayank));
        information.add(new Information("Mayank Shirvastava", "9589767379", R.drawable.mayanklpu));
        information.add(new Information("Aadarsh Arora", "8989629999", R.drawable.aadarsh));
        information.add(new Information("Ashish Pareek", "9448733454", R.drawable.aashish));

        recyclerViewAdapter.notifyDataSetChanged();
    }
}




