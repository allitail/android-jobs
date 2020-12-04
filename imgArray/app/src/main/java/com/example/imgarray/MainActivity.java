package com.example.imgarray;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

//    Button lbt, rbt;
    ImageView iv;

    int i = -1;

    private static Handler iHandler;

    Bitmap bmImg1 = BitmapFactory.decodeFile("/storage/emulated/0/a/IMG/q.jpg");
    Bitmap bmImg2 = BitmapFactory.decodeFile("/storage/emulated/0/a/IMG/w.jpg");
    Bitmap bmImg3 = BitmapFactory.decodeFile("/storage/emulated/0/a/IMG/e.jpg");
    Bitmap bmImg4 = BitmapFactory.decodeFile("/storage/emulated/0/a/IMG/r.jpg");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = (ImageView) findViewById(R.id.img);
//        lbt = (Button) findViewById(R.id.btnleft);
//        rbt = (Button) findViewById(R.id.btnright);

//        lbt.setOnClickListener(this);
//        rbt.setOnClickListener(this);

//        iv = (ImageView) findViewById(R.id.imgviewer);
//        iv.setImageResource(R.drawable.apple);


        iHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                changeImg();
            }
        };



        class NewRunnable implements Runnable {

            @Override
            public void run() {

                while(true) {

                    try {

                        Thread.sleep(1000);

                    } catch(Exception e) {

                        e.printStackTrace();

                    }

                    iHandler.sendEmptyMessage(0);

                }
            }
        }




        NewRunnable nr = new NewRunnable();
        Thread t = new Thread(nr);
        t.start();
    }


//    @Override
//    public void onClick(View v) {
//
//        switch (v.getId()) {
//            case R.id.btnright:
//                btn_click(true);
//                break;
//            case R.id.btnleft:
//                btn_click(false);
//                break;
//        }
//
//    }

//    private void btn_click(boolean isRight) {
//        Log.d("", "" + i);
//        if (isRight) {
//            if (i == 4) {
//
//            } else {
//                i++;
//            }
//
//        } else {
//            if (i == 0) {
//
//            } else {
//                i--;
//            }
//
//        }

//        Log.d("", "" + i);

    void changeImg(){

        i++;

        switch (i){

            case 0:
                ((ImageView)findViewById(R.id.img)).setImageBitmap(bmImg1);
                break;
            case 1:
                ((ImageView)findViewById(R.id.img)).setImageBitmap(bmImg2);
                break;
            case 2:
                ((ImageView)findViewById(R.id.img)).setImageBitmap(bmImg3);
                break;
            case 3:
                ((ImageView)findViewById(R.id.img)).setImageBitmap(bmImg4);
                break;

            case 4:
                iv.setImageResource(R.drawable.apple);
                break;
            case 5:
                iv.setImageResource(R.drawable.banana);
                break;
            case 6:
                iv.setImageResource(R.drawable.cherry);
                break;
            case 7:
                iv.setImageResource(R.drawable.orange);
                break;
            case 8:
                iv.setImageResource(R.drawable.peach);
                i=-1;
                break;

        }



    }









}