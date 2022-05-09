package hcmute.nhom2.foody.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import hcmute.nhom2.foody.Model.User;
import hcmute.nhom2.foody.R;
import hcmute.nhom2.foody.Static.StaticArg;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin,btnRegister,btnBack;
    EditText editTextEmail, editTextPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Anh xa
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister1);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPass = findViewById(R.id.editTextPass);
        btnBack=findViewById(R.id.btnBack1);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editTextEmail.getText().toString().trim();
                String pass = editTextPass.getText().toString().trim();
                if (email.equals("") || pass.equals("")) {
                    Toast.makeText(LoginActivity.this, "Bạn phải điền đủ thông tin", Toast.LENGTH_LONG).show();
                }else if(email.equals("admin") && pass.equals("admin")){
                    StaticArg.user = new User(-1, "admin");
                    Toast.makeText(LoginActivity.this, "Đăng nhập thành công bằng tài khoản admin", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }else if(checkLogin(email, pass)){
                    Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_LONG).show();
                    StaticArg.database.Update_Order(1);
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(LoginActivity.this,"Thông tin đăng nhập không hợp lệ", Toast.LENGTH_LONG).show();
                }
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
    private boolean checkLogin(String email, String pass){
        Cursor cursor = StaticArg.database.GetData("SELECT * FROM User WHERE username = '"+email+"' and pass= '"+pass+"'");
        while (cursor.moveToNext()){
            String rs =  cursor.getString(1);
            if(rs != null){
                int idUser=cursor.getInt(0);
                String name=cursor.getString(3);
                StaticArg.user=new User(idUser,name);
                return true;
            }

        }
        return false;
    }
}