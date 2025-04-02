package com.example.handler;

import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class Rotation extends RotateAnimation {
    public Rotation(float fromDegrees, float toDegrees, int pivotXType, float pivotXValue,
                    int pivotYType, float pivotYValue, int dureeRotation, ImageView image) {
        super(fromDegrees, toDegrees, pivotXType, pivotXValue, pivotYType, pivotYValue);

        setDuration(dureeRotation);
        setInterpolator(new LinearInterpolator());
        image.startAnimation(this);
    }
    public Rotation(float fromDegrees, float toDegrees, float pivotXValue,
                    float pivotYValue, int dureeRotation, ImageView image) {
        super(fromDegrees, toDegrees, RELATIVE_TO_SELF, pivotXValue, RELATIVE_TO_SELF, pivotYValue);

        setDuration(dureeRotation);
        setInterpolator(new LinearInterpolator());
        image.startAnimation(this);
    }
}