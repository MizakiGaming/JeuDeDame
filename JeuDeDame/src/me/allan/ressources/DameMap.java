package me.allan.ressources;


import java.util.HashMap;

import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class DameMap extends Parent {

	private static Stage window;
	private static HashMap<Byte, float[]> cellule;

	/*
	 * Creation de la grille de jeu de dame
	 * 
	 * @param stage mettre la grille sur quelle fenetre
	 */

	public DameMap(Stage stage) {

		window = stage;
		cellule = new HashMap<Byte, float[]>();
		double x = window.getScene().getWidth(), y = window.getScene().getHeight();
		makeColorCase(Color.SADDLEBROWN, Color.WHITESMOKE);
		createCellule();
		
		for (byte i = 1; i <= 10; i++) {
			Line ligne = new Line((i / 10.0) * x, 0.0, (i / 10.0) * x, y);
			ligne.setFill(Color.BLACK);
			ligne.setStrokeWidth(1.5);
			this.getChildren().add(ligne);
		}

		for (byte i = 1; i <= 10; i++) {
			Line ligne = new Line(0.0, (i / 10.0) * y, x, (i / 10.0) * y);
			ligne.setFill(Color.BLACK);
			ligne.setStrokeWidth(1.5);
			this.getChildren().add(ligne);
		}
	}

	private void makeColorCase(Color color1, Color color2) {
	
		byte color = 0;
		double x = window.getScene().getWidth(), y = window.getScene().getHeight();
	
		for (byte i = 0; i < 10; i++) {
	
			for (byte j = 0; j < 10; j++) {
				Rectangle carre = new Rectangle(x / 10.0, y / 10.0);
				if (color == 0) {
					carre.setFill(color1);
					color = 1;
				} else {
					carre.setFill(color2);
					color = 0;
				}
				
				carre.setLayoutX((i/10.0) * x);
				carre.setLayoutY((j/10.0) * y);
				
				this.getChildren().add(carre);
			}
			
			color = (byte) ((color == 0) ? 1 : 0);
		}
	}
	
	private void createCellule() {
		float x1, x2, y1, y2;
		float x = (float) window.getWidth(), y = (float) window.getHeight();
		byte nbrCellule = 1;
		
		for(byte j = 1; j <= 10; j++) {
			for(byte i = 1; i <= 10; i++) {
				x1 = (float) (((i-1)/10.0) * x);
				x2 = (float) ((i/10.0) * x);
				y1 = (float) (((j-1)/10.0) * y);
				y2 = (float) ((j/10.0) * y);
				
				cellule.put(nbrCellule, new float[] {x1, y1, x2, y2});
				nbrCellule++;
			}
		}
		
	}
	
	
}
