package tw.com.flag.myview2;


import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.Timer;
import java.util.TimerTask;

public class MyView extends View {
    private Bitmap ball;
    private Resources resources;
    private boolean isInit;
    private int viewW, viewH;
    private float ballX, ballY, dx ,dy, ballH, ballW;
    private Timer timer;

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        resources = context.getResources();
        ball = BitmapFactory.decodeResource(resources, R.drawable.ball);

        timer = new Timer();

    }

    private void init() {
        viewW = getWidth();
        viewH = getHeight();
        float ballW = viewW / 8f, ballH = ballW;

        Matrix matrix = new Matrix();
        matrix.postScale(ballW / ball.getWidth(), ballH / ball.getHeight());
        ball = Bitmap.createBitmap(ball, 0, 0, ball.getWidth(), ball.getHeight(), matrix, false);

        dx =10; dy=10
        ;

        timer.schedule(new BallTask(), 1000, 80);
        isInit =true;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if(!isInit) init();
        canvas.drawBitmap(ball, ballX, ballY, null);

    }


    private class BallTask extends TimerTask{
        @Override
        public void run() {
            if(ballX<0|| ballX+ballW > viewW-viewW / 7.5f){
                dx*=-1;
            }
            if(ballY<0 || ballY+ballH > viewH-viewH / 12f){
                dy*=-1;
            }


            ballX += dx;
            ballY += dy;
            postInvalidate();
        }
    }
}
