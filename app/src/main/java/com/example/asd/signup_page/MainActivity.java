package com.example.asd.signup_page;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText name = (EditText) findViewById(R.id.name);
        final EditText rollno = (EditText) findViewById(R.id.rollno);
        final EditText email = (EditText) findViewById(R.id.email);
        final EditText password = (EditText) findViewById(R.id.password);
        final EditText repassword=findViewById(R.id.repassword);
        final Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name1 = name.getText().toString();
                final String rollno1 = rollno.getText().toString();
                final String email1 =email.getText().toString();
                        //Integer.parseInt(etAge.getText().toString());
                final String password1= password.getText().toString();
                final String repassword1=repassword.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                //Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                //RegisterActivity.this.startActivity(intent);
                                Toast.makeText(MainActivity.this,"registeration sucess",Toast.LENGTH_SHORT).show();
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                builder.setMessage("Register Failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                                Toast.makeText(MainActivity.this,"registeration failed",Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                RegisterRequest registerRequest = new RegisterRequest(name1, rollno1, email1, password1, repassword1,responseListener);
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                queue.add(registerRequest);
                //Toast.makeText(MainActivity.this,"registeration sucess",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
