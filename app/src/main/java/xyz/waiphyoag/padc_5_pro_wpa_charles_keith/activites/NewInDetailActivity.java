package xyz.waiphyoag.padc_5_pro_wpa_charles_keith.activites;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.waiphyoag.padc_5_pro_wpa_charles_keith.R;
import xyz.waiphyoag.padc_5_pro_wpa_charles_keith.adapters.NewInImagePagerAdapter;
import xyz.waiphyoag.padc_5_pro_wpa_charles_keith.adapters.NewInProductAdapter;
import xyz.waiphyoag.padc_5_pro_wpa_charles_keith.data.vo.NewProductVO;
import xyz.waiphyoag.padc_5_pro_wpa_charles_keith.mvp.presenters.NewInDetailPresenter;
import xyz.waiphyoag.padc_5_pro_wpa_charles_keith.mvp.views.NewInDetailView;
import xyz.waiphyoag.padc_5_pro_wpa_charles_keith.persistence.AppDatabase;

/**
 * Created by WaiPhyoAg on 6/30/18.
 */

public class NewInDetailActivity extends BaseActivity implements NewInDetailView {

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, NewInDetailActivity.class);
        return intent;
    }

    private NewInImagePagerAdapter mAdapter;
    @BindView(R.id.vp_new_in_detail)
    ViewPager vpNewInDetail;

    private NewInDetailPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_in_detail);
        ButterKnife.bind(this, this);

        mAdapter = new NewInImagePagerAdapter(getApplicationContext());
        vpNewInDetail.setAdapter(mAdapter);

        mPresenter = ViewModelProviders.of(this).get(NewInDetailPresenter.class);
        mPresenter.initPresenter(this);

        mPresenter.getProductDetail().observe(this, new Observer<List<NewProductVO>>() {
            @Override
            public void onChanged(@Nullable List<NewProductVO> newProductVOS) {
                displayProductDetail(newProductVOS);
            }
        });
    }

    public void displayProductDetail(List<NewProductVO> newProductVOS) {
        mAdapter.setmProducts(newProductVOS);

    }

    //


}
