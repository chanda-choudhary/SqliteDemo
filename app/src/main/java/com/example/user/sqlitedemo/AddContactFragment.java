package com.example.user.sqlitedemo;


import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddContactFragment extends Fragment {

    private Button btnSave;
    private EditText edtId,edtName,edtEmail;

    public AddContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_add_contact, container, false);
        btnSave=view.findViewById(R.id.btn_save);
        edtId=view.findViewById(R.id.txt_contact_id);
        edtName=view.findViewById(R.id.txt_contact_name);
        edtEmail=view.findViewById(R.id.txt_contact_email);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=edtId.getText().toString();
                String name=edtName.getText().toString();
                String email=edtEmail.getText().toString();

                ContactDBHelper contactDBHelper=new ContactDBHelper(getActivity());
                SQLiteDatabase database=contactDBHelper.getWritableDatabase();
                contactDBHelper.addContact(Integer.parseInt(id),name,email,database);
                contactDBHelper.close();
                edtId.setText("");
                edtName.setText("");
                edtEmail.setText("");
                Toast.makeText(getActivity(),"Contact saved successfully",Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }

}
