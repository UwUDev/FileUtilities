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

    public static void editFileDate(String path, String date, String time) throws ParseException {
        File file = new File(path);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss.SSS");
        SimpleDateFormat timeFormat2 = new SimpleDateFormat("hh:mm");


        Date newLastModifiedDate = dateFormat.parse(date);
        Date newLastModifiedTime;
        try {
            newLastModifiedTime = timeFormat.parse(time);
        } catch (Exception ignored){
            newLastModifiedTime = timeFormat2.parse(time);
        }

        System.out.println(newLastModifiedDate);
        file.setLastModified(newLastModifiedDate.getTime() + newLastModifiedTime.getTime());
        System.out.println(newLastModifiedDate.getTime());
    }
}
