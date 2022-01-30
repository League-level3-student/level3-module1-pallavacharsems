package _08_California_Weather;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * OBJECTIVE:
 * 1. Create a program that allows the user to search for the weather
 * conditions of a given city in California. Use the example program below
 * and the Utilities class inside this project to get the temperature data
 * from a day in December 2020.
 * Example: User: Encinitas
 *          Program: Encinitas is Overcast with a tempeature of 59.01 �F
 
 * 2. Create a way for the user to specify the weather condition and then
 * list the cities that have those conditions.
 * Example: User: Mostly Cloudy
 *          Program: Long Beach, Pomona, Oceanside, ...
 * 
 * 3. Create a way for the user to enter a minimum and maximum temperature
 * and then list the cities that have temperatures within that range
 * Example: User: minimum temperature �F = 65.0, max temperature �F = 70.0
 *          Program: Fortana, Glendale, Escondido, Del Mar, ...
 * 
 * EXTRA:
 * Feel free to add pictures for specific weather conditions or a thermometer
 * for the temperature. Also If you want your program to get the current day's
 * temperature, you can get a free API key at: https://openweathermap.org/api
 */

public class CaliforniaWeather implements ActionListener {
	HashMap<String, WeatherData> weatherData = Utilities.getWeatherData();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton FindCond = new JButton();
	JButton FindCity = new JButton();
	JButton tempRange = new JButton();

	void setup() {
		frame.setVisible(true);
		FindCond.addActionListener(this);
		FindCity.addActionListener(this);
		tempRange.addActionListener(this);
		panel.add(FindCond);
		panel.add(FindCity);
		panel.add(tempRange);
		frame.add(panel);
		FindCond.setText("Find the Condition of a City");
		FindCity.setText("Find the cities with the certain condition");
		tempRange.setText("Find cities with the same temperature range");
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	void askWeather() {
		String city = JOptionPane.showInputDialog("Name a california city to get its weather.");
		city = Utilities.capitalizeWords(city);
		WeatherData datum = weatherData.get(city);

		if (datum == null) {
			JOptionPane.showMessageDialog(null, "Unable to find weather data for: " + city);
		} else {
			JOptionPane.showMessageDialog(null,
					city + " is " + datum.weatherSummary + " with a temperature of " + datum.temperatureF + " F");
		}
	}

	void findCondition() {
		String condition = JOptionPane.showInputDialog("Enter a condition to see cities with the same condition");
		condition = Utilities.capitalizeWords(condition);
		for (String city : weatherData.keySet()) {
			WeatherData wd = weatherData.get(city);
			if (wd.weatherSummary.contains(condition)) {
				JOptionPane.showMessageDialog(null, " A city that has a " + condition + " condition is " + city);
			}
		}

	}

	void temperatureRange() {
		String min = JOptionPane.showInputDialog("Enter a minimum temperature for the range!");
		String max = JOptionPane.showInputDialog("Enter a maximum temperature for the range!");
		int mini = Integer.parseInt(min);
		int maxi = Integer.parseInt(max);
		for(String city : weatherData.keySet()) {
			WeatherData wd = weatherData.get(city);
			if(wd.temperatureF>=mini && wd.temperatureF<=maxi) {
				JOptionPane.showMessageDialog(null, "A city that has the temperature range of " + mini + "-" + maxi + " degrees Fahrenheit you chose is " + city);
			}
		}
	}

	void start() {
		HashMap<String, WeatherData> weatherData = Utilities.getWeatherData();

		// All city keys have the first letter capitalized of each word
		String cityName = Utilities.capitalizeWords("National City");
		WeatherData datum = weatherData.get(cityName);

		if (datum == null) {
			System.out.println("Unable to find weather data for: " + cityName);
		} else {
			System.out.println(
					cityName + " is " + datum.weatherSummary + " with a temperature of " + datum.temperatureF + " F");
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource() == FindCond) {
			askWeather();
		}

		if (arg0.getSource() == FindCity) {
			findCondition();
		}
		if (arg0.getSource() == tempRange) {
			temperatureRange();
		}

	}
}
