package Ass2;
import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class GuiWithFileClass implements  ActionListener, ItemListener {
    
	public JTextField fname,lname,line;
    public JComboBox nationalityCom,professionCom;
    public  JPanel mainPanel;
    public String strNat, strPro;
    public  File filer;
	  public  File filew;
      public FileReader lineOut;
      public BufferedReader fileOut;
	  public BufferedReader br;
      public  DataInputStream in;
      public FileInputStream readL;
      public String linR;
    
    
        public JPanel myContentPaneCreater (){
    	String[] nationalityLIst={"","Ethiopian","American","British","Spanish","Finish","South Africa","China","Iran","French","Nepal","Germany"};
        String[] professionList={"","Physicist","Engineer","Lawyer","Psychatrist","Neurologist","Driver","House Wife","Teacher","Doctor","Cleaner","Muscian","journalist"};
    	// main panel
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.getHSBColor(120,120, 120));        
        mainPanel.setLayout(null);
        mainPanel.setLocation(200, 200);
        mainPanel.setBorder(BorderFactory.createTitledBorder("Input Form"));
       
        //user input Panel
        JPanel inputPanel = new JPanel();        
        inputPanel.setLayout(null);
        inputPanel.setBackground(Color.getHSBColor(120,105, 750));
        inputPanel.setLocation(150,50);
        inputPanel.setSize(310,200);
        mainPanel.add(inputPanel);
        
        //button Panel
        JPanel buttonPanel = new JPanel();        
        buttonPanel.setLayout(null);
        buttonPanel.setBackground(Color.getHSBColor(120,105, 750));
        buttonPanel.setLocation(150,270);
        buttonPanel.setSize(310,90);
        mainPanel.add(buttonPanel);
        
        // adding Lables to the panel        
        JLabel FNameL = new JLabel("First Name");
        FNameL .setLocation(10, 10);
        FNameL .setSize(70, 30);
        inputPanel.add(FNameL );
        
        JLabel LNameL = new JLabel("Family Name");
        LNameL.setLocation(10, 50);
        LNameL.setSize(100, 30);
        inputPanel.add(LNameL);
        
        JLabel NationalityL = new JLabel("Nationality");
        NationalityL.setLocation(10, 90);
        NationalityL.setSize(100, 30);
        inputPanel.add(NationalityL);
        
        JLabel ProfessionL = new JLabel("Profession");
        ProfessionL.setLocation(10, 130);
        ProfessionL.setSize(100, 30);
        inputPanel.add(ProfessionL);
        
        //adding text fields to the panel
        fname = new JTextField();
        fname.setLocation(100, 10);
        fname.setSize(200, 27);
        inputPanel.add(fname);
        
        lname = new JTextField();
        lname.setLocation(100, 50);
        lname.setSize(200, 27);
        inputPanel.add(lname);
        
        // adding combobox
        nationalityCom = new JComboBox(nationalityLIst);
        nationalityCom.setLocation(100, 90);
        nationalityCom.setSize(200, 27); 
        nationalityCom.setSelectedIndex(0);           
        inputPanel.add(nationalityCom);        
        
        
        professionCom = new JComboBox(professionList);
        professionCom.setLocation(100, 130);
        professionCom.setSize(200, 27);        
        professionCom.setSelectedIndex(0);        
        inputPanel.add(professionCom);
        
        // adding Buttons to the panel
        JButton openButton = new JButton("Open To Write");
        openButton.setLocation(5, 10);
        openButton.setSize(140, 30);
        buttonPanel.add(openButton );
        
        JButton writeButton = new JButton("Write This");
        writeButton.setLocation(5, 50);
        writeButton.setSize(140, 30);
        buttonPanel.add(writeButton);
        
        JButton readButton = new JButton("Open To Read");
        readButton.setLocation(165, 10);
        readButton.setSize(140, 30);
        buttonPanel.add(readButton);
        
        JButton readNButton = new JButton("Read Next");
        readNButton.setLocation(165, 50);
        readNButton.setSize(140, 30);
        buttonPanel.add(readNButton);
        
        // label for the text area
        JLabel lineRe = new JLabel("Line Read From File");
        lineRe .setLocation(250, 380);
        lineRe .setSize(250, 30);
        mainPanel.add(lineRe );
        
        // TextArea for text reading
        line = new JTextField ();
        line.setLocation(65, 420);
        line.setSize(455, 27);                       
        mainPanel.add(line);
        
        
        // open a file to write
        openButton.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String fileName;
                FileWriter fstream;
                fileName = JOptionPane.showInputDialog
                           ("Enter file name : ");
                filew = new File(fileName);  
                String inf= fileName+ ".txt is created!";
                try{
                    if (!filew.exists()) {   
                            filew.createNewFile();
                            JOptionPane.showMessageDialog(null, inf);
                        }
                    fstream = new FileWriter(filew);
                
                }
                 catch (IOException ioe)
                {
                    ioe.printStackTrace();
                }
            }
            
        });
        
        nationalityCom.addItemListener(new ItemListener(){
        public void itemStateChanged(ItemEvent ie){
            strNat = (String)nationalityCom.getSelectedItem();
        }
        });
        
        professionCom.addItemListener(new ItemListener(){
        public void itemStateChanged(ItemEvent ie){
            strPro = (String)professionCom .getSelectedItem();
        }
        });
        
        // write one line at a time
        writeButton.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              
            	try 
                {
        		     
                    FileWriter fstream = new FileWriter(filew, true);
                    BufferedWriter fileIn = new BufferedWriter(fstream); 
                    
                    
                     fileIn.append(fname.getText() + "   " ); 
                        fileIn.append(lname.getText() + "   "); 
                        fileIn.append(strNat+ "   "); 
                        fileIn.append(strPro);
                        fileIn.newLine();

                        nationalityCom.setSelectedIndex(0);
                        professionCom.setSelectedIndex(0);
                        fname.setText("");
                        lname.setText("");
                        
                       fileIn.close(); 

                }
                catch (IOException ioe)
                {
                    ioe.printStackTrace();
                }
                        
            }
                        
        });
        
       
        // open a file for reading
        readButton.addActionListener (new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	String filename1;     
                    
                    filename1 = JOptionPane.showInputDialog
                               ("Enter file name: ");
                    filer = new File(filename1);  
                    String dis2="The file does not exist.\n Enter an existing file name Again!";
                    try{
                        if (!filer.exists()) {   
                            filer.createNewFile();
                            JOptionPane.showMessageDialog(null, dis2);
                        }
                        readL = new FileInputStream(filer);
                        in = new DataInputStream(readL);
                        br = new BufferedReader(new InputStreamReader(in));
                    }

                     catch (IOException ioe)
                    {
                        ioe.printStackTrace();
                    }
            }
            
        });
       
       // Read Line of the Text File
        readNButton.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                try{ 
                ReadFromFile();
                }                
                catch (IOException ioe)
                {
                    JOptionPane.showMessageDialog(mainPanel, "No More Data !");                
                }
            }            
        });
        
        
        mainPanel.setOpaque(true);
        return mainPanel;
       
       
    }

    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported ");
    }

    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported ");
    }
    public void remove() { 
      throw new UnsupportedOperationException(); 
      
    }
    public  void ReadFromFile()  throws IOException {
    try{                            
        String line1=null;  
        line1=br.readLine();            
        if(line1!=null){      
            line.setText(line1);  
        } 
        else
        {
            JOptionPane.showMessageDialog(mainPanel, "No More Data !"); 
        }
                                
    }                
    catch (IOException ioe)
    {
        JOptionPane.showMessageDialog(mainPanel, "No More Data !"); 
        br.close();               
    }
    }
    
    
    
}
