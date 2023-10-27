import java.util.ArrayList;
import java.util.List;
import java.util.EventListener;
import java.util.EventObject;

//create WeatherDataEvent class that extends EventObject
class WeatherDataEvent extends EventObject {
    private double temperature;
    private double humidity;

    public WeatherDataEvent(Object source, double temperature, double humidity) {
        super(source);
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }
}

// create listener
interface WeatherDataListener extends EventListener {
    void onWeatherDataChanged(WeatherDataEvent event);
}

// class that generate wether
class WeatherStation {
    private List<WeatherDataListener> listeners = new ArrayList<>();
    private double temperature;
    private double humidity;

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setWeatherData(double temperature, double humidity) {
        this.temperature = temperature;
        this.humidity = humidity;

        // send notification to all listeners
        WeatherDataEvent event = new WeatherDataEvent(this, temperature, humidity);
        for (WeatherDataListener listener : listeners) {
            listener.onWeatherDataChanged(event);
        }
    }

    public void addListener(WeatherDataListener listener) {
        listeners.add(listener);
    }

    public void removeListener(WeatherDataListener listener) {
        listeners.remove(listener);
    }
}

// print the temperature for listeners
class TemperatureDisplay implements WeatherDataListener {
    @Override
    public void onWeatherDataChanged(WeatherDataEvent event) {
        System.out.println("Temperature Display: Temperature is " + event.getTemperature() + "°C");
    }
}

class HumidityDisplay implements WeatherDataListener {
    @Override
    public void onWeatherDataChanged(WeatherDataEvent event) {
        System.out.println("Humidity Display: Humidity is " + event.getHumidity() + "%");
    }
}

public class WeatherMonitoringSystem {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        TemperatureDisplay tempDisplay = new TemperatureDisplay();
        HumidityDisplay humidityDisplay = new HumidityDisplay();

        // add listeners to display
        weatherStation.addListener(tempDisplay);
        weatherStation.addListener(humidityDisplay);

        // set a weather data
        weatherStation.setWeatherData(25.5, 65.2);

        // remove listeners
        weatherStation.removeListener(tempDisplay);

        // set weather data again
        weatherStation.setWeatherData(27.0, 70.5);
    }
}
