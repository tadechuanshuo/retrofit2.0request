package lrucacheuse.tqp.com.qingqiuceshi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import rx.Subscriber;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SystemRequest.verifyCode(new Subscriber<PhoneICEntity>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(MainActivity.this, "网络异常", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(PhoneICEntity phoneICEntity) {
                        if (phoneICEntity.statusCode.equals("200")){
                            Toast.makeText(MainActivity.this, "成功", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(MainActivity.this, phoneICEntity.message.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }
}
