package es.tonicotitular.circulitos;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class GraphicView extends View {
    public Paint p;
    private List<Ball> balls = new ArrayList<>();
    private static final int RADIO = 30;
    private int centroX;
    private int centroY;
    private int velocidadX = 55;
    private int velocidadY = 55;


    public GraphicView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    public GraphicView(Context context) {
        super(context);
        init();
    }
    private void init(){
        //Add a new ball to the view
        balls.add(new Ball(50,50,100,Color.RED,100));
        balls.add(new Ball(50,50,100,Color.RED,50));
        balls.add(new Ball(50,50,100,Color.YELLOW,20));
        balls.add(new Ball(50,50,100,Color.YELLOW,34));
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //Draw the balls
        for(Ball ball : balls){
            //Move first
            ball.move(canvas);
            //Draw them
            canvas.drawOval(ball.oval,ball.paint);
        }
        invalidate(); // See note
    }




    }

