import java.io.*;

public class Operation
{
  public static void main(String[] args)
  {
    BufferedReader input1 = null;
    BufferedReader input2 = null;

    try
    {
      if(args.length != 2)
        throw new ArrayIndexOutOfBoundsException("Give exactly 2 arguments representing the file Matrices to be read");

      /////////////////////////////////////////////////////////////////////////
      //first matrix
      input1 = new BufferedReader(new FileReader(args[0]));
      int matrixCols1 = input1.readLine().split(" ").length;

      int matrixRows1 = 1;
      while(input1.readLine() != null){ matrixRows1++; };

      input1 = new BufferedReader(new FileReader(args[0]));
      double[][] matrixEntries1 = new double[matrixRows1][matrixCols1];

      for(int row = 0; row < matrixRows1; row++)
        matrixEntries1[row] = toDoubleArray(input1.readLine().split(" "));

      Matrix firstMatrix = new Matrix(matrixEntries1);
      /////////////////////////////////////////////////////////////////////////
      //second matrix
      input2 = new BufferedReader(new FileReader(args[1]));
      int matrixCols2 = input2.readLine().split(" ").length;

      int matrixRows2 = 1;
      while(input2.readLine() != null){ matrixRows2++; };

      input2 = new BufferedReader(new FileReader(args[1]));
      double[][] matrixEntries2 = new double[matrixRows2][matrixCols2];

      for(int row = 0; row < matrixRows2; row++)
        matrixEntries2[row] = toDoubleArray(input2.readLine().split(" "));

      Matrix secondMatrix = new Matrix(matrixEntries2);
      ////////////////////////////////////////////////////////////////////////

      //System.out.println("MATRIX\n\n" + firstMatrix + "\nADDED TO\n\n" + secondMatrix + "\nGIVES\n\n" + firstMatrix.add(secondMatrix));
      //System.out.println("MATRIX\n\n" + firstMatrix + "\nSUBTRACTING\n\n" + secondMatrix + "\nGIVES\n\n" + firstMatrix.subtract(secondMatrix));
      //int k = 5;
      //System.out.println("MATRIX\n\n" + firstMatrix + "\nMULTIPLIED BY SCALAR\n\n" + k + "\n\nGIVES\n\n" + firstMatrix.multiply(k));
      //System.out.println("MATRIX\n\n" + firstMatrix + "\nMULTIPLIED BY MATRIX\n\n" + secondMatrix + "\n\nGIVES\n\n" + firstMatrix.multiply(secondMatrix));
      //System.out.println("MATRIX\n\n" + firstMatrix + "\nAND MATRIX\n\n" + secondMatrix + "\nare" + (firstMatrix.equals(secondMatrix) ? "" : " NOT ") + " equal");
      System.out.println("MATRIX\n\n" + firstMatrix + "\nis" + (firstMatrix.isIdentityMatrix() ? "" : " NOT ") + "an identity matrix");
    }//try
    catch(IOException exception)
    { System.err.println(exception); }
    finally
    {
      try{ if(input1 != null) input1.close();  if(input2 != null) input2.close(); }
      catch(Exception ex) { System.err.print(ex); }
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
