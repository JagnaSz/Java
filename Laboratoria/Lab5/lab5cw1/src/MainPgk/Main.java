package MainPgk;
import java.io.IOException;

import MyPkg.DummyMatrix;
import MyPkg.Matrix;
import MyPkg.MatrixDimensionsException;
public class Main {

        public static void main(String[] args) throws IOException, MatrixDimensionsException {
               
                int [][] matrix = {{1,1,0,4}, {2,2,0,7}, {1,1,0,1}, {1,2,3,4}}; 
                
              DummyMatrix temp = new DummyMatrix(3,3,matrix);
              DummyMatrix temp2 = new DummyMatrix(2,2,matrix);
              DummyMatrix nowy = new DummyMatrix("D:/dane.txt");
              DummyMatrix nowy2 = new DummyMatrix();
              
                try{
            	temp.mul(temp2);
            	
                } catch(MatrixDimensionsException e) {
                	e.co();
                	e.matrix().print();	
                }
         
               // nowy2.print();               
              
        }

		

}
