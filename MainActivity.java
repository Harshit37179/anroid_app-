package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText usernameEditText, passwordEditText;
    Button loginButton, signupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.login_button);
        signupButton = findViewById(R.id.signup_button);

        loginButton.setOnClickListener(view -> {
            String inputUsername = usernameEditText.getText().toString().trim();
            String inputPassword = passwordEditText.getText().toString().trim();

            // Get saved credentials
            String savedUsername = getSharedPreferences("MyAppPrefs", MODE_PRIVATE).getString("username", "");
            String savedPassword = getSharedPreferences("MyAppPrefs", MODE_PRIVATE).getString("password", "");

            if (inputUsername.equals(savedUsername) && inputPassword.equals(savedPassword)) {
                Toast.makeText(MainActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, HomeActivity.class));
                finish();
            } else {
                Toast.makeText(MainActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
            }
        });


        signupButton.setOnClickListener(view -> {
            // Open a signup activity or dialog here
            Intent intent = new Intent(MainActivity.this, SignupActivity.class);
            startActivity(intent);

        });
    }
}
