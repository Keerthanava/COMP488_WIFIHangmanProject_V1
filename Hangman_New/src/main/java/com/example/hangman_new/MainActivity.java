package com.example.hangman_new;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends Activity {

    Button Newgame;
    Button Exit;
    Button Instructions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Newgame=(Button)findViewById(R.id.btnNewGame);
        Instructions=(Button)findViewById(R.id.btnInstructions);
        Exit = (Button)findViewById(R.id.btnExit);


        // Exit the game when clicked on exit
    Exit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            //finish();
            Toast.makeText(getBaseContext(), "Thanks for playing Hangman game!!", Toast.LENGTH_SHORT).show();
            moveTaskToBack(true);
            MainActivity.this.finish();
            System.exit(0);
        }
     });

    // Invoke the new game class when player clicks on new game
        Newgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, NewGame.class);
                startActivity(intent);
            }
        });

        // Ivoke the instructions to learn how to play the game,
        Instructions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Instructions.class);
                MainActivity.this.startActivity(intent);
            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


}
