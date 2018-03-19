package com.treever_template_tester;

import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.treever_template_tester.comman.API;
import com.treever_template_tester.comman.Constants;
import com.treever_template_tester.model.ModelTimeStamp;
import com.treever_template_tester.model.ServerResponseModel;

import org.junit.Before;
import org.junit.Test;

import common.TestDataFactory;
import io.reactivex.observers.TestObserver;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Abgaryan on 3/19/18.
 */

public class APITest {


    API mApi;

    ServerResponseModel mServerResponseModel;
    ModelTimeStamp mRequestModel;
    MockWebServer mMockWebServer;
    TestObserver<ServerResponseModel> mSubscriber;


    @Before
    public void setUp() {
        ModelTimeStamp mRequestModel = new ModelTimeStamp();
        mRequestModel.setLast_request(0);
        mServerResponseModel = TestDataFactory.makeSereverResponesModel();


        mMockWebServer = new MockWebServer();
        mSubscriber = new TestObserver<ServerResponseModel>();
    }


    @Test
    public void serverCallWithError() {
        //Given
        String url = "dfdf/";
        mMockWebServer.enqueue(new MockResponse().setBody(new Gson().toJson(mServerResponseModel)));
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(mMockWebServer.url(url))
                .build();

        mApi = retrofit.create(API.class);
        //When
        mApi.getAssets(mRequestModel).subscribeWith(mSubscriber);

        //Then
        mSubscriber.assertNoErrors();
        mSubscriber.assertComplete();
    }

    @Test
    public void severCallWithSuccessful() {
        //Given
        String url = Constants.BASE_URL;
        mMockWebServer.enqueue(new MockResponse().setBody(new Gson().toJson(mServerResponseModel)));
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(mMockWebServer.url(url))
                .build();
        mApi = retrofit.create(API.class);

        //When
        mApi.getAssets(mRequestModel).subscribeWith(mSubscriber);


        //Then
        mSubscriber.assertNoErrors();
        mSubscriber.assertComplete();
    }

}
