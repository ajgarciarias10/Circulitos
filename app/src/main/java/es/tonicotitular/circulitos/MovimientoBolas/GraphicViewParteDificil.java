package es.tonicotitular.circulitos.MovimientoBolas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import es.tonicotitular.circulitos.MovimientoBolas.Ball;

public class GraphicViewParteDificil  extends View {
    public static List<Ball> ballsdificil = new ArrayList<>();
    public GraphicViewParteDificil(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    public GraphicViewParteDificil(Context context) {
        super(context);
        init();
    }
    private void init(){
        //Add a new ball to the view
        ballsdificil.add(new Ball(250,30,100, Color.RED,74));
        ballsdificil.add(new Ball(350,50,100,Color.RED,60));
        ballsdificil.add(new Ball(520,110,100,Color.RED,62));
        ballsdificil.add(new Ball(150,30,100, Color.RED,74));
        ballsdificil.add(new Ball(380,50,100,Color.RED,60));
        ballsdificil.add(new Ball(540,140,100,Color.RED,62));
        ballsdificil.add(new Ball(110,20,100,Color.YELLOW,71));
        ballsdificil.add(new Ball(170,00,100,Color.YELLOW,60));
        ballsdificil.add(new Ball(102,210,100,Color.YELLOW,90));
        ballsdificil.add(new Ball(130,100,100,Color.YELLOW,50));
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //Draw the balls
        for(Ball ball : ballsdificil){
            //Move first
            ball.move(canvas);
            //Draw them
            canvas.drawOval(ball.oval,ball.paint);
        }
        invalidate(); // See note
    }
}
