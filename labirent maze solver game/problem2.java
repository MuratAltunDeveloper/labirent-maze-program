package prolabikideneme2;




import java.awt.*;
import java.beans.IntrospectionException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;

import javax.swing.*;



/**
 * Rastgele bir labirent oluşturur, ardından içinden bir yol bularak çözer.
 * Sol üst köşeden sağ alt köşeye. (Yaptıktan sonra
 * Bir labirent, bir süre bekler ve ardından bir labirent oluşturarak yeniden başlar.
 * yeni rastgele labirent.)
 */
 public class problem2 extends JPanel implements Runnable {

	 
	 
	 public static int txtatenkısayol[][]=new int[100][100];
	 public static int txtatgezilenyol[][]=new int[100][100];
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
public static int kackaregezdi=0;
int sonucgostergiris=0;
  
public static int yeter=0;

 static JFrame window = new JFrame("labirent yaratıcı ve çözücü");
  
  
	 public static void main(String[] args) {
    // Create a new JFrame object and set its title

   // JFrame'in içerik bölmesini Maze sınıfının yeni bir örneğine ayarlayın
  
	

    		window.setContentPane(new problem2());
	
 // JFrame'i bileşenlerinin tercih edilen boyutuna uyacak şekilde paketleyin
    window.pack();
 // JFrame'in ekrandaki konumunu ayarla
    window.setLocation(120,120);
 // JFrame kapatıldığında uygulamadan çıkmak için varsayılan kapatma işlemini ayarlayın
   // window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // Make the JFrame visible
    window.setVisible(true);
    //GORSEL ARAYUZ KAPANDI
	// bir ana rutin, bu sınıfı bir program olarak çalıştırmayı mümkün kılar
    
       
    
    
 
    
    }

	 
 public  int deger=0;//deger static yaparsak artmıyor
public static int mazetutucu[][];
 
 public static int gidilenyoltutucu[][]=new int[100][100];
public static int gidilenyolbirbirimetrafınıtutma[][]=new int[300][300];	 
    int[][] maze; 
 // Labirentin durumunun açıklaması. Labirentin değeri[i][j]
    // wallCode, pathcode, emptyCode sabitlerinden biridir,
    // veya ziyaret edilenKod. (Değer geçici olarak negatif de olabilir,
    // createMaze() içinde.)
    // Bir labirent duvarlardan ve koridorlardan oluşur. labirent[i][j]
    // ya bir duvarın parçası ya da bir koridorun parçası. Bir hücre
    // bir koridorun parçası olan hücre pathCode ile temsil edilir
    // labirentteki geçerli yolun parçasıysa,
    // daha önce araştırılmışsa ve bulamadan ziyaret edilen Kod
    // bir çözüm ve henüz araştırılmamışsa emptyCode tarafından. 
    final static int backgroundCode = 0;//arkaplan
    final static int wallCode = 1;//duvar kodu
    final static int pathCode = 2;//yol kodu
    final static int emptyCode = 3;//daha önce arastırılmamıssa
    final static int visitedCode = 4;//ziyaret edilen

    Color[] color;// önceki 5 sabitle ilişkili renkler;
   


    
    
    //sleeptime labirentdegiştir için kullan
    
    
    
    public static int aydınlatıcı[][]=new int[100][100];
    
    
    


	int rows ; //tek sayı olmalı cift hatalı
	// kenarları çevreleyen bir duvar da dahil olmak üzere labirentteki hücre sıralarının sayısı
    int columns ; 
 // kenarları çevreleyen bir duvar da dahil olmak üzere labirentteki hücre sütunlarının sayısı
    int border = 10;
    // labirent ile panelin kenarı arasındaki minimum piksel sayısı 
   
    int sleepTime = 200;
 // bir labirenti çözdükten sonra yenisini yapmadan önce bekleme süresi
    int uykudakalmasure ;
 // labirent yapma ve çözme adımları arasındaki kısa gecikme
    int blockSize = 12;

 // her hücrenin boyutu
    int width = -1;

 // boyutcheck() tarafından ayarlanacak panel genişliği
    int height = -1; 
 // boyutcheck() tarafından ayarlanacak panel yüksekliği

    int totalWidth; 

 // panel genişliği, eksi kenarlık alanı (boyutcheck() içinde ayarlanır)
    int totalHeight; 

 // panelin yüksekliği, eksi kenarlık alanı (boyutcheck() içinde ayarlanır)
    int left;

 // labirentin sol kenarı, sınıra izin veriyor (boyutcheck() içinde ayarlanmış)
    int top;
 // labirentin üst kenarı, sınıra izin veriyor (boyutcheck() içinde ayarlanmış)
    boolean labirentcıkıss = false; 
 // labirent[][] geçerli olduğunda true olarak ayarlayın; kullanılan
    // yeniden çizMaze(); createMaze() içinde true olarak ayarlayın ve
    // run()'da false'a sıfırla
    
    
    
    
    public static int engel[][]=new int[100][100];
    
    //RANDOM BALANGIC VE BİTİS DEGERLERİ
  static  int	basx;
  static  int	basy;
   static int	bitx;
   static int	bity;
    public static int oyusatır,oyusutun;		
    
    
    
    
    public void ata()
    {
    	for(int i=0;i<aydınlatıcı.length;i++)
    	{
    		for(int j=0;j<aydınlatıcı[0].length;j++)
    		{
    			aydınlatıcı[i][j]=0;
    		}
    	    		
    	}
    }
    
    
    
    
    public void sorgula()
    {
     	ata();
    	
    	String satırlar=JOptionPane.showInputDialog(null,"oluşturulacak labirentin satır boyu:");
      rows=Integer.parseInt(satırlar);
      
      String sutunlar=JOptionPane.showInputDialog(null,"oluşturulacak labirentin sutun boyu:");
      columns=Integer.parseInt(sutunlar);
      
   		
      
      String cozmehızı=JOptionPane.showInputDialog(null,"oluşturulacak labirenti cozme hızı:");
      uykudakalmasure=Integer.parseInt(cozmehızı);
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      if(rows%2==0)
      {
    	  rows++;
      }
      if(columns%2==0)
      {
    	  columns++;
      }
      
      
      
      
    }
    public problem2() {
    	
    	sorgula();
   
    	
    	//kullanıcıdan veri alma
    	
    	
    	
   
    	
    	
        color = new Color[] {
                new Color(0, 0,0),
                new Color(0,0,153),
                new Color(0,255, 51),
                Color.WHITE,
                new Color(0, 0, 0)
        };
        setBackground(color[backgroundCode]);
        setPreferredSize(new Dimension(blockSize * columns, blockSize * rows));
        new Thread(this).start();
    }

    void boyutcheck() {

    	// Çizim için kullanılan parametreleri ayarlamak için labirenti çizmeden önce çağrılır.
    	if (getWidth() != width || getHeight() != height) {
            width = getWidth();
            height = getHeight();
            int w = (width - 2 * border) / columns;
            int h = (height - 2 * border) / rows;
            left = (width - w * columns) / 2;
            top = (height - h * rows) / 2;
            totalWidth = w * columns;
            totalHeight = h * rows;
        }
    }

    synchronized protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        boyutcheck();
        yenidenciz(g);
    }

    void yenidenciz(Graphics g) {
    	// tüm labirenti çizer
        if (labirentcıkıss) {
            int w = totalWidth / columns; // her hücrenin genişliği
            int h = totalHeight / rows; // her hücrenin yuksekligi
            for (int j = 0; j < columns; j++)
                for (int i = 0; i < rows; i++) {
                    if (maze[i][j] < 0)
                        g.setColor(color[emptyCode]);
                    else
                        g.setColor(color[maze[i][j]]);
                    g.fillRect((j * w) + left, (i * h) + top, w, h);
                }
        }
    }
    
    public void labirentciz(int ciz[][])
    {
    	
    	String goruntu="<html><table>";
		for(int i=0;i<ciz.length;i++)
		{goruntu+="<tr>";
			for(int j=0;j<ciz[0].length;j++)
			{   if(ciz[i][j]==1)
			{
				goruntu+="<td bgcolor='black' width=15 ></td> ";
				
			}
		
			if(ciz[i][j]==3)
			{
				goruntu+="<td bgcolor='white' width=15></td>";
			}
			
			

			}
		
		
		}
		goruntu+="</tr>";
		goruntu+="</table></html>";

		JOptionPane.showMessageDialog(null, goruntu);
		
		
    }
    
    public void run()  {
//diger labirente gecmeden maze al 
    long randstart=System.currentTimeMillis();
    
    	 	// iş parçacığı için çalıştırma yöntemi art arda bir labirent oluşturur ve sonra onu çözer
    	try {
            Thread.sleep(1000);
        } // başlamadan önce biraz bekleyin
        catch (InterruptedException e) {
        }
        while (true) {
        	
       var sorgu=JOptionPane.showConfirmDialog(null,"YES-LABİRENTDEĞİŞTİR/NO-ÇALISTIR/CANCEL-SONUÇGÖSTER");
        	labirentyaratıcı();
        	//**********************************
        	//
        	
    	
        	
        	
        	
        	Random ratsgeleRandom=new Random();
        	
            int deger=ratsgeleRandom.nextInt();
            while(deger<0)
            {
            	deger=ratsgeleRandom.nextInt();
            }
            	deger%=2;
            	if(deger==0)
            	{
            	basx=1;
            	basy=1;
            	bitx=rows-2;
            	bity=columns-2;
            	
                    System.out.println("bitiş:"+bitx+"+"+bity);
            		
            		System.out.println("baslangıc:"+basx+"+"+basy);
            		
            		
            		System.out.println(0);
            	}
            	if(deger==1)
            	{
            		
            		
            		basx=1;
            		basy=columns-2;
            		bitx=rows-2;
            		bity=1;

            		
                    System.out.println("bitiş:"+bitx+bity);
            		
            		System.out.println("baslangıc:"+basx+basy);
           
            		
            		System.out.println(1);
            	}
            	
            	
            	
            	
            	for(int i=0;i<maze.length;i++)
            	{
            	for(int j=0;j<maze[0].length;j++)
            	{
            		if(maze[i][j]==3)
            		{    if(i>=1&&i<maze.length-1)
            		{
            			if(maze[i][j-1]==1&&maze[i][j+1]==1)
            			{	if(maze[i+1][j]==1||maze[i-1][j]==1)
            				{
            				if((i!=basx&&j!=basy)&&(i!=bitx&&j!=bity))
            				{
            					//engel 1olarak
            				System.out.println(i+"---"+j);
            				maze[i][j]=1;
            				engel[i][j]=-1;//engele -1 atadım
            				if(yeter>10)
            				{
            					break;
            				}
            				yeter++;
            				}
            					
            				}
            			}
            			
            		}
            		}
            	}
            	
            	
            	}
            	
            	          	
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	
       if(sorgu==0)
        {
        	
        	for(int i=0;i<maze.length;i++)
        	{
        		for(int j=0;j<maze[0].length;j++)
        		{ 
        			System.out.print(maze[i][j]);
        		}System.out.println();
        	}
            
       labirentciz(maze);
      
        }
       
       
       
       
       
       
    
        if(sorgu==1)
        {
        
        	oyusatır=basx;
        	oyusutun=basy;
        	// sorgu1
        	Object etiket[]= {"saga","sola","yukarı","asagı","cıkış"};
        	int tussec;
        	
        	
        	
        	maze[oyusatır][oyusutun]=-1;//oyuncu un oldugu yere -1 ata
        	

        	
        	while(maze[bitx][bity]!=-1)
        	{
        		tussec=JOptionPane.showOptionDialog(null,labirentadımadımciz(maze),"LABİRENT OYUNU",JOptionPane.DEFAULT_OPTION,
        				JOptionPane.INFORMATION_MESSAGE,null,etiket,etiket[4]);
                 	
        	maze[oyusatır][oyusutun]=0;//yolu actık
        	
        switch(tussec)
        {
        case 0:
        	oyusutun=sagagit(oyusutun,maze,oyusatır);
        	break;
        case 1:
        	oyusutun=solagit(oyusutun,maze,oyusatır);
        	 break;
        case 2:
        	oyusatır=yukarıgit(oyusutun,maze,oyusatır);
        	break;
        case 3:
        	oyusatır=asagıgit(oyusutun,maze,oyusatır);
        	break;
        case 4:
        	System.exit(0);


        }
        maze[oyusatır][oyusutun]=-1;
        	} 	
        	
        	
        	
        	
        	
        	
        	
        	
        }
    
        if(sorgu==2)
        {sonucgostergiris++;
        System.out.println("////"+sonucgostergiris);
     if(sonucgostergiris>1)
     {
    	 
    	 JOptionPane.showMessageDialog(null,enkısapathlabirent(mazetutucu));
    	 
    	 
     }
     
     
     
        if(sonucgostergiris<=1){
			 Long randend=System.currentTimeMillis();
          
        	
        	   labirentcoz(basx,basy);//baslangıc yeri !!!!!!!!!!!!!!!!!!!!!11
        	System.out.println("exit");
        	JOptionPane.showMessageDialog(null,"toplam saniye:"+(randend-randstart)/1000);
        	  uygulamasınıfı.problem2kacsure=(randend-randstart)/1000;      
        	for(int i=0;i<maze.length;i++)
        	{
        		for(int j=0;j<maze[0].length;j++)
        		{
        			System.out.print(maze[i][j]);
        			if(maze[i][j]==4)
        			{kackaregezdi++;
        				
        			}
        			if(maze[i][j]==2)
        			{kackaregezdi++;
        				
        			}
        		}System.out.println();
        	}
    
        	
      mazetutucu=new int[maze.length][maze[0].length];
        	
	        
	for(int i=0;i<maze.length;i++)
	{
		for(int j=0;j<maze[0].length;j++)
		{
			//System.out.print(maze[i][j]);
			mazetutucu[i][j]=maze[i][j];
			
		}
	}
        
        	
     JOptionPane.showMessageDialog(null,"ziyaret edilen kare sayısı:"+kackaregezdi);
        
     uygulamasınıfı.problem2kackare=kackaregezdi;
		}
            }
        	
       
         
            
            
            //labirent için
            //duvar=1;
            //en kısayol=2
            //ziyaret edilen yol=4
            //ziyaret edilmeyen yol=3
          
            
    
        	
        	
        	
        	
            
            System.out.println("**********************");
            
            
            
            
            
            
            
            
            
            
            synchronized (this) {
                try {
                	
                	
                    wait(sleepTime);
                } catch (InterruptedException e) {
                }
            }
            labirentcıkıss = false;
            repaint();
        }
    }
//************************************Labirent adımadımçiz
public String enkısapathlabirent(int labkare[][])
		{
	
	
	
	String ekranString="<html><table>";
	
	






	
	for(int i=0;i<maze.length;i++)
	{ekranString+="<tr>";
		for(int j=0;j<maze[0].length;j++)
		{
			
			
			
			 if(labkare[i][j]==1)
				{
					ekranString+="<td bgcolor='black' width=25 ></td> ";
					
				}
		
				else if(labkare[i][j]==3)
				{
				if(i==basx&&j==basy)
				{txtatgezilenyol[i][j]=1;
					ekranString+="<td bgcolor='white' width=25></td>";
				}
				else if(i==bitx&&j==bity)
				{txtatgezilenyol[i][j]=1;
					ekranString+="<td bgcolor='white' width=25></td>";
				}
				else {
					txtatgezilenyol[i][j]=1;
					ekranString+="<td bgcolor='white'  width=25></td>";
				}
				}
				else if(labkare[i][j]==4)
				{ txtatgezilenyol[i][j]=1;
					ekranString+="<td bgcolor='white'  width=25></td>";
				}
				else {
                  txtatenkısayol[i][j]=1;
               txtatgezilenyol[i][j]=1;
               ekranString+="<td bgcolor='yellow'  width=25></td>";
			
				}
	      
		
		
			
		}
	
	
	}
	
	enkısayolata();
	gezilenata();
	
	ekranString+="</tr>";
	ekranString+="</table></html>";
	return ekranString;
	
	
	
	
	
	
	
		}
    
public  void enkısayolata()
{
	
	try {	

		String ataString="";
		for(int i=0;i<maze.length;i++)
		{
			for(int j=0;j<maze[0].length;j++)
			{
				ataString+=txtatenkısayol[i][j]+"";
			}
			ataString+="\n";
		}
		
		
		
		
			File dosya=new File("C:\\Users\\murat\\OneDrive\\Masaüstü\\problem2içinenkısayolv egezilenkaresayısı.txt");
			FileWriter fwriterFile=new FileWriter(dosya);
			BufferedWriter bfrWriter=new BufferedWriter(fwriterFile);
			
			bfrWriter.write(ataString);
			bfrWriter.close();
        
	
	
	
	}
	catch (Exception e) {
		// TODO: handle exception
		System.err.println("satır 710");
	}



}
public  void gezilenata()
{
	
	try {	

		String ataString2="";
		for(int i=0;i<maze.length;i++)
		{
			for(int j=0;j<maze[0].length;j++)
			{
				System.out.println("+++"+i+"+++"+j);
				ataString2+=txtatgezilenyol[i][j]+"";
			}
			ataString2+="\n";
		}
		
		
		
		
			File dosya=new File("C:\\Users\\murat\\OneDrive\\Masaüstü\\problem2icingezilenkareler.txt");
			FileWriter fwriterFile=new FileWriter(dosya);
			BufferedWriter bfrWriter=new BufferedWriter(fwriterFile);
			
			bfrWriter.write(ataString2);
			bfrWriter.close();
        
	
	
	
	}
	catch (Exception e) {
		// TODO: handle exception
		System.err.println("satır 752");
	}



}





    
	public JPanel labirentadımadımciz(int labharita[][]) 
	{

		
	JPanel arayuzPanel=new JPanel();
	int x=0,y=0;
	JButton[][] btndizi=new JButton[labharita.length][labharita[0].length];	
	
	
	
	
	
	for(int i=0;i<labharita.length;i++)
	{
		for(int j=0;j<labharita[0].length;j++)
		{
			if(gidilenyoltutucu[i][j]!=0)
			{
			//gidilen yollar bir birim etrafına -2 ata
				gidilenyolbirbirimetrafınıtutma[i][j]=-2;
				gidilenyolbirbirimetrafınıtutma[i][j-1]=-2;
				gidilenyolbirbirimetrafınıtutma[i][j+1]=-2;
				
				
				gidilenyolbirbirimetrafınıtutma[i-1][j]=-2;
				gidilenyolbirbirimetrafınıtutma[i-1][j-1]=-2;
				gidilenyolbirbirimetrafınıtutma[i-1][j+1]=-2;
				
				
				gidilenyolbirbirimetrafınıtutma[i+1][j]=-2;
				gidilenyolbirbirimetrafınıtutma[i+1][j-1]=-2;
				gidilenyolbirbirimetrafınıtutma[i+1][j+1]=-2;
				
			 
				
			}
		}
	}
			
	               			
		
		for(int i=0;i<labharita.length;i++)
		{
			for(int j=0;j<labharita[0].length;j++)
			{
		  btndizi[i][j]=new JButton();
				if(labharita[i][j]==1)
				{
					if(gidilenyolbirbirimetrafınıtutma[i][j]==-2)
					{btndizi[i][j].setBackground(Color.black);
					}else {
						btndizi[i][j].setBackground(Color.gray);
					}
						
						
				}
				else if(labharita[i][j]==3)
				{
				if(i==basx&&j==basy)
				{
					if(gidilenyolbirbirimetrafınıtutma[i][j]==-2)
					{
					btndizi[i][j].setBackground(Color.white);
					btndizi[i][j].setText("s");
					}else {
						btndizi[i][j].setBackground(Color.gray);
						btndizi[i][j].setText("s");
						
					}
				
				
				
				}
				else if(i==bitx&&j==bity)
				{
					if(gidilenyolbirbirimetrafınıtutma[i][j]==-2)
					{
					btndizi[i][j].setBackground(Color.white);
					btndizi[i][j].setText("f");
					
					}else {
						btndizi[i][j].setBackground(Color.gray);
						btndizi[i][j].setText("f");
						
					}
				
					
					
				}
				else {
					
					
					if(gidilenyolbirbirimetrafınıtutma[i][j]==-2)
					{
					btndizi[i][j].setBackground(Color.white);
					}else {
						btndizi[i][j].setBackground(Color.gray);
						
					}
				
				}
				}
			
				else {
					btndizi[i][j].setBackground(Color.blue);
				   gidilenyoltutucu[i][j]=-1;
				   //ziyaret edilen yerlere -1 ata
				}
					
					
					
				
				
			btndizi[i][j].setBounds(x,y,15,15);		
		//	btndizi[i][j].setBackground(Color.gray);
			
			arayuzPanel.add(btndizi[i][j]);
	      x=x+16;	
				
			}
			y=y+16;
			x=0;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	   arayuzPanel.setVisible(true);
	   arayuzPanel.setLayout(null); 
	   arayuzPanel.setPreferredSize(new Dimension(500,500));
        window.add(arayuzPanel);
        
			return  arayuzPanel;
	    	

		
		
		
	/*
		
	System.out.println("********deger:"+deger);
		String ekranString="<html><table>";
		
		






		
		for(int i=0;i<maze.length;i++)
		{ekranString+="<tr>";
			for(int j=0;j<maze[0].length;j++)
			{
			
				
				
				
				
				
			if(deger>0)	
			{
				for(int x=0;x<aydınlatıcı.length;x++)
				{
					for(int y=0;y<aydınlatıcı[0].length;y++)
					{if(aydınlatıcı[x][y]!=0)
					  {
						
						
						System.out.println("--------------------"+x+"*"+y);
						
						
						if((x==i&&y-1==j)||(x+1==i&&y-1==j)||(x-1==i&&y-1==j)||(x+1==i&&y==j)||(x==i&&y==j)||(x-1==i&&y==j)||(x+1==i&&y+1==j)||(x==i&&y+1==j)||(x-1==i&&y+1==j))
						    {
						//	System.out.println("icte");
							
							System.out.println("i:"+i+"j:"+j);
							
							
						    if(labkare[i][j]==1)
						    {
						    	ekranString+="<td bgcolor='orange' width=25></td>";//white
								
						    }
						    if(labkare[i][j]==3)
							{
							if(i==basx&&j==basy)
							{
								
								ekranString+="<td bgcolor='white' width=25>s</td>";//white
							}
							else if(i==bitx&&j==bity)
							{
									
								ekranString+="<td bgcolor='white' width=25>f</td>";//white
							}
							else {
								
									
								
								
								ekranString+="<td bgcolor='black'  width=25></td>";//black
							}
							}
						    else {//System.out.println("yol");//duvara gitmeye calısınca konum değişmez
							ekranString+="<td bgcolor='blue' width=25></td>";//blue
							
							aydınlatıcı[i][j]=5;
							
							
							
						}
						    
						
						    
						 
						    
							}   
						    
					//	System.out.println("yol sayısı");
						
					
						
					if((x!=i&&y-1!=j)||(x+1!=i&&y-1!=j)||(x-1!=i&&y-1!=j)||(x+1!=i&&y!=j)||(x!=i&&y!=j)||(x-1!=i&&y!=j)||(x+1!=i&&y+1!=j)||(x!=i&&y+1!=j)||(x-1!=i&&y+1!=j)) 
					{
						 if(labkare[i][j]==1) 
							{
	
				 
				 ekranString+="<td bgcolor='gray' width=25 ></td> ";//orange
				
					
				}
				else if(labkare[i][j]==3)
				{
				if(i==basx&&j==basy)
				{
					ekranString+="<td bgcolor='gray' width=25>s</td>";//white
				}
				else if(i==bitx&&j==bity)
				{
					ekranString+="<td bgcolor='gray' width=25>f</td>";//white
				}
				else {
					ekranString+="<td bgcolor='gray'  width=25></td>";//black
				}
				}
			
				else {//System.out.println("yol");//duvara gitmeye calısınca konum değişmez
					ekranString+="<td bgcolor='blue' width=25></td>";//blue
					
					aydınlatıcı[i][j]=5;
					
					
					
				}
				}
						
						
						
					
					  }
					}
				
				}
				
            
					
			  
			    
				
				
				
				
				
				
					
			}	 
			
		
				
				
				
				
			if(deger==0)	
			{	 if(labkare[i][j]==1) 
								{
		
					 
					 ekranString+="<td bgcolor='gray' width=25 ></td> ";//orange
					
						
					}
					else if(labkare[i][j]==3)
					{
					if(i==basx&&j==basy)
					{
						ekranString+="<td bgcolor='gray' width=25>s</td>";//white
					}
					else if(i==bitx&&j==bity)
					{
						ekranString+="<td bgcolor='gray' width=25>f</td>";//white
					}
					else {
						ekranString+="<td bgcolor='gray'  width=25></td>";//black
					}
					}
				
					else {//System.out.println("yol");//duvara gitmeye calısınca konum değişmez
						ekranString+="<td bgcolor='blue' width=25></td>";//blue
						
						aydınlatıcı[i][j]=5;
						
						
						
					}
					
		
		
			
				
			}
		
		
		}
		
		}
		deger++;
		ekranString+="</tr>";
		ekranString+="</table></html>";
		return ekranString;
	
		
		*/
		
		
		
		
		
		
		
		
		
	}

    

    void fill(int row, int col, int replace, int replaceWith) {
    	// "oda kodlarını" değiştirmek için sökmek() tarafından çağrılır.
    	
    	if (maze[row][col] == replace) {
            maze[row][col] = replaceWith;
            fill(row + 1, col, replace, replaceWith);
            fill(row - 1, col, replace, replaceWith);
            fill(row, col + 1, replace, replaceWith);
            fill(row, col - 1, replace, replaceWith);
        }
    }
  
    
        
     //yukarı gitme saga sola gitme   
        
    public static int sagagit(int oyusutun,int dizikare[][],int oyusatır)
    {
    	oyusutun++;
    	if(oyusutun==dizikare[oyusatır].length||dizikare[oyusatır][oyusutun]==1)
    	{
    		
    		oyusutun--;
    	}
    	
    	
    	
    	
    	return oyusutun;
    	


    }
    public static int solagit(int oyusutun,int dizikare[][],int oyusatır)
    {oyusutun--;
    if(oyusutun==-1||dizikare[oyusatır][oyusutun]==1)
    {
    //solda duvar veya oyuncu varsa oyusutun++
    	oyusutun++;
    	
    }
    	
    	
    	return oyusutun;
    	


    }public static int yukarıgit(int oyusutun,int dizikare[][],int oyusatır)
    {oyusatır--;
    if(oyusatır==-1||dizikare[oyusatır][oyusutun]==1)
    {
    //solda duvar veya oyuncu varsa oyusutun++
    	oyusatır++;
    	
    }
    	
    	
    	
    	return oyusatır;
    	


    }public static int asagıgit(int oyusutun,int dizikare[][],int oyusatır)
    {
    	oyusatır++;
    	if(oyusatır==dizikare.length||dizikare[oyusatır][oyusutun]==1)
    	{
    	//solda duvar veya oyuncu varsa oyusutun++
    		oyusatır--;
    		
    	}
    		
    		
    	
    	return oyusatır;
    	


    }


   

    synchronized void sökmek(int row, int col) {//senkronize geçersiz ayırma
    	// Bir duvarı yıkın, bunu yapmak bir döngü oluşturmayacaksa. Bir duvarı yıkmak
        // iki "oda"yı bir "oda"da birleştirir. (Odalar koridor gibi görünmeye başlar.
        // büyüdükçe.) Bir duvar yıkıldığında bir taraftaki oda kodları
        // diğer taraftakilerle eşleşecek şekilde dönüştürülür, böylece bir odadaki tüm hücreler
        // aynı koda sahip. Oda kodları bir sayfanın her iki yanında yer alıyorsa,
        // duvar zaten aynı koda sahip, o zaman o duvarı yıkmak
        // bir döngü oluşturun, böylece duvar yerinde kalır.
    	if (row % 2 == 1 && maze[row][col - 1] != maze[row][col + 1]) {

    		// sıra tektir; duvar odaları yatay olarak ayırır
    		fill(row, col - 1, maze[row][col - 1], maze[row][col + 1]);
            maze[row][col] = maze[row][col + 1];
            repaint();
            try {
                wait(uykudakalmasure);
            } catch (InterruptedException e) {
            }
        } else if (row % 2 == 0 && maze[row - 1][col] != maze[row + 1][col]) {
        	// satır çifttir; duvar odaları dikey olarak ayırır
        	fill(row - 1, col, maze[row - 1][col], maze[row + 1][col]);
            maze[row][col] = maze[row + 1][col];
            repaint();
            try {
                wait(uykudakalmasure);
            } catch (InterruptedException e) {
            }
        }
    }      
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    void labirentyaratıcı() {
    	// Rastgele bir labirent oluştur. Strateji, başlamaktır
        // duvarlarla ayrılmış bağlantısız "odalar" ızgarası.
        // sonra ayırıcı duvarların her birine rastgele bakın
        // emir. Bir duvarı yıkmak bir döngü oluşturmayacaksa
        // labirentte, sonra onu yıkmak. Aksi takdirde, yerinde bırakın.
    	if (maze == null)
            maze = new int[rows][columns];
        int i, j;
        int boslukkont = 0;
     // oda sayısı
        int duvarkont = 0; 
        //duvar sayısı
        int[] duvarsatır = new int[(rows * columns) / 2]; 

     // odalar arasındaki duvarların konumu
        int[] duvarsutun = new int[(rows * columns) / 2];
        for (i = 0; i < rows; i++)// her şeyin duvar olmasıyla başla
            for (j = 0; j < columns; j++)
                maze[i][j] = wallCode;
        for (i = 1; i < rows - 1; i += 2) 
        	// boş odalardan oluşan bir tablo oluştur
            for (j = 1; j < columns - 1; j += 2) {
                boslukkont++;
                maze[i][j] = -boslukkont; // her oda farklı bir negatif sayı ile temsil edilir

                if (i < rows - 2) {// bu odanın altındaki duvarla ilgili bilgileri kaydet
                    duvarsatır[duvarkont] = i + 1;
                    duvarsutun[duvarkont] = j;
                    duvarkont++;
                }
                if (j < columns - 2) { // bu odanın sağındaki duvarla ilgili bilgileri kaydet
                    duvarsatır[duvarkont] = i;
                    duvarsutun[duvarkont] = j + 1;
                    duvarkont++;
                }
              
                
            }
      
        
      labirentcıkıss = true;
        repaint();
        int r;
        for (i = duvarkont - 1; i > 0; i--) {
            r = (int) (Math.random() * i); 
         // rastgele bir duvar seçin ve belki onu yıkın
            sökmek(duvarsatır[r], duvarsutun[r]);
            duvarsatır[r] = duvarsatır[i];
            duvarsutun[r] = duvarsutun[i];
        }
        for (i = 1; i < rows - 1; i++) // labirentteki[][] negatif değerleri emptyCode ile değiştir
            for (j = 1; j < columns - 1; j++)
                if (maze[i][j] < 0)
                    maze[i][j] = emptyCode;
    }

  

    boolean labirentcoz(int row, int col) {

    	// Mevcut yolu konumdan devam ettirerek labirenti çözmeye çalışın
    	        // (satır, sütun). Bir çözüm bulunursa true döndürün. Labirent
    	        // yol sağ alt hücreye ulaşırsa çözülmüş sayılır.
    	if (maze[row][col] == emptyCode) {
            maze[row][col] = pathCode; 
         // bu hücreyi yola ekle
            repaint();
            if (row == bitx && col == bity)//bitme kosulu !!!!!!!!!!!!!!!!!!!!!!!!!!!!
                return true; 
         // yol hedefe ulaştı
            try {
                Thread.sleep(uykudakalmasure);
            } catch (InterruptedException e) {
            }
            if (labirentcoz(row - 1, col) || // yolu genişleterek labirenti çözmeye çalış
                    labirentcoz(row, col - 1) || 
                 // mümkün olan her yönde
                    labirentcoz(row + 1, col) ||
                    labirentcoz(row, col + 1))
                return true;
         // labirent bu hücreden çözülemez, bu yüzden hücreden geri dön
            maze[row][col] = visitedCode;// hücreyi ziyaret edilmiş olarak işaretle 
            repaint();
            synchronized (this) {
                try {
                    wait(uykudakalmasure);
                } catch (InterruptedException e) {
                }
            }
        }
        return false;
    }
                            
 }
