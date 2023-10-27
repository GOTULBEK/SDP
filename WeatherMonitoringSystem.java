import java.util.ArrayList;
import java.util.List;
import java.util.EventListener;
import java.util.EventObject;

// Step 1: Create a custom event class
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

// Step 2: Define a custom listener interface
interface WeatherDataListener extends EventListener {
    void onWeatherDataChanged(WeatherDataEvent event);
}

// Step 3: Create a class that generates weather data events
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

        // Notify all registered listeners
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

// Step 4: Create display modules that implement the listener interface
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

        // Register the display modules as listeners
        weatherStation.addListener(tempDisplay);
        weatherStation.addListener(humidityDisplay);

        // Simulate weather data changes
        weatherStation.setWeatherData(25.5, 65.2);

        // Unregister the temperature display
        weatherStation.removeListener(tempDisplay);

        // Simulate weather data changes again (only humidity display will be updated)
        weatherStation.setWeatherData(27.0, 70.5);
    }
}
