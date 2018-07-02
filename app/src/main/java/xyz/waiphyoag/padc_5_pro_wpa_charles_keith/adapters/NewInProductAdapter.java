package xyz.waiphyoag.padc_5_pro_wpa_charles_keith.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import xyz.waiphyoag.padc_5_pro_wpa_charles_keith.R;
import xyz.waiphyoag.padc_5_pro_wpa_charles_keith.data.vo.NewProductVO;
import xyz.waiphyoag.padc_5_pro_wpa_charles_keith.delegates.NewInProductDelegate;
import xyz.waiphyoag.padc_5_pro_wpa_charles_keith.viewholders.BaseViewHolder;
import xyz.waiphyoag.padc_5_pro_wpa_charles_keith.viewholders.NewInProductViewHolder;

/**
 * Created by WaiPhyoAg on 6/29/18.
 */

public class NewInProductAdapter extends BaseRecyclerAdapter<BaseViewHolder, NewProductVO> {
    private NewInProductDelegate mDelegate;

    public NewInProductAdapter(Context context, NewInProductDelegate newInProductDelegate) {
        super(context);
        this.mDelegate = newInProductDelegate;

    }

    @Override
    public int getItemCount() {
        return super.getItemCount();
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflator.inflate(R.layout.item_new_in_product, parent, false);
        return new NewInProductViewHolder(view, mDelegate);
    }
}
