package net.msonic.myapplication.module;

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
    public LogonManager provideLogonManager(Retrofit retrofit) {


        LogonManager logonManager = new LogonManager();
        logonManager.setRetrofit(retrofit);

        return logonManager;
    }


}
