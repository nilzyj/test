package com.example.animation;

import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {
    private Button btn_shot, btn_fire;
    private ImageView image_rocket, image_bomb;
    //传统动画（帧动画，frame动画）
    private AnimationDrawable anim_fire, anim_bomb;
    //区间动画（tween动画）
    private Animation anim_tra;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_shot = (Button) findViewById(R.id.btn_shot);
        btn_fire = (Button) findViewById(R.id.btn_fire);
        image_rocket = (ImageView) findViewById(R.id.image_rocket);
        image_bomb = (ImageView) findViewById(R.id.image_bomb);
        //初始化动画类的具体内容
        anim_fire = (AnimationDrawable) image_rocket.getBackground();
        anim_bomb = (AnimationDrawable) image_bomb.getBackground();
        btn_fire.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                //启动传统动画
                if (anim_fire.isRunning()) {

                } else
                    anim_fire.start();
            }
        });

		/*btn_shot.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				anim_shot.start();
			}
		});*/

        anim_tra = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim);
        btn_shot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image_rocket.startAnimation(anim_tra);
            }
        });

        anim_tra.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationRepeat(Animation arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationEnd(Animation arg0) {
                image_bomb.setVisibility(View.VISIBLE);
                image_rocket.setVisibility(View.INVISIBLE);
                anim_bomb.start();
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.animation/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.animation/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
