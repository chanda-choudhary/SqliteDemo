package com.example.user.sqlitedemo;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateFragment extends Fragment {

    EditText updateId,updateName,updateEmail;
    Button btnUpdate;

    public UpdateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_update, container, false);
        updateId=view.findViewById(R.id.txt_update_id);
        updateName=view.findViewById(R.id.txt_update_name);
        updateEmail=view.findViewById(R.id.txt_update_email);
        btnUpdate=view.findViewById(R.id.btn_update);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateContact();
            }
        });
        return view;
    }
    private void updateContact()
    {
        int id=Integer.parseInt(updateId.getText().toString());
        String name=updateName.getText().toString();
        String email=updateEmail.getText().toString();

        ContactDBHelper contactDBHelper=new ContactDBHelper(getActivity());
        SQLiteDatabase database=contactDBHelper.getWritableDatabase();
        contactDBHelper.updateContact(id,name,email,database);
        contactDBHelper.close();
        Toast.makeText(getActivity(),"Contact Updated..",Toast.LENGTH_LONG).show();
        updateId.setText("");
        updateName.setText("");
        updateEmail.setText("");
    }

}
