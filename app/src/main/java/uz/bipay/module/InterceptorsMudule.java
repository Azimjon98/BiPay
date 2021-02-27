package uz.bipay.module;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import timber.log.Timber;
import uz.bipay.addition.Constants;
import uz.bipay.addition.MySettings;
import uz.bipay.interfaces.ApplicationContext;
import uz.bipay.interfaces.CacheInterceptor;
import uz.bipay.interfaces.OfflineCacheInterceptor;


@Module(includes = ContextModule.class)
public class InterceptorsMudule {

    public static final String HEADER_CACHE_CONTROL = "Cache-Control";
    public static final String HEADER_PRAGMA = "Pragma";

    @CacheInterceptor
    @Provides
    public Interceptor provideCacheInterceptor(@ApplicationContext Context context) {

        return chain -> {
            ConnectivityManager e = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetwork = e.getActiveNetworkInfo();
            boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();

            CacheControl cacheControl;
            if (isConnected) {
                cacheControl = new CacheControl.Builder()
                        .maxAge(0, TimeUnit.SECONDS)
                        .build();
            } else {
                cacheControl = new CacheControl.Builder()
                        .maxStale(7, TimeUnit.DAYS)
                        .build();
            }
            Timber.d("provideCacheInterceptor: isConnected: " + isConnected + "  cache: " + cacheControl.toString());


            Request originalRequest = chain.request();
            if (!MySettings.getInstance().getToken().isEmpty()) {
                Timber.d("with token");
                originalRequest = originalRequest.newBuilder()
                        .header(Constants.HEADER_AUTHORIZATION, MySettings.getInstance().getToken())
                        .removeHeader(HEADER_PRAGMA)
                        .removeHeader(HEADER_CACHE_CONTROL)
                        .header(HEADER_CACHE_CONTROL, cacheControl.toString())
                        .build();
            } else {
                Timber.d("without token");
                originalRequest = originalRequest.newBuilder()
                        .removeHeader(HEADER_PRAGMA)
                        .removeHeader(HEADER_CACHE_CONTROL)
                        .header(HEADER_CACHE_CONTROL, cacheControl.toString())
                        .build();
            }


            return chain.proceed(originalRequest);
        };
    }

    @OfflineCacheInterceptor
    @Provides
    public Interceptor provideOfflineCacheInterceptor(@ApplicationContext Context context) {

        return chain -> {
            ConnectivityManager e = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetwork = e.getActiveNetworkInfo();
            boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();

            CacheControl cacheControl;
            if (isConnected) {
                cacheControl = new CacheControl.Builder()
                        .maxAge(0, TimeUnit.SECONDS)
                        .build();
            } else {
                cacheControl = new CacheControl.Builder()
                        .maxStale(7, TimeUnit.DAYS)
                        .build();
            }
            Timber.d("provideCacheInterceptor: isConnected: " + isConnected + "  cache: " + cacheControl.toString());

            Request originalRequest = chain.request();
            if (!MySettings.getInstance().getToken().isEmpty()) {
                Timber.d("with token");
                originalRequest = originalRequest.newBuilder()
                        .header(Constants.HEADER_AUTHORIZATION, MySettings.getInstance().getToken())
                        .removeHeader(HEADER_PRAGMA)
                        .removeHeader(HEADER_CACHE_CONTROL)
                        .header(HEADER_CACHE_CONTROL, cacheControl.toString())
                        .build();
            } else {
                Timber.d("without token");
                originalRequest = originalRequest.newBuilder()
                        .removeHeader(HEADER_PRAGMA)
                        .removeHeader(HEADER_CACHE_CONTROL)
                        .header(HEADER_CACHE_CONTROL, cacheControl.toString())
                        .build();
            }


            return chain.proceed(originalRequest);
        };
    }

    @Provides
    public boolean isConnected(@ApplicationContext Context context) {

        try {
            ConnectivityManager e = (ConnectivityManager) context.getSystemService(
                    Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetwork = e.getActiveNetworkInfo();
            return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        } catch (Exception e) {

        }

        return false;
    }
}