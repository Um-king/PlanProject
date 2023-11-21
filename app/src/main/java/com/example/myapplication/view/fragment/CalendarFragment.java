package com.example.myapplication.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.view.object.SaturdayDecorator;
import com.example.myapplication.view.object.SundayDecorator;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;


import java.util.Calendar;
import java.util.Date;

public class CalendarFragment extends Fragment {

    MaterialCalendarView calendarView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_calendar2, container, false);
        calendarView = v.findViewById(R.id.calendarView);

        init();

        // Inflate the layout for this fragment
        return v;
    }

    private void init(){
        calendarView.state().edit()
                .setFirstDayOfWeek(Calendar.SUNDAY)
                .setMinimumDate(CalendarDay.from(1900,1,1))
                .setMaximumDate(CalendarDay.from(5000, 12, 31))
                .setCalendarDisplayMode(CalendarMode.MONTHS)
                .commit();

        calendarView.addDecorators(
                new SundayDecorator(),
                new SaturdayDecorator());

    }
}
