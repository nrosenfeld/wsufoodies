package edu.wsu.wsufoodies;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;

public class ActMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.laymain);
    }

    public void goLogin(View v){
        startActivity(new Intent(ActMain.this, LoginPage.class));
    }

    public void goRegister(View v){
        startActivity(new Intent(ActMain.this, RegistrationPage.class));
    }
}