package lrucacheuse.tqp.com.qingqiuceshi;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 11 on 2016/4/14.
 */
public class SystemRequest extends HttpRequstClient {

//    登录
    public static void verifyCode(Subscriber<PhoneICEntity> subscriber) {
        getRetrofit().create(SystemHttpInterface.class).verifyCode().subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
    }

}
