package hcmute.nhom2.foody.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import hcmute.nhom2.foody.Model.Food;
import hcmute.nhom2.foody.Model.Restaurant;
import hcmute.nhom2.foody.Model.User;
import hcmute.nhom2.foody.R;
import hcmute.nhom2.foody.Static.StaticArg;

public class RegisterActivity extends AppCompatActivity {
    Button btnRegister;
    EditText editTextTK, editTextPass, editTextName;
    List<User> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnRegister = findViewById(R.id.btnRegister);
        editTextTK = findViewById(R.id.editTextTK);
        editTextPass = findViewById(R.id.editTextMK);
        editTextName = findViewById(R.id.editTextName);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tk = editTextTK.getText().toString().trim();
                String pass = editTextPass.getText().toString().trim();
                String name = editTextName.getText().toString().trim();
                if (tk.equals("") || pass.equals("")|| name.equals("")||tk.length()<6||pass.length()<6||name.length()<6){
                    Toast.makeText(RegisterActivity.this,"Bạn phải điền đủ thông tin", Toast.LENGTH_LONG).show();
                }else if(checkRegister(tk)==true){
                    StaticArg.database.Insert_Account(
                            tk,
                            pass,
                            name
                    );
                    Toast.makeText(RegisterActivity.this,"Đăng ký thành công", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    //intent.putExtra("user", tk);
                    startActivity(intent);
                }else {
                    Toast.makeText(RegisterActivity.this,"Tài khoản đã tồn tại", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private boolean checkRegister(String tk){

        Cursor cursor = StaticArg.database.GetData("SELECT * FROM User WHERE username = '"+tk+"'");

        while (cursor.moveToNext()){
            String rs =  cursor.getString(1);
            if(rs != null)
                return false;
        }
        return true;
    }

}