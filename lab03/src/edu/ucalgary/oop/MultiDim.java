package edu.ucalgary.oop;

public class MultiDim {
  public static void main(String[] args) {

    int[][][] intNested = new int[2][3][]; // 3D-array
    
    intNested[0][0] = new int[3]; 
    intNested[0][1] = new int[4]; 
    intNested[0][2] = new int[2]; 
    intNested[1][0] = new int[5]; 
    intNested[1][1] = new int[1]; 
    intNested[1][2] = new int[1];

    // initialize values
    intNested[0][0][0] = 10;
    intNested[0][1][2] = 20;
    intNested[1][0][4] = 99;
    intNested[1][2][0] = 7;

    // loop through 3D array
    for (int i = 0; i < intNested.length; i++) {
      for (int j = 0; j < intNested[i].length; j++) {
        for (int k = 0; k < intNested[i][j].length; k++) {
            System.out.print("intNested[" + i + "][" + j + "][" + k + "] = ");
            System.out.println(intNested[i][j][k]);
        }
      }
    }
  }
}
