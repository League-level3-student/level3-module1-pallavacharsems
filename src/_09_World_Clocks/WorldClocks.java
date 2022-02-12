package _09_World_Clocks;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

/*
 * You task is to create a java program that:
 * 1. Displays the time for multiple cities around the world on one display.
 * 2. Gives the user the ability to add a city to the display. One possible
 *    way to do this is to create a HashMap of city names and their
 *    corresponding time zones, e.g. HashMap<String, TimeZone>, then use each
 *    city's TimeZone to get the current date/time every second using a
 *    Timer object (see example code below).
 * 
 * The code below is an example of how to print out a clock for San Diego.
 * Use the ClockUtilities class to find the time zone of each city, then use
 * Calendar.getInstance to return a Calendar object to get the current time for
 * that city. Example:
 *   TimeZone timeZone = clockUtil.getTimeZoneFromCityName("San Diego, US");
 *   Calendar c = Calendar.getInstance(timeZone);
 *   System.out.println("Full date and time: " + calendar.getTime());
 * 
 * NOTE: The program may take a second or two to execute
 * 
 * Calendar class:
 * https://docs.oracle.com/javase/7/docs/api/java/util/Calendar.html
 */

public class WorldClocks implements ActionListener {
    ClockUtilities clockUtil;
    Timer timer;
    TimeZone timeZone;

    JFrame frame;
    JPanel panel;
    JTextArea textArea;
    JButton button;
    
    HashMap<String, TimeZone> holdTime = new HashMap<String, TimeZone>();
    String city;
    String dateStr;
    String timeStr;
    
    public WorldClocks() {
        clockUtil = new ClockUtilities();

        // The format for the city must be: city, country (all caps)
        city = "Chicago, US";
        timeZone = clockUtil.getTimeZoneFromCityName(city);
        
       
        
        System.out.println(dateStr);

        // Sample starter program
        frame = new JFrame();
        panel = new JPanel();
        textArea = new JTextArea();
        button = new JButton();
        button.addActionListener(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(100, 100);
        frame.add(panel);
        panel.add(textArea);
        panel.add(button);
        textArea.setText(city + "\n" + dateStr);
        button.setText("Type a city for its time zone");
        
        // This Timer object is set to call the actionPerformed() method every
        // 1000 milliseconds
        timer = new Timer(1000, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        if(button == (arg0.getSource())) {
        	String getCity = JOptionPane.showInputDialog("Enter a city, (City, Country). Type the first letters in caps and add a comma in between.");
        	TimeZone time = clockUtil.getTimeZoneFromCityName(getCity);
            holdTime.put(getCity, time);
        	
        }
        dateStr = "";
        timeStr = "";
        String cityInfo = "";
    	for ( String cityName : holdTime.keySet()) {
			TimeZone time = holdTime.get(cityName);
    		Calendar c = Calendar.getInstance(time);
			String militaryTime = c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND);
	        String twelveHourTime = " [" + c.get(Calendar.HOUR) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND) + "]";
	        timeStr = militaryTime + twelveHourTime;
	        
	        String month = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
	        String dayOfWeek = c.getDisplayName( Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
	        dateStr = dayOfWeek + " " + month + " " + c.get(Calendar.DAY_OF_MONTH) + " " + c.get(Calendar.YEAR);
	        cityInfo += cityName + "\n" + dateStr + "\n" + timeStr + "\n";
 	        
		}
    	Calendar c = Calendar.getInstance(timeZone);
        String militaryTime = c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND);
        String twelveHourTime = " [" + c.get(Calendar.HOUR) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND) + "]";
        timeStr = militaryTime + twelveHourTime;
        
   
        String month = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
        String dayOfWeek = c.getDisplayName( Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
        dateStr = dayOfWeek + " " + month + " " + c.get(Calendar.DAY_OF_MONTH) + " " + c.get(Calendar.YEAR);
        
        System.out.println(timeStr);
        cityInfo += city + "\n" + dateStr + "\n" + timeStr + "\n";
        textArea.setText(cityInfo);
        
        
        frame.pack();
    }
}
