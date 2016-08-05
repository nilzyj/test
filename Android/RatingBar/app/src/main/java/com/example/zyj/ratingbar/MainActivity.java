package com.example.zyj.ratingbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RatingBar ratingBar_Small;
    private RatingBar ratingBar_Indicator;
    private RatingBar ratingBar_default;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ratingBar_Small = (RatingBar) findViewById(R.id.ratingBar_Small);
        ratingBar_Indicator = (RatingBar) findViewById(R.id.ratingBar_Indicator);
        ratingBar_default = (RatingBar) findViewById(R.id.ratingBar_default);
        mTextView = (TextView) findViewById(R.id.text);

        ratingBar_default.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                ratingBar_default.setRating(v);
                mTextView.setText(String.valueOf(v));
            }
        });

        ratingBar_Small.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                mTextView.setText(String.valueOf(v));
            }
        });

        ratingBar_Indicator.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                mTextView.setText(String.valueOf(v));
            }
        });

    }
}
