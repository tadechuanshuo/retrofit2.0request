package lrucacheuse.tqp.com.qingqiuceshi;

import okhttp3.RequestBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Design on 2016/4/1.
 */
public interface SystemHttpInterface {

    //get请求方式
    @GET("util/verifyCode/18310391875/6066")
    Observable<PhoneICEntity> verifyCode();


    //post请求方式
    @FormUrlEncoded
    @POST("地址")
    Observable<PhoneICEntity> getMemberInfo(@Field("version") String version,  @Field("v") String v);


    //    上传图片
    //也可以上传音频requestBody = RequestBody.create(MediaType.parse("audio/x-mei-aac"), fileList.get(i).getFile());
    //或其他文件
    @Multipart
    @POST("地址")
    Observable<PhoneICEntity> user_photo(@Part("version") String version, @Part("content") RequestBody img);

    //上传图片
    //requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), fileList.get(i).getFile());
//							requestBody = RequestBody.create(MediaType.parse("image/*"), fileList.get(i).getFile());
    @Multipart
    @POST("地址")
    Observable<PhoneICEntity> addDiseaseCourseImage(@Part("version") String version,  @Part("data\"; filename=\"image.jpg") RequestBody data);


}
