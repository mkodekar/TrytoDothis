package in.co.merkmod.dagger2databaseexample.dependency;

import android.app.Application;
import dagger.Module;
import dagger.Provides;
import in.co.merkmod.dagger2databaseexample.MyApplication;

import javax.inject.Singleton;

/**
 * Created by rkodekar on 8/21/16.
 */
@Module
public class MyApplicationModule {

    private MyApplication myApplication;

    public MyApplicationModule(MyApplication application) {
        myApplication  = application;
    }

    @Provides @MyApplicationScope
    MyApplication provideMyappContext() {
        return myApplication;
    }

    @Provides @MyApplicationScope Application provideApplication(MyApplication application) {
        return application;
    }

}
