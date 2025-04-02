package com.example.menuburger;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MessagesFragment extends Fragment {

    private TextView txtView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View monView = inflater.inflate(R.layout.fragment_messages, container, false);
        txtView = txtView.findViewById(R.id.txtView);
        return monView;

    }
}