package net.msonic.myapplication.component;

import android.content.SharedPreferences;

import net.msonic.myapplication.module.AppModule;
import net.msonic.myapplication.module.NetModule;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by manuelzegarra on 11/6/16.
 */

@Singleton
@Component(modules={AppModule.class, NetModule.class})
public interface NetComponent {
    // downstream components need these exposed
    Retrofit retrofit();
    OkHttpClient okHttpClient();
    SharedPreferences sharedPreferences();
}