package xyz.waiphyoag.padc_5_pro_wpa_charles_keith.events;

import java.util.List;

import xyz.waiphyoag.padc_5_pro_wpa_charles_keith.data.vo.NewProductVO;

/**
 * Created by WaiPhyoAg on 6/30/18.
 */

public class RestApiEvent {
    public static class onSuccessDataEvent {
        private String loadedPageIndex;
        private List<NewProductVO> productVOList;

        public onSuccessDataEvent(String loadedPageIndex, List<NewProductVO> productVOList) {
            this.loadedPageIndex = loadedPageIndex;
            this.productVOList = productVOList;
        }

        public String getLoadedPageIndex() {
            return loadedPageIndex;
        }

        public List<NewProductVO> getProductVOList() {
            return productVOList;
        }
    }
}
