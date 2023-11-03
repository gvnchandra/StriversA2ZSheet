package util;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class Sample {
    public static void main(String[] args) {
        Date date1 = new Date(System.currentTimeMillis());
        try {
            Thread.sleep(5500); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            // Handle the exception if necessary
        }
        Date date2 = new Date(System.currentTimeMillis());

        Instant instant1 = date1.toInstant();
        Instant instant2 = date2.toInstant();
        Duration duration = Duration.between(instant1, instant2);
        long seconds = duration.getSeconds();

        System.out.println("The difference in seconds is: " + seconds);
        System.out.println("current timestamp " + new Timestamp(System.currentTimeMillis()));
        System.out.println((date2.getTime() - date1.getTime()) / 1000);
    }
}