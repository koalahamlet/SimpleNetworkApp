package mikecanco.de.libraryplusplus;

import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.POST;
import rx.Observable;

/**
 * Created by koalahamlet on 11/14/14.
 */
public interface ApiService {

    @GET("/books") Observable<BooksResponse> getBooks();

    @GET("/books/{id}") Observable<Response> getSpecificBook();

    @POST("/books/{id}") Observable<Response> updateSpecificBook(
            @Body Book logItem);

    @DELETE("/books/{id}") Observable<Response> deleteSpecificBook();
}
