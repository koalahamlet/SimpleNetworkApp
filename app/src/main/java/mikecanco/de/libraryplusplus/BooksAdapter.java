package mikecanco.de.libraryplusplus;

/**
 * Created by koalahamlet on 11/14/14.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by michaelhuff on 4/14/14.
 */
public class BooksAdapter extends ArrayAdapter<Book> {

    private static class ViewHolder {

        TextView title;
        TextView authors;
    }

    public BooksAdapter(Context context, int books) {
        super(context, R.layout.book_list_item, books);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        super.getView(position, convertView, parent);

        // Get the data item for this position
        final Book book = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.book_list_item, null);
            viewHolder.title = (TextView) convertView.findViewById(R.id.tvTitle);
            viewHolder.authors = (TextView) convertView.findViewById(R.id.tvAuthor);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "you clicked "+book.getTitle(), Toast.LENGTH_SHORT ).show();
//                Intent i = new Intent(v.getContext(), BookDetailActivty.class);
//                i.putExtra("book", book);
//                ((MainActivity) v.getContext()).startActivityForResult(i, MainActivity.REQUEST_CODE);
            }
        });

        // Populate the data into the template view using the data object
        viewHolder.title.setText(book.getTitle());
        viewHolder.authors.setText(book.getAuthor());

        return convertView;
    }
}

