import cars.types.Type;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
  public static void main(String[] args) {
    System.out.println("Available number of cores: " + Runtime.getRuntime().availableProcessors());

    WaitingArea waitingArea = new WaitingArea();

    CarGenerator carGenerator = new CarGenerator(waitingArea, 20);

    Ferry ferry1 = new Ferry(waitingArea, Type.PASSENGER_CAR);
    Ferry ferry2 = new Ferry(waitingArea, Type.TRUCK);

    ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    service.execute(carGenerator);
    service.execute(ferry1);
    service.execute(ferry2);

    service.shutdown();
  }
}
