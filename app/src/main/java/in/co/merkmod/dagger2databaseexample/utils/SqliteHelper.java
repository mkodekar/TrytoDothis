package in.co.merkmod.dagger2databaseexample.utils;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;
import in.co.merkmod.dagger2databaseexample.dependency.MyApplicationScope;
import in.co.merkmod.dagger2databaseexample.model.Category;
import in.co.merkmod.dagger2databaseexample.model.Item;

import java.util.ArrayList;

/**
 * Created by rkodekar on 8/21/16.
 */
public class SqliteHelper extends SQLiteOpenHelper {


    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "items.db";
    public static final String TABLE_ITEM = "items_table";
    public static final String TABLE_CATEGORY = "category_table";
    public static final String ITEM_ID = "item_id";
    public static final String ITEM_NAME = "item_name";
    public static final String ITEM_RATE  = "item_rate";
    public static final String ITEM_IMAGE = "item_image";
    public static final String MAIN_GROUP_NAME = "main_group_name";
    public static final String MAIN_GROUP_ID = "main_group_id";
    public static final String MAIN_GROUP_SORT = "main_group_sort";
    public static final String MAIN_GROUP_IMAGE = "main_group_image";

    public SqliteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CREATE_CATEGORY_TABLE = " CREATE TABLE " + TABLE_CATEGORY + "("
                + MAIN_GROUP_ID + " TEXT," + MAIN_GROUP_NAME + " TEXT ,"  + MAIN_GROUP_SORT + " TEXT ," + MAIN_GROUP_IMAGE + " TEXT" + ")";
        sqLiteDatabase.execSQL(CREATE_CATEGORY_TABLE);

        String CREATE_ITEM_TABLE = " CREATE TABLE " + TABLE_ITEM + "("
                + ITEM_ID + " TEXT," + ITEM_NAME + " TEXT ,"  + ITEM_RATE + " TEXT ," + ITEM_IMAGE + " TEXT" + ")";
        sqLiteDatabase.execSQL(CREATE_ITEM_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + TABLE_CATEGORY );
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + TABLE_ITEM );
        onCreate(sqLiteDatabase);
    }

    public void insertCategory(ArrayList<Category> categoryArrayList) {
        clearCategory(true);
        //create a sql prepared statement
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "INSERT INTO " + TABLE_CATEGORY + " VALUES (?,?,?,?);";
        //compile the statement and start a transaction
        SQLiteStatement statement = db.compileStatement(sql);
        db.beginTransaction();
        for (int i = 0; i < categoryArrayList.size(); i++) {
            Category category = categoryArrayList.get(i);
            //for a given column index, simply bind the data to be put inside that index
            statement.bindString(1, category.getMainGroupId());
            statement.bindString(2, category.getMainGroupName());
            statement.bindString(3, category.getMainGroupSortNo());
            statement.bindString(4, category.getMainGroupImgPath());
            statement.execute();
        }
        //set the transaction as successful and end the transaction
        Log.d(this.getDatabaseName(), "inserting entries in Items " + categoryArrayList.size());
        db.setTransactionSuccessful();
        db.endTransaction();
        db.close();
    }

    public void insertItems(ArrayList<Item> listItems) {
        clearItems(true);
        //create a sql prepared statement
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "INSERT INTO " + TABLE_ITEM + " VALUES (?,?,?,?);";
        //compile the statement and start a transaction
        SQLiteStatement statement = db.compileStatement(sql);
        db.beginTransaction();
        for (int i = 0; i < listItems.size(); i++) {
            Item items = listItems.get(i);
            statement.bindString(1, items.getItemId());
            statement.bindString(2, items.getItemName());
            statement.bindString(3, items.getItemActRate());
            statement.bindString(4, items.getItemImgPath());
            statement.execute();
        }
        //set the transaction as successful and end the transaction
        Log.d(this.getDatabaseName(), "inserting entries in Items " + listItems.size());
        db.setTransactionSuccessful();
        db.endTransaction();
        db.close();
    }

    public ArrayList<Category> getAllCategories() {
        ArrayList<Category> categoryArrayList  = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_CATEGORY;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        while(cursor.moveToNext()) {
            int index  = cursor.getColumnIndex(MAIN_GROUP_ID);
            int index2 = cursor.getColumnIndex(MAIN_GROUP_NAME);
            int index3 = cursor.getColumnIndex(MAIN_GROUP_SORT);
            int index4 = cursor.getColumnIndex(MAIN_GROUP_IMAGE);
            String maingroup_id = cursor.getString(index);
            String maingourp_name = cursor.getString(index2);
            String maingroup_sort = cursor.getString(index3);
            String maingroup_image = cursor.getString(index4);
            Category category =  new Category();
            category.setMainGroupId(maingroup_id);
            category.setMainGroupName(maingourp_name);
            category.setMainGroupSortNo(maingroup_sort);
            category.setMainGroupImgPath(maingroup_image);
            categoryArrayList.add(category);
            db.close();
        }
        return categoryArrayList;
    }

    public void clearCategory(boolean clear) {
        if (clear) {
            SQLiteDatabase db = this.getWritableDatabase();
            db.delete(TABLE_CATEGORY, null, null);
            Log.d(SqliteHelper.class.getSimpleName(), "Deleted all category info from sqlite");
        }

    }

    public void clearItems(boolean clear) {
        if (clear) {
            SQLiteDatabase db = this.getWritableDatabase();
            db.delete(TABLE_ITEM, null, null);
            Log.d(SqliteHelper.class.getSimpleName(), "Deleted all items info from sqlite");
        }

    }
}
