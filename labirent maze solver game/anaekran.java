package prolabikideneme2;



import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.html.HTMLDocument.HTMLReader.BlockAction;
import java.io.*;
import java.net.URISyntaxException;
import java.util.*;

public class anaekran extends ızgarasınıfı{
//bas ve bitiş,engeller sınıf degişkeni 
	static	int basx,basy,bitx,bity;
	static int engeller[];
   static int yeniharita=0;//haritatusuna basınca artacak
  static int labirentsatırboyu;
  static int labirentsutunboyu;
 static int kont=0;
public static void main(String[] args) throws IOException, URISyntaxException {
	
	int cevap=JOptionPane.showConfirmDialog(null,"Hangi Problem(YES:Problem1-NO:Problem2)","SECMEBOLUMU",JOptionPane.YES_NO_OPTION);
	if(cevap==JOptionPane.YES_OPTION)
	{
		
		// nesne uretıpde engel yap
		if(kont==0)
		{
				problem11.main(args);
		
		}
		else {
	
		}	
		kont++;

		
	}
	if(cevap==JOptionPane.NO_OPTION)
	{//kullanıcı labirent olusturur.
		//çift sayılarda program hata veriyor.
		
		
		problem2.main(args);

		/*// x ve y tablo oluşturur
		int x=0,y=0;
		if(args.length>=1)
		{
			x=(Integer.parseInt(args[0]));
		}
		if(args.length<1)
		{
			x=anaekran.labirentboyu;
		}
		if(args.length==2)
		{
			y=(Integer.parseInt(args[1]));
		}
		if(args.length!=2)
		{
			y=anaekran.labirentboyu;
		}
		
		System.out.println("x:"+x+"y:"+y);
		
		
	   Randomlab4 maze = new Randomlab4(x, y);
		maze.display();
		
		
		
		String labirentresimString;
		labirentresimString=Randomlab4.labirentresimtutucuString.substring(4);
		
		System.out.println("Ana EKRAN");
       

System.out.println(labirentresimString);


File dosya=new File("C:\\Users\\murat\\OneDrive\\Masaüstü\\randomlabirent (2).txt");
FileWriter fwriterFile=new FileWriter(dosya);
BufferedWriter bfrWriter=new BufferedWriter(fwriterFile);
bfrWriter.write(labirentresimString);
bfrWriter.close();


*/




	}
	
}
}


