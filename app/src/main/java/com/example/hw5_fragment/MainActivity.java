package com.example.hw5_fragment;

import android.app.Fragment;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Fragment myFragment = new Fragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        getFragmentManager().putFragment(outState, "myfragment", myFragment);
    }

    public void onRestoreInstanceState(@NonNull Bundle inState) {
        myFragment = getFragmentManager().getFragment(inState, "myfragment");
    }
}