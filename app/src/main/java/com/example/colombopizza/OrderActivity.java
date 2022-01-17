package com.example.colombopizza;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {

    EditText pName, pType, pQuantity, pPrice, tPrice;
    Button insert, update, delete, view, insert2;

    DBHelper myDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        pName = findViewById(R.id.txtName);
        pType = findViewById(R.id.txtpizzaType);
        pQuantity = findViewById(R.id.txtQty);
        pPrice = findViewById(R.id.txtPrice);
        tPrice = findViewById(R.id.txtTPrice);

        insert = findViewById(R.id.insert);
        update = findViewById(R.id.update);
        delete = findViewById(R.id.Delete);
        view = findViewById(R.id.view);
        insert2 = findViewById(R.id.btnPayment);

        myDB = new DBHelper(this);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String pNameTXT = pName.getText().toString();
                String pTypeTXT = pType.getText().toString();
                String pQuantityTXT = pQuantity.getText().toString();
                String pPriceTXT = pPrice.getText().toString();
                String tPriceTXT = tPrice.getText().toString();

                Boolean checkinsertdata = myDB.insertorderdata(pNameTXT, pTypeTXT, pQuantityTXT,pPriceTXT,tPriceTXT);

                if(checkinsertdata == true) {

                    Toast.makeText(OrderActivity.this, "Successfully Order Submitted", Toast.LENGTH_SHORT).show();
                }
                else {

                    Toast.makeText(OrderActivity.this, "Order not Submitted", Toast.LENGTH_SHORT).show();
                }

            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String pNameTXT = pName.getText().toString();
                String pTypeTXT = pType.getText().toString();
                String pQuantityTXT = pQuantity.getText().toString();
                String pPriceTXT = pPrice.getText().toString();
                String tPriceTXT = tPrice.getText().toString();

                Boolean checkupdatedata = myDB.updateorderdata(pNameTXT, pTypeTXT, pQuantityTXT,pPriceTXT,tPriceTXT);

                if(checkupdatedata == true) {

                    Toast.makeText(OrderActivity.this, "Successfully Order Updated", Toast.LENGTH_SHORT).show();
                }
                else {

                    Toast.makeText(OrderActivity.this, "Order not Updated", Toast.LENGTH_SHORT).show();
                }

            }
        });


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String pNameTXT = pName.getText().toString();

                Boolean checkdeletedata = myDB.deletedata(pNameTXT);

                if(checkdeletedata == true) {

                    Toast.makeText(OrderActivity.this, "Successfully Order Deleted", Toast.LENGTH_SHORT).show();
                }
                else {

                    Toast.makeText(OrderActivity.this, "Order not Deleted", Toast.LENGTH_SHORT).show();
                }

            }
        });


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cursor res = myDB.getorderdata();
                if(res.getCount() == 0) {

                    Toast.makeText(OrderActivity.this, "No Entry Exist", Toast.LENGTH_SHORT).show();
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()) {

                    buffer.append("Order Name :" +res.getString( 0)+ "\n");
                    buffer.append("Order Type :" +res.getString( 1)+ "\n");
                    buffer.append("Order Quantity :" +res.getString( 2)+ "\n");
                    buffer.append("Price :" +res.getString( 3)+ "\n");
                    buffer.append("Total Price :" +res.getString( 4)+ "\n");
                    buffer.append("\n");
                    buffer.append("\n");

                }

                AlertDialog.Builder builder = new AlertDialog.Builder(OrderActivity.this);
                builder.setCancelable(true);
                builder.setTitle("User Entries");
                builder.setMessage(buffer.toString());
                builder.show();

            }
        });


        insert2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),PaymentActivity.class);
                startActivity(intent);
            }
        });





    }
}