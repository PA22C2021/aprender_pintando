package com.example.aprender_pintando.Domain;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

public class Draw extends View {

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
        paint.setStrokeWidth(25);
        paint.setColor(Color.WHITE);
        paint.setAntiAlias(true);

        if (action.equals("down"))
        {
            path.moveTo(x, y);
        }

        if (action.equals("move"))
        {
            path.lineTo(x, y);
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

    public void ClearDraw()
    {
        path.reset();
    }
}