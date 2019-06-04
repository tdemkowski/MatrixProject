package matrixProject;

public class MatrixClient {

	public static void main(String[] args) {
		Matrix A = new Matrix(3,3);	
		Matrix B = new Matrix(3,3);
		Matrix C = new Matrix(3,3);
		Matrix D = new Matrix(3,3);
		Matrix E = new Matrix(3,3);
		
		double[][] a = {{1,-1,0},{0,2,-2},{1,0,1}};
		for(int i=0; i < 3; i++) {
			for(int k=0; k < 3; k++)
				A.set(i, k, a[i][k]);
			System.out.println("|"+A.get(i,0)+"  "+A.get(i, 1)+"  "+A.get(i, 2)+"|");
		}
		
		System.out.println("");
		
		double[][] b = {{1,0,0},{0,1,0},{0,0,0}};
		for(int i=0; i < 3; i++) {
			for(int k=0; k < 3; k++)
				B.set(i, k, b[i][k]);
				System.out.println("|"+B.get(i,0)+"  "+B.get(i, 1)+"  "+B.get(i, 2)+"|");
		}
		
		System.out.println("");
		
		C = A.add(B);
		for(int i = 0; i < 3; i++) {
			System.out.println("|"+C.get(i,0)+"  "+C.get(i, 1)+"  "+C.get(i, 2)+"|");
		}
		
		System.out.println("");
		System.out.println("|C| = "+C.determinant());
		System.out.println("");
		
		D = C.inverse();
		for(int i = 0; i < 3; i++) {
			System.out.println("|"+D.get(i,0)+"  "+D.get(i, 1)+"  "+D.get(i, 2)+"|");
		}
		
		System.out.println("");
		
		E = C.multiply(D);
		for(int i = 0; i < 3; i++) {
			System.out.println("|"+E.get(i,0)+"  "+E.get(i, 1)+"  "+E.get(i, 2)+"|");
		}
	}
}
