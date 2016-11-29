package com.yf.ihook.db;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.yf.ihook.model.User;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Administrator on 2016/11/28.
 */
public class DbManager  {
    public  SQLiteDatabase initDb(Context context,String name,int version){
        DbHelper helper=new DbHelper(context,name,version);
        return helper.getReadableDatabase();
    }

    public  long addData(User user,SQLiteDatabase db){
        ContentValues values=new ContentValues();
        values.put("name",user.getName());
        return  db.insert("table",null,values);
    }

    public  long delData(User user,SQLiteDatabase db){
       return db.delete("table","id=?",new String[]{1+""});
    }

    public  long updateData(User user,SQLiteDatabase db){
        ContentValues values=new ContentValues();
        values.put("name",user.getName());
        return  db.update("table",values,"id=?",new String[]{1+""});
    }

    public List<User> queryAll(SQLiteDatabase db){
        List<User> users=new ArrayList<>();
        Cursor cursor = db.query("table", null, null, null, null, null, null);
        while (cursor.moveToNext()){
           String name= cursor.getString(0);
            User user=new User();
            user.setName(name);
            users.add(user);
        }
        return users;
    }

    public User queryUserById(SQLiteDatabase db,int id){
        Cursor cursor = db.query("table", null, "id=?", new String[]{id+""}, null, null, null);
        while (cursor.moveToNext()){
            String name= cursor.getString(0);
            User user=new User();
            user.setName(name);
            return  user;
        }
        return null;
    }
}
