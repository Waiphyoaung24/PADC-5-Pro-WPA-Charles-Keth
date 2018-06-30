package xyz.waiphyoag.padc_5_pro_wpa_charles_keith.network.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import xyz.waiphyoag.padc_5_pro_wpa_charles_keith.data.vo.NewProductVO;

/**
 * Created by WaiPhyoAg on 6/29/18.
 */

public class GetProductResponse {

    @SerializedName("code")
    @Expose
    private int code;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("apiVersion")
    @Expose
    private String apiVersion;

    @SerializedName("page")
    @Expose
    private String page;

    @SerializedName("newProducts")
    @Expose
    private List<NewProductVO> newProductVOList;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getPage() {
        return page;
    }

    public List<NewProductVO> getNewProductVOList() {
        return newProductVOList;
    }
}
