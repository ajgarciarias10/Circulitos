package es.tonicotitular.circulitos;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class GraphicViewMedium  extends View {
    private List<Ball> balls = new ArrayList<>();
    public GraphicViewMedium(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    public GraphicViewMedium(Context context) {
        super(context);
        init();
    }
    private void init(){
        //Add a new ball to the view
        balls.add(new Ball(20,130,100, Color.RED,40));
        balls.add(new Ball(550,50,100,Color.RED,40));
        balls.add(new Ball(120,210,100,Color.RED,40));
        balls.add(new Ball(310,320,100,Color.YELLOW,40));
        balls.add(new Ball(70,100,100,Color.YELLOW,40));
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

