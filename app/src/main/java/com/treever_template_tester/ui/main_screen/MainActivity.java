package com.treever_template_tester.ui.main_screen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.ViewFlipper;

import com.treever_template_tester.R;
import com.treever_template_tester.TreeverTesterApplication;
import com.treever_template_tester.comman.DialogHelper;
import com.treever_template_tester.model.ModelTemplate;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainContract.View {




    @BindView(R.id.navigation)
    public BottomNavigationView navigation ;

    @BindView(R.id.view_flipper)
    public ViewFlipper mViewFlipper;

    @BindView(R.id.to_be_tested_recyclerView)
    public RecyclerView mToBeTestedRecyclerView;


    @BindView(R.id.reviewed_recyclerView)
    public RecyclerView mReviewedRecyclerView;

    @BindView(R.id.progressBar)
    public ProgressBar mProgressBar;


    @Inject
    MainPresenter mMainPresenter;

    @Inject
    TemplateAdapter mTemplateAdapterToBeTested;

    @Inject
    TemplateAdapter mTemplateAdapterReviewed;

    private DialogHelper mDialogHelper = new DialogHelper();






    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_to_be_tested:
                    if (mViewFlipper.getDisplayedChild() == 0) return  true;
                    mViewFlipper.setDisplayedChild(0);
                    return true;
                case R.id.navigation_reviewed:
                    if (mViewFlipper.getDisplayedChild() == 1) return  true;
                    mViewFlipper.setDisplayedChild(1);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        ((TreeverTesterApplication) getApplication()).getAppComponent() .inject(this);

        initAdapters();

        mMainPresenter.attachView(this);


        mMainPresenter.loadTemplateModels();




    }

    /*
    * inits adapters for  mToBeTestedRecyclerView ,mReviewedRecyclerView
    * */
    private void initAdapters(){
        mToBeTestedRecyclerView.setAdapter(mTemplateAdapterToBeTested);
        mToBeTestedRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mReviewedRecyclerView.setAdapter(mTemplateAdapterReviewed);
        mReviewedRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMainPresenter.detachView();
    }


/***** Main View methods implementation *****/

    @Override
    public void showProgress() {
        if( !mProgressBar.isShown()) mProgressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgress() {
        if( mProgressBar.isShown()) mProgressBar.setVisibility(View.GONE);

    }

    @Override
    public void showError() {
        mDialogHelper.showErrorPopup(MainActivity.this,getResources().getString(R.string.dialog_message_error));

    }



    @Override
    public void loadToBeTested(List<ModelTemplate> templates) {
        mTemplateAdapterToBeTested.setModelTemplates(templates);
        mTemplateAdapterToBeTested.notifyDataSetChanged();

    }

    @Override
    public void loadToReviewed(List<ModelTemplate> templates) {
        mTemplateAdapterReviewed.setModelTemplates(templates);
        mTemplateAdapterReviewed.notifyDataSetChanged();
    }

    @Override
    public void navigateToBeTested() {

    }

    @Override
    public void navigateToReViewed() {


    }

    public static Intent getStartIntent(Context targetContext) {
        return new Intent(targetContext,MainActivity.class);
    }
}
