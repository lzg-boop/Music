package com.example.lzg.music;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.main_tv_tiaozhuan)
    TextView mainTvTiaozhuan;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        final Mycount mycount = new Mycount(3000, 1000);
        mycount.start();
        mainTvTiaozhuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ZhuActivity.class));
                mycount.cancel();
                finish();
            }
        });

    }


    public class Mycount extends CountDownTimer {
        public Mycount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long l) {
            mainTvTiaozhuan.setText("跳过" + l / 1000 + "s");
        }

        @Override
        public void onFinish() {
            startActivity(new Intent(MainActivity.this, ZhuActivity.class));
            finish();
        }
    }
}
