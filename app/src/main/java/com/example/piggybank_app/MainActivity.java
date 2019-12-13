package com.example.piggybank_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    public static String usernameInput;
    public static String passwordInput;

    EditText usernameEdit;
    EditText passwordEdit;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameEdit = (EditText)findViewById(R.id.username_editText);
        passwordEdit = (EditText)findViewById(R.id.password_editText);

        mAuth = FirebaseAuth.getInstance();
    }

    public void signin_register(View v) {
        Intent intent = new Intent(this, welcomeActivity.class);
        usernameInput = usernameEdit.getText().toString();
        passwordInput = passwordEdit.getText().toString();
        if(usernameInput.length() == 0 || passwordInput.length() == 0){
            Toast.makeText(getApplicationContext(), "You must enter a Username and Password", Toast.LENGTH_SHORT).show();
            return;
        }
        create_user(usernameInput, passwordInput);
        intent.putExtra("username", usernameInput);
        intent.putExtra("password", passwordInput);
        startActivity(intent);
    }

    public void create_user(String username, String password) {
        mAuth.createUserWithEmailAndPassword(username, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            System.out.println("Successful!");
//                            FirebaseUser user = mAuth.getCurrentUser();
//                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            //Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(getApplicationContext(), "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
