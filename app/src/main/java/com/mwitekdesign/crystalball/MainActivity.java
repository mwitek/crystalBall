package com.mwitekdesign.crystalball;


import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
    private CrystalBall mCrystalBall = new CrystalBall();
    private TextView mAnswerLabel;
    private Button mGetAnswerButton;
    private ImageView mCrystalBallImage;
    private AnimationDrawable mCrystalBallAnimation;
    private Animation animFadein;
    private MediaPlayer mCrystalBallSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Declare our View variables
        mAnswerLabel = (TextView) findViewById(R.id.textView1);
        mGetAnswerButton = (Button) findViewById(R.id.button1);

        mGetAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateCrystalBall();
                playCrystalBallSound();
                getCrystalBallAnswer();
                animateAnswer();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private void playCrystalBallSound() {
        mCrystalBallSound = MediaPlayer.create(this, R.raw.crystal_ball);
        if(mCrystalBallSound.isPlaying()) {
            mCrystalBallSound.reset();
        }else {
            mCrystalBallSound.start();
        }
    }

    private void animateCrystalBall() {
        //to work with the image  view item we need to reference it.
        mCrystalBallImage = (ImageView) findViewById(R.id.imageView1);
        mCrystalBallAnimation = (AnimationDrawable) mCrystalBallImage.getDrawable();

        if (mCrystalBallAnimation.isRunning()) {
            mCrystalBallAnimation.stop();
        }
        mCrystalBallAnimation.start();
    }

    private void getCrystalBallAnswer() {
        String answer = mCrystalBall.getAnAnswer();
        mAnswerLabel.setText(answer);
    }

    private void animateAnswer() {
        animFadein = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        mAnswerLabel.startAnimation(animFadein);
    }
}