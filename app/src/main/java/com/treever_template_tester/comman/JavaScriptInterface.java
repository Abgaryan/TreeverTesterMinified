package com.treever_template_tester.comman;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.webkit.JavascriptInterface;

/**
 * Created by Abgaryan on 9/15/15.
 */
public class JavaScriptInterface {

    private final Runnable rnStartAnimation;
    private final Runnable rnPauseAnimation;
    private final Runnable rnResumeAnimation;
    private final Runnable rnEndAnimation;

    private AnimationStates anim_state;
    private int ms_elapsed_since_start = 0;
    private AnimationStates anim_state_saved;
    private int ms_from_start_saved;

    private boolean do_restart = false;

    Context ctxt;


    public JavaScriptInterface(Activity activiy, Runnable rnStartAnimation, Runnable rnPauseAnimation,
                               Runnable rnResumeAnimation, Runnable rnEndAnimation) {

        this.rnStartAnimation = rnStartAnimation;
        this.rnPauseAnimation = rnPauseAnimation;
        this.rnResumeAnimation = rnResumeAnimation;
        this.rnEndAnimation = rnEndAnimation;

        this.anim_state = AnimationStates.INITIAL;
        this.anim_state_saved = AnimationStates.INITIAL;

        this.ms_elapsed_since_start = 0;
        this.ms_from_start_saved = 0;

        this.do_restart = false;

        this.ctxt = activiy.getBaseContext();
    }

    public void onSaveInstanceState(Bundle savedInstanceState) {


        int ms_initial = (this.ms_from_start_saved > 0) ? this.ms_from_start_saved : this.ms_elapsed_since_start;
        savedInstanceState.putInt(BUNDLES.MS_SINCE_START.name(), ms_initial);

        AnimationStates anim_intial = (this.anim_state_saved != AnimationStates.INITIAL) ? this.anim_state_saved : this.anim_state;
        savedInstanceState.putInt(BUNDLES.ANIM_STATE.name(), anim_intial.getCode());
    }


    public void onRestoreInstanceState (Bundle savedInstanceState) {
        this.ms_from_start_saved = savedInstanceState.getInt(BUNDLES.MS_SINCE_START.name(), 0);
        this.ms_elapsed_since_start = this.ms_from_start_saved;

        int anim_int = savedInstanceState.getInt(BUNDLES.ANIM_STATE.name(), 0);
        this.anim_state_saved = AnimationStates.get(anim_int);
        this.anim_state = this.anim_state_saved;
    }

    public void resetCounters() {
        this.anim_state = AnimationStates.INITIAL;
        this.anim_state_saved = AnimationStates.INITIAL;

        this.ms_elapsed_since_start = 0;
        this.ms_from_start_saved = 0;

        this.do_restart = false;
    }

    public int getMsElapsedSinceStart() {

        return this.ms_elapsed_since_start;
    }

    public boolean isInitialOrPlaying() {
        return this.anim_state == AnimationStates.INITIAL ||
                this.anim_state == AnimationStates.PLAYING;
    }


    public void requestRestart() {

        this.do_restart = true;

    }

    // this will be invoked several times. Capture the first time the finish occurs.
    public void forceEndAnimation() {
        if (this.anim_state != AnimationStates.FINISHED) {

            this.anim_state_saved = this.anim_state;
            this.ms_from_start_saved = this.ms_elapsed_since_start;
            this.anim_state = AnimationStates.FINISHED;
        }

    }

    @JavascriptInterface
    public int onStartAnimation(String anim_start) {

        this.ms_elapsed_since_start = this.ms_from_start_saved;
        this.anim_state = this.anim_state_saved;
        this.ms_from_start_saved = 0;
        this.anim_state_saved = AnimationStates.INITIAL;



        rnStartAnimation.run();

        if (this.anim_state == AnimationStates.INITIAL) this.anim_state = AnimationStates.PLAYING;

        // when paused, return a negative number.
        if (this.anim_state == AnimationStates.PAUSED) return -this.ms_elapsed_since_start;

        // normal restart.
        return this.ms_elapsed_since_start;
    }

    @JavascriptInterface
    public void onPauseAnimation(String anim_pause, int msSinceStart) {

        this.ms_elapsed_since_start = msSinceStart;
        this.anim_state = AnimationStates.PAUSED;
        rnPauseAnimation.run();

    }

    @JavascriptInterface
    public int onResumeAnimation(String anim_resume) {

        rnResumeAnimation.run();
        this.anim_state = AnimationStates.PLAYING;

        return this.ms_elapsed_since_start;
    }


    @JavascriptInterface
    public void onEndAnimation(String anim_end) {

        if (this.anim_state != AnimationStates.FINISHED) {

            this.anim_state = AnimationStates.FINISHED;
            rnEndAnimation.run();

        }

    }

    @JavascriptInterface
    public int onCheckRestart(String anim_restart, int animation_ms_from_start) {

        if (this.anim_state != AnimationStates.FINISHED) {
              this.ms_elapsed_since_start = animation_ms_from_start;
        }

        if (!this.do_restart) return 0;

        this.anim_state = AnimationStates.PLAYING;
        this.ms_elapsed_since_start = 0;
        this.do_restart = false;

        return 1;
    }

}
