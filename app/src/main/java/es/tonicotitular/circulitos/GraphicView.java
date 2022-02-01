package es.tonicotitular.circulitos;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class GraphicView extends View {
    public Paint p,p2,p3,p4;

    private static final int RADIO = 30;
    private int centroX;
    private int centroY;
    private int velocidadX = 55;
    private int velocidadY = 55;



    public GraphicView(Context context, AttributeSet attr) {
        super(context, attr);
        p = new Paint();
        p.setColor(Color.RED);
        p2= new Paint();
        p2.setColor(Color.RED);
        p3= new Paint();
        p3.setColor(Color.YELLOW);
        p4= new Paint();
        p4.setColor(Color.YELLOW);
    }


    @Override
    public void onSizeChanged(int w, int h, int oldW, int oldH) {
        centroX = w / 2;
        centroY = h / 2;
    }

    public void onDraw(Canvas c) {

        // Anchura
        int w = getWidth();
        // Altura
        int h = getHeight();


        centroX += velocidadX;
        centroY += velocidadY;

        // Límites de pantalla
        int limiteDerecha = w - RADIO;
        int limiteInferior = h - RADIO;

        // Comprobar si invertir si llegamos al límite
        if (centroX >= limiteDerecha) {
            centroX = limiteDerecha;
            velocidadX *= -1;
        }
        if (centroX <= RADIO) {
            centroX = RADIO;
            velocidadX *= -1;
        }
        if (centroY >= limiteInferior) {
            centroY = limiteInferior;
            velocidadY *= -1;
        }
        if (centroY <= RADIO) {
            centroY = RADIO;
            velocidadY *= -1;
        }
            // Dibujar el círculo
            c.drawCircle(centroX, centroY, RADIO, p);
            postInvalidateDelayed(100);
        c.drawCircle(centroX, centroY, RADIO, p2);
        postInvalidateDelayed(100);
        c.drawCircle(centroX, centroY, RADIO, p3);
        postInvalidateDelayed(100);
        c.drawCircle(centroX, centroY, RADIO, p4);
        postInvalidateDelayed(100);


    }
}
