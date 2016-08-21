package in.co.merkmod.dagger2databaseexample.dependency;

import dagger.Component;
import in.co.merkmod.dagger2databaseexample.service.ApiService;

/**
 * Created by rkodekar on 8/22/16.
 */

@ApiScope
@Component(modules = ApiModule.class, dependencies = NetworkComponent.class)
public interface ApiComponent {
    ApiService apiService();
}
