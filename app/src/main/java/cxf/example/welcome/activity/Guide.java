package cxf.example.welcome.activity;

import android.Manifest;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.github.paolorotolo.appintro.AppIntro;

import cxf.example.welcome.activity.fragment.FragmentOne;
import cxf.example.welcome.activity.fragment.FragmentThree;
import cxf.example.welcome.activity.fragment.FragmentTwo;

/**
 * Created by Administrator on 2017/3/20.
 */

public class Guide extends AppIntro {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        askForPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.READ_CONTACTS, Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE}, 2);
        addSlide(new FragmentOne());
        addSlide(new FragmentTwo());
        addSlide(new FragmentThree());
        // Override bar/separator color.
        setBarColor(Color.parseColor("#3F51B5"));
        setSeparatorColor(Color.parseColor("#2196F3"));
        // Hide Skip/Done button.
        showSkipButton(true);
        setProgressButtonEnabled(true);
//        showBackButtonWithDone = true;
        showDoneButton(true);
        setDoneText("开启一切可能");
        setBackButtonVisibilityWithDone(true);
        // Turn vibration on and set intensity.
        // NOTE: you will probably need to ask VIBRATE permission in Manifest.

    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        // Do something when users tap on Skip button.
        // 跳过
        Toast.makeText(getApplicationContext(), "跳过", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        // Do something when users tap on Done button.
        // 完成
        Toast.makeText(getApplicationContext(), "完成", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
        // Do something when the slide changes.
        // 滑动中
    }
}
