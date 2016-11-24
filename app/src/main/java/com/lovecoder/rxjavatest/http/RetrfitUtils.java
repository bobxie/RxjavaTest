package com.lovecoder.rxjavatest.http;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by haibo on 2016/11/24.
 */
public class RetrfitUtils {
    private static RetrfitUtils mRetrfitUtils = null;
    private static final int DEFAULT_TIMEOUT = 20;

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .baseUrl(baseUrl);
    private static OkHttpClient.Builder httpClient =
            new OkHttpClient.Builder()
                    .addNetworkInterceptor(
                            new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS))
                    .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

    private RetrfitUtils(){
        init();
    }

    private void init() {

    }

    public static RetrfitUtils getInstance() {
        if (null == mRetrfitUtils) {
            mRetrfitUtils = new RetrfitUtils();
        }
        return mRetrfitUtils;
    }
}
