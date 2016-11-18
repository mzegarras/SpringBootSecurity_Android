package net.msonic.myapplication.ws;



import net.msonic.myapplication.LogonReponse;
import net.msonic.myapplication.LogonRequest;
import net.msonic.myapplication.OAuth;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by manuelzegarra on 11/6/16.
 */

public class LogonManager {

    private Retrofit retrofit;


    public void logon(String userName,String password){

        //OAuth oAuth = retrofit.create(OAuth.class);

        //Call<LogonReponse> call = oAuth.logon("password",userName,password);

        //asynchronous call
        //call.enqueue(MainActivity.this);

        LogonRequest logonRequest = new LogonRequest();
        logonRequest.setUserName(userName);
        logonRequest.setPassword(password);


        onLoadAuthenticateEvent(logonRequest);

        }


    public void onLoadAuthenticateEvent(LogonRequest logonRequest) {

        String userName = logonRequest.getUserName();
        String password = logonRequest.getPassword();

        OAuth oAuth = retrofit.create(OAuth.class);

        Callback<LogonReponse> callback = new Callback<LogonReponse>() {

            @Override
            public void onResponse(Call<LogonReponse> call, Response<LogonReponse> response) {
                //bus.post(response);
            }

            @Override
            public void onFailure(Call<LogonReponse> call, Throwable t) {
                //bus.post(null);
            }
        };

        Call<LogonReponse> call = oAuth.logon("password",userName,password);

        call.enqueue(callback);

    }
    public Retrofit getRetrofit() {
        return retrofit;
    }

    public void setRetrofit(Retrofit retrofit) {
        this.retrofit = retrofit;
    }


}
