package xyz.waiphyoag.padc_5_pro_wpa_charles_keith.persistence.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import xyz.waiphyoag.padc_5_pro_wpa_charles_keith.data.vo.NewProductVO;

/**
 * Created by WaiPhyoAg on 6/30/18.
 */
@Dao
public interface ProductDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertProducts(List<NewProductVO> newProductVOList);

    @Query("SELECT * From products")
    List<NewProductVO> getAllProduct();

    @Query("SELECT * FROM products Where productId=:productId")
    List<NewProductVO> getProductById(String productId);

    @Query("SELECT * From products")
    LiveData<List<NewProductVO>> getAllLiveData();

    @Query("SELECT * FROM products Where productId=:productId")
    LiveData<List<NewProductVO>> getLiveDataProductById(String productId);


}
