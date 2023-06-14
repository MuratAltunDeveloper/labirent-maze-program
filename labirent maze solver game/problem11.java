package prolabikideneme2;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyStore.TrustedCertificateEntry;
import java.util.Random;

import javax.naming.directory.NoSuchAttributeException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class problem11 extends JPanel {
	
	
	 
	static int oyuncubassatırı,oyuncubassütunu;
	static int oyuncubitsatırı,oyuncubitsütunu;
		static int oyusatır,oyusutun;
 static int calıstırgir=0;
	static int[][]enkısayol;	
	static int kackezurlgir=0;	
	static String dosyayolu1,dosyayolu2;
	
	
	
static int 	gidilenyolbirbirimetrafınıtutma[][]=new int[300][300];
static int gidilenyoltutucu[][]=new int[100][100];

	public static int calıstırbutonbas=0;
		
	static final  int karebuyukluk=5;
	public static int cıkısart=0;
	
	public static String labirentciz(int labkare[][])
	{
		String ekranString="<html><table>";
		for(int i=0;i<labkare.length;i++)
		{ekranString+="<tr>";
			for(int j=0;j<labkare[0].length;j++)
			{   if(labkare[i][j]==1)
			{
				ekranString+="<td bgcolor='orange' width=25 ></td> ";
				
			}
			else if(labkare[i][j]==0)
			{
			if(i==oyuncubassatırı&&j==oyuncubassütunu)
			{
				ekranString+="<td bgcolor='white' width=25>BA</td>";
			}
			else if(i==oyuncubitsatırı&&j==oyuncubitsütunu)
			{
				ekranString+="<td bgcolor='white' width=25>Bİ</td>";
			}
			else {
				ekranString+="<td bgcolor='red'  width=25></td>";
			}
			}
		
			else {
				ekranString+="<td bgcolor='blue' width=25></td>";
			}
			
			
			
			
				
			}
		
		
		}
		ekranString+="</tr>";
		ekranString+="</table></html>";
		return ekranString;
	}
	
	
		
		
		


	public static String labirentadımadımciz(int labharita[][])
	{
		
	//	int x=0,y=0;
		System.out.println("*****************----------------****************");
		
		for(int i=0;i<labharita.length;i++)
		{
			for(int j=0;j<labharita[0].length;j++)
			{
				System.out.print(labharita[i][j]);
				if(gidilenyoltutucu[i][j]!=0)
				{
					//System.out.print("\n\n 9999999999999999999999999999");
					
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
			}System.out.println();
		}
				
		
		//başlangıç -1 bitiş 3 tür.
		         String ekranString="<html><table>";
	      			
			
			for(int i=0;i<labharita.length;i++)
			{ekranString+="<tr>";
				for(int j=0;j<labharita[0].length;j++)
				{
			  
					if(labharita[i][j]==1)
					{
						if(gidilenyolbirbirimetrafınıtutma[i][j]==-2)
						{ekranString+="<td bgcolor='black' width=25></td>";
						}else {
							ekranString+="<td bgcolor='gray' width=25></td>";	}
							
							
					}
					
					else if(labharita[i][j]==0||labharita[i][j]==3)
					{
					
						
				
				if(i==oyuncubassatırı&&j==oyuncubassütunu)
					{
				//	txtattumgeezilenyerler[i][j]=1;
						if(gidilenyolbirbirimetrafınıtutma[i][j]==-2)
						{
							ekranString+="<td bgcolor='white' width=25>s</td>";
						
						}else {
							ekranString+="<td bgcolor='gray' width=25>s</td>";
						}
					
					
					
					}
				else if(i==oyuncubitsatırı&&j==oyuncubitsütunu)
					{//txtattumgeezilenyerler[i][j]=1;
						if(gidilenyolbirbirimetrafınıtutma[i][j]==-2)
						{
							ekranString+="<td bgcolor='white' width=25>f</td>";	
						}else {
							ekranString+="<td bgcolor='gray' width=25>f</td>";		
						}
					
						
						
					}
											
					else {
						
			//			txtattumgeezilenyerler[i][j]=1;
						if(gidilenyolbirbirimetrafınıtutma[i][j]==-2)
						{
					
							ekranString+="<td bgcolor='white' width=25></td>";
							}else {
								ekranString+="<td bgcolor='gray' width=25></td>";		
						}
					
					
					}
				}
					else {
						ekranString+="<td bgcolor='blue' width=25></td>";
						gidilenyoltutucu[i][j]=-1;
		//				txtattumgeezilenyerler[i][j]=1;
					   //ziyaret edilen yerlere -1 ata
					}
						
						
				if(i==oyuncubassatırı&&j==oyuncubassütunu)
				{  System.out.println("//////////////////////////////////////////////");
					System.out.println(labharita[oyuncubitsatırı][oyuncubitsütunu]);
					System.out.println("//////////////////////////////////////////////");
				}
					
					
			
					
				}
			
			}
			
			
			
			
			
			
			
			
			
		
			
			
			
			
			
			
			
			ekranString+="</tr>";
			ekranString+="</table></html>";
			return ekranString;

			
		
		
		
		
		}

	
	public static void enkısayoliçintxtkaydet(int[][]dizikare) throws IOException
	{
		for(int x=0;x<dizikare.length;x++)
		{
			for(int y=0;y<dizikare[0].length;y++)
			{
				if(x==oyuncubassatırı&&y==oyuncubassütunu)
				{
					dizikare[x][y]=2;//start 2 oldu
				}
				if(x==oyuncubitsatırı&&y==oyuncubitsütunu)
				{
					dizikare[x][y]=3;//exit 3
				}
			}
		}
		
		
		
		
		
		
		 
		File Dosya=new File("C:\\Users\\murat\\OneDrive\\Masaüstü\\maze.txt");
		if(!Dosya.exists())
		{
			Dosya.createNewFile();
		}
		
		
		String kaydetString ="9";
		int giris=0;
		FileWriter yazmaFileWriter=new FileWriter(Dosya,false);
		BufferedWriter bfryazmaBufferedWriter=new BufferedWriter(yazmaFileWriter);
		for(int i=0;i<dizikare.length;i++)
		{
			  for(int j=0;j<dizikare[0].length;j++)
			  {if(giris==0)
			    {
				  kaydetString="1";
			    }
			  else {
				  kaydetString+=dizikare[i][j]+"";
				  
			}  
				  giris++;
			  }kaydetString+="\n";
			
		}
		
		bfryazmaBufferedWriter.write(kaydetString);
		
		
		bfryazmaBufferedWriter.close();
		
		
		
		
		
		System.out.println("oooooooooooooooooooooooooooooooolduuuuuuuuuuu");
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
public static void main(String[] args) throws IOException, URISyntaxException {

	
	
	
	
	// labirent labirentluk bir yapı olsun
	 int dizikare[][]=gelendosyadaengelkoy.fonksiyon();
	 System.out.println("ŞEKİL");
	 
	 for(int i=0;i<dizikare.length;i++)
	 {
		 for(int j=0;j<dizikare[0].length;j++)
		 {
			 System.out.print(dizikare[i][j]);
			 
		 }System.out.println();
	 }

	
	 
	 
	 
		
	 String etiketana[]= {"url degistir","çalıştır","sonuçgöster"," çıkış"};
	 	
	 	
	 		int	tussec2=JOptionPane.showOptionDialog(null,labirentciz(dizikare),"LABİRENT OYUNU",JOptionPane.DEFAULT_OPTION,
 			JOptionPane.WARNING_MESSAGE,null,etiketana,etiketana[3]);
	
	 	
	 	switch(tussec2)
	 	{
	 	case 0:
	 	case 1:
	 	case 2:	

	 		 Random rastgeleRandom=new Random();
	 		 oyuncubassatırı=rastgeleRandom.nextInt()%dizikare.length;
	 		 oyuncubassütunu=rastgeleRandom.nextInt()%dizikare.length;
	 		 oyuncubitsatırı=rastgeleRandom.nextInt()%dizikare.length;
	 		 oyuncubitsütunu=rastgeleRandom.nextInt()%dizikare.length;
	 		 while((oyuncubassatırı<0||oyuncubassütunu<0||oyuncubitsatırı<0||oyuncubitsütunu<0||(dizikare[oyuncubassatırı][oyuncubassütunu]==1||dizikare[oyuncubitsatırı][oyuncubitsütunu]==1)))
	 		 {
	 			 
	 			 
	 			 oyuncubassatırı=rastgeleRandom.nextInt()%dizikare.length;
	 			 oyuncubassütunu=rastgeleRandom.nextInt()%dizikare.length;
	 			 oyuncubitsatırı=rastgeleRandom.nextInt()%dizikare.length;
	 			 oyuncubitsütunu=rastgeleRandom.nextInt()%dizikare.length;
	 			
	 			 if(oyuncubassatırı>=0&&oyuncubassütunu>=0&&oyuncubitsatırı>=0&&oyuncubitsütunu>=0)
	 			 {
	 				 if(dizikare[oyuncubassatırı][oyuncubassütunu]==0&&dizikare[oyuncubitsatırı][oyuncubitsütunu]==0)
	 				 {break;}
	 				 
	 			 }
	 			 
	 		 }
	 			 
	 			System.out.println("bas:"+oyuncubassatırı+"satır"+oyuncubassütunu+"sutun"+":bitis:"+oyuncubitsatırı+"satır"+oyuncubitsütunu+"sütun"); 
	 			 
	 			 oyusatır=oyuncubassatırı;
	 			 oyusutun=oyuncubassütunu;
	 		
	 		 
	 		 
	 		 
	 		 
	 		 
	 		 enkısayoliçintxtkaydet(dizikare);
	 		System.out.println("       GORSELLİK      \n");
	 		for(int i=0;i<dizikare.length;i++)
	 		{
	 			for(int j=0;j<dizikare[0].length;j++)
	 			{
	 				
	 				if(dizikare[i][j]==1)
	 				{
	 					System.out.print("=");
	 				}else {
	 					System.out.print("*");
	 				}
	 				System.out.print(" ");
	 			}
	 			System.out.println();
	 		}
	 		//  jframe kullanmak  daha guzel
	 	  // bu joptınpane.showOptionDiolog  jframe de buton koyup,onu etkınlestırıp ugrasmamizi engeller;
	 		
	 		
	 		
	 		// burası seçim yaptıktan sonra çıkan arayüz
	 		Object etiket[]= {"saga","sola","yukarı","asagı","çalıstır","sonuç goster","url değiştir","HARİTA","çıkış"};
	 				int tussec;
	 	
	 				
	 		Object etiket2[]= {"saga","sola","yukarı","asagı","anaekranadon"};
	 		int calıstırtus;
	 		
	 		dizikare[oyusatır][oyusutun]=-1;//oyuncu un oldugu yere -1 ata
	 		

	 		
	 		while(dizikare[oyuncubitsatırı][oyuncubitsütunu]!=-1)
	 		{
	 				tussec=JOptionPane.showOptionDialog(null,labirentciz(dizikare),"LABİRENT OYUNU",JOptionPane.DEFAULT_OPTION,
	 				JOptionPane.WARNING_MESSAGE,null,etiket,etiket[8]);
	 	         	
	 		dizikare[oyusatır][oyusutun]=0;//yolu actık
	 		
	 	switch(tussec)
	 	{
	 	case 0:
	 		oyusutun=sagagit(oyusutun,dizikare,oyusatır);
	 		break;
	 	case 1:
	 		oyusutun=solagit(oyusutun,dizikare,oyusatır);
	 		 break;
	 	case 2:
	 		oyusatır=yukarıgit(oyusutun,dizikare,oyusatır);
	 		break;
	 	case 3:
	 		oyusatır=asagıgit(oyusutun,dizikare,oyusatır);
	 		break;
	 	case 4:
	 		
	 		
	 		
	 		dizikare[oyusatır][oyusutun]=-1;
	 		while(dizikare[oyuncubitsatırı][oyuncubitsütunu]!=-1)
	 		{
	 		
	 		
	 		
	 		
	 		calıstırtus=JOptionPane.showOptionDialog(null,labirentadımadımciz(dizikare),"LABİRENT OYUNU",JOptionPane.DEFAULT_OPTION,
	 				JOptionPane.WARNING_MESSAGE,null,etiket2,etiket2[4]);
	 	         
	 		dizikare[oyusatır][oyusutun]=0;
	 		switch(calıstırtus)
	 		{
	 		
	 		case 0:
		 		oyusutun=sagagit(oyusutun,dizikare,oyusatır);
		 		break;
		 	case 1:
		 		oyusutun=solagit(oyusutun,dizikare,oyusatır);
		 		 break;
		 	case 2:
		 		oyusatır=yukarıgit(oyusutun,dizikare,oyusatır);
		 		break;
		 	case 3:
		 		oyusatır=asagıgit(oyusutun,dizikare,oyusatır);
		 		break;
		 	case 4:
		 		cıkısart+=1;
		 		break;
		 	default:
		 		System.out.println("yanlış seçim");
	 		break;
	 		
	 		}
	 		dizikare[oyusatır][oyusutun]=-1;
	 		
	 		if(cıkısart%2==1)
	 		{
	 			break;
	 		}
	 		
	 		
	 		
	 		
	 		
	 		
	 		
	 		
	 		
	 		}
	 		break;
	 	case 5:
	 		sonucgoster(dizikare);
	 		break;
	 	case 6:
	 		dizikare=gelendosyadaengelkoy.fonksiyon();
	 	
	 		 oyuncubassatırı=rastgeleRandom.nextInt()%dizikare.length;
	 		 oyuncubassütunu=rastgeleRandom.nextInt()%dizikare.length;
	 		 oyuncubitsatırı=rastgeleRandom.nextInt()%dizikare.length;
	 		 oyuncubitsütunu=rastgeleRandom.nextInt()%dizikare.length;
	 		 while((oyuncubassatırı<0||oyuncubassütunu<0||oyuncubitsatırı<0||oyuncubitsütunu<0||(dizikare[oyuncubassatırı][oyuncubassütunu]==1||dizikare[oyuncubitsatırı][oyuncubitsütunu]==1)))
	 		 {
	 			 
	 			 
	 			 oyuncubassatırı=rastgeleRandom.nextInt()%dizikare.length;
	 			 oyuncubassütunu=rastgeleRandom.nextInt()%dizikare.length;
	 			 oyuncubitsatırı=rastgeleRandom.nextInt()%dizikare.length;
	 			 oyuncubitsütunu=rastgeleRandom.nextInt()%dizikare.length;
	 			
	 			 if(oyuncubassatırı>=0&&oyuncubassütunu>=0&&oyuncubitsatırı>=0&&oyuncubitsütunu>=0)
	 			 {
	 				 if(dizikare[oyuncubassatırı][oyuncubassütunu]==0&&dizikare[oyuncubitsatırı][oyuncubitsütunu]==0)
	 				 {break;}
	 				 
	 			 }
	 			 
	 		 }
	 			 
	 	
	 			System.out.println("bas:"+oyuncubassatırı+"satır"+oyuncubassütunu+"sutun"+":bitis:"+oyuncubitsatırı+"satır"+oyuncubitsütunu+"sütun"); 
	 			 
	 			 oyusatır=oyuncubassatırı;
	 			 oyusutun=oyuncubassütunu;
	 		
	 		 
	 		 
	 		 
	 		 
	 		 
	 		 enkısayoliçintxtkaydet(dizikare);
	 		System.out.println("       GORSELLİK      \n");
	 		for(int i=0;i<dizikare.length;i++)
	 		{
	 			for(int j=0;j<dizikare[0].length;j++)
	 			{
	 				
	 				if(dizikare[i][j]==1)
	 				{
	 					System.out.print("=");
	 				}else {
	 					System.out.print("*");
	 				}
	 				System.out.print(" ");
	 			}
	 			System.out.println();
	 		}
	 		//  jframe kullanmak  daha guzel
	 	  // bu joptınpane.showOptionDiolog  jframe de buton koyup,onu etkınlestırıp ugrasmamizi engeller;
	 		dizikare[oyusatır][oyusutun]=-1;//oyuncu un oldugu yere -1 ata
	 		

	 	break;
	 	case 7:
	 		
	 		JOptionPane.showMessageDialog(null,labirentciz(dizikare));
	 		break;
	 	case 8:
	 		System.exit(0);


	 	}
	 		dizikare[oyusatır][oyusutun]=-1;	
	 			
	 		}
	 			
	 	
	    
	 		break;
	 		default:
	 			System.out.println("problem 11 636 satır");
	 			break;
	
	 	}
	 	
}

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





public static void sonucgoster(int tablodizi[][])
{
try {
	labirentANAKISIM.main(null);
} catch (Exception e) {
System.out.println("problem11 429 satır");
	e.printStackTrace();
}	



}

















}
























