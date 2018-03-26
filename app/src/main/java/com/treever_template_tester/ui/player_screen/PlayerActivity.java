package com.treever_template_tester.ui.player_screen;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.treever_template_tester.R;

public class PlayerActivity extends AppCompatActivity implements PlayerContract.View {



    private Runnable startAnimation = new Runnable() {
        @Override
        public void run() {



//            int ms_since_start = jsInterface.getMsElapsedSinceStart();
//            is_animation_finished = false;
//
//            //end_animation_already_invoked = false;
//
//            if (ms_since_start < DELAY_IS_ALREADY_PLAYING) {
//                startTimer = new Timer("please_wait_timer");
//                startTimer.schedule(new TimerTask() {
//                    @Override
//                    public void run() {
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                if (viewFlipperPlayer.getDisplayedChild() != 0) {
//                                    viewFlipperPlayer.setDisplayedChild(0);
//                                }
//
//                                int template_id = 0;
//                                if (playerTreeveModel.getIs_cloud_treeve() == 1) {
//                                    template_id = playerTreeveModel.getCloud_treeve_template_id();
//                                } else {
//                                    template_id = playerTreeveModel.getCurrentTemplateModel().getTemplate_cloud_id();
//                                }
//
////                                Snackbar.make(actv.getCurrentFocus(), "Playing Template cloud id : " + String.valueOf(template_id), Snackbar.LENGTH_LONG).show();
//                            }
//                        });
//                    }
//                }, DELAY_TO_OPEN_CURTAIN);  // after delay, no repetition
//
//            }


        }
    };
    private Runnable pauseAnimation = new Runnable() {

        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
//                    end_treeve_btn.setVisibility(View.VISIBLE);
//                    end_treeve_btn.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
////                            FlurryAgent.logEvent("Button.Player.EndTreeve.TemplateTester");
//                            onBackPressed();
//
//                        }
//                    });
                }
            });

        }
    };
    private Runnable resumeAnimation = new Runnable() {
        @Override
        public void run() {

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
//                    end_treeve_btn.setVisibility(View.GONE);

                }
            });

        }
    };
    private ProgressDialog progress;
    private Runnable endAnimation = new Runnable() {
        @Override
        public void run() {


//            is_animation_finished = true;
//            runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            end_treeve_btn.setVisibility(View.VISIBLE);
//                            end_treeve_btn.setOnClickListener(new View.OnClickListener() {
//                                @Override
//                                public void onClick(View view) {
//                                    onBackPressed();
//
//                                }
//                            });
//                        }
//                    });
//
//
//                }
//            });


        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError() {

    }
}
