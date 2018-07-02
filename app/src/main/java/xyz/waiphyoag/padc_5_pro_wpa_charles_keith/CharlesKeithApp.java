package xyz.waiphyoag.padc_5_pro_wpa_charles_keith;

import android.app.Application;

import xyz.waiphyoag.padc_5_pro_wpa_charles_keith.data.model.ProductsModel;

/**
 * Created by WaiPhyoAg on 6/30/18.
 */

public class CharlesKeithApp extends Application {
    public static final String ACCESS_TOKEN = "b002c7e1a528b7cb460933fc2875e916";
    public static final String BASE_URL = "http://padcmyanmar.com/padc-5/ck/";
    public static final String LOG_TAG = "CharlesKeithApp";
    @Override
    public void onCreate() {
        super.onCreate();

    }
}
