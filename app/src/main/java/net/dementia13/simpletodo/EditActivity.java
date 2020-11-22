package net.dementia13.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    EditText etItem;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        etItem = findViewById(R.id.etText);
        btnSave = findViewById(R.id.btnSave);

        getSupportActionBar().setTitle("Edit item");

        getIntent().getStringExtra(MainActivity.KEY_ITEM_TEXT);

        etItem.setText(getIntent().getStringExtra(MainActivity.KEY_ITEM_TEXT));

        // When done editing, click save button
        btnSave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                // create an intent that contains the results
                Intent intent = new Intent();

                // pass results
                intent.putExtra(MainActivity.KEY_ITEM_TEXT, etItem.getText().toString());
                intent.putExtra(MainActivity.KEY_ITEM_POSITION, getIntent().getExtras().getInt(MainActivity.KEY_ITEM_POSITION));
                // set the result of the intent
                setResult(RESULT_OK, intent);

                // finish activity, close screen and go back
                finish();
            }
       });
    }
}