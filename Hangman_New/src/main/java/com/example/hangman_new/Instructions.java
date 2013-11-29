package com.example.hangman_new;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Keerthana on 11/16/13.
 */
public class Instructions extends Activity {

   Button Back;

    @Override
    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.instructions);

        Back = (Button)findViewById(R.id.btnBack);

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentBack = new Intent(Instructions.this,MainActivity.class);
                startActivity(intentBack);
            }
        });
    }


}
