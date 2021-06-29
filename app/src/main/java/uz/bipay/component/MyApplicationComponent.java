package uz.bipay.component;

import com.bumptech.glide.RequestManager;

import dagger.Component;
import retrofit2.Retrofit;
import uz.bipay.interfaces.MyApplicationScope;
import uz.bipay.interfaces.RetrofitAnnotations;
import uz.bipay.module.DataBaseModule;
import uz.bipay.module.GlideModule;
import uz.bipay.module.RetrofitModule;

@MyApplicationScope
@Component(modules = {RetrofitModule.class, GlideModule.class, DataBaseModule.class})
public interface
MyApplicationComponent {

    @RetrofitAnnotations.RetrofitApp
    Retrofit getRetrofitApp();

    RequestManager getGlideManager();

}
