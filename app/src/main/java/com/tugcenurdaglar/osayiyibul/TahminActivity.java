package com.tugcenurdaglar.osayiyibul;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class TahminActivity extends AppCompatActivity {
    private TextView textViewKalanHak, textViewYardim;
    private EditText editTextTahminGirdi;
    private Button buttonTahminEt;



    private int rastgeleSayi;
    private int sayac = 5;


    private TextView textViewMesaj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tahmin);

        textViewKalanHak = findViewById(R.id.textViewKalanHak);
        textViewYardim = findViewById(R.id.textViewYardim);
        editTextTahminGirdi = findViewById(R.id.editTextTahminGirdi);
        buttonTahminEt = findViewById(R.id.buttonTahminEt);


        Random r = new Random();
        rastgeleSayi = r.nextInt(101); //1-100

        Log.e("RASTGELE SAYI ", String.valueOf(rastgeleSayi));





        buttonTahminEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sayac = sayac-1;

                int kullaniciTahmini  = Integer.parseInt(editTextTahminGirdi.getText().toString());

                if (kullaniciTahmini == rastgeleSayi){
                    Intent i = new Intent(TahminActivity.this, SonucActivity.class);
                    i.putExtra("sonuc", true);
                    startActivity(i);

                    finish();
                    return;
                }
                if (kullaniciTahmini > rastgeleSayi){
                    textViewYardim.setText("AZALT ");
                    if (kullaniciTahmini == rastgeleSayi+2 || kullaniciTahmini == rastgeleSayi+1){
//                        Toast.makeText(getApplicationContext(),"Birazcık daha azalt çok yaklaştın",Toast.LENGTH_LONG).show();
                        View tasarim = getLayoutInflater().inflate(R.layout.toast_tasarim,null);
                        TextView textViewMesaj = tasarim.findViewById(R.id.textViewMesaj);
                        textViewMesaj.setText("Birazcık daha azalt çok yaklaştın");

                        Toast toastOzel = new Toast(getApplicationContext());

                        toastOzel.setView(tasarim);

                        toastOzel.setDuration(Toast.LENGTH_LONG);

                        toastOzel.show();
                    }
                    textViewKalanHak.setText("Kalan Hak : "+sayac);
                }

                if (kullaniciTahmini < rastgeleSayi){
                    textViewYardim.setText("ARTTIR");
                    if (kullaniciTahmini == rastgeleSayi-2 || kullaniciTahmini == rastgeleSayi-1){
//                        Toast.makeText(getApplicationContext(),"Birazcık daha arttır çok yaklaştın", Toast.LENGTH_LONG).show();
                        View tasarim = getLayoutInflater().inflate(R.layout.toast_tasarim,null);
                        TextView textViewMesaj = tasarim.findViewById(R.id.textViewMesaj);
                        textViewMesaj.setText("Birazcık daha arttır çok yaklaştın");

                        Toast toastOzel = new Toast(getApplicationContext());

                        toastOzel.setView(tasarim);

                        toastOzel.setDuration(Toast.LENGTH_LONG);

                        toastOzel.show();
                    }
                    textViewKalanHak.setText("Kalan Hak : "+sayac);
                }
                if (sayac == 0){
                    Intent i = new Intent(TahminActivity.this, SonucActivity.class);

                    i.putExtra("sonuc", false);
                    startActivity(i);

                    finish();


                }
                editTextTahminGirdi.setText("");

            }
        });
    }
}