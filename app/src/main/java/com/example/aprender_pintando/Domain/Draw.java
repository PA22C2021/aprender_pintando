package com.example.aprender_pintando.Domain;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.aprender_pintando.Controller.LetraCtrl;
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

    ProgressBar progressBar;
    ImageView letraCompletada;
    MotorJuego motorJuego;
    LetraCtrl lCtrl;
    ImageButton btnTerminar;

    Handler handler = new Handler();

    public void setProgressBar(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    public void setLetraCompletada(ImageView letraCompletada) {
        this.letraCompletada = letraCompletada;
    }

    public void setMotorJuego(MotorJuego motorJuego) {
        this.motorJuego = motorJuego;
    }

    public void setlCtrl(LetraCtrl lCtrl) {
        this.lCtrl = lCtrl;
    }

    public void setCoordValidator(CoordenadaValidatorHelper coordValidator) {
        this.coordValidator = coordValidator;
    }

    public void setBtnTerminar(ImageButton btnTerminar) {
        this.btnTerminar = btnTerminar;
    }

    public CoordenadaValidatorHelper getCoordValidator() {
        return coordValidator;
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

    //Tama??o asignado a la vista
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
        progressBar.setProgress(coordValidator.getCantCoordenadasValidas());

        if(this.coordValidator.validarCoordenadas(touchX, touchY)){
            letraCompletada.setVisibility(VISIBLE);
            handleAnimation(getRootView());
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Do something after 5s = 5000ms
                    if(coordValidator.validarCoordenadas(touchX, touchY)){
                        motorJuego.getLetra().setCompleted(true);
                        lCtrl.actualizarLetra(motorJuego.getLetra());
                        btnTerminar.callOnClick();
                        letraCompletada.setVisibility(INVISIBLE);
                    }
                }
            }, 2000);

            return true;
        }

        //repintar
        invalidate();
        return true;
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

    public void handleAnimation (View view) {
        ObjectAnimator animatorStars = ObjectAnimator.ofFloat(letraCompletada, "y", 0f, 220f);
        animatorStars.setDuration(3000);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animatorStars);
        animatorSet.start();
    }



}