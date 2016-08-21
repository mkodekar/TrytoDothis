package in.co.merkmod.dagger2databaseexample.service;

import in.co.merkmod.dagger2databaseexample.model.Category;
import in.co.merkmod.dagger2databaseexample.model.Item;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

import java.util.ArrayList;

/**
 * Created by rkodekar on 8/22/16.
 */


public interface ApiService {

    @GET("/maincategory.php")
    Observable<ArrayList<Category>> getCategory();

    @POST("/itemMaster.php")
    Observable<ArrayList<Item>> getItems (@Path("MainGroup_Id") String maingroup_id);

}
