package com.example.mailgonder;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText mKisi,mKonu,mIcerik;
    Button gonderBtn;

    String iceriktx,konutx,mailadrestx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanimla();
        mailAlveGor();

    }
    public void tanimla()
    {
        mKisi=findViewById(R.id.kisi_et);
        mKonu=findViewById(R.id.konu_et);
        mIcerik=findViewById(R.id.icerik_et);
        gonderBtn=findViewById(R.id.mail_btn);
    }
    public void bilgial()
    {
        iceriktx=mIcerik.getText().toString();
        konutx=mKonu.getText().toString();
        mailadrestx=mKisi.getText().toString();
    }
    public void mailAlveGor()
    {
        bilgial();
        gonderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent=new Intent(Intent.ACTION_SEND);
                    intent.setType("message/rfc822");
                    intent.putExtra(Intent.EXTRA_EMAIL,mailadrestx);
                    intent.putExtra(Intent.EXTRA_SUBJECT,konutx);
                    intent.putExtra(Intent.EXTRA_TEXT,iceriktx);
                    startActivity(intent);
                }
                catch (Exception e)
                {
                    System.out.println(" "+e);
                }


            }
        });
    }

}
