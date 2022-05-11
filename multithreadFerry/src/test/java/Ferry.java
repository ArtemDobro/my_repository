import cars.Car;
import cars.types.Type;

public class Ferry implements Runnable {

  private Type carType;
  private WaitingArea waitingArea;

  public Ferry(WaitingArea waitingArea, Type carType) {
    this.waitingArea = waitingArea;
    this.carType = carType;
  }

  @Override
  public void run() {

    while (true) {
      try {
        Thread.currentThread().setName("Loader " + carType);

        //Time to load the goods
        Thread.sleep(500);
        Car car = waitingArea.get(carType);
        if (car != null) {
          while (car.countCheck()) {
            Thread.sleep(100);
            car.add(10);
            System.out.println(
                car.getWeight() + " Loaded car. " + Thread.currentThread().getName());
          }
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

  }
//  private int capacity;
//  private int fullness;
//  private static volatile Ferry instance;
//
//  private Ferry(int capacity) {
//    this.capacity = capacity;
//  }
//
//  public static Ferry getInstance(int value) {
//    Ferry result = instance;
//    if (result != null) {
//      return result;
//    }
//    synchronized (Ferry.class) {
//      if (instance == null) {
//        instance = new Ferry(value);
//      }
//      return instance;
//    }
//  }
}
