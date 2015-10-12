import java.io.*;

public class Determinant
{
  public static void main(String[] args)
  {
    BufferedReader input = null;

    try
    {
      if(args.length != 1)
        throw new ArrayIndexOutOfBoundsException("Give exactly one argument representing the file Matrix to be read");

      //read the first line to calculate the dimensions of the matrix
      //we assume it is a square matrix and that user input is valid
      input = new BufferedReader(new FileReader(args[0]));
      int matrixDimension = input.readLine().split(" ").length;
     
      //reset input reader because a line has already been read
      input = new BufferedReader(new FileReader(args[0]));
      double[][] matrixEntries = new double[matrixDimension][matrixDimension];
      
      //copy values from file to a double array
      for(int row = 0; row < matrixDimension; row++)
        matrixEntries[row] = toDoubleArray(input.readLine().split(" "));

      //print the determinant and the matrix itself
      SquareMatrix matrix = new SquareMatrix(matrixEntries);
      //System.out.println("Matrix \n" + matrix + "\nhas determinant : " + matrix.getDeterminant());
    }
    catch(IOException exception)
    { System.err.println(exception); }
    finally
    {
      try { if(input != null) input.close(); }
      catch(Exception e) { System.err.println(e); }
    }//finally
  }//main

  //convert array of Strings to array of doubles
  public static double[] toDoubleArray(String[] stringArray)
  {
    double[] returnedIntArray = new double[stringArray.length];

    for(int i = 0; i < stringArray.length; i++)
      returnedIntArray[i] = Double.parseDouble(stringArray[i]);

    return returnedIntArray;
  }//toDoubleArray

}//class
