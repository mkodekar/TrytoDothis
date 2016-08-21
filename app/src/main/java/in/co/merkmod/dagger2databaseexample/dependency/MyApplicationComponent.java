package in.co.merkmod.dagger2databaseexample.dependency;

import android.app.Application;
import android.content.SharedPreferences;
import dagger.Component;
import in.co.merkmod.dagger2databaseexample.MainActivity;
import in.co.merkmod.dagger2databaseexample.MyApplication;
import in.co.merkmod.dagger2databaseexample.SplashScreen;
import in.co.merkmod.dagger2databaseexample.utils.SqliteHelper;
import retrofit2.Retrofit;

import javax.inject.Singleton;

/**
 * Created by rkodekar on 8/21/16.
 */

@MyApplicationScope
@Component(modules = {MyApplicationModule.class, SharedPreferenceModule.class, SqliteModule.class}, dependencies = ApiComponent.class)
public interface MyApplicationComponent {
    void inject(SplashScreen splashScreen);
    void inject(MainActivity mainActivity);
    @MyApplicationScope Application application();
    @MyApplicationScope SqliteHelper sqliteHelper();
    @MyApplicationScope SharedPreferences sharedPreferences();
}

