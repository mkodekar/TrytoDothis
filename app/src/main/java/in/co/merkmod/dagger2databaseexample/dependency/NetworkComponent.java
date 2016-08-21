package in.co.merkmod.dagger2databaseexample.dependency;

import dagger.Component;
import retrofit2.Retrofit;

import javax.inject.Singleton;

/**
 * Created by rkodekar on 8/22/16.
 */

@Singleton
@Component(modules = NetworkModule.class)
public interface NetworkComponent {
    Retrofit retrofit();
}
