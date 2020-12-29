package me.uwu.fu.utils;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class FileUtilities {
    public static LocalDate getFileDate(String path){
        File file = new File(path);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");

        return LocalDate.parse(dateFormat.format(file.lastModified()), dateTimeFormatter);
    }

    public static void editFileDate(String path, String date) throws ParseException {
        File file = new File(path);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date newLastModifiedDate = dateFormat.parse(date);
        System.out.println(newLastModifiedDate);
        file.setLastModified(newLastModifiedDate.getTime());
    }
}
