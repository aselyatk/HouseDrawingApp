package com.example.housedrawingapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.View;
import android.graphics.Path;


import androidx.core.content.ContextCompat;

public class MyDraw extends View {
    private int colorSky;
    private int colorGrass;
    public MyDraw(Context context) {
        super(context);
        colorSky = ContextCompat.getColor(context, R.color.sky); // Получаем цвет неба из ресурсов
        colorGrass = ContextCompat.getColor(context, R.color.green); // Получаем цвет поля из ресурсов
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(colorSky); // Цвет неба
        canvas.drawRect(0, 0, getWidth(), 1000, paint); // Рисуем небо

        paint.setColor(colorGrass); // Цвет поля
        canvas.drawRect(0, 1000, getWidth(), getHeight(), paint); // Рисуем поле

        paint.setColor(Color.GRAY);

        // Рисуем основу дома
        canvas.drawRect(300, 600, 800, 1200, paint);

        // Рисуем крышу (треугольник)
        paint.setColor(Color.BLUE);
        Path roofPath = new Path();
        roofPath.moveTo(300, 600); // Левый нижний угол крыши
        roofPath.lineTo(550, 350); // Вершина крыши
        roofPath.lineTo(800, 600); // Правый нижний угол крыши
        roofPath.close(); // Замыкаем путь, чтобы получить треугольник
        canvas.drawPath(roofPath, paint);

        paint.setColor(Color.YELLOW);  // Устанавливаем цвет окна
        int leftWindow = 350;
        int topWindow = 700;
        int rightWindow = 550;
        int bottomWindow = 900;
        canvas.drawRect(leftWindow, topWindow, rightWindow, bottomWindow, paint);

        paint.setColor(Color.RED); // Устанавливаем цвет сетки

// Рисуем вертикальные линии с интервалом в 10 пикселей
        for (int i = leftWindow + 15; i < rightWindow; i += 15) {
            canvas.drawLine(i, topWindow, i, bottomWindow, paint);
        }

        for (int i = topWindow + 15; i < bottomWindow; i += 15) {
            canvas.drawLine(leftWindow, i, rightWindow, i, paint);
        }

        // Рисуем дверь
        paint.setColor(Color.BLUE);
        canvas.drawRect(600, 850, 750, 1200, paint);
    } }

