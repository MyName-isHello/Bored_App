package com.wilson.app_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public int n=999;
    int max = 90 ,min = 0,size = 31;
    boolean AB_switch = false;
    int tota = 0;
    int stop = 0;
    int time_stp = 5;
    Random random = new Random();
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startThread();


        final Button next = findViewById(R.id.btn_next);
        TextView top_Text = findViewById(R.id.txt_top);
        TextView score_text = findViewById(R.id.score);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(n == 0 && stop<1){
                    tota++;
                    stop ++;
                    time_stp ++;
                }
                System.out.println("onClick");
            }
        });

        handler = new Handler(){
            @Override
            public void handleMessage(Message msg){
                top_Text.setTextSize(size);
                top_Text.setText(""+n);
                score_text.setText("Score :"+tota);
            }
        };
    }

    public void startThread(){
        Thread_1 thread = new Thread_1();
        System.out.println("thread_start");
        thread.start();
    }

    public class Thread_1 extends Thread{

        @Override
        public void run(){
            while (true) {
                    try {
                        if (size == max){
                            AB_switch = true;
                        }
                        if (size == min){
                            AB_switch = false;
                            n = random.nextInt(10);
                            stop=0;
                        }
                        if (AB_switch){
                            size --;
                        }else{
                            size++;
                        }
                        Thread.sleep(time_stp);
                        handler.sendEmptyMessage(0);
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }
            }
        }

    }

}