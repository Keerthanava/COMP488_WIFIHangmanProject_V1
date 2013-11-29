package com.example.hangman_new;

import android.app.Activity;
<<<<<<< HEAD
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
=======
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
>>>>>>> 3c5503d3a2fafd68a075975e778f5d4b489a8cc4

/**
 * Created by Keerthana on 11/15/13.
 */
public class StartGame extends Activity {

    private static final String TAG = "Hangman";


<<<<<<< HEAD
    TextView mysteryWordTextView;
    //The view of the hint that is being shown
    TextView hintTextView;
    //The view ofo the string of letters guessed incorrecty

    ImageView hangmanImgView;
    Button homeButton;
=======
    TextView MysteryWord;
    //The view of the hint that is being shown
    TextView Hint;
    //The view ofo the string of letters guessed incorrecty
     TextView WrongLetters;
    //The view of the displayed hangman image
    ImageView Hangmanimg;
    Button Home;
>>>>>>> 3c5503d3a2fafd68a075975e778f5d4b489a8cc4
   // Button a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z;




<<<<<<< HEAD
    String mysteryWordString;
    String underscoreWord;
    private int wrongLetterCount =0;

/*
    private int curMan=0;
    private ArrayList<Boolean> curAnswer;
    private String key;*/
=======

    private int curMan=0;
    private ArrayList<Boolean> curAnswer;
    private String key;
>>>>>>> 3c5503d3a2fafd68a075975e778f5d4b489a8cc4





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // set the content view for the game layout
        setContentView(R.layout.commomscreen);
<<<<<<< HEAD
        mysteryWordTextView = (TextView)findViewById(R.id.txtUnderScore);
        hintTextView = (TextView)findViewById(R.id.txthint);
        homeButton = (Button)findViewById(R.id.btnHome);
        hangmanImgView = (ImageView)findViewById(R.id.hang);

        //You dont need this anymore since you already added a method in onClick in each button
        /*
=======


        MysteryWord = (TextView)findViewById(R.id.txtUnderScore);
        Hint = (TextView)findViewById(R.id.txthint);
        Home = (Button)findViewById(R.id.btnHome);
>>>>>>> 3c5503d3a2fafd68a075975e778f5d4b489a8cc4
        Button a = (Button)findViewById(R.id.btnA);
        Button b = (Button)findViewById(R.id.btnB);
        Button c = (Button)findViewById(R.id.btnC);
        Button d = (Button)findViewById(R.id.btnD);
        Button e = (Button)findViewById(R.id.btnE);
        Button f = (Button)findViewById(R.id.btnF);
        Button g = (Button)findViewById(R.id.btnG);
        Button h = (Button)findViewById(R.id.btnH);
        Button i = (Button)findViewById(R.id.btnI);
        Button j = (Button)findViewById(R.id.btnJ);
        Button k = (Button)findViewById(R.id.btnK);
        Button l = (Button)findViewById(R.id.btnL);
        Button m = (Button)findViewById(R.id.btnM);
        Button n = (Button)findViewById(R.id.btnN);
        Button o = (Button)findViewById(R.id.btnO);
        Button p = (Button)findViewById(R.id.btnP);
        Button q = (Button)findViewById(R.id.btnQ);
        Button r = (Button)findViewById(R.id.btnR);
        Button s = (Button)findViewById(R.id.btnS);
        Button t = (Button)findViewById(R.id.btnT);
        Button u = (Button)findViewById(R.id.btnU);
        Button v = (Button)findViewById(R.id.btnV);
        Button w = (Button)findViewById(R.id.btnW);
        Button x = (Button)findViewById(R.id.btnX);
        Button y = (Button)findViewById(R.id.btnY);
<<<<<<< HEAD
        Button z = (Button)findViewById(R.id.btnZ);*/
=======
        Button z = (Button)findViewById(R.id.btnZ);
>>>>>>> 3c5503d3a2fafd68a075975e778f5d4b489a8cc4

        Bundle extras = getIntent().getExtras();

        if(extras!=null){
<<<<<<< HEAD
            String Hintword = extras.getString("hint");
            String str=extras.getString("WordString");
            Log.e("WORD:::",str);
            mysteryWordString = str.toUpperCase();
            Log.e("TO UPPER CASE WORD::::",mysteryWordString);


            //replace the word with an underscore
            underscoreWord = mysteryWordString.replaceAll("[A-Za-z]", "_ ");
            Log.e("UNDERSCORED WORD:::::",underscoreWord);
            mysteryWordTextView.setText(underscoreWord);
            hintTextView.setText(Hintword);
        }



        //Click on home button to move back to the home screen
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHome = new Intent(StartGame.this, MainActivity.class);
                startActivity(intentHome);
            }
        });


    }


    /*
    Method that is called when an alphabet button is pressed.
    @param View   the view of the button being pressed
    @author amehjabeen@luc.edu
     */
    public void clickLetter(View view) {
        char letterPressed = ((String)view.getTag()).charAt(0);
        Log.d("Start GAME","Letter pressed is: "+letterPressed);
        validateGuess(letterPressed);
        view.setClickable(false);

    }




    /*
    Method to validate if the pressed letter is correct or incorrect and perform appropriate
    action based on that

    @param char  a char containing the alphabet whose button was pressed.
    @author amehjabeen@luc.edu
     */


    public void validateGuess(char guessedLetter) {
        boolean wrongGuess = true;
        String tempString;
        StringBuilder temp = new StringBuilder(underscoreWord);
        int len=mysteryWordString.length();
        for (int i=0; i<len; i++) {
            if (mysteryWordString.charAt(i) == guessedLetter) {
                temp.setCharAt(i*2, guessedLetter);
                Log.e("at Position:::::", String.valueOf(i));
                wrongGuess = false;



            }

        }

         underscoreWord = temp.toString();
        Log.e("UNDERSCORED WORD NOW:::::",underscoreWord);
        if(mysteryWordTextView !=null ){
            mysteryWordTextView.setText(underscoreWord);


        }
        if (wrongGuess){

            Log.i(TAG,"Wrong Letter pressed!!"+guessedLetter);

                if(wrongLetterCount >= Constants.LOWER_BOUND && wrongLetterCount < Constants.MAX_WRONG_GUESSES ){
                wrongLetterCount++;
                UpdateTheHangmanFigure(wrongLetterCount);

            }
        }else{
            tempString = underscoreWord.replaceAll("\\s","");
            Log.e("REMOVED SPACES::::",tempString);
            Log.e("ORIG WORD::::",mysteryWordString);
            if(tempString.equals(mysteryWordString)){
                playerWon();

            }
        }

    }



    /*
    Method that updates the hang7 figure based on the wrong guesses
    @param int the number of letters that were guessed incorrectly
    @author amehjabeen@luc.edu
     */
    private void UpdateTheHangmanFigure(int wrongLetterCount) {
        //TODO fix the images in the drawable folder
        if(hangmanImgView != null){
            if(wrongLetterCount == 1){
                hangmanImgView.setImageResource(R.drawable.hang1);
            }
            else if(wrongLetterCount == 2){
                hangmanImgView.setImageResource(R.drawable.hang2);
            }
            else if(wrongLetterCount == 3){
                hangmanImgView.setImageResource(R.drawable.hang3);
            }
            else if(wrongLetterCount == 4){
                hangmanImgView.setImageResource(R.drawable.hang4);
            }
            else if(wrongLetterCount == 5){
                hangmanImgView.setImageResource(R.drawable.hang5);
            }
            else if(wrongLetterCount == 6){
                hangmanImgView.setImageResource(R.drawable.hang6);
            }
            else if(wrongLetterCount == 7){
                hangmanImgView.setImageResource(R.drawable.hang7);
                playerLost();
            }
        }

    }

    /*
    Method that notifies the player that he lost
     */
    private void playerLost() {
        Toast.makeText(getApplicationContext(),"You Lost!!!!",Toast.LENGTH_LONG).show();
        Intent intentLost = new Intent(StartGame.this,MainActivity.class);
        startActivity(intentLost);
    }

    /*
    Method that notifies the player that he won
     */
    private void playerWon() {
        Toast.makeText(getApplicationContext(),"Congrats you won the game!!!!",Toast.LENGTH_LONG).show();
        Intent intentWon = new Intent(StartGame.this,MainActivity.class);
        startActivity(intentWon);
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // TODO Auto-generated method stub
        super.onSaveInstanceState(outState);
        outState.putString("mysteryWordTextView",mysteryWordTextView.getText().toString());
        outState.putString("hintTextView",hintTextView.getText().toString());


    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onRestoreInstanceState(savedInstanceState);
        mysteryWordTextView.setText(savedInstanceState.getString("mysteryWordTextView"));
        hintTextView.setText(savedInstanceState.getString("hintTextView"));

    }
=======



            String Hintword = extras.getString("hint");
            String strMysteryWord = extras.getString("WordString");
           // String Underscoreword = extras.getString("Storeword");

            //replace the word with an underscore
            String Underscoreword = strMysteryWord.replaceAll("[A-Za-z]", "_ ");
            MysteryWord.setText(Underscoreword);
            Hint.setText(Hintword);


        }



        //Click on home button to move back to the home screen
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intentHome = new Intent(StartGame.this,MainActivity.class);
                startActivity(intentHome);
            }
        });


    }

   /* @Override
    public boolean onKeyDown(int keyCode,KeyEvent event){
        switch (keyCode){
            case KeyEvent.KEYCODE_A :
                validateGuess('A');
                break;
            case KeyEvent.KEYCODE_B:
                validateGuess('B');
                break;
            case KeyEvent.KEYCODE_C:
                validateGuess('C');
                break;
            case KeyEvent.KEYCODE_D:
                validateGuess('D');
                break;
            case KeyEvent.KEYCODE_E:
                validateGuess('E');
                break;
            case KeyEvent.KEYCODE_F:
                validateGuess('F');
                break;
            case KeyEvent.KEYCODE_G:
                validateGuess('G');
                break;
            case KeyEvent.KEYCODE_H:
                validateGuess('H');
                break;
            case KeyEvent.KEYCODE_I:
                validateGuess('I');
                break;
            case KeyEvent.KEYCODE_J:
                validateGuess('J');
                break;
            case KeyEvent.KEYCODE_K:
                validateGuess('K');
                break;
            case KeyEvent.KEYCODE_L:
                validateGuess('L');
                break;
            case KeyEvent.KEYCODE_M:
                validateGuess('M');
                break;
            case KeyEvent.KEYCODE_N:
                validateGuess('N');
                break;
            case KeyEvent.KEYCODE_O:
                validateGuess('O');
                break;
            case KeyEvent.KEYCODE_P:
                validateGuess('P');
                break;
            case KeyEvent.KEYCODE_Q:
                validateGuess('Q');
                break;
            case KeyEvent.KEYCODE_R:
                validateGuess('R');
                break;
            case KeyEvent.KEYCODE_S:
                validateGuess('S');
                break;
            case KeyEvent.KEYCODE_T:
                validateGuess('T');
                break;
            case KeyEvent.KEYCODE_U:
                validateGuess('U');
                break;
            case KeyEvent.KEYCODE_V:
                validateGuess('V');
                break;
            case KeyEvent.KEYCODE_W:
                validateGuess('W');
                break;
            case KeyEvent.KEYCODE_X:
                validateGuess('X');
                break;
            case KeyEvent.KEYCODE_Y:
                validateGuess('Y');
                break;
            case KeyEvent.KEYCODE_Z:
                validateGuess('Z');
                break;
            default:
                return  super.onKeyDown(keyCode,event);
        }
        return true;
    }*/

>>>>>>> 3c5503d3a2fafd68a075975e778f5d4b489a8cc4

}
