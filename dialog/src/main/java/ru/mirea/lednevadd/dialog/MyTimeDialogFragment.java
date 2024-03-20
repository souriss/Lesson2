package ru.mirea.lednevadd.dialog;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import java.util.Calendar;
import androidx.fragment.app.DialogFragment;

public class MyTimeDialogFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar time = Calendar.getInstance();
        TimePickerDialog.OnTimeSetListener timeListener = (view, hourOfDay, minute) ->{};
        TimePickerDialog timeDialog = new TimePickerDialog(getActivity(), timeListener, time.get(Calendar.HOUR_OF_DAY), time.get(Calendar.MINUTE), true);
        timeDialog.setTitle("Выберете час:");
        timeDialog.setButton(Dialog.BUTTON_NEUTRAL, "Ок", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ((MainActivity)getActivity()).onTimeClicked();
                        dialog.cancel();
                    }
                }
        );
        timeDialog.show();
        return timeDialog;
    }
}
