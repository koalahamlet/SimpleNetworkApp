package mikecanco.de.libraryplusplus;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by koalahamlet on 11/14/14.
 */
public class ApiClient {



    @Inject ApiService apiService;

//
//    public static Observable<Response> uploadPassiveLogItem(List<PassiveLogItem> items) {
//
//        PassiveLogRequest myPassiveLogRequst = new PassiveLogRequest(items);
//        return apiService.uploadPassiveLogItems(myPassiveLogRequst)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread());
//    }

    public ApiClient() {
        App.sInstance.inject(this);
    }

    public  Observable<BooksResponse> getBooks() {


        return apiService.getBooks()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
//
//    public static Observable<Response> uploadResponses(List<Question> questions) {
//
//        AnswerRequest myResponseRequest = new AnswerRequest(questions);
//        return apiService.uploadResponses(myResponseRequest)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread());
//    }
//
//    public static Observable<Dashboard> getDashBoard() {
//
//        return apiService.getDashboard()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread());
//    }
}
