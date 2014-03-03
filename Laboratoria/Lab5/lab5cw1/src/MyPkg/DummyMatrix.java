package MyPkg;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;


public class DummyMatrix extends Matrix {
	
	public DummyMatrix() {
		rows = 3;
        cols = 3;
        matrix = new int[rows][cols];
        for( int i=0; i<rows; i++)
                for( int j=0; j<cols; j++)
                        matrix[i][j] = 0;
	}
	public DummyMatrix(int x, int y) {
		rows = x;
        cols = y;
        matrix = new int[rows][cols];
        for( int i=0; i<rows; i++)
                for( int j=0; j<cols; j++)
                        matrix[i][j] = 0;
	}
	public DummyMatrix(int x, int y, int [][] tab) {
		super(x, y, tab);
	}
	
	public DummyMatrix(String file) throws MatrixDimensionsException, IOException {
		super(file);
	}
	
	public DummyMatrix add(DummyMatrix temp) throws MatrixDimensionsException {
    	 
		int[][] result = new int[this.rows][this.cols];
    	int[][] result2 = new int[this.rows][this.cols]; 
    	
         if(this.rows > temp.rows || this.cols > temp.cols){ 
        	 for(int i=0; i < this.rows; i++) {
        		 for(int j=0; j<this.cols; j++) {
    			 
        			 if(temp.rows <= i || temp.cols <= j) { 
        				 result2[i][j] = 1;		 
        			 }
    			 
        			 else {
        				 result2[i][j] = temp.matrix[i][j];	
        			 }
    			 
        		 }
        	 }
        	 DummyMatrix result1 = new DummyMatrix(this.rows, this.cols);
             for(int i=0;i<this.rows;i++)
                     for(int j=0;j<this.cols;j++)
                             result1.matrix[i][j] = this.matrix[i][j] + result2[i][j];
          
             
             throw new MatrixDimensionsException("Z³e wymiary", result1);
         }
        
         else {
         
        	 for(int i=0; i < this.rows; i++) {
        		 for(int j=0; j<this.cols; j++) {
        			 result[i][j] = temp.matrix[i][j];
        		 }
        	 }
        	 
        	 DummyMatrix result1 = new DummyMatrix(this.rows, this.cols);
             for(int i=0;i<this.rows;i++)
                     for(int j=0;j<this.cols;j++)
                             result1.matrix[i][j] = this.matrix[i][j] + result[i][j];
          
             
             return result1;
         }
    }
	
	public DummyMatrix sub(DummyMatrix temp) throws MatrixDimensionsException {
   	 
    	int[][] result = new int[this.rows][this.cols];
    	int[][] result2 = new int[this.rows][this.cols]; 
    	
         if(this.rows > temp.rows || this.cols > temp.cols){ 
        	 for(int i=0; i < this.rows; i++) {
        		 for(int j=0; j<this.cols; j++) {
    			 
        			 if(temp.rows <= i || temp.cols <= j) { 
        				 result2[i][j] = 1;		 
        			 }
    			 
        			 else {
        				 result2[i][j] = temp.matrix[i][j];	
        			 }
    			 
        		 }
        	 }
        	 DummyMatrix result1 = new DummyMatrix(this.rows, this.cols);
             for(int i=0;i<this.rows;i++)
                     for(int j=0;j<this.cols;j++)
                             result1.matrix[i][j] = this.matrix[i][j] - result2[i][j];
          
             
             throw new MatrixDimensionsException("Z³e wymiary", result1);
         }
         else {
         
        	 for(int i=0; i < this.rows; i++) {
        		 for(int j=0; j<this.cols; j++) {
        			 result[i][j] = temp.matrix[i][j];
        		 }
        	 }
        	 DummyMatrix result1 = new DummyMatrix(this.rows, this.cols);
             for(int i=0;i<this.rows;i++)
                     for(int j=0;j<this.cols;j++)
                             result1.matrix[i][j] = this.matrix[i][j] - result[i][j];
          
             return result1;
         }
	}
    	
	public DummyMatrix mul(DummyMatrix temp) throws MatrixDimensionsException {
		//int[][] result = new int[this.rows][this.cols];
    	int[][] result2 = new int[this.rows][this.cols]; 
    	
        
        	if(this.rows != temp.rows && this.cols != temp.cols){ 
        		for(int i=0; i < this.rows; i++) {
        			for(int j=0; j<this.cols; j++) {
    			 
        				if(temp.rows <= i || temp.cols <= j) { 
        					result2[i][j] = 1;		 
        			 }
    			 
        			 else {
        				 result2[i][j] = temp.matrix[i][j];	
        			 }
    			 
        		 }
        	 }
        	 DummyMatrix result1 = new DummyMatrix(this.rows, this.cols);
        	 for(int i=0; i<this.cols;i++)
                 for( int j=0; j<this.rows;j++)
                         for(int k=0; k<this.cols; k++)
                                 result1.matrix[i][j] += result2[i][j] * result2[j][k];
          
             
             throw new MatrixDimensionsException("Z³e wymiary", result1);
         }
         
        	else {
        		 DummyMatrix result1 = new DummyMatrix(this.rows, this.cols);
        		for(int i=0; i<this.cols;i++)
                    for( int j=0; j<this.rows;j++)
                            for(int k=0; k<temp.cols; k++)
                                    result1.matrix[i][j] += this.matrix[i][j] * temp.matrix[j][k];
        	 
        return result1;	
        	}
    }
	
	public void print() {
		super.print();
	}
}
