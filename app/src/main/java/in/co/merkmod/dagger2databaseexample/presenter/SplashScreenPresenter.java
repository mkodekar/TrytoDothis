package in.co.merkmod.dagger2databaseexample.presenter;

import in.co.merkmod.dagger2databaseexample.model.Category;
import rx.Observable;
import rx.Observer;

import java.util.ArrayList;

/**
 * Created by rkodekar on 8/22/16.
 */
public class SplashScreenPresenter extends BasePresenter implements Observer<ArrayList<Category>> {

    private  SplashScreenInterface splashScreenInterface;

    public SplashScreenPresenter(SplashScreenInterface splashScreenInterface) {
        this.splashScreenInterface = splashScreenInterface;
    }

    @Override
    public void onCompleted() {
        splashScreenInterface.onCompleted();
    }

    @Override
    public void onError(Throwable e) {

        splashScreenInterface.onError(e.getMessage());
    }

    @Override
    public void onNext(ArrayList<Category> categoryArrayList) {
        splashScreenInterface.onFetched(categoryArrayList);
    }

    public void fetchCategories() {
        unSubscribeAll();
        subscribe(splashScreenInterface.getCategory(), SplashScreenPresenter.this);
    }
}
