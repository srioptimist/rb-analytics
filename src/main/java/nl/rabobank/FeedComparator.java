package nl.rabobank;

import java.util.Comparator;

/**
 * Created by JayaramanJ on 25-11-2016.
 */
public class FeedComparator implements Comparator<Feeds> {

     public int compare(Feeds f1, Feeds f2) {

        int result = f2.getSource().compareTo(f2.getSource());
        if (result != 0)
        {
            return result;
        }
        result = f2.getFeedDate().compareTo(f1.getFeedDate());
        if (result != 0)
        {
            return result;
        }
        return result;
        // f1.getFeetDate().compareTo(f2.getFeetDate());
    }
}
