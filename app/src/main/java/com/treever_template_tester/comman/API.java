package com.treever_template_tester.comman;

import com.treever_template_tester.model.ModelTimeStamp;
import com.treever_template_tester.model.ServerResponseModel;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Abgaryan on 3/12/18.
 */
public interface API {
//
    @POST("/update-assets-tester/")
    Observable<ServerResponseModel> getAssets(@Body ModelTimeStamp modelTimeStamp);
//
//    @POST("/api/auth/disable-account/")
//    Observable<Object> deleteProfile(@Body PrepaUser user);
//
//    @POST("/api/auth/signup/")
//    Observable<PostUserObject> register(@Body PostUserObject user);
//
//    @POST("/api/auth/facebook/")
//    Observable<KeyObject> loginWithFacebook(@Body PostFaceBookLoginObject access_token);
//
//    @POST("/api/auth/emailconfirmation/")
//    Observable<KeyObject> emailConfirmation(@Body EmailConfirmationObject email_confirmation);
//
//    @POST("/api/auth/signup/verify-email/")
//    Observable<MessageObject> emailVerify(@Body KeyObject key);
//
//    @POST("/api/auth/login/")
//    Observable<KeyObject> login(@Body PostUserObject user);
//
//    @GET("/api/v1/users/user/")
//    Observable<UserObject> getUser();  // ???? Not used??
//
//    @PATCH("/api/auth/user/")
//    Observable<User> updateUser(@Body User user);
//
//    @GET("/api/v1/users/ufouser/")
//    Observable<List<PrepaUser>> getPrepaUser();
//
//    @PATCH("/api/v1/recruiting/qualification/{pk}/")
//    Observable<Job> editJob(@Path("pk") String pk,
//                            @Body Job user);
//
//    @PATCH("/api/v1/recruiting/qualification/{pk}/")
//    Observable<Education> editEducation(@Path("pk") String pk,
//                                        @Body Education user);
//
//    @DELETE("/api/v1/recruiting/qualification/{pk}/")
//    Observable<PrepaUser> deleteEducation(@Path("pk") String pk);
//
//    @PATCH("/api/v1/users/ufouser/{pk}/")
//    Observable<PrepaUser> updateUfoUser(@Path("pk") String pk,
//                                        @Body PrepaUser user);
//
//    @PUT("/api/v1/users/ufouser/{pk}/")
//    Observable<PrepaUser> putPrepaUser(@Path("pk") String pk,
//                                       @Body PrepaUser user);
//
//    @GET("/api/v1/tagging/tag/")
//    Observable<List<Tag>> getTags();
//
//    @GET("/api/v1/geo/city/")
//    Observable<List<City>> getCityList(@Query("search") String query);
//
//    @POST("/api/v1/recruiting/application/")
//    Observable<Video> postApplication(@Body ApplicationPost applicationPost);
//
//    @Multipart
//    @POST("/api/v1/media/video/")
//    Observable<Video> uploadVideo(@Part("profile_video") String alwaysTrue,
//                                  @Part MultipartBody.Part file);
//
//    @GET("/api/v1/recruiting/vacancy/")
//    Observable<Response<List<Vacancy>>> getFilteredJobs(@Query("city") String location,
//                                                        @Query("search") String search,
//                                                        @Query("kind") String kind,
//                                                        @Query("industry") String industries,
//                                                        @Query("limit") int limit,
//                                                        @Query("offset") int offset);
//
//    @POST("/api/v1/messaging/push-notification-setup/")
//    Observable<Push> registerPush(@Body PushSetup pushSetup);
//
//    @GET("/api/v1/messaging/email-setup/")
//    Observable<List<EmailSetup>> getEmailServices();
//
//    @PATCH("/api/v1/messaging/email-setup/{pk}/")
//    Observable<EmailSetup> updateEmailSettings(@Path("pk") String pk,
//                                               @Body EmailSetup emailSetup);
//
//    @PATCH("/api/v1/messaging/contact-message/{pk}/")
//    Observable<ContactMessage> patchIsReadApplication(@Path("pk") String pk,
//                                                      @Body MessageRead body);
//
//    @PATCH("/api/v1/messaging/declination-message/{pk}/")
//    Observable<ContactMessage> patchDeclinedIsReadApplication(@Path("pk") String pk,
//                                                              @Body MessageRead body);
//
//    @GET("/api/v1/media/list-examples/")
//    Observable<List<GetInspiredRecyclerAdapter.GetInspiredHolder>> getInsiprationList(@Query("language") String language);
//
//    @GET("/api/v1/recruiting/vacancy/{pk}/")
//    Observable<Vacancy> getSingleVacancy(@Path("pk") String pk);
}

