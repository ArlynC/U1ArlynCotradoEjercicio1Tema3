package com.example.bottnav;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class GridFragment extends Fragment {


    public GridFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.activity_grid_fragment,container,false);
        GridView gv = view.findViewById(R.id.migridview);
        ArrayAdapter miarrayadapter= ArrayAdapter.createFromResource(getActivity(),R.array.milista,android.R.layout.simple_list_item_1);
        gv.setAdapter(miarrayadapter);
        return view;
    }

}

