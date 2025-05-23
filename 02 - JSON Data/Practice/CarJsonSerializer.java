package Day24.Practice;
import com.fasterxml.jackson.databind.ObjectMapper;

class Car {
    public String brand;
    public String model;
    public int year;

    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }
}

public class CarJsonSerializer {
    public static void main(String[] args) throws Exception {
        Car car = new Car("Toyota", "Camry", 2022);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(car);
        System.out.println(json);
    }
}

