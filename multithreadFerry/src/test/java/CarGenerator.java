import cars.Car;
import cars.types.Size;
import cars.types.Type;
import java.util.Random;

public class CarGenerator implements Runnable {

  private WaitingArea waitingArea;
  private int carCount;

  public CarGenerator(WaitingArea waitingArea, int carCount) {
    this.waitingArea = waitingArea;
    this.carCount = carCount;
  }

  @Override
  public void run() {
    int count = 0;
    while (count < carCount) {
      count++;
      Thread.currentThread().setName(" Generator car number " + count);
      waitingArea.add(new Car(getRandomSize(), getRandomType()));
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    }
  }

  private Type getRandomType() {
    Random random = new Random();
    return Type.values()[random.nextInt(Type.values().length)];
  }

  private Size getRandomSize() {
    Random random = new Random();
    return Size.values()[random.nextInt(Size.values().length)];
  }
}
