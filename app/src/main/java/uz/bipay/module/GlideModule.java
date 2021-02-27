package uz.bipay.module;

import android.content.Context;

import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;

import dagger.Module;
import dagger.Provides;
import uz.bipay.interfaces.ApplicationContext;


@Module(includes = {ContextModule.class})
public class GlideModule {
    @Provides
    public RequestManager glideRequestManager(@ApplicationContext Context context, CircularProgressDrawable circularProgressDrawable) {
        return Glide.with(context)
                .setDefaultRequestOptions(new RequestOptions()
                        .placeholder(circularProgressDrawable)
                        );
    }

//    @Provides
//    public RequestManager glideRequestManager(@ApplicationContext Context context, ) {
//        return Glide.with(context)
//                .setDefaultRequestOptions(new RequestOptions()
//                                .placeholder(circularProgressDrawable)
////                        .placeholder(R.drawable.empty_medium)
//                );
//    }

    @Provides
    public CircularProgressDrawable circularProgressDrawable(@ApplicationContext Context context) {
        CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(context);
        circularProgressDrawable.setStrokeWidth(5f);
        circularProgressDrawable.setCenterRadius(30f);
        circularProgressDrawable.start();

        return circularProgressDrawable;
    }

}