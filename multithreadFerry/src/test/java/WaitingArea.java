import cars.Car;
import cars.types.Type;
import java.util.ArrayList;
import java.util.List;

public class WaitingArea {

  private List<Car> store;
  private static final int maxCarsInQueue = 5;
  private static final int minCarsInQueue = 0;
  private int carsCounter = 0;


  public WaitingArea() {
    store = new ArrayList<>();
  }

  public synchronized boolean add(Car element) {

    try {
      if (carsCounter < maxCarsInQueue) {
        notifyAll();
        store.add(element);
        String info = String.format("%s + The car arrived in the waiting area: %s %s %s",
            store.size(),
            element.getType(), element.getSize(), Thread.currentThread().getName());
        System.out.println(info);
        carsCounter++;

      } else {
        System.out.println(
            store.size() + "> There is no place for a car in the waiting area: "
                + Thread.currentThread()
                .getName());
        wait();
        return false;
      }

    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return true;
  }

  public synchronized Car get(Type carType) {

    try {
      if (carsCounter > minCarsInQueue) {
        notifyAll();
        for (Car ship : store) {
          if (ship.getType() == carType) {
            carsCounter--;
            System.out.println(
                store.size() + "- The car is taken from the waiting area: " + Thread.currentThread()
                    .getName());
            store.remove(ship);
            return ship;
          }
        }
      }

      System.out.println("0 < There are no cars in the waiting area");
      wait();

    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return null;
  }


}
