package com.dfr.myfirstapp;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.view.View;
import android.graphics.Bitmap;
import android.app.Activity;

public class SettingsPage extends AppCompatActivity {
    private static final int CAMERA_REQUEST = 1888;
    EditText nom;
    ImageButton camBtn;
    ImageView marco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_page);
        nom = (EditText) findViewById(R.id.campEscr);
        camBtn = (ImageButton) findViewById(R.id.btnFoto);
        marco = (ImageView) findViewById(R.id.foto);

        camBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK){
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            marco.setImageBitmap(photo);
        }
    }

    @Override
    protected void onResume(){
        super.onResume();
        // restauramos datos
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor ed = prefs.edit();
        String name = prefs.getString("username","Name");
        nom.setText(name);
    }

    @Override
    protected void onPause(){
        // guardar datos
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor ed = prefs.edit();
        String name = nom.getText().toString();
        ed.putString("username", name);
        ed.commit();
        super.onPause();
    }

}
