package xyz.waiphyoag.padc_5_pro_wpa_charles_keith.viewholders;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.waiphyoag.padc_5_pro_wpa_charles_keith.R;
import xyz.waiphyoag.padc_5_pro_wpa_charles_keith.data.vo.NewProductVO;

/**
 * Created by WaiPhyoAg on 6/30/18.
 */

public class NewInProductDetailViewHolder extends FrameLayout {

    @BindView(R.id.iv_product_detail_image)
    ImageView ivProductImage;

    @BindView(R.id.tv_product_detail_name)
    TextView tvProductDetail;

    public NewInProductDetailViewHolder(Context context) {
        super(context);
    }

    public NewInProductDetailViewHolder(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NewInProductDetailViewHolder(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this, this);
    }

    public void setData(NewProductVO newProductVO) {
        Glide.with(ivProductImage.getContext())
                .load(newProductVO.getProductImage())
                .into(ivProductImage);
        tvProductDetail.setText(newProductVO.getProductTitle());
    }
}
