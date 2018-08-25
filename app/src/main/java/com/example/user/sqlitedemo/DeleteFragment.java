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
public class DeleteFragment extends Fragment {

    EditText Id;
    Button deleteButton;

    public DeleteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_delete, container, false);
        Id=view.findViewById(R.id.txt_delete_id);
        deleteButton=view.findViewById(R.id.btn_delete);

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteContact();
            }
        });
        return view;
    }

    private void deleteContact() {
        ContactDBHelper contactDBHelper=new ContactDBHelper(getActivity());
        SQLiteDatabase database=contactDBHelper.getWritableDatabase();
        int id=Integer.parseInt(Id.getText().toString());
        contactDBHelper.deleteContact(id,database);
        contactDBHelper.close();
        Id.setText("");
        Toast.makeText(getActivity(),"Contact Removed Successfully",Toast.LENGTH_LONG).show();
    }

}
