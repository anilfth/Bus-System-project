// Program to simulate a bus management system. This program comprises of two co-dependent segments, one for administrator and his functions
// for the customer.
// This program provides an interactive GUI which facilitates the administrator as well as the 
// customer to use the software effectively.
//Username for admin : VRL , SUGAMA , DURGAMBA
//Password : vrl1234,sugama1234,durgamba1234
import java.io.*;
import java.util.*;

interface Tickethandler
{
//Methods required to be implemented by all classes that implement ticket handler
    void bookticket();
    int cancelticket();
    void displayticket();
}



abstract class bus //Class from which Sugama,Vrl and Durgamba classes are derived.
{
 //Attributes common to all derived classes
 protected String typef ;
 protected String sourcef;
 protected String destinationf;
 protected String starttimef;
 protected String endtimef;
 protected String routenof;
 protected char seatmatrixf[][];
 protected String uniqKeyf;
 protected int seatsf;
 static int countf= 0;
 int rowsf = 0;
 int columnsf = 0;
 int pricef = 0;
 //Methods common to all derived classes
 abstract public void adddetails();
 abstract public void typechange(String str);
 abstract public void sourcechange(String str);
 abstract public void destinationchange(String str);
 abstract public void starttimechange(String str);
 abstract public void endtimechange(String str);
 abstract public void routechange(String str);
 abstract public void pricechange(int i);
 abstract public void createseatmatrix(int rows,int columns);
 abstract public void search();
 abstract public void getprice();
}
































class Sugama extends bus implements Tickethandler , Serializable
{   //Attributes
    private Boolean hastv , haslight , haschargepoint;
    private String pass_name, pass_age , pass_mail , pass_phone;
    private char sex ;
    protected String key;
    protected String type ;
    protected String source;
    protected String destination;
    protected String starttime;
    protected String endtime;
    protected String routeno;
   protected char seatmatrix[][] = new char[40][40];
    protected String uniqKey;
   protected int seats;
 static int count= 0;
 int rows = 0;
 int columns = 0;
 int price;
    @Override
    public void adddetails() // Method to add details of a bus
    {    Scanner scan = new Scanner(System.in);
        // System.out.println("Enter bus type");
         type = scan.nextLine();
        
         //System.out.println("Enter Destination");
         destination = scan.nextLine();
        // System.out.println("Enter Start Time");
         starttime = scan.nextLine();
        // System.out.println("Enter End Time");
         endtime = scan.nextLine();
         //System.out.println("Enter route no");
         routeno = scan.nextLine();
         //System.out.println("Enter Unique Key");
         key = scan.nextLine();
         //System.out.println("Enter price per seat");
         price = scan.nextInt();
          //System.out.println("Enter source");
         source = scan.nextLine();
       //  createseatmatrix();

    }

    @Override
    public void typechange(String str) // method to change the type
    {
      this.type = str;
    }

    @Override
    public void sourcechange(String str) // method to change the source
    {
     this.source = str;
    }
    @Override
    public void destinationchange(String str) // method to change the destination
    {
     this.destination = str;
    }

    @Override
    public void starttimechange(String str) // method to change the starttime
    {
        this.starttime = str;
    }

    @Override
    public void endtimechange(String str) //method to change the end time 
    {
       this.endtime = str;
    }

    @Override
    public void routechange(String str) // method to change the route
    {
        this.routeno = str;
    }

  /*  @Override
  public void search()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getprice()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void bookticket()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cancelticket()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void displayticket()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    @Override
    public void createseatmatrix(int rows,int columns)//method to create the seat matrix of a given bus
    {
      Scanner scan = new Scanner(System.in);
     // System.out.println("Enter the number of rows for this bus ");
      //rows = scan.nextInt();
     // System.out.println("Enter number of columns for this bus ");
     // columns = scan.nextInt();
      seatmatrix = new char[rows][columns];
      for(int i = 0;i<rows;i++)
      {
          for(int j = 0;j<columns;j++)
          {
            seatmatrix[i][j] = 'X'; // 'X' signifies that the seat is vacant 
          }
      }
    }

// Methods for the class

public Boolean hastv() // to check if the bus provides a tv facility
{
  if(hastv = true)
      return true;
  else
      return false;
}
public Boolean hascharge()//to check if bus provides a charger facility
{
  if(haschargepoint = true)
      return true;
  else
      return false;
}
public Boolean haslight()// to check if the bus provides a reading light
{
  if(haslight = true)
      return true;
  else
      return false;
}
/*public void addpassdetails()
{

}*/

public void displayall() // method to display the details of the bus
{

       /*  System.out.println(" Bus type :"+type);
         System.out.println(" Source :"+source);
         System.out.println(" Destination :"+destination);
         System.out.println("Start Time :"+starttime);
         System.out.println("End Time :"+endtime);
         System.out.println("Route no"+routeno);
         System.out.println("Unique Key"+key);
         System.out.println("Price per ticket"+price);*/
         displayseatmatrix();
}
public void displayseatmatrix() //method to display the seat matrix
{

  for (int i = 0;i<rows;i++)
  {
    for(int j = 0;j<columns;j++)
      System.out.print(seatmatrix[i][j]);
       System.out.println("\n");
  }
}

public void alterseatmatrix() // method to alter the seat matrix
{ int choice;
  Scanner scan = new Scanner(System.in);
  do
  {
  /* System.out.println("1.change number of rows \n");
   System.out.println("2.change the number of columns");
   System.out.println("3.update");
   System.out.println("enter choice");*/
   choice = scan.nextInt();
    switch(choice)
    {
        case 1:
           // System.out.println("enter number of rows");
            rows = scan.nextInt();
            break;
        case 2:
            //System.out.println("enter number of columns");
            columns = scan.nextInt();
            break;
        case 3:
            seatmatrix = new char[rows][columns];
            for(int i = 0;i<rows;i++)
             {
               for(int j = 0;j<columns;j++)
               {
                seatmatrix[i][j] = 'X';
               }
             }
            break;
   }
  }while(choice<=3);

}

    @Override
    public void pricechange(int i) 
    {
     this.price = i;  
    }

    @Override
    public void search() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getprice() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void bookticket() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int cancelticket() {
        return 0;//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void displayticket() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}






















class Vrl extends bus implements Tickethandler , Serializable
{   //Attributes
    private Boolean hastv , haslight , haschargepoint;
    private String pass_name, pass_age , pass_mail , pass_phone;
    private char sex ;
    protected String key;
    protected String source1;   //CHANGE THIS
    protected int seat;
     protected String type ;
 protected String source;
 protected String destination;
 protected String starttime;
 protected String endtime;
 protected String routeno;
 protected char seatmatrix[][] = new char[40][40];
 protected String uniqKey;
 protected int seats;
 int price= 0;
 static int count= 0;
 int rows = 0;
 int columns = 0;
    //methods from base class and interface
    @Override
    public void adddetails()//method to add details of a bus 
    {    
         Scanner scan = new Scanner(System.in);
         //System.out.println("Enter bus type");
         this.type = scan.nextLine();
         //System.out.println("Enter Destination");
         this.destination = scan.nextLine();
         //System.out.println("Enter Start Time");
         this.starttime = scan.nextLine();
         //System.out.println("Enter End Time");
         this.endtime = scan.nextLine();
         //System.out.println("Enter route no");
         this.routeno = scan.nextLine();
         //System.out.println("Enter Unique Key");
         this.key = scan.nextLine();
         //System.out.println("Enter Price per ticket");
         this.price = scan.nextInt();
         //System.out.println("Enter source");
         this.source = scan.nextLine();
         //createseatmatrix(int rows,int columns);
      

    }

    @Override
    public void typechange(String str)//method to change the bus type
    {
      this.type = str;
    }

    @Override
    public void sourcechange(String str)//method to change the source
    {
     this.source = str;
    }
    @Override
    public void destinationchange(String str)//method to change the destination
    {
     this.destination = str;
    }

    @Override
    public void starttimechange(String str)//method to change the starttime
    {
        this.starttime = str;
    }

    @Override
    public void endtimechange(String str)//method to change the end time
    {
       this.endtime = str;
    }

    @Override
    public void routechange(String str)//method to change the bus route
    {
        this.routeno = str;
    }

    @Override
    public void search()
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void pricechange(int i)//method to change price
    {
     this.price = i;   
    }
    @Override
    public void bookticket()
    {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int cancelticket() {
        return 0;//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void displayticket()
    {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void createseatmatrix(int rows,int columns)//method to create the seat matrix for the bus
    {
      Scanner scan = new Scanner(System.in);
     // System.out.println("Enter the number of rows for this bus ");
      //rows = scan.nextInt();
     // System.out.println("Enter number of columns for this bus ");
      //columns = scan.nextInt();
      seatmatrix = new char[rows][columns];
      for(int i = 0;i<rows;i++)
      {
          for(int j = 0;j<columns;j++)
          {
            seatmatrix[i][j] = 'X';//'X' signifies that the bus is vacant
          }
      }
    }

// Methods for the class

public Boolean hastv()//method to check if the bus has a tv facility
{
  if(hastv = true)
      return true;
  else
      return false;
}
public Boolean hascharge()//method to check if the bus has a charging facility
{
  if(haschargepoint = true)
      return true;
  else
      return false;
}
public Boolean haslight()//method to check if the bus has a reading light facility
{
  if(haslight = true)
      return true;
  else
      return false;
}
public void addpassdetails()
{

}

public void displayall()//method to display the contents of the bus
{

        /* System.out.println(" Bus type :"+type);
         System.out.println(" Source :"+source);
         System.out.println(" Destination :"+destination);
         System.out.println("Start Time :"+starttime);
         System.out.println("End Time :"+endtime);
         System.out.println("Route no"+routeno);
         System.out.println("Unique Key"+key);
         System.out.println("Price per ticket"+price);*/
         displayseatmatrix();
}
public void displayseatmatrix()//method to display seat matrix
{

  for (int i = 0;i<rows;i++)
  {
    for(int j = 0;j<columns;j++)
       //System.out.print(seatmatrix[i][j]);
       System.out.println("\n");
  }
}

public void alterseatmatrix()//method to alter seatmatrix
{ int choice;
  Scanner scan = new Scanner(System.in);
  do
  {
  // System.out.println("1.change number of rows \n");
  // System.out.println("2.change the number of columns");
  // System.out.println("3.update");
  // System.out.println("enter choice");
   choice = scan.nextInt();
    switch(choice)
    {
        case 1:
            //System.out.println("enter number of rows");
            rows = scan.nextInt();
            break;
        case 2:
          //  System.out.println("enter number of columns");
            columns = scan.nextInt();
            break;
        case 3:
            seatmatrix = new char[rows][columns];
            for(int i = 0;i<rows;i++)
             {
               for(int j = 0;j<columns;j++)
               {
                seatmatrix[i][j] = 'X';
               }
             }
            break;
   }
  }while(choice<=3);

}

   
    @Override
    public void getprice() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}

















class Durgamba extends bus implements Tickethandler,Serializable
{   //Attributes
    private Boolean hastv , haslight , haschargepoint;
    private String pass_name, pass_age , pass_mail , pass_phone;
    private char sex ;
     protected String type ;
 protected String source;
 protected String destination;
 protected String starttime;
 protected String endtime;
 protected String routeno;
 protected char seatmatrix[][] = new char[40][40];
 protected String uniqKey;
 protected int seats;
 int price;
 static int count= 0;
 int rows = 0;
 int columns = 0;
    protected int seat;
    protected String key;
    //methods from base class and interface
    @Override
    public void adddetails()//method to add details to a bus
    {    Scanner scan = new Scanner(System.in);
         //System.out.println("Enter bus type");
         type = scan.nextLine();
         
         //System.out.println("Enter Destination");
         destination = scan.nextLine();
        // System.out.println("Enter Start Time");
         starttime = scan.nextLine();
        // System.out.println("Enter End Time");
         endtime = scan.nextLine();
        // System.out.println("Enter route no");
         routeno = scan.nextLine();
        // System.out.println("Enter Unique Key");
         key = scan.nextLine();
       //  System.out.println("Enter the price per ticket");
         price = scan.nextInt();
       //   System.out.println("Enter source");
         source = scan.nextLine();
         //createseatmatrix();


    }

    @Override
    public void typechange(String str) //method to change the bus type
    {
      this.type = str;
    }

    @Override
    public void sourcechange(String str)//method to change the source type
    {
     this.source = str;
    }
    @Override
    public void destinationchange(String str)//method to change the destination type
    {
     this.destination = str;
    }

    @Override
    public void starttimechange(String str)//method to change the start time 
    {
        this.starttime = str;
    }

    @Override
    public void endtimechange(String str)//method to change the endtime 
    {
       this.endtime = str;
    }

    @Override
    public void routechange(String str)//method to change the route
    {
        this.routeno = str;
    }

    @Override
    public void search()
    {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getprice()
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void bookticket()
    {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
   public int cancelticket() {
        return 0;//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void displayticket()
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void createseatmatrix(int rows,int columns)//method to create the seat matrix
    {
      Scanner scan = new Scanner(System.in);
      //System.out.println("Enter the number of rows for this bus ");
      rows = scan.nextInt();
     // System.out.println("Enter number of columns for this bus ");
      columns = scan.nextInt();
      seatmatrix = new char[rows][columns];
      for(int i = 0;i<rows;i++)
      {
          for(int j = 0;j<columns;j++)
          {
            seatmatrix[i][j] = 'X';//'X' signifies that the seat is vacant
          }
      }
    }

// Methods for the class

public Boolean hastv()//method to check if the bus has a tv
{
  if(hastv = true)
      return true;
  else
      return false;
}
public Boolean hascharge() //method to check if the bus has a charger
{
  if(haschargepoint = true)
      return true;
  else
      return false;
}
public Boolean haslight()//method to check if the bus has a reading light
{
  if(haslight = true)
      return true;
  else
      return false;
}
public void addpassdetails()
{

}

public void displayall()//method to display the bus details
{

       /*  System.out.println(" Bus type :"+type);
         System.out.println(" Source :"+source);
         System.out.println(" Destination :"+destination);
         System.out.println("Start Time :"+starttime);
         System.out.println("End Time :"+endtime);
         System.out.println("Route no"+routeno);
         System.out.println("Unique Key"+key);
         System.out.println("Price per ticket"+price);*/
         displayseatmatrix();
}
public void displayseatmatrix()//method to display theseat matrix
{

  for (int i = 0;i<rows;i++)
  {
    for(int j = 0;j<columns;j++)
       //System.out.print(seatmatrix[i][j]);
       System.out.println("\n");
  }
}
public void alterseatmatrix()//method to alter the seat matrix
{ int choice;
  Scanner scan = new Scanner(System.in);
  do
  {
  // System.out.println("1.change number of rows \n");
  // System.out.println("2.change the number of columns");
   //System.out.println("3.update");
   //System.out.println("enter choice");
   choice = scan.nextInt();
    switch(choice)
    {
        case 1:
          //  System.out.println("enter number of rows");
            rows = scan.nextInt();
            break;
        case 2:
            //System.out.println("enter number of columns");
            columns = scan.nextInt();
            break;
        case 3:
            seatmatrix = new char[rows][columns];
            for(int i = 0;i<rows;i++)
             {
               for(int j = 0;j<columns;j++)
               {
                seatmatrix[i][j] = 'X';
               }
             }
            break;
   }
  }while(choice<=3);

}

    @Override
    public void pricechange(int i) //method to changeprice per seat
    {
     this.price = i;
    }




}

class PassDtls implements Serializable //class for storing passenger details
{
    String name;
    String contactno;
    String gender;
    String mail;
    int seatrow;
    int seatcol;
    int seat;
    String age;
    String rte;//For route
    
}






public class BusMod
{
    

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Scanner scan = new Scanner(System.in);
        ArrayList<Vrl> vrllist = new ArrayList<Vrl>();//holds list of vrl buse
        ArrayList<Sugama> sugalist = new ArrayList<Sugama>();//holds list of sugama buses
        ArrayList<Durgamba> durlist = new ArrayList<Durgamba>(); // holds list of durgamba buses
        ArrayList<PassDtls> vrlp = new ArrayList();
        ArrayList<PassDtls> sugap = new ArrayList();
        ArrayList<PassDtls> durp = new ArrayList();
         Vrl vcust = new Vrl();
        ArrayList<Vrl> vcustlist = new ArrayList<Vrl>();
        Sugama scust = new Sugama();
        ArrayList<Sugama> scustlist = new ArrayList<Sugama>();
        Durgamba dcust = new Durgamba();
        ArrayList<Durgamba> dcustlist = new ArrayList<Durgamba>();
        int i;
        int choice;
       String type[] = {"AC SLEEPER","AC SEMI SLEEPER","NON AC SLEEPER","AC SLEEPER","AC SEMI SLEEPER","AC SLEEPER","AC SEMI SLEEPER","NON AC SLEEPER","AC SLEEPER","AC SLEEPER","NON AC SLEEPER","NON AC SLEEPER","AC SLEEPER","AC SEMI SLEEPER","NON AC SLEEPER","AC SLEEPER","AC SLEEPER","AC SEMI SLEEPER","AC SLEEPER","AC SEMI SLEEPER","AC SLEEPER","AC SLEEPER","AC SLEEPER","AC SEMI SLEEPER","AC SLEEPER","AC SEMI SLEEPER","NON AC SLEEPER","AC SLEEPER","AC SEMI SLEEPER","AC SLEEPER","AC SLEEPER","AC SEMI SLEEPER","AC SLEEPER","AC SLEEPER","NON AC SEMI SLEEPER","NON AC  SLEEPER","AC SLEEPER","AC SEMI SLEEPER","AC SLEEPER"};
        String source[] = {"Bangalore","Bangalore","Bangalore","Bangalore","Bangalore","Bangalore","Bangalore","Bangalore","Bangalore","Bangalore","Bangalore","Bangalore","Chennai","Chennai","Chennai","Chennai","Chennai","Chennai","Kochi","Kochi","Kochi","Kochi","Kochi","Kochi","Hyderabad","Hyderabad","Hyderabad","Hyderabad","Hyderabad","Hyderabad","Hyderabad","Hyderabad","Manipal","Manipal","Manipal","Manipal","Manipal","Manipal","Manipal"};
        String []destination = {"Chennai","Chennai","Chennai","Kochi","Kochi","Hyderabad","Hyderabad","Hyderabad","Manipal","Manipal","Manipal","Manipal","Bangalore","Bangalore","Bangalore","Kochi","Hyderabad","Hyderabad","Bangalore","Bangalore","Chennai","Hyderabad","Manipal","Manipal","Bangalore","Bangalore","Bangalore","Chennai","Chennai","Kochi","Manipal","Manipal","Bangalore","Bangalore","Bangalore","Bangalore","Kochi","Kochi","Hyderabad"};       
        String []startime1 = {"16:30","15:00","23:00","22:00","23:00","14:00","12:00","21:00","22:00","22:45","21:30","20:45","16:30","15:00","23:00","22:00","22:15","13:00","22:00","23:00","22:00","21:00","13:00","14:00","14:00","12:00","23:00","22:15","13:00","21:00","15:00","13:30","22:00","22:45","21:30","20:45","01:00","02:00","15:00"};
        String []endtime1 = {"22:00","20:00","05:00","08:00","08:20","20:30","18:30","06:30","06:00","06:00","05:45","04:30","21:00","20:00","05:00","08:30","06:00","19:30","08:00","08:20","08:30","07:00","17:30","18:00","20:30","18:30","06:30","06:00","19:30","07:00","07:25","06:40","06:00","06:00","05:45","04:30","17:30","18:00","19:25"};
        String []startime2 = {"16:40","12:00","23:00","22:30","23:00","12:00","12:10","20:00","22:20","22:15","21:40","20:45","15:30","15:50","23:00","22:10","22:15","14:00","22:50","23:10","22:00","21:20","13:00","13:00","14:00","12:10","23:00","22:45","13:00","21:10","15:00","13:00","22:15","22:35","21:10","20:45","00:00","01:00","14:00"};
        String []endtime2 = {"22:10","17:00","05:30","08:40","08:30","19:30","19:00","06:00","06:40","05:40","05:45","04:00","22:00","21:00","04:40","08:50","06:30","20:30","08:50","08:20","08:30","08:00","17:00","18:45","20:30","18:40","07:00","06:30","19:50","07:40","07:45","06:10","06:55","06:10","05:00","04:30","16:30","17:00","18:25"};
        String []startime3 = {"16:00","14:00","23:10","22:00","23:00","16:00","12:00","20:00","22:00","23:15","21:20","21:00","16:30","15:30","23:00","22:40","21:15","13:00","21:00","23:00","22:40","21:00","13:00","13:00","14:30","12:00","23:40","22:45","13:20","21:50","14:00","13:00","22:30","22:45","21:40","20:45","00:30","01:30","15:00"};
        String []endtime3 = {"22:50","20:00","05:00","08:20","08:30","22:30","18:55","06:15","06:00","06:30","06:05","05:30","22:00","20:00","05:40","09:30","05:30","19:00","07:00","08:20","09:30","06:45","17:30","18:00","21:30","18:30","06:55","06:10","19:40","08:00","06:25","06:20","06:40","07:00","06:15","04:30","17:45","17:30","19:25"};
        String [][]seatmatrix = new String[20][20];
        String []uniquekey= {"V1","V2","V3","V4","V5","V6","V7","V8","V9","V10","V11","V12","V13","V14","V15","V16","V17","V18","V19","V20","V21","V22","V23","V24","V25","V26","V27","V28","V29","V30","V31","V32","V33","V34","V35","V36","V37","V38","V39"};
        String []uniquekey1= {"D1","D2","D3","D4","D5","D6","D7","D8","D9","D10","D11","D12","D13","D14","D15","D16","D17","D18","D19","D20","D21","D22","D23","D24","D25","D26","D27","D28","D29","D30","D31","D32","D33","D34","D35","D36","D37","D38","D39"};
        String []uniquekey2= {"S1","S2","S3","S4","S5","S6","S7","S8","S9","S10","S11","S12","S13","S14","S15","S16","S17","S18","S19","S20","S21","S22","S23","S24","S25","S26","S27","S28","S29","S30","S31","S32","S33","S34","S35","S36","S37","S38","S39"};
        int []prices1 =       {600,750,450,600,750,600,750,450,600,600,450,450,600,750,450,600,600,750,600,750,600,600,600,750,600,750,450,600,750,600,600,750,600,600,450,450,600,750,600,750,600};
        int []prices2 =       {650,720,400,650,720,650,720,400,650,650,400,400,650,720,400,650,650,720,650,720,650,650,650,720,650,720,400,650,720,650,650,720,650,650,400,400,650,720,650,720,650};
        int []prices3 =       {620,750,500,620,750,620,750,500,620,620,500,500,620,750,500,620,620,750,620,750,620,620,620,750,620,750,500,620,750,620,620,750,620,620,500,500,620,750,620,750,620};
        
        
        int []rows   =  {4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4};
        int []columns = {8,10,8,8,10,8,10,8,8,8,8,8,8,10,8,8,8,10,8,10,8,8,8,10,8,10,8,8,10,8,8,10,8,8,8,8,8,10,8};
        int j,k;
        
        
        /*OutputStream file = new FileOutputStream("VRLTesting.dat",true);
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);*/
        /*OutputStream file1 = new FileOutputStream("DurgambaTesting.dat",true);
        OutputStream buffer1 = new BufferedOutputStream(file1);
        ObjectOutput output1 = new ObjectOutputStream(buffer1);*/
        /*OutputStream file2 = new FileOutputStream("SugamaTesting.dat",true);
        OutputStream buffer2 = new BufferedOutputStream(file2);
        ObjectOutput output2 = new ObjectOutputStream(buffer2);*/
        for(i=0;i<39;i++)      
        {   Vrl obj = new Vrl();
            Durgamba obj1=new Durgamba();
            Sugama obj2=new Sugama();                        
            obj.type = type[i];
            obj.source = source[i];
            obj.destination = destination[i];
            obj.starttime = startime1[i];
            obj.endtime = endtime1[i];
            obj.key = uniquekey[i];
            obj.price = prices1[i]; //VRL buses are inputted here
            obj.rows = rows[i];
            obj.columns = columns[i];
            
             for(j = 0;j<obj.rows;j++)
             { 
                 for(k = 0;k<obj.columns;k++)
                     obj.seatmatrix[j][k] = 'X';
             }
            obj1.type = type[i];
            obj1.source = source[i];
            obj1.destination = destination[i];
            obj1.starttime = startime2[i];
            obj1.endtime = endtime2[i];//durgamba buses are inputted here
            obj1.key = uniquekey1[i];
            obj1.price = prices2[i];
            obj1.rows = rows[i];
            obj1.columns = columns[i];
             
            for(j = 0;j<obj1.rows;j++)
             { 
                 for(k = 0;k<obj1.columns;k++)
                     obj1.seatmatrix[j][k] = 'X';
             }
            obj2.type = type[i];
            obj2.source = source[i];
            obj2.destination = destination[i];
            obj2.starttime = startime3[i];
            obj2.endtime = endtime3[i];
            obj2.key = uniquekey2[i];//Sugama buses are inputted here
            obj2.price = prices3[i];
            obj2.rows = rows[i];
            obj2.columns = columns[i];
             for(j = 0;j<obj2.rows;j++)
             { 
                 for(k = 0;k<obj2.columns;k++)
                     obj2.seatmatrix[j][k] = 'X';
             }
            vrllist.add(obj);//vrl buses added to this list
            durlist.add(obj1);//durgamba buses added to ths list
            sugalist.add(obj2);//sugama buses added to this list
        }
        File f=new File ("VRLTesting.dat");//file to store vrl buses
        if(!f.exists())// to check if file exists
        {  
        f.createNewFile();
        OutputStream file = new FileOutputStream(f); // 10/11/13-Removed the true
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);
        output.writeObject(vrllist);//writing to vrl file
        output.close();
        buffer.close();
        file.close();
        }
        File f1=new File("DurgambaTesting.dat"); // file to store durgamba buses
        if(!f1.exists())
        {
           f1.createNewFile();
           OutputStream file1 = new FileOutputStream(f1);
           OutputStream buffer1 = new BufferedOutputStream(file1);
           ObjectOutput output1 = new ObjectOutputStream(buffer1);
           output1.writeObject(durlist);//writing to durgamba file
           output1.close();
           buffer1.close();
           file1.close();
        } 
       File f2=new File("SugamaTesting.dat"); // file to store sugama buses
       if(!f2.exists())
       { 
        f2.createNewFile();   
        OutputStream file2 = new FileOutputStream(f2);
        OutputStream buffer2 = new BufferedOutputStream(file2);
        ObjectOutput output2 = new ObjectOutputStream(buffer2);
        output2.writeObject(sugalist); // file to store sugama buses
        output2.close();
        buffer2.close();
        file2.close();
       } 
    
      Main ob=new Main();
       }
// Menus for admin
   public static  void adminmenu() throws IOException, ClassNotFoundException
    {
        Scanner scan = new Scanner(System.in);
        int i;
        int choice;
       // do
        //{
        /*  System.out.println("1. Vrl ");
          System.out.println("2. Sugama");
          System.out.println("3. Durgamba");
          System.out.println("4. Exit");
          System.out.println("Enter your choice ");*/
       //   i = scan.nextInt();
         /* switch(i)
          {
              case 1:
              vrladminmenu();
              break;
              case 2:
              sugadminmenu();
              break;
              case 3:
              duradminmenu();
              break;



          }
        }while(i<=3);
*/

       }






 public static void vrladminmenu() throws IOException, ClassNotFoundException
    {
       
        ArrayList<Vrl> vrltemp = new ArrayList();       
        Vrl obj1 = new Vrl();
        Scanner scan = new Scanner(System.in);
        int i;
        int choice;
        int count = 0;
        boolean eof =false;

        do
        {
        /*  System.out.println("1.Add a new bus ");
          System.out.println("2.Modify the details of existing bus");
          System.out.println("3.Remove a bus");
          System.out.println("4.Display a list of all the buses");
          System.out.println("5. Exit");
          System.out.println("Enter your choice ");*/
          i = scan.nextInt();
          switch(i)
          {
              case 1:
              Vrl obj = new Vrl();
              FileInputStream f = new FileInputStream("VrlTesting.dat");//open vrl file to read the buses
              ObjectInputStream objectinput = new ObjectInputStream(f);
              ArrayList<Vrl> read = (ArrayList<Vrl>) objectinput.readObject();//list containig these buses
              objectinput.close();
              obj.adddetails();
              read.add(obj);//add new bus to list
              
              OutputStream file = new FileOutputStream("VrlTesting.dat");
              OutputStream buffer = new BufferedOutputStream(file);
              ObjectOutput output = new ObjectOutputStream(buffer);
             
              output.writeObject(read);//rewrite contents back to list
              
              output.close();
             
              break;
              case 2:
              vrlmodifymenu();
              break;
              case 3:
             // vrlremove();
              break;

              case 4:
               FileInputStream f1 = new FileInputStream("VrlTesting.dat");
        
        try
       {   
          ObjectInputStream objectinputstream = new ObjectInputStream(f1);
          ArrayList<Vrl> readCase = (ArrayList<Vrl>) objectinputstream.readObject();
          System.out.println(readCase.size());
          objectinputstream .close();
          for(i = 0;i<readCase.size();i++)
          {
           /* System.out.println(readCase.get(i).type);
            System.out.println(readCase.get(i).source);
            System.out.println(readCase.get(i).destination);
            System.out.println(readCase.get(i).starttime);
            System.out.println(readCase.get(i).endtime);
            System.out.println(readCase.get(i).key);
            System.out.println(readCase.get(i).price);*/
            readCase.get(i).displayseatmatrix();
          }
          
              


        }
               catch (Exception e) 
               {
                 e.printStackTrace();
               }
        break;          
     }

        }while(i<=4);


    }
 
   public static  void duradminmenu() throws IOException, ClassNotFoundException
    {


        Durgamba obj1 = new Durgamba();
        Scanner scan = new Scanner(System.in);
        int i;
        int choice;
        int count = 0;

        do
        {
          /*System.out.println("1.Add a new bus ");
          System.out.println("2.Modify the details of existing bus");
          System.out.println("3.Remove a bus");
          System.out.println("4.Display a list of all the buses");
          System.out.println("5. Exit");
          System.out.println("Enter your choice ");*/
          i = scan.nextInt();
          switch(i)
          {
              case 1:
              Durgamba obj = new Durgamba();
              FileInputStream f = new FileInputStream("DurgambaTesting.dat");//opening file to read the buses
              ObjectInputStream objectinput = new ObjectInputStream(f);
              ArrayList<Durgamba> read = (ArrayList<Durgamba>) objectinput.readObject();//list contining all the buses
              objectinput.close();
              obj.adddetails();
              read.add(obj);//adding a new bus to the list
              
              OutputStream file = new FileOutputStream("DurgambaTesting.dat");
              OutputStream buffer = new BufferedOutputStream(file);
              ObjectOutput output = new ObjectOutputStream(buffer);
             
              output.writeObject(read);//re writing the modified list
              
              output.close();
              break;
              case 2:
              duramodifymenu();
              break;
              case 3:
//              durremove();
              break;
              case 4:
              FileInputStream f1 = new FileInputStream("DurgambaTesting.dat");
        
        try
       {   
          ObjectInputStream objectinputstream = new ObjectInputStream(f1);
          ArrayList<Durgamba> readCase = (ArrayList<Durgamba>) objectinputstream.readObject();
          objectinputstream .close();
          for(i = 0;i<readCase.size();i++)
          {
            /*System.out.println(readCase.get(i).type);
            System.out.println(readCase.get(i).source);
            System.out.println(readCase.get(i).destination);
            System.out.println(readCase.get(i).starttime);
            System.out.println(readCase.get(i).endtime);
            System.out.println(readCase.get(i).key);
            System.out.println(readCase.get(i).price);*/
            readCase.get(i).displayseatmatrix();
          }
              
              


        }
               catch (Exception e) 
               {
                 e.printStackTrace();
               }
              break;


          }
        }while(i<=4);



 }
 
     public static  void sugadminmenu() throws IOException,EOFException, ClassNotFoundException
    {

        Sugama obj1 = new Sugama();
        Scanner scan = new Scanner(System.in);
        int i;
        int choice;
        int count = 0;

        do
        {
         /* System.out.println("1.Add a new bus ");
          System.out.println("2.Modify the details of existing bus");
          System.out.println("3.Remove a bus");
          System.out.println("4.Display a list of all the buses");
          System.out.println("5. Exit");
          System.out.println("Enter your choice ");*/
          i = scan.nextInt();
          switch(i)
          {
              case 1:
             Sugama obj = new Sugama();
              FileInputStream f = new FileInputStream("SugamaTesting.dat");//opening file to read buses
              ObjectInputStream objectinput = new ObjectInputStream(f);
              ArrayList<Sugama> read = (ArrayList<Sugama>) objectinput.readObject();
              objectinput.close();
              obj.adddetails();
              read.add(obj);//adding new object to the list
              
              OutputStream file = new FileOutputStream("SugamaTesting.dat");
              OutputStream buffer = new BufferedOutputStream(file);
              ObjectOutput output = new ObjectOutputStream(buffer);
             
              output.writeObject(read);//rewriting modified list to the file
              
              output.close();
             
              break;
              case 2:
              sugamodifymenu();
              break;
              case 3:
             // sugaremove();
              break;
              case 4:
                   FileInputStream f1 = new FileInputStream("SugamaTesting.dat");
        
                  try
                   {   
                    ObjectInputStream objectinputstream = new ObjectInputStream(f1);
                    ArrayList<Sugama> readCase = (ArrayList<Sugama>) objectinputstream.readObject();
                    System.out.println(readCase.size());
                    objectinputstream .close();
          for(i = 0;i<readCase.size();i++)
          {
           /* System.out.println(readCase.get(i).type);
            System.out.println(readCase.get(i).source);
            System.out.println(readCase.get(i).destination);
            System.out.println(readCase.get(i).starttime);
            System.out.println(readCase.get(i).endtime);
            System.out.println(readCase.get(i).key);
            System.out.println(readCase.get(i).price);*/
            readCase.get(i).displayseatmatrix();
          }
          
              


        }
               catch (Exception e) 
               {
                 e.printStackTrace();
               }
        break; 

          }
        }while(i<=4);

    }
     
     public static void durremove(String uniq) throws FileNotFoundException, IOException, ClassNotFoundException
 {
   //String sourcesearch , destsearch , uniq ;
   //Scanner scan = new Scanner(System.in);
   Durgamba obj = new Durgamba();
   FileInputStream f = new FileInputStream("DurgambaTesting.dat");
   ObjectInputStream objectinput = new ObjectInputStream(f);
   ArrayList<Durgamba> read = (ArrayList<Durgamba>) objectinput.readObject();
   objectinput.close();
   //System.out.println("Enter the source ");
   //sourcesearch = scan.nextLine();
   //System.out.println("Enter the destination");
   //destsearch = scan.nextLine();
   //System.out.println("Enter the unique key");
   //uniq = scan.nextLine();

   for(int i = 0;i<read.size();i++)
    {  Durgamba obj1 = new Durgamba();
       obj1 = (Durgamba)read.get(i);
       if(/*obj1.source.equalsIgnoreCase(sourcesearch)&&obj1.destination.equalsIgnoreCase(destsearch)&&*/obj1.key.equals(uniq))
       read.remove(i);//remove selected bus from the list
   }
              OutputStream file = new FileOutputStream("DurgambaTesting.dat");
              OutputStream buffer = new BufferedOutputStream(file);
              ObjectOutput output = new ObjectOutputStream(buffer);
             
              output.writeObject(read);//re write the modified list to the file
              
              output.close();
   
 }
 // Removal functions

  public static void vrlremove(String uniq) throws FileNotFoundException, IOException, ClassNotFoundException
 {
   //String sourcesearch , destsearch , uniq ;
   //Scanner scan = new Scanner(System.in);
   Vrl obj = new Vrl();
   FileInputStream f = new FileInputStream("VrlTesting.dat");
   ObjectInputStream objectinput = new ObjectInputStream(f);
   ArrayList<Vrl> read = (ArrayList<Vrl>) objectinput.readObject();
   objectinput.close();
   //System.out.println("Enter the source ");
   //sourcesearch = scan.nextLine();
   //System.out.println("Enter the destination");
   //destsearch = scan.nextLine();
  // System.out.println("Enter the unique key");
   //uniq = scan.nextLine();

   for(int i = 0;i<read.size();i++)
    {  Vrl obj1 = new Vrl();
       obj1 = (Vrl)read.get(i);
       if(/*obj1.source.equalsIgnoreCase(sourcesearch)&&obj1.destination.equalsIgnoreCase(destsearch)&&*/obj1.key.equals(uniq))
       read.remove(i);//remove the slected bus
   }
              OutputStream file = new FileOutputStream("VrlTesting.dat");
              OutputStream buffer = new BufferedOutputStream(file);
              ObjectOutput output = new ObjectOutputStream(buffer);
             
              output.writeObject(read);//re write the list back to the file
              
              output.close();
   
 }
 public static void sugaremove(String uniq) throws FileNotFoundException, IOException, ClassNotFoundException
 {
 //  String sourcesearch , destsearch , uniq ;
 //  Scanner scan = new Scanner(System.in);
   Sugama obj = new Sugama();
   FileInputStream f = new FileInputStream("SugamaTesting.dat");
   ObjectInputStream objectinput = new ObjectInputStream(f);
   ArrayList<Sugama> read = (ArrayList<Sugama>) objectinput.readObject();
   objectinput.close();
   //System.out.println("Enter the source ");
  // sourcesearch = scan.nextLine();
  // System.out.println("Enter the destination");
   //destsearch = scan.nextLine();
   //System.out.println("Enter the unique key");
   //uniq = scan.nextLine();

   for(int i = 0;i<read.size();i++)
    {  Sugama obj1 = new Sugama();
       obj1 = (Sugama)read.get(i);
       if(obj1.key.equals(uniq))
       read.remove(i);//remove the selected bus
   }
              OutputStream file = new FileOutputStream("SugamaTesting.dat");
              OutputStream buffer = new BufferedOutputStream(file);
              ObjectOutput output = new ObjectOutputStream(buffer);
             
              output.writeObject(read);//re write the modified list back to thefile
              
              output.close();
   
 }
 public static void durremove() throws FileNotFoundException, IOException, ClassNotFoundException
 {
   String sourcesearch , destsearch , uniq ;
   Scanner scan = new Scanner(System.in);
   Durgamba obj = new Durgamba();
   FileInputStream f = new FileInputStream("DurgambaTesting.dat");
   ObjectInputStream objectinput = new ObjectInputStream(f);
   ArrayList<Durgamba> read = (ArrayList<Durgamba>) objectinput.readObject();
   objectinput.close();
  // System.out.println("Enter the source ");
 //  sourcesearch = scan.nextLine();
   //System.out.println("Enter the destination");
  // destsearch = scan.nextLine();
   //System.out.println("Enter the unique key");
  // uniq = scan.nextLine();

   for(int i = 0;i<read.size();i++)
    {  Durgamba obj1 = new Durgamba();
       obj1 = (Durgamba)read.get(i);
    //   if(obj1.source.equalsIgnoreCase(sourcesearch)&&obj1.destination.equalsIgnoreCase(destsearch)&&obj1.key.equals(uniq))
       read.remove(i);//remove the selected bus from list
   }
              OutputStream file = new FileOutputStream("DurgambaTesting.dat");
              OutputStream buffer = new BufferedOutputStream(file);
              ObjectOutput output = new ObjectOutputStream(buffer);
             
              output.writeObject(read);// re write the modified list
              
              output.close();
   
 }

 // Modify functions
 public static void vrlmodifymenu() throws FileNotFoundException, IOException, ClassNotFoundException
 {
        Vrl obj1 = new Vrl();
        Scanner scan1 = new Scanner(System.in);
        int i;
        int choice;
        String routesearch;
        String typemod;
        String sourcemod;
        String destmod;
        String startmod, endmod , routemod;
        int pricemod;

        do
        {
         /* System.out.println("1. Modify the type of bus ");
          System.out.println("2. Modify the source ");
          System.out.println("3. Modify the destination ");
          System.out.println("4. Modify the start time");
          System.out.println("5. Modify the end time ");
          System.out.println("6. Modify the price per ticket ");
          System.out.println("7. Modify the seat matrix");
          System.out.println("8. Exit");
          System.out.println("Enter your choice ");*/
          i = scan1.nextInt();

          switch(i)
          {
              case 1:
            //  System.out.println("Enter the unique key of the bus whose type you wish to modify");
            //  routesearch = scan1.nextLine();
            //  routesearch = scan1.nextLine();
               Vrl obj = new Vrl();
              FileInputStream f = new FileInputStream("VrlTesting.dat");
              ObjectInputStream objectinput = new ObjectInputStream(f);
              ArrayList<Vrl> read = (ArrayList<Vrl>) objectinput.readObject();
              objectinput.close();
              
              
            for(int j = 0;j<read.size();j++)
              {
                 obj1 = (Vrl)read.get(j);
                // if(obj1.key.equalsIgnoreCase(routesearch))
                 {
                   //  System.out.println("Enter the type of bus ");
                     typemod = scan1.nextLine();
                     
                     obj1.typechange(typemod);//call to typemod function
                 }
              }
              OutputStream file = new FileOutputStream("VrlTesting.dat");
              OutputStream buffer = new BufferedOutputStream(file);
              ObjectOutput output = new ObjectOutputStream(buffer);
             
              output.writeObject(read);//re write modified contents to file
              
              output.close();
              break;
              case 2:
             // System.out.println("Enter the unique key of the bus whose type you wish to modify");
              
            //  routesearch = scan1.nextLine();
            //  routesearch = scan1.nextLine();
              Vrl obj3 = new Vrl();
              FileInputStream f1 = new FileInputStream("VrlTesting.dat");
              ObjectInputStream objectinput2 = new ObjectInputStream(f1);
              ArrayList<Vrl> read2 = (ArrayList<Vrl>) objectinput2.readObject();
              objectinput2.close();
              
              for(int j = 0;j<read2.size();j++)
              {
                 obj1 = (Vrl)read2.get(j);
                // if(obj1.key.equalsIgnoreCase(routesearch))
                 {
                    // System.out.println("Enter the new source of bus ");
                     sourcemod=scan1.nextLine();
                     obj1.sourcechange(sourcemod);//call to source change function
                 }
              }
              OutputStream file2 = new FileOutputStream("VrlTesting.dat");
              OutputStream buffer2 = new BufferedOutputStream(file2);
              ObjectOutput output2 = new ObjectOutputStream(buffer2);
             
              output2.writeObject(read2);//re write back to the file
              
              output2.close();
              break;
             case 3:
              
             // System.out.println("Enter the unique key of the bus whose type you wish to modify");
             // routesearch = scan1.nextLine();
             // routesearch = scan1.nextLine();
              Vrl obj4 = new Vrl();
              FileInputStream f2 = new FileInputStream("VrlTesting.dat");
              ObjectInputStream objectinput3 = new ObjectInputStream(f2);
              ArrayList<Vrl> read3 = (ArrayList<Vrl>) objectinput3.readObject();
              objectinput3.close();
              for(int j = 0;j<read3.size();j++)
              {
                 obj1 = (Vrl)read3.get(j);
               //  if(obj1.key.equalsIgnoreCase(routesearch))
                 {
                     System.out.println("Enter the new destination of bus ");
                     destmod=scan1.nextLine();
                     obj1.destinationchange(destmod);//call to dest change function
                 }
              }
              OutputStream file3 = new FileOutputStream("VrlTesting.dat");
              OutputStream buffer3 = new BufferedOutputStream(file3);
              ObjectOutput output3 = new ObjectOutputStream(buffer3);
             
              output3.writeObject(read3);//re write back to the file
              
              output3.close();
              
              break;
           case 4:
             // System.out.println("Enter the unique key of the bus whose type you wish to modify");
            //  routesearch = scan1.nextLine();
            //  routesearch = scan1.nextLine();
              Vrl obj5 = new Vrl();
              FileInputStream f3 = new FileInputStream("VrlTesting.dat");
              ObjectInputStream objectinput4 = new ObjectInputStream(f3);
              ArrayList<Vrl> read4 = (ArrayList<Vrl>) objectinput4.readObject();
              objectinput4.close();
              
              
              for(int j = 0;j<read4.size();j++)
              {
                 obj1 = (Vrl)read4.get(j);
              //   if(obj1.key.equalsIgnoreCase(routesearch))
                 {
                     System.out.println("Enter the new start time of bus ");
                     destmod=scan1.nextLine();
                     obj1.starttimechange(destmod);
                 }
              }
               OutputStream file4 = new FileOutputStream("VrlTesting.dat");
              OutputStream buffer4 = new BufferedOutputStream(file4);
              ObjectOutput output4 = new ObjectOutputStream(buffer4);
             
              output4.writeObject(read4);
              
              output4.close();
              break;
           case 5:
             // System.out.println("Enter the unique key of the bus whose type you wish to modify");
             // routesearch = scan1.nextLine();
            //  routesearch = scan1.nextLine();
              Vrl obj6 = new Vrl();
              FileInputStream f4 = new FileInputStream("VrlTesting.dat");
              ObjectInputStream objectinput5 = new ObjectInputStream(f4);
              ArrayList<Vrl> read5 = (ArrayList<Vrl>) objectinput5.readObject();
              objectinput5.close();
              for(int j = 0;j<read5.size();j++)
              {
                 obj1 = (Vrl)read5.get(j);
              //   if(obj1.key.equalsIgnoreCase(routesearch))
                 {
                     System.out.println("Enter the new end time of bus ");
                     endmod=scan1.nextLine();
                     obj1.endtimechange(endmod);//change the end time
                 }
              }
              OutputStream file5 = new FileOutputStream("VrlTesting.dat");
              OutputStream buffer5 = new BufferedOutputStream(file5);
              ObjectOutput output5 = new ObjectOutputStream(buffer5);
             
              output5.writeObject(read5);//re write contents back to the file
              
              output5.close();
              
              break;
            case 6:
            //  System.out.println("Enter the unique key of the bus whose type you wish to modify");
            //  routesearch = scan1.nextLine();
            //  routesearch = scan1.nextLine();
              Vrl obj7 = new Vrl();
              FileInputStream f5 = new FileInputStream("VrlTesting.dat");
              ObjectInputStream objectinput6 = new ObjectInputStream(f5);
              ArrayList<Vrl> read6 = (ArrayList<Vrl>) objectinput6.readObject();
              objectinput6.close();
              for(int j = 0;j<read6.size();j++)
              {
                 obj1 = (Vrl)read6.get(j);
              //   if(obj1.key.equalsIgnoreCase(routesearch))
                 {
                     System.out.println("Enter the new price per ticket of bus ");
                     pricemod=scan1.nextInt();
                     obj1.pricechange(pricemod); //method to change the price 
                 }
              }
               OutputStream file6 = new FileOutputStream("VrlTesting.dat");
              OutputStream buffer6 = new BufferedOutputStream(file6);
              ObjectOutput output6 = new ObjectOutputStream(buffer6);
             
              output6.writeObject(read6);// re write contents back to the file
              
              output6.close();
              
              break;
            case 7:
         //     System.out.println("Enter the unique key of the bus whose type you wish to modify");
          //    routesearch = scan1.nextLine();
           //   routesearch = scan1.nextLine();
              Vrl obj8 = new Vrl();
              FileInputStream f6 = new FileInputStream("VrlTesting.dat");
              ObjectInputStream objectinput7 = new ObjectInputStream(f6);
              ArrayList<Vrl> read7 = (ArrayList<Vrl>) objectinput7.readObject();
              objectinput7.close();
              for(int j = 0;j<read7.size();j++)
              {
                 obj1 = (Vrl)read7.get(j);
             //    if(obj1.key.equalsIgnoreCase(routesearch))
                 {
                  obj1.alterseatmatrix();
                 } 
              }
              OutputStream file7 = new FileOutputStream("VrlTesting.dat");
              OutputStream buffer7 = new BufferedOutputStream(file7);
              ObjectOutput output7 = new ObjectOutputStream(buffer7);
             
              output7.writeObject(read7);// re write contents back to the file
              
              output7.close();
          }
        }while(i<=7);
        
       
        
}


 public static void duramodifymenu() throws FileNotFoundException, IOException, ClassNotFoundException
 {
        Durgamba obj1 = new Durgamba();
        Scanner scan1 = new Scanner(System.in);
        int i;
        int choice;
        String routesearch;
        String typemod;
        String sourcemod;
        String destmod;
        String startmod, endmod , routemod;
        int pricemod;

        do
        {
          /*System.out.println("1. Modify the type of bus ");
          System.out.println("2. Modify the source ");
          System.out.println("3. Modify the destination ");
          System.out.println("4. Modify the start time");
          System.out.println("5. Modify the end time ");
          System.out.println("6. Modify the price per ticket ");
          System.out.println("7. Modify the seat matrix");
          System.out.println("8. Exit");
          System.out.println("Enter your choice ");*/
          i = scan1.nextInt();

          switch(i)
          {
              case 1:
             // System.out.println("Enter the unique key of the bus whose type you wish to modify");
             // routesearch = scan1.nextLine();
             // routesearch = scan1.nextLine();
               Durgamba obj = new Durgamba();
              FileInputStream f = new FileInputStream("DurgambaTesting.dat");
              ObjectInputStream objectinput = new ObjectInputStream(f);
              ArrayList<Durgamba> read = (ArrayList<Durgamba>) objectinput.readObject();
              objectinput.close();
              
              
                 for(int j = 0;j<read.size();j++)
                 {
                 obj1 = (Durgamba)read.get(j);
             //    if(obj1.key.equalsIgnoreCase(routesearch))
                 {
                    // System.out.println("Enter the type of bus ");
                     typemod = scan1.nextLine();
                     
                     obj1.typechange(typemod);//change the type
                 }
              }
              OutputStream file = new FileOutputStream("DurgambaTesting.dat");
              OutputStream buffer = new BufferedOutputStream(file);
              ObjectOutput output = new ObjectOutputStream(buffer);
             
              output.writeObject(read);// re write contents back to the file
              
              output.close();
              break;
              case 2:
              //System.out.println("Enter the unique key of the bus whose type you wish to modify");
              
             // routesearch = scan1.nextLine();
             // routesearch = scan1.nextLine();
              Durgamba obj3 = new Durgamba();
              FileInputStream f1 = new FileInputStream("DurgambaTesting.dat");
              ObjectInputStream objectinput2 = new ObjectInputStream(f1);
              ArrayList<Durgamba> read2 = (ArrayList<Durgamba>) objectinput2.readObject();
              objectinput2.close();
              
              for(int j = 0;j<read2.size();j++)
              {
                 obj1 = (Durgamba)read2.get(j);
                 //if(obj1.key.equalsIgnoreCase(routesearch))
                 {
                   //  System.out.println("Enter the new source of bus ");
                     sourcemod=scan1.nextLine();
                     obj1.sourcechange(sourcemod);//change source
                 }
              }
              OutputStream file2 = new FileOutputStream("DurgambaTesting.dat");
              OutputStream buffer2 = new BufferedOutputStream(file2);
              ObjectOutput output2 = new ObjectOutputStream(buffer2);
             
              output2.writeObject(read2);//// re write contents back to the file
              
              output2.close();
              break;
             case 3:
              
            //  System.out.println("Enter the unique key of the bus whose type you wish to modify");
            //  routesearch = scan1.nextLine();
             // routesearch = scan1.nextLine();
              Durgamba obj4 = new Durgamba();
              FileInputStream f2 = new FileInputStream("DurgambaTesting.dat");
              ObjectInputStream objectinput3 = new ObjectInputStream(f2);
              ArrayList<Durgamba> read3 = (ArrayList<Durgamba>) objectinput3.readObject();
              objectinput3.close();
              for(int j = 0;j<read3.size();j++)
              {
                 obj1 = (Durgamba)read3.get(j);
               //  if(obj1.key.equalsIgnoreCase(routesearch))
                 {
                   //  System.out.println("Enter the new destination of bus ");
                     destmod=scan1.nextLine();
                     obj1.destinationchange(destmod);//change destination
                 }
              }
              OutputStream file3 = new FileOutputStream("DurgambaTesting.dat");
              OutputStream buffer3 = new BufferedOutputStream(file3);
              ObjectOutput output3 = new ObjectOutputStream(buffer3);
              output3.writeObject(read3);// re write contents back to the file
              output3.close();
              
              break;
           case 4:
            //  System.out.println("Enter the unique key of the bus whose type you wish to modify");
            //  routesearch = scan1.nextLine();
             // routesearch = scan1.nextLine();
              Durgamba obj5 = new Durgamba();
              FileInputStream f3 = new FileInputStream("DurgambaTesting.dat");
              ObjectInputStream objectinput4 = new ObjectInputStream(f3);
              ArrayList<Durgamba> read4 = (ArrayList<Durgamba>) objectinput4.readObject();
              objectinput4.close();
              
              
              for(int j = 0;j<read4.size();j++)
              {
                 obj1 = (Durgamba)read4.get(j);
               //  if(obj1.key.equalsIgnoreCase(routesearch))
                 {
                   //  System.out.println("Enter the new start time of bus ");
                     destmod=scan1.nextLine();
                     obj1.starttimechange(destmod);
                 }
              }
               OutputStream file4 = new FileOutputStream("DurgambaTesting.dat");
              OutputStream buffer4 = new BufferedOutputStream(file4);
              ObjectOutput output4 = new ObjectOutputStream(buffer4);
             
              output4.writeObject(read4);// re write contents back to the file
              
              output4.close();
              break;
           case 5:
              //System.out.println("Enter the unique key of the bus whose type you wish to modify");
              //routesearch = scan1.nextLine();
              //routesearch = scan1.nextLine();
              Vrl obj6 = new Vrl();
              FileInputStream f4 = new FileInputStream("DurgambaTesting.dat");
              ObjectInputStream objectinput5 = new ObjectInputStream(f4);
              ArrayList<Durgamba> read5 = (ArrayList<Durgamba>) objectinput5.readObject();
              objectinput5.close();
              for(int j = 0;j<read5.size();j++)
              {
                 obj1 = (Durgamba)read5.get(j);
                // if(obj1.key.equalsIgnoreCase(routesearch))
                 {
                    // System.out.println("Enter the new end time of bus ");
                     endmod=scan1.nextLine();
                     obj1.endtimechange(endmod);//change end time
                 }
              }
              OutputStream file5 = new FileOutputStream("DurgambaTesting.dat");
              OutputStream buffer5 = new BufferedOutputStream(file5);
              ObjectOutput output5 = new ObjectOutputStream(buffer5);
             
              output5.writeObject(read5); //// re write contents back to the file
              
              output5.close();
              
              break;
            case 6:
             // System.out.println("Enter the unique key of the bus whose type you wish to modify");
             // routesearch = scan1.nextLine();
             // routesearch = scan1.nextLine();
              Vrl obj7 = new Vrl();
              FileInputStream f5 = new FileInputStream("DurgambaTesting.dat");
              ObjectInputStream objectinput6 = new ObjectInputStream(f5);
              ArrayList<Durgamba> read6 = (ArrayList<Durgamba>) objectinput6.readObject();
              objectinput6.close();
              for(int j = 0;j<read6.size();j++)
              {
                 obj1 = (Durgamba)read6.get(j);
              //   if(obj1.key.equalsIgnoreCase(routesearch))
                 {
                 //    System.out.println("Enter the new price per ticket of bus ");
                     pricemod=scan1.nextInt();
                     obj1.pricechange(pricemod);
                 }
              }
               OutputStream file6 = new FileOutputStream("DurgambaTesting.dat");
              OutputStream buffer6 = new BufferedOutputStream(file6);
              ObjectOutput output6 = new ObjectOutputStream(buffer6);
             
              output6.writeObject(read6);// re write contents back to the file
              
              output6.close();
              
              break;
            case 7:
             // System.out.println("Enter the unique key of the bus whose type you wish to modify");
             // routesearch = scan1.nextLine();
            //  routesearch = scan1.nextLine();
              Vrl obj8 = new Vrl();
              FileInputStream f6 = new FileInputStream("DurgambaTesting.dat");
              ObjectInputStream objectinput7 = new ObjectInputStream(f6);
              ArrayList<Durgamba> read7 = (ArrayList<Durgamba>) objectinput7.readObject();
              objectinput7.close();
              for(int j = 0;j<read7.size();j++)
              {
                 obj1 = (Durgamba)read7.get(j);
               //  if(obj1.key.equalsIgnoreCase(routesearch))
                 {
                  obj1.alterseatmatrix();
                 } 
              }
              OutputStream file7 = new FileOutputStream("DurgambaTesting.dat");
              OutputStream buffer7 = new BufferedOutputStream(file7);
              ObjectOutput output7 = new ObjectOutputStream(buffer7);
             
              output7.writeObject(read7);// re write contents back to the file
              
              output7.close();
          }
        }while(i<=7);
        
       
}

 public static void sugamodifymenu() throws FileNotFoundException, IOException, ClassNotFoundException
 {
        Sugama obj1 = new Sugama();
        Scanner scan1 = new Scanner(System.in);
        int i;
        int choice;
        String routesearch;
        String typemod;
        String sourcemod;
        String destmod;
        String startmod, endmod , routemod;
        int pricemod;

        do
        {
         /* System.out.println("1. Modify the type of bus ");
          System.out.println("2. Modify the source ");
          System.out.println("3. Modify the destination ");
          System.out.println("4. Modify the start time");
          System.out.println("5. Modify the end time ");
          System.out.println("6. Modify the price per ticket ");
          System.out.println("7. Modify the seat matrix");
          System.out.println("8. Exit");
          System.out.println("Enter your choice ");*/
          i = scan1.nextInt();

          switch(i)
          {
              case 1:
             // System.out.println("Enter the unique key of the bus whose type you wish to modify");
            //  routesearch = scan1.nextLine();
            //  routesearch = scan1.nextLine();
               Sugama obj = new Sugama();
              FileInputStream f = new FileInputStream("SugamaTesting.dat");
              ObjectInputStream objectinput = new ObjectInputStream(f);
              ArrayList<Sugama> read = (ArrayList<Sugama>) objectinput.readObject();
              objectinput.close();
              
              
            for(int j = 0;j<read.size();j++)
              {
                 obj1 = (Sugama)read.get(j);
               //  if(obj1.key.equalsIgnoreCase(routesearch))
                 {
                     //System.out.println("Enter the type of bus ");
                     typemod = scan1.nextLine();
                     
                     obj1.typechange(typemod);//change type
                 }
              }
              OutputStream file = new FileOutputStream("SugamaTesting.dat");
              OutputStream buffer = new BufferedOutputStream(file);
              ObjectOutput output = new ObjectOutputStream(buffer);
             
              output.writeObject(read);// re write contents back to the file
              
              output.close();
              break;
              case 2:
             // System.out.println("Enter the unique key of the bus whose type you wish to modify");
              
             // routesearch = scan1.nextLine();
             // routesearch = scan1.nextLine();
              Sugama obj3 = new Sugama();
              FileInputStream f1 = new FileInputStream("SugamaTesting.dat");
              ObjectInputStream objectinput2 = new ObjectInputStream(f1);
              ArrayList<Sugama> read2 = (ArrayList<Sugama>) objectinput2.readObject();
              objectinput2.close();
              
              for(int j = 0;j<read2.size();j++)
              {
                 obj1 = (Sugama)read2.get(j);
                // if(obj1.key.equalsIgnoreCase(routesearch))
                 {
                  //   System.out.println("Enter the new source of bus ");
                     sourcemod=scan1.nextLine();
                     obj1.sourcechange(sourcemod);
                 }
              }
              OutputStream file2 = new FileOutputStream("SugamaTesting.dat");
              OutputStream buffer2 = new BufferedOutputStream(file2);
              ObjectOutput output2 = new ObjectOutputStream(buffer2);
             
              output2.writeObject(read2);// re write contents back to the file
              
              output2.close();
              break;
             case 3:
              
             // System.out.println("Enter the unique key of the bus whose type you wish to modify");
              //routesearch = scan1.nextLine();
              //routesearch = scan1.nextLine();
              Sugama obj4 = new Sugama();
              FileInputStream f2 = new FileInputStream("SugamaTesting.dat");
              ObjectInputStream objectinput3 = new ObjectInputStream(f2);
              ArrayList<Sugama> read3 = (ArrayList<Sugama>) objectinput3.readObject();
              objectinput3.close();
              for(int j = 0;j<read3.size();j++)
              {
                 obj1 = (Sugama)read3.get(j);
              //   if(obj1.key.equalsIgnoreCase(routesearch))
                 {
                  //   System.out.println("Enter the new destination of bus ");
                     destmod=scan1.nextLine();
                     obj1.destinationchange(destmod);//change destination
                 }
              }
              OutputStream file3 = new FileOutputStream("SugamaTesting.dat");
              OutputStream buffer3 = new BufferedOutputStream(file3);
              ObjectOutput output3 = new ObjectOutputStream(buffer3);
             
              output3.writeObject(read3);//// re write contents back to the file
              
              output3.close();
              
              break;
           case 4:
             // System.out.println("Enter the unique key of the bus whose type you wish to modify");
              //routesearch = scan1.nextLine();
             // routesearch = scan1.nextLine();
              Sugama obj5 = new Sugama();
              FileInputStream f3 = new FileInputStream("SugamaTesting.dat");
              ObjectInputStream objectinput4 = new ObjectInputStream(f3);
              ArrayList<Sugama> read4 = (ArrayList<Sugama>) objectinput4.readObject();
              objectinput4.close();
              
              
              for(int j = 0;j<read4.size();j++)
              {
                 obj1 = (Sugama)read4.get(j);
               //  if(obj1.key.equalsIgnoreCase(routesearch))
                 {
                  //   System.out.println("Enter the new start time of bus ");
                     destmod=scan1.nextLine();
                     obj1.starttimechange(destmod);
                 }
              }
               OutputStream file4 = new FileOutputStream("SugamaTesting.dat");
              OutputStream buffer4 = new BufferedOutputStream(file4);
              ObjectOutput output4 = new ObjectOutputStream(buffer4);
             
              output4.writeObject(read4);// re write contents back to the file
              
              output4.close();
              break;
           case 5:
              //System.out.println("Enter the unique key of the bus whose type you wish to modify");
              //routesearch = scan1.nextLine();
              //routesearch = scan1.nextLine();
              Sugama obj6 = new Sugama();
              FileInputStream f4 = new FileInputStream("SugamaTesting.dat");
              ObjectInputStream objectinput5 = new ObjectInputStream(f4);
              ArrayList<Sugama> read5 = (ArrayList<Sugama>) objectinput5.readObject();
              objectinput5.close();
              for(int j = 0;j<read5.size();j++)
              {
                 obj1 = (Sugama)read5.get(j);
                 //if(obj1.key.equalsIgnoreCase(routesearch))
                 {
                 //    System.out.println("Enter the new end time of bus ");
                     endmod=scan1.nextLine();
                     obj1.endtimechange(endmod);//change end time 
                 }
              }
              OutputStream file5 = new FileOutputStream("SugamaTesting.dat");
              OutputStream buffer5 = new BufferedOutputStream(file5);
              ObjectOutput output5 = new ObjectOutputStream(buffer5);
             
              output5.writeObject(read5);// re write contents back to the file
              
              output5.close();
              
              break;
            case 6:
              //System.out.println("Enter the unique key of the bus whose type you wish to modify");
              //routesearch = scan1.nextLine();
              //routesearch = scan1.nextLine();
              Sugama obj7 = new Sugama();
              FileInputStream f5 = new FileInputStream("SugamaTesting.dat");
              ObjectInputStream objectinput6 = new ObjectInputStream(f5);
              ArrayList<Sugama> read6 = (ArrayList<Sugama>) objectinput6.readObject();
              objectinput6.close();
              for(int j = 0;j<read6.size();j++)
              {
                 obj1 = (Sugama)read6.get(j);
                // if(obj1.key.equalsIgnoreCase(routesearch))
                 {
                  //   System.out.println("Enter the new price per ticket of bus ");
                     pricemod=scan1.nextInt();
                     obj1.pricechange(pricemod);//// re write contents back to the file
                 }
              }
              OutputStream file6 = new FileOutputStream("SugamaTesting.dat");
              OutputStream buffer6 = new BufferedOutputStream(file6);
              ObjectOutput output6 = new ObjectOutputStream(buffer6);
             
              output6.writeObject(read6);// re write contents back to the file
              
              output6.close();
              
              break;
            case 7:
              //System.out.println("Enter the unique key of the bus whose type you wish to modify");
              //routesearch = scan1.nextLine();
              //routesearch = scan1.nextLine();
              Sugama obj8 = new Sugama();
              FileInputStream f6 = new FileInputStream("SugamaTesting.dat");
              ObjectInputStream objectinput7 = new ObjectInputStream(f6);
              ArrayList<Sugama> read7 = (ArrayList<Sugama>) objectinput7.readObject();
              objectinput7.close();
              for(int j = 0;j<read7.size();j++)
              {
                 obj1 = (Sugama)read7.get(j);
                // if(obj1.key.equalsIgnoreCase(routesearch))
                 {
                  obj1.alterseatmatrix();
                 } 
              }
              OutputStream file7 = new FileOutputStream("SugamaTesting.dat");
              OutputStream buffer7 = new BufferedOutputStream(file7);
              ObjectOutput output7 = new ObjectOutputStream(buffer7);
             
              output7.writeObject(read7);// re write contents back to the file
              
              output7.close();
          }
        }while(i<=7);
        
       
        
}



 //Customer Menus
 public static  void customermenu(ArrayList<PassDtls> vrlp,ArrayList<PassDtls> durp,ArrayList<PassDtls> sugap,ArrayList<Vrl> vrllist,ArrayList<Durgamba> durlist,ArrayList<Sugama> sugalist ) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        Scanner scan = new Scanner(System.in);
        int i;
        String key;
        int choice;
        do
        {
          /*System.out.println("1. Book Ticket ");
          System.out.println("2. Cancel ticket");
          System.out.println("3. Exit");
          System.out.println("Enter your choice ");*/
          i = scan.nextInt();
          switch(i)
          {
              case 1:
              key = searchbus();
             /// bookTicket(key);
              break;
              case 2:
             // cancelTicket();
              break;


          }
        }while(i<=2);


       }


//searchbus method for customer
  public static String searchbus() throws FileNotFoundException, IOException, ClassNotFoundException
     {   String uniqkey;
         FileInputStream f1 = new FileInputStream("VrlTesting.dat");
         ObjectInputStream objectinput1 = new ObjectInputStream(f1);
         ArrayList<Vrl> read1 = (ArrayList<Vrl>) objectinput1.readObject();
         objectinput1.close();
         FileInputStream f2 = new FileInputStream("SugamaTesting.dat");
         ObjectInputStream objectinput2 = new ObjectInputStream(f2);
         ArrayList<Sugama> read2 = (ArrayList<Sugama>) objectinput2.readObject();
         objectinput2.close();
         FileInputStream f3 = new FileInputStream("DurgambaTesting.dat");
         ObjectInputStream objectinput3 = new ObjectInputStream(f3);
         ArrayList<Durgamba> read3 = (ArrayList<Durgamba>) objectinput3.readObject();
         objectinput3.close();
         Scanner scan=new Scanner(System.in);
         int choice;
         ArrayList<Vrl> reqdVrl=new ArrayList();//the list of VRL buses on this route
         ArrayList<Durgamba> reqdDurgam=new ArrayList();//the list of Durgamba buses on this route
         ArrayList<Sugama> reqdSugam=new ArrayList();//the list of Sugama buses on this route

         int i=0;
         String src;//the start point
         String dest;//the end point

         //System.out.println("Enter the source station");
         src=scan.nextLine();
         //System.out.println("Enter the destination");
         dest=scan.nextLine();

         //Adding the objects to reqdVrl list
         for(i = 0;i<read1.size();i++)
         {   
             Vrl obj1 = new Vrl();
             obj1 = (Vrl)read1.get(i);
             {
                 if(obj1.source.equals(src) && obj1.destination.equals(dest))
                 reqdVrl.add((obj1));//add to search list
                 
             }
                
         }
         
         
         for(i=0;i<read3.size();i++)
         {    Durgamba obj2 = new Durgamba();
              
              obj2 = (Durgamba)read3.get(i);
               if(obj2.source.equals(src) && obj2.destination.equals(dest))
                 reqdDurgam.add((obj2));//add to search list

         }
         i=0;
         //Adding the objects to reqdSugam list
        
         while(i<read2.size())
         {   Sugama obj3 = new Sugama();
              obj3 = (Sugama)read2.get(i);
              if(obj3.source.equals(src) && obj3.destination.equals(dest))
               reqdSugam.add((obj3));//add to searchlist

             i++;
         }
         i=0;
         
         do
         {
           /*System.out.println("The buses on the route are");
           System.out.println("1.VRL "+reqdVrl.size()+" buses");
           System.out.println("2.DURGAMBA "+reqdDurgam.size()+" buses");
           System.out.println("3.SUGAMA "+reqdSugam.size()+" buses");
           System.out.println("Please Select one");*/


           choice=scan.nextInt();
          // System.out.println(choice);
         switch(choice)
         {
                 case 1:
               //  System.out.println("VRL");
                 //Display all details of VRL Buses on this route
                 while(i<reqdVrl.size())
                 {
                     Vrl obj1 = new Vrl();
                     obj1 = (Vrl)reqdVrl.get(i);
                     obj1.displayall();
                     i++;
                 }i=0;
                 break;

             case 2:
                // System.out.println("DURGAMBA");
                 //Display all details of DURGAMBA Buses on this route
                 while(i<reqdDurgam.size())
                 {
                     Durgamba obj2 = new Durgamba();
                     obj2 = reqdDurgam.get(i);
                     obj2.displayall();
                     i++;
                 }i=0;
                 break;
             case 3:
                     while(i<reqdSugam.size())
                 {
                     Sugama obj3 = new Sugama();
                     obj3 = (Sugama)reqdSugam.get(i);
                     obj3.displayall();
                     i++;
                 }i=0;

                 break;



      }
      }while(choice<=3);
uniqkey = searchuniqkey();
//System.out.println(uniqkey);
return uniqkey;
}
public static String searchuniqkey() throws FileNotFoundException, IOException, ClassNotFoundException
{
  String uniqkey;
  Scanner scan = new Scanner(System.in);
         FileInputStream f1 = new FileInputStream("VrlTesting.dat");
         ObjectInputStream objectinput1 = new ObjectInputStream(f1);
         ArrayList<Vrl> read1 = (ArrayList<Vrl>) objectinput1.readObject();
         objectinput1.close();
         FileInputStream f2 = new FileInputStream("SugamaTesting.dat");
         ObjectInputStream objectinput2 = new ObjectInputStream(f2);
         ArrayList<Sugama> read2 = (ArrayList<Sugama>) objectinput2.readObject();
         objectinput2.close();
         FileInputStream f3 = new FileInputStream("DurgambaTesting.dat");
         ObjectInputStream objectinput3 = new ObjectInputStream(f3);
         ArrayList<Durgamba> read3 = (ArrayList<Durgamba>) objectinput3.readObject();
         objectinput3.close();
        // System.out.println("enter the unique key of the bus you wish to travel in");
         uniqkey = scan.nextLine();
  int i = 0;
  for(i=0;i<read1.size();i++)
  {
    Vrl obj1 = new Vrl();
    obj1 = (Vrl)read1.get(i);
    if(obj1.key.equals(uniqkey))
    {
     return obj1.key;
    }
    
  }
  
  for(i=0;i<read2.size();i++)
  {  //System.out.println("entered sugama list");
     Sugama obj2 = new Sugama();
     obj2 = (Sugama)read2.get(i);
    if(obj2.key.equals(uniqkey))
    {
      return obj2.key;
    }
   
  }
 
  for(i=0;i<read3.size();i++)
  { //System.out.println("entered durgamba list");
    Durgamba obj3 = new Durgamba();
    obj3 = (Durgamba)read3.get(i);
    if(obj3.key.equals(uniqkey))
    {
     return obj3.key;
    }
    
  }
  
return null;
}

  
 public static int bookTicket(String key,int x,int y) throws FileNotFoundException, IOException, ClassNotFoundException
 {
         Scanner scan=new Scanner(System.in);
        // Page3 ob=new Page3();
        // System.out.println("Transfer passed");//customer details
         String name;
         String contactNo;
         String gender;
         String email;
         //int x,y;
         int i=0;
         int k=0;
         int j = 0;
         int l = 0;
         int flag = 0;
         int v=0,s=0,d=0;
         //files of buses
         FileInputStream f1 = new FileInputStream("VrlTesting.dat");
         ObjectInputStream objectinput1 = new ObjectInputStream(f1);
         ArrayList<Vrl> read1 = (ArrayList<Vrl>) objectinput1.readObject();
         objectinput1.close();
         FileInputStream f2 = new FileInputStream("SugamaTesting.dat");
         ObjectInputStream objectinput2 = new ObjectInputStream(f2);
         ArrayList<Sugama> read2 = (ArrayList<Sugama>) objectinput2.readObject();
         objectinput2.close();
         FileInputStream f3 = new FileInputStream("DurgambaTesting.dat");
         ObjectInputStream objectinput3 = new ObjectInputStream(f3);
         ArrayList<Durgamba> read3 = (ArrayList<Durgamba>) objectinput3.readObject();
         objectinput3.close();
         
             
                ArrayList<PassDtls> vcustList=new ArrayList();
                ArrayList<PassDtls> dcustList=new ArrayList();
                ArrayList<PassDtls> scustList=new ArrayList();
                PassDtls obj = new PassDtls();
               
                int flag1=0;
                int flag2=0;
         for(i=0;i<read1.size();i++)
         {   
             //Vrl obj1 = new Vrl();
             //obj1 = (Vrl)read1.get(i);
             if(read1.get(i).key.equals(key))
             {   
                //System.out.println("Choose your seat by selecting the row and column of your seat");
                //x = scan.nextInt();
                //y = scan.nextInt();
                
                //obj1.displayseatmatrix();
                    if(read1.get(i).seatmatrix[x][y]=='X')
                    {
                      read1.get(i).seatmatrix[x][y] = 'O';
                      obj.seatcol = y;
                      obj.seatrow = x;
                      obj.seat = ((x*read1.get(i).columns)+y+1); //Page3 ob=new Page3(obj)
                     // System.out.println("Your seat is "+obj.seat);
                     // Page3 ob=new Page3(obj);
                      flag1=1;
                      obj.rte=read1.get(i).key;
                      v=1;
                    }
                    else
                    {    
                    // System.out.println("Occupied book again");
                    }
               read1.get(i).displayseatmatrix();
                //vcustList.add(obj);
                break;
              } 
         }
                
        if(flag1==0)
        {    
           for(i=0;i<read3.size();i++)
         {   
            // Durgamba obj1 = new Durgamba();
             //obj1 = (Durgamba)read3.get(i);
             if(read3.get(i).key.equals(key))
             {   
                //System.out.println("Choose your seat by selecting the row and column of your seat");
                //x = scan.nextInt();
                //y = scan.nextInt();
                
                
                    if(read3.get(i).seatmatrix[x][y]=='X')
                    {
                      read3.get(i).seatmatrix[x][y] = 'O';
                      obj.seatcol = y;
                      obj.seatrow = x;
                      obj.seat = ((x*read3.get(i).columns)+y+1);
                      System.out.println("Your seat is "+obj.seat);
                      flag2=1;
                       obj.rte=read3.get(i).key;
                       d=1;
                    }
                    else
                    {    
                     System.out.println("Occupied book again");
                    }
                read3.get(i).displayseatmatrix();
                dcustList.add(obj);
                break;
              } 
         }
         if(flag2==0)
         {    
          for(i=0;i<read2.size();i++)
          {   
             //Sugama obj1 = new Sugama();
             //obj1 = (Sugama)read2.get(i);
             if(read2.get(i).key.equals(key))
             {   
                //System.out.println("Choose your seat by selecting the row and column of your seat");
                //x = scan.nextInt();
                //y = scan.nextInt();
                System.out.println("Entered the seatmatrix loop");
                
                    if(read2.get(i).seatmatrix[x][y]=='X')
                    {
                      read2.get(i).seatmatrix[x][y] = 'O';
                      obj.seatcol = y;
                      obj.seatrow = x;
                      obj.seat = ((x*read2.get(i).columns)+y+1);
                      System.out.println("Your seat is "+obj.seat);
                       obj.rte=read2.get(i).key;
                       s=1;
                    }
                    else
                    {    
                     System.out.println("Occupied book again");
                    }
                read2.get(i).displayseatmatrix();
                //scustList.add(obj);
                break;
              } 
         }
         }  
     }
        if(v==1)
        {
         OutputStream file = new FileOutputStream("VRLTesting.dat"); // 10/11/13-Removed the true
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);
        output.writeObject(read1);
        output.close();
        }
        else if(d==1)
        {
         OutputStream file1 = new FileOutputStream("DurgambaTesting.dat");
        OutputStream buffer1 = new BufferedOutputStream(file1);
        ObjectOutput output1 = new ObjectOutputStream(buffer1);
        output1.writeObject(read3);
        output1.close();   
        }
        else if(s==1)
        {
            OutputStream file2 = new FileOutputStream("SugamaTesting.dat");
        OutputStream buffer2 = new BufferedOutputStream(file2);
        ObjectOutput output2 = new ObjectOutputStream(buffer2);
        output2.writeObject(read2);
        output2.close();
            
        }
        return obj.seat;
     //   Page3 ob=new Page3(obj); //Pass passenger details to the Page
     
      
    
      }
  


     public static  int cancelTicket(String Key,int x,int y) throws FileNotFoundException, IOException, ClassNotFoundException
     {   
        // System.out.println("cancel ticket entered");
         //String Key;
         String seat;
         String bus;
         int i=0;
         int ret=0;
         int flag=0;
         //int x, y ;
         FileInputStream f1 = new FileInputStream("VrlTesting.dat");
         ObjectInputStream objectinput1 = new ObjectInputStream(f1);
         ArrayList<Vrl> read1 = (ArrayList<Vrl>) objectinput1.readObject();
         objectinput1.close();
         FileInputStream f2 = new FileInputStream("SugamaTesting.dat");
         ObjectInputStream objectinput2 = new ObjectInputStream(f2);
         ArrayList<Sugama> read2 = (ArrayList<Sugama>) objectinput2.readObject();
         objectinput2.close();
         FileInputStream f3 = new FileInputStream("DurgambaTesting.dat");
         ObjectInputStream objectinput3 = new ObjectInputStream(f3);
         ArrayList<Durgamba> read3 = (ArrayList<Durgamba>) objectinput3.readObject();
         objectinput3.close();
         Scanner in=new Scanner(System.in);
       //  System.out.println("Enter the unique key number");
         //Key=in.next();
       //  System.out.println("Key received is"+Key);   
         for(i = 0;i<read1.size();i++)
         {     
           Vrl obj1 = new Vrl();
           obj1 = (Vrl)read1.get(i);
           
           if(obj1.key.equals(Key))
           {
                // System.out.println("enter your seat row and seat column");
                /// x = in.nextInt();
                // y = in.nextInt();
                 if(obj1.seatmatrix[x][y]=='O')
                 {  // System.out.println("going to call vrl remove");
                     vrlpremove(x,y,Key);
                     return 3;
                 }
                  return 2;
            }
         }
         
         
           for(i = 0;i<read2.size();i++)
           {     
           Sugama obj2 = new Sugama();
           obj2 = (Sugama)read2.get(i);
           if(obj2.key.equals(Key))
           {
                // System.out.println("enter your seat row and seat column");
              //   x = in.nextInt();
               //  y = in.nextInt();
                 if(obj2.seatmatrix[x][y]=='O')
                 {
                     sugapremove(x,y,Key);
                     return 3;
                 }
                 return 2;  
             }
           }
         
        
       for(i = 0;i<read3.size();i++)
         {     
           Durgamba obj3 = new Durgamba();
           obj3 = (Durgamba)read3.get(i);
           if(obj3.key.equals(Key))
           {
               //  System.out.println("enter your seat row and seat column");
                // x = in.nextInt();
                // y = in.nextInt();
                 if(obj3.seatmatrix[x][y]=='O')
                 {
                     durpremove(x,y,Key);
                     return 3;
                 }
                 return 2;
           }
         }
         if(flag==0)
         {
             return 1;
         }
         return 0;
        
     }            
   
   public static void vrlpremove(int x,int y,String key ) throws IOException, ClassNotFoundException
   {   
       int i,j ;
       FileInputStream f1 = new FileInputStream("VrlPassenger.dat");
       ObjectInputStream objectinput1 = new ObjectInputStream(f1);
       ArrayList<PassDtls> read1 = (ArrayList<PassDtls>) objectinput1.readObject();
       objectinput1.close();
       FileInputStream f = new FileInputStream("VrlTesting.dat");
       ObjectInputStream objectinput = new ObjectInputStream(f);
         ArrayList<Vrl> read = (ArrayList<Vrl>) objectinput.readObject();
         objectinput1.close();
    //  System.out.println("ENTERED THE FUNCTION");
    //  System.out.println("Rows and colums are "+x +"\t" + y);
    //  System.out.println("Size of passenger and bus list are" +read1.size() + "\t"+ read.size());
    //  System.out.println(read1.get(0).seatcol + "\t"+ read1.get(0).seatrow + "\t" +read1.get(0).name);
      for(i = 0;i<read1.size();i++)
       { 
          PassDtls p = new PassDtls();       
          p = (PassDtls)read1.get(i);
          if(p.seatcol==y && p.seatrow==x)
          {   
              read1.remove(p);
            //  System.out.println("Found the guy");
              for(j = 0;j<read.size();j++)
              {
                Vrl Object = new Vrl();
                Object = read.get(j);
                if(Object.key.equals(key))
                {
                
                Object.seatmatrix[x][y]='X';
              //  System.out.println("Changed");
                break;
                }
                
              }
              
          }
       }
        OutputStream file1 = new FileOutputStream("VrlTesting.dat");
         OutputStream buffer1 = new BufferedOutputStream(file1);
         ObjectOutput output1 = new ObjectOutputStream(buffer1);
       output1.writeObject(read);
       output1.close();
              
              OutputStream filevrlp = new FileOutputStream("VrlPassenger.dat");
              OutputStream bufferv = new BufferedOutputStream(filevrlp);
              ObjectOutput outputvrlp = new ObjectOutputStream(bufferv);
              outputvrlp.writeObject(read1);
              outputvrlp.close();
        
       
  }
   public static void sugapremove(int x,int y,String key) throws FileNotFoundException, IOException, ClassNotFoundException
   {   int i,j ;
       FileInputStream f1 = new FileInputStream("SugamaPassenger.dat");
       ObjectInputStream objectinput1 = new ObjectInputStream(f1);
       ArrayList<PassDtls> read1 = (ArrayList<PassDtls>) objectinput1.readObject();
       objectinput1.close();
       FileInputStream f = new FileInputStream("SugamaTesting.dat");
       ObjectInputStream objectinput = new ObjectInputStream(f);
         ArrayList<Sugama> read = (ArrayList<Sugama>) objectinput.readObject();
         objectinput1.close();
         OutputStream file1 = new FileOutputStream("SugamaTesting.dat");
         OutputStream buffer1 = new BufferedOutputStream(file1);
         ObjectOutput output1 = new ObjectOutputStream(buffer1);
       for(i = 0;i<read1.size();i++)
       { 
          PassDtls p = new PassDtls();       
          p = (PassDtls)read1.get(i);
          if(p.seatcol==y&&p.seatrow==x)
          {   
              read1.remove(p);
              for(j = 0;j<read.size();j++)
              {
                Sugama Object = new Sugama();
                Object = read.get(j);
                if(Object.key.equals(key))
                {
                
                Object.seatmatrix[x][y]='X';
                break;
                }
                
              }
              
          }
       }
       
       output1.writeObject(read);
       output1.close();
              
              OutputStream filesugap = new FileOutputStream("SugamaPassenger.dat");
              OutputStream buffers = new BufferedOutputStream(filesugap);
              ObjectOutput outputsugap = new ObjectOutputStream(buffers);
              outputsugap.writeObject(read1);
              outputsugap.close();
        
       
       
   }
   public static void durpremove(int x,int y,String key) throws FileNotFoundException, IOException, ClassNotFoundException
   {   int i,j ;
       FileInputStream f1 = new FileInputStream("DurgambaPassenger.dat");
       ObjectInputStream objectinput1 = new ObjectInputStream(f1);
       ArrayList<PassDtls> read1 = (ArrayList<PassDtls>) objectinput1.readObject();
       objectinput1.close();
       FileInputStream f = new FileInputStream("DurgambaTesting.dat");
       ObjectInputStream objectinput = new ObjectInputStream(f);
         ArrayList<Durgamba> read = (ArrayList<Durgamba>) objectinput.readObject();
         objectinput1.close();
         OutputStream file1 = new FileOutputStream("DurgambaTesting.dat");
         OutputStream buffer1 = new BufferedOutputStream(file1);
         ObjectOutput output1 = new ObjectOutputStream(buffer1);
       for(i = 0;i<read1.size();i++)
       { 
          PassDtls p = new PassDtls();       
          p = (PassDtls)read1.get(i);
          if(p.seatcol==y&&p.seatrow==x)
          {   
              read1.remove(p);
              for(j = 0;j<read.size();j++)
              {
                Durgamba Object = new Durgamba();
                Object = read.get(j);
                if(Object.key.equals(key))
                {
                
                Object.seatmatrix[x][y]='X';
                break;
                }
                
              }
              
          }
       }
       
       output1.writeObject(read);
       output1.close();
              
              OutputStream filedurp = new FileOutputStream("DurgambaPassenger.dat");
              OutputStream bufferd = new BufferedOutputStream(filedurp);
              ObjectOutput outputdurp = new ObjectOutputStream(bufferd);
              outputdurp.writeObject(read1);
              outputdurp.close();
        
   }
}