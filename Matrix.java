public class Matrix implements Comparable<Matrix>
{
  private double[][] entries;
  private int rows, cols;

  public Matrix(double[][] givenEntries)
  {
    entries = givenEntries;
    rows = givenEntries.length;
    cols = givenEntries[0].length;
  }//constructor

  public int getRows()
  {
    return rows;
  }//getRows
 
  public int getCols()
  {
    return cols;
  }//getCols

  public int getAmountOfElements()
  {
    return rows * cols;
  }//getAmountOfElements

  //Accessor method for the matrix entries
  public double getEntry(int x, int y)
  {
    return entries[x][y];
  }//getEntry

  public Matrix multiply(double k)
  {
    double[][] multMatrix = new double[rows][cols];

    for(int row = 0; row < this.rows; row++)
      for(int col = 0; col < this.cols; col++)
        multMatrix[row][col] = entries[row][col] * k;

    return new Matrix(multMatrix);
  }//multiply

  public Matrix multiply(Matrix other)
  {
    if(this.cols != other.getRows())
      return null;

    double[][] resultingMatrix = new double[this.rows][other.getCols()];

    for(int row = 0; row < this.rows; row++)
      for(int colCounter = 0; colCounter < other.getCols(); colCounter++)
        for(int col = 0; col < this.cols; col++)
          resultingMatrix[row][colCounter] += entries[row][col] * other.getEntry(col,colCounter);

    return new Matrix(resultingMatrix);
  }//multiply

  public Matrix add(Matrix other)
  {
    if(this.rows != other.getRows() || this.cols != other.getCols())
      return null;

    double[][] sumMatrix = new double[rows][cols];

    for(int row = 0; row < this.rows; row++)
      for(int col = 0; col < this.cols; col++)
        sumMatrix[row][col] = entries[row][col] + other.getEntry(row,col);

    return new Matrix(sumMatrix);
  }//add

  public Matrix subtract(Matrix other)
  {
    if(this.rows != other.getRows() || this.cols != other.getCols())
      return null;

    double[][] subMatrix = new double[rows][cols];

    for(int row = 0; row < this.rows; row++)
      for(int col = 0; col < this.cols; col++)
        subMatrix[row][col] = entries[row][col] - other.getEntry(row,col);

    return new Matrix(subMatrix);
  }//subtract

  public boolean isZeroMatrix()
  {
    for(int row = 0; row < this.rows; row++)
      for(int col = 0; col < this.cols; col++)
        if(entries[row][col] != 0)
          return false;

    return true;
  }//isZeroMatrix

  public boolean isIdentityMatrix()
  {
    if(rows == cols)
    {
      for(int row = 0; row < this.rows; row++)
        for(int col = 0; col < this.cols; col++)
        {
          if(row == col)
          {
            if(entries[row][col] != 1)
              return false;
          }
          else
            if(entries[row][col] != 0)
              return false;
        }//for
      return true;
    }
    else
      return false;
  }//isIdentityMatrix

  public boolean isInverseOf(Matrix other)
  {
    return this.multiply(other).isIdentityMatrix();
  }//isInverseOf

  @Override
  public int compareTo(Matrix other)
  {
    if(this.rows > ((Matrix)other).getRows())
      return 1;
    else if(this.rows == ((Matrix)other).getRows())
    {
      if(this.cols > ((Matrix)other).getCols())
        return 1;
      else
        return -1;
    }//else if
    else
      return -1;
  }//compareTo

  @Override
  public boolean equals(Object other)
  {
    if(other instanceof Matrix)
    {
      if(rows != ((Matrix)other).getRows() || cols != ((Matrix)other).getCols())
        return false;

      for(int row = 0; row < this.rows; row++)
        for(int col = 0; col < this.cols; col++)
          if(entries[row][col] != ((Matrix)other).getEntry(row,col))
            return false;

      return true;
    }
    else
      return super.equals(other);
  }//equals

  @Override
  public String toString()
  {
    String stringToReturn = "";

    for(int row = 0; row < this.rows; row++)
    {
      for(int col = 0; col < this.cols; col++)
        stringToReturn += entries[row][col] + " ";

      stringToReturn += "\n";
    }//for
  
    return stringToReturn;
  }//toString
}//class
