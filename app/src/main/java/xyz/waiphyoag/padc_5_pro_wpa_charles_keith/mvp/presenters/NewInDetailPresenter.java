package xyz.waiphyoag.padc_5_pro_wpa_charles_keith.mvp.presenters;

import android.arch.lifecycle.LiveData;

import java.util.List;

import xyz.waiphyoag.padc_5_pro_wpa_charles_keith.data.model.ProductsModel;
import xyz.waiphyoag.padc_5_pro_wpa_charles_keith.data.vo.NewProductVO;
import xyz.waiphyoag.padc_5_pro_wpa_charles_keith.mvp.views.NewInDetailView;

/**
 * Created by WaiPhyoAg on 6/30/18.
 */

public class NewInDetailPresenter extends BasePresenter<NewInDetailView> {
    @Override
    public void initPresenter(NewInDetailView mView) {
        super.initPresenter(mView);
    }

    public LiveData<List<NewProductVO>> getProductLDById(String id) {
        return ProductsModel.getmInstance().getProductLiveDataById(id);
    }

    public LiveData<List<NewProductVO>> getProductDetail() {
        return ProductsModel.getmInstance().getAllProductLiveData();
    }
}
