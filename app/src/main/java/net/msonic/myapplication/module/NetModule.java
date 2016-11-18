package net.msonic.myapplication.module;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Base64;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by manuelzegarra on 11/6/16.
 */

@Module
public class NetModule {

    private String baseUrl;

    public NetModule(String baseUrl) {
        this.baseUrl = baseUrl;
    }


    // Dagger will only look for methods annotated with @Provides
    @Provides
    @Singleton
    SharedPreferences providesSharedPreferences(Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }


    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {

        Interceptor interceptorHeader = new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request original = chain.request();

                String str = "foo:foosecret";
                String   base64EncodedUsernamePassword = Base64.encodeToString(str.getBytes("UTF-8"), Base64.NO_WRAP);


                // Request customization: add request headers
                Request.Builder requestBuilder = original.newBuilder()
                        .header("Authorization", String.format("Basic %s",base64EncodedUsernamePassword)); // <-- this is the important line

                Request request = requestBuilder.build();
                return chain.proceed(request);

            }
        };

        HttpLoggingInterceptor interceptorLogging = new HttpLoggingInterceptor();
        interceptorLogging.setLevel(HttpLoggingInterceptor.Level.BODY);


        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptorHeader)
                .addInterceptor(interceptorLogging)
                .build();

        return client;
    }

    // Dagger will only look for methods annotated with @Provides
    @Provides
    @Singleton
    ObjectMapper provideMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper;
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(ObjectMapper mapper, OkHttpClient okHttpClient) {

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(JacksonConverterFactory.create(mapper))
                .baseUrl(this.baseUrl)
                .client(okHttpClient)
                .build();
        return retrofit;
    }




}



