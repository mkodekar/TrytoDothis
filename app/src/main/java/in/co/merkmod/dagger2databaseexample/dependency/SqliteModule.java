package in.co.merkmod.dagger2databaseexample.dependency;

import android.app.Application;
import dagger.Module;
import dagger.Provides;
import in.co.merkmod.dagger2databaseexample.MyApplication;
import in.co.merkmod.dagger2databaseexample.utils.SqliteHelper;

/**
 * Created by rkodekar on 8/21/16.
 */

@Module
public class SqliteModule {

    @Provides @MyApplicationScope
    SqliteHelper provideSqlite(MyApplication application) {
        return new SqliteHelper(application.getApplicationContext());
    }
}
