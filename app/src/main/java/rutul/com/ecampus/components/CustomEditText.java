package rutul.com.ecampus.components;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;

import rutul.com.ecampus.R;
import rutul.com.ecampus.utils.HelperMethods;

public class CustomEditText extends android.support.v7.widget.AppCompatEditText {
    private boolean disableEmoji;

    public CustomEditText(Context context) {
        super(context);
    }

    public CustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCustomFont(context, attrs);
    }

    public CustomEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setCustomFont(context, attrs);
    }

    private void setCustomFont(Context ctx, AttributeSet attrs) {
        TypedArray a = ctx.obtainStyledAttributes(attrs, R.styleable.CustomFont);
        String customFont = a.getString(R.styleable.CustomFont_myFont);
        setCustomFont(ctx, customFont);
        disableEmoji = a.getBoolean(R.styleable.CustomFont_disable_emoji, false);
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
