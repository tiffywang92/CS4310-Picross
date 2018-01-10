/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author School
 */
public class scorer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       int[][] solGrid = {{2,3},{4,3}};
       int[][] userGrid = {{2,1},{4,3}};
      
          //call scoring
        scoring(solGrid,userGrid);
    }
    
    
    public static void scoring(int[][]solGrid, int[][]userGrid){
        boolean correct = true;
        
        for (int i = 0; i<solGrid.length; i++){
            for (int j = 0; j<solGrid[i].length; j++){
                if(solGrid[i][j] != userGrid[i][j]){
                correct = false;
            
                }
        
            } 
        
        
        }
        
         if(correct){
            System.out.println("correct!");
         }
        else{
         System.out.println("incorrect!");
         //print user Grid and solution Grid
        }
    
}
}



   

