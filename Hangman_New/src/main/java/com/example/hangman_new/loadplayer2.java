package com.example.hangman_new;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

/**
 * Created by Keerthana on 11/27/13.
 */
public class loadplayer2 extends Activity {
    //stores the total progress
    private static int myprogress=0;

    //store the reference of the progress bar
    private ProgressBar progressBar;

    //stores teh current progress status
    private int progressStatus=0;

    //handler for the progress bar
    private Handler myHandler= new Handler();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player2_new);
    }

    public void beginTask(View view){

        myprogress=0;
        progressBar=(ProgressBar)findViewById(R.id.myProgress);
        progressBar.setMax(100);

        // invoking the thread method to perform the task in the background
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(progressStatus<100){

                    progressStatus=performTask();
                    myHandler.post(new Runnable() {
                        @Override
                        public void run() {

                            progressBar.setProgress(progressStatus);
                        }
                    });
                }

                myHandler.post(new Runnable() {
                    @Override
                    public void run() {

                        Toast.makeText(getBaseContext(),"TaskCompleted",Toast.LENGTH_LONG).show();
                        Intent intentStartGame = new Intent(loadplayer2.this,StartGame.class);
                        startActivity(intentStartGame);
                    }
                });
            }


            private int performTask(){

                try{

                    Thread.sleep(100);
                }catch(InterruptedException e){

                    e.printStackTrace();

                }
                return ++myprogress;
            }
        });


    }

}
