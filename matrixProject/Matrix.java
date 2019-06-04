package matrixProject;

import java.util.ArrayList;

public class Matrix {
	private ArrayList< ArrayList<Double> > data;

	/**
	 * empty matrix constructor
	 */
	public Matrix() {
		data = new ArrayList< ArrayList<Double> >();
	}

	/**
	 * 
	 * @param n (number of sides in square matrix)
	 */
	public Matrix(int n) {
		data = new ArrayList< ArrayList<Double> >();
		if(n > 0) {
			for(int i=0; i < n; i++) {
				ArrayList<Double> temp = new ArrayList<Double>();
				for(int k=0; k < n; k++) {
					temp.add(0.0);
				}
				data.add(temp);
			}
		}
	}

	/**
	 * This method has been provided for your convenience
	 * 
	 * assumption values is a valid string
	 * (contains double values separated by space)
	 * For example, "1.5 2.4 5.6 7.1 4 7.8"
	 * 
	 * If the number of items in values is square
	 * of an integer, it creates a square matrix.
	 * For example, "1 2 3 4" would create matrix
	 * 1 2
	 * 3 4
	 * 
	 * If the number of items in values is not square
	 * of an integer, it tries to create a matrix of size
	 * 2 by (values.length/2). If not possible then,
	 * 3 by (values.length/3). If not possible then,
	 * ...
	 * and in the worst case scenario, it creates a matrix
	 * of size values.length by 1
	 * 
	 * For example, "1 2 3 4 5 6" would create matrix
	 * 1 2 3
	 * 4 5 6
	 * 
	 * while "1 2 3 4 5 6 7" would create the matrix
	 * 1
	 * 2
	 * 3
	 * 4
	 * 5
	 * 6
	 * 7
	 * 
	 * @param values
	 */
	public Matrix(String values) {
		String[] s = values.split(" ");
		double[] items = new double[s.length];
		for(int i=0; i < s.length; i++)
			items[i] = Double.parseDouble(s[i]);
		int n = (int)Math.sqrt(items.length);
		int nRows = n;
		int nColumns = n;
		if(n != Math.sqrt(items.length)) {
			for(int i=2; i<= items.length; i++)
				if(items.length % i == 0) {
					nRows = i;
					nColumns = items.length / i;
					break;
				}
		}
		data = new ArrayList< ArrayList<Double> >();
		int m = 0;
		for(int i=0; i < nRows; i++) {
			ArrayList<Double> temp = new ArrayList<Double>();
			for(int k=0; k < nColumns; k++) {
				temp.add(items[m]);
				m++;
			}
			data.add(temp);
		}
	}
	
	/**
	 * 
	 * @param nRows number of rows
	 * @param nCols number of columns
	 */
	public Matrix(int nRows, int nCols) {
		data = new ArrayList< ArrayList<Double> >();
		if(nRows > 0 && nCols > 0) {
			for(int i = 0; i < nRows; i++) {
				ArrayList<Double> temp = new ArrayList<Double>();
				for(int j = 0; j < nCols; j ++) {
					temp.add(0.0);
				}
				data.add(temp);
			}
		}

		//to be completed
	}

	/**
	 * 
	 * @param source whose deep copy must be made
	 */
	public Matrix(Matrix source) {
		data = new ArrayList< ArrayList<Double> >();
		if(source.rowCount() > 0) {
			for(int i=0; i < source.rowCount(); i++) {
				ArrayList<Double> temp = new ArrayList<Double>();
				for(int k=0; k < source.columnCount(); k++) {
					temp.add(source.get(i, k));
				}
				data.add(temp);
			}
		}
	}

	public Double get(int row, int column) {
		if(!isValid(row, column))
			return null;
		return data.get(row).get(column);
	}

	public int rowCount() {
		return data.size();
	}

	public int columnCount() {
		if(data.size() == 0)
			return 0;
		return data.get(0).size();
	}
	
	public boolean isSquare() {
		return rowCount() == columnCount();
	}
	
	public boolean isValid(int row, int column) {
		if(row < 0 || row >= rowCount())
			return false;
		if(column < 0 || column >= columnCount())
			return false;
		return true;
	}

	public String toString() {
		String result = "";
		for(ArrayList<Double> list: data) {
			result+="| ";
			for(Double item: list) {
				result += item+" ";
			}
			result+="|\n";
		}
		result+="\n";
		return result;
	}
	
	/**
	 * 
	 * @return true if calling object is a zero matrix,
	 * false otherwise
	 */
	public boolean isZero() {
		//ERROR, FIX THIS

		for(int R = 0; R < rowCount(); R++) {
			for(int C = 0; C < columnCount(); C++) {
				if(!(get(R,C) == 0)) {
					return false;
				}
			}
		}
		return true; 
		//to be completed
	}
	
	/**
	 * 
	 * @return if calling object is a diagonal matrix,
	 * false otherwise
	 */
	public boolean isDiagonal() {
		if(isSquare() == false)
			return false;
		for(int R = 0; R < rowCount(); R++) {
			for(int C = 0; C < columnCount(); C++) {
				if(!(R == C)) {
					if(!(get(R,C) == 0)) {
						return false;
					}
				}
			}
		}
		return true; 
		//to be completed
	}
	
	/**
	 * 
	 * @return true if calling object is an identity matrix,
	 * false otherwise
	 */
	public boolean isIdentity() {
		if(isDiagonal() == false)
			return false;
		for(int i = 0; i < columnCount(); i++) {
			if(!(data.get(i).get(i) == 1))
				return false;
		}
		return true; //to be completed
	}

	/**
	 * 
	 * @param row 
	 * @param column
	 * @param value
	 * @return if row and column are valid, 
	 * assign value to corresponding item and
	 * return true, otherwise return false
	 */
	public boolean set(int row, int column, double value) {
		if(row >= 0 && column >= 0) {
			//System.out.println("("+row+","+column+") --> "+value);
			//System.out.println("New value is:");
			data.get(row).set(column, value);
			//System.out.println(data.get(row).get(column));
			//System.out.println("--------");
			return true;
		}
		return false; //to be completed
	}
	
	/**
	 * 
	 * @param incValue
	 * @return matrix where incValue has been added
	 * to each item of the calling object.
	 */
	public Matrix change(double incValue) {
		Matrix A = new Matrix(rowCount(),columnCount());
			for(int R = 0; R < rowCount(); R++) {
				for(int C = 0; C < columnCount(); C ++) {
					A.set(R, C, get(R, C) + incValue);
				}
			}
			return A; //to be completed
	}

	/**
	 * 
	 * @param factor
	 * @return matrix where each item of the 
	 * calling object has been multiplied by factor.
	 */
	public Matrix amplify(double factor) {
		for(int R = 0; R < rowCount(); R++) {
			for(int C = 0; C < columnCount(); C ++) {
				set(R, C, this.get(R, C) * factor);
			}
		}
		return this; //to be completed
	}

	/**
	 * 
	 * @param other
	 * @return this matrix + other matrix
	 */
	public Matrix add(Matrix other) {
		if(!(rowCount() == other.rowCount() || !(columnCount() == other.columnCount())))
				return null;
		Matrix A = new Matrix(rowCount(),columnCount());
		for(int R = 0; R < rowCount(); R++) {
			for(int C = 0; C < columnCount(); C++) {
				A.set(R,C,get(R,C)+other.get(R, C));
			}
		}
		return A;
		//to be completed
	}

	/**
	 * 
	 * @param other
	 * @return this matrix - other matrix
	 */

	public Matrix subtract(Matrix other) {
		if(!(rowCount() == other.rowCount() || !(columnCount() == other.columnCount())))
			return null;
	Matrix A = new Matrix(rowCount(),columnCount());
	for(int R = 0; R < rowCount(); R++) {
		for(int C = 0; C < columnCount(); C++) {
			A.set(R,C,get(R,C)-other.get(R, C));
		}
	}
	return A;
	//to be completed
	}

	/**
	 * ADVANCED
	 * @param other
	 * @return this matrix * other matrix
	 */

	public Matrix multiply(Matrix other) {
		if(rowCount() == other.columnCount()) {
			Matrix A = new Matrix(rowCount(),other.columnCount());
			for(int R = 0; R < rowCount(); R++) {
				for(int C = 0; C < other.columnCount(); C++) {
					for(int i = 0; i < columnCount(); i++) {
						//A.get(R, C) += get(R,i) * other.get(i, C); - what I want it to do
						A.set(R, C, A.get(R, C)+get(R,i)*other.get(i, C));
					}
				}
			}
			return A;
		}
		return null; //to be completed
	}

	/**
	 * 
	 * @param row
	 * @param column
	 * @return minor of item at given row and column
	 */
	public Matrix minor(int row, int column) {
		if(rowCount() == 1)
			return null;
		Matrix result = new Matrix();
		for(int i=0; i < rowCount(); i++) {
			if(i == row) {
				continue;
			}
			ArrayList<Double> temp = new ArrayList<Double>();
			for(int k=0; k < columnCount(); k++) {
				if(k == column)
					continue;
				temp.add(get(i, k));
			}
			result.data.add(temp);
		}
		return result;
	}

	/**
	 * 
	 * @return cofactor matrix
	 */
	public Matrix cofactor() {
		Matrix A = new Matrix(rowCount(), columnCount());
		for(int i = 0; i < rowCount(); i++) {
			for(int j = 0; j < columnCount(); j++) {
				A.set(i, j, Math.pow(-1,i+j)*(minor(i,j).determinant()));
			}
		}
		return A; //to be completed
	}
	
	/**
	 * 
	 * @return determinant value of matrix
	 * See 
	 * partially completed
	 */
	public double determinant() {
		if(!isSquare())
			return 0;
		if(rowCount() == 0)
			return 0;
		if(rowCount() == 1)
			return get(0, 0);
		if(rowCount() == 2)
			return (get(0,0)*get(1,1) - get(0,1)*get(1,0));

		int sign = 1;
		double x = 0.0;
		double y = 0;
		for(int R = 0; R < columnCount(); R++) {
			Matrix A = new Matrix(columnCount()-1,columnCount()-1);
				for(int i = 0; i < rowCount(); i++) {
					for(int C = 1; C < columnCount(); C++) {
						if(i < R) {
							A.set(i, C-1, get(i,C));
						}
						if(i > R) {
							A.set(i-1, C-1, get(i,C));
						}
				}
			}
			x = sign*get(R,0)*A.determinant();
			y = y + x;
			sign = -sign;
		}
		return y; //to be completed
		/** 
		 * NOTE: i've completed this before properly looking at minor, and before attempting cofactor
		 * this is why neither are used here
		 * i am too lazy and impressed to include them
		 */
	}
	
	/**
	 * 
	 * @return true if matrix is invertible, 
	 * false otherwise
	 */
	public boolean invertible() {
		if(determinant() == 0)
			return false;
		return true; //to be completed
	}

	/**
	 * 
	 * @return transpose of matrix
	 */
	public Matrix transpose() {
		Matrix A = new Matrix(columnCount(),rowCount());
		for(int C = 0; C < columnCount(); C++) {
			for(int R = 0; R < rowCount(); R++) {
				A.set(C, R, get(R,C));
			}
		}
		return A; //to be completed
	}

	/**
	 * 
	 * @return inverse of matrix
	 * return null if not invertible
	 */
	public Matrix inverse() {
		if(invertible() == false)
			return null;
		Matrix A = new Matrix(rowCount(),columnCount());
		A = (cofactor()).transpose().amplify(1/determinant());
		return A; //to be completed
	}
}
