package uz.bipay.application;

import android.app.Application;

import uz.bipay.component.DaggerMyApplicationComponent;
import uz.bipay.component.MyApplicationComponent;
import uz.bipay.module.ContextModule;


public class MyApplication extends Application {
    private static MyApplication instance;
    private MyApplicationComponent myApplicationComponent;


    public static MyApplication getInstance() throws ClassNotFoundException {
        if (instance == null)
            throw new ClassNotFoundException("application doesn't create yet");
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        myApplicationComponent = DaggerMyApplicationComponent.builder()
                .contextModule(new ContextModule(this))
                .build();
    }

    public MyApplicationComponent getMyApplicationComponent() {
        return myApplicationComponent;
    }
}
