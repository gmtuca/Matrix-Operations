public class Point2D
{
  private double x, y;

  public Point2D(double givenX, double givenY)
  {
    x = givenX;
    y = givenY;
  }

  public double getX()
  {
    return x;
  }//getX

  public double getY()
  {
    return y;
  }//getY

  public Matrix toMatrix()
  {
    return new Matrix(new double[][]{{x},{y},{1.0}});
  }//toMatrix

  public double distanceFrom(Point2D other)
  {
    return Math.sqrt(Math.pow(x - other.getX(), 2) + Math.pow(y - other.getY(), 2));
  }//distanceFrom

  @Override
  public String toString()
  {
    return "(" + x + "," + y + ")";
  }//toString
}//class
