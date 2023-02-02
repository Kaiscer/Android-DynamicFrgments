package com.example.actividaduf3_5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SizeDataListener {

    Button btnChangeSize;
    static int TAG = 24;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnChangeSize = findViewById(R.id.btn_changeSize);
        btnChangeSize.setOnClickListener(btn -> {
            SizeDialog dialogFragment = new SizeDialog();
            dialogFragment.setCancelable(false);
            dialogFragment.show(getSupportFragmentManager(), "SizeDialogFragment");
        });
    }

    /**
     * El suppressLint es para que no me salga el error de que el metodo no esta sobrescrito
     *
     *@return
     */
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_exit:
                showMessageExit();
                break;
            case R.id.menu_java:
                fragmentManage(new JavaFragment());
                break;
            case R.id.menu_python:
                fragmentManage(new PythonFragment());
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void fragmentManage(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_containerView, fragment)
                .addToBackStack(null)
                .commit();
    }


    private void showMessageExit() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage(R.string.message_exit);
        builder.setPositiveButton(R.string.btn_accept, (dialog, which) -> finish());
        builder.setNegativeButton(R.string.btn_cancel, (dialog, which) -> dialog.cancel());

        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }


    @Override
    public void onAcceptSizeListener(int size) {
        this.TAG = size;

    }
}