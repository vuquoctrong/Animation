package rikkesoft.trongvu.com.animation;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_name;
    private Button btn_onclick, btn_backActivity;
    private ImageView imv_anhaodai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        clickOnBT();
        backActivity();

    }

    /*
    ánh xạ
     */
    private void init(){
        tv_name = (TextView) findViewById(R.id.tv_name);
        btn_onclick = (Button) findViewById(R.id.btn_onClickAnim);
        imv_anhaodai = (ImageView) findViewById(R.id.im_anhdep);
        btn_backActivity = (Button) findViewById(R.id.btn_backActivity);
    }

    /*
    OnClick Button
     */
    private void clickOnBT(){
        btn_onclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
                tv_name.startAnimation(animation);
                Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.batch_animation);
                imv_anhaodai.startAnimation(animation1);
            }
        });
    }

    /*
    Back Activity
     */
    private void backActivity(){
        btn_backActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,BackActivity.class));
                overridePendingTransition(R.anim.anim_back,R.anim.anim_exit);
            }
        });
    }
}
