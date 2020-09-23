package com.example.hw5_fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class BlankFragment2 extends Fragment {
    String t;
    RecyclerView recyclerView;
    MainAdapter adapter;
    ArrayList<String> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank2, container, false);
        recyclerView = view.findViewById(R.id.recyclerview);
        if (getArguments() != null && savedInstanceState != null) {
            list = savedInstanceState.getStringArrayList("list");
        }
        if (getArguments() != null) {
            list = new ArrayList<>();
            t = getArguments().getString("text");
            list.add(t);
            Log.e("TAG", "onCreateView: " + list.toString());
        }
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MainAdapter();
        recyclerView.setAdapter(adapter);
        adapter.addText(t);

        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList("list", list);
        Log.e("TAG", "onSaveInstanceState: " + list);
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e("TAG", "onPause: " );
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e("TAG", "onStop: " );
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState != null) {
            if (getArguments() != null) {
            }
        }
    }
}