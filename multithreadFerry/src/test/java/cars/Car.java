package cars;

import cars.types.Size;
import cars.types.Type;

public class Car {

  private int weight;
  private Size size;
  private Type type;


  public Car(Size size, Type type) {
    this.size = size;
    this.type = type;
  }


  public void add(int count) {
    this.weight += count;
  }

  public boolean countCheck() {
    if (weight >= size.getValue()) {
      return false;
    }
    return true;
  }

  public int getWeight() {
    return weight;
  }

  public Type getType() {
    return type;
  }

  public Size getSize() {
    return size;
  }

}
