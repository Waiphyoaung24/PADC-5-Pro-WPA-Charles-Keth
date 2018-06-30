package xyz.waiphyoag.padc_5_pro_wpa_charles_keith.viewholders;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import javax.microedition.khronos.opengles.GL;

import butterknife.BindView;
import xyz.waiphyoag.padc_5_pro_wpa_charles_keith.R;
import xyz.waiphyoag.padc_5_pro_wpa_charles_keith.data.vo.NewProductVO;
import xyz.waiphyoag.padc_5_pro_wpa_charles_keith.delegates.NewInProductDelegate;

/**
 * Created by WaiPhyoAg on 6/29/18.
 */

public class NewInProductViewHolder extends BaseViewHolder<NewProductVO> {
    @BindView(R.id.iv_product_image)
    ImageView ivProductImage;
    @BindView(R.id.tv_product_name)
    TextView tvProductName;
    private NewInProductDelegate mDelegate;

    public NewInProductViewHolder(View itemView, NewInProductDelegate newInProductDelegate) {
        super(itemView);
        this.mDelegate = newInProductDelegate;
    }

    @Override
    public void setData(NewProductVO data) {

        Glide.with(itemView.getContext())
                .load(data.getProductImage())
                .into(ivProductImage);
        tvProductName.setText(data.getProductTitle());

    }


    @Override
    public void onClick(View v) {
        mDelegate.onTapProduct();

    }
}
