package dxexwxexy.server.Support;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CategoriesDB extends SQLiteOpenHelper {

    private static final String DB_NAME = "categories_data.db";
    private static final String TB_NAME = "categories";
    private static final String CAT = "category";
    private static final String NUM = "";

    public CategoriesDB(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ TB_NAME + " ("+ CAT + " TEXT, " + NUM + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TB_NAME);
        onCreate(db);
    }

    public void increaseSelection(String operation, String result) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CAT, operation);
        contentValues.put(NUM, result);
        db.insert(TB_NAME, null, contentValues);
    }

    public Cursor getCategories() {
        SQLiteDatabase db = getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + TB_NAME, null);
    }

    public void deleteDatabase() {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TB_NAME);
    }
}
