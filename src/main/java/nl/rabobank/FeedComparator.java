package nl.rabobank;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Locale;

/**
 * Created by JayaramanJ on 25-11-2016.
 */
public class FeedComparator implements Comparator<Feeds> {

     public int compare(Feeds f1, Feeds f2) {

        int result = f2.getSource().compareTo(f1.getSource());
        if (result != 0)
        {
            return result;
        }
        final DateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.ENGLISH);
        
        try {
            result = format.parse(f2.getFeedDate()).compareTo(format.parse(f1.getFeedDate()));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (result != 0)
        {
            return result;
        }
        return result;
        // f1.getFeetDate().compareTo(f2.getFeetDate());
    }
}
