package hcmute.nhom2.foody;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    EditText editTextEmail, editTextPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Anh xa
        btnLogin = findViewById(R.id.btnLogin);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPass = findViewById(R.id.editTextPass);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editTextEmail.getText().toString().trim();
                String pass = editTextPass.getText().toString().trim();
                if (email.equals("") || pass.equals("")){
                    Toast.makeText(LoginActivity.this,"Bạn phải điền đủ thông tin", Toast.LENGTH_LONG).show();
                }else if(checkLogin(email, pass)){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("user", email);
                    startActivity(intent);
                }
            }
        });
    }
    private boolean checkLogin(String email, String pass){
        return  true;
    }
}