package net.msonic.myapplication.component;

/**
 * Created by manuelzegarra on 11/6/16.
 */


import net.msonic.myapplication.MainActivity;
import net.msonic.myapplication.module.EventBusModule;
import net.msonic.myapplication.module.LogonModule;
import net.msonic.myapplication.module.OAuthModule;
import net.msonic.myapplication.scopes.UserScope;

import dagger.Component;

@UserScope
@Component(dependencies = NetComponent.class, modules={OAuthModule.class,
                                                       EventBusModule.class,
                                                        LogonModule.class})
public interface ToolsComponent {

    void inject(MainActivity activity);
}
