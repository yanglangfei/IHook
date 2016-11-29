package com.yf.ihook.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.facepp.error.FaceppParseException;
import com.facepp.http.HttpRequests;
import com.facepp.http.PostParameters;
import com.google.gson.Gson;
import com.yf.ihook.R;
import com.yf.ihook.model.Face;

import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

import cn.finalteam.galleryfinal.GalleryFinal;
import cn.finalteam.galleryfinal.model.PhotoInfo;
import cn.finalteam.toolsfinal.io.stream.ByteArrayOutputStream;

/**
 * Created by Administrator on 2016/11/28.
 */
public class LoginActivity extends Activity implements View.OnClickListener {
    private ImageView mIvLogo;
    private Button mBtnLogin;
    private Button mBtnToregin;
    private  String choses[]={"选择相册","选择相机"};
    private  String loginUrl="http://apicn.faceplusplus.com/v2/detection/detect";
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
                         }).show();
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
    public void loginWithPicture(final String path) {
       // mDialog.show();
        //图片登录
        new Thread(){
            @Override
            public void run() {
                HttpRequests requests=new HttpRequests("cdfc73b3f9047a75c01317a13c9bb3b1","p4aMTlZU5pxf0oz3U8QqD6iXjfHPxs3l",true,true);
                JSONObject result = null;
                try {
                    Bitmap bm=BitmapFactory.decodeFile(path);
                    ByteArrayOutputStream bos=new ByteArrayOutputStream();
                    bm.compress(Bitmap.CompressFormat.JPEG,100,bos);
                    result = requests.detectionDetect(new PostParameters().setImg(bos.toByteArray()));
                    Gson gson=new Gson();
                    Face face = gson.fromJson(result.toString(), Face.class);
                    List<Face.FaceBean> faceBean = face.getFace();
                    for (int i = 0; i < faceBean.size(); i++) {
                        String faceId = faceBean.get(i).getFace_id();
                        Log.i("111","id:"+faceId);
                    }
                } catch (FaceppParseException e) {
                    e.printStackTrace();
                }
            }
        }.start();
      //  mDialog.dismiss();


    }
}
