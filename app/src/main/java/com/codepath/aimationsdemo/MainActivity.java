package com.codepath.aimationsdemo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         Button btnAnimate = (Button) findViewById(R.id.btnAnimate);
        //Object animator
        //Animate the y value down to zero
//overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        btnAnimate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                ObjectAnimator moveToTop = ObjectAnimator.ofFloat(view, "y", 0.0f);
                moveToTop.setDuration(2500);
                moveToTop.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        ObjectAnimator fadeAway = ObjectAnimator.ofFloat(view, "alpha", 0.0f);
                        fadeAway.start();
                    }
                });
                moveToTop.start();


            }
        });

        //AnimatorSet set = new AnimatorSet();
        //set.playSequentially(moveToTop, fadeAway);
        //set.start();

        //2. Animate the alpha value to zero
    }
}
