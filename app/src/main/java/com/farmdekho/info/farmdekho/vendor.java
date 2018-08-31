package com.farmdekho.info.farmdekho;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class vendor extends AppCompatActivity {
    private EditText inputdate, inputneed, inputName, inputMobile, inputquantity, inputaddress;
    private Button ADD,SEARCH_FARMER;
    private String userId;

   // public static final String Database_path="user_Database";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor);
        //Firebase.setAndroidContext(vendor.this);

        inputaddress = (EditText) findViewById(R.id.vaddress);
        inputquantity = (EditText) findViewById(R.id.vquantity);
        inputneed = (EditText) findViewById(R.id.vneed);
        inputdate = (EditText) findViewById(R.id.vdate);
        inputName = (EditText) findViewById(R.id.vname);
        inputMobile = (EditText) findViewById(R.id.vnumber);
        ADD = (Button) findViewById(R.id.addvendor);
        SEARCH_FARMER = (Button) findViewById(R.id.searchfarmer);


        ADD.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.addvendor:

                        String name = inputName.getText().toString().trim();
                        String address = inputaddress.getText().toString().trim();
                        String phone = inputMobile.getText().toString().trim();
                        // String location = spinnerLocation.getSelectedItem().toString();
                        String quantity = inputquantity.getText().toString().trim();
                        String date = inputdate.getText().toString().trim();
                        String need = inputneed.getText().toString().trim();
                        if ((!TextUtils.isEmpty(name))&&(!TextUtils.isEmpty(address))&&(!TextUtils.isEmpty(phone))&&(!TextUtils.isEmpty(need))&&(!TextUtils.isEmpty(date))&&(!TextUtils.isEmpty(quantity)))
                        {
                            if (phone.length() != 10) {
                                Toast.makeText(getApplicationContext(), "Please Check Mobile Number!", Toast.LENGTH_SHORT).show();
                                return;
                            }
                            else {
                                user1 vendor = new user1(name, address, phone, need, date, quantity);
                                saveData(vendor);

                                Toast.makeText(getApplicationContext(), "VENDOR ADDED SUCCESSFULLY", Toast.LENGTH_LONG).show();
                            }
                        }
                        else
                        {
                            if(TextUtils.isEmpty(name))
                            {
                                Toast.makeText(getApplicationContext(), "Enter name of vendor!", Toast.LENGTH_SHORT).show();
                                return;
                            }
                            if (TextUtils.isEmpty(address)) {
                                Toast.makeText(getApplicationContext(), "Enter postal address!", Toast.LENGTH_SHORT).show();
                                return;
                            }
                            if (TextUtils.isEmpty(phone)) {
                                Toast.makeText(getApplicationContext(), "Enter Mobile Number!", Toast.LENGTH_LONG).show();
                                return;
                            }

                            if (TextUtils.isEmpty(need)) {
                                Toast.makeText(getApplicationContext(), "Enter the need name", Toast.LENGTH_SHORT).show();
                                return;
                            }
                            if (TextUtils.isEmpty(date)) {
                                Toast.makeText(getApplicationContext(), "Enter the date of product want", Toast.LENGTH_SHORT).show();
                                return;
                            }

                            if (TextUtils.isEmpty(quantity)) {
                                Toast.makeText(getApplicationContext(), "Enter the amount of quantity", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        }
                        break;
                }
            }

            public void saveData(user1 vendor) {
                FirebaseDatabase dataset = FirebaseDatabase.getInstance();
                DatabaseReference myRef1 = dataset.getReference("Vendors");
                userId = myRef1.push().getKey();
                myRef1.child(userId).setValue(vendor);

               // myRef1.push().setValue(vendor);

            }
        });

        SEARCH_FARMER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(vendor.this, searchFARMER.class));
            }
        });

    }
}