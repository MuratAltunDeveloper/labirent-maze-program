package prolabikideneme2;



public class coordinate {
	int x;
	coordinate ebeveyn;
    int y;
    public coordinate(int x1,int y1,coordinate ebeveyn1) {
		
    x=x1;
    y=y1;
    ebeveyn=ebeveyn1;
    	
	}
    public coordinate(int x, int y) {
        this.x = x;
        this.y = y;
      
    }

  

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }
    
    coordinate getparent()
    {
    	return ebeveyn;
    }
    
    
}
