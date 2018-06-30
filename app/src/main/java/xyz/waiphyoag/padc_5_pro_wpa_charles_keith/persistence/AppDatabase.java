package xyz.waiphyoag.padc_5_pro_wpa_charles_keith.persistence;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import xyz.waiphyoag.padc_5_pro_wpa_charles_keith.data.vo.NewProductVO;
import xyz.waiphyoag.padc_5_pro_wpa_charles_keith.persistence.dao.ProductDAO;

/**
 * Created by WaiPhyoAg on 6/30/18.
 */

@Database(entities = {NewProductVO.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase objInstance;
    private static String DB_NAME = "Product_DB";

    public abstract ProductDAO productDAO();

    public static AppDatabase getObjInstance(Context context) {
        if (objInstance == null) {
            objInstance = Room.databaseBuilder(context, AppDatabase.class, DB_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return objInstance;
    }
}
