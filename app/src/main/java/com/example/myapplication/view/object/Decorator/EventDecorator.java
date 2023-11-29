package com.example.myapplication.view.object.Decorator;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;

import com.example.myapplication.R;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;

public class EventDecorator implements DayViewDecorator {

    private ArrayList<Integer> colors;
    private int color;
    private HashSet<CalendarDay> dates;

    private Drawable drawable;

    public EventDecorator(int color, Collection<CalendarDay> dates){
        this.color = color;
        this.dates = new HashSet<>(dates);

    }

    public EventDecorator(int color, Collection<CalendarDay> dates, Activity context){
        this.color = color;
        this.dates = new HashSet<>(dates);

        //this.drawable = context.getDrawable(R.drawable.borderline_kakaologinbtn);
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        return dates.contains(day);
        //return true; // true 리턴시 모든 요일에 내가 설정한 드로어블이 적용된다.
    }

    @Override
    public void decorate(DayViewFacade view) {

        colors = new ArrayList<Integer>();

        for(int i = 0; i < 5; i++){
            switch (i){
                case 0:
                    colors.add(Color.RED);
                    break;
                case 1:
                    colors.add(Color.YELLOW);
                    break;
                case 2:
                    colors.add(Color.GREEN);
                    break;
                case 3:
                    colors.add(Color.BLUE);
                    break;
                case 4:
                    colors.add(Color.BLACK);
                    break;
            }
        }

        //view.setSelectionDrawable(drawable);

        // 점을 여러개 출력
        view.addSpan(new CustomMultipleDotSpan(7f, colors));
    }
}

// [출처] https://cnwlcjf.tistory.com/68