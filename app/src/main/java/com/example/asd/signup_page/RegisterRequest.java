package com.example.asd.signup_page;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by asd on 10/15/2018.
 */

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

    public class RegisterRequest extends StringRequest {
        private static final String REGISTER_REQUEST_URL = "https://goyalakash1997.000webhostapp.com/register.php";
        private Map<String, String> params;

        public RegisterRequest(String name, String rollno, String email, String password,String repassword, Response.Listener<String> listener) {
            super(Request.Method.POST, REGISTER_REQUEST_URL, listener, null);
            params = new HashMap<>();
            params.put("name", name);
            params.put("rollno", rollno + "");
            params.put("username", email);
            params.put("password", password);
            params.put("repassword",repassword);
        }

        @Override
        public Map<String, String> getParams() {
            return params;
        }
       /* public byte[] getBody() throws AuthFailureError {
            try {
                return stringRequestBody.getBytes("utf-8"); //String Request Body with Encoded
            } catch (UnsupportedEncodingException uee) {
                return null;
            }
        }*/
    }
