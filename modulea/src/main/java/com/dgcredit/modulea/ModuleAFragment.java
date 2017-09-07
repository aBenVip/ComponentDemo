package com.dgcredit.modulea;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;


/**
 * A simple {@link Fragment} subclass.
 */
@Route(path = "/modulea/fragment")
public class ModuleAFragment extends Fragment {


    public ModuleAFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.modulea_fragment_module_a, container, false);
    }

}
