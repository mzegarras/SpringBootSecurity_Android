package net.msonic.myapplication;

import android.app.Application;


import net.msonic.myapplication.component.DaggerNetComponent;
import net.msonic.myapplication.component.DaggerToolsComponent;
import net.msonic.myapplication.component.ToolsComponent;
import net.msonic.myapplication.component.NetComponent;
import net.msonic.myapplication.module.AppModule;
import net.msonic.myapplication.module.NetModule;

/**
 * Created by manuelzegarra on 11/6/16.
 */

public class CustomApplication extends Application {


    private NetComponent netComponent;
    private ToolsComponent gitHubComponent;


    @Override
    public void onCreate() {
        super.onCreate();

        netComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("http://192.168.0.14:9000/hascode/"))
                .build();

        gitHubComponent = DaggerToolsComponent.builder()
                .netComponent(netComponent)
                .build();



    }


    public NetComponent getNetComponent() {
        return netComponent;
    }

    public ToolsComponent getGitHubComponent() {
        return gitHubComponent;
    }




}
