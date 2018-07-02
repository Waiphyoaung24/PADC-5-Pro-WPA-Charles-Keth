package xyz.waiphyoag.padc_5_pro_wpa_charles_keith.activites;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import xyz.waiphyoag.padc_5_pro_wpa_charles_keith.R;
import xyz.waiphyoag.padc_5_pro_wpa_charles_keith.adapters.NewInProductAdapter;
import xyz.waiphyoag.padc_5_pro_wpa_charles_keith.data.model.ProductsModel;
import xyz.waiphyoag.padc_5_pro_wpa_charles_keith.data.vo.NewProductVO;
import xyz.waiphyoag.padc_5_pro_wpa_charles_keith.delegates.NewInProductDelegate;
import xyz.waiphyoag.padc_5_pro_wpa_charles_keith.events.RestApiEvent;
import xyz.waiphyoag.padc_5_pro_wpa_charles_keith.mvp.presenters.NewInPresenter;
import xyz.waiphyoag.padc_5_pro_wpa_charles_keith.mvp.views.NewInView;

public class NewInListActivity extends BaseActivity implements NewInView {

    @BindView(R.id.rv_new_in_list)
    RecyclerView rvNewInList;
    @BindView(R.id.tv_item_count)
    TextView tvItemCount;
    private NewInProductAdapter mAdapter;
    private NewInPresenter mPresenter;
    private PublishSubject<List<NewProductVO>> mProductPS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_in_list);
        ButterKnife.bind(this, this);
        ProductsModel.initProductModel(getApplicationContext());

        mPresenter = ViewModelProviders.of(this).get(NewInPresenter.class);
        mPresenter.initPresenter(this);

        mPresenter.getNewProductLD().observe(this, new android.arch.lifecycle.Observer<List<NewProductVO>>() {
            @Override
            public void onChanged(@Nullable List<NewProductVO> newProductVOS) {
                displayProduct(newProductVOS);
            }
        });

        mPresenter.getErrorLD().observe(this, new android.arch.lifecycle.Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Snackbar.make(rvNewInList,s,Snackbar.LENGTH_INDEFINITE).show();
            }
        });



        mAdapter = new NewInProductAdapter(getApplicationContext(), mPresenter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        rvNewInList.setLayoutManager(gridLayoutManager);
        rvNewInList.setAdapter(mAdapter);



    }

    public void displayProduct(List<NewProductVO> newProductVOS) {
        mAdapter.appendNewData(newProductVOS);
        tvItemCount.setText(mAdapter.getItemCount()+" ITEMS ");
    }


    @Override
    public void launchNewInDetailScreen() {
        Intent intent = NewInDetailActivity.newIntent(getApplicationContext());
        startActivity(intent);

    }
}
