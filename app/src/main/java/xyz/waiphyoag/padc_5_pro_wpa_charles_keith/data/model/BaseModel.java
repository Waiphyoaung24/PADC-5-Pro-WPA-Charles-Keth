package xyz.waiphyoag.padc_5_pro_wpa_charles_keith.data.model;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import xyz.waiphyoag.padc_5_pro_wpa_charles_keith.network.NewProductApi;
import xyz.waiphyoag.padc_5_pro_wpa_charles_keith.persistence.AppDatabase;

/**
 * Created by WaiPhyoAg on 6/29/18.
 */

public abstract class BaseModel {
    protected NewProductApi theApi;
    protected AppDatabase mDatabase;

    protected BaseModel(Context context) {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://padcmyanmar.com/padc-5/ck/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();

        theApi = retrofit.create(NewProductApi.class);
        mDatabase = AppDatabase.getObjInstance(context);

    }
}
