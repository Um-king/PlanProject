package com.example.myapplication.view.object.Decorator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;

public class CircleDrawable extends Drawable {

    private final int color;
    private final Paint paint;

    public CircleDrawable(int color) {
        this.color = color;
        this.paint = new Paint();
        paint.setColor(color);
        paint.setAntiAlias(true);
    }

    @Override
    public void draw(Canvas canvas) {
        Log.d("CircleDrawable", "draw function called");
        Rect bounds = getBounds();
        canvas.drawCircle(bounds.centerX(), bounds.centerY(),
                Math.min(bounds.width(), bounds.height()) / 2f, paint);
    }

    @Override
    public void setAlpha(int alpha) {
        // 필요에 따라 구현
    }

    @Override
    public void setColorFilter(android.graphics.ColorFilter colorFilter) {
        // 필요에 따라 구현
    }

    @Override
    public int getOpacity() {
        return android.graphics.PixelFormat.OPAQUE;
    }
}