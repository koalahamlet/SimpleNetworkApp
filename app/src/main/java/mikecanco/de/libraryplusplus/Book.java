package mikecanco.de.libraryplusplus;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by koalahamlet on 11/14/14.
 */
public class Book implements Serializable{


    String author;
    String categories;
    String lastCheckedOut;
    String lastCheckedOutBy;
    String publisher;
    String title;
    String url;

    public Book() {

    }

    public Book(String author, String categories, String publisher, String title) {

        this.author = author;
        this.categories = categories;
        this.publisher = publisher;
        this.title = title;
        this.lastCheckedOutBy = "joe";
        // maybe the date should be updated as well.
    }

    public Book(String author, String categories, Date lastCheckedOut, String lastCheckedOutBy,
                String publisher, String title, String url) {

        this.author = author;
        this.categories = categories;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss zzz");
        this.lastCheckedOut = sdf.format(lastCheckedOut);
        this.lastCheckedOutBy = lastCheckedOutBy;
        this.publisher = publisher;
        this.title = title;
        this.url = url;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getLastCheckedOut() {
        return lastCheckedOut;
    }

    public void setLastCheckedOut(Date lastCheckedOut) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss zzz");
        this.lastCheckedOut = sdf.format(lastCheckedOut);
    }

    public String getLastCheckedOutBy() {
        return lastCheckedOutBy;
    }


    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        String formattedUrl = url.substring(1);
        return formattedUrl;
    }

}
