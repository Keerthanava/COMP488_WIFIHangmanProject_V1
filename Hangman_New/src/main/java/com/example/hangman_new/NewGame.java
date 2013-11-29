package com.example.hangman_new;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Keerthana on 11/14/13.
 */
public class NewGame extends Activity  {


    Button Play;
    Button Home;
    EditText Word;
    EditText Hint;

    //TextView UnderScore;


    Context NewgameContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player1_new);

        Home =(Button)findViewById(R.id.btnHome1);

        Play =(Button)findViewById(R.id.btnPlay1);

        Word =(EditText)findViewById(R.id.EdittxtWord);

        Hint = (EditText)findViewById(R.id.Edittxthint);

       // UnderScore = (TextView)findViewById(R.id.txtUnderScore);


        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intentHome = new Intent(NewGame.this,MainActivity.class);
                startActivity(intentHome);
            }
        });

        // enter the word and hint and click on play

        Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String WordString = Word.getText().toString();

                String HintString = Hint.getText().toString();

                //char[] arrWordString = WordString.toCharArray();

                if(WordString.length() > 0 && HintString.length() > 0){

                    Intent intentStartGame = new Intent(NewGame.this,StartGame.class);


                   // String Underscoreword = WordString.replaceAll("[A-Za-z]", "_ ");

                   //intentStartGame.putExtra("Storeword",Underscoreword);
                    intentStartGame.putExtra("WordString",WordString);
                    intentStartGame.putExtra("hint",HintString);
                    //UnderScore.setText(Underscoreword);

                    startActivity(intentStartGame);




                }

                else{

                    Toast.makeText(getBaseContext(),"Please enter the word and the hint for player 2!!",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
<<<<<<< HEAD

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // TODO Auto-generated method stub
        super.onSaveInstanceState(outState);
        outState.putString("MysteryWord", Word.getText().toString());
        outState.putString("HintWord", Hint.getText().toString());

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onRestoreInstanceState(savedInstanceState);
        Word.setText(savedInstanceState.getString("MysteryWord"));
        Hint.setText(savedInstanceState.getString("HintWord"));
    }
=======
>>>>>>> 3c5503d3a2fafd68a075975e778f5d4b489a8cc4
}
