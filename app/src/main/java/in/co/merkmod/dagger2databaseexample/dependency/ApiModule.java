package in.co.merkmod.dagger2databaseexample.dependency;

import dagger.Module;
import dagger.Provides;
import in.co.merkmod.dagger2databaseexample.service.ApiService;
import retrofit2.Retrofit;

/**
 * Created by rkodekar on 8/22/16.
 */
@Module
public class ApiModule {

    @Provides @ApiScope
    ApiService provideApiService(Retrofit retrofit){
        return retrofit.create(ApiService.class);
    }

}
