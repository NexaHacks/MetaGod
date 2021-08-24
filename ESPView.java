package com.nexa.esp;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.view.View;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.graphics.Bitmap.Config;
import android.content.SharedPreferences;
import android.graphics.Path;
import android.graphics.Bitmap;
import android.util.Base64;
import android.graphics.Matrix;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.util.Half;
import android.icu.util.Calendar;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.view.View;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.os.SystemClock;

public class ESPView extends View implements Runnable {

    Paint paint31;

    Paint mStrokePaint;

    Paint mStrokePaint2;

    Paint mFilledPaint;

    Paint mFilledPaint2;

    Paint mStrokePaintrgm;

    Paint mTextPaint;

    Paint mTextPaint2;

    Paint mTextPaint3;

    Paint mRGMTextPaint;

    Paint mFilledPaint3;

    Paint mStrokePaint3;

    Paint p;

    Thread mThread;

    private int mFPS = 0;

    private int mFPSCounter = 0;

    private long mFPSTime = 0;

    int FPS = 60;

    static long sleepTime;

    Date time;

    SimpleDateFormat formatter;

    SimpleDateFormat formatter2;

    static Context ctx;

    public static void ChangeFps(int fps){

        sleepTime = 1000/(20+fps);

    }

    public native void aimingRange(int i);


    Bitmap[] OTHER = new Bitmap[5];


    public ESPView(Context context) {

        super(context, null, 0);

        InitializePaints();

        setFocusableInTouchMode(false);

        setBackgroundColor(Color.TRANSPARENT);

        time = new Date();

        formatter = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());

        formatter2 = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

        sleepTime = 1000 / FPS;

        mThread = new Thread(this);

        mThread.start();

    }


    @Override

    protected void onDraw(Canvas canvas) {

        if (canvas != null && getVisibility() == VISIBLE) {

            ClearCanvas(canvas);

            int height = canvas.getHeight();

            float f = (height - 20);

            time.setTime(System.currentTimeMillis());

            //DrawText(canvas, 255, 128, 0, 0,1.1f, formatter2.format(time) + "  " + formatter.format(time), (canvas.getWidth()/2), 45, 28);

            DrawText(canvas, 255, 0, 255, 0, 1.0f, "", 180.0f, f, 20.0f);

            FloatingMenu.DrawOn(this, canvas);

        }

    }


    public void DrawText(Canvas cvs, int a, int r, int g, int b,float stroke, String txt, float posX, float posY, float size) {

        mTextPaint.setColor(Color.RED);

        mTextPaint.setShadowLayer(5,4,7, Color.TRANSPARENT);

        mTextPaint.setTextSize(30);

        if (SystemClock.uptimeMillis() - mFPSTime > 1000) {

            mFPSTime = SystemClock.uptimeMillis();

            mFPS = mFPSCounter;

            mFPSCounter = 0;

        } else {

            mFPSCounter++;

        }

        cvs.drawText("𝙁𝙋𝙎  : " + mFPS, posX, posY, mTextPaint);

    }

    @Override

    public void run() {

        android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_BACKGROUND);

        while (mThread.isAlive() && !mThread.isInterrupted()) {

            try {

                long t1 = System.currentTimeMillis();

                postInvalidate();

                long td = System.currentTimeMillis() - t1;

                Thread.sleep(Math.max(Math.min(0, sleepTime - td), sleepTime));

            } catch (InterruptedException it) {

                Log.e("OverlayThread", it.getMessage());

            }

        }

    }





    static boolean getConfig(String key){

        SharedPreferences sp=ctx.getSharedPreferences("espValue",Context.MODE_PRIVATE);

        return  sp.getBoolean(key,false);

        return !key.equals("");

    }


    public void InitializePaints() {

        mStrokePaint = new Paint();

        mStrokePaint.setStyle(Paint.Style.STROKE);

        mStrokePaint.setAntiAlias(true);

        mStrokePaint.setColor(Color.rgb(255, 0, 0));


        mStrokePaintrgm = new Paint();

        mStrokePaintrgm.setStyle(Paint.Style.STROKE);

        mStrokePaintrgm.setAntiAlias(true);

        mStrokePaintrgm.setColor(Color.rgb(255,255,0));

        mStrokePaintrgm.setStrokeWidth(2.0f);


        mFilledPaint = new Paint();

        mFilledPaint.setStyle(Paint.Style.FILL);

        mFilledPaint.setAntiAlias(true);

        mFilledPaint.setColor(Color.rgb(255, 0, 0));


        mStrokePaint2 = new Paint();

        mStrokePaint2.setStyle(Paint.Style.STROKE);

        mStrokePaint2.setAntiAlias(true);

        mStrokePaint2.setColor(Color.rgb(255, 0, 0));


        mStrokePaint3 = new Paint();

        mStrokePaint3.setStyle(Paint.Style.STROKE);

        mStrokePaint3.setAntiAlias(true);

        mStrokePaint3.setColor(Color.rgb(255, 0, 0));


        mFilledPaint3 = new Paint();

        mFilledPaint3.setStyle(Paint.Style.FILL);

        mFilledPaint3.setAntiAlias(true);

        mFilledPaint3.setColor(Color.rgb(255, 255, 255));


        mFilledPaint2 = new Paint();

        mFilledPaint2.setStyle(Paint.Style.FILL);

        mFilledPaint2.setAntiAlias(true);

        mFilledPaint2.setColor(Color.rgb(255, 0, 0));


        mTextPaint = new Paint();

        mTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);

        mTextPaint.setAntiAlias(true);

        mTextPaint.setColor(Color.rgb(255, 0, 0));

        mTextPaint.setTextAlign(Paint.Align.CENTER);

        mTextPaint.setStrokeWidth(1.2f);


        mRGMTextPaint = new Paint();

        mRGMTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);

        mRGMTextPaint.setAntiAlias(true);

        mRGMTextPaint.setColor(Color.rgb(255, 0, 0));

        mRGMTextPaint.setTextAlign(Paint.Align.CENTER);

        mRGMTextPaint.setStrokeWidth(1.5f);


        mTextPaint2 = new Paint();

        mTextPaint2.setStyle(Paint.Style.FILL_AND_STROKE);

        mTextPaint2.setAntiAlias(true);

        mTextPaint2.setColor(Color.rgb(255, 0, 0));

        mTextPaint2.setTextAlign(Paint.Align.CENTER);

        mTextPaint2.setStrokeWidth(1.1f);


        mTextPaint3 = new Paint();

        mTextPaint3.setStyle(Paint.Style.FILL_AND_STROKE);

        mTextPaint3.setAntiAlias(true);

        mTextPaint3.setColor(Color.rgb(255, 0, 0));

        mTextPaint3.setTextAlign(Paint.Align.CENTER);

        mTextPaint3.setStrokeWidth(1.1f);

                 p=new Paint();

                 final int bitmap_count_oth = OTHER.length;


                 for(int i = 0 ; i < bitmap_count_oth ; i++)

                 {

                 OTHER[i] = BitmapFactory.decodeResource(getResources(), OTH_NAME[i]);

                 if(i == 4){

                 OTHER[i] = scale(OTHER[i],500,400);

                 }

                 else{

                 OTHER[i] = scale(OTHER[i],80,80);

                 }

                 }

                 }

    }

    public void ClearCanvas(Canvas cvs) {

        cvs.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);

    }

    public void Drawcount(Canvas canvas) {

        DrawFilledRect(canvas,20,0,255,0,canvas.getWidth()/2-80,50,160,40);

        DrawFilledRect(canvas,20,0,255,0,canvas.getWidth()/2-72,50,144,40);

        DrawFilledRect(canvas,20,0,255,0,canvas.getWidth()/2-64,50,128,40);

        DrawFilledRect(canvas,20,0,255,0,canvas.getWidth()/2-60,50,120,40);

        DrawFilledRect(canvas,20,0,255,0,canvas.getWidth()/2-56,50,112,40);

        DrawFilledRect(canvas,20,0,255,0,canvas.getWidth()/2-52,50,104,40);

        DrawFilledRect(canvas,20,0,255,0,canvas.getWidth()/2-48,50,96,40);

        DrawFilledRect(canvas,20,0,255,0,canvas.getWidth()/2-44,50,88,40);}


    public void DrawText3(Canvas cvs, int a, int r, int g, int b,float stroke, String txt, float posX, float posY, float size) {

        mTextPaint.setColor(Color.rgb(r, g, b));

        mTextPaint.setAlpha(a);

        mTextPaint.setShadowLayer(5,7,5, Color.TRANSPARENT);

        mTextPaint.setStrokeWidth(stroke);



        if (getRight() > 1920 || getBottom() > 1920)

            mTextPaint.setTextSize(4 + size);

        else if (getRight() == 1920 || getBottom() == 1920)

            mTextPaint.setTextSize(2 + size);

        else

            mTextPaint.setTextSize(size);


        cvs.drawText(txt, posX, posY, mTextPaint);

    }


    public void DrawLine(Canvas cvs, int a, int r, int g, int b, float lineWidth, float fromX, float fromY, float toX, float toY) {

        mStrokePaint.setColor(Color.rgb(r, g, b));

        mStrokePaint.setAlpha(a);

        mStrokePaint.setStrokeWidth(1.0f);

        cvs.drawLine(fromX, fromY, toX, toY, mStrokePaint);

    }

    public void DrawLine1(Canvas cvs, int a, int r, int g, int b, float lineWidth, float fromX, float fromY, float toX, float toY) {

        mStrokePaint.setColor(Color.rgb(r, g, b));

        mStrokePaint.setAlpha(a);

        mStrokePaint.setStrokeWidth(1.3f);

        cvs.drawLine(fromX, fromY, toX, toY, mStrokePaint);

    }

    public void DrawRect(Canvas cvs, int a, int r, int g, int b, float stroke, float x, float y, float width, float height) {

        mStrokePaint.setStrokeWidth(stroke);

        mStrokePaint.setColor(Color.rgb(r, g, b));

        mStrokePaint.setAlpha(a);

        cvs.drawRect(x, y,  width,  height, mStrokePaint);

    }

    public void DrawFilledRect(Canvas cvs, int a, int r, int g, int b, float x, float y, float width, float height ) {

        mFilledPaint.setColor(Color.rgb(r, g, b));

        mFilledPaint.setAlpha(a);

        cvs.drawRect(x, y, width, height, mFilledPaint);

        /*  float halfwidth = width / 3;

         Path path = new Path();

         cvs.drawLine(x, y, halfwidth, height, mStrokePaint);

         cvs.drawLine(x, y, halfwidth, height, mStrokePaint);

         path.lineTo(x, y - halfwidth - height);

         path.lineTo(x, y - halfwidth + height);

         cvs.drawPath(path, mFilledPaint);*/

        /*float halfWidth = width / 4;

         Path path = new Path();

         path.moveTo(x, y - halfWidth); // Top

         path.lineTo(x - halfWidth, y + halfWidth); // Bottom left

         path.lineTo(x + halfWidth, y + halfWidth); // Bottom right

         path.lineTo(x, y - halfWidth); // Back to Top

         path.close();

         cvs.drawPath(path, mFilledPaint);

         */

    }


    /* public void DrawFilledRect(Canvas cvs, int a, int r, int g, int b, float x, float y, int width ,float height) {

     drawPaint.setColor(Color.GREEN);

     int halfWidth = width / 2;

     Path path = new Path();

     path.moveTo(x, y - halfWidth); // Top

     path.lineTo(x - halfWidth, y + halfWidth); // Bottom left

     path.lineTo(x + halfWidth, y + halfWidth); // Bottom right

     path.lineTo(x, y - halfWidth); // Back to Top

     path.close();

     cvs.drawPath(path, drawPaint);

     cvs.drawRect(x, y, width, height, mFilledPaint);

     }

     */

    public void DrawCircle(Canvas cvs, int a, int r, int g, int b, float stroke, float posX, float posY, float radius) {

        mStrokePaint.setColor(Color.rgb(r, g, b));

        mStrokePaint.setAlpha(a);

        mStrokePaint.setStrokeWidth(3.0f);

        cvs.drawCircle(posX, posY, radius, mStrokePaint);

    }

    public void DrawFilledRect3(Canvas cvs, int a, int r, int g, int b, float x, float y, float width, float height) {

        mFilledPaint2.setColor(Color.rgb(r, g, b));

        mFilledPaint2.setAlpha(a);

        cvs.drawRect(x-45, y-5, width+45, (height + 1.2f), mFilledPaint2);

    }


    public void DrawRect2(Canvas cvs, int a, int r, int g, int b, float stroke, float x, float y, float width, float height) {

        mStrokePaint2.setStrokeWidth(stroke);

        mStrokePaint2.setColor(Color.rgb(r, g, b));

        mStrokePaint2.setAlpha(a);

        cvs.drawRect(x-45, y-5,  width+45,  (height + 1.2f), mStrokePaint2);

    }



  /*  public void DrawOTH(Canvas cvs, int image_number, float X, float Y) {


        cvs.drawBitmap(OTHER[image_number], X, Y, p);


    }

    */

    public void DebugText(String s) {

        System.out.println(s);

    }


    public void DrawText(Canvas cvs, int a, int r, int g, int b, String txt, float posX, float posY, float size) {

        mTextPaint.setARGB(a,r, g, b);

        mTextPaint.setTextSize(size);

        cvs.drawText(txt, posX, posY, mTextPaint);

        mTextPaint.setShadowLayer(5,7,5, Color.BLUE);

        mTextPaint.setStrokeWidth(2.0f);

    }

    public void DrawText1(Canvas cvs, int a, int r, int g, int b, String txt, float posX, float posY, float size) {

        mStrokePaint3.setARGB(a,r, g, b);

        mStrokePaint3.setTextSize(size);

        cvs.drawText(txt, posX, posY, mStrokePaint3);

    }

    public void DrawTextDistance(Canvas cvs, int a, int r, int g, int b, String txt, float posX, float posY, float size) {

        mTextPaint.setARGB(0, 0 ,0, 0);

        mTextPaint.setAlpha(180);

        cvs.drawRect(posX-44,posY-18,posX-79,posY+6,mTextPaint);

        mStrokePaint.setColor(Color.rgb(0, 0, 0));

        mStrokePaint.setStrokeWidth(2.2f);

        cvs.drawRect(posX-44,posY-18,posX-79,posY+6,mStrokePaint);

        mTextPaint.setTextSize(13);

        mTextPaint.setARGB(255,255,255,255);

        cvs.drawText(txt, posX-62, posY, mTextPaint);

    }


    public void DrawTextAltert(Canvas cvs, int a, int r, int g, int b, String txt, float posX, float posY, float size) {

        mTextPaint.setARGB(255,255,255,255);

        mTextPaint.setTextSize(size);

        cvs.drawText(txt, posX, posY, mTextPaint);

    }


    public void DrawWeapon(Canvas cvs, int a, int r, int g, int b, int id,int ammo,int ammo2, float posX, float posY, float size) {

        mTextPaint.setARGB(a,r, g, b);

        String wname=getWeapon(id);

        if(wname!=null)

            mTextPaint2.setAlpha(200);

        cvs.drawRect(posX-100,posY-10,posX+100,posY+18,mTextPaint2);

        mStrokePaint.setColor(Color.rgb(0, 0, 0));

        mStrokePaint.setStrokeWidth(2.0f);

        cvs.drawRect(posX-100,posY-10,posX+100,posY+18,mStrokePaint);

        mTextPaint.setTextSize(15);

        cvs.drawText(wname+">"+ammo+"/"+ammo2, posX, posY+12, mTextPaint);

    }


    public void DrawName(Canvas cvs, int a, int r, int g, int b, String nametxt,int teamid, float posX, float posY, float size) {

        String[] namesp = nametxt.split(":");

        char[] nameint = new char[namesp.length];

        for (int i = 0; i < namesp.length; i++)

            nameint[i] = (char) Integer.parseInt(namesp[i]);

        String realname = new String(nameint);

        mTextPaint.setARGB(a,r, g, b);

        mTextPaint2.setARGB(255,255,255,255);

        mTextPaint2.setAlpha(150);

        cvs.drawRect(posX - 100, posY-22, posX+100,posY+ 10.0f,mTextPaint2);

        mStrokePaint.setColor(Color.rgb(0, 0, 0));

        mStrokePaint.setStrokeWidth(2.0f);

        cvs.drawRect(posX - 100, posY-22, posX+100,posY+ 10.0f,mStrokePaint);

        mTextPaint.setARGB(180,255,0,0);

        mTextPaint.setAlpha(200);

        // cvs.drawCircle(posX - 100.0f, posY-5, 25.0f,mTextPaint);

        //  mStrokePaint.setColor(Color.rgb(255,255,255));

        //  mStrokePaint.setStrokeWidth(2.0f);

        //  cvs.drawCircle(posX - 100.0f, posY-5, 25.0f,mStrokePaint);

        mTextPaint.setTextSize(15);

        mTextPaint.setARGB(180,0,0,0);

        cvs.drawText("" + realname, posX, posY, mTextPaint);

        mTextPaint.setTextSize(18);

        cvs.drawText("" + teamid, posX - 100.0f, posY, mTextPaint);

    }

    /*

     public void DrawRGMCircle(Canvas cvs, int a, int r, int g, int b, float posX, float posY, float radius) {

     mFilledPaint.setColor(Color.rgb(r, g, b));

     mFilledPaint.setAlpha(a);

     cvs.drawCircle(posX, posY, radius, mFilledPaint);

     }

     */

    /*  public void DrawRGMCircle(Canvas cvs, int a, int r, int g, int b, float posX, float posY, float radius) {

     mFilledPaint.setColor(Color.rgb(r, g, b));

     mFilledPaint.setARGB(0, 255, 255, 255);

     mFilledPaint.setAlpha(a);

     cvs.drawCircle(posX, posY, radius, mFilledPaint);

     }

     */

    /*  public void DrawRGMCircle(Canvas cvs, int a, int r, int g, int b, float posX, float posY, float radius) {

     mFilledPaint.setColor(Color.rgb(r, g, b));

     mFilledPaint.setAlpha(a);

     if (true && getConfig("SQUARE")){

     mFilledPaint.setARGB(0, 255, 255, 255);

     cvs.drawRect(posX-75,posY-32,posX+75,posY+16,mFilledPaint);

     }else if (getConfig("SQUARE")){

     mFilledPaint.setColor(Color.rgb(255, 255, 255));

     cvs.drawRect(posX-75,posY-32,posX+75,posY+16,mFilledPaint);

     }else{

     mFilledPaint.setARGB(0, 255, 255, 255);

     cvs.drawCircle(posX, posY, radius, mFilledPaint);

     }

     }

     */




    public void DrawFilledCircle(Canvas cvs, int a, int r, int g, int b, float posX, float posY, float radius) {

        mFilledPaint.setARGB(200,255,0,0);

        mFilledPaint.setAlpha(a);

        cvs.drawRect(posX-75,posY-32,posX+75,posY+16,mFilledPaint);

        mStrokePaint.setColor(Color.rgb(255, 255, 255));

        mStrokePaint.setStrokeWidth(2.0f);

        cvs.drawRect(posX-75,posY-32,posX+75,posY+16,mStrokePaint);

    }


    public void DrawHead(Canvas cvs, int a, int r, int g, int b, float posX, float posY, float radius) {

        mFilledPaint.setColor(Color.rgb(r, g, b));

        mFilledPaint.setAlpha(a);

        mFilledPaint.setARGB(255,255,0,0);

        cvs.drawCircle(posX, posY, radius, mFilledPaint);

    }

    public void DrawRGMItems1(Canvas cvs, String itemName,float distance, float posX, float posY, float size) {

        String realItemName = getRGMItemName(itemName);

        mRGMTextPaint.setTextSize(size);

        if(realItemName!=null && !realItemName.equals(""))

            cvs.drawText(realItemName+" ("+Math.round(distance)+"m)", posX, posY, mRGMTextPaint);

    }

    public void DrawVehicles(Canvas cvs, String itemName,float distance, float posX, float posY, float size) {

        String realVehicleName = getVehicleName(itemName);

        mTextPaint.setColor(Color.RED);

        mTextPaint.setAlpha(150);

        mTextPaint.setTextSize(size);

        if(realVehicleName!=null && !realVehicleName.equals(""))

            cvs.drawText(realVehicleName+": "+Math.round(distance)+"m", posX, posY, mTextPaint);

    }

    public void DrawBuggy(Canvas cvs, String itemName,float distance, float posX, float posY, float size) {

        String realVehicleName = getBuggy(itemName);

        mTextPaint.setColor(Color.GREEN);

        mTextPaint.setAlpha(150);

        mTextPaint.setTextSize(size);

        if(realVehicleName!=null && !realVehicleName.equals(""))

            cvs.drawText(realVehicleName+": "+Math.round(distance)+"m", posX, posY, mTextPaint);

    }

    public void DrawBike(Canvas cvs, String itemName,float distance, float posX, float posY, float size) {

        String realVehicleName = getBike(itemName);

        mTextPaint.setColor(Color.YELLOW);

        mTextPaint.setAlpha(150);

        mTextPaint.setTextSize(size);

        if(realVehicleName!=null && !realVehicleName.equals(""))

            cvs.drawText(realVehicleName+": "+Math.round(distance)+"m", posX, posY, mTextPaint);

    }

    public void DrawBoat(Canvas cvs, String itemName,float distance, float posX, float posY, float size) {

        String realVehicleName = getBoat(itemName);

        mTextPaint.setColor(Color.RED);

        mTextPaint.setAlpha(150);

        mTextPaint.setTextSize(size);

        if(realVehicleName!=null && !realVehicleName.equals(""))

            cvs.drawText(realVehicleName+": "+Math.round(distance)+"m", posX, posY, mTextPaint);

    }

    public void DrawTrike(Canvas cvs, String itemName,float distance, float posX, float posY, float size) {

        String realVehicleName = getTrike(itemName);

        mTextPaint.setColor(Color.YELLOW);

        mTextPaint.setAlpha(150);

        mTextPaint.setTextSize(size);

        if(realVehicleName!=null && !realVehicleName.equals(""))

            cvs.drawText(realVehicleName+": "+Math.round(distance)+"m", posX, posY, mTextPaint);

    }

    public void DrawDacia(Canvas cvs, String itemName,float distance, float posX, float posY, float size) {

        String realVehicleName = getDacia(itemName);

        mTextPaint.setColor(Color.GREEN);

        mTextPaint.setAlpha(150);

        mTextPaint.setTextSize(size);

        if(realVehicleName!=null && !realVehicleName.equals(""))

            cvs.drawText(realVehicleName+": "+Math.round(distance)+"m", posX, posY, mTextPaint);

    }

    public void DrawJet(Canvas cvs, String itemName,float distance, float posX, float posY, float size) {

        String realVehicleName = getJet(itemName);

        mTextPaint.setColor(Color.BLACK);

        mTextPaint.setAlpha(150);

        mTextPaint.setTextSize(size);

        if(realVehicleName!=null && !realVehicleName.equals(""))

            cvs.drawText(realVehicleName+": "+Math.round(distance)+"m", posX, posY, mTextPaint);

    }

    public void DrawBus(Canvas cvs, String itemName,float distance, float posX, float posY, float size) {

        String realVehicleName = getBus(itemName);

        mTextPaint.setColor(Color.YELLOW);

        mTextPaint.setAlpha(150);

        mTextPaint.setTextSize(size);

        if(realVehicleName!=null && !realVehicleName.equals(""))

            cvs.drawText(realVehicleName+": "+Math.round(distance)+"m", posX, posY, mTextPaint);

    }

    public void DrawMirado(Canvas cvs, String itemName,float distance, float posX, float posY, float size) {

        String realVehicleName = getMirado(itemName);

        mTextPaint.setColor(Color.RED);

        mTextPaint.setAlpha(150);

        mTextPaint.setTextSize(size);

        if(realVehicleName!=null && !realVehicleName.equals(""))

            cvs.drawText(realVehicleName+": "+Math.round(distance)+"m", posX, posY, mTextPaint);

    }

    public void DrawScooter(Canvas cvs, String itemName,float distance, float posX, float posY, float size) {

        String realVehicleName = getScooter(itemName);

        mTextPaint.setColor(Color.GREEN);

        mTextPaint.setAlpha(150);

        mTextPaint.setTextSize(size);

        if(realVehicleName!=null && !realVehicleName.equals(""))

            cvs.drawText(realVehicleName+": "+Math.round(distance)+"m", posX, posY, mTextPaint);

    }

    public void DrawRony(Canvas cvs, String itemName,float distance, float posX, float posY, float size) {

        String realVehicleName = getRony(itemName);

        mTextPaint.setColor(Color.YELLOW);

        mTextPaint.setAlpha(150);

        mTextPaint.setTextSize(size);

        if(realVehicleName!=null && !realVehicleName.equals(""))

            cvs.drawText(realVehicleName+": "+Math.round(distance)+"m", posX, posY, mTextPaint);

    }

    public void DrawSnowBike(Canvas cvs, String itemName,float distance, float posX, float posY, float size) {

        String realVehicleName = getSnowBike(itemName);

        mTextPaint.setColor(Color.RED);

        mTextPaint.setAlpha(150);

        mTextPaint.setTextSize(size);

        if(realVehicleName!=null && !realVehicleName.equals(""))

            cvs.drawText(realVehicleName+": "+Math.round(distance)+"m", posX, posY, mTextPaint);

    }

    public void DrawSnowmobile(Canvas cvs, String itemName,float distance, float posX, float posY, float size) {

        String realVehicleName = getSnowmobile(itemName);

        mTextPaint.setColor(Color.GREEN);

        mTextPaint.setAlpha(150);

        mTextPaint.setTextSize(size);

        if(realVehicleName!=null && !realVehicleName.equals(""))

            cvs.drawText(realVehicleName+": "+Math.round(distance)+"m", posX, posY, mTextPaint);

    }

    public void DrawTuk(Canvas cvs, String itemName,float distance, float posX, float posY, float size) {

        String realVehicleName = getTuk(itemName);

        mTextPaint.setColor(Color.RED);

        mTextPaint.setAlpha(150);

        mTextPaint.setTextSize(size);

        if(realVehicleName!=null && !realVehicleName.equals(""))

            cvs.drawText(realVehicleName+": "+Math.round(distance)+"m", posX, posY, mTextPaint);

    }

    public void DrawTruck(Canvas cvs, String itemName,float distance, float posX, float posY, float size) {

        String realVehicleName = getTruck(itemName);

        mTextPaint.setColor(Color.BLUE);

        mTextPaint.setAlpha(150);

        mTextPaint.setTextSize(size);

        if(realVehicleName!=null && !realVehicleName.equals(""))

            cvs.drawText(realVehicleName+": "+Math.round(distance)+"m", posX, posY, mTextPaint);

    }

    public void DrawBRDM(Canvas cvs, String itemName,float distance, float posX, float posY, float size) {

        String realVehicleName = getBRDM(itemName);

        mTextPaint.setColor(Color.RED);

        mTextPaint.setAlpha(150);

        mTextPaint.setTextSize(size);

        if(realVehicleName!=null && !realVehicleName.equals(""))

            cvs.drawText(realVehicleName+": "+Math.round(distance)+"m", posX, posY, mTextPaint);

    }

    public void DrawLadaNiva(Canvas cvs, String itemName,float distance, float posX, float posY, float size) {

        String realVehicleName = getLadaNiva(itemName);

        mTextPaint.setColor(Color.YELLOW);

        mTextPaint.setAlpha(150);

        mTextPaint.setTextSize(size);

        if(realVehicleName!=null && !realVehicleName.equals(""))

            cvs.drawText(realVehicleName+": "+Math.round(distance)+"m", posX, posY, mTextPaint);

    }

    public void DrawMonster(Canvas cvs, String itemName,float distance, float posX, float posY, float size) {

        String realVehicleName = getMonster(itemName);

        mTextPaint.setColor(Color.RED);

        mTextPaint.setAlpha(150);

        mTextPaint.setTextSize(size);

        if(realVehicleName!=null && !realVehicleName.equals(""))

            cvs.drawText(realVehicleName+": "+Math.round(distance)+"m", posX, posY, mTextPaint);

    }


    private String getRGMItemName(String s) {



        if (s.contains("SCAR")) { mTextPaint.setARGB(255, 52, 224, 63);

            return "SCAR-L";

        }



        if (s.contains("Bag_Lv1")) { mTextPaint.setARGB(255, 127, 154, 250);

            return "Bag lvl 1";

        }


        if (s.contains("Bag_Lv2")) { mTextPaint.setARGB(255, 77, 115, 255);

            return "Bag lvl 2";

        }


        if (s.contains("Armor_Lv2")) { mTextPaint.setARGB(255, 77, 115, 255);

            return "Vest lvl 2";

        }


        if (s.contains("Armor_Lv1")) { mTextPaint.setARGB(255, 127, 154, 250);

            return "Vest lvl 1";

        }


        if (s.contains("M416")) { mTextPaint.setARGB(255, 115, 235, 223);

            return "M416";

        }


        if (s.contains("MZJ_8X")) { mTextPaint.setARGB(255, 247, 99, 245);

            return "8x";

        }


        if (s.contains("MZJ_6X")) { mTextPaint.setARGB(255, 247, 99, 245);

            return "6x";

        }


        if (s.contains("M16A4")) { mTextPaint.setARGB(255, 116, 227, 123);

            return "M16A-4";

        }


        if (s.contains("Mk47")) { mTextPaint.setARGB(255, 247, 99, 245);

            return "Mk47 Mutant";

        }


        if (s.contains("FirstAidbox")) { mTextPaint.setARGB(255, 0, 171, 6);

            return "Medkit";

        }



        if (s.contains("Grenade_Shoulei")) { mTextPaint.setARGB(255, 2, 77, 4);

            return "Grenade";

        }


        if (s.contains("G36")) { mTextPaint.setARGB(255, 116, 227, 123);

            return "G36C";

        }


        if (s.contains("QBZ")) { mTextPaint.setARGB(255, 52, 224, 63);

            return "QBZ";

        }


        if (s.contains("AKM")) { mTextPaint.setARGB(255, 214, 99, 99);

            return "AKM";

        }


        if (s.contains("Groza")) { mTextPaint.setARGB(255, 214, 99, 99);

            return "Groza";

        }


        if (s.contains("DP28")) { mTextPaint.setARGB(255, 43, 26, 28);

            return "DP28";

        }


        if (s.contains("M249")) { mTextPaint.setARGB(255, 247, 99, 245);

            return "M249";

        }


        if (s.contains("AWM")) { mTextPaint.setColor(Color.BLACK);

            return "AWM";

        }


        if (s.contains("Ammo_762mm")) { mTextPaint.setARGB(255, 92, 36, 28);

            return "7.62";

        }


        if (s.contains("Ammo_556mm")) { mTextPaint.setColor(Color.GREEN);

            return "5.56";

        }


        if (s.contains("Bag_Lv3")) { mTextPaint.setARGB(255, 36, 83, 255);

            return "Bag lvl 3";

        }



        if ( s.contains("PickUpListWrapperActor")) { mTextPaint.setARGB(255, 132, 201, 66);

            return "Crate";

        }

        if ((s.contains("AirDropPlane"))) { mTextPaint.setARGB(255, 224, 177, 224);

            return "DropPlane";

        }

        if ((s.contains("AirDrop"))){ mTextPaint.setARGB(255, 255, 10, 255);

            return "AirDrop";

        }


        if (s.contains("AUG")) { mTextPaint.setARGB(255, 52, 224, 63);

            return "AUG";

        }


        if (s.contains("M762")) { mTextPaint.setARGB(255, 43, 26, 28);

            return "M762";

        }


        if (s.contains("Armor_Lv3")) { mTextPaint.setARGB(255, 36, 83, 255);

            return "Vest lvl 3";

        }


        if (s.contains("Helmet_Lv2")) { mTextPaint.setARGB(255, 77, 115, 255);

            return "Helmet lvl 2";

        }



        if (s.contains("Grenade_Burn") ) { mTextPaint.setARGB(255, 230, 175, 64);

            return "Molotov";

        }

        if (s.contains("Flare")) { mTextPaint.setARGB(255, 242, 63, 159);

            return "Flare Gun";

        }


        if (s.contains("Ghillie")) { mTextPaint.setARGB(255, 139, 247, 67);

            return "Ghillie Suit";

        }

        if (s.contains("CheekPad")) { mTextPaint.setARGB(255, 112, 55, 55);

            return "CheekPad";

        }


        if (s.contains("Helmet_Lv1")) { mTextPaint.setARGB(255, 127, 154, 250);

            return "Helmet lvl 1";

        }


        if (s.contains("Helmet_Lv3")) { mTextPaint.setARGB(255, 36, 83, 255);

            return "Helmet lvl 3";

        }



        if (s.contains("Firstaid")) { mTextPaint.setARGB(255, 194, 188, 109);

            return "FirstAidKit";

        }


        if (s.contains("Grenade_Smoke")) { mTextPaint.setColor(Color.WHITE);

            return "Smoke";

        }

        return null;


    }

    private String getWeapon(int id){

        if(id==101006)

            return "AUG";


        if(id==106903)

            return "RGM5";



        if(id==101008)

            return "M762" ;


        if(id==101003)

            return "SCAR-L";


        if(id==101004)

            return "M416";


        if(id==101002)

            return "M16A-4";


        if(id==101009)

            return "Mk47 Mutant";


        if(id==101010)

            return "G36C";


        if(id==101007)

            return "QBZ";


        if(id==101001)

            return "AKM";


        if(id==101005)

            return "Groza";


        if(id==105002)

            return "DP28";


        if(id==105001)

            return "M249";



        if(id==103003)

            return "AWM";


        if(id==104903)

            return "RGM";



        if(id==103683)

            return "RGM1";



        if(id==105803)

            return "RGM2";



        if(id==100703)

            return "RGM3";



        if(id==101803)

            return "RGM4";

        return null;


    }



    private String getBuggy(String s){

        if(s.contains("Buggy"))

            return "Buggy";

        return "";

    }


    private String getVehicleName(String s){

        if(s.contains("UAZ"))

            return "UAZ";

        return "";

    }

    private String getBike(String s){

        if(s.contains("Motorcycle"))

            return "Bike";


        return "";

    }

    private String getBoat(String s){

        if(s.contains("PG117"))

            return "Boat";


        return "";

    }

    private String getTrike(String s){

        if(s.contains("MotorcycleC"))

            return "Trike";


        return "";

    }

    private String getDacia(String s){

        if(s.contains("Dacia"))

            return "Dacia";


        return "";

    }

    private String getJet(String s){

        if(s.contains("AquaRail"))

            return "Jet";


        return "";

    }

    private String getBus(String s){

        if(s.contains("MiniBus"))

            return "Bus";


        return "";

    }

    private String getMirado(String s){

        if(s.contains("Mirado"))

            return "Mirado";


        return "";

    }

    private String getScooter(String s){

        if(s.contains("Scooter"))

            return "Scooter";


        return "";

    }

    private String getRony(String s){

        if(s.contains("Rony"))

            return "Rony";


        return "";

    }

    private String getSnowBike(String s){

        if(s.contains("Snowbike"))

            return "Snowbike";


        return "";

    }

    private String getSnowmobile(String s){

        if(s.contains("Snowmobile"))

            return "Snowmobile";


        return "";

    }

    private String getTuk(String s){

        if(s.contains("Tuk"))

            return "Tempo";


        return "";

    }

    private String getTruck(String s){

        if(s.contains("PickUp"))

            return "Truck";


        return "";

    }

    private String getBRDM(String s){

        if(s.contains("BRDM"))

            return "BRDM";


        return "";

    }

    private String getLadaNiva(String s){

        if(s.contains("LadaNiva"))

            return "LadaNiva";


        return "";

    }

    private String getMonster(String s){

        if(s.contains("Bigfoot"))

            return "Monster Truck";


        return "";

    }


    public static Bitmap scale(Bitmap bitmap, int maxWidth, int maxHeight) {

        // Determine the constrained dimension, which determines both dimensions.

        int width;

        int height;

        float widthRatio = (float)bitmap.getWidth() / maxWidth;

        float heightRatio = (float)bitmap.getHeight() / maxHeight;

        // Width constrained.

        if (widthRatio >= heightRatio) {

            width = maxWidth;

            height = (int)(((float)width / bitmap.getWidth()) * bitmap.getHeight());

        }

        // Height constrained.

        else {

            height = maxHeight;

            width = (int)(((float)height / bitmap.getHeight()) * bitmap.getWidth());

        }

        Bitmap scaledBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);


        float ratioX = (float)width / bitmap.getWidth();

        float ratioY = (float)height / bitmap.getHeight();

        float middleX = width / 2.0f;

        float middleY = height / 2.0f;

        Matrix scaleMatrix = new Matrix();

        scaleMatrix.setScale(ratioX, ratioY, middleX, middleY);


        Canvas canvas = new Canvas(scaledBitmap);

        canvas.setMatrix(scaleMatrix);

        canvas.drawBitmap(bitmap, middleX - bitmap.getWidth() / 2, middleY - bitmap.getHeight() / 2, new Paint(Paint.FILTER_BITMAP_FLAG));

        return scaledBitmap;

    }

}


