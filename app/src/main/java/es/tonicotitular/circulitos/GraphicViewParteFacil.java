package es.tonicotitular.circulitos;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class GraphicViewParteFacil extends View {
    private List<Ball> balls = new ArrayList<>();
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
        balls.add(new Ball(50,50,100,Color.RED,30));
        balls.add(new Ball(50,50,100,Color.RED,32));
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

