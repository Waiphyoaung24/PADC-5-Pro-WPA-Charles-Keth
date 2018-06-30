package xyz.waiphyoag.padc_5_pro_wpa_charles_keith.mvp.presenters;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import xyz.waiphyoag.padc_5_pro_wpa_charles_keith.mvp.views.BaseView;

/**
 * Created by WaiPhyoAg on 6/30/18.
 */

public abstract class BasePresenter<T extends BaseView> extends ViewModel {
    protected T mView;
    protected MutableLiveData<String> errorMsgLD;

    public void initPresenter(T mView) {
        this.mView = mView;
        errorMsgLD = new MutableLiveData<>();
    }

    public LiveData<String> getErrorLD() {
        return errorMsgLD;
    }
}
