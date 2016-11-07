package net.msonic.myapplication.module;

import net.msonic.myapplication.OAuth;
import net.msonic.myapplication.scopes.UserScope;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by manuelzegarra on 11/6/16.
 */

@Module
public class OAuthModule {

    @Provides
    @UserScope
    public OAuth providesOAuthInterface(Retrofit retrofit) {

        return retrofit.create(OAuth.class);
    }

}
