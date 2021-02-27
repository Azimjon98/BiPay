package uz.bipay.module;


import android.content.Context;

import dagger.Module;
import dagger.Provides;
import uz.bipay.interfaces.ApplicationContext;
import uz.bipay.interfaces.MyApplicationScope;

@ApplicationContext
@Module
public class ContextModule {
    Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @MyApplicationScope
    @ApplicationContext
    @Provides
    Context context() {
        return context.getApplicationContext();
    }
}
