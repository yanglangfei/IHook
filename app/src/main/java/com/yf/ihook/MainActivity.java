package com.yf.ihook;

import android.content.ComponentName;
import android.content.Intent;
import android.provider.Settings;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.yf.ihook.service.WeChatShare;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public  void  onAsist(View view){
        //开启辅助功能
        final String service = getPackageName() + "/" + WeChatShare.class.getCanonicalName();
        int enabled=0;
        try {
            enabled=Settings.Secure.getInt(getContentResolver(), Settings.Secure.ACCESSIBILITY_ENABLED);
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }

        TextUtils.SimpleStringSplitter splitter=new TextUtils.SimpleStringSplitter(':');

        if(enabled==1){
            //可用状态
           String value= Settings.Secure.getString(getContentResolver(), Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES);
            if(value!=null){
              splitter.setString(value);
                while (splitter.hasNext()){
                    String accessibilityService = splitter.next();
                    if (accessibilityService.equalsIgnoreCase(service)) {

                    }
                }
            }
        }
    }
}
