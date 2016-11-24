package nl.rabobank;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class WriteToFile {

    private static final String NOT_FOUND = "NOT_FOUND";
    private static final String SEPERATOR = "\t";

    public static void write(List<Feeds> feeds, String keyWord) {
        FileWriter file = null;
        final DateFormat format = new SimpleDateFormat("ddMMM");
        String d = format.format(new Date());
        try {
            String fileName = "C://temp//Feeds_" + keyWord + "_" + d + ".txt";
            file = new FileWriter(fileName);
            for (Feeds feed : feeds) {
                file.write(feed.getFeedDate() + SEPERATOR + checkEmpty(feed.getFeedBy()) + SEPERATOR
                        + checkEmpty(feed.getLocation()) + SEPERATOR + feed.getFeed());
                file.write(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                file.flush();
                file.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static String checkEmpty(final String value) {
        return StringUtils.isEmpty(value) ? NOT_FOUND : value;
    }
}
