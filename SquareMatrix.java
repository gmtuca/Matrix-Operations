public class SquareMatrix extends Matrix
{
  private int dimension;

  public SquareMatrix(double[][] givenEntries)
  {
    super(givenEntries);
    dimension = getRows();
  }//constructor

  public int getDimension()
  {
    return dimension;
  }//getDimension

  //Recursive algorithm to retrieve the determinant of a square matrix. 
  public double getDeterminant()
  {
    if(dimension < 1) // Invalid!
      return -1; 
    else if(dimension == 1) // BASE CASE: 1x1 matrix.
      return getEntry(0,0);
    else if(dimension == 2) // BASE CASE: 2x2 matrix. detM = ad - bc
      return getEntry(0,0) * getEntry(1,1) - getEntry(0,1) * getEntry(1,0);
    else // RECURSIVE CALL
    {
      double sigma = 0;

      //calculate determinant of an nxn matrix
      for(int n = 0; n < dimension; n++)
      {
        double x = getEntry(0,n) * SquareMatrix.cutRowCol(this,0,n).getDeterminant();

        //Alternate between + and -
        sigma += (n % 2 == 0 ? -x : x);
      }//for

      return sigma;
    }//else    
  }//getDeterminant

  //Class method used to generate a (n - 1)x(n - 1) matrix
  //by throwing away a specific row and a specific column
  public static SquareMatrix cutRowCol(SquareMatrix matrixToCut, int rowToCut, int colToCut)
  {
    int x = matrixToCut.getRows();
    int y = matrixToCut.getCols();
    double[][] cuttedMatrixEntries = new double[x - 1][y - 1];

    int rowAdjustment = 0;

    for(int row = 0; row < x; row++)
    {
      int colAdjustment = 0;

      for(int col = 0; col < y; col++)
      {
        if(row == rowToCut)
        {
          rowAdjustment++;
          break;
        }//if

        if(col != colToCut)
          cuttedMatrixEntries[row - rowAdjustment][col - colAdjustment] = matrixToCut.getEntry(row,col);
        else
          colAdjustment++;
      }//for
    }//for

   return new SquareMatrix(cuttedMatrixEntries);
  }//cutRowCol

}//class
