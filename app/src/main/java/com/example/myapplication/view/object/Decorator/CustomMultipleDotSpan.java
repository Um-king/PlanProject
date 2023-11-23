package com.example.myapplication.view.object.Decorator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.LineBackgroundSpan;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class CustomMultipleDotSpan implements LineBackgroundSpan {

    private Float radius;
    private ArrayList<Integer> color;

    public CustomMultipleDotSpan(Float radius, ArrayList<Integer> color){
        this.radius = radius;
        this.color = color;
    }

    @Override
    public void drawBackground(@NonNull Canvas canvas, @NonNull Paint paint,
                               int left, int right, int top, int baseline, int bottom,
                               @NonNull CharSequence charSequence,
                               int start, int end, int lineNum) {

        int total = 0;
        if(color.size() > 2)
            total = 3;
        else
            total = color.size();

        // 점과 점사이의 거리
        int leftMost = (total - 1) * -12;

        for(int i = 0; i < total; i++){
            int oldColor = paint.getColor();
            if(color.get(i) != 0){
                paint.setColor(color.get(i));
            }
            canvas.drawCircle(((left + right) / 2 - leftMost), bottom + (radius * 5), radius, paint);
            paint.setColor(oldColor);
            leftMost += 24;
        }
    }
}


// [출처] https://cnwlcjf.tistory.com/68