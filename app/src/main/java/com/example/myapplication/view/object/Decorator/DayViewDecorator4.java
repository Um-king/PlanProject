package com.example.myapplication.view.object.Decorator;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.LineBackgroundSpan;
import android.view.View;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewFacade;

public class DayViewDecorator4 implements com.prolificinteractive.materialcalendarview.DayViewDecorator {

    private final int color;
    private CalendarDay date;

    private Drawable circleDrawable;
    private CalendarDay previousDate;

    public DayViewDecorator4(CalendarDay date, int color) {
        this.color = color;
        this.date = date;
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        return day.equals(date);
    }

    @Override
    public void decorate(DayViewFacade view) {
        // 이전에 선택된 날짜의 원을 제거
        if (previousDate != null) {
            view.setBackgroundDrawable(null);
        }

        // 현재 선택된 날짜에 원을 추가
        CircleSpan circleSpan = new CircleSpan(color);
//        view.setBackgroundDrawable(circleSpan);
        view.setSelectionDrawable(circleSpan);

        // 이전에 선택된 날짜 업데이트
        previousDate = date;
    }

    private static class CircleSpan extends Drawable {

        private final int color;

        public CircleSpan(int color) {
            this.color = color;
        }

        @Override
        public void draw(Canvas canvas) {
            // draw the circle on the canvas using the specified color
            int x = canvas.getWidth() / 2;
            int y = canvas.getHeight() / 2;
            int radius = Math.min(canvas.getWidth(), canvas.getHeight()) / 2;

            Paint paint = new Paint();
            paint.setColor(color);
            paint.setStyle(Paint.Style.FILL);

            canvas.drawCircle(x, y, radius, paint);
        }

        @Override
        public void setAlpha(int alpha) {
            // not implemented
        }

        @Override
        public void setColorFilter(ColorFilter colorFilter) {
            // not implemented
        }

        @Override
        public int getOpacity() {
            return PixelFormat.OPAQUE;
        }

        @Override
        public void setBounds(int left, int top, int right, int bottom) {
            // Set the bounds of the drawable
            super.setBounds(left, top, right, bottom);
        }
    }

}
