package com.jaeger.statusbarutil;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import com.ms.module.statusbar.utils.StatusBarUtils;
import com.jaeger.statusbardemo.R;

/**
 * Created by jaeger on 08/03/2018.
 *
 * Email: chjie.jaeger@gmail.com
 * GitHub: https://github.com/laobie
 */

public class SwitchModeActivity extends BaseActivity {
    private Toolbar mToolbar;
    private Button mBtnSetLightMode;
    private Button mBtnSetDarkMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_mode);

        mToolbar = findViewById(R.id.toolbar);
        mBtnSetLightMode = findViewById(R.id.btn_set_light_mode);
        mBtnSetDarkMode = findViewById(R.id.btn_set_dark_mode);

        // 设置toolbar
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mBtnSetLightMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = getResources().getColor(R.color.light_gray);
                StatusBarUtils.setColor(SwitchModeActivity.this, color, 30);
                mToolbar.setBackgroundColor(color);
                StatusBarUtils.setLightMode(SwitchModeActivity.this);
            }
        });

        mBtnSetDarkMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = getResources().getColor(R.color.colorPrimary);
                StatusBarUtils.setColor(SwitchModeActivity.this, color);
                mToolbar.setBackgroundColor(color);
                StatusBarUtils.setDarkMode(SwitchModeActivity.this);
            }
        });
    }

    @Override
    protected void setStatusBar() {
        StatusBarUtils.setColor(this, getResources().getColor(R.color.colorPrimary));
    }
}
