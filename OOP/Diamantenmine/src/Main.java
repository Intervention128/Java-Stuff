package src;

public class Main {
	public static void main(String[] args) {
		// test1();
		// test2();
		test3();
    }
	
	public static void test1() {
		Node[][] field = new Node[7][7];
        for(int i = 0; i<7; i++) {
        	for (int j=0; j<7; j++) {
        		field[i][j] = new Node(false);
        	}
        }
        
        for(int i=0; i<7; i++) {
        	field[0][i].setType(Node.Type.NULL);
        	field[6][i].setType(Node.Type.NULL);
        	field[i][0].setType(Node.Type.NULL);
        	field[i][6].setType(Node.Type.NULL);
        }
        
        field[1][1].setType(Node.Type.NULL);
        field[1][2].setType(Node.Type.NULL);
        field[2][1].setType(Node.Type.NULL);
        field[1][5].setType(Node.Type.NULL);
        field[2][5].setType(Node.Type.NULL);
        field[5][1].setType(Node.Type.NULL);
        field[4][5].setType(Node.Type.NULL);
        field[5][5].setType(Node.Type.NULL);
        
        field[1][4].setType(Node.Type.DIAMOND);
		field[3][4].setType(Node.Type.DIAMOND);
		field[4][2].setType(Node.Type.DIAMOND);
        field[5][2].setType(Node.Type.DIAMOND);
        
        Mine mine = new Mine(field);
        mine.printGraph();
        System.out.println("");
        mine.printFinalPath();
	}
	
	public static void test2() {
		Node[][] field = new Node[11][11];
		for(int i = 0; i<11; i++) {
        	for (int j=0; j<11; j++) {
        		field[i][j] = new Node(false);
        	}
        }
		for(int i=0; i<11; i++) {
			field[i][0].setType(Node.Type.NULL);
			field[i][10].setType(Node.Type.NULL);
			field[0][i].setType(Node.Type.NULL);
			field[10][i].setType(Node.Type.NULL);
		}
		field[1][1].setType(Node.Type.NULL);
		field[1][3].setType(Node.Type.NULL);
		field[1][4].setType(Node.Type.NULL);
		field[1][5].setType(Node.Type.NULL);
		field[1][6].setType(Node.Type.NULL);
		field[1][7].setType(Node.Type.NULL);
		field[1][8].setType(Node.Type.NULL);
		field[1][9].setType(Node.Type.NULL);
		
		field[2][5].setType(Node.Type.NULL);
		field[2][6].setType(Node.Type.NULL);
		field[2][7].setType(Node.Type.NULL);
		field[2][8].setType(Node.Type.NULL);
		field[2][9].setType(Node.Type.NULL);
		
		field[3][7].setType(Node.Type.NULL);
		field[3][8].setType(Node.Type.NULL);
		field[3][9].setType(Node.Type.NULL);
		
		field[4][8].setType(Node.Type.NULL);
		field[4][9].setType(Node.Type.NULL);
		
		field[5][1].setType(Node.Type.NULL);
		
		field[6][1].setType(Node.Type.NULL);
		field[6][2].setType(Node.Type.NULL);
		
		field[7][1].setType(Node.Type.NULL);
		field[7][2].setType(Node.Type.NULL);
		
		field[8][1].setType(Node.Type.NULL);
		field[8][2].setType(Node.Type.NULL);
		field[8][9].setType(Node.Type.NULL);
		
		field[9][1].setType(Node.Type.NULL);
		field[9][2].setType(Node.Type.NULL);
		field[9][3].setType(Node.Type.NULL);
		field[9][7].setType(Node.Type.NULL);
		field[9][8].setType(Node.Type.NULL);
		field[9][9].setType(Node.Type.NULL);
		
		field[3][2].setType(Node.Type.DIAMOND);
		field[4][3].setType(Node.Type.DIAMOND);
		field[5][6].setType(Node.Type.DIAMOND);
		field[6][7].setType(Node.Type.DIAMOND);
		field[6][8].setType(Node.Type.DIAMOND);
		field[8][5].setType(Node.Type.DIAMOND);
		
        Mine mine = new Mine(field);
        mine.printGraph();
        System.out.println("");
        mine.printFinalPath();
	}
	
	public static void test3() {
		Node[][] field = new Node[11][11];
		for(int i = 0; i<11; i++) {
        	for (int j=0; j<11; j++) {
        		field[i][j] = new Node(false);
        	}
        }
		for(int i=0; i<11; i++) {
			field[i][0].setType(Node.Type.NULL);
			field[i][10].setType(Node.Type.NULL);
			field[0][i].setType(Node.Type.NULL);
			field[10][i].setType(Node.Type.NULL);
		}
		field[1][1].setType(Node.Type.NULL);
		field[1][3].setType(Node.Type.NULL);
		field[1][4].setType(Node.Type.NULL);
		field[1][5].setType(Node.Type.NULL);
		field[1][6].setType(Node.Type.NULL);
		
		field[2][5].setType(Node.Type.NULL);
		
		field[3][8].setType(Node.Type.NULL);
		field[3][9].setType(Node.Type.NULL);
		
		field[4][8].setType(Node.Type.NULL);
		field[4][9].setType(Node.Type.NULL);
		
		field[5][1].setType(Node.Type.NULL);
		
		field[6][1].setType(Node.Type.NULL);
		field[6][2].setType(Node.Type.NULL);
		
		field[7][1].setType(Node.Type.NULL);
		field[7][2].setType(Node.Type.NULL);
		
		field[8][1].setType(Node.Type.NULL);
		field[8][2].setType(Node.Type.NULL);
		field[8][9].setType(Node.Type.NULL);
		
		field[9][1].setType(Node.Type.NULL);
		field[9][2].setType(Node.Type.NULL);
		field[9][7].setType(Node.Type.NULL);
		field[9][8].setType(Node.Type.NULL);
		field[9][9].setType(Node.Type.NULL);
		
		field[2][7].setType(Node.Type.DIAMOND);
		field[3][2].setType(Node.Type.DIAMOND);
		field[4][3].setType(Node.Type.DIAMOND);
		field[5][6].setType(Node.Type.DIAMOND);
		field[6][7].setType(Node.Type.DIAMOND);
		field[7][5].setType(Node.Type.DIAMOND);
		field[8][5].setType(Node.Type.DIAMOND);
		
        Mine mine = new Mine(field);
        mine.printGraph();
        System.out.println("");
        mine.printFinalPath();
	}
}























