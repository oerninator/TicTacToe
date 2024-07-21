package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Controller {
	
	private Model model;
	
	public Controller(Model model) {
		this.model = model;
	}
	
	public void start() {
		ViewInterface view = new View(model);
		model.registerView(view);
		
		for(ViewInterface v : model.getRegisteredViews()) {
			if(v instanceof View) {
				v = (View) v;
				//Es sind 9 JButtons vorhanden
				for(int i = 0; i < 9; i++) {
					JButton j = ((View) v).getButtons().get(i);
				
					j.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							//Gucken ob es ein gültiger Zug ist
							if(checkPossibleMove(j)) {
								if(model.getCurrentPlayer().equals(Player.CROSS)) {
									j.setText("X");
								} else {
									j.setText("O");
								}
								//Field updaten
								updateField(j);
								//Checken ob Spiel vorbei ist
								gameOver();
								//Spieler wechseln
								model.switchPlayer();
								//Und andere Views updaten (hier nicht nötig)
							}
						}
						
					});
				}
			}
		}
	}
	
	//Fügt den neuen Zug zum Field hinzu
	private void updateField(JButton j) {
		FieldType f = model.getCurrentPlayer().equals(Player.CIRCLE)? FieldType.CIRCLE : FieldType.CROSS;
		FieldType[][] field = model.getField();
		
		for(ViewInterface v : model.getRegisteredViews()) {
			if(v instanceof View) {
				field[((View) v).getButtons().indexOf(j) / 3][((View) v).getButtons().indexOf(j) % 3] = f;
			}
		}
		
		model.setField(field);
	}
	
	//Überprüft ob der Zug möglich ist
	private boolean checkPossibleMove(JButton j) {
		for(ViewInterface v : model.getRegisteredViews()) {
			if(v instanceof View) {
				if(model.getField()[((View) v).getButtons().indexOf(j) / 3]
						[((View) v).getButtons().indexOf(j) % 3].equals(FieldType.EMPTY)) {
					return true;
				}
			}
		}
		return false;
	}
	
	//Überprüft ob das Spiel vorbei ist
	public void gameOver() {
		FieldType[][] field = model.getField();
		FieldType player = model.getCurrentPlayer().equals(Player.CIRCLE)? FieldType.CIRCLE : FieldType.CROSS;
		
		String winner = model.getCurrentPlayer().equals(Player.CIRCLE)? "Kreisspieler" : "Kreuzspieler";
		//Horizontal und vertikal gecheckt
		for(int row = 0; row < 3; row++) {
			boolean winRow = true, winCol = true;
			for(int col = 0; col < 3; col++) {
				if(!field[row][col].equals(player)) {
					winRow = false;
				}
				if(!field[col][row].equals(player)) {
					winCol = false;
				}
			}
			
			if(winRow || winCol) {
				System.out.println("Es hat der " + winner + " gewonnen!");
				System.exit(0);
			}
		}
		//Die beiden Diagonalen überprüfen
		if((field[0][0].equals(player) && field[1][1].equals(player) && field[2][2].equals(player)) || 
				(field[2][0].equals(player) && field[1][1].equals(player) && field[0][2].equals(player))) {
			System.out.println("Es hat der " + winner + " gewonnen!");
			System.exit(0);
		}
		
		if(model.getRound() == 8) {
			System.out.println("Unentschieden!");
			System.exit(0);
		}
	}
	
}
