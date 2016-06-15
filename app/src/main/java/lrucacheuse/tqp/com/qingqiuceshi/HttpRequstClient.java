package lrucacheuse.tqp.com.qingqiuceshi;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Design on 2016/4/1.
 */
public class HttpRequstClient {

//    http://192.168.16.184:8921/v2.1/rest/util/verifyCode/15507487039/1234?api_key=wvP4Egy79SqChhZm&channels=aph0&appVersion=4.0.2&platform=1

    private final static int HOST = 1;
    private final static String[] IPS = {"192.168.16.184:8921/v2.1/rest/", "192.168.199.111:8921/v2.1/rest/"};
    private final static String BASE_URL = "http://" + IPS[HOST];

    public static String getBaseUrl() {
        return BASE_URL;
    }


    public static Retrofit getRetrofit() {
//        OkHttpClient client = new OkHttpClient();
//        client.interceptors().add(new Interceptor() {
//            @Override
//            public Response intercept(Interceptor.Chain chain) throws IOException {
//                Request original = chain.request();
//                // Customize the request header
//                Request request = original.newBuilder()
//                        .header("Accept", "application/json")
//                        .header("Content-Type", "application/json")
//                        .header("Authorization", "auth-token")
//                        .method(original.method(), original.body())
//                        .build();
//
//                Response response = chain.proceed(request);
//
//                // Customize or return the response
//                return response;
//            }
//        });


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getBaseUrl())
//                .client(client)
                .addConverterFactory(GsonConverterFactory.create()) // 添加 json 转换器
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // 添加 RxJava 适配器
                .build();

        return retrofit;
    }


}
