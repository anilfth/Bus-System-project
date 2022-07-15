import java.io.*;
import java.util.ArrayList;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.*;
import java.awt.GridBagConstraints;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingConstants;

class addBus {
    
    JFrame frame;
    JPanel windowContent=new JPanel();
    char[][] seatStruct=new char[10][10];
    int X,Y;
    
    JButton type=new JButton("Enter Bus Type");
   
    TypeHandler typeListener=new TypeHandler();
    String inputType;
    JButton sorc=new JButton("ADD THE SOURCE");
    srcHandler srcListener=new srcHandler();
    String src;
    
    JButton des=new JButton("ADD THE DESTINATION");
    destHandler destListener=new destHandler();
    String dest;
    
    JButton pric=new JButton("Enter the price");
    priceHandler priceListener=new priceHandler();
    String price;
    
    JButton strt=new JButton("Enter the Start Time");
    strtHandler strtListener=new strtHandler();
    String start;
    
    JButton end=new JButton("Enter the End Time");
    endHandler endListener=new endHandler();
    String etime;
    String rtNo;
    
    
   JLabel route=new JLabel("Enter Route No.");
    JTextField inputRt=new JTextField(10);
    JLabel uniq=new JLabel("Enter Unique Key");
    JTextField inputUniq=new JTextField(10);
    JButton rows=new JButton("ENTER THE NO. OF ROW");
    rowHandler rowListener=new rowHandler();
    String row;
    JButton columns=new JButton("ENTER THE NO. OF COLUMNS ");
    colHandler colListener=new colHandler();
    String column;
    
    
    JButton confirm=new JButton("CONFIRM");
    addBus.ButtonHandler listener=new addBus.ButtonHandler();
    JButton backbut = new JButton("Back");
    BackHandler1 butlistener = new BackHandler1();
    
    addBus(String company){
      
      frame=new JFrame("ADD A "+company+" BUS");  
      Toolkit toolKit = Toolkit.getDefaultToolkit();
      java.awt.Dimension screenSize =
      toolKit.getScreenSize();
      X = screenSize.height;
      Y = screenSize.width;
      frame.setVisible(true);
      frame.setSize(X,Y);
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       frame.setIconImage(new ImageIcon("C:\\Rohit\\Java Stuff\\NetBeans\\busmodfinal\\bus.jpg").getImage());
      
      des.addActionListener(destListener);
      sorc.addActionListener(srcListener);
      pric.addActionListener(priceListener);
      strt.addActionListener(strtListener);
      end.addActionListener(endListener);
      rows.addActionListener(rowListener);
      columns.addActionListener(colListener);
      backbut.addActionListener(butlistener);
      
      confirm.addActionListener(listener);
      
      
       for(int i = 0;i<10;i++)
      {
          for(int j = 0;j<10;j++)
          {
            seatStruct[i][j] = 'X';//adding seats 
          }
      }
      
      windowContent.setLayout(new GridLayout(0,1));
      inputRt.setMaximumSize(new Dimension(250,20));
      inputUniq.setMaximumSize(new Dimension(250,20));
     
      windowContent.add(type);
      type.addActionListener(typeListener);
      
      windowContent.add(sorc);
      windowContent.add(des);
     windowContent.add(pric);
    
      windowContent.add(strt);
     // windowContent.add(inputStrt);
      windowContent.add(end);
    //  windowContent.add(inputEnd);
      windowContent.add(route);
      windowContent.add(inputRt);
      windowContent.add(rows);
     // windowContent.add(inputrow);
     //windowContent.add(Box.createRigidArea(new Dimension(250,50)));
      windowContent.add(columns);
     
     //windowContent.add(inputcolumn);
      windowContent.add(confirm);
      windowContent.add(backbut);
      
       frame.setContentPane(windowContent);
       frame.setVisible(true);
        frame.setBounds(0,0,2*X,Y);
       frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       
    }
    
     private class TypeHandler implements ActionListener
       {
           @Override
          public void actionPerformed(ActionEvent e)
           {
               String[] options={"AC SLEEPER","AC SEMI SLEEPER","NON AC SLEEPER","AC"};
               inputType=(String)JOptionPane.showInputDialog(windowContent,
"Choose One", "Input",
JOptionPane.INFORMATION_MESSAGE, null,
options, options[0]);
           }
       }
    
     
     private class rowHandler implements ActionListener
       {
           @Override
          public void actionPerformed(ActionEvent e)
           {
               String[] options={"1","2","3"};
               row=(String)JOptionPane.showInputDialog(windowContent,
"Choose One", "Input",
JOptionPane.INFORMATION_MESSAGE, null,
options, options[0]);
           }
       }
     
     
     private class colHandler implements ActionListener
       {
           @Override
          public void actionPerformed(ActionEvent e)
           {
               String[] options={"1","2","3","4","5","6","7","8","9"};
               column=(String)JOptionPane.showInputDialog(windowContent,
"Choose One", "Input",
JOptionPane.INFORMATION_MESSAGE, null,
options, options[0]);
           }
       }
     
     
     private class strtHandler implements ActionListener
       {
           @Override
          public void actionPerformed(ActionEvent e)
           {
               String[] options={"00:00","00:30","01:00","01:30","02:00","02:30","03:00","03:30","04:00","04:30","05:00","05:30","06:00","06:30","07:00","07:30","08:00","08:30","09:00","09:30","18:00","18:30","19:00","19:30","20:00","20:30","21:00","21:30","22:00","22:30","23:00","23:30"};
               start=(String)JOptionPane.showInputDialog(windowContent,
"Choose One", "Input",
JOptionPane.INFORMATION_MESSAGE, null,
options, options[0]);
           }
       }
     
     
     private class endHandler implements ActionListener
       {
           @Override
          public void actionPerformed(ActionEvent e)
           {
               String[] options={"00:00","00:30","01:00","01:30","02:00","02:30","03:00","03:30","04:00","04:30","05:00","05:30","06:00","06:30","07:00","07:30","08:00","08:30","09:00","09:30","18:00","18:30","19:00","19:30","20:00","20:30","21:00","21:30","22:00","22:30","23:00","23:30"};
              etime=(String)JOptionPane.showInputDialog(windowContent,
"Choose One", "Input",
JOptionPane.INFORMATION_MESSAGE, null,
options, options[0]);
           }
       }
     private class srcHandler implements ActionListener
       {
           @Override
          public void actionPerformed(ActionEvent e)
           {
               String[] options={"Bangalore","Chennai","Kochi","Hyderabad","Manipal"};
               src=(String)JOptionPane.showInputDialog(windowContent,
"Choose One", "Input",
JOptionPane.INFORMATION_MESSAGE, null,
options, options[0]);
           }
       }
     
      private class priceHandler implements ActionListener
       {
           @Override
          public void actionPerformed(ActionEvent e)
           {
               String[] options={"250","300","350","400","450","500","550","600","650","700","750","800","850","900"};
               price=(String)JOptionPane.showInputDialog(windowContent,
"Choose One", "Input",
JOptionPane.INFORMATION_MESSAGE, null,
options, options[0]);
           }
       }
    
     
     private class destHandler implements ActionListener
       {
           @Override
          public void actionPerformed(ActionEvent e)
           {
               String[] options={"Chennai","Bangalore","Kochi","Hyderabad","Manipal"};
               dest=(String)JOptionPane.showInputDialog(windowContent,
"Choose One", "Input",
JOptionPane.INFORMATION_MESSAGE, null,
options, options[0]);
           }
       }
       private class BackHandler1 implements ActionListener
    {
       // String newSelection;
        @Override
        public void actionPerformed(ActionEvent e) 
        {
           Main ob=new Main();
          frame.dispose();
         
        }
        
      
    }  
    
     private class ButtonHandler implements ActionListener
       {
           @Override
          public void actionPerformed(ActionEvent e)
           {
               String type=inputType;
               int p=0;
               try{
                   
                    rtNo=inputRt.getText();
                   
               }
               catch(NullPointerException w){
                   JOptionPane.showMessageDialog(windowContent,"PLEASE ENTER ROUTE NO. STARTING WITH THE LETTERS 'V' or 'S' or 'D'");
               }
               if(rtNo.charAt(0)=='V')
               {
              Vrl ob=new Vrl();
              ob.destinationchange(dest);
              ob.pricechange(Integer.parseInt(price));
              ob.sourcechange(src);
              ob.typechange(type);
              ob.starttimechange(start);
              ob.endtimechange(etime);
              ob.routechange(rtNo);
              ob.key=rtNo;
              ob.rows=Integer.parseInt(row);
              ob.columns=Integer.parseInt(column);
              //ob.seatmatrix=seatStruct;
             ob.createseatmatrix(ob.rows,ob.columns);
              p=1;
              
               try {
                   listener.addtryVrl(ob);
               } catch (IOException ex) {
                   Logger.getLogger(addBus.class.getName()).log(Level.SEVERE, null, ex);
               } catch (ClassNotFoundException ex) {
                   Logger.getLogger(addBus.class.getName()).log(Level.SEVERE, null, ex);
               }
                    }
    
              if(rtNo.charAt(0)=='D'){
              Durgamba ob=new Durgamba();
              ob.destinationchange(dest);
              ob.pricechange(Integer.parseInt(price));
              ob.sourcechange(src);
              ob.typechange(type);
              ob.starttimechange(start);
              ob.endtimechange(etime);
              ob.routechange(rtNo);
              ob.key=rtNo;
              ob.rows=Integer.parseInt(row);
              ob.columns=Integer.parseInt(column);
             ob.createseatmatrix(ob.rows,ob.columns);
              p=1;
             // ob.seatmatrix=seatStruct;
//              ob.createseatmatrix(rows,columns);
               try {
                   listener.addtryDur(ob);
               } catch (IOException ex) {
                   Logger.getLogger(addBus.class.getName()).log(Level.SEVERE, null, ex);
               } catch (ClassNotFoundException ex) {
                   Logger.getLogger(addBus.class.getName()).log(Level.SEVERE, null, ex);
               }
                    }
               
               
              if(rtNo.charAt(0)=='S'){
              Sugama ob=new Sugama();
              ob.destinationchange(dest);
              ob.pricechange(Integer.parseInt(price));
              ob.sourcechange(src);
              ob.typechange(type);
//              ob.starttimechange(strt);
  //            ob.endtimechange(end);
              ob.routechange(rtNo);
              ob.key=rtNo;
              
              ob.rows=Integer.parseInt(row);
              ob.columns=Integer.parseInt(column);
//             ob.createseatmatrix(rows,columns);
              p=1;
               try {
                   listener.addtrySug(ob);
               } catch (IOException ex) {
                   Logger.getLogger(addBus.class.getName()).log(Level.SEVERE, null, ex);
               } catch (ClassNotFoundException ex) {
                   Logger.getLogger(addBus.class.getName()).log(Level.SEVERE, null, ex);
               }
                    }
             if(p==1)
             {    
              JOptionPane.showMessageDialog(windowContent,"THE BUS HAS BEEN ADDED");
              Main ob=new Main();
               frame.dispose();
             }
            
             else
             {
                  JOptionPane.showMessageDialog(windowContent,"ENTER ROUTE STARTING WITH V/D/S");
             }
           }
     
     public void addtryVrl(Vrl ob) throws IOException, ClassNotFoundException
    {
       
        ArrayList<Vrl> vrltemp = new ArrayList();       
        Vrl obj1 = new Vrl();
        Scanner scan = new Scanner(System.in);
        int i;
        int choice;
        boolean eof =false;

              Vrl obj = new Vrl();
              FileInputStream f = new FileInputStream("VrlTesting.dat");
              ObjectInputStream objectinput = new ObjectInputStream(f);
              ArrayList<Vrl> read = (ArrayList<Vrl>) objectinput.readObject();
              objectinput.close();
             // obj.adddetails();
              read.add(ob);
              
              OutputStream file = new FileOutputStream("VrlTesting.dat");
              OutputStream buffer = new BufferedOutputStream(file);
              ObjectOutput output = new ObjectOutputStream(buffer);
             
              output.writeObject(read);
              
              output.close();
             
    }

          public void addtryDur(Durgamba ob) throws IOException, ClassNotFoundException
    {
       
        ArrayList<Durgamba> vrltemp = new ArrayList();       
        Durgamba obj1 = new Durgamba();
        
                     
              Durgamba obj = new Durgamba();
              FileInputStream f = new FileInputStream("DurgambaTesting.dat");
              ObjectInputStream objectinput = new ObjectInputStream(f);
              ArrayList<Durgamba> read = (ArrayList<Durgamba>) objectinput.readObject();
              objectinput.close();
        //      obj.adddetails();
              read.add(ob);
              
              OutputStream file = new FileOutputStream("DurgambaTesting.dat");
              OutputStream buffer = new BufferedOutputStream(file);
              ObjectOutput output = new ObjectOutputStream(buffer);
             
              output.writeObject(read);
              
              output.close();

    }
          
          public void addtrySug(Sugama ob) throws IOException,EOFException, ClassNotFoundException
    {

        Sugama obj1 = new Sugama();
        Scanner scan = new Scanner(System.in);
        int i;
        int choice;
        int count = 0;

             Sugama obj = new Sugama();
              FileInputStream f = new FileInputStream("SugamaTesting.dat");
              ObjectInputStream objectinput = new ObjectInputStream(f);
              ArrayList<Sugama> read = (ArrayList<Sugama>) objectinput.readObject();
              objectinput.close();
              //obj.adddetails();
              read.add(ob);
              
              OutputStream file = new FileOutputStream("SugamaTesting.dat");
              OutputStream buffer = new BufferedOutputStream(file);
              ObjectOutput output = new ObjectOutputStream(buffer);
             
              output.writeObject(read);
              
              output.close();
          
}
     }
     
    

    
     public static void main(String[] args){
         addBus ob=new addBus("VRL");
     }
    

}
