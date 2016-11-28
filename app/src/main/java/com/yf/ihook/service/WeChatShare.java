package com.yf.ihook.service;

import android.accessibilityservice.AccessibilityService;
import android.os.Build;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Toast;
import java.util.List;
/**
 * Created by Administrator on 2016/11/24.
 */
public class WeChatShare extends AccessibilityService {
    private  String packageName="com.tencent.mm";
    private  String loginClass="com.tencent.mm.ui.account.LoginHistoryUI";
    private  String mainClass="com.tencent.mm.ui.LauncherUI";
    private  String nearFiends="com.tencent.mm.plugin.nearby.ui.NearbyFriendsIntroUI";
    private  String speed="";

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        //连接到service
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        CharSequence p = event.getPackageName();
        CharSequence c = event.getClassName();
        int type=event.getEventType();
        if(type==AccessibilityEvent.TYPE_WINDOWS_CHANGED){
            if(p.equals(packageName)&&c.equals(mainClass)){
                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.JELLY_BEAN){
                    clickTex(getRootInActiveWindow(),"发现");
                }else {
                    Toast.makeText(this, "版本不支持2", Toast.LENGTH_SHORT).show();
                }
            }

        }

    }

    public  void clickId(AccessibilityNodeInfo window,String id){
       if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.JELLY_BEAN_MR2){
            List<AccessibilityNodeInfo> nearView = window.findAccessibilityNodeInfosByViewId(id);
            for (AccessibilityNodeInfo info : nearView){
                info.performAction(AccessibilityNodeInfo.ACTION_CLICK);
                Log.i("111","click...");
            }
        }else {
            Toast.makeText(this, "版本不支持1", Toast.LENGTH_SHORT).show();
        }
    }


    public void clickTex(AccessibilityNodeInfo infos,String text){
        List<AccessibilityNodeInfo> infoList = infos.findAccessibilityNodeInfosByText(text);
        for(AccessibilityNodeInfo info : infoList){
            info.performAction(AccessibilityNodeInfo.ACTION_CLICK);
            Log.i("111","click...");
        }
    }

    @Override
    public void onInterrupt() {

    }
}
