package mikecanco.de.libraryplusplus;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import javax.inject.Inject;

import rx.Observer;


public class MainActivity extends Activity {

    public final String TAG = MainActivity.class.getSimpleName();

    @Inject ApiClient apiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        App.sInstance.inject(this);

        ListView myList = (ListView) findViewById(R.id.myList);
        // Add a dummy adapter initially to display the empty list view while data loads
        myList.setAdapter(new ArrayAdapter<Book>(this, 0));
        refreshList();
    }

    private void refreshList() {
        // get instance of (aka construct) Library service
//        getBooks(RestClientProvider.getInstance().getService());
        Observer<BooksResponse> observer = new Observer<BooksResponse>() {
            @Override public void onCompleted() {

//                progressBar.setVisibility(View.GONE);
//
//                txtTitle1.setVisibility(View.VISIBLE);
//                txtTitle2.setVisibility(View.VISIBLE);
//
//                //TODO: this could be removed in production/
//                Intent intent = new Intent(App.getInstance().getApplicationContext(),
//                        ShowQuestionAlarmReceiver.class);
//                App.getInstance().getApplicationContext().sendBroadcast(intent);
            }

            @Override public void onError(Throwable e) {
                Log.d(TAG, "I errored in the Dashboard Network Call");
                e.printStackTrace();
//                if (e instanceof RetrofitError) {
//                    RetrofitError error = (RetrofitError) e;
//                    if (error.getResponse().getStatus() == 401) {
//                        Session.logout();
//                        MainActivity.launch(getActivity());
//                        getActivity().finish();
//                    }
//                }
            }

            @Override public void onNext(BooksResponse response) {

                Log.d("DEBUG", response.toString());
                BooksAdapter mAdapter = new BooksAdapter(getBaseContext(), response.getBooks().size());
                //Log.d(TAG, "I came back ok");
//                scrollView.setEnabled(true);
//                dashboard = metric;
//                displayMetricItems();
            }
        };


        apiClient.getBooks().subscribe(observer);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
