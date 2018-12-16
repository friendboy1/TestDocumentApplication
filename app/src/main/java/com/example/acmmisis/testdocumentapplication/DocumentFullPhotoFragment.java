package com.example.acmmisis.testdocumentapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.File;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DocumentFullPhotoFragment extends Fragment {
    private ImageView imageView;

    public static DocumentFullPhotoFragment newInstanse(String path) {
        DocumentFullPhotoFragment documentFullPhotoFragment = new DocumentFullPhotoFragment();
        Bundle bundle = new Bundle();
        bundle.putString("12311", path);
        documentFullPhotoFragment.setArguments(bundle);
        return documentFullPhotoFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.document_full_photo_fragment, container, false);
        imageView = view.findViewById(R.id.document_full_image_view);
        if (getArguments() != null) {
            String path = getArguments().getString("12311");
            File imgFile = new  File(path);

            if(imgFile.exists()){
                Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
                imageView.setImageBitmap(DocumentFragment.createRotatedBitmap(myBitmap, path));
            }
        }
        return view;
    }


}
