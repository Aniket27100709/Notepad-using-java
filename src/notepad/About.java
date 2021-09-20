/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad;

import javax.swing.*;
public class About extends JFrame {
    About(){
         setTitle("About");
        setBounds(100,100,700,700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ImageIcon icon=new ImageIcon(getClass().getResource("forbidden.png"));
        setIconImage(icon.getImage());
        setLayout(null);
        
        JLabel iconLabel=new JLabel(new ImageIcon(getClass().getResource("forbidden.png")));
        iconLabel.setBounds(50,50,250,250);
        add(iconLabel);
        
        JLabel textlabel=new JLabel("<html>Notepad<br/>This is a simple editor which  helps in creating documents</html>");
        textlabel.setBounds(100,280,400,300);
        add(textlabel);
    }
    public static void main(String[] args) {
        // TODO code application logic here
        new About().setVisible(true);
    }
}
