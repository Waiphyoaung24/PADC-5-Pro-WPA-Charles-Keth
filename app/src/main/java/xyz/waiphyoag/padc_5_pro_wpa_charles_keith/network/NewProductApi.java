package xyz.waiphyoag.padc_5_pro_wpa_charles_keith.network;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import xyz.waiphyoag.padc_5_pro_wpa_charles_keith.network.responses.GetProductResponse;

/**
 * Created by WaiPhyoAg on 6/29/18.
 */

public interface NewProductApi {
    @FormUrlEncoded
    @POST("getNewProducts.php")
    Observable<GetProductResponse> loadProduct(
            @Field("page") String page,
            @Field("access_token") String accessToken);


}
