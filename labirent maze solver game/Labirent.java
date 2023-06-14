package prolabikideneme2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.security.cert.CertPathBuilderResult;




public class Labirent {
	 public static final int ROAD = 0;
	    public static final int WALL = 1;
	    public static final int START = 2;
	    public static final int EXIT = 3;
	    public static final int PATH = 4;

	    public static int tekrar=0;
	    public static int tekrar2=0;
	    public int[][] labirent;
	    public boolean[][] visited;
	    public coordinate start;
	    public coordinate exit;
    
	    public static int  roadtutucu;
	    public static int roadtutucu2;
        public static int saat;
	    public static int harita[][]=new int[gelendosyadaengelkoy.txtboy+2][gelendosyadaengelkoy.txtboy+2];
	//    public static int[][]gezilenyol;
	    public static  int txtatenkısapath[][]=new int[100][100];
		public static int txtattumgeezilenyerler[][]=new int [100][100];	
		
		 

	 public Labirent() {
		
			
			for(int i=0;i<txtatenkısapath.length;i++)
			{
				for(int j=0;j<txtatenkısapath[0].length;j++)
				{
					txtatenkısapath[i][j]=0;
				}
			}
			
			
			for(int i=0;i<txtattumgeezilenyerler.length;i++)
			{
				for(int j=0;j<txtattumgeezilenyerler[0].length;j++)
				{
					txtattumgeezilenyerler[i][j]=0;
				}
			}
			
		}
	    
	    
	    
	    
	    
	    public  Labirent(File labirent) throws FileNotFoundException {
	        String filemetin = "";
	        filemetin=filemetin+"";
	        try (Scanner giriş= new Scanner(labirent)) {
	            while (giriş.hasNextLine()) {
	                filemetin+= giriş.nextLine() + "\n";
	            }
	        }
	        labirentyarat(filemetin);
	    }

	    private void  labirentyarat(String labgorseli) 
	    { if (labgorseli == null || labgorseli.trim().length() == 0) {
            throw new IllegalArgumentException("satır 49 hata vermiş");
        }

	    String[] satırlar = labgorseli.split("[\r]?\n");
	    //lab satır sayısı
	    int topsatır=satırlar.length;
	    //lab top sutun sayısı
	    int topsutun=satırlar[0].length();
        labirent = new int[topsatır][topsutun];
        visited = new boolean[topsatır][topsutun];

	    
        
        int yukseklık=yukseklıkgetir();
        int genislik=genislikgetir();
        
        for (int satır = 0; satır <yukseklık; satır++) {
            if (satırlar[satır].length() != genislik) {
              //  throw new IllegalArgumentException("satır 67 hata");
            }

            for (int sutun = 0; sutun< genislik; sutun++) {
                if (satırlar[satır].charAt(sutun) == '1')
                    labirent[satır][sutun] = WALL;
                else if (satırlar[satır].charAt(sutun) == '2') {
                    labirent[satır][sutun] = START;
                    start = new coordinate(satır,sutun);
                } else if (satırlar[satır].charAt(sutun) == '3') {
                    labirent[satır][sutun] = EXIT;
                    exit = new coordinate(satır,sutun);
                } else
                    labirent[satır][sutun] = ROAD;
            }
        }
	    
	    
	    
	    	
	    
	    
	    }
	    
	    
	  
	    

	    public void printPath(List<coordinate> path) {
	        int[][] tempMaze = Arrays.stream(labirent)
	            .map(int[]::clone)
	            .toArray(int[][]::new);
	        for (coordinate coordinate : path) {
	            if (isStart(coordinate.getX(), coordinate.getY()) || isExit(coordinate.getX(), coordinate.getY())) {
	                continue;
	            }
	            tempMaze[coordinate.getX()][coordinate.getY()] = PATH;
	        }
	        System.out.println(toString(tempMaze));
	    }

	    
	    
	    
	    
	    

	    public boolean gecerlikonum(int row, int col,int deger) {
	        if (row < 0 || row >= yukseklıkgetir()|| col < 0 || col >= genislikgetir()) {
	          deger=0;
	        	return false;
	        }
	        return true;
	    }
	    
	    
	    public  int yukseklıkgetir() {
	       roadtutucu=gelendosyadaengelkoy.txtboy+2;
	    	return labirent.length;
	        
	    }

	    public int genislikgetir() {
	        roadtutucu2=gelendosyadaengelkoy.txtboy+2;
	    	return labirent[0].length;
	    }

	    
	    
	    public coordinate getEntry() {
	        return start;
	    }

	    public coordinate getExit() {
	        return exit;
	    }

	    public boolean isExit(int x, int y) {
	        return x == exit.getX() && y == exit.getY();
	    }

	    public boolean isStart(int x, int y) {
	        return x == start.getX() && y == start.getY();
	    }

	    public boolean isExplored(int row, int col) {
	        return visited[row][col];
	    }

	    public boolean isWall(int row, int col) {
	        return labirent[row][col] == WALL;
	    }
	  
	  static String[][] ziyarettrue=new String[300][300];
	  
	                                                static int x=0,y=0;
	  
	                                                public static void atamacı()
	   {
		   for(int i=0;i<300;i++)
		   {
			   for(int j=0;j<300;j++)
			   {
				ziyarettrue[i][j]="yok";  
			   }
		   }
		   
	   }
	  
	/*   public static void tekraredenleriat(String deger)
	   {
		  
	for(int x1=0;x1<x;x1++)
	{
	for(int y1=0;y1<y;y1++)
	{

		if(ziyarettrue[x1][y1].contains(deger))
		{
			ziyarettrue[x][y]="yok";
			x--;
			y--;
		}
	}



	}



		   
	   }
	  */
	   
	   public static int tutucu[]=new int[900];
	   public static int tutucu2[]=new int[900];
	   public int str=0,stn=0;
	   public static int art=0;
	   
	    public void setVisited(int row, int col, boolean value,int height,int weidth) {
	        visited[row][col] = value;
	   //  System.out.println(+row+"  "+col);
	       
	        
	        tutucu[str]=row;
	     
	        tutucu2[stn]=col;
	        stn++;
	        art++;
	        str++;

	        
	        
	        
	        for(int  i=0;i<12;i++)
	        {
	        	for(int j=0;j<10;j++)
	        	{
	        		if(i==row&&j==col)
	        		{
	        			//System.out.print("0");
	        		}
	        		else {
						//System.out.print("1");
					}
	        		
	        	}
	        }
	        
	        
	        
	    }
	    
	    

	    
	    
	    public static String sonuçharitasınıcizdir(int labharita[][])
		{
	    	
	    	//toplam kare veya toplam sutun hesaplanırken dogru sonuc,cıktı veriyor
	    	//!!!!
	    	//!!!!!
	    	//!!!!!
	    	System.out.println("sonuçharitasınıcizdir");
	    	System.out.println("road tutucu"+roadtutucu);
	    	
	    	for(int i=0;i<labharita.length;i++)
	    	{
	    		for(int j=0;j<labharita[0].length;j++)
	    		{
	    			System.out.print(labharita[i][j]);
	    		}System.out.println();
	    	}
	    	int xeks=0,yeks=0;
	    	
	    JFrame arayuz=new JFrame();
	    
	    JButton[] btn=new JButton[(roadtutucu*roadtutucu2)+1];
	    for(int j=0;j<btn.length;j++)
	    {
	    	btn[j]=new JButton();
	    
	    }
	    
	    int index=0;
	    
	    //4 duvar
	    //3 yol
	    // baslangıc ve bitis kırmızı
	    //mavi enkısa yol
	    //sarı gezilen tum yol
	    
	    
	    for(int x=0;x<labharita.length;x++)
		{
		for(int y=0;y<labharita[0].length;y++)
	               { 
			     if(labharita[x][y]!=0)
			     {
			    	 if(labharita[x][y]==4)
			    	 {
			    		 btn[index].setBounds(xeks, yeks,28,28 );
			    		 btn[index].setBackground(Color.black);
			    		 arayuz.add(btn[index]);	
			    		 
			    		 xeks+=30;
			    		 index++;
			    	 }
			    	 else if(labharita[x][y]==5)
			    	 {  txtatenkısapath[x][y]=1;
			     		 btn[index].setBounds(xeks,yeks,28,28);
			     		btn[index].setBackground(Color.blue);
			     		 arayuz.add(btn[index]);	 
			     		xeks+=30; 
			     		index++;
			    	 }
			    	 else if(labharita[x][y]==3)
			    	 {
			    		 btn[index].setBounds(xeks, yeks,28,28);
			    		 btn[index].setBackground(Color.white);
			    		 arayuz.add(btn[index]);
			    		 xeks+=30;
			    		 index++;
			    	 }
			    	 else if(labharita[x][y]==2)
			    	 {
			      		 btn[index].setBounds(xeks, yeks,28,28);
			      		btn[index].setBackground(Color.red);
			      		btn[index].setText("S");
			      		arayuz.add(btn[index]);	 
			      		xeks+=30;
			      		index++;
			    	 }
			    	 else if(labharita[x][y]==1)
			    	 {   	
			    		 btn[index].setBounds(xeks, yeks,28,28);
			    		 btn[index].setText("F");
			    		 btn[index].setBackground(Color.red);
			    		 arayuz.add(btn[index]);
			    		 xeks+=30;index++;
			    	 }else {
			       		 	btn[index].setBounds(xeks, yeks,28,28 );
			       		 btn[index].setBackground(Color.yellow);
			       		 	arayuz.add(btn[index]);	
			       		xeks+=30;index++;
					}
			    	   
			     }
			     if(y==labharita[0].length-1)
			     {
			    	 System.out.println("GELDİİİİİİİİİİİİİİİİİİİİİ");
			    	yeks+=30;
			    			
			    	xeks=0;
		
			     }
			    	 
			    	 
		                
		         }
		
		}
		
		
	    
	    
	    
	    enkısayolata(labharita);
	    
	    arayuz.add(btn[index]);	    
	    arayuz.setSize(60*roadtutucu,60*roadtutucu2);
	    arayuz.setLayout(null);
	     arayuz.setVisible(true);
	    
			return 	"gorsel oluşuyor";
	    	
	    	
			
		}    
	    
	    
	    
	    
	    

	    public String toString(int[][] labirent) {
	    	System.out.println();
	    	System.out.println();
	    	int[][] gezilenyol=yollarciz(yukseklıkgetir(),genislikgetir());
	    	
	    	
	    	
	    int[][]path=new int[yukseklıkgetir()][genislikgetir()];
	    int[][]wall=new int[yukseklıkgetir()][genislikgetir()];
	    int[][]road=new int[yukseklıkgetir()][genislikgetir()];
	    int[][]start=new int[yukseklıkgetir()][genislikgetir()];
	    int[][]finish=new int[yukseklıkgetir()][genislikgetir()];
	    
	    	
   	int anaharita[][]=new int[yukseklıkgetir()][genislikgetir()];
	    	
	    	
	    	
	    	
	    	StringBuilder result = new StringBuilder(genislikgetir() * (yukseklıkgetir() + 1));
	        for (int satır = 0; satır< yukseklıkgetir(); satır++) {
	            for (int sutun = 0; sutun < genislikgetir(); sutun++) {
	                if (labirent[satır][sutun] == ROAD) {
	                    road[satır][sutun]=3;
	                	result.append('0');
	                } else if (labirent[satır][sutun] == WALL) {
	                    wall[satır][sutun]=4;
	                	result.append('1');
	                } else if (labirent[satır][sutun] == START) {
	                   start[satır][sutun]=2;
	                	result.append('2');
	                } else if (labirent[satır][sutun] == EXIT) {
	                    finish[satır][sutun]=1;
	                	result.append('3');
	                } else {
	                    path[satır][sutun]=5;
	                	result.append('4');
	                }
	            }
	            result.append('\n');
	        }
	     
	        
	        
	  
	        
	        
	        
	        
	for(int i=0;i<yukseklıkgetir();i++)
	{
		
		for(int j=0;j<genislikgetir();j++)
		{
			if(wall[i][j]==4)
			{
				anaharita[i][j]=4;
			}
			else if(start[i][j]==2)
			{
				anaharita[i][j]=2;
			}
			else if(finish[i][j]==1)
			{
				anaharita[i][j]=1;
			}
			else if(path[i][j]==5)
			{ 
		
			anaharita[i][j]=5;
			}
			else if(road[i][j]==3&&gezilenyol[i][j]==6)
			{
				anaharita[i][j]=6;
			
			}
			else {
				anaharita[i][j]=3;
			}
			
		}
	}
	        
	        
	        System.out.println("\n\n");
	        
	       for(int i=0;i<yukseklıkgetir();i++)
	       {
	    	   for(int j=0;j<genislikgetir();j++)
	    	   {
	    		   System.out.print(anaharita[i][j]);
	    	   }System.out.println();
	       }
	      
	       
	       
	       
	       
	       

		    int temp; 
		    System.out.println("road tutucu2:"+roadtutucu2);
	  	 
	    	for(int i=0;i<harita.length;i++)
	    	{
	    		for(int j=0;j<harita[0].length;j++)
	    		{
	    			if((i<roadtutucu&&j<roadtutucu2))
	    			{
	    				 temp=anaharita[i][j];
	    				harita[i][j]=temp;
	    				
	    			}
	    			else {
	    				
					}
	  
	    			//System.out.println(dizi[i][j]);
	    			}
	    	}
	    	
	    	
	    	
	    	for(int i=0;i<harita.length;i++)
	    	{
	    		for(int j=0;j<harita[0].length;j++)
	    		{
	    	
	    		System.out.print(harita[i][j]);
	    		}System.out.println();
	    	}
	    
	    	
	    	
	    	
	    	
	    	
	      for(int i=0;i<gezilenyol.length;i++)
	      {
	    	  for(int j=0;j<gezilenyol[0].length;j++)
	    	  {
	    		  txtatenkısapath[i][j]=gezilenyol[i][j];
	    	  }
	      }
	    	
	    	
	    	
	      
	      for(int i=0;i<path.length;i++)
	      {
	    	  for(int j=0;j<path[0].length;j++)
	    	  {
	    		  txtattumgeezilenyerler[i][j]=path[i][j];
	    	  }
	      }
	    	
	    	
	       
	       tum(anaharita);
	    enkısayolata(anaharita);
	       
	       
	       
	       fonksiyon();
	        System.out.println("\n\n");
	        return result.toString();
	    }
	    
	    
	    
	    public void reset() {
	        for (int i = 0; i < visited.length; i++)
	            Arrays.fill(visited[i], false);
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
		public static void enkısayolata(int labharita[][])
		{
			
		// 5 en kısa yol

			try {	

				String ataString="";
				for(int i=0;i<labharita.length;i++)
				{
					for(int j=0;j<labharita[0].length;j++)
					{
						ataString+=txtatenkısapath[i][j]+"";
					}
					ataString+="\n";
				}
				
				
					
					File dosya=new File("C:\\Users\\murat\\OneDrive\\Masaüstü\\problemm11icintumyollar.txt"
			);
					FileWriter fwriterFile=new FileWriter(dosya);
					BufferedWriter bfrWriter=new BufferedWriter(fwriterFile);
					
					bfrWriter.write(ataString);
					bfrWriter.close();
		        
			
			
			
			}
			catch (Exception e) {
				// TODO: handle exception
				System.err.println("satır 278");
			//	e.printStackTrace();

			}

			
			
			
		}
		public static void tum(int labharita[][])
		{
			
			//1 en kısa yollar  6 gezilen yoollar
			try {	

				String ataString="";
				for(int i=0;i<labharita.length;i++)
				{
					for(int j=0;j<labharita[0].length;j++)
					{
						ataString+=txtattumgeezilenyerler[i][j]+"";
					}
					ataString+="\n";
				}
				
				
				
				
					File dosya=new File("C:\\Users\\murat\\OneDrive\\Masaüstü\\problem11icinenkısayol.txt");
					FileWriter fwriterFile=new FileWriter(dosya);
					BufferedWriter bfrWriter=new BufferedWriter(fwriterFile);
					
					bfrWriter.write(ataString);
					bfrWriter.close();
		        
			
			
			
			}
			catch (Exception e) {
				// TODO: handle exception
			System.err.println("satır 342");
			}


			
		}
		
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	   
	    public static int[][] yollarciz(int yukseklık,int genislik)
	    {
	    	int gezilenyol[][]=new int[yukseklık][genislik];
	   	
	    	
	    	System.out.println("yukseklık:"+yukseklık);
	    	System.out.println("genişlik:"+genislik);
	    	
	    	      

	        int ilkgiriss=0;	
			int içart=0;
	        // System.out.println(yukseklık); 		
	         
	        for(int i=0;i<yukseklık;i++)
	        {
	      	  
	      	  for(int j=0;j<genislik;j++)
	      	  {
	      		  ilkgiriss++;
	      		  içart++;
	      		  if(ilkgiriss>1)
	      		                    {
	      			  
	      		  
	      		  
	      		  
	      		 int bak=0;
	       for(int k=0;k<tutucu.length;k++)		
	       {
	      	 if(tutucu[k]==i&&tutucu2[k]==j)
	      	        {
	      		 System.out.print("*");
	      		 gezilenyol[i][j]=6;
	      				 ;//gidilmeyen yol0-gezilen yol1
	      	     bak++;
	                   }
	      		  
	       }
	       if(bak==0)
	       {
	       System.out.print("#");
	       }
	      	 
	            }
	       	
	          		
	          }  System.out.println(); 
	  
	  
	                                      }
	    
	    
	        
	        
	        
	        
	        
	        int kont[][]=BFSMazeSolver.digergidilenyollar;
	        
	        
	             
	    	      

	  
	  
	      return gezilenyol;                              
	            
	    
	    }
	    
	    public static void fonksiyon() {
	    	
	    	int labharita[][]=harita;
			int art = 0;
	
			
			
			
			for(int x=0;x<labharita.length;x++)
			{
				for(int y=0;y<labharita[0].length;y++)
				{System.out.print(labharita[x][y]);
					
					if(labharita[x][y]==5||labharita[x][y]==6||labharita[x][y]==2||labharita[x][y]==1)
					{
							art++;
					}
				}System.out.println();
			}
			
			
			
	 String etiket2[]= {"toplam kare","toplam süre"};
	int tussec;		
	int topkare=art;
    tekrar2++;
	tekrar++;
	tussec=JOptionPane.showOptionDialog(null,sonuçharitasınıcizdir(labharita),"sonuç",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null, etiket2,etiket2[1]);
	switch(tussec)
	{
	case 0:
		if(tekrar==1)
		JOptionPane.showMessageDialog(null,"toplam kare:"+"hesaplanıyor");
		else 
			JOptionPane.showMessageDialog(null,"toplam kare:"+topkare);
		uygulamasınıfı.problem1kackare=topkare;
		break;
	case 1:
		if(tekrar2==1)
		JOptionPane.showMessageDialog(null, "toplam gecen süre:"+"hesaplanıyor.....");
		else 
			
			JOptionPane.showMessageDialog(null, "toplam gecen süre:"+labirentANAKISIM.zaman);
		uygulamasınıfı.problem1kacsure=labirentANAKISIM.zaman;
		break;
	default:
			
			System.out.println("yanlış seçim");
	         break;
	}
		
		  
	    
	    }
	    
	    
	    
	    }
