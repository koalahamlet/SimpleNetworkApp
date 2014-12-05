package mikecanco.de.libraryplusplus;

import dagger.Module;

/**
 * Created by koalahamlet on 11/14/14.
 */
@Module(
        includes = {
                NetworkModule.class
        },
        staticInjections = {
                ApiClient.class
        },
        injects = {
                ApiClient.class,
                MainActivity.class
        })
public final class AppModule {

    private App mApp;

    public AppModule(App mLibraryApp) {
        this.mApp = mLibraryApp;
    }
}
