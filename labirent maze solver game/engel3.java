package prolabikideneme2;

import java.util.Random;

public class engel3 extends engelsınıfı {
public engel3() {
engeltipiString="3";
maxkaplananyer=3;
}
 
public static int  kactane3=0;


public int[][] sekilolusturucu()
{
	int engel3[][]=new int[maxkaplananyer][maxkaplananyer];
	for(int i=0;i<maxkaplananyer;i++)
	{
		for(int j=0;j<maxkaplananyer;j++)
		{
			if(kactane3==0)
			{
				if(i==0)
				     {
					engel3[0][j]=1;
				     }
				engel3[1][1]=1;
				
			}
			else if(kactane3==1)
			{  if(i==1)
			       {
				engel3[1][j]=1;
		           }
				engel3[0][1]=1;
			}
			else if(kactane3==2)
			{           if(i==2)
			            {
				      engel3[2][j]=1;
			            }
				engel3[1][2]=1;
				
			}else if(kactane3==3){
				if(i==2)
				{
					engel3[j][2]=1;
					
				}engel3[1][1]=1;
			}
			else if(kactane3==4){
				if(i==2)
				{
					engel3[0][2]=1;
					engel3[1][2]=1;
					
				}engel3[1][1]=1;
			}
			else if(kactane3==5){
				if(i==1)
				{
					engel3[j][2]=1;
					
				}engel3[1][1]=1;
			}
			else if(kactane3==6){
				if(i==2)
				{
					engel3[0][2]=1;
					engel3[1][2]=1;
					
				}engel3[1][1]=1;
			}
			else if(kactane3==7){
				if(i==1)
				{
					engel3[j][2]=1;
					
				}engel3[1][1]=1;
			}
			else if(kactane3==8)
			{
				if(i==0)
				{
					engel3[0][0]=1;
					engel3[1][1]=1;
					engel3[0][2]=1;
					
				}
				
			}
			else if(kactane3==9)
			{
				if(i==0)
				{
					engel3[0][0]=1;
					engel3[1][0]=1;
					engel3[0][1]=1;
					
				}
				
			}
			else if(kactane3==10)
			{
				if(i==0)
				{
					engel3[0][0]=1;
					engel3[0][2]=1;
					engel3[0][1]=1;
					
				}
				
			}	else if(kactane3==11)
			{
				if(i==0)
				{
					engel3[0][2]=1;
					engel3[1][1]=1;
					engel3[1][2]=1;
					
				}
				
			}
			else {
				if(i==1)
				{
					engel3[j][1]=1;
				engel3[2][2]=1;
				}
			}
			
			
		}
	}
	
	
	kactane3++;
	
	
	
	Random secRandom=new Random();
	
	int secvariable=secRandom.nextInt()/2;
	
	while(secvariable<0)
	{
		secvariable=secRandom.nextInt()/2;
	}
	if(secvariable>0&&secvariable==0)
	{
		
	}
	if(secvariable>0&&secvariable==1)
	{ 
		kactane3+=1;
		
	}
	
	
	
	
	for(int i=0;i<maxkaplananyer;i++)
	{
		for(int j=0;j<maxkaplananyer;j++)
		{
			System.out.print(engel3[i][j]);
		}System.out.println();
	}
	
	
	System.out.println();
	
	
	
	
	
	
	
	
	
	
	
	return engel3;
	
}	


}
