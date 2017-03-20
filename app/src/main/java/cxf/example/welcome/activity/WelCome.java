package cxf.example.welcome.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import cxf.example.welcome.R;

/**
 * Created by Administrator on 2017/3/20.
 */

public class WelCome extends BaseActivity {
    private TextView textview = null;
    private int time = 5;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.welcome);
        init();
    }

    private void init() {
        textview = (TextView) findViewById(R.id.welcome_text);
        handler.postDelayed(runnable, 1000);
        textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time = 0;
            }
        });
    }

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (time > 0) {
                time--;
                textview.setText(time + "s 跳过");
                handler.postDelayed(this, 1000);
            } else {
                startIntent();
            }
        }
    };

    private void startIntent() {
        Intent intent = new Intent(WelCome.this, Guide.class);
        startActivity(intent);
        WelCome.this.finish();
    }
}
