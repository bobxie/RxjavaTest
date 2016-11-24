package com.lovecoder.rxjavatest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.lovecoder.rxjavatest.net.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.click_me_BN)
    Button clickMeBN;
    @Bind(R.id.result_TV)
    TextView resultTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


//        Observable<String> myObservable = Observable.create(new Observable.OnSubscribe<String>() {
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//                subscriber.onNext("Hello, world!");
//                subscriber.onCompleted();
//            }
//        });
//        Subscriber<String> mySubscriber = new Subscriber<String>() {
//            @Override
//            public void onCompleted() {
//
//            }
//            @Override
//            public void onError(Throwable e) {
//                e.printStackTrace();
//            }
//
//            @Override
//            public void onNext(String s) {
//                Log.d("admin", "熟悉原理===" + s);
//            }
//        };
//        myObservable.subscribe(mySubscriber);
//
//
//        //简洁的代码
//        Observable observable = Observable.just("Hello,我是简洁的");
//
//        Action1<String> action1 = new Action1<String>() {
//            @Override
//            public void call(String s) {
//                Log.d("admin", "简洁代码回调输出===" + s);
//            }
//        };
//        observable.subscribe(action1);
//
//        Observable.just("Heee").subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                Log.d("admin", "简洁代码回调输出===" + s);
//            }
//        });
//
//
//        Observable.just("map学习")
//                .map(new Func1<String, String>() {
//                    @Override
//                    public String call(String s) {
//                        return "----增加的";
//                    }
//                })
//                .map(new Func1<String, Integer>() {
//                    @Override
//                    public Integer call(String s) {
//                        return s.hashCode();
//                    }
//                })
//                .subscribe(new Action1<Integer>() {
//                    @Override
//                    public void call(Integer s) {
//                        Log.d("admin", "map操作符增加后===" + s);
//                    }
//                });
//
        List<String> lists = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lists.add("结果" + i);
        }

//        Observable.just(lists)
//        .flatMap(new Func1<List<String>, Observable<String>>() {
//            @Override
//            public Observable<String> call(List<String> strings) {
//                return Observable.from(strings);
//            }
//        })
//        .subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                Log.d("admin","flatMap循环===" + s);
//            }
//        });

//        Observable.just(lists)
//                .flatMap(new Func1<List<String>, Observable<String>>() {
//                    @Override
//                    public Observable<String> call(List<String> strings) {
//                        return Observable.from(strings);
//                    }
//                })
//                .flatMap(new Func1<String, Observable<String>>() {
//                    @Override
//                    public Observable<String> call(String url) {
//                        return Observable.just(url);
//                    }
//                })
//                .filter(new Func1<String, Boolean>() {
//                    @Override
//                    public Boolean call(String s) {
//                        return !s.equals("结果8");
//                    }
//                })
//                .take(3)
//                .doOnNext(new Action1<String>() {
//                    @Override
//                    public void call(String s) {
//                        Log.d("admin","保存" + s);
//                    }
//                })
//                .subscribe(new Subscriber<String>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//
//                    }
//                });
//                .subscribe(new Action1<String>() {
//                    @Override
//                    public void call(String s) {
//                        Log.d("admin","s===" + s);
//                    }
//                });
        Observable.just("ssasdasdsad")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                    }
                });

    }

    @OnClick(R.id.click_me_BN)
    public void onClick() {
        getMovie();
    }

    private Subscriber<MovieEntity> subscriber;

    private void getMovie(){
//        subscriber = new Subscriber<MovieEntity>() {
//            @Override
//            public void onCompleted() {
//                Toast.makeText(MainActivity.this, "Get Top Movie Completed", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                resultTV.setText(e.getMessage());
//            }
//
//            @Override
//            public void onNext(MovieEntity movieEntity) {
//                resultTV.setText(movieEntity.toString());
//            }
//        };
//        HttpMethods.getInstance().getTopMovie(subscriber, 0, 10);
    }


    //进行网络请求
//    private void getMovie(){
//        String baseUrl = "https://api.douban.com/v2/movie/";
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(baseUrl)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .build();
//
//        MovieService1 movieService = retrofit.create(MovieService1.class);
//
//        movieService.getTopMovie(0, 10)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<MovieEntity>() {
//                    @Override
//                    public void onCompleted() {
//                        Toast.makeText(MainActivity.this, "Get Top Movie Completed", Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        resultTV.setText(e.getMessage());
//                    }
//
//                    @Override
//                    public void onNext(MovieEntity movieEntity) {
//                        resultTV.setText(movieEntity.toString());
//                    }
//                });
//    }


    //进行网络请求
//    private void getMovie() {
//        String baseUrl = "https://api.douban.com/v2/movie/";
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(baseUrl)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        MovieService movieService = retrofit.create(MovieService.class);
//        Call<MovieEntity> call = movieService.getTopMovie(0, 10);
//        call.enqueue(new Callback<MovieEntity>() {
//            @Override
//            public void onResponse(Call<MovieEntity> call, Response<MovieEntity> response) {
//                resultTV.setText(response.body().toString());
//            }
//
//            @Override
//            public void onFailure(Call<MovieEntity> call, Throwable t) {
//                resultTV.setText(t.getMessage());
//            }
//        });
//    }


}
