package de.fff.mightymind;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;


public class ColoredButton extends AppCompatButton {

    private int myColor;

    public ColoredButton(@NonNull Context context) {
        super(context);
        myColor = 0;
    }

    public ColoredButton(@NonNull Context context, AttributeSet attrs) {
        super(context, attrs);
        myColor = 0;
    }

    public ColoredButton(@NonNull Context context, AttributeSet attrs, int defStyle) {
        super(context,attrs,defStyle);
        myColor = 0;
    }

    public void setMyColor(int colorParam) {
        this.myColor = colorParam;
    }

    public int getMyColor() {
        return myColor;
    }


}
