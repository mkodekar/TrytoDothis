package in.co.merkmod.dagger2databaseexample.presenter;

import in.co.merkmod.dagger2databaseexample.model.Category;
import rx.Observable;

import java.util.ArrayList;

/**
 * Created by rkodekar on 8/22/16.
 */
public interface SplashScreenInterface  {

    void onCompleted();
    void onError(String message);
    void onFetched(ArrayList<Category> examples);
    Observable<ArrayList<Category>> getCategory();
}
