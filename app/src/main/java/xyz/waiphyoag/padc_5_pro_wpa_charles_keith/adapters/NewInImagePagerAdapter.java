package xyz.waiphyoag.padc_5_pro_wpa_charles_keith.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import xyz.waiphyoag.padc_5_pro_wpa_charles_keith.R;
import xyz.waiphyoag.padc_5_pro_wpa_charles_keith.data.vo.NewProductVO;
import xyz.waiphyoag.padc_5_pro_wpa_charles_keith.viewholders.NewInProductDetailViewHolder;

/**
 * Created by WaiPhyoAg on 6/30/18.
 */

public class NewInImagePagerAdapter extends PagerAdapter {
    private LayoutInflater mLayoutInflater;
    private List<NewProductVO>mProducts;

    public NewInImagePagerAdapter(Context context) {
        super();
        mLayoutInflater = LayoutInflater.from(context);
        this.mProducts=new ArrayList<>();
    }

    @Override
    public int getCount() {
        return mProducts.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (View) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        NewInProductDetailViewHolder view = (NewInProductDetailViewHolder) mLayoutInflater.inflate(R.layout.item_new_in_detail_product, container, false);
        view.setData(mProducts.get(position));
        container.addView(view);
        return view;
    }
    public void setmProducts(List<NewProductVO> mProducts) {
        this.mProducts = mProducts;
        notifyDataSetChanged();
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
