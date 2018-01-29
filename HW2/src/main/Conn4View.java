package main;



public class Conn4View {
	private Conn4Model conModel;

	public Conn4View(Conn4Model conModel) {
		super();
		this.conModel = conModel;
	}
	
	public void printBoard(){
		
		// printing y axis label
		System.out.print(" ");
		for (int k = 0; k < conModel.getSize(); k++)
			System.out.print(" "+ (char) (k+97));
		System.out.println();


		//printing grid and x axis label
	    for (int i = 0; i < conModel.getSize(); i++) {
	    	System.out.print(i+1);
	    	for (int j = 0; j < conModel.getSize(); j++) {
	    		System.out.print("|");
	    		if (conModel.getSquare(i, j) == 'X' || conModel.getSquare(i, j) == 'O')
	    			System.out.print(conModel.getSquare(i, j));
	    		else System.out.print("_");
	    	}
	    	System.out.println("|");
	    }
	}
	
	public void printPrompt (char turn) {
		System.out.println("Input Q anytime to exit");
		System.out.println("Please select the square for "+  turn+ " user (e.g a1, a3, a4):");
	}
	
	
	


}


