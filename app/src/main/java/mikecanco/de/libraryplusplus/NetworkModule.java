package mikecanco.de.libraryplusplus;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.converter.Converter;
import retrofit.converter.GsonConverter;

/**
 * Created by koalahamlet on 11/14/14.
 */
@Module(
        staticInjections = { ApiClient.class },
        complete = false, library = true)
public class NetworkModule {


    @Provides @Singleton ApiClient provideApiClient() {

        return new ApiClient();
    }

    @Provides @Singleton RequestInterceptor provideHeaders() {
        return new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
//                App.getWritableDB();
                request.addHeader("Content-type", "application/json");
//                if (Session.isLoggedIn()) {
//                    request.addHeader("Authorization", "Bearer " + Session.getKnowlToken());
//                }
//                request.addHeader("User-Agent", "knowlapp android version " + String.valueOf(App.getAppVersion()));
            }
        };
    }


    @Provides
    @Singleton
    RestAdapter.Builder provideRestAdapterBuilder(RequestInterceptor headers,
                                                  Converter converter) {
        return new RestAdapter.Builder().setEndpoint("http://prolific-interview.herokuapp.com/53444c44ce48cc11ad329ec5/")
                .setLogLevel(RestAdapter.LogLevel.FULL)
//                .setRequestInterceptor(headers).setErrorHandler(provideErrorHandler())
                .setConverter(converter);
    }

    @Provides @Singleton ApiService provideApiService(RestAdapter.Builder restAdapterBuilder,
                                                      RequestInterceptor headers) {
        final RestAdapter restAdapter = restAdapterBuilder.build();
        return restAdapter.create(ApiService.class);
    }

    @Provides @Singleton
    Gson provideGson() {
        return new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
//                .registerTypeAdapter(Date.class, new DateDeserializer())
//                .setDateFormat(DateDeserializer.DATE_FORMATS[0])
                .create();
    }

    @Provides @Singleton Converter provideConverter(Gson gson) {
        return new GsonConverter(gson);
    }
}
