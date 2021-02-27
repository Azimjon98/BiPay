package uz.bipay.module;

import android.content.Context;

import java.io.File;
import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;
import uz.bipay.interfaces.ApplicationContext;
import uz.bipay.interfaces.CacheInterceptor;
import uz.bipay.interfaces.MyApplicationScope;
import uz.bipay.interfaces.OfflineCacheInterceptor;

@Module(includes = {ContextModule.class, InterceptorsMudule.class})
public class
OkHttpClientModule {


    //adding network interceptors and configuring RETROFIT, GLIDE CACHE
    @Provides
    public OkHttpClient okHttpClient(@ApplicationContext Context context, Cache cache, HttpLoggingInterceptor interceptor,
                                     @OfflineCacheInterceptor Interceptor offlineCacheIntercepror,
                                     @CacheInterceptor Interceptor cacheInterceptor) {

        return new OkHttpClient.Builder()
                .addInterceptor(offlineCacheIntercepror)
//                .addInterceptor(new ChuckInterceptor(context).showNotification(false))
                .addInterceptor(interceptor)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .cache(cache)
                .build();
    }


    @Provides
    public Cache cache(File file) {
        return new Cache(file, 1000 * 1000 * 1000); //1000mb
    }

    @Provides
    @MyApplicationScope
    public File file(@ApplicationContext Context context) {
        File file = new File(context.getCacheDir(), "HttpCache");
        file.mkdir();
        return file;
    }

    @Provides
    public HttpLoggingInterceptor httpLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(message -> Timber.d(message));
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }
}
