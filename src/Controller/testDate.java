/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Administrator
 */
public class testDate {
  
             public static void main(String[] args) throws ParseException {
//           DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
//             LocalDateTime now = LocalDateTime.now();  
//             System.out.println(dtf.format(now)); 
//               String start = dtm.getValueAt(index, 3).toString();
            String start = "2021-05-06";
             String end ="2021-05-06";
                 Date Sdate1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(start); 
                Date Edate1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(end); 
              long diff =  (Edate1.getTime()-Sdate1.getTime()) ;
                long diffSeconds = diff / 1000 % 60;  
            long diffMinutes = diff / (60 * 1000) % 60; 
            long diffHours = diff / (60 * 60 * 1000);
                 System.out.println(diffSeconds);
                 System.out.println(diffMinutes);
                 System.out.println(diffHours);
                
    }
}
