package in.co.merkmod.dagger2databaseexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import in.co.merkmod.dagger2databaseexample.model.Category;
import in.co.merkmod.dagger2databaseexample.presenter.SplashScreenInterface;
import in.co.merkmod.dagger2databaseexample.presenter.SplashScreenPresenter;
import in.co.merkmod.dagger2databaseexample.service.ApiService;
import in.co.merkmod.dagger2databaseexample.utils.SqliteHelper;
import rx.Observable;

import javax.inject.Inject;
import java.util.ArrayList;

/**
 * Created by rkodekar on 8/22/16.
 */
public class SplashScreen extends AppCompatActivity implements SplashScreenInterface{

    @Inject
    ApiService apiService;

    @Inject
    SqliteHelper sqliteHelper;

    private SplashScreenPresenter splashScreenPresenter;

    @BindView(R.id.mainContent)
    CoordinatorLayout maiLayout;

    @BindView(R.id.errorMessgae)
    TextView errotextView;

    @BindView(R.id.button)
    AppCompatButton button;

    @OnClick(R.id.button)
    void onClick(AppCompatButton button) {
        this.finish();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);
        ButterKnife.bind(this);
        MyApplication.getMyApplicationComponent(this).inject(this);
        splashScreenPresenter  = new SplashScreenPresenter(this);
        maiLayout.setStatusBarBackgroundResource(R.drawable.launch_screen);
        splashScreenPresenter.fetchCategories();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        splashScreenPresenter.onDestroy();
    }

    @Override
    public void onBackPressed() {
    }

    @Override
    public void onCompleted() {
        Intent intent = new Intent(SplashScreen.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onError(String message) {
        maiLayout.setStatusBarBackgroundResource(R.color.colorPrimary);
        errotextView.setVisibility(View.VISIBLE);
        errotextView.setText(message);
    }

    @Override
    public void onFetched(ArrayList<Category> examples) {
        sqliteHelper.insertCategory(examples);

    }

    @Override
    public Observable<ArrayList<Category>> getCategory() {
        return apiService.getCategory();
    }
}
