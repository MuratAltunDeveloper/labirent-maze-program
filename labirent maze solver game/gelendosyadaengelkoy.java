package prolabikideneme2;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class gelendosyadaengelkoy {
	static int txtboy;
	static int[][] txtdosyaengelsizstatic;
	public static int kont=0;
	public static int gecis[][];
	public static int[][]fonksiyon() throws IOException, URISyntaxException {
		//bunu fonksiyon1 yaparsın
	

	URL url1=new URL("http://bilgisayar.kocaeli.edu.tr/prolab2/url1.txt");
	URL url2=new URL("http://bilgisayar.kocaeli.edu.tr/prolab2/url2.txt");	
		
	
	HttpURLConnection urlbaglantı1=(HttpURLConnection)url1.openConnection();
	if(urlbaglantı1.getResponseCode()==200)
	{
		InputStream inputStream=urlbaglantı1.getInputStream();
		StringBuffer stringBuffer=new StringBuffer();
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
		String lineString=bufferedReader.readLine();
		
		File labirent=new File("C:\\Users\\murat\\OneDrive\\Masaüstü\\url1.txt");
		FileOutputStream fileOutputStream=new FileOutputStream(labirent);
		BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(fileOutputStream));
		
		while(lineString!=null)
		{
			System.out.println("????"+lineString);
			bufferedWriter.write(lineString);
			bufferedWriter.newLine();
			lineString=bufferedReader.readLine();
		}
		
	bufferedWriter.close();	
	}
	
	System.out.println("?????????????????????????????"+urlbaglantı1.getResponseCode());
	
	
	HttpURLConnection urlbaglantı2=(HttpURLConnection)url2.openConnection();
	if(urlbaglantı2.getResponseCode()==200)
	{
		InputStream inputStream2=urlbaglantı2.getInputStream();
		StringBuffer stringBuffer2=new StringBuffer();
		BufferedReader bufferedReader2=new BufferedReader(new InputStreamReader(inputStream2));
		String lineString2=bufferedReader2.readLine();
		
		File labirent=new File("C:\\Users\\murat\\OneDrive\\Masaüstü\\url2.txt");
		FileOutputStream fileOutputStream2=new FileOutputStream(labirent);
		BufferedWriter bufferedWriter2=new BufferedWriter(new OutputStreamWriter(fileOutputStream2));
		
		while(lineString2!=null)
		{
			System.out.println("????"+lineString2);
			bufferedWriter2.write(lineString2);
			bufferedWriter2.newLine();
			lineString2=bufferedReader2.readLine();
		}
		
		bufferedWriter2.close();
	}
	System.out.println("?????????????????????????????"+urlbaglantı2.getResponseCode());

	
	
	
	
	
		
		
		
		
		
		
		
		
		
		
		

if(kont==0)
{


/*
 aslında resmi bir URL file:///c|/files/someFile.dat olacaktır.

*/	
	File labirent=new File("C:\\Users\\murat\\OneDrive\\Masaüstü\\url2.txt");
//url'ler her zaman protokol:// ile başlar ve ardından ayırıcı olarak '/' ile yol + adlar
//kötü pencereler IE bazen '/' yerine '\' kullanır, ancak resmi kullanım '/' şeklindedir.



FileReader fReader=new FileReader(labirent);

	    BufferedReader bfrreadeReader=new BufferedReader(fReader);
	    txtboy=bfrreadeReader.readLine().length();
	 String lineString;
	 char[][]  txtmetni=new char[txtboy][txtboy];
	 int [][]  inttxtmetni=new int[txtboy][txtboy];
int art=0;
	 while((lineString=bfrreadeReader.readLine())!=null)
	 {
		 System.out.println("-"+lineString);
		 txtmetni[art]=lineString.toCharArray();
		 art++;
	 }
	    
	    
	    
	  
	     bfrreadeReader.close();
	   
	    
	    
	     
	     
	     
	     FileInputStream flinStream=new FileInputStream(labirent);
	     BufferedInputStream bfrStream=new BufferedInputStream(flinStream);
	     int temp;
	     int gecici[]=new int[txtboy];
	     int artım=0;
	     while((temp=bfrStream.read())!=-1)
	     {if(artım<txtboy)
  {
	   	gecici[artım]=Integer.parseInt((char)temp+"");
	     artım++;  	 
  }
	   
	     }
	     
	  
		
		
		
		
		
		
		
		System.out.println("\n\n");
		
		
		for(int i=0;i<txtboy;i++)
		{
			for(int j=0;j<txtboy;j++)
			{
                        if(txtmetni[i][j]=='3'||txtmetni[i][j]=='2'||txtmetni[i][j]=='1'||txtmetni[i][j]=='0')
				
                        	{System.out.print(txtmetni[i][j]);
				inttxtmetni[i][j]=Integer.parseInt(txtmetni[i][j]+"");
                        	}
			}System.out.println();
		}
		
		System.out.println("en son int hali");
		
		for(int i=0;i<txtboy;i++)
		{
			for(int j=0;j<txtboy;j++)
			{
 System.out.print(inttxtmetni[i][j]);
				
			}System.out.println();
		}
		
	int[][]	inttxtmetniyeni=new int[txtboy][txtboy];
		
		for(int i=0;i<txtboy;i++)
		{
			for(int j=0;j<txtboy;j++)
			{
				if(i<txtboy-1)
				{
					inttxtmetniyeni[i+1][j]=inttxtmetni[i][j];
				}
				
			}
		}
		System.out.println("0 ları duzeltmeye calışma");
		
		for(int i=0;i<txtboy;i++)
		{
			for(int j=0;j<txtboy;j++)
			{
				if(i==0)
				{
					inttxtmetniyeni[i][j]=gecici[j];
				}
				
				
 System.out.print(inttxtmetniyeni[i][j]);
				
			}System.out.println();
		}
		
		
		
		
		
		System.out.println("SON HAL");
		for(int i=0;i<txtboy;i++)
		{
			for(int j=0;j<txtboy;j++)
			{
				
 System.out.print(inttxtmetniyeni[i][j]);
				
			}System.out.println();
		}
		
		
	//	txtdosyaengelsizstatic=inttxtmetniyeni;
		//burdada engel koyacak olan fonksiyon2 var
	
gecis=fonksiyon2(inttxtmetniyeni);
}

if(kont>0&&kont%2==1)
{
	
	
	System.out.println("URL İÇİNDE  kont%2==1 olan");
	
	
	
	File labirent=new File("C:\\Users\\murat\\OneDrive\\Masaüstü\\url1.txt");
	




FileReader fReader=new FileReader(labirent);

	    BufferedReader bfrreadeReader=new BufferedReader(fReader);
	    txtboy=bfrreadeReader.readLine().length();
	 String lineString;
	 char[][]  txtmetni=new char[txtboy][txtboy];
	 int [][]  inttxtmetni=new int[txtboy][txtboy];
int art=0;
	 while((lineString=bfrreadeReader.readLine())!=null)
	 {
		 System.out.println("-"+lineString);
		 txtmetni[art]=lineString.toCharArray();
		 art++;
	 }
	    
	    
	    
	  
	     bfrreadeReader.close();
	   
	    
	    
	     
	     
	     
	     FileInputStream flinStream=new FileInputStream(labirent);
	     BufferedInputStream bfrStream=new BufferedInputStream(flinStream);
	     int temp;
	     int gecici[]=new int[txtboy];
	     int artım=0;
	     while((temp=bfrStream.read())!=-1)
	     {if(artım<txtboy)
  {
	   	gecici[artım]=Integer.parseInt((char)temp+"");
	     artım++;  	 
  }
	   
	     }
	     
	  
		
		
		
		
		
		
		
		System.out.println("\n\n");
		
		
		for(int i=0;i<txtboy;i++)
		{
			for(int j=0;j<txtboy;j++)
			{
                        if(txtmetni[i][j]=='3'||txtmetni[i][j]=='2'||txtmetni[i][j]=='1'||txtmetni[i][j]=='0')
				
                        	{System.out.print(txtmetni[i][j]);
				inttxtmetni[i][j]=Integer.parseInt(txtmetni[i][j]+"");
                        	}
			}System.out.println();
		}
		
		System.out.println("en son int hali");
		
		for(int i=0;i<txtboy;i++)
		{
			for(int j=0;j<txtboy;j++)
			{
 System.out.print(inttxtmetni[i][j]);
				
			}System.out.println();
		}
		
	int[][]	inttxtmetniyeni=new int[txtboy][txtboy];
		
		for(int i=0;i<txtboy;i++)
		{
			for(int j=0;j<txtboy;j++)
			{
				if(i<txtboy-1)
				{
					inttxtmetniyeni[i+1][j]=inttxtmetni[i][j];
				}
				
			}
		}
		System.out.println("0 ları duzeltmeye calışma");
		
		for(int i=0;i<txtboy;i++)
		{
			for(int j=0;j<txtboy;j++)
			{
				if(i==0)
				{
					inttxtmetniyeni[i][j]=gecici[j];
				}
				
				
 System.out.print(inttxtmetniyeni[i][j]);
				
			}System.out.println();
		}
		
		
		
		
		
		System.out.println("SON HAL");
		for(int i=0;i<txtboy;i++)
		{
			for(int j=0;j<txtboy;j++)
			{
				
 System.out.print(inttxtmetniyeni[i][j]);
				
			}System.out.println();
		}
		
		
	//	txtdosyaengelsizstatic=inttxtmetniyeni;
		//burdada engel koyacak olan fonksiyon2 var
		
gecis=fonksiyon2(inttxtmetniyeni);
}
if(kont>0&&kont%2==0)
{
	
	
	System.out.println("URL İÇİNDE   kont%'==0 olan");
	
	
	
	File labirent=new File("C:\\Users\\murat\\OneDrive\\Masaüstü\\url2.txt");
	




FileReader fReader=new FileReader(labirent);

	    BufferedReader bfrreadeReader=new BufferedReader(fReader);
	    txtboy=bfrreadeReader.readLine().length();
	 String lineString;
	 char[][]  txtmetni=new char[txtboy][txtboy];
	 int [][]  inttxtmetni=new int[txtboy][txtboy];
int art=0;
	 while((lineString=bfrreadeReader.readLine())!=null)
	 {
		 System.out.println("-"+lineString);
		 txtmetni[art]=lineString.toCharArray();
		 art++;
	 }
	    
	    
	    
	  
	     bfrreadeReader.close();
	   
	    
	    
	     
	     
	     
	     FileInputStream flinStream=new FileInputStream(labirent);
	     BufferedInputStream bfrStream=new BufferedInputStream(flinStream);
	     int temp;
	     int gecici[]=new int[txtboy];
	     int artım=0;
	     while((temp=bfrStream.read())!=-1)
	     {if(artım<txtboy)
  {
	   	gecici[artım]=Integer.parseInt((char)temp+"");
	     artım++;  	 
  }
	   
	     }
	     
	  
		
		
		
		
		
		
		
		System.out.println("\n\n");
		
		
		for(int i=0;i<txtboy;i++)
		{
			for(int j=0;j<txtboy;j++)
			{
                        if(txtmetni[i][j]=='3'||txtmetni[i][j]=='2'||txtmetni[i][j]=='1'||txtmetni[i][j]=='0')
				
                        	{System.out.print(txtmetni[i][j]);
				inttxtmetni[i][j]=Integer.parseInt(txtmetni[i][j]+"");
                        	}
			}System.out.println();
		}
		
		System.out.println("en son int hali");
		
		for(int i=0;i<txtboy;i++)
		{
			for(int j=0;j<txtboy;j++)
			{
 System.out.print(inttxtmetni[i][j]);
				
			}System.out.println();
		}
		
	int[][]	inttxtmetniyeni=new int[txtboy][txtboy];
		
		for(int i=0;i<txtboy;i++)
		{
			for(int j=0;j<txtboy;j++)
			{
				if(i<txtboy-1)
				{
					inttxtmetniyeni[i+1][j]=inttxtmetni[i][j];
				}
				
			}
		}
		System.out.println("0 ları duzeltmeye calışma");
		
		for(int i=0;i<txtboy;i++)
		{
			for(int j=0;j<txtboy;j++)
			{
				if(i==0)
				{
					inttxtmetniyeni[i][j]=gecici[j];
				}
				
				
 System.out.print(inttxtmetniyeni[i][j]);
				
			}System.out.println();
		}
		
		
		
		
		
		System.out.println("SON HAL");
		for(int i=0;i<txtboy;i++)
		{
			for(int j=0;j<txtboy;j++)
			{
				
 System.out.print(inttxtmetniyeni[i][j]);
				
			}System.out.println();
		}
		
		
	//	txtdosyaengelsizstatic=inttxtmetniyeni;
		//burdada engel koyacak olan fonksiyon2 var
	
gecis=fonksiyon2(inttxtmetniyeni);
}  kont++;

System.out.println("kont:::::::::::::"+kont);
	return gecis;
		
	}
	
	public static int[][] fonksiyon2(int txtmetinengelsiz[][])
	{
		int[][]deneme=new int[txtboy+2][txtboy+2];
		
		System.out.println("\n\n\n\n\n\nFONKSİYON 2");
		for(int i=0;i<txtboy;i++)
		{
			for(int j=0;j<txtboy;j++)
			{
				
 System.out.print(txtmetinengelsiz[i][j]);
				
			}System.out.println();
		}
		
		
		
int kac2x2=0;
int kac3x3=0;
for(int i=0;i<txtboy;i++)
{
	for(int j=0;j<txtboy;j++)
	{
		
if(txtmetinengelsiz[i][j]==3)
{
	kac3x3++;
}
if(txtmetinengelsiz[i][j]==2)
{
	kac2x2++;
}
	}
}

kac2x2/=4;
kac3x3/=9;
System.out.println(kac2x2+"  "+kac3x3);
engel2 engel2nesneleri[]=new engel2[kac2x2];
engel3 engel3nesneleri[]=new engel3[kac3x3];

for(int x=0;x<engel2nesneleri.length;x++)
{
engel2nesneleri[x]=new engel2();	
}
for(int y=0;y<engel3nesneleri.length;y++)
{
engel3nesneleri[y]=new engel3();
}
		
System.out.println("engel2 ve engel3 random");
System.out.println(kac2x2+"   "+kac3x3);
System.out.println();
int engel3koy[][][]=new int[kac3x3][3][3];
int engel2koy[][][]=new int[kac2x2][2][2];
int kac3x3sayac=0,kac2x2sayac=0;



for(int x=0;x<engel2nesneleri.length;x++)
{
engel2koy[kac2x2sayac]=engel2nesneleri[x].sekilolusturucu().clone();
kac2x2sayac++;
}
for(int y=0;y<engel3nesneleri.length;y++)
{
engel3koy[kac3x3sayac]=engel3nesneleri[y].sekilolusturucu().clone();
kac3x3sayac++;
}

//kontrol////////////////
for(int x=0;x<engel2nesneleri.length;x++)
{
for(int w=0;w<2;w++)
     {
	for(int w2=0;w2<2;w2++)
	{
	System.out.print(engel2koy[x][w][w2]);
	}System.out.println();  
	}
System.out.println("*******");
}

System.out.println(engel3koy.length);
System.out.println("*****************");
//////////////////////////
int artım3=0;
int artım2=0;

int icartx=0,icarty=0;




//  engeleri yerine koyma kaldı

for(int x=0;x<txtmetinengelsiz.length;x++)
{
for(int y=0;y<txtmetinengelsiz[0].length;y++)
        {
         if(txtmetinengelsiz[x][y]==3) 
         {
        	 while(icarty<3)
        	            {
        		 
        		 
        		 
           txtmetinengelsiz[x+icartx][y+icarty]=engel3koy[artım3][icartx][icarty];
      //    System.out.print("x:"+x+"y:"+y);
          		  if(icartx==2)
           {icarty++;
        	icartx=0;
           }else {
			  icartx++;
		}
          		
           
          
        	             }
        //	 System.out.println("dongu dısı"+artım3);
           icarty=0;artım3++;icartx=0;
           
        	 
         }
	
         
         if(txtmetinengelsiz[x][y]==2) 
         {
        	 while(icarty<2)
        	            {
        	 
           txtmetinengelsiz[x+icartx][y+icarty]=engel2koy[artım2][icartx][icarty];
         //  System.out.println("x2:"+x+"y2:"+y);	 
        //   System.out.println("artım2::"+artım2);
           if(icartx==1)
           {icarty++;
        	icartx=0;
           } 
           	  else
           	  {
           		  icartx++;
           	  }
           
          
        	             }
             System.out.println("dongu dişi"+artım2);
                         artım2++;
                    	 icarty=0;
                    	 icartx=0;
                     
           
        	 
         }
	
	
	
        }

}







System.out.println("en son sistem hali");
for(int x=0;x<txtmetinengelsiz.length;x++)
{
for(int y=0;y<txtmetinengelsiz[0].length;y++)
        {

		System.out.print(txtmetinengelsiz[x][y]);   
	    
	    
        }
System.out.println();

}




for(int i=0;i<txtmetinengelsiz.length;i++)
{
for(int j=0;j<txtmetinengelsiz[0].length;j++)
{	
	deneme[i+1][j+1]=txtmetinengelsiz[i][j];
}

}	


for(int i=0;i<deneme.length;i++)
{
for(int j=0;j<deneme[0].length;j++)
{	
	
	if(i==0)
	deneme[i][j]=1;
	if(i==deneme.length-1)
		deneme[i][j]=1;
	if(j==0)
		deneme[i][j]=1;
	if(j==deneme[0].length-1)
		deneme[i][j]=1;
	//System.out.print(deneme[i][j]);
}//System.out.println();

}	



System.out.println("test deneme");
for(int i=0;i<txtmetinengelsiz.length+2;i++)
{
for(int j=0;j<txtmetinengelsiz[0].length+2;j++)
{	
//	deneme[i][j]=txtmetinengelsiz[i][j];
System.out.print(deneme[i][j]);
}System.out.println();

}	



return deneme;
		
	}
	
	
}
