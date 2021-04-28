package com.example.simplecanvas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Canvas mCanvas;
    private Paint mPaint=new Paint();
    private Paint mPaintText=new Paint(Paint.UNDERLINE_TEXT_FLAG);
    private Bitmap mBitmap;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView=findViewById(R.id.my_imageview);
        mPaint.setColor(Color.YELLOW);
        mPaintText.setColor(ResourcesCompat.getColor(getResources(),R.color.purple_700, null));
        mPaintText.setTextSize(80);
    }

    public void drawSomething(View view) {
        int vWidth=view.getWidth();
        int vHeight=view.getHeight();
        mBitmap=Bitmap.createBitmap(vWidth,vHeight,Bitmap.Config.ARGB_8888);
        mImageView.setImageBitmap(mBitmap);
        mCanvas=new Canvas(mBitmap);
        mCanvas.drawColor(Color.GRAY);
        mCanvas.drawText(getString(R.string.app_name), 260,100,mPaintText);

        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(12);
        mCanvas.drawLine(500,200,300,450,mPaint);

        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(12);
        mCanvas.drawLine(500,200,700,450,mPaint);

        mPaint.setColor(Color.RED);
        Rect mRect=new Rect();
        mRect.set(400,600,600,400);
        mCanvas.drawRect(mRect,mPaint);


        mPaint.setColor(Color.BLACK);
        mCanvas.drawCircle(500,500,20,mPaint);

//        Path path=new Path();
//        path.moveTo(400,700);
//        path.lineTo(300,800);
//        path.lineTo(500,700);
//        path.lineTo(700,800);
//        mPaint.setColor(Color.BLUE);
//        mCanvas.drawPath(path,mPaint);

//        mPaint.setColor(Color.GRAY);
//        RectF rectf=new RectF();
//        rectf.set(100,200,600,400);
//        mCanvas.drawOval(rectf,mPaint);


        view.invalidate();
    }
}