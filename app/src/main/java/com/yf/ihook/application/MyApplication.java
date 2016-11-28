package com.yf.ihook.application;

import android.app.Application;

import com.yf.ihook.utils.UILImageLoader;

import org.xutils.x;

import cn.finalteam.galleryfinal.CoreConfig;
import cn.finalteam.galleryfinal.FunctionConfig;
import cn.finalteam.galleryfinal.GalleryFinal;
import cn.finalteam.galleryfinal.ImageLoader;
import cn.finalteam.galleryfinal.ThemeConfig;

/**
 * Created by Administrator on 2016/11/28.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //相机、相册 GalleryFinal
        ThemeConfig theme = new ThemeConfig.Builder().build();  //设置主题
        FunctionConfig function = new FunctionConfig.Builder().build();  //配置功能
        ImageLoader loader = new UILImageLoader();  //配置ImageLoader
        CoreConfig config = new CoreConfig.Builder(this, loader, theme).setFunctionConfig(function).build();
        GalleryFinal.init(config);

        x.Ext.init(this);
        x.Ext.setDebug(true);
    }
}
