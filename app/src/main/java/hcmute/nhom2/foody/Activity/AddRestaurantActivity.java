package hcmute.nhom2.foody.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import hcmute.nhom2.foody.FragmentCustom.HomeFragment;
import hcmute.nhom2.foody.R;
import hcmute.nhom2.foody.Static.StaticArg;

public class AddRestaurantActivity extends AppCompatActivity {
    Button btnAdd,btnCancel,btnBack;
    EditText edtName;
    ImageButton imgCam,imgFodel;
    ImageView imgHinh;

    final int REQUEST_CODE_CAMERA=123;
    final int REQUEST_CODE_FOLDER=456;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_restaurant);

        Anhxa();

        btnBack=findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddRestaurantActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        imgCam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(
                        AddRestaurantActivity.this,
                        new String[]{Manifest.permission.CAMERA},
                        REQUEST_CODE_CAMERA
                );
            }
        });
        imgFodel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(
                        AddRestaurantActivity.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_CODE_FOLDER
                );
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtName.getText().toString().trim();
                if(edtName.equals("")){
                    Toast.makeText(AddRestaurantActivity.this,"B???n ph???i ??i???n ????? th??ng tin",Toast.LENGTH_SHORT).show();
                }else {
                    //chuy???n imageview -> byte[]
                    BitmapDrawable bitmapDrawable = (BitmapDrawable) imgHinh.getDrawable();
                    Bitmap bitmap = bitmapDrawable.getBitmap();
                    ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArray);
                    byte[] hinhanh = byteArray.toByteArray();

                    StaticArg.database.Insert_Res(
                            edtName.getText().toString().trim(),
                            hinhanh
                    );
                    Toast.makeText(AddRestaurantActivity.this, "???? th??m", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(AddRestaurantActivity.this, MainActivity.class));
                }
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtName.setText("");
                imgHinh.setImageBitmap(null);
                Toast.makeText(AddRestaurantActivity.this,"???? hu???",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case REQUEST_CODE_CAMERA:
                if(grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
                    Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent,REQUEST_CODE_CAMERA);
                }else{
                    Toast.makeText(this, "B???n kh??ng cho ph??p m??? camera!", Toast.LENGTH_SHORT).show();
                }
                break;
            case REQUEST_CODE_FOLDER:
                if(grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
                    Intent intent=new Intent(Intent.ACTION_PICK);
                    intent.setType("image/*");
                    startActivityForResult(intent,REQUEST_CODE_FOLDER);
                }else{
                    Toast.makeText(this, "B???n kh??ng cho ph??p m??? folder!", Toast.LENGTH_SHORT).show();
                }
                break;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==REQUEST_CODE_CAMERA && resultCode==RESULT_OK && data!=null){
            Bitmap bitmap=(Bitmap) data.getExtras().get("data");
            imgHinh.setImageBitmap(bitmap);
        }
        if(requestCode==REQUEST_CODE_FOLDER && resultCode==RESULT_OK && data!=null){
            Uri uri=data.getData();
            try {
                InputStream inputStream=getContentResolver().openInputStream(uri);
                Bitmap bitmap= BitmapFactory.decodeStream(inputStream);
                imgHinh.setImageBitmap(bitmap);
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void Anhxa(){
        btnAdd =(Button) findViewById(R.id.buttonThem);
        btnCancel=(Button) findViewById(R.id.buttonHuy);
        edtName=(EditText) findViewById(R.id.editName);
        imgHinh=(ImageView) findViewById(R.id.imageViewHinh);
        imgCam=(ImageButton) findViewById(R.id.imageButtonCam);
        imgFodel=(ImageButton) findViewById(R.id.imageButtonFodel);
    }
}