package in.co.merkmod.dagger2databaseexample.dependency;

import android.app.Application;
import android.content.SharedPreferences;
import dagger.Module;
import dagger.Provides;
import in.co.merkmod.dagger2databaseexample.MyApplication;
import in.co.merkmod.dagger2databaseexample.config.AppConfig;

/**
 * Created by rkodekar on 8/21/16.
 */

@Module
public class SharedPreferenceModule {

    @Provides @MyApplicationScope
    SharedPreferences provideSharePreference(MyApplication application) {
        return application.getSharedPreferences(AppConfig.APP_SHARE_PREF, 0);
    }
}
