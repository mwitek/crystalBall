package com.mwitekdesign.crystalball;


import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
    private CrystalBall mCrystalBall = new CrystalBall();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Declare our View variables
        final TextView answerLabel = (TextView) findViewById(R.id.textView1);
        Button getAnswerButton = (Button) findViewById(R.id.button1);

        getAnswerButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String answer = mCrystalBall.getAnAnswer();
                animateCrystalBall();
                answerLabel.setText(answer);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private void animateCrystalBall() {
        //to work with the image  view item we need to reference it.
        ImageView crystalBallImage = (ImageView) findViewById(R.id.imageView1);
        AnimationDrawable crystalBallAnimation = (AnimationDrawable) crystalBallImage.getDrawable();

        if (crystalBallAnimation.isRunning()) {
            crystalBallAnimation.stop();
        }
        crystalBallAnimation.start();
    }
}
