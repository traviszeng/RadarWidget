package traviszeng.com.radarwidget;

/**
 * Created by Travis Zeng on 2017/3/14.
 */

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;



/**
 * Radar scanning effect
 *
 * */

public class Radar extends FrameLayout{


    private ImageView scanning;
    private ImageView target;
    private RotateAnimation rotateAnimation;
    private AlphaAnimation alphaAnimation;
    private boolean isRunning = true;

    //three constructor with parameters
    public Radar(Context context){
        super(context);
        init(context);
    }

    public Radar(Context context, AttributeSet attributeSet,int defStyle){
        super(context,attributeSet,defStyle);
        init(context);
    }

    public Radar(Context context, AttributeSet attributeSet){
        this(context,attributeSet,0);
    }

    public void init(Context context){
        LayoutInflater.from(context).inflate(R.layout.radar_element,this);
        scanning = (ImageView) findViewById(R.id.scan);
        target = (ImageView) findViewById(R.id.target);

        rotateAnimation = new RotateAnimation(0,360, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setDuration(2000);
        rotateAnimation.setRepeatCount(Animation.INFINITE);

        alphaAnimation = new AlphaAnimation(0.0f,1.0f);
        alphaAnimation.setDuration(3000);
        alphaAnimation.setRepeatCount(Animation.INFINITE);
    }


    @Override
    protected void onAttachedToWindow() {
        // TODO Auto-generated method stub
        super.onAttachedToWindow();
        scanning.startAnimation(rotateAnimation);
        target.startAnimation(alphaAnimation);
        isRunning = true;

    }

    public void startAnimation() {
        scanning.startAnimation(rotateAnimation);
        target.startAnimation(alphaAnimation);
        isRunning = true;
    }

    //function to stop the animation
    public void stopAnimation() {
        scanning.clearAnimation();   // clear the animation of this ImageView
        target.clearAnimation();    // clear the animation of this ImageView
        isRunning = false;
    }

    @Override
    protected void onDetachedFromWindow() {
        // TODO Auto-generated method stub
        super.onDetachedFromWindow();
        scanning.clearAnimation();
        target.clearAnimation();
        isRunning = false;
    }

    public boolean isRunning() {
        return isRunning;
    }
}
