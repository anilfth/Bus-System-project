
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.*;
import java.awt.GridBagConstraints;
import java.io.*;
import java.lang.String;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Page2 
{
    JFrame frame2;//=new JFrame("BUS DETAILS");
    JPanel windowContent=new JPanel();
    
    JButton rowNo=new JButton("ENTER ROW NO.");
    JButton colNo=new JButton("ENTER COLUMN NO.");
    
    JButton confirm=new JButton("Confirm");
    JButton show=new JButton("Seat Matrix");
    
    ButtonHandler listener=new ButtonHandler();//actionListener for confirm
    ButtonHandler2 listener2=new ButtonHandler2();//actionListener for showSeatMatrix
    
    ButtonHandler3 rowListener=new ButtonHandler3();
    ButtonHandler4 colListener=new ButtonHandler4();
    
    JLabel temp=new JLabel("ENTER ROUTE.No");
    JLabel temp2=new JLabel("ENTER SEAT No.");
    JLabel temp3=new JLabel("              ");
    
    JTextField inputArea=new JTextField();   // FOR ROUTE NUMBER
   // JTextField inputArea2=new JTextField();  // FOR SEAT NUMBER
    
    String rowno,colno;
    int X,Y;
       
    String svar1,dvar1;
    JButton back=new JButton("BACK");
    ButtonHandler5 listener3=new ButtonHandler5();
    //String svar1;
    //String dvar1;
    String date1;
  Page2(String svar,String dvar,String date) throws IOException, ClassNotFoundException
  {
      svar1=svar;
      dvar1=dvar;
      date1=date;
      Toolkit toolKit = Toolkit.getDefaultToolkit();
    //  System.out.println("SVAR IS- " +svar);
     // System.out.println("DVAR IS- " +dvar);
      java.awt.Dimension screenSize =
      toolKit.getScreenSize();
      X = screenSize.height;
      Y = screenSize.width;
      String check="Buses On "+svar+" -"+dvar;
      frame2=new JFrame(check);
     // frame2.setVisible(true);
      //frame2.setBounds(0,0,2*X,Y);
      //frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      confirm.addActionListener(listener);
      show.addActionListener(listener2);
      back.addActionListener(listener3);
       windowContent.setLayout(new GridLayout(0,8));
       FileInputStream f = new FileInputStream("VrlTesting.dat");
        ArrayList<Vrl> read;
        ObjectInputStream objectinput = new ObjectInputStream(f); 
        read = (ArrayList<Vrl>) objectinput.readObject();
        objectinput.close();
        FileInputStream f1 = new FileInputStream("DurgambaTesting.dat");
        ArrayList<Durgamba> read1;
        ObjectInputStream objectinput1 = new ObjectInputStream(f1); 
        read1 = (ArrayList<Durgamba>) objectinput1.readObject();
        objectinput1.close();
         FileInputStream f2 = new FileInputStream("SugamaTesting.dat");
        ArrayList<Sugama> read2;
        ObjectInputStream objectinput2 = new ObjectInputStream(f2); 
        read2 = (ArrayList<Sugama>) objectinput2.readObject();
        objectinput2.close();
        //System.out.println(read.size());
        //System.out.println(read1.size());
        //System.out.println(read2.size());
       
        rowNo.addActionListener(rowListener);
        colNo.addActionListener(colListener);
        
        JLabel tempCompany=new JLabel("COMPANY");
          tempCompany.setFont(new Font("Serif", Font.BOLD, 18));
          tempCompany.setForeground(Color.red);
          tempCompany.setBorder(BorderFactory.createLineBorder(Color.BLACK));
          windowContent.add(tempCompany);
          JLabel tempAmmenities=new JLabel("AMMENITIES");
          tempAmmenities.setFont(new Font("Serif", Font.BOLD, 18));
          tempAmmenities.setForeground(Color.red);
          tempAmmenities.setBorder(BorderFactory.createLineBorder(Color.BLACK));
          windowContent.add(tempAmmenities);
          
          JLabel tempRoute=new JLabel("ROUTE NUMBER");
          tempRoute.setFont(new Font("Serif", Font.BOLD, 18));
          tempRoute.setForeground(Color.red);
          tempRoute.setBorder(BorderFactory.createLineBorder(Color.BLACK));
          windowContent.add(tempRoute);
          JLabel tempType=new JLabel("TYPE");
          tempType.setFont(new Font("Serif", Font.BOLD, 18));
          tempType.setForeground(Color.red);
          tempType.setBorder(BorderFactory.createLineBorder(Color.BLACK));
          windowContent.add(tempType);
          JLabel tempPrice=new JLabel("PRICE"); // Change this
          tempPrice.setFont(new Font("Serif", Font.BOLD, 18));
          tempPrice.setForeground(Color.red);
          tempPrice.setBorder(BorderFactory.createLineBorder(Color.BLACK));
          windowContent.add(tempPrice);
          
          JLabel tempDate=new JLabel("DATE");
          tempDate.setFont(new Font("Serif", Font.BOLD, 18));
          tempDate.setForeground(Color.red);
          tempDate.setBorder(BorderFactory.createLineBorder(Color.BLACK));
          windowContent.add(tempDate);
          
          
          JLabel tempStrt=new JLabel("START TIME");
          tempStrt.setFont(new Font("Serif", Font.BOLD, 18));
          tempStrt.setForeground(Color.red);
          tempStrt.setBorder(BorderFactory.createLineBorder(Color.BLACK));
          windowContent.add(tempStrt);
          
          
          JLabel tempEnd=new JLabel("END TIME");
          tempEnd.setFont(new Font("Serif", Font.BOLD, 18));
          tempEnd.setForeground(Color.red);
          tempEnd.setBorder(BorderFactory.createLineBorder(Color.BLACK));
          windowContent.add(tempEnd);
          frame2.setIconImage(new ImageIcon("C:\\Rohit\\Java Stuff\\NetBeans\\busmodfinal\\bus.jpg").getImage());
          
          
      for(int i=0;i<read.size();i++)
      {
          
   
         if(svar.equals (read.get(i).source) && dvar.equals (read.get(i).destination))     
         {
          tempCompany=new JLabel("VRL");
          tempCompany.setBorder(BorderFactory.createLineBorder(Color.BLACK));
          windowContent.add(tempCompany);
          
          String ammenities;
          ammenities="CHARGING POINT";
          
          if(read.get(i).type.equals("AC SLEEPER"))
              ammenities="chargePoint&readLight";
          else if(read.get(i).type.equals("AC SEMI SLEEPER"))
              ammenities="chargePoint&readLight&TV";
          else if(read.get(i).type.equals("NON AC SLEEPER"))
              ammenities="chargePoint&TV";
          
          tempAmmenities=new JLabel(ammenities);
          tempAmmenities.setBorder(BorderFactory.createLineBorder(Color.BLACK));
          windowContent.add(tempAmmenities);
          
          tempRoute=new JLabel(read.get(i).key);
          tempRoute.setBorder(BorderFactory.createLineBorder(Color.BLACK));
          windowContent.add(tempRoute);
          tempType=new JLabel(read.get(i).type);
          tempType.setBorder(BorderFactory.createLineBorder(Color.BLACK));
          windowContent.add(tempType);
          Integer k=read.get(i).price;
          
          tempPrice=new JLabel(k.toString());
          tempPrice.setBorder(BorderFactory.createLineBorder(Color.BLACK));
          windowContent.add(tempPrice);
         
          tempDate=new JLabel(date);
         tempDate.setBorder(BorderFactory.createLineBorder(Color.BLACK));
          windowContent.add(tempDate);
         windowContent.add(rowNo);
         windowContent.add(colNo);
         
         tempStrt=new JLabel(read.get(i).starttime);
         tempStrt.setBorder(BorderFactory.createLineBorder(Color.BLACK));
         windowContent.add(tempStrt);
         
         tempEnd=new JLabel(read.get(i).endtime);
         tempEnd.setBorder(BorderFactory.createLineBorder(Color.BLACK));
         windowContent.add(tempEnd);
         
         } 
     }
     for(int i=0;i<read1.size();i++)
      {
   
         if(svar.equals (read1.get(i).source) &&dvar.equals (read1.get(i).destination))     
         {
          tempCompany=new JLabel("Durgamba");
          tempCompany.setBorder(BorderFactory.createLineBorder(Color.BLACK));
          windowContent.add(tempCompany);
          
          
          String ammenities;
          ammenities="CHARGING POINT";
          
          if(read1.get(i).type.equals("AC SLEEPER"))
              ammenities="chargePoint&readLight";
          else if(read1.get(i).type.equals("AC SEMI SLEEPER"))
              ammenities="chargePoint&readLight&TV";
          else if(read1.get(i).type.equals("NON AC SLEEPER"))
              ammenities="chargePoint&TV";
          
          tempAmmenities=new JLabel(ammenities);
          tempAmmenities.setBorder(BorderFactory.createLineBorder(Color.BLACK));
          windowContent.add(tempAmmenities);
          
          
          tempRoute=new JLabel(read1.get(i).key);
          tempRoute.setBorder(BorderFactory.createLineBorder(Color.BLACK));
          windowContent.add(tempRoute);
          
          
          tempType=new JLabel(read1.get(i).type);
          tempType.setBorder(BorderFactory.createLineBorder(Color.BLACK));
          windowContent.add(tempType);
          
          Integer k=read1.get(i).price;
          
          tempPrice=new JLabel(k.toString());
          tempPrice.setBorder(BorderFactory.createLineBorder(Color.BLACK));
          windowContent.add(tempPrice);
          
          
          tempDate=new JLabel(date);
          tempDate.setBorder(BorderFactory.createLineBorder(Color.BLACK));
          windowContent.add(tempDate);
          
          
         tempStrt=new JLabel(read1.get(i).starttime);
         tempStrt.setBorder(BorderFactory.createLineBorder(Color.BLACK));
         windowContent.add(tempStrt);
         
         tempEnd=new JLabel(read1.get(i).endtime);
         tempEnd.setBorder(BorderFactory.createLineBorder(Color.BLACK));
         windowContent.add(tempEnd);
         
         } 
     }
       for(int i=0;i<read2.size();i++)
      {
   
         if(svar.equals (read2.get(i).source) && dvar.equals (read2.get(i).destination))     
         {
          tempCompany=new JLabel("Sugama");
          tempCompany.setBorder(BorderFactory.createLineBorder(Color.BLACK));
          windowContent.add(tempCompany);
          
          String ammenities;
          ammenities="CHARGING POINT";
          
          if(read2.get(i).type.equals("AC SLEEPER"))
              ammenities="chargePoint&readLight";
          else if(read2.get(i).type.equals("AC SEMI SLEEPER"))
              ammenities="chargePoint&readLight";
          else if(read2.get(i).type.equals("NON AC SLEEPER"))
              ammenities="chargePoint";
          
          tempAmmenities=new JLabel(ammenities);
          tempAmmenities.setBorder(BorderFactory.createLineBorder(Color.BLACK));
          windowContent.add(tempAmmenities);
          
          
          tempRoute=new JLabel(read2.get(i).key);
          tempRoute.setBorder(BorderFactory.createLineBorder(Color.BLACK));
          windowContent.add(tempRoute);
          tempType=new JLabel(read2.get(i).type);
          tempType.setBorder(BorderFactory.createLineBorder(Color.BLACK));
          windowContent.add(tempType);
          
          
          Integer k=read2.get(i).price;
          
          tempPrice=new JLabel(k.toString());
          tempPrice.setBorder(BorderFactory.createLineBorder(Color.BLACK));
          windowContent.add(tempPrice);
          
          tempDate=new JLabel(date);
          tempDate.setBorder(BorderFactory.createLineBorder(Color.BLACK));
          windowContent.add(tempDate);
          
          
          
         tempStrt=new JLabel(read2.get(i).starttime);
         tempStrt.setBorder(BorderFactory.createLineBorder(Color.BLACK));
         windowContent.add(tempStrt);
         
         tempEnd=new JLabel(read2.get(i).endtime);
         tempEnd.setBorder(BorderFactory.createLineBorder(Color.BLACK));
         windowContent.add(tempEnd);
         
         } 
     }
      
      //date,
      
       windowContent.add(back);
       windowContent.add(temp);
       windowContent.add(inputArea);
       windowContent.add(temp3);
       //windowContent.add(temp3);
       windowContent.add(show);
      // windowContent.add(temp3);
//       windowContent.add(temp2);
      // windowContent.add(temp3);
     //  windowContent.add(inputArea2);
       //windowContent.add(temp3);
       windowContent.add(rowNo);
       windowContent.add(colNo);
       windowContent.add(confirm);
       
       frame2.setContentPane(windowContent);
       frame2.setVisible(true);
       frame2.setBounds(0,0,X,Y);
       frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      
  
   
  
}
  
   private class ButtonHandler2 implements ActionListener
       {
           @Override
          public void actionPerformed(ActionEvent e)
           {
             //int i=0;
             //JOptionPane.showMessageDialog(windowContent,"Hey","SEAT MATRIX",JOptionPane.PLAIN_MESSAGE);
               
               FileInputStream f = null;
               try {
                   f = new FileInputStream("VrlTesting.dat");
               } catch (FileNotFoundException ex) {
                   Logger.getLogger(Page2.class.getName()).log(Level.SEVERE, null, ex);
               }
        ArrayList<Vrl> read = null;
        ObjectInputStream objectinput = null; 
               try {
                   objectinput = new ObjectInputStream(f);
               } catch (IOException ex) {
                   Logger.getLogger(Page2.class.getName()).log(Level.SEVERE, null, ex);
               }
               try {
                   read = (ArrayList<Vrl>) objectinput.readObject();
               } catch (IOException ex) {
                   Logger.getLogger(Page2.class.getName()).log(Level.SEVERE, null, ex);
               } catch (ClassNotFoundException ex) {
                   Logger.getLogger(Page2.class.getName()).log(Level.SEVERE, null, ex);
               }
               try {
                   objectinput.close();
               } catch (IOException ex) {
                   Logger.getLogger(Page2.class.getName()).log(Level.SEVERE, null, ex);
               }
        FileInputStream f1 = null;
               try {
                   f1 = new FileInputStream("DurgambaTesting.dat");
               } catch (FileNotFoundException ex) {
                   Logger.getLogger(Page2.class.getName()).log(Level.SEVERE, null, ex);
               }
        ArrayList<Durgamba> read1 = null;
        ObjectInputStream objectinput1 = null; 
               try {
                   objectinput1 = new ObjectInputStream(f1);
               } catch (IOException ex) {
                   Logger.getLogger(Page2.class.getName()).log(Level.SEVERE, null, ex);
               }
               try {
                   read1 = (ArrayList<Durgamba>) objectinput1.readObject();
               } catch (IOException ex) {
                   Logger.getLogger(Page2.class.getName()).log(Level.SEVERE, null, ex);
               } catch (ClassNotFoundException ex) {
                   Logger.getLogger(Page2.class.getName()).log(Level.SEVERE, null, ex);
               }
               try {
                   objectinput1.close();
               } catch (IOException ex) {
                   Logger.getLogger(Page2.class.getName()).log(Level.SEVERE, null, ex);
               }
         FileInputStream f2 = null;
               try {
                   f2 = new FileInputStream("SugamaTesting.dat");
               } catch (FileNotFoundException ex) {
                   Logger.getLogger(Page2.class.getName()).log(Level.SEVERE, null, ex);
               }
        ArrayList<Sugama> read2 = null;
        ObjectInputStream objectinput2 = null; 
               try {
                   objectinput2 = new ObjectInputStream(f2);
               } catch (IOException ex) {
                   Logger.getLogger(Page2.class.getName()).log(Level.SEVERE, null, ex);
               }
               try {
                   read2 = (ArrayList<Sugama>) objectinput2.readObject();
               } catch (IOException ex) {
                   Logger.getLogger(Page2.class.getName()).log(Level.SEVERE, null, ex);
               } catch (ClassNotFoundException ex) {
                   Logger.getLogger(Page2.class.getName()).log(Level.SEVERE, null, ex);
               }
               try {
                   objectinput2.close();
               } catch (IOException ex) {
                   Logger.getLogger(Page2.class.getName()).log(Level.SEVERE, null, ex);
               }
               
               
               
               String key=inputArea.getText();
               
               char[][] seat;
              
               String work="";
               for(int i=0;i<read.size();i++)
               {
                   if(read.get(i).key.equalsIgnoreCase(key))
                   {
                       seat=read.get(i).seatmatrix;
                       //System.out.println("WORKING");
                       for(int k=0;k<read.get(i).rows;k++)
                       {
                           for(int j=0;j<read.get(i).columns;j++)
                           {
                               work=work+seat[k][j]+" ";
                              
                           }
                           //System.out.println("\n");
                           work=work+"\n";
                       }
                   }
               }
          
               for(int i=0;i<read1.size();i++)
               {
                   if(read1.get(i).key.equalsIgnoreCase(key))
                   {
                       seat=read1.get(i).seatmatrix;
                       
                       for(int k=0;k<read1.get(i).rows;k++)
                       {
                           for(int j=0;j<read1.get(i).columns;j++)
                          work=work+seat[k][j]+" ";
                           work=work+"\n";
                       }
                   }
               }
               
               
               for(int i=0;i<read2.size();i++)
               {
                   if(read2.get(i).key.equalsIgnoreCase(key))
                   {
                       seat=read2.get(i).seatmatrix;
                       
                       for(int k=0;k<read2.get(i).rows;k++)
                       {
                           for(int j=0;j<read2.get(i).columns;j++)
                           work=work+seat[k][j]+" ";
                           work=work+"\n";
                       }
                      
                   }
               }
               
               JOptionPane.showMessageDialog(windowContent,work+"\n"+"X=>FREE,O=>OCCUPIED","SEAT MATRIX", JOptionPane.PLAIN_MESSAGE);
             
               
               //seatMatrix ob=new seatMatrix(seat);
              // g=ob.getGraphics();
              // ob.paint(g);
               
               
           }
       }


      private class ButtonHandler3 implements ActionListener
       {
           @Override
          public void actionPerformed(ActionEvent e)
           {
             try
             { 
                 while(true)
               {
                 rowno=(String)JOptionPane.showInputDialog(windowContent,"ENTER THE ROW NO.(0-3) ","INPUT ROW", JOptionPane.QUESTION_MESSAGE);
                 
                 int i=Integer.parseInt(rowno);
                 
                 if(i>3||i<0)
                 {
                     JOptionPane.showMessageDialog(windowContent,"PLEASE INPUT NO.S IN THE RANGE 0-3");
                     continue;
                 }
                 else
                     break;
               }
             
             }catch(NumberFormatException e1)
             {
                    JOptionPane.showMessageDialog(windowContent,"Invalid Entry");
             }
           }
       }

   private class ButtonHandler4 implements ActionListener
       {
           @Override
          public void actionPerformed(ActionEvent e)
           {
             try
             {
                 while(true)
               {
                 colno=(String)JOptionPane.showInputDialog(windowContent,"ENTER THE COLUMN NO.(0-9) ","INPUT ROW", JOptionPane.QUESTION_MESSAGE);
                 
                 int i=Integer.parseInt(colno);
                 
                 if(i>9||i<0)
                 {
                     JOptionPane.showMessageDialog(windowContent,"PLEASE INPUT NO.S IN THE RANGE 0-9");
                     continue;
                 }
                 else
                     break;
               }
             
             
             }catch(NumberFormatException e1)
             {
                    JOptionPane.showMessageDialog(windowContent,"Invalid Entry");
             }
           }    
       }

   
  private class ButtonHandler  implements ActionListener
  {
           @Override
          public void actionPerformed(ActionEvent e) 
           {
             String s1=inputArea.getText(); // for route number
       //      String s2=inputArea2.getText();
           //  System.out.println("The values taken are " + s1);
               try 
               {
                    Scanner scan=new Scanner(System.in);
        // Page3 ob=new Page3();
         //System.out.println("Transfer passed");//customer details
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
         Boolean ischanged=false;      
                int flag1=0;
                int flag2=0;
               
         for(i=0;i<read1.size();i++)
         {   
             
             Vrl obj1 = new Vrl();
             obj1 = (Vrl)read1.get(i);
             if(obj1.key.equals(s1))
             {   
                 if(!((obj1.source.equals(svar1))&&(obj1.destination.equals(dvar1))))
                 {
                    JOptionPane.showMessageDialog(windowContent,"BUS NOT PRESENT ON THIS ROUTE","ERROR",JOptionPane.ERROR_MESSAGE);
                     return;
                 }
                //System.out.println("Entered the seatmatrix loop");
             //    while(ischanged==false)
            //{     
                    if(obj1.seatmatrix[Integer.parseInt(rowno)][Integer.parseInt(colno)]=='X')
                    {
                      
                      ischanged=true;
                      //f1(s1,s2);
                      
                      //System.out.println("Your seat is "+obj.seat);
                      
                    }
                    else
                    {    
                     //System.out.println("Occupied book again");
                      JOptionPane.showMessageDialog(windowContent,"Occupied Book Again","ERROR",JOptionPane.ERROR_MESSAGE);
                    }                
                 //if(ischanged==true)
                   //  f1(s1,s2);
              //}
             // break;   
           }
      }          
        if(flag1==0)
        {    
           for(i=0;i<read3.size();i++)
         {   
            
             Durgamba obj1 = new Durgamba();
             obj1 = (Durgamba)read3.get(i);
             if(obj1.key.equals(s1))
             {      
              //  while(ischanged==false)
               //{
                   if(!((obj1.source.equals(svar1))&&(obj1.destination.equals(dvar1))))
                 {
                     JOptionPane.showMessageDialog(windowContent,"BUS NOT PRESENT ON THIS ROUTE","ERROR",JOptionPane.ERROR_MESSAGE);
                     return;
                 }
                 
                    if(obj1.seatmatrix[Integer.parseInt(rowno)][Integer.parseInt(colno)]=='X')
                    {
                      
                      ischanged=true;
                    //  f1(s1,s2);
                      
                      //System.out.println("Your seat is "+obj.seat);
                      
                    }
                    else
                    {    
                     System.out.println("Occupied book again");
                      JOptionPane.showMessageDialog(windowContent,"Occupied Book Again","ERROR",JOptionPane.ERROR_MESSAGE);
                    }                
              // }
            // if(ischanged==true)
              //       f1(s1,s2);
              //break;  
              } 
           
       }
         if(flag2==0)
         {    
          for(i=0;i<read2.size();i++)
          {  
            
             Sugama obj1 = new Sugama();
             obj1 = (Sugama)read2.get(i);
             if(obj1.key.equals(s1))
             {   
                if(!((obj1.source.equals(svar1))&&(obj1.destination.equals(dvar1))))
                 {
                     JOptionPane.showMessageDialog(windowContent,"BUS NOT PRESENT ON THIS ROUTE","ERROR",JOptionPane.ERROR_MESSAGE);
                     return;
                 }
                 
                //System.out.println("Entered the seatmatrix loop");
               //  while(ischanged==false)
            //{     
                    if(obj1.seatmatrix[Integer.parseInt(rowno)][Integer.parseInt(colno)]=='X')
                    {
                      
                    ischanged=true;
                  //    f1(s1,s2);
                      
                      //System.out.println("Your seat is "+obj.seat);
                      
                    }
                    else
                    {    
                   //  System.out.println("Occupied book again");
                      JOptionPane.showMessageDialog(windowContent,"Occupied Book Again","ERROR",JOptionPane.ERROR_MESSAGE);
                    }                
                
              //}
              //if(ischanged==true)
                     //f1(s1,s2);
                    //break;   
           }             //END OF IF
         
          }
         } //END OF IF  
      if(ischanged==true)
      {
           f1(s1);
           
         
        }
        }
      
      
        
                     
               } catch (IOException ex) {
                   Logger.getLogger(Page2.class.getName()).log(Level.SEVERE, null, ex);
               } catch (ClassNotFoundException ex) {
                   Logger.getLogger(Page2.class.getName()).log(Level.SEVERE, null, ex);
               }
               catch(NullPointerException ex)
               {
                JOptionPane.showMessageDialog(windowContent,"Invalid Entry");
               }
               catch(NumberFormatException e2)
               {
                   JOptionPane.showMessageDialog(windowContent,"Invalid Entry");
               }
             //Page3 ob=new Page3();       
           //    System.out.println("Sup");
           //   frame2.dispose();   
           }
           void f1(String rno) throws IOException, ClassNotFoundException
           {
              //rno=uniqkey
              // System.out.println("Printing to the screen");
              // System.out.println("Route is" +rno);
               FileInputStream f = new FileInputStream("VrlTesting.dat");
               ArrayList<Vrl> read;
               ObjectInputStream objectinput = new ObjectInputStream(f); 
               read = (ArrayList<Vrl>) objectinput.readObject();
               objectinput.close();
               FileInputStream f1 = new FileInputStream("DurgambaTesting.dat");
               ArrayList<Durgamba> read1;
               ObjectInputStream objectinput1 = new ObjectInputStream(f1); 
               read1 = (ArrayList<Durgamba>) objectinput1.readObject();
               objectinput1.close();
               FileInputStream f2 = new FileInputStream("SugamaTesting.dat");
               ArrayList<Sugama> read2;
               ObjectInputStream objectinput2 = new ObjectInputStream(f2); 
               read2 = (ArrayList<Sugama>) objectinput2.readObject();
               objectinput2.close();
              // BusMod.bookTicket("hey");
               int i=0;
               int flag=0,flag1=0;
               for(i=0;i<read.size();i++)
               {
               //    System.out.println("Entered the loop");
                   if(rno.equals(read.get(i).key))
                   {
                       //BusMod.bookTicket(rno,Integer.parseInt(rowno),Integer.parseInt(colno));
                       Page3 ob=new Page3(rno,Integer.parseInt(rowno),Integer.parseInt(colno),svar1,dvar1,date1);
                        frame2.dispose(); 
                       flag=1;
                       break;
                   }
               }
              if(flag==0)
              {    
               for(i=0;i<read1.size();i++)
               {
                 //  System.out.println("Entered the Durgamba loop");
                   if(rno.equals(read1.get(i).key))
                   {
                   //    System.out.println("Working!!!");
                       flag1=1;
                    // BusMod.bookTicket(rno,Integer.parseInt(rowno),Integer.parseInt(colno));
                      Page3 ob=new Page3(rno,Integer.parseInt(rowno),Integer.parseInt(colno),svar1,dvar1,date1);
                       frame2.dispose();  
                      break; 
                   }
               }
              if(flag1==0) 
              {
                  for(i=0;i<read2.size();i++)
               {
                   //System.out.println("Entered the Sugama loop");
                   if(rno.equals(read2.get(i).key))
                   {
                     //  System.out.println("Working!!!");
                     //BusMod.bookTicket(rno,Integer.parseInt(rowno),Integer.parseInt(colno));
                       Page3 ob=new Page3(rno,Integer.parseInt(rowno),Integer.parseInt(colno),svar1,dvar1,date1);
                       frame2.dispose(); 
                       break;
                   }
               }
              }    
              }  
           }
           
       }
  
     private class ButtonHandler5 implements ActionListener
    {
       // String newSelection;
        @Override
        public void actionPerformed(ActionEvent e) 
        {
          Main ob=new Main();
          frame2.dispose();
         
        }
        
      
    }
  
/* public static void main(String[] args)
    {
        //Page2 obj=new Page2();
        System.out.println("Hello");//Page2 ob=new Page2();  // TODO code application logic here
    }*/
}
