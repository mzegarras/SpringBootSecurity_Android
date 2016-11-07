package net.msonic.myapplication.module;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

import net.msonic.myapplication.scopes.UserScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by manuelzegarra on 11/6/16.
 */

@Module
public class EventBusModule {


    @Provides
    @UserScope
    public Bus provideBus() {
        Bus bus = new Bus(ThreadEnforcer.ANY);
        return bus;
    }

}
