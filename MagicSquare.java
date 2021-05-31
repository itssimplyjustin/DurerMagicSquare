import java.util.*;
public class MagicSquare {
	
	private int size = 0;
	private int rowSum = 0;
	private int colSum = 0;
	private int sum = 0;
	private int sum2 = 0;
	private int[][] arr;
	private int cornerSum;
	private int centerSum;
	private int topBottomCenterColSum;
	private int leftRightCenterRowSum;
	private int clockwiseSum;

	
	public MagicSquare(int size) {
			Scanner sc = new Scanner(System.in);
			int[][] square = new int[size][size];
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {
					System.out.println("Enter a number for row " + (i+1) + " , column " + (j+1) + ": ");
					square[i][j] = sc.nextInt();
					
				}
			}
			arr = square;
			this.size = size;
	}

	public boolean isMagic() {
		// calculate the sum of 
        // the diagonal 
        int sum = 0; 
        for (int i = 0; i < size; i++) {
            sum = sum + arr[i][i]; 
        }
        int sum2 = 0; 
        for (int i = 0; i > size; i--) {
            sum2 = sum2 + arr[size][size]; 
        }
        // For sums of Rows 
        for (int i = 0; i < size; i++) { 
  
            int rowSum = 0; 
            for (int j = 0; j < size; j++) 
                rowSum += arr[i][j]; 
  
            // check if every row sum is 
            // equal to diagonal sum 
            this.rowSum = rowSum;
            if (rowSum != sum) 
                return false; 
        } 
  
        // For sums of Columns 
        for (int i = 0; i < size; i++) { 
  
            int colSum = 0; 
            for (int j = 0; j < size; j++) 
                colSum += arr[j][i]; 
  
            // check if every column sum is 
            // equal to diagonal sum
            this.colSum = colSum;
            if (sum != colSum) 
                return false; 
        }
        this.sum = sum;
        //return true;   
        if(valuesCheck() == true){
        	return true;
        }
        return false;
		//- returns true if the 2-dim array is a magic square
	}
	
	public boolean isA4x4Durer(){
		//– returns true if it isMagic() and it holds properties of a Dürer magic square. It should verify that the array is a 4 x 4 array.

		
		if(size == 4 && isMagic() == true){
			if(cornerSum() == rowSum() && cornerSum() == colSum() && cornerSum() == sum){
				if(centerSum() == rowSum() && centerSum() == colSum() && centerSum() == sum){
					if(topBottomCenterColSum() == rowSum() && topBottomCenterColSum == colSum() && centerSum == sum) {
						if(leftRightCenterRowSum() == rowSum() && leftRightCenterRowSum == colSum() && leftRightCenterRowSum == sum) {
							if(clockwiseSum() == rowSum() && clockwiseSum() == colSum() && clockwiseSum() == sum){
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}
	private int cornerSum() {
		int cornerSum = (arr[0][0] + arr[size-1][0] + arr[size-1][size-1] + arr[0][size-1]);
		this.cornerSum = cornerSum;
		return cornerSum;
		//– returns the sum of the corners of the 2-dim array
	}
	private int centerSum() {
		int centerSum = (arr[0][0] + arr[size-1][0] + arr[size-1][size-1] + arr[0][size-1]);
		this.centerSum = centerSum;
		return centerSum;
		//– returns the sum of the 4 inner cells of the 2-dim array
	}
	private int colSum() {
		return colSum;
		//– returns the sum of column c
	}
	private int rowSum () {
		return rowSum;
		//– returns the sum of column r
	}
	private int diag1() {
		return sum;
		//– returns the sum of upper-left to lower-right diagonal
	}
	private int diag2() {
		return sum2;
		//– returns the sum of lower-left to upper-right diagonal
	}
	private boolean valuesCheck() {
		int s2 = (size * size);
		ArrayList <Integer> ints = new ArrayList();
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				ints.add(arr[i][j]);
			}
		}
		for (int row = 0; row < arr.length; row++)
	    {
	        for (int col = 0; col < arr[row].length; col++)
	        {
	            int num = arr[row][col];
	            for (int otherCol = col + 1; otherCol < arr.length; otherCol++)
	            {
	                if (num == arr[row][otherCol])
	                {
	                    return false;
	                }
	            }
	        }
	    }

	    return true;
		//– each number is between 1 and s^2
		
	}
	private int topBottomCenterColSum() {
		int topBottomCenterColSum = (arr[0][1] + arr[0][2] + arr[size-1][1] + arr[size-1][2]);
		this.topBottomCenterColSum = topBottomCenterColSum;
		return topBottomCenterColSum;
		//returns the sum of the values indicated below
	}
	private int leftRightCenterRowSum() {
		int leftRightCenterRowSum = (arr[1][0] + arr[2][0] + arr[1][size-1] + arr[2][size-1]);
		this.leftRightCenterRowSum = leftRightCenterRowSum;
		return leftRightCenterRowSum;
		//– returns the sum of the values indicated
	}
//	
	private int clockwiseSum() {
		int clockwiseSum = (arr[0][1] + arr[1][size-1] + arr[size-1][2] + arr[2][0]);
		this.clockwiseSum = clockwiseSum;
		return clockwiseSum;
		//– compares the sum of the values of the four cells
	}
	public String toString() {
		String aString = "";
		  for(int row = 0; row < arr.length; row++) {
		     for(int col = 0; col < arr[row].length; col++) {
		        aString += " " + arr[row][col];
		     }
		  }
		  return aString;
		//- displays the contents of 2-dim array in grid format
	}
	
	}

