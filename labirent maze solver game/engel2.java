package prolabikideneme2;

public class engel2 extends engelsınıfı {
public engel2() {
engeltipiString="2";
maxkaplananyer=2;
}


public static int kactane2=0;


public  int[][] sekilolusturucu()
{
	int engel2[][]=new int[maxkaplananyer][maxkaplananyer];
	
	
	
	
	
	
	for(int i=0;i<maxkaplananyer;i++)
	{
		for(int j=0;j<maxkaplananyer;j++)
		{
			if(kactane2==0)
			{
				if(i==0)
				{
					engel2[0][j]=1;
				}
				engel2[1][1]=1;
			}
			else if(kactane2==1)
			{
				if(i==1)
				{
					engel2[1][j]=1;
					
				}
				
			}
			else if(kactane2==2)
			{
				
				if(j==0)
				{
					engel2[i][0]=1;
				}
				
			}	else if(kactane2==3)
			{ 
				engel2[0][0]=1;
				engel2[0][1]=1;
				engel2[1][1]=1;
				
			}	else if(kactane2==4)
			{
				if(j==0)
				{
					engel2[1][1]=0;
					engel2[0][1]=1;
				}
				
			}	else if(kactane2==5)
			{
				if(j==0)
				{
					engel2[i][0]=1;
				}
				
			}
			else if(kactane2==6)
			{	if(i==0)
			{
				engel2[0][j]=1;
			}
			engel2[1][1]=1;
				
			}
			else if(kactane2==7)
			{
				if(j==0)
				{
					engel2[i][0]=1;
				}
				
			}	else if(kactane2==8)
			{
				
				engel2[0][0]=1;
				engel2[0][1]=1;
				engel2[1][1]=1;
				
			}
			else if(kactane2==9)
			{
				if(j==0)
				{
					engel2[i][1]=1;
				}
				
			}
			else if(kactane2==10)
			{
				engel2[0][0]=1;
				engel2[1][1]=1;
			}
			else if(kactane2==11)
			{
				if(j==1)
				{
					engel2[i][1]=1;
				}
				
			}
			else if(kactane2==12)
			{		
				engel2[0][0]=1;
				engel2[0][1]=1;
				engel2[1][1]=1;
			}
			else if(kactane2==13)
			{
				engel2[0][1]=1;
				engel2[1][1]=1;
			}
			else if(kactane2==15)
			{if(j==0)
			{
				engel2[i][0]=1;
			}
			
			}
			
			else {
				if(j==1)
				{
					engel2[i][1]=1;
				}
				
			}
			
			
		}
	}
	
	kactane2++;
	
	
	
	
	
	
	
	
	for(int i=0;i<maxkaplananyer;i++)
	{
		for(int j=0;j<maxkaplananyer;j++)
		{
			System.out.print(engel2[i][j]);
		}System.out.println();
	}
	
	
	System.out.println();
	
	
	
	
	
	
	
	
	
	
	
	
	return engel2;
	
}



}
