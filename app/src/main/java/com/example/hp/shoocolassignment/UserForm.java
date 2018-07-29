package com.example.hp.shoocolassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class UserForm extends AppCompatActivity {
    EditText first_name, last_name, phone, address, restau_name;
    Spinner requestby;
    Button save;
    DatabaseHelper dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_form);

        dbhelper=new DatabaseHelper(this);
        first_name = (EditText) findViewById(R.id.editText);
        last_name = (EditText) findViewById(R.id.editText2);
        phone = (EditText) findViewById(R.id.editText3);
        address = (EditText) findViewById(R.id.editText4);
        restau_name = (EditText) findViewById(R.id.editText5);
        requestby = (Spinner) findViewById(R.id.spinner);
        save = (Button) findViewById(R.id.button);


        String[] items=new String[] {"Owner", "Manager", "Other"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String >(this, R.layout.support_simple_spinner_dropdown_item, items);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        requestby.setAdapter(adapter);
        requestby.setSelection(2);
    }

        public void save_data(View view){
        int val=0;

            String fname=first_name.getText().toString();
            String lname=last_name.getText().toString();
            String phn=phone.getText().toString();
            String add=address.getText().toString();
            String restau=restau_name.getText().toString();
            String req=requestby.getSelectedItem().toString();
            if (req=="Owner")
                val=1;
            else if (req=="Manager")
                val=2;
            else
                val=3;
            if(fname.equals("") | lname.equals("") | phn.equals("") | add.equals("") | restau.equals(""))
                Toast.makeText(UserForm.this, "Please fill all details", Toast.LENGTH_LONG).show();
            else {

                Boolean isInserted = dbhelper.insertData(fname, lname, phn, add, restau, req);
                if (isInserted = true)
                    Toast.makeText(this, "Successfully Registered", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(this, "Registeration Failed", Toast.LENGTH_LONG).show();
            }
            first_name.setText("");
            last_name.setText("");
            phone.setText("");
            address.setText("");
            restau_name.setText("");
            requestby.setSelection(2);
        }
}
