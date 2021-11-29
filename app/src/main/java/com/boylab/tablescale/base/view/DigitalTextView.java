package com.boylab.tablescale.base.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.annotation.Nullable;

public class DigitalTextView extends androidx.appcompat.widget.AppCompatTextView {

    public DigitalTextView(Context context) {
        super(context);
        Typeface tf = Typeface.createFromAsset(context.getAssets(), "font/digittext.TTF");
        setTypeface(tf);
    }

    public DigitalTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Typeface tf = Typeface.createFromAsset(context.getAssets(), "font/digittext.TTF");
        setTypeface(tf);
    }

    public DigitalTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        Typeface tf = Typeface.createFromAsset(context.getAssets(), "font/digittext.TTF");
        setTypeface(tf);
    }
}
