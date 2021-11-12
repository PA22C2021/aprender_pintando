package com.example.aprender_pintando.Domain;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.view.MotionEvent;
import android.view.View;

import com.example.aprender_pintando.Helper.CoordenadaValidatorHelper;

public class Draw extends View {

    private int ColorPaint = Color.CYAN;
    private int strokePaint = 180;
    private boolean isClean = true;

    private static Paint drawPaint;
    private Paint canvasPaint;
    private Bitmap canvasBitmap;
    private Canvas drawCanvas;
    private Path drawPath;
    private CoordenadaValidatorHelper coordValidator;
    private Coordenada coordLetra;

    public void setCoordLetra(Coordenada coordLetra) {
        this.coordLetra = coordLetra;
    }
    public void setCoordValidator(CoordenadaValidatorHelper coordValidator) {
        this.coordValidator = coordValidator;
    }

    public CoordenadaValidatorHelper getCoordValidator() {
        return coordValidator;
    }

    public Coordenada getCoordLetra() {
        return coordLetra;
    }

    public Draw(Context context) {
        super(context);
        drawPath = new Path();
        drawPaint = new Paint();
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeWidth(strokePaint);
        drawPaint.setColor(ColorPaint);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);
        canvasPaint = new Paint(Paint.DITHER_FLAG);
        coordValidator = new CoordenadaValidatorHelper();
    }

    //Tamaño asignado a la vista
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        drawCanvas = new Canvas(canvasBitmap);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        canvas.drawBitmap(canvasBitmap, 0, 0, canvasPaint);
        canvas.drawPath(drawPath, drawPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        float touchX = event.getX();
        float touchY = event.getY();

        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                drawPath.moveTo(touchX, touchY);
                break;

            case MotionEvent.ACTION_MOVE:
                drawPath.lineTo(touchX, touchY);
                break;

            case MotionEvent.ACTION_UP:
                drawPath.lineTo(touchX, touchY);
                drawCanvas.drawPath(drawPath, drawPaint);
                drawPath.reset();
                break;

            default:
                return false;
        }

        isClean = false;

        boolean termino = this.coordValidator.validarCoordenadas(touchX, touchY);

        if(termino){
            this.coordLetra.setCompleted(true);
        }

        //repintar
        invalidate();
        return true;
    }

    public boolean getIsCompleted() {
        return  this.coordLetra.getCompleted();
    }


    public boolean isClean()
    {
        return isClean;
    }

    public void ClearDraw()
    {
        isClean = true;
        drawCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        invalidate();
    }

    public void SetColor(int color)
    {
        ColorPaint = color;
        drawPaint.setColor(color);
    }

    public void SetStroke(int stroke)
    {
        strokePaint = stroke;
        drawPaint.setStrokeWidth(stroke);
    }

}