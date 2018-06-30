package xyz.waiphyoag.padc_5_pro_wpa_charles_keith.activites;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by WaiPhyoAg on 6/30/18.
 */

public abstract class BaseActivity extends AppCompatActivity implements Observer<String> {

    @Override
    public void onChanged(@Nullable String s) {
        displayErrorMsg(s);

    }

    protected void displayErrorMsg(String s) {

    }
}
