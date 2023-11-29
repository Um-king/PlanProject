package com.example.myapplication.view.object.Decorator;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;

public class DayViewDecorator2 implements DayViewDecorator {

    private final int color;
    private CalendarDay date;

    private Drawable mCircleDrawable;

    private Rect circleDrawableRect = new Rect();

    public DayViewDecorator2(CalendarDay date, int color) {

        this.color = color; // 배경 원의 색상을 여기에 지정
        this.date = date;
    }
    @Override
    public boolean shouldDecorate(CalendarDay day) {
        return day.equals(date);
    }

    @Override
    public void decorate(DayViewFacade view) {

        CircleDrawable circleDrawable = new CircleDrawable(color);
        view.setSelectionDrawable(circleDrawable);

        //view.setSelectionDrawable(new CircleDrawable(color));
    }
}
