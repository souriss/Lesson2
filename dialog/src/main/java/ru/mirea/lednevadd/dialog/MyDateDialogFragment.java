package ru.mirea.lednevadd.dialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import java.util.Calendar;
import androidx.fragment.app.DialogFragment;

public class MyDateDialogFragment extends DialogFragment {
    Calendar date = Calendar.getInstance();
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        DatePickerDialog.OnDateSetListener dateListener = (view, year, month, dayOfMonth) ->{};
        DatePickerDialog dateDialog = new DatePickerDialog(getActivity(), dateListener, date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DAY_OF_MONTH));
        dateDialog.setTitle("Выберете дату:");
        dateDialog.setButton(Dialog.BUTTON_POSITIVE, "Ок", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ((MainActivity)getActivity()).onDateClicked();
                        dialog.cancel();
                    }
                }
        );
        dateDialog.show();
        return dateDialog;
    }
}
