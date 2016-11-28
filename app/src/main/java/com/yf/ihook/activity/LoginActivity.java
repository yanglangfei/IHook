package com.yf.ihook.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.yf.ihook.R;

import java.util.List;

import cn.finalteam.galleryfinal.GalleryFinal;
import cn.finalteam.galleryfinal.model.PhotoInfo;
/**
 * Created by Administrator on 2016/11/28.
 */
public class LoginActivity extends Activity implements View.OnClickListener {
    private ImageView mIvLogo;
    private Button mBtnLogin;
    private Button mBtnToregin;
    private  String choses[]={"选择相册，选择相机"};
    private ProgressDialog mDialog;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        mIvLogo = (ImageView) findViewById(R.id.iv_logo);
        mBtnLogin = (Button) findViewById(R.id.btn_login);
        mBtnToregin = (Button) findViewById(R.id.btn_toregin);
        mDialog=new ProgressDialog(this);
        mDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mDialog.setMessage("正在登录，请稍等...");
        mIvLogo.setOnClickListener(this);
        mBtnLogin.setOnClickListener(this);
        mBtnToregin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_logo:
                new AlertDialog.Builder(this)
                        .setTitle("选择照片")
                         .setSingleChoiceItems(choses, 0, new DialogInterface.OnClickListener() {
                             @Override
                             public void onClick(DialogInterface dialog, int which) {
                                 dialog.dismiss();
                                 if(which==0){
                                     //相册
                                     choseFromPictire();
                                 }else {
                                     //相机
                                     choseFromCamera();
                                 }
                             }
                         });
                break;
            case R.id.btn_login:
                if(null==url||"".equals(url)){
                    return;
                }
                loginWithPicture(url);
                break;
            case  R.id.btn_toregin:
                this.startActivity(new Intent(this, ReginActivity.class));
                break;
            default:
                break;

        }
    }

    /**
     *  通过相机获取照片
     */
    private void choseFromCamera() {
        GalleryFinal.openCamera(2, new GalleryFinal.OnHanlderResultCallback() {
            @Override
            public void onHanlderSuccess(int reqeustCode, List<PhotoInfo> resultList) {
                if(reqeustCode==2){
                    if(resultList!=null&&resultList.size()>0){
                        PhotoInfo info=resultList.get(0);
                        url=info.getPhotoPath();
                        Bitmap bm= BitmapFactory.decodeFile(url);
                        mIvLogo.setImageBitmap(bm);
                    }
                }
            }

            @Override
            public void onHanlderFailure(int requestCode, String errorMsg) {

            }
        });
    }

    /**
     *  从图库选择照片
     */
    private void choseFromPictire() {
        GalleryFinal.openGallerySingle(1, new GalleryFinal.OnHanlderResultCallback() {
            @Override
            public void onHanlderSuccess(int reqeustCode, List<PhotoInfo> resultList) {
                if(reqeustCode==1){
                   if(resultList!=null&&resultList.size()>0){
                      PhotoInfo info=resultList.get(0);
                       url=info.getPhotoPath();
                       Bitmap bm= BitmapFactory.decodeFile(url);
                       mIvLogo.setImageBitmap(bm);
                   }
                }
            }

            @Override
            public void onHanlderFailure(int requestCode, String errorMsg) {

            }
        });
    }

    /**
     *  对照片进行识别 登录
     */
    public void loginWithPicture(String path){
        mDialog.show();
        //图片登录




        mDialog.dismiss();

        this.startActivity(new Intent(this,Main.class));
        this.finish();

    }
}
