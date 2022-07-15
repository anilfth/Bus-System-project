/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JHON
 */
import java.awt.Container;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicComboBoxUI;

public class Main extends JFrame
{
    
    /**
     * @param args the command line arguments
     */
    String svar; // Variable to record the source data
    String dvar; //Variable to record the destination data
    
    JTextField inputDate=new JTextField("ENTER DATE IN DD-MM-YYYY",20);   //TO INPUT DATE
    
    JButton confirm=new JButton("Book Ticket");
    JButton cancel=new JButton("Cancel Ticket");
    JButton admin=new JButton("Login as Admin");
    JLabel lab=new JLabel("*********************************************************************************************************************************************WELCOME*********************************************************************************************************************************************");
     //JLabel lab=new JLabel("WELCOME");
    Choice ch=new Choice();
    JLabel l1=new JLabel("Source");
    JLabel l2=new JLabel("Destination");
    Choice ch2=new Choice();
    JPanel windowContent;
    ButtonHandler listener=new ButtonHandler();
    ButtonHandler1 listener4=new ButtonHandler1();
    ButtonHandler2 listener5=new ButtonHandler2();
    //Combo listener1=new Combo();
    
    
    String date;
    JFrame frame=new JFrame("Welcome Page");
    JComboBox patternList;//SOURCE
    Combo listener1=new Combo(); // For the Jcombox1,i.e Source  
    JComboBox list2; //DESTINATION
    Combo1 listener2=new Combo1(); // For the Jcombox1,i.e Destination
    JPanel j1 = new JPanel();
    JPanel j2 = new JPanel();
    JPanel j3 = new JPanel();
    JPanel j4 = new JPanel();
    JComboBox dateList;//DATE
    Combo2 listener3=new Combo2();//For the JComboBox2,i.e.date
    
    
    
    Main()
    {
       int X,Y;
       Point p;
      
       Toolkit toolKit = Toolkit.getDefaultToolkit();
       java.awt.Dimension screenSize = toolKit.getScreenSize();
       toolKit.getScreenSize();
       X = screenSize.height;//set size of window
       Y = screenSize.width;
       frame.getMaximizedBounds();
       
       confirm.addActionListener(listener);
       cancel.addActionListener(listener4);
       admin.addActionListener(listener5);
       lab.setBounds(0,0,X,Y);
       windowContent=new JPanel();
       windowContent.setLayout(new FlowLayout());
       j1.setLayout(new FlowLayout()); 
       j2.setLayout(new FlowLayout()); 
            lab.setForeground(Color.red);
            lab.setFont(new Font("Serif", Font.BOLD, 18));
          
          windowContent.add(lab);
          //windowContent.add(l1);
          j2.add(l1);
        lab.setBounds(X,100,20,20);
        lab.setBounds(600,10,80,80);
     
        windowContent.add(l2);
      //  l2.setBounds(0,10,20,20);
        //FOR THE JCOMBO BOX(source)
         String[] patternExamples = {
                 "Bangalore",
                 "Chennai",
                 "Hyderabad",
                 "Kochi",
                 "Manipal"
                 };
         svar=patternExamples[0];
          patternList = new JComboBox(patternExamples);
          patternList.setEditable(true);
          patternList.addActionListener(listener1); 
         // For the second JCOMBO BOX,destination
         String[] patternExamples1 = {
                 "Bangalore",
                 "Chennai",
                 "Hyderabad",
                 "Kochi",
                 "Manipal"
                 };
         
         String[] dateExamples=new String[61];
         int k;
         int i=0;
         for(i=0;i<30;i++){
             k=i+1;
             dateExamples[i]=k+" NOV"+" 2013";
         }
         for(int j=0;j<31;j++)
         {
             k=j+1;
             dateExamples[i]=k+" DEC"+" 2013";
             ++i;
         }
         //for date

         date=dateExamples[0];
         dateList=new JComboBox(dateExamples);
         dateList.setEditable(false);
         dateList.addActionListener(listener3);
         
         
         dvar=patternExamples1[0];
         
        list2 = new JComboBox(patternExamples1);
        list2.setEditable(true);
        list2.addActionListener(listener2);   
      
        //windowContent.add(patternList);
        //windowContent.add(l2);
        //windowContent.add(list2);
        //windowContent.add(dateList);
        j2.add(patternList);
        j2.add(l2);
        j2.add(list2);
        j2.add(dateList);
        
        //  windowContent.add(confirm);
       // windowContent.add(cancel);
        // windowContent.add(admin);
        j1.add(confirm);
         j1.add(cancel);
         j1.add(admin);
        
        frame.setLayout(new BorderLayout()); 
        frame.add(windowContent,BorderLayout.NORTH);
         frame.add(j2,BorderLayout.CENTER); 
        frame.add(j1,BorderLayout.SOUTH);
        frame.setSize(X,Y);
        frame.setVisible(true);//to display the frame
         frame.setBounds(0,0,2*X,Y-630);
        frame.setIconImage(new ImageIcon("C:\\Rohit\\Java Stuff\\NetBeans\\busmodfinal\\bus.jpg").getImage());   
       
    }
    private class ButtonHandler implements ActionListener
       {
           @Override
          public void actionPerformed(ActionEvent e)
           {
               try {
                   if(svar.equals(dvar))
 
                       JOptionPane.showMessageDialog(windowContent,"SOURCE AND DESTINATION CANNOT BE SAME","ERROR",JOptionPane.ERROR_MESSAGE);
                   else {
                       // patternList.addActionListener(listener1);
                   Page2 ob=new Page2(svar,dvar,date);   
                    frame.dispose();  
               } }catch (IOException ex) {
                   Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
               } catch (ClassNotFoundException ex) {
                   Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
               }
              // Page3 ob=new Page3();
             //  frame.dispose();   
           }
       }
    private class Combo implements ActionListener
    {
        //String newSelection;
        @Override
        public void actionPerformed(ActionEvent e) 
        {
          JComboBox cb = (JComboBox)e.getSource();
          svar = (String)cb.getSelectedItem();
         
        }
        
      
    }
     private class Combo1 implements ActionListener
    {
       // String newSelection;
        @Override
        public void actionPerformed(ActionEvent e) 
        {
          JComboBox cb = (JComboBox)e.getSource();
          dvar = (String)cb.getSelectedItem();
         
        }
        
      
    }
     
     
     private class Combo2 implements ActionListener
    {
       // String newSelection;
        @Override
        public void actionPerformed(ActionEvent e) 
        {
          JComboBox cb = (JComboBox)e.getSource();
          date = (String)cb.getSelectedItem();
         
        }
        
      
    }
     
   private class ButtonHandler1 implements ActionListener
   {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            cancelTicket ob=new cancelTicket();
            frame.dispose();
        }
       
   }
    private class ButtonHandler2 implements ActionListener
   {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            admin ob=new admin();
            frame.dispose();
        }
       
   }
     
     
     public static void main(String[] args){
         //Main ob=new Main();
         
         
     }
 }
