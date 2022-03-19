package ru.mirea.lebedeva.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class AlertDialogFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Hello Mirea!")
                .setMessage("Success near?")
                .setIcon(android.R.drawable.btn_star_big_on)
                .setPositiveButton("Going further", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {((MainActivity)getActivity()).onOkClicked();
                        dialog.cancel(); }
                })
                .setNeutralButton("On pause",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int id) {((MainActivity)getActivity()).onNeutralClicked();
                                dialog.cancel(); }
                        })
                .setNegativeButton("Nope",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int id) {((MainActivity)getActivity()).onCancelClicked();
                                dialog.cancel(); }
                        });
        return builder.create();
    }
}
