package com.example.user.sqlitedemo;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    private Button btnAdd,btnView,btnUpdate,btnDelete;
    OnDbOpListener dbOpListener;

    public HomeFragment() {
        // Required empty public constructor
    }

    public interface OnDbOpListener{
        public void dbOpPerform(int method);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home, container, false);
        btnAdd=view.findViewById(R.id.btn_add_contact);
        btnView=view.findViewById(R.id.btn_view_contact);
        btnUpdate=view.findViewById(R.id.btn_update_contact);
        btnDelete=view.findViewById(R.id.btn_delete_contact);

        btnAdd.setOnClickListener(this);
        btnView.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_add_contact:
                dbOpListener.dbOpPerform(0);
                break;
            case R.id.btn_view_contact:
                dbOpListener.dbOpPerform(1);
                break;
            case R.id.btn_update_contact:
                dbOpListener.dbOpPerform(2);
                break;
            case R.id.btn_delete_contact:
                dbOpListener.dbOpPerform(3);
                break;
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity=(Activity)context;
        try {
            dbOpListener= (OnDbOpListener) activity;
        }
        catch (ClassCastException e){
            throw new ClassCastException(activity.toString()+" must implement the interface method");
        }
    }
}
