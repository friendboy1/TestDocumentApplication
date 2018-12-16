package com.example.acmmisis.testdocumentapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.File;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DocumentFullPhotoActivity extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.document_full_photo_fragment);
        imageView = findViewById(R.id.document_full_image_view);
        String path = getIntent().getStringExtra("qwer");
        File imgFile = new File(path);

        if (imgFile.exists()) {
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            imageView.setImageBitmap(DocumentFragment.createRotatedBitmap(myBitmap, path));
        }
    }


    public static void start(Activity activity, String path) {
        final Intent intent = new Intent(activity, DocumentFullPhotoActivity.class);
        intent.putExtra("qwer", path);
        activity.startActivity(intent);
    }
}
