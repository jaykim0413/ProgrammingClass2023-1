public class ParallelogramTest {
  public static void main(String[] args) {
    Parallelogram p1 = Parallelogram.getInstance(3, 6, 50);
    Parallelogram pTest = Parallelogram.getInstance(4, 2, 170);
    Parallelogram p2 = Parallelogram.getInstance(pTest);

    System.out.println("\n");

    printArray(p1.getSides());
    printArray(p1.getAngles());
    System.out.println("Area: "+p1.getArea()+"\nDiagonal Length: "+p1.getDiagonal()+"\nInterAngle: "+p1.getInterAngle()+"\nInstane Number: "+p1.instanceNumber+"\n");

    printArray(p2.getSides());
    printArray(p2.getAngles());
    System.out.println("Area: "+p2.getArea()+"\nDiagonal Length: "+p2.getDiagonal()+"\nInterAngle: "+p2.getInterAngle()+"\nInstance Number: "+p2.instanceNumber+"\n");
  }

  public static void printArray(double[] arr) {
    for (double d : arr) {
      System.out.print(d+" ");
    }
    System.out.println("\n");
  }
}
