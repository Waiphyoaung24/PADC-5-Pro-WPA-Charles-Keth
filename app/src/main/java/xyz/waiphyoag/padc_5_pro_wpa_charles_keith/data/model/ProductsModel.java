package xyz.waiphyoag.padc_5_pro_wpa_charles_keith.data.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import xyz.waiphyoag.padc_5_pro_wpa_charles_keith.CharlesKeithApp;
import xyz.waiphyoag.padc_5_pro_wpa_charles_keith.data.vo.NewProductVO;
import xyz.waiphyoag.padc_5_pro_wpa_charles_keith.events.RestApiEvent;
import xyz.waiphyoag.padc_5_pro_wpa_charles_keith.network.responses.GetProductResponse;

/**
 * Created by WaiPhyoAg on 6/29/18.
 */

public class ProductsModel extends BaseModel {
    private static ProductsModel mInstance;
    private String pageIndex = "1";

    protected ProductsModel(Context context) {
        super(context);
    }


    public static ProductsModel getmInstance() {
        if (mInstance != null) {
            return mInstance;
        }
        throw new RuntimeException("asdf");

    }

    public static void initProductModel(Context context) {

        mInstance = new ProductsModel(context);
    }

    public void startLoadingCKProducts(final MutableLiveData<List<NewProductVO>> mProductLD, final MutableLiveData<String> mErrorMsgLD) {
        Observable<GetProductResponse> getProductResponseObservable = theApi.loadProduct(pageIndex, CharlesKeithApp.ACCESS_TOKEN);
        getProductResponseObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetProductResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetProductResponse getProductResponse) {
                        if (getProductResponse != null && getProductResponse.getNewProductVOList().size() > 0) {
                            mProductLD.setValue(getProductResponse.getNewProductVOList());
                            addNewProductsToDB(getProductResponse.getNewProductVOList());


                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        mErrorMsgLD.setValue(e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void addNewProductsToDB(List<NewProductVO> productsVOS) {
        mDatabase.productDAO().insertProducts(productsVOS);
    }

    public List<NewProductVO> getProductById(String productId) {
        return mDatabase.productDAO().getProductById(productId);
    }

    public LiveData<List<NewProductVO>> getAllProductLiveData() {
        return mDatabase.productDAO().getAllLiveData();
    }

    public LiveData<List<NewProductVO>> getProductLiveDataById(String id) {
        return mDatabase.productDAO().getLiveDataProductById(id);
    }

    public List<NewProductVO> getAllProduct() {
        return mDatabase.productDAO().getAllProduct();
    }


}
