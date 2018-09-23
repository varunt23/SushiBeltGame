package sushigame.view;

import javax.swing.*;

import sushi.IngredientPortion;
import sushi.Plate;
import sushigame.model.Belt;

public class PlateInfo extends JFrame {
	
	private Belt belt;
	private JLabel words = new JLabel("");
	private JLabel roll = new JLabel("");
	private Plate plate;
	private String avocado;
	private String eel;
	private String tuna;
	private String shrimp;
	private String seaweed;
	private String salmon;
	private String rice;
	private String crab;
	public PlateInfo (Belt b, int i) {
		this.belt = b;
		setSize(500, 500);
		setLocation(00,0);
		setTitle("PlateInfo");
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.plate = belt.getPlateAtPosition(i);
		
		
		avocado = "Avocado Amount : 0"; 
		eel = "Eel Amount : 0"; 
		seaweed = "Seaweed Amount : 0"; 
		salmon = "Salmon Amount : 0"; 
		tuna = "Tuna Amount : 0"; 
		crab = "Crab Amount : 0"; 
		rice = "Rice Amount : 0"; 
		shrimp = "Shrimp Amount : 0"; 

		
		words.setText("<html>PLATE Color:" + plate.getColor()
					+ "<br> CHEF:" + plate.getChef().getName() + "<br>"
					+ "<br> AGE:" + b.getAgeOfPlateAtPosition(i) + "<br>"
					+ "<br> SUSHI TYPE:" + plate.getContents().getName() + "<br>"	+"<html>");
		
		ingSetter();
		if(plate.getContents().getName() == "Random Roll") {
			words.setText("<html>PLATE Color:" + plate.getColor()
			+ "<br> CHEF:" + plate.getChef().getName() + "<br>"
			+ "<br> AGE:" + b.getAgeOfPlateAtPosition(i) + "<br>"
			+ "<br> SUSHI TYPE:" + plate.getContents().getName() + "<br>"
			+ "<br> " + avocado + "<br>"
			+ "<br> " + eel + "<br>"
			+ "<br> " + crab + "<br>"
			+ "<br> " + shrimp + "<br>"
			+ "<br> " + salmon + "<br>"
			+ "<br> " + rice + "<br>"
			+ "<br> " + tuna + "<br>"
			+ "<br> " + seaweed + "<br>"
			+"<html>");
		} else {
			words.setText("<html>PLATE Color:" + plate.getColor()
			+ "<br> CHEF:" + plate.getChef().getName() + "<br>"
			+ "<br> AGE:" + b.getAgeOfPlateAtPosition(i) + "<br>"
			+ "<br> SUSHI TYPE:" + plate.getContents().getName() + "<br>"	+"<html>");
		}
		
		this.add(words);
		

	}
	
	
	
	public void ingSetter() {
		IngredientPortion[] arr = plate.getContents().getIngredients();
		for(int i = 0; i < plate.getContents().getIngredients().length; i++) {
			
			if(arr[i].getIngredient().getName() == "avocado") {
				double amt = arr[i].getAmount();
				avocado = "Avocado Amount:" + amt;
			}
			if(arr[i].getIngredient().getName() == "eel") {
				double amt = arr[i].getAmount();
				eel = "Eel Amount:" + amt;
			}
			if(arr[i].getIngredient().getName() == "crab") {
				double amt = arr[i].getAmount();
				crab = "Crab Amount:" + amt;
			}
			if(arr[i].getIngredient().getName() == "rice") {
				double amt = arr[i].getAmount();
				rice = "Rice Amount:" + amt;
			}
			if(arr[i].getIngredient().getName() == "shrimp") {
				double amt = arr[i].getAmount();
				shrimp = "Shrimp Amount:" + amt;
			}
			if(arr[i].getIngredient().getName() == "salmon") {
				double amt = arr[i].getAmount();
				salmon = "Salmon Amount:" + amt;
			}
			if(arr[i].getIngredient().getName() == "tuna") {
				double amt = arr[i].getAmount();
				tuna = "Tuna Amount:" + amt;
			}
			if(arr[i].getIngredient().getName() == "seaweed") {
				double amt = arr[i].getAmount();
				seaweed = "Seaweed Amount:" + amt;
			}
			
		}
	}
	
	
	
	
	
}
