package com.example.laba6;

import android.os.Handler;
import android.util.Log;
import java.util.TimerTask;


import android.view.View;


public class Scheduler extends TimerTask{
    float x;

    private Handler handler;

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    private MainActivity activity;

    public void setActivity(MainActivity activity) {
        this.activity = activity;
    }
    @Override
    public void run() {
        float a = 2, b = 3, c = 4;
        float F;

        // Изменение значения x от -30 до 30 с шагом 1
        for (x = -30; x <= 30; x++) {
            if (x < 3 && b != 0) {
                F = (a * x * x - b * x + c);
            } else if (x > 3 && b == 0) {
                F = ((x - a) / (x - c));
            } else {
                F = (x / c);
            }
            Log.i("Вывод", "Значение F при x = " + x + ": " + F);

            if (handler != null && x < 30) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        activity.onClick(null);
                    }
                });
            }

            try {
                Thread.sleep(100); // Пауза в одну секунду между итерациями
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
