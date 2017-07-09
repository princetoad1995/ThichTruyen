package com.princetoad.thichtruyen.Common;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by PRINCE D. TOAD on 3/13/2017.
 */

public class RetrofitRequest {

    private static RetrofitRequest instance;
    private static Retrofit retrofit = null;
    private static OkHttpClient defaultHttpClient = null;

    private RetrofitRequest() {
        if (defaultHttpClient == null) {
            OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
            builder.readTimeout(Constant.RETROFIT.READ_TIME_OUT, TimeUnit.SECONDS);
            builder.connectTimeout(Constant.RETROFIT.CONNECT_TIME_OUT, TimeUnit.SECONDS);
            defaultHttpClient = builder.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request().newBuilder().build();
                    return chain.proceed(request);
                }
            }).build();
        }
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constant.RETROFIT.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(defaultHttpClient)
                    .build();
        }
    }

    public static RetrofitRequest getInstance() {
        if (instance == null) {
            instance = new RetrofitRequest();
        }
        return instance;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

}
