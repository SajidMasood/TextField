package com.mr_abdali.textfield;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    AppCompatEditText user;
    AppCompatEditText pass;

    // stop focusing when click out of edittext...
    RelativeLayout relativeLayout;

    // Edittext should be empty
    TextInputLayout userLayout;


    // show password toggle
    TextInputLayout passLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user =(AppCompatEditText) findViewById(R.id.username_TextField);
        pass =(AppCompatEditText) findViewById(R.id.password_TextField);

        // stop focusing when click out of edittext...
        relativeLayout = (RelativeLayout) findViewById(R.id.activity_main);
        relativeLayout.setOnClickListener(null);

        // Edittext should be empty
        userLayout = (TextInputLayout) findViewById(R.id.username_TextInputLayout);
        user.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                // show an error
                if (user.getText().toString().isEmpty()){
                    //
                    userLayout.setErrorEnabled(true);
                    userLayout.setError("please enter your user name");
                }
                else{
                    //
                    userLayout.setErrorEnabled(false);
                }
            }
        });
        user.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (user.getText().toString().isEmpty()){
                    //
                    userLayout.setErrorEnabled(true);
                    userLayout.setError("please enter your user name");
                }
                else{
                    //
                    userLayout.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        // end


        // show password toggles.....& password max size lenght
        passLayout = (TextInputLayout) findViewById(R.id.password_TextInputLayout);
        passLayout.setCounterEnabled(true);
        passLayout.setCounterMaxLength(8);


        /* first method...
            user.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // see character in run windows 1 not second one show ...
                //System.out.println(charSequence);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // see character in run windows 1 by 1 show ...
                //System.out.println(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // see character in run windows 1 by 1 show ...
                //System.out.println("after");
            }
        });*/

        // second method... for focus
        /*user.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                System.out.println(b);
            }
        });*/
    }
}
