package com.example.myapplication;



import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    EditText usernameEditText, passwordEditText;
    Button createAccountButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Link views
        usernameEditText = findViewById(R.id.signup_username);
        passwordEditText = findViewById(R.id.signup_password);
        createAccountButton = findViewById(R.id.create_account_button);

        // Button action
        createAccountButton.setOnClickListener(v -> {
            String newUsername = usernameEditText.getText().toString().trim();
            String newPassword = passwordEditText.getText().toString().trim();

            if (!newUsername.isEmpty() && !newPassword.isEmpty()) {
                // Save credentials
                getSharedPreferences("MyAppPrefs", MODE_PRIVATE)
                        .edit()
                        .putString("username", newUsername)
                        .putString("password", newPassword)
                        .apply();

                Toast.makeText(SignupActivity.this, "Account created successfully!", Toast.LENGTH_SHORT).show();
                finish(); // go back to login screen
            } else {
                Toast.makeText(SignupActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
