package edu.wsu.wsufoodies;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;





public class RegistrationPage extends AppCompatActivity {

    private Retrofit retrofit;
    private RetrofitInterface retrofitInterface;
    private final String BASE_URL = "http://10.0.2.2:980";
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String passwordConfirm;
    private int age;
    private Standing standing;
    private User newUser;
    EditText emailBox;


    EditText passwordBox;


    /*
    {

     }
    */

    TextView message;
    EditText confirmPassword;// = findViewById(R.id.confirmPassword);
    EditText firstNameBox;// = findViewById(R.id.firstName);
    EditText lastNameBox;// = findViewById(R.id.lastName);
    EditText ageBox;// = findViewById(R.id.bdate);
    Spinner standingSelect;// = findViewById(R.id.standing);
    Button submit;
    String standings[]={"FRESHMAN","SOPHOMORE","JUNIOR","SENIOR","GRADUATE","ALUMNUS",
        "FACULTY"};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page_new);
        message = (TextView) findViewById(R.id.textView2);
        message.setText("Registration Page");
        passwordBox = (EditText) findViewById(R.id.passwordRegister);
        emailBox = (EditText) findViewById(R.id.email);
        confirmPassword = (EditText) findViewById(R.id.confirmPassword);
        firstNameBox = (EditText) findViewById(R.id.firstName);
        lastNameBox = (EditText) findViewById(R.id.lastName);
        ageBox = (EditText) findViewById(R.id.bdate);
        standingSelect = (Spinner) findViewById(R.id.standing);
        submit = (Button) findViewById(R.id.button);
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, standings);
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitInterface = retrofit.create(RetrofitInterface.class);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        standingSelect.setAdapter(adapter);
        standingSelect.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = emailBox.getText().toString();
                firstName = firstNameBox.getText().toString();
                lastName = lastNameBox.getText().toString();
                firstName = firstNameBox.getText().toString();
                password = passwordBox.getText().toString();
                passwordConfirm = confirmPassword.getText().toString();
                age = Integer.parseInt(ageBox.getText().toString());

                standing = Standing.ALUMNUS;   //just default to alumnus until I can figure out how
                //to read value from spinner
                if (password.equals("")||firstName.equals("")||lastName.equals("")){
                    Toast.makeText(RegistrationPage.this, "Form incomplete!",
                            Toast.LENGTH_LONG).show();
                }
                else if (!password.equals(passwordConfirm)){
                    Toast.makeText(RegistrationPage.this, "Passwords don't match!",
                        Toast.LENGTH_LONG).show();
                }
                else {
                    newUser = new User(lastName, firstName, password, email, standing, age);

                    message.setText("Welcome!");
                    Call<Void> call = retrofitInterface.executeRegister(newUser);
                    call.enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            Toast.makeText(RegistrationPage.this,"Success!",
                                Toast.LENGTH_LONG).show();

                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                            Toast.makeText(RegistrationPage.this, t.getMessage(),
                                Toast.LENGTH_LONG).show();


                        }
                    });
                }
            }
        });
    }

    public void goMain(View v) {
        startActivity(new Intent(RegistrationPage.this, ActMain.class));
    }




}