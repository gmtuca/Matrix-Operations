public class TestPoint
{
  public static void main(String[] args)
  {
    Point2D point2 = new Point2D(1,2);
    System.out.println(point2.toMatrix());

    Point3D point3 = new Point3D(1,2,3);
    System.out.println(point3.toMatrix());
  }//main
}//class
