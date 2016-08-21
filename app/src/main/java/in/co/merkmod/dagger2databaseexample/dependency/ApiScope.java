package in.co.merkmod.dagger2databaseexample.dependency;

import javax.inject.Scope;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by rkodekar on 8/22/16.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiScope {
}
