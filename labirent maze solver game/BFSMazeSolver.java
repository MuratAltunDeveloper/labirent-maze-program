package prolabikideneme2;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BFSMazeSolver {
	
	public static int digergidilenyollar[][]=new int[Labirent.roadtutucu][Labirent.roadtutucu2];
	
	

	
	
	
    private static final int[][] DIRECTIONS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public List<coordinate> solve(Labirent maze) {
    	
        LinkedList<coordinate> nextToVisit = new LinkedList<>();
        coordinate start = maze.getEntry();
        nextToVisit.add(start);

        while (!nextToVisit.isEmpty()) {
            coordinate cur = nextToVisit.remove();

            if (!maze.gecerlikonum(cur.getX(), cur.getY(),78) || maze.isExplored(cur.getX(), cur.getY())) {
                 
                 if(cur.getX()>=0&&cur.getY()>=0)
                 {
                	 for(int x=0;x<digergidilenyollar.length;x++)
                	 {
                	for(int y=0;y<digergidilenyollar[0].length;y++)
                             	{
                		// gidilen yollara 1 ata
                		if(x==cur.getX()&&y==cur.getY())
                		{
                			digergidilenyollar[x][y]=1;
                		}
                		
                             	} 
                	 }
                	 
                	 
                 System.out.println(cur.getX()+"  "+cur.getY());
                 
                
                 }                 
                 
                 
                 continue;
            }

            if (maze.isWall(cur.getX(), cur.getY())) {
                maze.setVisited(cur.getX(), cur.getY(), true,maze.yukseklıkgetir(),maze.genislikgetir());
                continue;
            }

            if (maze.isExit(cur.getX(), cur.getY())) {
               return backtrackPath(cur);
            }
            
            	
            	for (int[] direction : DIRECTIONS) {
                coordinate coordinate = new coordinate(cur.getX() + direction[0], cur.getY() + direction[1], cur);
                nextToVisit.add(coordinate);
                maze.setVisited(cur.getX(), cur.getY(), true,maze.yukseklıkgetir(),maze.genislikgetir());
            }
        }
        
        return Collections.emptyList();
    }

    private List<coordinate> backtrackPath(coordinate cur) {
        List<coordinate> path = new ArrayList<>();
        coordinate iter = cur;
        while (iter != null) {
            path.add(iter);
            iter = iter.ebeveyn;
        }

        return path;
    }
    private List<coordinate> backtrackPath2(coordinate cur) {
        List<coordinate> path2 = new ArrayList<>();
        coordinate iter = cur;
        while (iter != null) {
            path2.add(iter);
            iter = iter.ebeveyn;
        }

        return path2;
    }
    
    
    public static void LABİRENTGİT() {
    	System.out.println();
    	System.out.println();
    	System.out.println();
	for(int i=0;i<digergidilenyollar.length;i++)
	{
		for(int j=0;j<digergidilenyollar[0].length;j++)
		{
			System.out.print(digergidilenyollar[i][j]);
		}System.out.println();
	}
		
		
	}
    
}