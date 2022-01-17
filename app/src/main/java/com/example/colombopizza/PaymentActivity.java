package com.example.colombopizza;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PaymentActivity extends AppCompatActivity {

    EditText cardno, choldername , cvv, expiredate;

    Button insert;

    DBHelper myDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        cardno = findViewById(R.id.CardNo);
        choldername = findViewById(R.id.CardHolderName);
        cvv = findViewById(R.id.cvvNumber);
        expiredate = findViewById(R.id.ExpireDate);
        insert = findViewById(R.id.btnInsert);
        myDB = new DBHelper(this);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String CardNumTXT = cardno.getText().toString();
                String CardHolderNameTXT = choldername.getText().toString();
                String CVVNumberTXT = cvv.getText().toString();
                String ExpireDateTXT = expiredate.getText().toString();

                Boolean checkPaymentInsert = myDB.InsertPaymentDetails(CardNumTXT, CardHolderNameTXT, CVVNumberTXT, ExpireDateTXT);

                if(checkPaymentInsert == true) {

                    Toast.makeText(PaymentActivity.this, "Payment Successful", Toast.LENGTH_SHORT).show();
                }

                else {

                    Toast.makeText(PaymentActivity.this, "Payment Not Successful", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}