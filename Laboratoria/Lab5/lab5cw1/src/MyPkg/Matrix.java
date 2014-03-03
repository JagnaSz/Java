package MyPkg;


import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Matrix {
        public int [][] matrix;
        int rows;
        int cols;
        
        public Matrix(int x, int y, int [][] tab){
                rows = x;
                cols = y;
                matrix = new int[rows][cols];
                for( int i=0; i<rows; i++)
                        for( int j=0; j<cols; j++)
                                matrix[i][j] = tab[i][j];
                        
        }
        public Matrix(){
                rows = 3;
                cols = 3;
                matrix = new int[rows][cols];
                for( int i=0; i<rows; i++)
                        for( int j=0; j<cols; j++)
                                matrix[i][j] = 0;
        }
        
        public Matrix(String plik) throws IOException, MatrixDimensionsException {
        	File file = new File(plik);
        	Scanner in = new Scanner(file);
        	String linia;
        	int width = 0;
        	
        	LinkedList<String[]> macierz = new LinkedList<String[]>();
        	
        	try{
        		while(in.hasNextLine()) {
        			linia = in.nextLine(); 
        				String[] wiersz = linia.split(" ");
        				
        				if(width!=0 && width != wiersz.length) throw new MatrixDimensionsException("Bad width");
        				width = wiersz.length;
        		
        				macierz.add(wiersz);
        				//System.out.println(wiersz[0].length());
        		}
        	}finally{
        		in.close();
        	}
        	//System.out.println(macierz.get(0)[1]);
        	cols = macierz.size();
        	rows = macierz.get(0).length;
        	matrix = new int[rows][cols];
        	
        	for(int i = 0; i < cols; i++)
        		for(int j = 0; j < rows; j++)
        			matrix[i][j] = Integer.valueOf(macierz.get(i)[j]);
        }
        
        public void print() {
    		for (int i = 0; i < this.rows; ++i) {
    			System.out.println();
    			for (int j = 0; j < this.cols; ++j) {
    				System.out.print(matrix[i][j]);
    				System.out.print(" ");
    			}
    		}
    		System.out.println();
    	} 
        
        public Matrix add(Matrix temp) throws MatrixDimensionsException {
        	if((this.cols != temp.cols) || (this.rows != temp.cols)) throw new MatrixDimensionsException("blee");
                Matrix result = new Matrix();
                for(int i=0;i<this.rows;i++)
                        for(int j=0;j<this.cols;j++)
                                result.matrix[i][j] = this.matrix[i][j] + temp.matrix[i][j];
                
                return result;
        }
        
        public Matrix sub(Matrix temp){
                Matrix result = new Matrix();
                for(int i=0;i<this.rows;i++)
                        for(int j=0;j<this.cols;j++)
                                result.matrix[i][j] = this.matrix[i][j] - temp.matrix[i][j];
                
                return result;
        }
        
        public Matrix mul(Matrix temp) throws MatrixDimensionsException {
        	if((this.cols != temp.cols) || (this.rows != temp.cols)) throw new MatrixDimensionsException("brr");
                Matrix result = new Matrix();
                for(int i=0; i<this.cols;i++)
                        for( int j=0; j<this.rows;j++)
                                for(int k=0; k<temp.cols; k++)
                                        result.matrix[i][j] += this.matrix[i][j] * temp.matrix[j][k];
                                
                return result;
        }
        
}