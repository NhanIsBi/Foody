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
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import hcmute.nhom2.foody.R;
import hcmute.nhom2.foody.Static.StaticArg;

public class AddFoodActivity extends AppCompatActivity {
    Button btnAdd,btnCancel,btnBack;
    EditText edtNameFood,edtIDRES,editPrice;
    ImageButton imgCam,imgFodel;
    ImageView imgHinh;

    final int REQUEST_CODE_CAMERA=123;
    final int REQUEST_CODE_FOLDER=456;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);

        Anhxa();

        btnBack=findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddFoodActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        imgCam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(intent,REQUEST_CODE_CAMERA);
                ActivityCompat.requestPermissions(
                        AddFoodActivity.this,
                        new String[]{Manifest.permission.CAMERA},
                        REQUEST_CODE_CAMERA
                );
            }
        });
        imgFodel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent=new Intent(Intent.ACTION_PICK);
//                intent.setType("image/*");
//                startActivityForResult(intent,REQUEST_CODE_FOLDER);
                ActivityCompat.requestPermissions(
                        AddFoodActivity.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_CODE_FOLDER
                );
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameFood = edtNameFood.getText().toString().trim();
                String price = editPrice.getText().toString().trim();
                String IdRes = edtIDRES.getText().toString().trim();
                if(nameFood.equals("")||price.equals("")||IdRes.equals("")){
                    Toast.makeText(AddFoodActivity.this,"Bạn phải điền đủ thông tin",Toast.LENGTH_SHORT).show();
                }else{
                    //chuyển imageview -> byte[]
                    BitmapDrawable bitmapDrawable= (BitmapDrawable) imgHinh.getDrawable();
                    Bitmap bitmap= bitmapDrawable.getBitmap();
                    ByteArrayOutputStream byteArray=new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG,100,byteArray);
                    byte[] hinhanh=byteArray.toByteArray();

                    StaticArg.database.Insert_Food(
                            hinhanh,
                            edtNameFood.getText().toString().trim(),
                            Double.parseDouble(editPrice.getText().toString().trim()),
                            Integer.parseInt(edtIDRES.getText().toString().trim())
                    );
                    Toast.makeText(AddFoodActivity.this,"Đã thêm",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(AddFoodActivity.this,MainActivity.class));
                }

            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtNameFood.setText("");
                editPrice.setText("");
                edtIDRES.setText("");
                imgHinh.setImageBitmap(null);
                Toast.makeText(AddFoodActivity.this,"Đã huỷ",Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(this, "Bạn không cho phép mở camera!", Toast.LENGTH_SHORT).show();
                }
                break;
            case REQUEST_CODE_FOLDER:
                if(grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
                    Intent intent=new Intent(Intent.ACTION_PICK);
                    intent.setType("image/*");
                    startActivityForResult(intent,REQUEST_CODE_FOLDER);
                }else{
                    Toast.makeText(this, "Bạn không cho phép mở folder!", Toast.LENGTH_SHORT).show();
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
        btnAdd =(Button) findViewById(R.id.buttonAddFood);
        btnCancel=(Button) findViewById(R.id.buttonCancelFood);
        edtNameFood=(EditText) findViewById(R.id.editNameFood);
        edtIDRES=(EditText) findViewById(R.id.editIdRes);
        editPrice=(EditText) findViewById(R.id.editPrice);
        imgHinh=(ImageView) findViewById(R.id.imageViewHinhFood);
        imgCam=(ImageButton) findViewById(R.id.imageButtonCamFood);
        imgFodel=(ImageButton) findViewById(R.id.imageButtonFodelFood);
    }
}