package com.wilson.app_1;

import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.TreeMap;

public class Thread_2 extends Thread{

    int seconds;
    TextView tv;
    int runing = 0;
    public Thread_2(int seconds, TextView tv){
        this.seconds=seconds;
        this.tv = tv;

    }

    @Override
    public void run(){
        while (true) {
            for (int i = 0; i < this.seconds; i++) {
                Log.d("thread_1", "sleep :" + i);
                this.runing++;
                this.tv.setText("go"+this.runing);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }
    }

}
