package com.example.aprender_pintando.Domain;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;

public class Draw extends View {

    private int ColorPaint = Color.CYAN;
    private int strokePaint = 180;
    private boolean isClean = true;

    private static Paint drawPaint;
    private Paint canvasPaint;
    private Bitmap canvasBitmap;
    private Canvas drawCanvas;
    private Path drawPath;
    private ArrayList<Cordenada> listaDePixeles;
    private int cordenadasValidas;

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
        this.cordenadasValidas = 0;
        this.listaDePixeles = Cordenada.getAllPixelesReferencias();
    }

    public void setCordenadasValidas(int cordenadasValidas) {
        this.cordenadasValidas = cordenadasValidas;
    }

    public int getCordenadasValidas(){
        return this.cordenadasValidas;
    }

    public ArrayList<Cordenada> getListaDePixeles(){
        return this.listaDePixeles;
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

        Log.d("posiciones en pantalla","onTouchEvent: X:" + touchX + " Y:" + touchY);

        isClean = false;

        // Log.d("X: ",  touchX + "  - Y: " + touchY);

        boolean termino = validarPixel(touchX,  touchY);

        if(termino){
            Log.d("No  lo puedo  creer", touchY + "");
        }



        //repintar
        invalidate();
        return true;
    }

    public boolean validarPixel (float touchX, float touchY){


        for(Cordenada c : this.listaDePixeles){
            float pixelWithMarginErrorXPlus = c.getX() + 90;
            float pixelWithMarginErrorXMinus = c.getX() - 90;
            float pixelWithMarginErrorYPlus = c.getY() + 90;
            float pixelWithMarginErrorYMinus = c.getY() - 90;
            if(touchX <= pixelWithMarginErrorXPlus && touchX >= pixelWithMarginErrorXMinus &&
                    touchY <= pixelWithMarginErrorYPlus && touchY >= pixelWithMarginErrorYMinus
            ){
                if (!c.getCompleted()) {
                    c.setCompleted(true);
                    this.setCordenadasValidas(this.getCordenadasValidas() + 1);
                    Log.d("Tildo  un pixel", this.getCordenadasValidas() + "");
                    Log.d("Size", this.listaDePixeles.size() + "");
                }
            }
        }

        boolean estaCompleta =  false;

        if(this.getCordenadasValidas() == this.listaDePixeles.size() ){
            // TODO: mostrar imagen

            estaCompleta = true;
        }

        return estaCompleta;

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