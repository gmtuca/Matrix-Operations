public class Point3D
{
  private double x, y, z;

  public Point3D(double givenX, double givenY)
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

  public double getZ()
  {
    return z;
  }//getY

  public Matrix toMatrix()
  {
    return new Matrix(new double[][]{{x},{y},{z},{1.0}});
  }//toMatrix

  public double distanceFrom(Point3D other)
  {
    return Math.sqrt(Math.pow(x - other.getX(), 2) + Math.pow(y - other.getY(), 2) + Math.pow(z - other.getZ(), 2));
  }//distanceFrom

  @Override
  public String toString()
  {
    return "(" + x + "," + y + "," + z + ")";
  }//toString
}//class
