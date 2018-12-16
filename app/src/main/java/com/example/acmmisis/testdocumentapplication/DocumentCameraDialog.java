package com.example.acmmisis.testdocumentapplication;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import pl.aprilapps.easyphotopicker.EasyImage;

public class DocumentCameraDialog extends DialogFragment {
    private String inputText;
    private EditText editText;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        Bundle args = getArguments();

        builder.setView(inflater.inflate(R.layout.document_camera_dialog, null));
        builder.setTitle("Добавление документа");
        builder.setPositiveButton("Добавить", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                editText = getDialog().findViewById(R.id.document_edit_text);
                inputText = String.valueOf(editText.getText());

                takePhoto();
                Log.e("!!!", "Ввели: " + inputText);
            }
        });
        builder.setNegativeButton("Отменить", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dismiss();
            }
        });

        return builder.create();
    }

    public String getInputText() {
        return inputText;
    }

    private void takePhoto() {
        EasyImage.openCameraForImage(getActivity(), 0);
    }
}
