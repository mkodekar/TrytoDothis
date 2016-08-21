package in.co.merkmod.dagger2databaseexample;

import android.app.Application;
import android.content.Context;
import in.co.merkmod.dagger2databaseexample.config.AppConfig;
import in.co.merkmod.dagger2databaseexample.dependency.*;

/**
 * Created by rkodekar on 8/21/16.
 */
public class MyApplication extends Application {

    private MyApplicationComponent myApplicationComponent;

    @Override
    public void onCreate() {
        resolveDependency();
        super.onCreate();
    }

    public void resolveDependency() {
        myApplicationComponent  = DaggerMyApplicationComponent.builder()
                .myApplicationModule(new MyApplicationModule(this))
                .sqliteModule(new SqliteModule())
                .apiComponent(getApiComponent())
                .sharedPreferenceModule(new SharedPreferenceModule())
                .build();
    }

    public ApiComponent getApiComponent() {
        return DaggerApiComponent.builder().networkComponent(networkComponent()).build();
    }
    public NetworkComponent networkComponent() {
        return DaggerNetworkComponent.builder().networkModule(new NetworkModule(AppConfig.BASE_URL)).build();
    }

    public static MyApplicationComponent getMyApplicationComponent(Context context) {
        return ((MyApplication)context.getApplicationContext()).myApplicationComponent;
    }
}
