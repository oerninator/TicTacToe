package mvc;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class View implements ViewInterface{
	
	private Model model;
	private List<JButton> buttons = new ArrayList<>(); 
	private Font cross;
	private Font circle;
	
	public View(Model model) {
		this.model = model;
		//Erstellung JFrame
		JFrame frame = new JFrame("TicTacToe");
		frame.setSize(800, 800);
		frame.setVisible(true);
		
		//Spielfeld mit JButtons erstellen
		for(int i = 0; i < 9; i++) {
			JButton b = new JButton("");
			b.setForeground(Color.WHITE);
			b.setBackground(Color.BLACK);
			b.setFont(new Font("Arial", 1, 100));
//			b.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//	                // Insert code here
//	            }
//			});
			buttons.add(b);
			frame.add(b);
		}
	    
	    frame.setLayout(new GridLayout(3,3));
	    
	    //Fonts für die beiden Spieler erstellen
	    
	    
	    //frame.repaint();
//		// Erstellung eines JColorChooser Dialoges, 
//        // der eine Farbe zurück gibt
//        Color ausgewaehlteFarbe = JColorChooser.showDialog(null, 
//            "Farbauswahl", null);
//        // Ausgabe der ausgewählten Farbe
//        System.out.println(ausgewaehlteFarbe);
	}
	
	public List<JButton> getButtons() {
		return this.buttons;
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
}
