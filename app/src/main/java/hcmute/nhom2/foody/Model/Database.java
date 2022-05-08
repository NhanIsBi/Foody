package hcmute.nhom2.foody.Model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

import java.sql.ResultSet;

public class Database extends SQLiteOpenHelper {

    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void QueryData(String sql){
        SQLiteDatabase database=getWritableDatabase();
        database.execSQL(sql);
    }
    public void Insert_Res(String ten,byte[] hinh){
        SQLiteDatabase database=getWritableDatabase();
        String sql="INSERT INTO QuanAn VALUES(null,?,?)";
        SQLiteStatement statement=database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1,ten);
        statement.bindBlob(2,hinh);

        int a = (int) statement.executeInsert();
        //Log.d("AAAAAAAA: ",String.valueOf(a));
    }
    public void Insert_Food(byte[] hinh,String ten,int price,int ResId){
        SQLiteDatabase database=getWritableDatabase();
        String sql="INSERT INTO Food VALUES(null,?,?,?,?)";
        SQLiteStatement statement=database.compileStatement(sql);
        statement.clearBindings();

        statement.bindDouble(1,ResId);
        statement.bindString(2,ten);
        statement.bindDouble(3,price);
        statement.bindBlob(4,hinh);

        int a = (int) statement.executeInsert();
        //Log.d("AAAAAAAA: ",String.valueOf(a));
    }
    public void Insert_Cart(int UserID,int FoodID,int Amount,int OderID){
        SQLiteDatabase database=getWritableDatabase();
        String sql="INSERT INTO Cart VALUES(null,?,?,?,?)";
        SQLiteStatement statement=database.compileStatement(sql);
        statement.clearBindings();

        statement.bindDouble(1,UserID);
        statement.bindDouble(2,FoodID);
        statement.bindDouble(3,Amount);
        statement.bindDouble(4,OderID);

        int a = (int) statement.executeInsert();
        //Log.d("AAAAAAAA: ",String.valueOf(a));
    }
    public void Insert_Account(String tk,String mk,String name){
        SQLiteDatabase database=getWritableDatabase();
        String sql="INSERT INTO User VALUES(null,?,?,?)";
        SQLiteStatement statement=database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1,tk);
        statement.bindString(2,mk);
        statement.bindString(3,name);

        int a = (int) statement.executeInsert();
        //Log.d("AAAAAAAA: ",String.valueOf(a));
    }

    public Cursor GetData(String sql){
        SQLiteDatabase database=getReadableDatabase();
        return database.rawQuery(sql,null);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
