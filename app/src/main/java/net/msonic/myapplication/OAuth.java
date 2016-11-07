package net.msonic.myapplication;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by manuelzegarra on 11/6/16.
 */

public interface OAuth {

    @FormUrlEncoded
    @POST("oauth/token")
    Call<LogonReponse> logon(@Field("grant_type") String grantType,
                             @Field("username") String userName,
                             @Field("password") String password);

}
