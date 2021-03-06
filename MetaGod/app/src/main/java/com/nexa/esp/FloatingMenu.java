package com.nexa.esp;

import android.animation.ArgbEvaluator;
import android.animation.TimeAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.text.Html;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.net.Uri;
import android.os.IBinder;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.graphics.drawable.GradientDrawable;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Switch;
import android.widget.TextView;
import java.util.List;
import java.util.Random;
import android.view.Gravity;
import android.graphics.PixelFormat;
import android.view.ViewConfiguration;
import org.json.JSONArray;
import org.json.JSONObject;
import android.annotation.TargetApi;
import android.animation.ArgbEvaluator;
import android.animation.TimeAnimator;
import android.animation.ValueAnimator;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.text.Html;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextUtils;
import android.text.method.DigitsKeyListener;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import com.nexa.animation.AnimationSetupCallback;
import com.nexa.animation.Titanic;
import com.nexa.animation.TitanicButton;
import com.nexa.animation.TitanicTextView;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import android.view.View.OnClickListener;

public class FloatingMenu extends Service {
    public static String title;
    int glitch_delay = 175;
    int glitch_len = 2;
    float density;
    int dpi;
    final int menu_bg_color = Color.parseColor("#00ffff");
    final int menu_bg_col = Color.parseColor("#cc0000");
    WindowManager.LayoutParams g_layoutParams;
    int height;
    RelativeLayout iconLayout;
    private TextView menu2;
    private TextView menu1;
    private TextView rgmmenu3;
    private TextView rgmmenu4;
    private TextView rgmmenu5;
    private TextView rgmmenu6;
    TextView inputFieldTextView;
    private LinearLayout.LayoutParams hr;
    GradientDrawable gdMenuBody, gdAnimation = new GradientDrawable();
    String inputFieldFeatureName;
    LinearLayout[] contentLayouts;
    int inputFieldFeatureNum;
    LinearLayout itemlist,itemsLayout,itemsLayout2,itemsLayout3,phaku;
    LinearLayout body,RGM,itemmenu,patchlist1,patchlist2,patchlist3,patchlist4,patchlist5,patchlist6,patchlist8;
    RelativeLayout relativeLayout;
    ScrollView scrollView,itemlist1,scrollViewr;
    private ScrollView scrollView2,scrollView3,scrollView4,scrollView5,scrollView6,scrollView7,scrollView8;
    TextView textTitle;
    int type;
    int width;
    WindowManager windowManager;
    public native void stringFromJNI();
    ESPView espLayout;
    static Context ctx;
    private native String Icon();
    boolean stopChecking;
    private native void Changes(int feature, int value);
    private native String[] getFeatureList();
    static {
        title = "MetaGod V 0.1 (BETA)";
    }
    public int onStartCommand(Intent intent, int i, int i2) {
        return Service.START_NOT_STICKY;
    }

    private void AddButton(String str, View.OnClickListener onClickListener) {
        Button button = new Button(this);
        button.setText(str);
        button.setBackgroundColor(Color.GREEN);
        button.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dp(270), -1);
        layoutParams.setMargins(0, dp(10), 0, dp(10));
        button.setLayoutParams(layoutParams);
        button.setTranslationX(90.0f);
        button.setTextColor(Color.BLACK);
        button.setOnClickListener(onClickListener);
        button.setTextSize(17.0f);
        this.patchlist1.addView(button);
    }
    private void AddSeekbar1(final String string, int n3,final SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        final TextView textView = new TextView((Context)this);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(": ");
        stringBuilder.append(n3);
        textView.setText((CharSequence)stringBuilder.toString());
        textView.setTextSize(1, 12.5f);
        textView.setPadding(this.convertSizeToDp(10.0f), this.convertSizeToDp(5.0f), this.convertSizeToDp(10.0f), this.convertSizeToDp(5.0f));
        textView.setTextColor(-1);
        textView.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -2));
        SeekBar seekBar = new SeekBar((Context)this);
        seekBar.setMax(n3);
        seekBar.setPadding(this.convertSizeToDp(10.0f), this.convertSizeToDp(5.0f), this.convertSizeToDp(10.0f), this.convertSizeToDp(5.0f));
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            public void onProgressChanged(SeekBar seekBar, int n, boolean bl) {
                TextView textView2 = textView;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append(": ");
                stringBuilder.append(n);
                textView2.setText((CharSequence)stringBuilder.toString());
                onSeekBarChangeListener.onProgressChanged(seekBar, n, bl);
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.patchlist4.addView((View)textView);
        this.patchlist4.addView((View)seekBar);
    }
    private LinearLayout.LayoutParams setParams() {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        params.gravity = Gravity.CENTER_VERTICAL;
        return params;
    }
    private void addSpace(int space) {
        View separator = new View(ctx);
        LinearLayout.LayoutParams params = setParams();
        params.height = space;
        separator.setLayoutParams(params);
        separator.setBackgroundColor(Color.TRANSPARENT);
    }
    private void AddSeekbar(int max, final SeekBar.OnSeekBarChangeListener listener) {
        SeekBar sb = new SeekBar(ctx);
        sb.setMax(max);
        sb.setLayoutParams(setParams());
        sb.setOnSeekBarChangeListener(listener);
        addSpace(12);
    }
    private void AddText(String string) {
        TextView textView = new TextView((Context)this);
        textView.setText((CharSequence)string);
        textView.setTextSize(1, 12.5f);
        textView.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -2));
        textView.setPadding(this.convertSizeToDp(10.0f), this.convertSizeToDp(5.0f), this.convertSizeToDp(10.0f), this.convertSizeToDp(5.0f));
        textView.setTextColor(menu_bg_col);
        this.patchlist1.addView((View)textView);
    }
    private void AddTextDivide(String string) {
        TextView textView = new TextView((Context)this);
        textView.setText((CharSequence)string);
        textView.setTextSize(1, 15.0f);
        textView.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-2, -2));
        textView.setTypeface(Typeface.SERIF);
        textView.setPadding(this.convertSizeToDp(10.0f), this.convertSizeToDp(5.0f), this.convertSizeToDp(10.0f), this.convertSizeToDp(5.0f));
        textView.setTextColor(menu_bg_col);
        this.patchlist1.addView((View)textView);
    }
    private void AddTextDivide4(String string) {
        TextView textView = new TextView((Context)this);
        textView.setText((CharSequence)string);
        textView.setTextSize(1, 15.0f);
        textView.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-2, -2));
        textView.setTypeface(Typeface.SERIF);
        textView.setPadding(this.convertSizeToDp(10.0f), this.convertSizeToDp(5.0f), this.convertSizeToDp(10.0f), this.convertSizeToDp(5.0f));
        textView.setTextColor(menu_bg_col);
        this.patchlist4.addView((View)textView);
    }
    private void AddTextDivide1(String string) {
        TextView textView = new TextView((Context)this);
        textView.setText((CharSequence)string);
        textView.setTextSize(1, 15.0f);
        textView.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-2, -2));
        textView.setTypeface(Typeface.SERIF);
        textView.setPadding(this.convertSizeToDp(10.0f), this.convertSizeToDp(5.0f), this.convertSizeToDp(10.0f), this.convertSizeToDp(5.0f));
        textView.setTextColor(menu_bg_col);
        this.patchlist3.addView((View)textView);
    }
    private void AddTextDivide2(String string) {
        TextView textView = new TextView((Context)this);
        textView.setText((CharSequence)string);
        textView.setTextSize(1, 15.0f);
        textView.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-2, -2));
        textView.setTypeface(Typeface.SERIF);
        textView.setPadding(this.convertSizeToDp(10.0f), this.convertSizeToDp(5.0f), this.convertSizeToDp(10.0f), this.convertSizeToDp(5.0f));
        textView.setTextColor(menu_bg_col);
        this.patchlist2.addView((View)textView);
    }
    private void AddTextDivide3(String string) {
        TextView textView = new TextView((Context)this);
        textView.setText((CharSequence)string);
        textView.setTextSize(1, 15.0f);
        textView.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-2, -2));
        textView.setTypeface(Typeface.SERIF);
        textView.setPadding(this.convertSizeToDp(10.0f), this.convertSizeToDp(5.0f), this.convertSizeToDp(10.0f), this.convertSizeToDp(5.0f));
        textView.setTextColor(menu_bg_col);
        this.patchlist6.addView((View)textView);
    }
    private void AddTextDivide7(String string) {
        TextView textView = new TextView((Context)this);
        textView.setText((CharSequence)string);
        textView.setTextSize(1, 15.0f);
        textView.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-2, -2));
        textView.setTypeface(Typeface.SERIF);
        textView.setPadding(this.convertSizeToDp(10.0f), this.convertSizeToDp(5.0f), this.convertSizeToDp(10.0f), this.convertSizeToDp(5.0f));
        textView.setTextColor(menu_bg_col);
        this.patchlist4.addView((View)textView);
    }
    private void AddTextDivide8(String string) {
        TextView textView = new TextView((Context)this);
        textView.setText((CharSequence)string);
        textView.setTextSize(1, 15.0f);
        textView.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-2, -2));
        textView.setTypeface(Typeface.SERIF);
        textView.setPadding(this.convertSizeToDp(10.0f), this.convertSizeToDp(5.0f), this.convertSizeToDp(10.0f), this.convertSizeToDp(5.0f));
        textView.setTextColor(menu_bg_col);
        this.patchlist8.addView((View)textView);
    }
    private void AddToggle(String string, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        Switch switch_ = new Switch((Context)this);
        switch_.setText((CharSequence)string);
        switch_.setPadding(10, 5, 0, 5);
        switch_.setPadding(this.convertSizeToDp(10.0f), this.convertSizeToDp(5.0f), this.convertSizeToDp(10.0f), this.convertSizeToDp(5.0f));
        switch_.setTextSize(1, 12.5f);
        switch_.setTypeface(Typeface.SERIF);
        switch_.setTextColor(menu_bg_col);
        switch_.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
            }
        });
        ColorStateList colorStateList = new ColorStateList((int[][])new int[][]{{-16842910}, {16842912}, new int[0]}, new int[]{-16776961, -16711936, -65536});
        ColorStateList colorStateList2 = new ColorStateList((int[][])new int[][]{{-16842910}, new int[0]}, new int[]{-7829368, -3355444});
        if (Build.VERSION.SDK_INT >= 23) {
            if (Build.VERSION.SDK_INT >= 24) {
                switch_.setTrackTintList(colorStateList2);
                switch_.setTrackTintMode(PorterDuff.Mode.OVERLAY);
            }
            switch_.setThumbTintList(colorStateList);
        } else if (Build.VERSION.SDK_INT >= 21) {
            switch_.getThumbDrawable().setTintList(colorStateList);
            switch_.getTrackDrawable().setTintList(colorStateList2);
        }
        switch_.setOnCheckedChangeListener(onCheckedChangeListener);
        switch_.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1,-2));
        this.patchlist1.addView((View)switch_);
    }

    private void AddToggle1(String string, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        Switch RGMSwitch = new Switch((Context)this);
        RGMSwitch.setText((CharSequence)string);
        RGMSwitch.setPadding(this.convertSizeToDp(10.0f), this.convertSizeToDp(5.0f), this.convertSizeToDp(10.0f), this.convertSizeToDp(5.0f));
        RGMSwitch.setTextSize(1, 12.5f);
        RGMSwitch.setTextColor(menu_bg_col);
        RGMSwitch.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
            }
        });
        ColorStateList colorStateList = new ColorStateList((int[][])new int[][]{{-16842910}, {16842912}, new int[0]}, new int[]{-16776961, -16711936, -65536});
        ColorStateList colorStateList2 = new ColorStateList((int[][])new int[][]{{-16842910}, new int[0]}, new int[]{-7829368, -3355444});
        if (Build.VERSION.SDK_INT >= 23) {
            if (Build.VERSION.SDK_INT >= 24) {
                RGMSwitch.setTrackTintList(colorStateList2);
                RGMSwitch.setTrackTintMode(PorterDuff.Mode.OVERLAY);
            }
            RGMSwitch.setThumbTintList(colorStateList);
        } else if (Build.VERSION.SDK_INT >= 21) {
            RGMSwitch.getThumbDrawable().setTintList(colorStateList);
            RGMSwitch.getTrackDrawable().setTintList(colorStateList2);
        }
        RGMSwitch.setOnCheckedChangeListener(onCheckedChangeListener);
        RGMSwitch.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -2));
    }
    private void AddToggle2(String string, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        Switch RGMSwitch2 = new Switch((Context)this);
        RGMSwitch2.setText((CharSequence)string);
        RGMSwitch2.setPadding(this.convertSizeToDp(10.0f), this.convertSizeToDp(5.0f), this.convertSizeToDp(10.0f), this.convertSizeToDp(5.0f));
        RGMSwitch2.setTextSize(1, 12.5f);
        RGMSwitch2.setTypeface(Typeface.SERIF);
        RGMSwitch2.setTextColor(menu_bg_col);
        RGMSwitch2.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
            }
        });
        ColorStateList colorStateList = new ColorStateList((int[][])new int[][]{{-16842910}, {16842912}, new int[0]}, new int[]{-16776961, -16711936, -65536});
        ColorStateList colorStateList2 = new ColorStateList((int[][])new int[][]{{-16842910}, new int[0]}, new int[]{-7829368, -3355444});
        if (Build.VERSION.SDK_INT >= 23) {
            if (Build.VERSION.SDK_INT >= 24) {
                RGMSwitch2.setTrackTintList(colorStateList2);
                RGMSwitch2.setTrackTintMode(PorterDuff.Mode.OVERLAY);
            }
            RGMSwitch2.setThumbTintList(colorStateList);
        } else if (Build.VERSION.SDK_INT >= 21) {
            RGMSwitch2.getThumbDrawable().setTintList(colorStateList);
            RGMSwitch2.getTrackDrawable().setTintList(colorStateList2);
        }
        RGMSwitch2.setOnCheckedChangeListener(onCheckedChangeListener);
        RGMSwitch2.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -2));
        this.patchlist2.addView((View)RGMSwitch2);
    }
    private void AddToggle4(String string, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        CheckBox switch_ = new CheckBox((Context)this);
        switch_.setText((CharSequence)string);
        switch_.setPadding(this.convertSizeToDp(10.0f), this.convertSizeToDp(5.0f), this.convertSizeToDp(10.0f), this.convertSizeToDp(5.0f));
        switch_.setTextSize(1, 12.5f);
        switch_.setTypeface(Typeface.SERIF);
        switch_.setTextColor(menu_bg_col);
        switch_.setOnCheckedChangeListener(onCheckedChangeListener);
        switch_.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -2));
        this.patchlist3.addView((View)switch_);
    }
    public void startAnimation() {
        final int start = Color.parseColor("#FFFF1EFF");
        final int end = Color.parseColor("#FF6000FF");

        final ArgbEvaluator evaluator = new ArgbEvaluator();
        gdAnimation.setCornerRadius(menu_bg_colOR);
        gdAnimation.setOrientation(GradientDrawable.Orientation.TL_BR);
        final GradientDrawable gradient = gdAnimation;

        ValueAnimator animator = TimeAnimator.ofFloat(0.0f, 1.0f);
        animator.setDuration(1000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Float fraction = valueAnimator.getAnimatedFraction();
                int newStrat = (int) evaluator.evaluate(fraction, start, end);
                int newEnd = (int) evaluator.evaluate(fraction, end, start);
                int[] newArray = {newStrat, newEnd};
                gradient.setColors(newArray);
            }
        });

        animator.start();
    }
    private void AddToggle5(String string, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        CheckBox switch_ = new CheckBox((Context)this);
        switch_.setText((CharSequence)string);
        switch_.setPadding(this.convertSizeToDp(10.0f), this.convertSizeToDp(5.0f), this.convertSizeToDp(10.0f), this.convertSizeToDp(5.0f));
        switch_.setTextSize(1, 12.5f);
        switch_.setTypeface(Typeface.SERIF);
        switch_.setTextColor(menu_bg_col);
        switch_.setOnCheckedChangeListener(onCheckedChangeListener);
        switch_.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -2));
        this.patchlist2.addView((View)switch_);
    }

    private void AddToggle6(String string, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        CheckBox switch_ = new CheckBox((Context)this);
        switch_.setText((CharSequence)string);
        switch_.setPadding(this.convertSizeToDp(10.0f), this.convertSizeToDp(5.0f), this.convertSizeToDp(10.0f), this.convertSizeToDp(5.0f));
        switch_.setTextSize(1, 12.5f);
        switch_.setTypeface(Typeface.SERIF);
        switch_.setTextColor(menu_bg_col);
        switch_.setOnCheckedChangeListener(onCheckedChangeListener);
        switch_.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -2));
        this.patchlist6.addView((View)switch_);
    }
    private void AddToggle7(String string, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        CheckBox switch_ = new CheckBox((Context)this);
        switch_.setText((CharSequence)string);
        switch_.setPadding(this.convertSizeToDp(10.0f), this.convertSizeToDp(5.0f), this.convertSizeToDp(10.0f), this.convertSizeToDp(5.0f));
        switch_.setTextSize(1, 12.5f);
        switch_.setTypeface(Typeface.SERIF);
        switch_.setTextColor(menu_bg_col);
        switch_.setOnCheckedChangeListener(onCheckedChangeListener);
        switch_.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -2));
        this.patchlist4.addView((View)switch_);
    }
    private void AddToggle8(String string, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        CheckBox switch_ = new CheckBox((Context)this);
        switch_.setText((CharSequence)string);
        switch_.setPadding(this.convertSizeToDp(10.0f), this.convertSizeToDp(5.0f), this.convertSizeToDp(10.0f), this.convertSizeToDp(5.0f));
        switch_.setTextSize(1, 12.5f);
        switch_.setTypeface(Typeface.SERIF);
        switch_.setTextColor(menu_bg_col);
        switch_.setOnCheckedChangeListener(onCheckedChangeListener);
        switch_.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -2));
        this.patchlist8.addView((View)switch_);
    }
    private View Switch(final int featureNum, final String featureName) {
        final Switch switchR = new Switch(this);
        ColorStateList buttonStates = new ColorStateList(
                new int[][]{
                        new int[]{-android.R.attr.state_enabled},
                        new int[]{android.R.attr.state_checked},

                }
        );
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            switchR.getThumbDrawable().setTintList(buttonStates);
            switchR.getTrackDra            new int[]{}
        },
        new int[]{
                Color.BLUE,
                Color.GREEN,
                Color.REDwable().setTintList(buttonStates);
        }

        switchR.setText(featureName);
        switchR.setTextColor(menu_bg_col);
        switchR.setPadding(10, 5, 0, 5);
        switchR.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
            }
        });
        return switchR;
    }
    public void AddRadioButton(Object obj, String[] strArr, int i, boolean b1, RadioGroup.OnCheckedChangeListener onCheckedChangeListener) {
        RadioGroup radioGroup = new RadioGroup(this);
        RadioButton[] radioButtonArr = new RadioButton[strArr.length];
        radioGroup.setOrientation(1);
        int i4 = i;
        for (int i2 = 0; i2 < strArr.length; i2++) {
            radioButtonArr[i2] = new RadioButton(this);
            if (i2 == i) {
                radioButtonArr[i2].setChecked(true);
            }
            radioButtonArr[i2].setPadding(convertSizeToDp(10.0f), convertSizeToDp(5.0f), convertSizeToDp(10.0f), convertSizeToDp(5.0f));
            radioButtonArr[i2].setText(strArr[i2]);
            radioButtonArr[i2].setTextSize(1, 11.0f);
            radioButtonArr[i2].setId(i2);
            radioButtonArr[i2].setGravity(5);
            radioButtonArr[i2].setTextColor(-16777216);
            radioGroup.addView(radioButtonArr[i2]);
        }
        radioGroup.setOnCheckedChangeListener(onCheckedChangeListener);
        radioGroup.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        if (obj instanceof ViewGroup) {
            ((ViewGroup) obj).addView(radioGroup);
        } else if (obj instanceof Integer) {
            this.contentLayouts[((Integer) obj).intValue()].addView(radioGroup);
        }
    }
    private void AddToggleDefTrue(String string, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        Switch switch_ = new Switch((Context)this);
        switch_.setText((CharSequence)string);
        switch_.setChecked(true);
        switch_.setPadding(10, 5, 0, 5);
        switch_.setX((float)this.convertSizeToDp(10.0f));
        switch_.setPadding(this.convertSizeToDp(10.0f), this.convertSizeToDp(5.0f), this.convertSizeToDp(10.0f), this.convertSizeToDp(5.0f));
        switch_.setTextSize(1, 12.5f);
        switch_.setTextColor(menu_bg_col);
        switch_.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
            }
        });
        ColorStateList colorStateList = new ColorStateList((int[][])new int[][]{{-16842910}, {16842912}, new int[0]}, new int[]{-16776961, -16711936, -65536});
        ColorStateList colorStateList2 = new ColorStateList((int[][])new int[][]{{-16842910}, new int[0]}, new int[]{-7829368, -3355444});
        if (Build.VERSION.SDK_INT >= 23) {
            if (Build.VERSION.SDK_INT >= 24) {
                switch_.setTrackTintList(colorStateList2);
                switch_.setTrackTintMode(PorterDuff.Mode.OVERLAY);
            }
            switch_.setThumbTintList(colorStateList);
        } else if (Build.VERSION.SDK_INT >= 21) {
            switch_.getThumbDrawable().setTintList(colorStateList);
            switch_.getTrackDrawable().setTintList(colorStateList2);
        }
        switch_.setOnCheckedChangeListener(onCheckedChangeListener);
        switch_.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -2));
        this.patchlist1.addView((View)switch_);
    }
    static native void Switch(int i, boolean k);

    static native void Switch2(int i);
    static native void TextSize(int var0);

    private int getLayoutType() {
        if (Build.VERSION.SDK_INT >= 26) {
            return 2038;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            return 2002;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return 2005;
        }
        return 2003;
    }
    public static native void DrawOn(ESPView espView, Canvas canvas);
    public void CreateCanvas() {
        ESPView eSPView;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -1, this.type, 56, -3);
        if (Build.VERSION.SDK_INT >= 28) {
            layoutParams.layoutInDisplayCutoutMode = 1;
        }
        layoutParams.x = 0;
        layoutParams.y = 0;
        layoutParams.gravity = 51;
        this.espLayout = eSPView = new ESPView((Context)this);
        this.windowManager.addView((View)eSPView, (ViewGroup.LayoutParams)layoutParams);
    }
    public int convertSizeToDp(float f) {
        return Math.round((float)TypedValue.applyDimension((int)1, (float)f, (DisplayMetrics)this.getResources().getDisplayMetrics()));
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        final RelativeLayout relativeLayout;
        TextView textView;
        super.onCreate();
        System.loadLibrary("NEXAMOD");
        // System.loadLibrary("NEXAMODE");
        int i4;
        windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        this.relativeLayout = new RelativeLayout((Context)this);
        this.type = this.getLayoutType();
        Display display = this.windowManager.getDefaultDisplay();
        Point point = new Point();
        display.getRealSize(point);
        this.width = point.x;
        this.height = point.y;
        this.dpi = Resources.getSystem().getDisplayMetrics().densityDpi;
        this.density = Resources.getSystem().getDisplayMetrics().density;
        this.hr = new LinearLayout.LayoutParams(-1, -1);
        this.hr.setMargins(0, 0, 0, 5);
        this.relativeLayout.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
        this.body = new LinearLayout((Context)this);
        body.setLayoutParams(new LinearLayout.LayoutParams(-1,-1));
        body.setOrientation(LinearLayout.HORIZONTAL);
        body.setGravity(Gravity.START);
        this.scrollViewr = new ScrollView((Context)this);
        this.scrollViewr.setLayoutParams(new ScrollView.LayoutParams(dp(170),-1));
        this.itemlist = new LinearLayout((Context)this);
        LinearLayout.LayoutParams layparam = new LinearLayout.LayoutParams(dp(140),-1);
        layparam.setMargins(dp(8),dp(8),dp(8),dp(8));
        itemlist.setLayoutParams(layparam);
        GradientDrawable gradientDrawable1 =new GradientDrawable();
        // gradientDrawable1.setColor(Color.parseColor("#0000A0"));
        gradientDrawable1.setColor(menu_bg_colOR);
        gradientDrawable1.setCornerRadius(40);
        itemlist.setOrientation(LinearLayout.VERTICAL);
        itemlist.setBackground(gradientDrawable1);
        itemlist.setPadding(dp(8),dp(18),dp(8),dp(3));
        menu1 = new TextView(this);
        menu1.setText("???????????????????????? ????????????????????????");
        menu1.setTextColor(menu_bg_col);
        menu1.setGravity(Gravity.CENTER);
        menu1.setBackgroundColor(Color.TRANSPARENT);
        menu1.setPadding(8,25,8,25);
        LinearLayout.LayoutParams patchmenu1 = new LinearLayout.LayoutParams(-1,-2);
        patchmenu1.setMargins(0,dp(25),0,0);
        menu1.setLayoutParams(patchmenu1);
        menu1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View p1)
            {
                GradientDrawable gradientDrawable1 =new GradientDrawable();
                gradientDrawable1.setStroke(dp(3),menu_bg_col);
                gradientDrawable1.setCornerRadius(0);
                menu1.setBackground(gradientDrawable1);
                menu1.setTextColor(menu_bg_col);
                scrollView.setVisibility(ScrollView.VISIBLE);
                menu2.setBackgroundColor(Color.TRANSPARENT);
                menu2.setTextColor(menu_bg_col);
                rgmmenu3.setBackgroundColor(Color.TRANSPARENT);
                rgmmenu3.setTextColor(menu_bg_col);
                scrollView2.setVisibility(ScrollView.GONE);
                scrollView3.setVisibility(ScrollView.GONE);
                rgmmenu6.setTextColor(menu_bg_col);
                rgmmenu6.setBackgroundColor(Color.TRANSPARENT);
                scrollView6.setVisibility(ScrollView.GONE);
                rgmmenu4.setTextColor(menu_bg_col);
                rgmmenu4.setBackgroundColor(Color.TRANSPARENT);
                scrollView7.setVisibility(ScrollView.GONE);
                rgmmenu5.setTextColor(menu_bg_col);
                rgmmenu5.setBackgroundColor(Color.TRANSPARENT);
                scrollView8.setVisibility(ScrollView.GONE);
            }
        });
        menu2 = new TextView(this);
        menu2.setText("???????????????? ????????????????????????");
        menu2.setBackgroundColor(Color.TRANSPARENT);
        menu2.setGravity(Gravity.CENTER);
        menu2.setTextColor(menu_bg_col);
        menu2.setPadding(10,25,10,25);
        menu2.setLayoutParams(patchmenu1);
        menu2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                GradientDrawable gradientDrawable1 =new GradientDrawable();
                gradientDrawable1.setStroke(dp(3),menu_bg_col);
                gradientDrawable1.setColor(menu_bg_color);
                gradientDrawable1.setCornerRadius(0);
                menu2.setBackground(gradientDrawable1);
                menu2.setTextColor(menu_bg_col);
                scrollView2.setVisibility(ScrollView.VISIBLE);
                menu1.setBackgroundColor(Color.TRANSPARENT);
                menu1.setTextColor(menu_bg_col);
                rgmmenu3.setBackgroundColor(Color.TRANSPARENT);
                rgmmenu3.setTextColor(menu_bg_col);
                scrollView.setVisibility(ScrollView.GONE);
                scrollView3.setVisibility(ScrollView.GONE);
                rgmmenu6.setTextColor(menu_bg_col);
                rgmmenu6.setBackgroundColor(Color.TRANSPARENT);
                scrollView6.setVisibility(ScrollView.GONE);
                rgmmenu4.setTextColor(menu_bg_col);
                rgmmenu4.setBackgroundColor(Color.TRANSPARENT);
                scrollView7.setVisibility(ScrollView.GONE);
                rgmmenu5.setTextColor(menu_bg_col);
                rgmmenu5.setBackgroundColor(Color.TRANSPARENT);
                scrollView8.setVisibility(ScrollView.GONE);
            }
        });
        rgmmenu3 = new TextView(this);
        rgmmenu3.setText("???????????????????????????????? ????????????????????????");
        rgmmenu3.setTextColor(menu_bg_col);
        rgmmenu3.setGravity(Gravity.CENTER);
        rgmmenu3.setBackgroundColor(Color.TRANSPARENT);
        rgmmenu3.setPadding(8,16,8,16);
        rgmmenu3.setLayoutParams(patchmenu1);
        rgmmenu3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                GradientDrawable gradientDrawable1 =new GradientDrawable();
                gradientDrawable1.setStroke(dp(3),menu_bg_col);
                gradientDrawable1.setColor(menu_bg_color);
                gradientDrawable1.setCornerRadius(0);
                rgmmenu3.setBackground(gradientDrawable1);
                rgmmenu3.setTextColor(menu_bg_col);
                scrollView3.setVisibility(ScrollView.VISIBLE);
                menu1.setBackgroundColor(Color.TRANSPARENT);
                menu1.setTextColor(menu_bg_col);
                menu2.setBackgroundColor(Color.TRANSPARENT);
                menu2.setTextColor(menu_bg_col);
                scrollView.setVisibility(ScrollView.GONE);
                scrollView2.setVisibility(ScrollView.GONE);
                rgmmenu6.setTextColor(menu_bg_col);
                rgmmenu6.setBackgroundColor(Color.TRANSPARENT);
                scrollView6.setVisibility(ScrollView.GONE);
                rgmmenu4.setTextColor(menu_bg_col);
                rgmmenu4.setBackgroundColor(Color.TRANSPARENT);
                scrollView7.setVisibility(ScrollView.GONE);
                rgmmenu5.setTextColor(menu_bg_col);
                rgmmenu5.setBackgroundColor(Color.TRANSPARENT);
                scrollView8.setVisibility(ScrollView.GONE);
            }
        });

        rgmmenu6 = new TextView(this);
        rgmmenu6.setText("????????????????????????????");
        rgmmenu6.setTextColor(menu_bg_col);
        rgmmenu6.setGravity(Gravity.CENTER);
        rgmmenu6.setBackgroundColor(Color.TRANSPARENT);
        rgmmenu6.setPadding(8,16,8,16);
        rgmmenu6.setLayoutParams(patchmenu1);
        rgmmenu6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                GradientDrawable gradientDrawable1 =new GradientDrawable();
                gradientDrawable1.setStroke(dp(3),menu_bg_col);
                gradientDrawable1.setColor(menu_bg_color);
                gradientDrawable1.setCornerRadius(0);
                rgmmenu6.setBackground(gradientDrawable1);
                rgmmenu6.setTextColor(menu_bg_col);
                scrollView6.setVisibility(ScrollView.VISIBLE);
                menu1.setBackgroundColor(Color.TRANSPARENT);
                menu1.setTextColor(menu_bg_col);
                menu2.setBackgroundColor(Color.TRANSPARENT);
                menu2.setTextColor(menu_bg_col);
                rgmmenu3.setTextColor(menu_bg_col);
                rgmmenu3.setBackgroundColor(Color.TRANSPARENT);
                scrollView.setVisibility(ScrollView.GONE);
                scrollView2.setVisibility(ScrollView.GONE);
                scrollView3.setVisibility(ScrollView.GONE);
                rgmmenu4.setTextColor(menu_bg_col);
                rgmmenu4.setBackgroundColor(Color.TRANSPARENT);
                scrollView7.setVisibility(ScrollView.GONE);
                rgmmenu5.setTextColor(menu_bg_col);
                rgmmenu5.setBackgroundColor(Color.TRANSPARENT);
                scrollView8.setVisibility(ScrollView.GONE);
            }
        });
        rgmmenu4 = new TextView(this);
        rgmmenu4.setText("???????????????????????? ????????????????");
        rgmmenu4.setTextColor(menu_bg_col);
        rgmmenu4.setGravity(Gravity.CENTER);
        rgmmenu4.setBackgroundColor(Color.TRANSPARENT);
        rgmmenu4.setPadding(8,16,8,16);
        rgmmenu4.setLayoutParams(patchmenu1);
        rgmmenu4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                GradientDrawable gradientDrawable1 =new GradientDrawable();
                gradientDrawable1.setStroke(dp(3),menu_bg_col);
                gradientDrawable1.setColor(menu_bg_color);
                gradientDrawable1.setCornerRadius(0);
                rgmmenu4.setBackground(gradientDrawable1);
                rgmmenu4.setTextColor(menu_bg_col);
                scrollView7.setVisibility(ScrollView.VISIBLE);
                menu1.setBackgroundColor(Color.TRANSPARENT);
                menu1.setTextColor(menu_bg_col);
                menu2.setBackgroundColor(Color.TRANSPARENT);
                menu2.setTextColor(menu_bg_col);
                scrollView.setVisibility(ScrollView.GONE);
                scrollView2.setVisibility(ScrollView.GONE);
                rgmmenu6.setTextColor(menu_bg_col);
                rgmmenu6.setBackgroundColor(Color.TRANSPARENT);
                scrollView6.setVisibility(ScrollView.GONE);
                scrollView3.setVisibility(ScrollView.GONE);
                rgmmenu5.setTextColor(menu_bg_col);
                rgmmenu5.setBackgroundColor(Color.TRANSPARENT);
                scrollView8.setVisibility(ScrollView.GONE);
                rgmmenu3.setTextColor(menu_bg_col);
                rgmmenu3.setBackgroundColor(Color.TRANSPARENT);
                scrollView3.setVisibility(ScrollView.GONE);
            }
        });
        rgmmenu5 = new TextView(this);
        rgmmenu5.setText("???????????????????????? ???????????????????");
        rgmmenu5.setTextColor(menu_bg_col);
        rgmmenu5.setGravity(Gravity.CENTER);
        rgmmenu5.setBackgroundColor(Color.TRANSPARENT);
        rgmmenu5.setPadding(8,16,8,16);
        rgmmenu5.setLayoutParams(patchmenu1);
        rgmmenu5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                GradientDrawable gradientDrawable1 =new GradientDrawable();
                gradientDrawable1.setStroke(dp(3),menu_bg_col);
                gradientDrawable1.setColor(menu_bg_color);
                gradientDrawable1.setCornerRadius(0);
                rgmmenu5.setBackground(gradientDrawable1);
                rgmmenu5.setTextColor(menu_bg_col);
                scrollView8.setVisibility(ScrollView.VISIBLE);
                menu1.setBackgroundColor(Color.TRANSPARENT);
                menu1.setTextColor(menu_bg_col);
                menu2.setBackgroundColor(Color.TRANSPARENT);
                menu2.setTextColor(menu_bg_col);
                scrollView.setVisibility(ScrollView.GONE);
                scrollView2.setVisibility(ScrollView.GONE);
                rgmmenu4.setTextColor(menu_bg_col);
                rgmmenu4.setBackgroundColor(Color.TRANSPARENT);
                scrollView7.setVisibility(ScrollView.GONE);
                //scrollView6.setVisibility(ScrollView.GONE);
                rgmmenu6.setTextColor(menu_bg_col);
                rgmmenu6.setBackgroundColor(Color.TRANSPARENT);
                scrollView6.setVisibility(ScrollView.GONE);
                rgmmenu3.setTextColor(menu_bg_col);
                rgmmenu3.setBackgroundColor(Color.TRANSPARENT);
                scrollView3.setVisibility(ScrollView.GONE);
            }
        });
        this.itemmenu = new LinearLayout(this);
        LinearLayout.LayoutParams lay2param = new LinearLayout.LayoutParams(-1,-1);
        lay2param.setMargins(dp(150),dp(30),dp(8),dp(8));
        this.itemmenu.setLayoutParams(lay2param);
        GradientDrawable gradientdrawable = new GradientDrawable();
        gradientdrawable.setCornerRadius(40);
        // gradientdrawable.setColor(Color.parseColor("#0000A0"));
        gradientdrawable.setColor(menu_bg_color);
        this.itemmenu.setBackground(gradientdrawable);
        this.itemmenu.setOrientation(LinearLayout.VERTICAL);
        this.relativeLayout.addView((View)this.body);
        this.relativeLayout.addView((View)this.itemmenu);
        this.body.addView((View)this.scrollViewr);
        this.scrollViewr.addView((View)this.itemlist);
        itemlist.addView(menu1);
        itemlist.addView(menu2);
        itemlist.addView(rgmmenu3);
        itemlist.addView(rgmmenu6);
        itemlist.addView(rgmmenu4);
        itemlist.addView(rgmmenu5);
        this.scrollView = new ScrollView((Context)this);
        this.scrollView.setLayoutParams(new ScrollView.LayoutParams(-1,-1));
        this.patchlist1 = new LinearLayout((Context)this);
        this.patchlist1.setLayoutParams(new LinearLayout.LayoutParams(-1,-1));
        this.patchlist1.setOrientation(LinearLayout.VERTICAL);
        this.scrollView2 = new ScrollView((Context)this);
        this.scrollView2.setLayoutParams(new ScrollView.LayoutParams(-1,-1));
        this.scrollView3 = new ScrollView((Context)this);
        this.scrollView3.setLayoutParams(new ScrollView.LayoutParams(-1,-1));
        this.scrollView6 = new ScrollView((Context)this);
        this.scrollView6.setLayoutParams(new ScrollView.LayoutParams(-1,-1));
        this.scrollView7 = new ScrollView((Context)this);
        this.scrollView7.setLayoutParams(new ScrollView.LayoutParams(-1,-1));
        this.scrollView8 = new ScrollView((Context)this);
        this.scrollView8.setLayoutParams(new ScrollView.LayoutParams(-1,-1));
        this.patchlist2 = new LinearLayout((Context)this);
        this.patchlist2.setLayoutParams(new LinearLayout.LayoutParams(-1,-1));
        this.patchlist2.setOrientation(LinearLayout.VERTICAL);
        this.patchlist3 = new LinearLayout((Context)this);
        this.patchlist3.setLayoutParams(new LinearLayout.LayoutParams(-1,-1));
        this.patchlist3.setOrientation(LinearLayout.VERTICAL);
        this.patchlist6 = new LinearLayout((Context)this);
        this.patchlist6.setLayoutParams(new LinearLayout.LayoutParams(-1,-1));
        this.patchlist6.setOrientation(LinearLayout.VERTICAL);
        this.patchlist4 = new LinearLayout((Context)this);
        this.patchlist4.setLayoutParams(new LinearLayout.LayoutParams(-1,-1));
        this.patchlist4.setOrientation(LinearLayout.VERTICAL);
        this.patchlist8 = new LinearLayout((Context)this);
        this.patchlist8.setLayoutParams(new LinearLayout.LayoutParams(-1,-1));
        this.patchlist8.setOrientation(LinearLayout.VERTICAL);
        this.scrollView.addView((View)this.patchlist1);
        this.scrollView2.addView((View)this.patchlist2);
        this.scrollView3.addView((View)this.patchlist3);
        this.scrollView6.addView((View)this.patchlist6);
        this.scrollView7.addView((View)this.patchlist4);
        this.scrollView8.addView((View)this.patchlist8);

        int n = this.convertSizeToDp(470.0f);
        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams(n, this.convertSizeToDp(320.0f), this.type, 8, -3);
        // this.relativeLayout.setBackgroundColor(Color.RED);
        this.relativeLayout.setBackgroundColor(menu_bg_color);
        //this.relativeLayout.setBackgroundColor(menu_bg_color);
        layoutParams2.x = 0;
        layoutParams2.y = 0;
        layoutParams2.gravity = 51;
        this.g_layoutParams = layoutParams2;
        FrameLayout frameLayout = new FrameLayout((Context)this);
        frameLayout.setClickable(true);
        frameLayout.setFocusable(true);
        frameLayout.setFocusableInTouchMode(true);
        frameLayout.setBackgroundColor(menu_bg_col);
        frameLayout.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(n, (int)((float)this.dpi / 5.5f)));
        Button button = new Button((Context)this);
        button.setPadding(30,20,20,30);
        button.setText("???");
        button.setTextColor(-1);
        button.setTextSize(1, 10.0f);
        button.setWidth(0);
        button.setTranslationX(1200);
        button.setGravity(Gravity.START);
        button.setBackgroundColor(Color.parseColor("#000000"));
        button.setX((float)(n - (int)((float)this.dpi / 5f)));
        frameLayout.addView((View)button);
        this.textTitle = textView = new TextView((Context)this);
        textView.setText((CharSequence)title);
        this.textTitle.setGravity(22);
        TitanicTextView textTitle = new TitanicTextView(this);
        //title.setText(Html.fromHtml(Title()));
        //RelativeLayout.LayoutParams rl = new RelativeLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT);
        //rl.addRule(RelativeLayout.CENTER_HORIZONTAL);
        //textTitle.setLayoutParams(rl);
        //setTitleText(textTitle);
        new Titanic().start(textTitle);
        this.textTitle.setTextColor(Color.WHITE);
        this.textTitle.setTypeface(null, 1);
        this.textTitle.setPadding(this.convertSizeToDp(50.0f), 0, 0, 0);
        this.textTitle.setTextSize(20.0f);
        frameLayout.addView((View)this.textTitle);
        this.itemmenu.addView((View)this.scrollView);
        this.itemmenu.addView((View)this.scrollView2);
        this.itemmenu.addView((View)this.scrollView3);
        this.itemmenu.addView((View)this.scrollView6);
        this.itemmenu.addView((View)this.scrollView7);
        this.itemmenu.addView((View)this.scrollView8);
        this.relativeLayout.addView((View)frameLayout);
        this.relativeLayout.setAlpha(20.0f);
        this.iconLayout = relativeLayout = new RelativeLayout((Context)this);
        relativeLayout.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-2, -2));
        ImageView imageView = new ImageView((Context)this);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(this.convertSizeToDp(60.0f), this.convertSizeToDp(60.0f)));
        relativeLayout.addView((View)imageView);
        byte[] arrby = Base64.decode(Icon(), 0);
        imageView.setImageBitmap(BitmapFactory.decodeByteArray((byte[])arrby, (int)0, (int)arrby.length));
        final WindowManager.LayoutParams layoutParams4 = new WindowManager.LayoutParams(-2, -2, this.type, 8, -3);
        layoutParams4.gravity = 51;
        layoutParams4.x = 0;
        layoutParams4.y = 0;
        this.windowManager.addView((View)relativeLayout, (ViewGroup.LayoutParams)layoutParams4);
        this.windowManager.addView((View)this.relativeLayout, (ViewGroup.LayoutParams)layoutParams2);
        this.relativeLayout.setVisibility(20);
        //  CreateMenuList();
        frameLayout.setOnTouchListener(new View.OnTouchListener(){
            float deltaX;
            float deltaY;
            float maxX;
            float maxY;
            float newX;
            float newY;
            float pressedX;
            float pressedY;

            public boolean onTouch(View view, MotionEvent motionEvent) {
                int f = motionEvent.getActionMasked();
                if (f == 0) {
                    this.deltaX = (float)FloatingModMenuService.this.g_layoutParams.x - motionEvent.getRawX();
                    this.deltaY = (float)FloatingModMenuService.this.g_layoutParams.y - motionEvent.getRawY();
                    this.pressedX = motionEvent.getRawX();
                    this.pressedY = motionEvent.getRawY();
                    FloatingModMenuService.this.scrollView.requestDisallowInterceptTouchEvent(true);
                    return false;
                }
                if (f == 1) {
                    float f;
                    float f2;
                    float f3;
                    float f4;
                    this.maxX = FloatingModMenuService.this.width - FloatingModMenuService.this.relativeLayout.getWidth();
                    this.maxY = FloatingModMenuService.this.height - FloatingModMenuService.this.relativeLayout.getHeight();
                    if (this.newX < 0.0f) {
                        this.newX = 0.0f;
                    }
                    if ((f = this.newX) > (f3 = this.maxX)) {
                        this.newX = (int)f3;
                    }
                    if (this.newY < 0.0f) {
                        this.newY = 0.0f;
                    }
                    if ((f4 = this.newY) > (f2 = this.maxY)) {
                        this.newY = (int)f2;
                    }
                    FloatingModMenuService.this.g_layoutParams.x = (int)this.newX;
                    FloatingModMenuService.this.g_layoutParams.y = (int)this.newY;
                    FloatingModMenuService.this.windowManager.updateViewLayout((View)FloatingModMenuService.this.relativeLayout, (ViewGroup.LayoutParams)FloatingModMenuService.this.g_layoutParams);
                    FloatingModMenuService.this.relativeLayout.setAlpha(10.0f);
                    FloatingModMenuService.this.scrollView.requestDisallowInterceptTouchEvent(false);
                    return true;
                }
                if (n == 2) {
                    float f;
                    float f5;
                    this.newX = motionEvent.getRawX() + this.deltaX;
                    this.newY = motionEvent.getRawY() + this.deltaY;
                    this.maxX = FloatingModMenuService.this.width - FloatingModMenuService.this.relativeLayout.getWidth();
                    this.maxY = f5 = (float)(FloatingModMenuService.this.height - FloatingModMenuService.this.relativeLayout.getHeight());
                    float f6 = this.newX;
                    if (f6 >= 0.0f && f6 <= this.maxX && (f = this.newY) >= 0.0f && f <= f5) {
                        FloatingModMenuService.this.relativeLayout.setAlpha(10.f);
                        FloatingModMenuService.this.g_layoutParams.x = (int)this.newX;
                        FloatingModMenuService.this.g_layoutParams.y = (int)this.newY;
                        FloatingModMenuService.this.windowManager.updateViewLayout((View)FloatingModMenuService.this.relativeLayout, (ViewGroup.LayoutParams)FloatingModMenuService.this.g_layoutParams);
                    }
                    FloatingModMenuService.this.relativeLayout.setAlpha(10.0f);
                    FloatingModMenuService.this.g_layoutParams.x = (int)this.newX;
                    FloatingModMenuService.this.g_layoutParams.y = (int)this.newY;
                    FloatingModMenuService.this.windowManager.updateViewLayout((View)FloatingModMenuService.this.relativeLayout, (ViewGroup.LayoutParams)FloatingModMenuService.this.g_layoutParams);
                }
                return false;
            }
        });
        relativeLayout.setOnTouchListener(new View.OnTouchListener(){
            float deltaX;
            float deltaY;
            float newX;
            float newY;
            float pressedX;
            float pressedY;

            public boolean onTouch(View view, MotionEvent motionEvent) {
                int n = motionEvent.getActionMasked();
                if (n == 0) {
                    this.deltaX = (float)layoutParams4.x - motionEvent.getRawX();
                    this.deltaY = (float)layoutParams4.y - motionEvent.getRawY();
                    this.pressedX = motionEvent.getRawX();
                    this.pressedY = motionEvent.getRawY();
                    return false;
                }
                if (n == 1) {
                    int n2 = (int)(motionEvent.getRawX() - this.pressedX);
                    int n3 = (int)(motionEvent.getRawY() - this.pressedY);
                    if (n2 == 0 && n3 == 0) {
                        FloatingModMenuService.this.relativeLayout.setVisibility(0);
                        relativeLayout.setVisibility(20);
                    }
                    return true;
                }
                if (n == 2) {
                    this.newX = motionEvent.getRawX() + this.deltaX;
                    this.newY = motionEvent.getRawY() + this.deltaY;
                    float f = FloatingModMenuService.this.width - view.getWidth();
                    float f2 = FloatingModMenuService.this.height - view.getHeight();
                    if (this.newX < 0.0f) {
                        this.newX = 0.0f;
                    }
                    if (this.newX > f) {
                        this.newX = (int)f;
                    }
                    if (this.newY < 0.0f) {
                        this.newY = 0.0f;
                    }
                    if (this.newY > f2) {
                        this.newY = (int)f2;
                    }
                    layoutParams4.x = (int)this.newX;
                    layoutParams4.y = (int)this.newY;
                    FloatingModMenuService.this.windowManager.updateViewLayout((View)relativeLayout, (ViewGroup.LayoutParams)layoutParams4);
                }
                return false;
            }
        });
        button.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                FloatingModMenuService.this.relativeLayout.setVisibility(20);
                relativeLayout.setVisibility(0);
            }
        });
        CreateCanvas();
        this.AddTextDivide("???????????? ????????????????");
        AddToggle("Active Esp", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                ESPView eSPView = espLayout;
                int n = bl ? 0 : 4;
                eSPView.setVisibility(n);
            }
        });

        AddToggle("Esp Box", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(1, bl);
            }
        });
        AddToggle("Esp Line", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(2, bl);
            }
        });

        AddToggle("Esp Distance", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(3, bl);
            }
        });
        AddToggle("Esp Health", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(4, bl);
            }
        });
        AddToggle("Player Name", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(5, bl);
            }
        });
        AddToggle("Esp Head", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(6, bl);
            }
        });
        AddToggle("Esp 360??", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(7, bl);
            }
        });
        this.AddToggle("Skeleton", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(8, bl);
            }
        });
        AddToggle("Grenade Warning", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(9, bl);
            }
        });
        this.AddToggle("Enemy Count", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(14, bl);
            }
        });
        this.AddTextDivide1("Vehicles :-");
        this.AddToggle4("Buggy", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(15, bl);
            }
        });

        this.AddToggle4("UAZ", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(16, bl);
            }
        });

        this.AddToggle4("Trike", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(17, bl);
            }
        });

        this.AddToggle4("Bike", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(18, bl);
            }
        });

        this.AddToggle4("Dacia", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(19, bl);
            }
        });

        this.AddToggle4("Jet", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(20, bl);
            }
        });

        this.AddToggle4("Boat", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(21, bl);
            }
        });

        this.AddToggle4("Bus", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(22, bl);
            }
        });
        this.AddToggle4("Mirado", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(23, bl);
            }
        });

        this.AddToggle4("Scooter", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(24, bl);
            }
        });
        this.AddToggle4("Rony", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(25, bl);
            }
        });

        this.AddToggle4("Snowbike", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(26, bl);
            }
        });
        this.AddToggle4("Snowmobile", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(27, bl);
            }
        });

        this.AddToggle4("Tempo", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(28, bl);
            }
        });

        this.AddToggle4("Truck", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(29, bl);
            }
        });

        this.AddToggle4("BRDM", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(30, bl);
            }
        });

        this.AddToggle4("LadaNiva", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(31, bl);
            }
        });

        this.AddToggle4("MonsterTruck", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(32, bl);
            }
        });

        this.AddTextDivide2("Scopes :-");
        this.AddToggle5("6x", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(39, bl);
            }
        });

        this.AddToggle5("8x", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(40, bl);
            }
        });
        this.AddTextDivide2("AR:-");
        this.AddToggle5("Aug", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(41, bl);
            }
        });

        this.AddToggle5("M762", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(42, bl);
            }
        });
        this.AddToggle5("Scar-L", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(43, bl);
            }
        });

        this.AddToggle5("M416", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(44, bl);
            }
        });
        this.AddToggle5("M164-A", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(45, bl);
            }
        });

        this.AddToggle5("Mk47 Mutant", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(46, bl);
            }
        });

        this.AddToggle5("G36C", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(47, bl);
            }
        });

        this.AddToggle5("QBZ", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(48, bl);
            }
        });

        this.AddToggle5("AKM", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(49, bl);
            }
        });

        this.AddToggle5("Groza", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(50, bl);
            }
        });
        this.AddToggle5("DP28", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(57, bl);
            }
        });

        this.AddToggle5("M249", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(58, bl);
            }
        });

        this.AddToggle5("AWM", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(59, bl);
            }
        });

        this.AddTextDivide2("Ammo :-");
        this.AddToggle5("7.62", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(86, bl);
            }
        });

        this.AddToggle5("5.56", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(88, bl);
            }
        });
        this.AddTextDivide2("Bag Helmet Vest :-");
        this.AddToggle5("Bag lvl 1", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(93, bl);
            }
        });

        this.AddToggle5("Bag lvl 2", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(94, bl);
            }
        });
        this.AddToggle5("Bag lvl 3", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(95, bl);
            }
        });

        this.AddToggle5("Helmet lvl 1", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(96, bl);
            }
        });

        this.AddToggle5("Helmet lvl 2", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(97, bl);
            }
        });

        this.AddToggle5("Helmet lvl 3", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(98, bl);
            }
        });

        this.AddToggle5("Vest lvl 1", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(99, bl);
            }
        });

        this.AddToggle5("Vest lvl 2", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(100, bl);
            }
        });

        this.AddToggle5("Vest lvl 3", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(101, bl);
            }
        });
        this.AddTextDivide2("Health Kits :-");
        this.AddToggle5("FirstAidKit", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(105, bl);
            }
        });
        this.AddToggle5("Medkit", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(107, bl);
            }
        });
        this.AddTextDivide2("Throwables :-");
        this.AddToggle5("Grenade", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(109, bl);
            }
        });

        this.AddToggle5("Smoke", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(110, bl);
            }
        });

        this.AddToggle5("Molotov", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(111, bl);
            }
        });
        this.AddTextDivide3("Special Items :-");
        this.AddToggle6("Flare Gun", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(130, bl);
            }
        });
        this.AddToggle6("Ghillie Suit", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(131, bl);
            }
        });

        this.AddToggle6("Cheek Pad", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(132, bl);
            }
        });

        this.AddToggle6("Player Crate", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(133, bl);
            }
        });

        this.AddToggle6("AirDrop Plane", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(134, bl);
            }
        });

        this.AddToggle6("AirDrop", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(135, bl);
            }
        });
        this.AddTextDivide7("AIMBOT MENU :-");
        this.AddToggle7("AIMBOT", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(136, bl);
            }
        });
        this.AddTextDivide8("MEMORY HACKS :-");
        this.AddToggle8("BLACK SKY", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(137, bl);
            }
        });
        this.AddToggle8("ANTI SHAKE", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(138, bl);
            }
        });
        this.AddToggle8("NO FOG", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(139, bl);
            }
        });
        this.AddToggle8("LESS RECOIL", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(140, bl);
            }
        });
        this.AddToggle8("SMALL CROSSHIR", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(141, bl);
            }
        });
        //IPAD VIEW
        this.AddToggle8("IPAD", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(142, bl);
            }
        });
        //FLASH
        this.AddToggle8("BLACK BODY", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(143, bl);
            }
        });
        this.AddToggle8("MAGIC BULLET", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(144, bl);
            }
        });
        this.AddToggle8("RED FOG", new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Switch(145, bl);
            }
        });
        AddButton("TELEGRAM", new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setFlags(268435456);
                intent.setPackage("org.telegram.messenger");
                intent.setData(Uri.parse("https://t.me/nexahacks"));
                FloatingModMenuService.this.getApplicationContext().startActivity(intent);
            }
        });
    }

    public void onDestroy() {
        this.windowManager.removeViewImmediate((View)this.espLayout);
        this.windowManager.removeViewImmediate((View)this.iconLayout);
        this.windowManager.removeViewImmediate((View)this.relativeLayout);
        super.onDestroy();
    }
    public static interface OnListChoosedListener {
        public void onChoosed(int var1);
    }
    private int convertDipToPixels(int i) {
        return (int) ((((float) i) * getResources().getDisplayMetrics().density) + 0.5f);
    }
    private int dp(int i) {
        return (int) TypedValue.applyDimension(1, (float) i, getResources().getDisplayMetrics());
    }

    public void onTaskRemoved(Intent intent) {
        stopSelf();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        super.onTaskRemoved(intent);
    }

    private interface InterfaceBtn {
        void OnWrite();
    }

    private interface InterfaceInt {
        void OnWrite(int i);
    }

    private interface InterfaceBool {
        void OnWrite(boolean z);
    }

    private interface InterfaceStr {
        void OnWrite(String s);
    }
}