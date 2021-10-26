package com.example.aprender_pintando.Domain;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

public class Draw extends View {

    boolean isClean = true;
    float x = 0;
    float y = 0;
    String action = "action";
    Path path =  new Path();

    public Draw(Context context) {
        super(context);
    }

    public void onDraw(Canvas canvas)
    {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(30);
        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);

        if (action.equals("down"))
        {
            path.moveTo(x, y);
        }

        if (action.equals("move"))
        {
            path.lineTo(x, y);
            isClean = false;
        }

        canvas.drawPath(path, paint);
    }

    public boolean onTouchEvent(MotionEvent e)
    {
        x = e.getX();
        y = e.getY();

        if (e.getAction() == MotionEvent.ACTION_DOWN)
        {
            action = "down";
        }

        if (e.getAction() == MotionEvent.ACTION_MOVE)
        {
            action = "move";
        }

        invalidate();
        return true;
    }

    public boolean isClean()
    {
        return isClean;
    }

    public void ClearDraw()
    {
        x = 0;
        y = 0;

        path.reset();
        invalidate();
    }
}