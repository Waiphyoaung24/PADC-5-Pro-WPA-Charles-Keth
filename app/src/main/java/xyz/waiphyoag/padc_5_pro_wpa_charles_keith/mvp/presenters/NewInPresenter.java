package xyz.waiphyoag.padc_5_pro_wpa_charles_keith.mvp.presenters;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import java.util.List;

import xyz.waiphyoag.padc_5_pro_wpa_charles_keith.data.model.ProductsModel;
import xyz.waiphyoag.padc_5_pro_wpa_charles_keith.data.vo.NewProductVO;
import xyz.waiphyoag.padc_5_pro_wpa_charles_keith.delegates.NewInProductDelegate;
import xyz.waiphyoag.padc_5_pro_wpa_charles_keith.mvp.views.NewInView;
import xyz.waiphyoag.padc_5_pro_wpa_charles_keith.persistence.AppDatabase;

/**
 * Created by WaiPhyoAg on 6/30/18.
 */

public class NewInPresenter extends BasePresenter<NewInView> implements NewInProductDelegate {

    private MutableLiveData<List<NewProductVO>> mProductLD;

    @Override
    public void initPresenter(NewInView mView) {
        super.initPresenter(mView);
        mProductLD = new MutableLiveData<>();
        ProductsModel.getmInstance().startLoadingCKProducts(mProductLD, errorMsgLD);

    }

    public LiveData<List<NewProductVO>> getNewProductLD() {
        return mProductLD;
    }


//    @Override
//    public void onTapProduct() {
//        mView.launchNewInDetailScreen();
//
//    }

    @Override
    public void onTapProduct() {
        mView.launchNewInDetailScreen();
    }
}
