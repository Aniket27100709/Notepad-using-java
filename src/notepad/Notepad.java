/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad;

import javax.swing.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.FileNameExtensionFilter;
public class Notepad extends JFrame implements ActionListener{
    JMenuBar menubar=new JMenuBar();
    JMenu file=new JMenu("File");
    JMenu edit=new JMenu("Edit");
    JMenu help=new JMenu("Help");
    
    JMenuItem newfile=new JMenuItem("New File");
    JMenuItem openfile=new JMenuItem("Open File");
    JMenuItem savefile=new JMenuItem("Save File");
    JMenuItem print=new JMenuItem("Print");
    JMenuItem exit=new JMenuItem("Exit");
    
    JMenuItem cut=new JMenuItem("Cut"); 
    JMenuItem copy=new JMenuItem("Copy");
    JMenuItem paste=new JMenuItem("Paste");
    JMenuItem selectall=new JMenuItem("SelectAll");
   
    JMenuItem about=new JMenuItem("About");
    
    JTextArea textArea=new JTextArea();
    Notepad(){
        setTitle("Notepad");
        setBounds(100,100,700,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // for setting image
        ImageIcon icon=new ImageIcon(getClass().getResource("forbidden.png"));
        setIconImage(icon.getImage());
        //for setting menubar
        setJMenuBar(menubar);
        menubar.add(file);
        menubar.add(edit);
        menubar.add(help);
        
        file.add(newfile);
        file.add(openfile);
        file.add(savefile);
        file.add(print);
        file.add(exit);
        
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectall);
        
        help.add(about);
        
        JScrollPane scrollpane =new JScrollPane(textArea);
        add(scrollpane);
        scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        
        newfile.addActionListener(this);
        openfile.addActionListener(this);
        savefile.addActionListener(this);
        print.addActionListener(this);
        exit.addActionListener(this);
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectall.addActionListener(this);
        about.addActionListener(this);
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        new Notepad().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
          if(e.getActionCommand().equalsIgnoreCase("New File")){
              textArea.setText(null);  
          }
          else if(e.getActionCommand().equalsIgnoreCase("Open File")){
               JFileChooser fc=new JFileChooser();
               FileNameExtensionFilter textFilter = new FileNameExtensionFilter("Text Files","txt");
               fc.setAcceptAllFileFilterUsed(false);
               fc.addChoosableFileFilter(textFilter);
               int action=fc.showSaveDialog(null);
               if(action!=JFileChooser.APPROVE_OPTION){
                   return;
               }
               else{

                  
                       
                       try{
                           BufferedReader reader=new BufferedReader(new FileReader(fc.getSelectedFile()));
                           textArea.read(reader,null);
                       }
                       catch(IOException ex){
                           ex.printStackTrace();
                       }
                   
               }
          }
          else if(e.getActionCommand().equalsIgnoreCase("Save File")){
               JFileChooser fc=new JFileChooser();
               FileNameExtensionFilter textFilter = new FileNameExtensionFilter("Text Files","txt");
               fc.setAcceptAllFileFilterUsed(false);
               fc.addChoosableFileFilter(textFilter);
               
               int action=fc.showSaveDialog(null);
               if(action!=JFileChooser.APPROVE_OPTION){
                   return;
               }
               else{
                   String filename=fc.getSelectedFile().getAbsolutePath().toString();
                   if(!filename.contains(".txt")){
                       filename=filename+".txt";
                       
                       try{
                           BufferedWriter writer=new BufferedWriter(new FileWriter(filename));
                           textArea.write(writer);
                       }
                       catch(IOException ex){
                           ex.printStackTrace();
                       }
                   }
               }
          }
          else  if(e.getActionCommand().equalsIgnoreCase("Print")){
              try {
                  textArea.print();
                          } catch (PrinterException ex) {
                  Logger.getLogger(Notepad.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
          else if(e.getActionCommand().equalsIgnoreCase("Exit")){
              System.exit(0);
          }
          else if(e.getActionCommand().equalsIgnoreCase("Cut")){
              textArea.cut();
          }
          else if(e.getActionCommand().equalsIgnoreCase("Copy")){
              textArea.copy();
          }
          else if(e.getActionCommand().equalsIgnoreCase("Paste")){
              textArea.paste();
          }
          else if(e.getActionCommand().equalsIgnoreCase("SelectAll")){
              textArea.selectAll();
          }
          else if(e.getActionCommand().equalsIgnoreCase("About")){
              new About().setVisible(true);
          }
    }
    
}
