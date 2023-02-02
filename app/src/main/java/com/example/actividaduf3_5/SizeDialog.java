package com.example.actividaduf3_5;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.snackbar.Snackbar;

public class SizeDialog extends DialogFragment {

    SizeDataListener sizeDataListener;
    EditText etSize;





    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_size, null);
        etSize = view.findViewById(R.id.et_size);
        etSize.setText(String.valueOf(MainActivity.TAG));

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view);

        builder.setTitle(R.string.title_dialog)
                .setPositiveButton(R.string.btn_accept,null)
                .setNegativeButton(R.string.btn_cancel, (dialog, which) -> dialog.cancel());

        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);

        dialog.setOnShowListener(dialogInterface -> {
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(btn -> {
                if (etSize.getText().toString().isEmpty() || Integer.parseInt(etSize.getText().toString()) <= 0)
                    Snackbar.make(btn, R.string.error_data, Snackbar.LENGTH_SHORT).show();
                else {
                    sizeDataListener.onAcceptSizeListener(Integer.parseInt(etSize.getText().toString()));
                    dialog.dismiss();
                }
            });
        });

        return dialog;
    }
    /**
     * Este metodo es el que le indica al listener que implemente la interfaz SizeListener
     * De esta manera, el listener puede acceder a los metodos de la interfaz.
     * Si no lo implementa, se lanza una excepcion
     * @param context
     */
    @Override
    public void onAttach(@NonNull Context context){
        super.onAttach(context);
        if (context instanceof SizeDataListener){
            sizeDataListener = (SizeDataListener) context;
        }else{
            throw new RuntimeException(context.toString() + getString(R.string.error_onAttach));
        }
    }

    public void onDetach(){
        if (sizeDataListener != null){
            sizeDataListener = null;
        }
    super.onDetach();
    }
}
