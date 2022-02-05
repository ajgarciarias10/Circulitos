package es.tonicotitular.circulitos.MovimientoBolas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.TranslateAnimation;

import java.util.ArrayList;
import java.util.List;

import es.tonicotitular.circulitos.MovimientoBolas.Ball;

public class GraphicViewParteFacil extends View  {
    private static List<Ball> ballsfacil = new ArrayList<>();
    TranslateAnimation an ;
    public GraphicViewParteFacil(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    public GraphicViewParteFacil(Context context) {
        super(context);
        init();
    }
    private void init(){
        //Add a new ball to the view
        ballsfacil.add(new Ball(50,50,100,Color.RED,30));
        ballsfacil.add(new Ball(50,50,100,Color.RED,32));
        ballsfacil.add(new Ball(50,50,100,Color.YELLOW,20));
        ballsfacil.add(new Ball(50,50,100,Color.YELLOW,34));
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //Draw the balls
        for(Ball ball : ballsfacil){

            //Move first
            ball.move(canvas);
            //Draw them
            canvas.drawOval(ball.oval,ball.paint);
        }
        invalidate(); // See note
    }


}

