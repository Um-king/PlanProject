package com.example.myapplication.view.object.Decorator;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.text.style.ForegroundColorSpan;
import android.text.style.LineBackgroundSpan;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;


public class DayViewDecorator implements com.prolificinteractive.materialcalendarview.DayViewDecorator {

    private final int color;
    private CalendarDay date;

    private Drawable mCircleDrawable;

    private Rect circleDrawableRect = new Rect();

    private Drawable d;

    public DayViewDecorator(CalendarDay date, int color) {

        this.color = color; // 배경 원의 색상을 여기에 지정
        this.date = date;
    }

    public DayViewDecorator(Context context, CalendarDay date, int color) {

        this.color = color; // 배경 원의 색상을 여기에 지정
        this.date = date;

        this.d = context.getResources().getDrawable(R.drawable.borderline_home_001);
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        return day.equals(date);
    }

    @Override
    public void decorate(DayViewFacade view) {

//        view.setSelectionDrawable(new CircleDrawable(color));

//        view.setBackgroundDrawable(new Drawable() {
//            @Override
//            public void draw(Canvas canvas) {
//                // 원을 그리기 위한 Paint 설정
//                Paint paint = new Paint();
//                paint.setColor(color);
//                paint.setAntiAlias(true);
//
//                // 원을 Canvas에 그림
//                canvas.drawCircle(canvas.getWidth() / 2f, canvas.getHeight() / 2f, Math.min(canvas.getWidth(), canvas.getHeight()) / 2f, paint);
//            }
//
//            @Override
//            public void setAlpha(int i) {
//
//            }
//
//            @Override
//            public void setColorFilter(@Nullable ColorFilter colorFilter) {
//
//            }
//
//            @Override
//            public int getOpacity() {
//                return PixelFormat.OPAQUE;
//            }
//        });

//
        CircleSpan circleSpan = new CircleSpan(this.color);
        circleDrawableRect = circleSpan.rect;

        //mCircleDrawable.setBounds(circleDrawableRect);
        mCircleDrawable = generateBackground(color, 3, circleDrawableRect);
        view.setBackgroundDrawable(mCircleDrawable);
        //view.addSpan(new ForegroundColorSpan(Color.BLACK));

        //view.setBackgroundDrawable(d);
    }


    private static Drawable generateBackground(int color, int fadeTime, Rect bounds) {
        StateListDrawable drawable = new StateListDrawable();
        drawable.setExitFadeDuration(fadeTime);
        drawable.addState(new int[] { android.R.attr.state_checked }, generateCircleDrawable(color));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            drawable.addState(
                    new int[] { android.R.attr.state_pressed },
                    generateRippleDrawable(color, bounds)
            );
        } else {
            drawable.addState(new int[] { android.R.attr.state_pressed }, generateCircleDrawable(color));
        }

        drawable.addState(new int[] { }, generateCircleDrawable(Color.TRANSPARENT));

        return drawable;
    }

    private static Drawable generateCircleDrawable(final int color) {
        ShapeDrawable drawable = new ShapeDrawable(new OvalShape());
        drawable.getPaint().setColor(color);

        return drawable;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private static Drawable generateRippleDrawable(final int color, Rect bounds) {
        ColorStateList list = ColorStateList.valueOf(color);
        Drawable mask = generateCircleDrawable(Color.WHITE);
        RippleDrawable rippleDrawable = new RippleDrawable(list, null, mask);
        //        API 21
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.LOLLIPOP) {
            rippleDrawable.setBounds(bounds);
        }

        //        API 22. Technically harmless to leave on for API 21 and 23, but not worth risking for 23+
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.LOLLIPOP_MR1) {
            int center = (bounds.left + bounds.right) / 2;
            rippleDrawable.setHotspotBounds(center, bounds.top, center, bounds.bottom);
        }

        return rippleDrawable;
    }


    private static class CircleSpan implements LineBackgroundSpan {

        private final int color;
        private Rect rect = new Rect();

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
            //int radius = Math.min((right - left) / 2, (bottom - top) / 2);
            int x = left + (right - left) / 2;
            int y = top + (bottom - top) / 2;

//            paint.setColor(color);
//            paint.setStyle(Paint.Style.FILL);
//
//            canvas.drawCircle(x, y, radius, paint);

            int width = right - left;
            int height = bottom - top;
            final int radius = Math.min(height, width);
            final int offset = Math.abs(height - width) / 2;

            // Lollipop platform bug. Circle drawable offset needs to be half of normal offset
            final int circleOffset =
                    Build.VERSION.SDK_INT == Build.VERSION_CODES.LOLLIPOP ? offset / 2 : offset;


            if (width >= height) {
                rect.set(circleOffset, 0, radius + circleOffset, height);
            } else {
                rect.set(0, circleOffset, width, radius + circleOffset);
            }


            paint.setColor(color);
            paint.setStyle(Paint.Style.FILL);

            canvas.drawCircle(x, y, radius, paint);
        }
    }
}
