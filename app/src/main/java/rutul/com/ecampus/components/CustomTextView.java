package rutul.com.ecampus.components;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextUtils;
import android.util.AttributeSet;

import rutul.com.ecampus.R;
import rutul.com.ecampus.utils.HelperMethods;

public class CustomTextView extends AppCompatTextView {

    public CustomTextView(Context context) {
        super(context);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCustomFont(context, attrs);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setCustomFont(context, attrs);
    }

    private void setCustomFont(Context ctx, AttributeSet attrs) {
        TypedArray a = ctx.obtainStyledAttributes(attrs, R.styleable.CustomFont);
        String customFont = a.getString(R.styleable.CustomFont_myFont);
        setCustomFont(ctx, customFont);
        a.recycle();
    }

    public boolean setCustomFont(Context ctx, String customFont) {
        this.setImeOptions(TextUtils.CAP_MODE_SENTENCES);
        Typeface tf = null;
        try {
            tf = Typeface.createFromAsset(ctx.getAssets(), getResources().getString(R.string.FONT_REGULAR));
        } catch (Exception e) {
            return false;
        }

        if (HelperMethods.checkForValidString(customFont)) {
            if (customFont.equalsIgnoreCase(ctx.getString(R.string.REGULAR))) {
                tf = Typeface.createFromAsset(ctx.getAssets(), getResources().getString(R.string.FONT_REGULAR));
            } else if (customFont.equalsIgnoreCase(ctx.getString(R.string.LIGHT))) {
                tf = Typeface.createFromAsset(ctx.getAssets(), getResources().getString(R.string.FONT_LIGHT));
            } else if (customFont.equalsIgnoreCase(ctx.getString(R.string.BOLD))) {
                tf = Typeface.createFromAsset(ctx.getAssets(), getResources().getString(R.string.FONT_BOLD));
            } else if (customFont.equalsIgnoreCase(ctx.getString(R.string.MEDIUM))) {
                tf = Typeface.createFromAsset(ctx.getAssets(), getResources().getString(R.string.FONT_MEDIUM));
            } else if (customFont.equalsIgnoreCase(ctx.getString(R.string.SEMIBOLD))) {
                tf = Typeface.createFromAsset(ctx.getAssets(), getResources().getString(R.string.FONT_SEMIBOLD));
            }
        }
        setTypeface(tf);
        return true;
    }
}
