import java.util.Scanner;

public class Parallelogram {
  private double side1;
  private double side2;
  private double angle1;
  private double angle2;
  private double diagonal1;
  private double diagonal2;
  private double interAngle;
  private double area;
  private final Scanner sc = new Scanner(System.in);
  private static int count;
  private static final int LIMIT = 100;

  /**
   * The number of instances of the Parallelogram Class up to this instance.
   */
  public int instanceNumber;

  /**
   * This constructor creates a Parallelogram Instance based on two double values indicating the side lengths and one double value indicating one angle size.
   * <p>
   * This constructor is private and is used by the method getInstance to create a instance of the class Parallelogram with the parameter values indicating two sides and one angle. If the member variables are set with no value that is out of bounds, the constructor will print out the information of the class, such as which number instance it was.
   * 
   * @param side1 Value of the length of one side of a parallelogram.
   * @param side2 Value of the length of another side of a parallelogram.
   * @param angle1 Value of the size of one angle of a parallelogram.
   */
  private Parallelogram(double side1, double side2, double angle1) {
    angle1 = Math.toRadians(angle1);

    setSides(side1, side2);
    setAngle1(angle1);
    calculate();

    System.out.println(toString());
  }

  /**
   * This constructor generates a deep copy of another Parallelogram instance by getting the other instance as an argument.
   * 
   * @param other A Parallelogram instance that is already created prior to the calling of method getInstance with the Parallelogram-type parameter.
   */
  private Parallelogram(Parallelogram other) {
    setSides(other.getSide1(), other.getSide2());
    setAngles(other.getAngle1(), other.getAngle2());
    calculate();

    System.out.println(toString());
  }

  /**
   * Method to create Parallelogram instance with two side length values and one angle size value.
   * <p>
   * This public method creates a Parallelogram instance if the number of instances already created doesn't exceed the limit value.
   * If the number of instances exceeds the limit, the constructor will return null to the calling method or class.
   * 
   * @param s1 Value of the length of one side of a parallelogram to be passed to the private constructor.
   * @param s2 Value of the length of another side of a parallelogram to be passed to the private constructor.
   * @param a1 Value of the size of one angle of a parallelogram to be passed to the private constructor.
   * @return parallelogram Returns the successfully created Parallelogram instance.
   */
  public static synchronized Parallelogram getInstance(double s1, double s2, double a1) {
    if (count < LIMIT) {
      count++;
      Parallelogram parallelogram = new Parallelogram(s1, s2, a1);
      parallelogram.instanceNumber = count;
      return parallelogram;
    }
    return null;
  }

  /**
   * Method to create Parallelogram instance with a pre-created Parallelogram instance.
   * <p>
   * This public method creates a Parallelogram instance if the number of instances already created doesn't exceed the limit value.
   * If the number of instances exceeds the limit, the constructor will return null to the calling method or class.
   * 
   * @param other A pre-created Parallelogram instance to be passed to the private constructor
   * @return parallelogram Returns the successfully created Parallelogram instance.
   */
  public static synchronized Parallelogram getInstance(Parallelogram other) {
    if (count < LIMIT) {
      count++;
      Parallelogram parallelogram = new Parallelogram(other);
      parallelogram.instanceNumber = count;
      return parallelogram;
    }
    return null;
  }
  
  /**
   * Method used to get the two side lengths in a form of a double-type array.
   * @return sidesArray Returns a double-type array with each side length as elements.
   */
  public double[] getSides() {
    return new double[]{this.side1, this.side2};
  }

  /**
   * Method used to get the two angle sizes in a form of a double-type array.
   * @return anglesArray Returns a double-type array with each angle size as elements.
   */
  public double[] getAngles() {
    return new double[]{this.angle1, this.angle2};
  }

  /**
   * Method used to get the length of the first diagonal line as a double value.
   * @return diagonal Returns the value of the instance variable "diagonal".
   */
  public double getDiagonal1() {
    return this.diagonal1;
  }

  /**
   * Method used to get the length of the second diagonal line as a double value.
   * @return diagonal Returns the value of the instance variable "diagonal".
   */
  public double getDiagonal2() {
    return this.diagonal2;
  }

  /**
   * Method used to get the size of the intersecting angle created by the two diagonals as a double value.
   * @return interAngle Returns the value of the instance variable "interAngle".
   */
  public double getInterAngle() {
    return this.interAngle;
  }

  /**
   * Method used to get the area of the parallelogram created as a double value.
   * @return area Returns the value of the instance variable "area".
   */
  public double getArea() {
    return this.area;
  }

  /**
   * Method used to get the length of the first side set by the constructor as a double value.
   * @return side1 Returns the value of the instance variable "side1".
   */
  public double getSide1() {
    return this.side1;
  }

  /**
   * Method used to get the length of the second side set by the constructor as a double value.
   * @return side2 Returns the value of the instance variable "side2".
   */
  public double getSide2() {
    return this.side2;
  }

  /**
   * Method used to get the size of the angle set by the constructor as a double value.
   * @return angle1 Returns the value of the instance variable "angle1"
   */
  public double getAngle1() {
    return Math.toDegrees(this.angle1);
  }

  /**
   * Method used to get the size of the suplement angle to angle set by the constructor as a double value.
   * @return angle2 Returns the value of the instance variable "angle2"
   */
  public double getAngle2() {
    return Math.toDegrees(this.angle2);
  }

  /**
   * Method used to set the length of the two sides of the Parallelogram instance.
   * <p>
   * This method only changes the value of the two sides and does not update the remaining values accordingly. The public method calculate() must be called following this method in order for the Parallelogram to be properly updated.
   * @param s1 Value of the side s1
   * @param s2 Value of the side s2
   */
  public void setSides(double s1, double s2) {
    while (s1 <= 0.0) {
      System.out.println("Length of Side1 out of bounds : Negative Double\nPlease Enter New Positive Double Value");
      s1 = sc.nextDouble();
    }

    while (s2 <= 0.0) {
      System.out.println("Length of Side2 out of bounds : Negative Double\nPlease Enter New Positive Double Value");
      s2 = sc.nextDouble();
    }

    this.side1 = s1;
    this.side2 = s2;
  }

  /**
   * Method used to set the length of the first side of the Parallelogram instance.
   * <p>
   * This method only changes the value of the one of the sides and does not update the remaining values accordingly. The public method calculate() must be called following this method in order for the Parallelogram to be properly updated.
   * @param s1 Length of the side s1
   */
  public void setSide1(double s1) {
    while (s1 <= 0.0) {
      System.out.println("Length of Side1 out of bounds : Negative Double\nPlease Enter New Positive Double Value");
      s1 = sc.nextDouble();
    }

    this.side1 = s1;
  }

  /**
   * Method used to set the length of the second side of the Parallelogram instance.
   * <p>
   * This method only changes the value of the one of the sides and does not update the remaining values accordingly. The public method calculate() must be called following this method in order for the Parallelogram to be properly updated.
   * @param s2 Length of the side s2
   */
  public void setSide2(double s2) {
    while (s2 <= 0.0) {
      System.out.println("Length of Side2 out of bounds : Negative Double\nPlease Enter New Positive Double Value");
      s2 = sc.nextDouble();
    }
    
    this.side2 = s2;
  }

  /**
   * Method used to set the size of the two angles of the Parallelogram instance.
   * <p>
   * This method only changes the value of the two angles and does not update the remaining values accordingly. The public method calculate() must be called following this method in order for the Parallelogram to be properly updated.
   * @param a1 Value of the angle a1
   * @param a2 Value of the angle a2
   */
  public void setAngles(double a1, double a2) {
    while (a1 <= 0.0 || a1 >= 180) {
      System.out.println("Degree of Angle1 out of bounds\nPlease Enter New Fit Double Degree Value");
      a1 = sc.nextDouble();
    }

    while (a2 <= 0.0 || a2 >= 180) {
      System.out.println("Degree of Angle2 out of bounds\nPlease Enter New Fit Double Degree Value");
      a2 = sc.nextDouble();
    }

    this.angle1 = Math.toRadians(a1);
    this.angle2 = Math.toRadians(a2);
  }

    /**
   * Method used to set the size of the first angle of the Parallelogram instance.
   * <p>
   * This method only changes the value of the two angles and does not update the remaining values accordingly. The public method calculate() must be called following this method in order for the Parallelogram to be properly updated.
   * @param a1 Value of the angle a1
   */
  public void setAngle1(double a1) {
    while (a1 <= 0.0 || a1 >= 180) {
      System.out.println("Degree of Angle1 out of bounds\nPlease Enter New Fit Double Degree Value");
      a1 = sc.nextDouble();
    }

    this.angle1 = Math.toRadians(a1);
    this.angle2 = Math.PI - Math.toRadians(a1);
  }

    /**
   * Method used to set the length of the second side of the Parallelogram instance.
   * <p>
   * This method only changes the value of the two angles and does not update the remaining values accordingly. The public method calculate() must be called following this method in order for the Parallelogram to be properly updated.
   * @param a2 Value of the angle a2
   */
  public void setAngle2(double a2) {
    while (a2 <= 0.0 || a2 >= 180) {
      System.out.println("Degree of Angle2 out of bounds\nPlease Enter New Fit Double Degree Value");
      a2 = sc.nextDouble();
    }

    this.angle1 = Math.PI - Math.toRadians(a2);
    this.angle2 = Math.toRadians(a2);
  }

  private void setDiagonal1(double d) {
    this.diagonal1 = d;
  }

  private void setDiagonal2(double d) {
    this.diagonal2 = d;
  }

  private void setInterAngle(double iA) {
    this.interAngle = iA;
  }

  private void setArea(double a) {
    this.area = a;
  }

  /**
   * Method used to get the information of the Parallelogram instance.
  */
  public String toString() {
    String info = "This is the " + count + ((count%10==1 && count/10!=1) ? "st instance of the Parallelogram Class." : (count%10==2 && count/10!=1) ? "nd instance of the Parallelogram Class." : (count%10==3 && count/10!=1) ? "rd instance of the Parallelogram Class." : "th instance of the Parallelogram Class.")+(count==LIMIT ? " This is the last possible instance for the Parallelogram Class." : "");

    return info;
  }

  /**
   * Method used to calculate the value of the length of the diagonal, the area, and the size of the intersecting angle of the parallelogram.
   * <p>
   * This method must be called after every set method that is called after the creation of an instance.
   * The calculate() method does not take in any arguments and only sets or updates the private instances' values.
   */
  public void calculate() {
    setDiagonal1(Math.sqrt(side1*side1+side2*side2-2.0*side1*side2*Math.cos(angle1)));
    setDiagonal2(Math.sqrt(side1*side1+side2*side2-2.0*side1*side2*Math.cos(angle2)));
    setAngle2(Math.PI - angle1);
    setArea(Math.sin(angle1)*side1*side2);
    setInterAngle(Math.asin(this.area*2.0/(diagonal1*diagonal2)));
  }
}