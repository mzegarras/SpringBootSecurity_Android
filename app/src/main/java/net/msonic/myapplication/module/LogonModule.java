package net.msonic.myapplication.module;

import com.squareup.otto.Bus;

import net.msonic.myapplication.scopes.UserScope;
import net.msonic.myapplication.ws.LogonManager;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by manuelzegarra on 11/6/16.
 */


@Module
public class LogonModule {


    @Provides
    @UserScope
    public LogonManager provideLogonManager(Retrofit retrofit, Bus bus) {


        LogonManager logonManager = new LogonManager();
        logonManager.setRetrofit(retrofit);
        logonManager.setBus(bus);

        return logonManager;
    }


}
