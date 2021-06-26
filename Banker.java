// Student Name: Abdulrahman Saleh Alghaligah           Student ID:439015052
import java.io.*;
import java.util.*;
public class Banker 
{ 
//--------------------------------------------------------------------Banker class attribute ------------------------------------------------------------------------------------

	int n ;// Number of processes 
	int m; // Number of resources 
	int need[][]; // initialized in calculateNeed function 
	int [][]max;  
	int [][]allocation; 
	int []available;
        int []request; // initialized in Request Algorithm function
	int SafeSeq[]; 
        int processRequested;
        

        Scanner scanFile;// declare object that scan the file 
        void openFile(){
            
            
            
   //--------------------------------------------------------------------Open,read,close file functions --------------------------------------------------------------------

            try{
    scanFile=new Scanner (new File("input.txt"));
            }
            
            catch(Exception e){
                System.out.println("could not open the file");
                
            }
    
}
        
        
        
        
        void readFile(){
            try{
                n=scanFile.nextInt();
                m=scanFile.nextInt();
                
                allocation=new int[n][m];
                
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        allocation[i][j]=scanFile.nextInt();
                        
                    }
                    
                }
                max=new int [n][m];
                  for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        max[i][j]=scanFile.nextInt();
                        
                    }
                    
                }
                  
                  available=new int [m];
                  
                  for (int i = 0; i < available.length; i++) {
                      available[i]=scanFile.nextInt();
                    
                }
                  request=new int[m];
                String lastLine="";
                while(scanFile.hasNext()){
                    lastLine+=scanFile.next();
                    
                        
                    }
                
                
                processRequested=Character.getNumericValue(lastLine.charAt(0));
                
                int count=0;
                while( count < request.length){
                    for (int i = 2; i < lastLine.length(); i++) {
                        request[count]=Character.getNumericValue(lastLine.charAt(i));
                        count++;
                    }
                    
                

                }
                
                
                   
                
            
           
                  
                  
                  
            }
                
                
            
            catch(Exception e){
                System.out.println("File format is not same as sample \nplease insert numbers same as the sample");
                
            }
            
                
            
        }
        
        
        void closeFile(){
            scanFile.close();}
            
        
        
        
        
    
        
  //--------------------------------------------------------------------Saftey Algorithim function--------------------------------------------------------------------

        boolean SafteyAlgorithim()
        { 
            SafeSeq=new int[n];
	int c=0; // decalre a counter 
	
	boolean finish[] = new boolean[n];// declare finish array to decide which process needs to be checked
	for (int i = 0;i < n; i++) 
	{ 
		finish[i] = false; 
	} 
		
	int work[] = new int[m]; //declare work array to store a copy of available resources 

	for (int i = 0;i < m; i++) 
	{ 
		work[i] = available[i]; 
	} 

	while (c<n) 
	{ 
		boolean flag = false; 
		for (int i = 0;i < n; i++) 
		{ 
			if (finish[i] == false) 
			{ 
			int j; 
			for (j = 0;j < m; j++) 
			{		 
				if (need[i][j] > work[j]) 
				break; 
			} 
			if (j == m) 
			{ 
			SafeSeq[c++]=i; 
			finish[i]=true; 
			flag=true; 
						
				for (j = 0;j < m; j++) 
				{ 
				work[j] = work[j]+allocation[i][j]; 
				} 
			} 
			} 
		} 
		if (flag == false) 
		{ 
			break; 
		} 
	} 
	if (c < n) 
	{ 
		
            return false; //("The System is on UnSafe mode
	} 
	else
	{ 
	              return true; //The given System is on Safe mode 
        } 
	} 
        
        
        
        

        
        
        
        
//-----------------------------------------------------------------------------calculate Need function--------------------------------------------------------------------
        
        void calculateNeed(){
            need=new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    
                    need[i][j]=max[i][j] - allocation[i][j];
                    
                }
                
            }
            
        }
//-----------------------------------------------------------------------------Request Algorithm function------------------------------------------------------------------------
        void RequestAlgorithm(){
            
            boolean []RequestAndAvailable=new boolean[request.length];
            boolean []RequestAndNeed= new boolean [request.length];
            for (int i = 0; i < request.length; i++) {
                if(request[i] <= available[i])
                {
                    RequestAndAvailable[i]=true;
                }
                else{
                    RequestAndAvailable[i]=false;
                }
                
            }
            
            for (int i = 0; i < request.length; i++) {
                if(request[i]<= need[processRequested][i]){
                    RequestAndNeed[i]=true;
                }
                else{
                    RequestAndNeed[i]=false;
                }
                
                
            }
            boolean b=true;
            for (int i = 0; i < request.length; i++) {
                if(RequestAndAvailable[i] && RequestAndNeed[i] == false)
                {
                    System.out.println("process can not be granted");
                    b=false;
                    break;
                }
                
                
            }
            
            if(b){
                for (int i = 0; i < request.length; i++) {
                    available[i]=available[i]-request[i];
                    allocation[processRequested][i]=allocation[processRequested][i] + request[i];
                    need[processRequested][i]=need[processRequested][i] - request[i];
                    
                    
                }
            }
            
            if(SafteyAlgorithim()){
                System.out.println("THE REQUEST CAN BE GRANTED!");
                
            }
            
            else{
                System.out.println("THE REQUEST CAN NOT BE GRANTED!");
            }
            
            
            
            
            
        }
        
        
//------------------------------------------------------------------------------Main method-------------------------------------------------------------------------------------
            
public static void main(String[]args){

Banker b=new Banker();



b.openFile();// open the texr file 
b.readFile();// read the text file
b.closeFile(); // close the text file 

String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";

//------------------------------------------------------------------------------Print number of processes and resources -----------------------------------------------------------

System.out.println("There are "+b.n+" processes in the system."); 
System.out.println();
System.out.println("There are "+b.m+" resource types.\n");








//------------------------------------------------------------------------------Print Allocation-----------------------------------------------------------
System.out.println("The Allocation Matrix is...");


        System.out.print("   ");
    for (int i = 0; i < b.m; i++) {
        System.out.print(alphabet.charAt(i)+" ");
        
        
    }
    
    System.out.println();
    
    


int allocationCount=0;

while(allocationCount<b.n)
{
System.out.print(allocationCount+": ");
    for (int i = 0; i < b.m; i++) {
       System.out.print(b.allocation[allocationCount][i]+" "); 
        
    }
    System.out.println();
    
    allocationCount++;}

System.out.println();



//------------------------------------------------------------------------------Print Max-----------------------------------------------------------
System.out.println("The Max Matrix is...");


        System.out.print("   ");
    for (int i = 0; i < b.m; i++) {
        System.out.print(alphabet.charAt(i)+" ");
        
        
    }
    
    System.out.println();
    
    


int MaxCount=0;

while(MaxCount<b.n)
{
System.out.print(MaxCount+": ");
    for (int i = 0; i < b.m; i++) {
       System.out.print(b.max[MaxCount][i]+" "); 
        
    }
    System.out.println();
    
    MaxCount++;}

System.out.println();


//------------------------------------------------------------------------------Print Need------------------------------------------------------------------------------------

b.calculateNeed();
System.out.println("The Need Matrix is...");


        System.out.print("   ");
    for (int i = 0; i < b.m; i++) {
        System.out.print(alphabet.charAt(i)+" ");
        
        
    }
    
    System.out.println();
    
    


int NeedCount=0;

while(NeedCount<b.n)
{
System.out.print(NeedCount+": ");
    for (int i = 0; i < b.m; i++) {
       System.out.print(b.need[NeedCount][i]+" "); 
        
    }
    System.out.println();
    
    NeedCount++;}

System.out.println();





//------------------------------------------------------------------------------Print Available -----------------------------------------------------------

System.out.println("The Available vector is...");




        System.out.print("");
    for (int i = 0; i < b.m; i++) {
        System.out.print(alphabet.charAt(i)+" ");
        
        
    }
    
    System.out.println();
    System.out.print("");
    
    for (int i = 0; i < b.m; i++) {
        System.out.print(b.available[i]+" ");
        
    }
    
    System.out.println();
    
    
    System.out.println();
    


//------------------------------------------------------------------------------Is the system in a Safe state? -----------------------------------------------------------



boolean isSafe=b.SafteyAlgorithim();

if(isSafe){
    System.out.println("THE SYSTEM IS IN A SAFE STATE!");
}
else{
     System.out.println("THE SYSTEM IS NOT IN A SAFE STATE!");
}

System.out.println();


//------------------------------------------------------------------------------Print Request -----------------------------------------------------------

System.out.println("The Request vector is...");




        System.out.print("  ");
    for (int i = 0; i < b.m; i++) {
        System.out.print(alphabet.charAt(i)+" ");
        
        
    }
    
    System.out.println();
    System.out.print(b.processRequested+":");
    
    for (int i = 0; i < b.m; i++) {
        System.out.print(b.request[i]+" ");
        
    }
    
    System.out.println();
    
    
    System.out.println();
    
    





//------------------------------------------------------------------------------can the request be granted ? -----------------------------------------------------------

b.RequestAlgorithm();

System.out.println();
//------------------------------------------------------------------------------Print Available vector after the request -----------------------------------------------------------

System.out.println("The Available vector is...");




        System.out.print("");
    for (int i = 0; i < b.m; i++) {
        System.out.print(alphabet.charAt(i)+" ");
        
        
    }
    
    System.out.println();
    System.out.print("");
    
    for (int i = 0; i < b.m; i++) {
        System.out.print(b.available[i]+" ");
        
    }
    
    System.out.println();
    
    
    System.out.println();









}}










