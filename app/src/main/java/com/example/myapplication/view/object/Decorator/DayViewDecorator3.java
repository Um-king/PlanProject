package com.example.myapplication.view.object.Decorator;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.text.style.LineBackgroundSpan;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewFacade;

public class DayViewDecorator3 implements com.prolificinteractive.materialcalendarview.DayViewDecorator {

    private final int color;
    private CalendarDay date;

    public DayViewDecorator3(CalendarDay date, int color) {
        this.color = color;
        this.date = date;
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        return day.equals(date);
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.addSpan(new CircleSpan(color));
    }

    private class CircleSpan implements LineBackgroundSpan {

        private final int color;

        public CircleSpan(int color) {
            this.color = color;
        }

        @Override
        public void drawBackground(
                Canvas canvas, Paint paint,
                int left, int right, int top, int baseline, int bottom,
                CharSequence charSequence,
                int start, int end, int lineNum
        ) {
            int x = left + (right - left) / 2;
            int y = top + (bottom - top) / 2;

            int width = right - left;
            int height = bottom - top;
            final int radius = Math.min(height, width);
            final int offset = Math.abs(height - width) / 2;

            // Lollipop platform bug. Circle drawable offset needs to be half of normal offset
            final int circleOffset =
                    Build.VERSION.SDK_INT == Build.VERSION_CODES.LOLLIPOP ? offset / 2 : offset;

            Rect rect;
            if (width >= height) {
                rect = new Rect(circleOffset, 0, radius + circleOffset, height);
            } else {
                rect = new Rect(0, circleOffset, width, radius + circleOffset);
            }

            paint.setColor(color);
            paint.setStyle(Paint.Style.FILL);

            canvas.drawCircle(x, y, radius, paint);
        }
    }
}
