package ru.mirea.lebedeva.dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Calendar calendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickShowDialog(View view){
        AlertDialogFragment dialogFragment = new AlertDialogFragment();
        dialogFragment.show(getSupportFragmentManager(), "mirea");
    }

    public void onOkClicked() {
        Toast.makeText(getApplicationContext(), "You chose \"Going further\" button!",
                Toast.LENGTH_LONG).show();
    }
    public void onCancelClicked() {
        Toast.makeText(getApplicationContext(), "You chose \"Nope\" button!",
                Toast.LENGTH_LONG).show();
    }
    public void onNeutralClicked() {
        Toast.makeText(getApplicationContext(), "You chose \"On pause\" button!",
                Toast.LENGTH_LONG).show();
    }

    public void onClickDate(View view){
        MyDateDialogFragment fragment = new MyDateDialogFragment();
        new DatePickerDialog(MainActivity.this, fragment.d,
                fragment.calendar.get(Calendar.YEAR),
                fragment.calendar.get(Calendar.MONTH),
                fragment.calendar.get(Calendar.DAY_OF_MONTH))
                .show();
    }

    public void onClickTime(View view) {
        MyTimeDialogFragment fragment = new MyTimeDialogFragment();
        new TimePickerDialog(this, fragment.t,
                fragment.calendar.get(Calendar.HOUR_OF_DAY),
                fragment.calendar.get(Calendar.MINUTE), true)
                .show();
    }

    public void onClickProgress(View view){
        MyProgressDialogFragment fragment = new MyProgressDialogFragment(this);
        fragment.onProgress();
    }
}