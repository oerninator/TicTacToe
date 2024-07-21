package mvc;

import java.util.ArrayList;

public class Model {
	
	private ArrayList<ViewInterface> views;
	private FieldType[][] field = new FieldType[3][3];
	private Player currentPlayer;
	private int currentRound;
	
	public Model() {
		currentPlayer = Player.CROSS;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				field[i][j] = FieldType.EMPTY;
			}
		}
	}
	
	public void registerView(ViewInterface view) {
		if(views == null) {
			views = new ArrayList<>();
		}
		views.add(view);
	}
	
	public void update() {
		for(ViewInterface v : views) {
			v.update();
		}
	}
	
	protected FieldType[][] getField() {
		return this.field;
	}
	
	protected void setField(FieldType[][] field) {
		this.field = field;
	}
	
	protected ArrayList<ViewInterface> getRegisteredViews() {
		return this.views;
	}
	
	protected Player getCurrentPlayer() {
		return this.currentPlayer;
	}
	
	protected void switchPlayer() {
		if(this.currentPlayer.equals(Player.CIRCLE)) {
			this.currentPlayer = Player.CROSS;
		} else {
			this.currentPlayer = Player.CIRCLE;
		}
		//Die Runden Anzahl muss bei einem Spielerwechsel erhöht werden
		this.currentRound++;
	}
	
	protected int getRound() {
		return this.currentRound;
	}
}
