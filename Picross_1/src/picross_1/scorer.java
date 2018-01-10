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
       boolean[][] solGrid = {{true,true},{false,false}};
       boolean[][] userGrid = {{true,true},{false,true}};
      
          //call scoring
        scoring(solGrid,userGrid);
    }
    
    
    public static boolean scoring(boolean[][]solGrid, boolean[][]userGrid){
        boolean correct = true;  //correct flag
        
        for (int i = 0; i<solGrid.length; i++){
            for (int j = 0; j<solGrid[i].length; j++){
                if(solGrid[i][j] != userGrid[i][j]){
                correct = false;
            
                }
        
            } 
        
        
        }
        
         if(correct){
            System.out.println("correct!");
            return correct;
         }
        else{
         System.out.println("incorrect!");
         //print user Grid and solution Grid
            return correct;
        }
    
}
}



   

