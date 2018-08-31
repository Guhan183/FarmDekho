package com.farmdekho.info.farmdekho;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class farmer extends AppCompatActivity {
    private EditText inputdate, inputcrop, inputName, inputMobile, inputquantity, inputaddress;
    private Button ADD, SEARCH_VENDOR;
    private String userId1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer);

        inputName = (EditText) findViewById(R.id.fname);
        inputaddress = (EditText) findViewById(R.id.faddress);
        inputMobile = (EditText) findViewById(R.id.fnumber);
        inputcrop = (EditText) findViewById(R.id.fcrop);
        inputdate = (EditText) findViewById(R.id.fdate);
        inputquantity = (EditText) findViewById(R.id.fquantity);
        ADD = (Button) findViewById(R.id.addfarmer);
        SEARCH_VENDOR = (Button) findViewById(R.id.searchvendor);
       // final DatabaseReference    mFirebaseDatabase = FirebaseDatabase.getInstance().getReference();



        ADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.addfarmer:
                       // user farmer = new user(inputName.getText().toString().trim(), inputaddress.getText().toString().trim(), inputMobile.getText().toString().trim(), inputcrop.getText().toString().trim(), inputdate.getText().toString().trim(), inputquantity.getText().toString().trim());
                        String name = inputName.getText().toString().trim();
                        String address = inputaddress.getText().toString().trim();
                        String phone = inputMobile.getText().toString().trim();
                        String quantity = inputquantity.getText().toString().trim();
                        String date = inputdate.getText().toString().trim();
                        String crop = inputcrop.getText().toString().trim();

                        if ((!TextUtils.isEmpty(name))&&(!TextUtils.isEmpty(address))&&(!TextUtils.isEmpty(phone))&&(!TextUtils.isEmpty(crop))&&(!TextUtils.isEmpty(date))&&(!TextUtils.isEmpty(quantity)))
                        {
                            if (phone.length() != 10) {
                                Toast.makeText(getApplicationContext(), "Please Check Mobile Number!", Toast.LENGTH_SHORT).show();
                                return;
                            }
                            else {
                                user farmer = new user(name, address, phone, crop, date, quantity);
                                saveData(farmer);

                                Toast.makeText(getApplicationContext(), "FARMER ADDED SUCCESSFULLY", Toast.LENGTH_LONG).show();
                            }
                        }
                        else
                        {
                            if(TextUtils.isEmpty(name))
                            {
                                Toast.makeText(getApplicationContext(), "Enter name of farmer!", Toast.LENGTH_SHORT).show();
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
                            if (TextUtils.isEmpty(crop)) {
                                Toast.makeText(getApplicationContext(), "Enter the crop name", Toast.LENGTH_SHORT).show();
                                return;
                            }
                            if (TextUtils.isEmpty(date)) {
                                Toast.makeText(getApplicationContext(), "Enter the date of cultivating", Toast.LENGTH_SHORT).show();
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

            private void saveData(user farmer) {
                FirebaseDatabase dataset = FirebaseDatabase.getInstance();
                DatabaseReference myRef = dataset.getReference("Farmers");
                myRef.push().setValue(farmer);
            }
        });

        SEARCH_VENDOR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(farmer.this, searchVENDOR.class));

            }
        });
    }
}

