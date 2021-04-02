package com.example.wallpapersss;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.IOException;

public class FullImageActivity extends AppCompatActivity {

    private ImageView fullImage;
    private Button apply;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);
        fullImage = findViewById(R.id.fullimage);
        apply = findViewById(R.id.apply);

        Glide.with(this).load(getIntent().getStringExtra("image")).into(fullImage);

        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBackground();
            }
        });
    }
    private void setBackground ()
    {
        Bitmap bitmap = ((BitmapDrawable)fullImage.getDrawable()).getBitmap();

        WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());

        try {
            manager.setBitmap(bitmap);
        } catch (IOException e) {
            Toast.makeText(this,"Error" + e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

    }
}