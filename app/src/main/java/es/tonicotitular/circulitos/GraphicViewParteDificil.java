package es.tonicotitular.circulitos;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class GraphicViewParteDificil  extends View {
    private List<Ball> balls = new ArrayList<>();
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
        balls.add(new Ball(250,30,100, Color.RED,70));
        balls.add(new Ball(350,50,100,Color.RED,60));
        balls.add(new Ball(520,110,100,Color.RED,60));
        balls.add(new Ball(10,20,100,Color.YELLOW,70));
        balls.add(new Ball(170,00,100,Color.YELLOW,70));
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
