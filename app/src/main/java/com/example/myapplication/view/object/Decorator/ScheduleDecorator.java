package com.example.myapplication.view.object.Decorator;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.spans.DotSpan;

import java.util.Collection;
import java.util.HashSet;

/*
* 해당 날짜란에 색상 점을 찍는다.
*/
public class ScheduleDecorator implements DayViewDecorator {

    private int color;
    private HashSet<CalendarDay> dates;

    public ScheduleDecorator(int color, Collection<CalendarDay> dates){
        this.color = color;
        this.dates = new HashSet<>(dates);
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        return dates.contains(day);
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.addSpan(new DotSpan(5, color));
    }

}

// [출처] https://gameprograming.tistory.com/152
