package com.example.gevorg.task_1;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

    public final static String Extra_Message = "some text";

    public void pushed(View view){
        Intent intent = new Intent(this, MessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.name);
        String message = editText.getText().toString() + "\n";

        editText = (EditText) findViewById(R.id.lastName);
        message += editText.getText().toString() + "\n";

        editText = (EditText) findViewById(R.id.birthDate);
        message += editText.getText().toString();

        intent.putExtra(Extra_Message,message);
        startActivity(intent);
    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            buttonEnabled();

        }

        @Override
        public void afterTextChanged(Editable s) {


        }
    };

    EditText etName, etLastName, etDate;
    Button sendButton;

    public void buttonEnabled(){
        if ((TextUtils.isEmpty(etName.getText())) ||
                (TextUtils.isEmpty(etLastName.getText())) ||
                        (TextUtils.isEmpty(etDate.getText())))
        {
            sendButton.setEnabled(false);
        } else
        {
            sendButton.setEnabled(true);
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         sendButton = (Button) findViewById(R.id.sendButton);
         etName = (EditText) findViewById(R.id.name);
        etLastName = (EditText) findViewById(R.id.lastName);
        etDate = (EditText) findViewById(R.id.birthDate);

        buttonEnabled();

        etName.addTextChangedListener(textWatcher);
        etLastName.addTextChangedListener(textWatcher);
        etDate.addTextChangedListener(textWatcher);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
