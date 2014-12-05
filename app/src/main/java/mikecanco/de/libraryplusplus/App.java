package mikecanco.de.libraryplusplus;

import android.app.Application;

import dagger.ObjectGraph;

/**
 * Created by koalahamlet on 11/14/14.
 */
public class App extends Application {

    public static App sInstance;
    private ObjectGraph objectGraph;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        initDaggerObjectGraph();

    }

    private void initDaggerObjectGraph() {
        objectGraph = ObjectGraph.create(new AppModule(this));
        objectGraph.injectStatics();
    }

    public void inject(Object object) {
        objectGraph.inject(object);
    }

//    public static App getInstance() {
//        if (sInstance == null) {
//            sInstance new App();
//        } else {}
//    }
//
}