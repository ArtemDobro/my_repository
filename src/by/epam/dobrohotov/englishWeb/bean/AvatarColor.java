package by.epam.dobrohotov.englishWeb.bean;

import java.util.HashMap;
import java.util.Objects;

public class AvatarColor extends Purchase {

  private HashMap<String, Integer> colorsToCost;

  public AvatarColor(HashMap<String, Integer> colorsToCost) {
    this.colorsToCost = colorsToCost;
  }

  @Override
  public boolean equals(Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
    AvatarColor that = (AvatarColor) o;
    return Objects.equals(colorsToCost, that.colorsToCost);
  }

  @Override
  public int hashCode() {
    return Objects.hash(colorsToCost);
  }

  @Override
  public String toString() {
    return "AvatarColor{" +
        "colorsToCost=" + colorsToCost +
        '}';
  }

  public HashMap<String, Integer> getColorsToCost() {
    return colorsToCost;
  }

  public void setColorsToCost(HashMap<String, Integer> colorsToCost) {
    this.colorsToCost = colorsToCost;
  }
}
