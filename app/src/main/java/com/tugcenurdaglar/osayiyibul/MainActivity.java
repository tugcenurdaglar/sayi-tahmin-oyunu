package com.tugcenurdaglar.osayiyibul;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.PopupMenu;
import android.widget.Switch;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private Button buttonBasla, buttonKural;
    private Switch switchKaranlikMod;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_bilgi:
                AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this);

                ad.setMessage("1'den 100e kadar sayı tahmini yapmak için 5 hakkınız olacaktır");
                ad.setTitle("Oyun Kuralı");
                ad.setIcon(R.drawable.onay_resim);

                ad.setPositiveButton("Anladım", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Snackbar.make(buttonKural, "Umarım anlamışsınızdır, başarılar..", Snackbar.LENGTH_LONG).show();


                    }
                });
                ad.create().show();
                return true;


            case R.id.app_bar_switch:
//                switchKaranlikMod.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//                    @Override
//                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//
//                        if (isChecked){
//
//                            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//
//                        }
//                        else {
//                            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//
//                        }
//
//                    }
//                });



                return true;




        }
        return super.onOptionsItemSelected(item);

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchKaranlikMod = findViewById(R.id.switchKaranlikMod);

        buttonBasla = findViewById(R.id.buttonBasla);

        buttonKural = findViewById(R.id.buttonKural);

        toolbar = findViewById(R.id.toolbar);

        toolbar.setTitle("Bul O Sayıyı");
        toolbar.setSubtitle("hadi bul bul :D");
        setSupportActionBar(toolbar);






        switchKaranlikMod.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked){

                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);

                }
                else {
                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);

                }

            }
        });

        buttonBasla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(MainActivity.this,buttonBasla);

                popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {


                        switch (item.getItemId()){
                            case R.id.action_oyun1:

                                startActivity(new Intent(MainActivity.this,TahminActivity.class));
                                return true;
                            case R.id.action_oyun2:
                                startActivity(new Intent(MainActivity.this,MainActivity.class));
                                return true;

                            default:
                                return false;
                        }

                    }
                });

                popup.show();
            }
        });


    }
}