package newsproject;
import java.awt.*;  
import java.awt.event.*;
import java.util.List;

import javax.swing.*;  
public class CardLayoutExample extends JFrame implements ActionListener{  
CardLayout card;  
JButton[] b=new JButton[100];
JLabel[] area=new JLabel[100];  
Container c;  
    CardLayoutExample(List<String> s,int size){  
          
        c=getContentPane();  
        card=new CardLayout(200,200);  
        c.setLayout(card);  
        for(int i=0;i<size;i++) {
        	area[i]=new JLabel(s.get(i));
        	area[i].setPreferredSize(getPreferredSize());
        	 area[i].setFont(new Font("Arial", Font.PLAIN, 40));
        	 b[i]=new JButton();
        	 b[i].add(area[i]);
        }
        for(int i=0;i<size;i++) {
        	b[i].addActionListener(this);
        }
        for(int i=0;i<size;i++) {
        	c.add(b[i]);
        }                       
    }  
    public void actionPerformed(ActionEvent e) {  
    card.next(c);  
    }  
  
  
}  