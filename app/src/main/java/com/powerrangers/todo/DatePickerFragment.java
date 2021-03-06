package com.powerrangers.todo;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.util.Log;
import android.widget.DatePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DatePickerFragment extends DialogFragment
    implements DatePickerDialog.OnDateSetListener {

    DatePickedListener listener;

    public interface DatePickedListener {
        public void returnDate (String date);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        listener = (DatePickedListener) getActivity();

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
      Calendar c = Calendar.getInstance();
      c.set(year, month, day);

      SimpleDateFormat sdf = new SimpleDateFormat("EEEE, MMM d");
      String formattedDate = sdf.format(c.getTime());
      if (listener != null)
      {
        listener.returnDate(formattedDate);
      }
    }
}
