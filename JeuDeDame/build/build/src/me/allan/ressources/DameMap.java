package me.allan.ressources;

import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class DameMap extends Parent {

	private static Stage window;

	/*
	 * Creation de la grille de jeu de dame
	 * 
	 * @param stage mettre la grille sur quelle fenetre
	 */

	public DameMap(Stage stage) {

		window = stage;
		double x = window.getScene().getWidth(), y = window.getScene().getHeight();
		makeColorCase(Color.SADDLEBROWN, Color.WHITESMOKE);
		
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
}
