package com.yf.ihook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.yf.ihook.activity.Main;

/**
 * Created by Administrator on 2016/11/28.
 */

public class Welcom extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcom);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
              Welcom.this.startActivity(new Intent(Welcom.this, Main.class));
            }
        },3000);
    }
}
