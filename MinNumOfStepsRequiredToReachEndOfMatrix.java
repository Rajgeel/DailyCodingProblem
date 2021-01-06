import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class MinNumOfStepsRequiredToReachEndOfMatrix {

	int ROW ;
	int COL;

	static class Point {
	    int x;
	    int y;
	 
	    public Point(int x, int y)
	    {
	        this.x = x;
	        this.y = y;
	    }
	};
 
	static class queueNode {
	    Point pt; 
	    int dist;
	 
	    public queueNode(Point pt, int dist) {
	        this.pt = pt;
	        this.dist = dist;
	    }
	};

	boolean isValid(int row, int col) {
	    
	    return (row >= 0) && (row < ROW) &&
	           (col >= 0) && (col < COL);
	}
	 

	int rowNum[] = {-1, 0, 0, 1};
	int colNum[] = {0, -1, 1, 0};
	 

 	int BFS(boolean mat[][], Point src, Point dest) {
	  
	    if (mat[src.x][src.y] != true || 
	        mat[dest.x][dest.y] != true)
	        return -1;
	 
	    boolean [][]visited = new boolean[ROW][COL];
	     
	    
	    visited[src.x][src.y] = true;
	 
	
	    Queue<queueNode> q = new LinkedList<>();
	     
	    
	    queueNode s = new queueNode(src, 0);
	    q.add(s); 
	 
	    
	    while (!q.isEmpty())
	    {
	        queueNode curr = q.peek();
	        Point pt = curr.pt;
	 
	        if (pt.x == dest.x && pt.y == dest.y)
	            return curr.dist;
	 
	        q.remove();
	 
	        for (int i = 0; i < 4; i++)
	        {
	            int row = pt.x + rowNum[i];
	            int col = pt.y + colNum[i];
	             
	            if (isValid(row, col) && 
	                    mat[row][col] == true && 
	                    !visited[row][col])
	            {
	                visited[row][col] = true;
	                queueNode Adjcell = new queueNode
	                             (new Point(row, col),
	                                   curr.dist + 1 );
	                q.add(Adjcell);
	            }
	        }
	    }
	 
	    return -1;
	}
	


	public static void main(String... s) {

		MinNumOfStepsRequiredToReachEndOfMatrix obj = new MinNumOfStepsRequiredToReachEndOfMatrix();

		Scanner sc = new Scanner(System.in);
		obj.ROW = sc.nextInt();
		obj.COL  = sc.nextInt();

		boolean board[][] = new boolean[obj.ROW][obj.COL];

		for(int i=0; i<obj.ROW; i++) {
			for(int j=0; j<obj.COL; j++) {
				board[i][j] = sc.nextBoolean();
			}
		}

		int srcX = sc.nextInt();
		int srcY = sc.nextInt();

		int destX = sc.nextInt();
		int destY = sc.nextInt();

		Point source = new Point(srcX, srcY);
    	Point dest = new Point(destX, destY);

		System.out.println(obj.BFS(board, source, dest));

	}
}