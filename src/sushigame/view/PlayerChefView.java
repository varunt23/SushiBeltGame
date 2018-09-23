package sushigame.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.swing.*;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import sushi.AvocadoPortion;
import sushi.CrabPortion;
import sushi.EelPortion;
import sushi.IngredientPortion;
import sushi.Nigiri;
import sushi.Plate;
import sushi.RedPlate;
import sushi.RicePortion;
import sushi.Roll;
import sushi.SalmonPortion;
import sushi.Sashimi;
import sushi.SeaweedPortion;
import sushi.ShrimpPortion;
import sushi.Sushi;
import sushi.TunaPortion;

public class PlayerChefView extends JPanel implements ActionListener, ChangeListener<Object> {

	private List<ChefViewListener> listeners;
	//	private Sushi kmp_roll;
	//	private Sushi crab_sashimi;
	//	private Sushi eel_nigiri;
	private int belt_size;
	private JButton sashimi_button;	
	private JButton nigiri_button;
	private JButton roll_button;
	private JButton crab;	
	private JButton eel;
	private JButton shrimp;
	private JButton tuna;	
	private JButton salmon;
	private JButton blue;
	private JButton red;
	private JButton green;
	private JButton gold;
	private JButton create;
	private JButton next;
	private JButton back;
	private JSlider nearest;
	private JSlider price;
	private JSlider avocadopor;
	private JSlider crabpor;
	private JSlider eelpor;
	private JSlider ricepor;
	private JSlider salmonpor;
	private JSlider seaweedpor;
	private JSlider shrimppor;
	private JSlider tunapor;
	private JLabel avoamt;
	private JLabel crabamt;
	private JLabel eelamt;
	private JLabel riceamt;
	private JLabel salamt;
	private JLabel seaamt;
	private JLabel shramt;
	private JLabel tunaamt;
	private JLabel nearestto;
	private JLabel pricelabel;
	private int type;
	private int platetype;
	private int sushitype;
	private int positiontype;
	private double avocadoamnt;
	private double crabamnt;
	private double eelamnt;
	private double riceamnt;
	private double salmonamnt;
	private double seaweedamnt;
	private double shrimpamnt;
	private double tunaamnt;
	private Sushi rolly;


	public PlayerChefView(int belt_size) {
		this.belt_size = belt_size;
		listeners = new ArrayList<ChefViewListener>();

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		sashimi_button = new JButton(" Make Sashimi");
		sashimi_button.setActionCommand("Sashimi");
		sashimi_button.addActionListener(this);
		add(sashimi_button);

		nigiri_button = new JButton(" Make Nigiri");
		nigiri_button.setActionCommand("Nigiri");
		nigiri_button.addActionListener(this);
		add(nigiri_button);

		roll_button = new JButton(" Make Roll");
		roll_button.setActionCommand("Roll");
		roll_button.addActionListener(this);
		add(roll_button);

		//		kmp_roll = new Roll("KMP Roll", new IngredientPortion[] {new EelPortion(1.0), new AvocadoPortion(0.5), new SeaweedPortion(0.2)});
		//		crab_sashimi = new Sashimi(Sashimi.SashimiType.CRAB);
		//		eel_nigiri = new Nigiri(Nigiri.NigiriType.EEL);

		this.type = 0;
		this.platetype = 0;
		this.sushitype = 0;
		this.positiontype = 0;
		this.avocadoamnt = 0;
		this.crabamnt = 0;
		this.eelamnt = 0;
		this.riceamnt = 0;
		this.shrimpamnt = 0;
		this.salmonamnt = 0;
		this.tunaamnt = 0;
		this.seaweedamnt = 0;
	}

	public void registerChefListener(ChefViewListener cl) {
		listeners.add(cl);
	}

	private void makeRedPlateRequest(Sushi plate_sushi, int plate_position) {
		for (ChefViewListener l : listeners) {
			l.handleRedPlateRequest(plate_sushi, plate_position);
		}
	}

	private void makeGreenPlateRequest(Sushi plate_sushi, int plate_position) {
		for (ChefViewListener l : listeners) {
			l.handleGreenPlateRequest(plate_sushi, plate_position);
		}
	}

	private void makeBluePlateRequest(Sushi plate_sushi, int plate_position) {
		for (ChefViewListener l : listeners) {
			l.handleBluePlateRequest(plate_sushi, plate_position);
		}
	}

	private void makeGoldPlateRequest(Sushi plate_sushi, int plate_position, double price) {
		for (ChefViewListener l : listeners) {
			l.handleGoldPlateRequest(plate_sushi, plate_position, price);
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {



		switch (e.getActionCommand()) {
		case "Sashimi":
			
			
			if(back != null) {
				back.setVisible(false);
			}
			type =1;
			sashimi_button.setVisible(false);
			nigiri_button.setVisible(false);
			roll_button.setVisible(false);
			crab = new JButton("Crab");
			crab.setActionCommand("Crab");
			crab.addActionListener(this);
			// crab.setVisible(true);
			this.add(crab);

			eel = new JButton("Eel");
			eel.setActionCommand("Eel");
			eel.addActionListener(this);
			this.add(eel);

			salmon = new JButton("Salmon");
			salmon.setActionCommand("Salmon");
			salmon.addActionListener(this);
			this.add(salmon);

			shrimp = new JButton("Shrimp");
			shrimp.setActionCommand("Shrimp");
			shrimp.addActionListener(this);
			this.add(shrimp);

			tuna = new JButton("Tuna");
			tuna.setActionCommand("Tuna");
			tuna.addActionListener(this);
			this.add(tuna);

			back = new JButton("back");
			back.setActionCommand("Back");
			back.addActionListener(this);
			this.add(back);
			break;
		case "Nigiri":
			if(back != null) {
				back.setVisible(false);
			}
			type =2;
			sashimi_button.setVisible(false);
			nigiri_button.setVisible(false);
			roll_button.setVisible(false);

			crab = new JButton("Crab");
			crab.setActionCommand("Crab");
			crab.addActionListener(this);
			this.add(crab);

			eel = new JButton("Eel");
			eel.setActionCommand("Eel");
			eel.addActionListener(this);
			this.add(eel);

			salmon = new JButton("Salmon");
			salmon.setActionCommand("Salmon");
			salmon.addActionListener(this);
			this.add(salmon);

			shrimp = new JButton("Shrimp");
			shrimp.setActionCommand("Shrimp");
			shrimp.addActionListener(this);
			this.add(shrimp);

			tuna = new JButton("Tuna");
			tuna.setActionCommand("Tuna");
			tuna.addActionListener(this);
			this.add(tuna);

			back = new JButton("back");
			back.setActionCommand("Back");
			back.addActionListener(this);
			this.add(back);
			
			
			break;

			//This is where roll starts
		case "Roll":
		
			if(back != null) {
				back.setVisible(false);
			}
			type =3;

			sashimi_button.setVisible(false);
			nigiri_button.setVisible(false);
			roll_button.setVisible(false);


			Hashtable labelTable = new Hashtable();
			labelTable.put( new Integer( 1 ), new JLabel("0.1") );
			labelTable.put( new Integer( 5 ), new JLabel("0.5") );
			labelTable.put( new Integer( 10 ), new JLabel("1.0") );
			labelTable.put( new Integer( 15 ), new JLabel("1.5") );

			avoamt = new JLabel("Select Amount of Avocado");
			this.add(avoamt);
			avocadopor = new JSlider();
			this.add(avocadopor);
			avocadopor.setLabelTable( labelTable );
			avocadopor.setLabelTable(labelTable);
			avocadopor.setMaximum(15);
			avocadopor.setMinimum(1);
			avocadopor.setValue(8);
			avocadopor.setMajorTickSpacing(5);
			avocadopor.setMinorTickSpacing(1);
			avocadopor.setPaintTicks(true);
			avocadopor.setPaintLabels(true);

			crabamt = new JLabel("Select Amount of Crab");
			this.add(crabamt);
			crabpor = new JSlider();
			this.add(crabpor);
			crabpor.setLabelTable( labelTable );
			crabpor.setLabelTable(labelTable);
			crabpor.setMaximum(15);
			crabpor.setMinimum(1);
			crabpor.setValue(8);
			crabpor.setMajorTickSpacing(5);
			crabpor.setMinorTickSpacing(1);
			crabpor.setPaintTicks(true);
			crabpor.setPaintLabels(true);

			eelamt = new JLabel("Select Amount of Eel");
			this.add(eelamt);
			eelpor = new JSlider();
			this.add(eelpor);
			eelpor.setLabelTable( labelTable );
			eelpor.setLabelTable(labelTable);
			eelpor.setMaximum(15);
			eelpor.setMinimum(1);
			eelpor.setValue(8);
			eelpor.setMajorTickSpacing(5);
			eelpor.setMinorTickSpacing(1);
			eelpor.setPaintTicks(true);
			eelpor.setPaintLabels(true);

			riceamt = new JLabel("Select Amount of Rice");
			this.add(riceamt);
			ricepor = new JSlider();
			this.add(ricepor);
			ricepor.setLabelTable( labelTable );
			ricepor.setLabelTable(labelTable);
			ricepor.setMaximum(15);
			ricepor.setMinimum(1);
			ricepor.setValue(8);
			ricepor.setMajorTickSpacing(5);
			ricepor.setMinorTickSpacing(1);
			ricepor.setPaintTicks(true);
			ricepor.setPaintLabels(true);

			salamt = new JLabel("Select Amount of Salmon");
			this.add(salamt);
			salmonpor = new JSlider();
			this.add(salmonpor);
			salmonpor.setLabelTable( labelTable );
			salmonpor.setLabelTable(labelTable);
			salmonpor.setMaximum(15);
			salmonpor.setMinimum(1);
			salmonpor.setValue(8);
			salmonpor.setMajorTickSpacing(5);
			salmonpor.setMinorTickSpacing(1);
			salmonpor.setPaintTicks(true);
			salmonpor.setPaintLabels(true);

			seaamt = new JLabel("Select Amount of Seaweed");
			this.add(seaamt);
			seaweedpor = new JSlider();
			this.add(seaweedpor);
			seaweedpor.setLabelTable( labelTable );
			seaweedpor.setLabelTable(labelTable);
			seaweedpor.setMaximum(15);
			seaweedpor.setMinimum(1);
			seaweedpor.setValue(8);
			seaweedpor.setMajorTickSpacing(5);
			seaweedpor.setMinorTickSpacing(1);
			seaweedpor.setPaintTicks(true);
			seaweedpor.setPaintLabels(true);

			shramt = new JLabel("Select Amount of Shrimp");
			this.add(shramt);
			shrimppor = new JSlider();
			this.add(shrimppor);
			shrimppor.setLabelTable( labelTable );
			shrimppor.setLabelTable(labelTable);
			shrimppor.setMaximum(15);
			shrimppor.setMinimum(1);
			shrimppor.setValue(8);
			shrimppor.setMajorTickSpacing(5);
			shrimppor.setMinorTickSpacing(1);
			shrimppor.setPaintTicks(true);
			shrimppor.setPaintLabels(true);

			tunaamt = new JLabel("Select Amount of Tuna");
			this.add(tunaamt);
			tunapor = new JSlider();
			this.add(tunapor);
			tunapor.setLabelTable( labelTable );
			tunapor.setLabelTable(labelTable);
			tunapor.setMaximum(15);
			tunapor.setMinimum(1);
			tunapor.setValue(8);
			tunapor.setMajorTickSpacing(5);
			tunapor.setMinorTickSpacing(1);
			tunapor.setPaintTicks(true);
			tunapor.setPaintLabels(true);

			next = new JButton("Next");
			next.setActionCommand("Next");
			next.addActionListener(this);
			this.add(next);

			
			back = new JButton("back");
			back.setActionCommand("Back");
			back.addActionListener(this);
			this.add(back);
			
			break;
			//This is where the Type of nigiri and sashimi are
		case "Crab":
			
			if(back != null) {
				back.setVisible(false);
			}
			sushitype = 1;
			crab.setVisible(false);
			eel.setVisible(false);
			shrimp.setVisible(false);
			salmon.setVisible(false);
			tuna.setVisible(false);

			red = new JButton("Red");
			red.setActionCommand("RedPlate");
			red.addActionListener(this);
			this.add(red);

			blue = new JButton("Blue");
			blue.setActionCommand("BluePlate");
			blue.addActionListener(this);
			this.add(blue);

			green = new JButton("Green");
			green.setActionCommand("GreenPlate");
			green.addActionListener(this);
			this.add(green);

			gold = new JButton("Gold");
			gold.setActionCommand("GoldPlate");
			gold.addActionListener(this);
			this.add(gold);


			back = new JButton("back");
			back.setActionCommand("Back");
			back.addActionListener(this);
			this.add(back);

			break;
		case "Salmon":
			
			
			if(back != null) {
				back.setVisible(false);
			}
			sushitype = 2;
			crab.setVisible(false);
			eel.setVisible(false);
			shrimp.setVisible(false);
			salmon.setVisible(false);
			tuna.setVisible(false);

			red = new JButton("Red");
			red.setActionCommand("RedPlate");
			red.addActionListener(this);
			this.add(red);

			blue = new JButton("Blue");
			blue.setActionCommand("BluePlate");
			blue.addActionListener(this);
			this.add(blue);

			green = new JButton("Green");
			green.setActionCommand("GreenPlate");
			green.addActionListener(this);
			this.add(green);

			gold = new JButton("Gold");
			gold.setActionCommand("GoldPlate");
			gold.addActionListener(this);
			this.add(gold);

			back = new JButton("back");
			back.setActionCommand("Back");
			back.addActionListener(this);
			this.add(back);
			
			break;
		case "Tuna":
			if(back != null) {
				back.setVisible(false);
			}
			
			sushitype = 3;
			crab.setVisible(false);
			eel.setVisible(false);
			shrimp.setVisible(false);
			salmon.setVisible(false);
			tuna.setVisible(false);

			red = new JButton("Red");
			red.setActionCommand("RedPlate");
			red.addActionListener(this);
			this.add(red);

			blue = new JButton("Blue");
			blue.setActionCommand("BluePlate");
			blue.addActionListener(this);
			this.add(blue);

			green = new JButton("Green");
			green.setActionCommand("GreenPlate");
			green.addActionListener(this);
			this.add(green);

			gold = new JButton("Gold");
			gold.setActionCommand("GoldPlate");
			gold.addActionListener(this);
			this.add(gold);

			back = new JButton("back");
			back.setActionCommand("Back");
			back.addActionListener(this);
			this.add(back);
			
			break;
		case "Shrimp":
			if(back != null) {
				back.setVisible(false);
			}
			sushitype = 4;
			crab.setVisible(false);
			eel.setVisible(false);
			shrimp.setVisible(false);
			salmon.setVisible(false);
			tuna.setVisible(false);

			red = new JButton("Red");
			red.setActionCommand("RedPlate");
			red.addActionListener(this);
			this.add(red);

			blue = new JButton("Blue");
			blue.setActionCommand("BluePlate");
			blue.addActionListener(this);
			this.add(blue);

			green = new JButton("Green");
			green.setActionCommand("GreenPlate");
			green.addActionListener(this);
			this.add(green);

			gold = new JButton("Gold");
			gold.setActionCommand("GoldPlate");
			gold.addActionListener(this);
			this.add(gold);

			back = new JButton("back");
			back.setActionCommand("Back");
			back.addActionListener(this);
			this.add(back);
			
			break;
		case "Eel":
			if(back != null) {
				back.setVisible(false);
			}
			sushitype = 5;
			crab.setVisible(false);
			eel.setVisible(false);
			shrimp.setVisible(false);
			salmon.setVisible(false);
			tuna.setVisible(false);

			red = new JButton("Red");
			red.setActionCommand("RedPlate");
			red.addActionListener(this);
			this.add(red);

			blue = new JButton("Blue");
			blue.setActionCommand("BluePlate");
			blue.addActionListener(this);
			this.add(blue);

			green = new JButton("Green");
			green.setActionCommand("GreenPlate");
			green.addActionListener(this);
			this.add(green);

			gold = new JButton("Gold");
			gold.setActionCommand("GoldPlate");
			gold.addActionListener(this);
			this.add(gold);

			back = new JButton("back");
			back.setActionCommand("Back");
			back.addActionListener(this);
			this.add(back);

			break;
			//This is where the cases for the different colored plates start
		case "RedPlate":
			if(back != null) {
				back.setVisible(false);
			}
			platetype = 1;
			blue.setVisible(false);
			red.setVisible(false);
			green.setVisible(false);
			gold.setVisible(false);

			nearestto = new JLabel("Set Plate Nearest to Which Position");
			this.add(nearestto);
			nearest = new JSlider();
			nearest.setMaximum(20);
			nearest.setMinimum(0);
			nearest.setValue(10);
			nearest.setMajorTickSpacing(5);
			nearest.setMinorTickSpacing(1);
			nearest.setPaintTicks(true);
			nearest.setPaintLabels(true);
			this.add(nearest);

			create = new JButton("Create");
			create.setActionCommand("Create");
			create.addActionListener(this);
			this.add(create);

			back = new JButton("back");
			back.setActionCommand("Back");
			back.addActionListener(this);
			this.add(back);
			
			break;
		case "BluePlate":
			if(back != null) {
				back.setVisible(false);
			}
			platetype = 2;
			blue.setVisible(false);
			red.setVisible(false);
			green.setVisible(false);
			gold.setVisible(false);

			nearestto = new JLabel("Set Plate Nearest to Which Position");
			this.add(nearestto);
			nearest = new JSlider();
			nearest.setMaximum(20);
			nearest.setMinimum(0);
			nearest.setValue(10);
			nearest.setMajorTickSpacing(5);
			nearest.setMinorTickSpacing(1);
			nearest.setPaintTicks(true);
			nearest.setPaintLabels(true);
			this.add(nearest);

			create = new JButton("Create");
			create.setActionCommand("Create");
			create.addActionListener(this);
			this.add(create);
			
			back = new JButton("back");
			back.setActionCommand("Back");
			back.addActionListener(this);
			this.add(back);
			break;
		case "GreenPlate":
			if(back != null) {
				back.setVisible(false);
			}
			platetype = 3;
			blue.setVisible(false);
			red.setVisible(false);
			green.setVisible(false);
			gold.setVisible(false);

			nearestto = new JLabel("Set Plate Nearest to Which Position");
			this.add(nearestto);
			nearest = new JSlider();
			nearest.setMaximum(20);
			nearest.setMinimum(0);
			nearest.setValue(10);
			nearest.setMajorTickSpacing(5);
			nearest.setMinorTickSpacing(1);
			nearest.setPaintTicks(true);
			nearest.setPaintLabels(true);
			//	nearest.addChangeListener((javax.swing.event.ChangeListener) this);
			this.add(nearest);

			create = new JButton("Create");
			create.setActionCommand("Create");
			create.addActionListener(this);
			this.add(create);
			
			back = new JButton("back");
			back.setActionCommand("Back");
			back.addActionListener(this);
			this.add(back);
			
			break;

		case "GoldPlate":
			if(back != null) {
				back.setVisible(false);
			}
			platetype = 4;
			blue.setVisible(false);
			red.setVisible(false);
			green.setVisible(false);
			gold.setVisible(false);

			sashimi_button.setVisible(false);
			nigiri_button.setVisible(false);
			roll_button.setVisible(false);
			
			nearestto = new JLabel("Set Plate Nearest to Which Position");
			this.add(nearestto);
			nearest = new JSlider();
			nearest.setMaximum(belt_size -1);
			nearest.setMinimum(0);
			nearest.setValue(10);
			nearest.setMajorTickSpacing(5);
			nearest.setMinorTickSpacing(1);
			nearest.setPaintTicks(true);
			nearest.setPaintLabels(true);
			//	nearest.addChangeListener((javax.swing.event.ChangeListener) this);
			this.add(nearest);

			Hashtable pricetable = new Hashtable();
			pricetable.put( new Integer( 500 ), new JLabel("$5") );
			pricetable.put( new Integer( 600 ), new JLabel("$6") );
			pricetable.put( new Integer( 700 ), new JLabel("$7") );
			pricetable.put( new Integer( 800 ), new JLabel("$8") );
			pricetable.put( new Integer( 900 ), new JLabel("$9") );
			pricetable.put( new Integer( 1000 ), new JLabel("$10") );			 
			
			pricelabel = new JLabel("Price to set the plate to");
			this.add(pricelabel);
			price = new JSlider();
			price.setMaximum(1000);
			price.setMinimum(500);
			price.setValue(750);
			price.setMajorTickSpacing(100);
			price.setMinorTickSpacing(1);
			price.setPaintTicks(true);
			price.setPaintLabels(true);
			price.setLabelTable(pricetable);
			this.add(price);

			create = new JButton("Create");
			create.setActionCommand("Create");
			create.addActionListener(this);
			this.add(create);
			
			back = new JButton("back");
			back.setActionCommand("Back");
			back.addActionListener(this);
			this.add(back);
			
			break;
		case "Next":
			if(back != null) {
				back.setVisible(false);
			}

			sashimi_button.setVisible(false);
			nigiri_button.setVisible(false);
			roll_button.setVisible(false);
			
			avocadoamnt = (double) avocadopor.getValue() / 10;
			crabamnt = (double) crabpor.getValue() / 10;
			eelamnt = (double) eelpor.getValue() / 10;
			riceamnt = (double) ricepor.getValue() / 10;
			salmonamnt = (double) salmonpor.getValue() / 10;
			seaweedamnt =  (double) seaweedpor.getValue() / 10;
			shrimpamnt = (double) shrimppor.getValue() / 10;
			tunaamnt =  (double) tunapor.getValue() / 10;

			rolly = new Roll("Random Roll", new IngredientPortion[] {
					new AvocadoPortion(avocadoamnt),
					new CrabPortion(crabamnt),
					new EelPortion(eelamnt),
					new RicePortion(riceamnt),
					new SalmonPortion(salmonamnt),
					new SeaweedPortion(seaweedamnt),
					new ShrimpPortion(shrimpamnt),
					new TunaPortion(tunaamnt),
			});
			
			avocadopor.setVisible(false);
			crabpor.setVisible(false);;
			eelpor.setVisible(false);;
			ricepor.setVisible(false);;
			salmonpor.setVisible(false);;
			seaweedpor.setVisible(false);;
			shrimppor.setVisible(false);;
			tunapor.setVisible(false);;
			avoamt.setVisible(false);
			crabamt.setVisible(false);
			eelamt.setVisible(false);
			riceamt.setVisible(false);
			salamt.setVisible(false);
			seaamt.setVisible(false);
			shramt.setVisible(false);
			tunaamt.setVisible(false);
			next.setVisible(false);
			
			red = new JButton("Red");
			red.setActionCommand("RedPlate");
			red.addActionListener(this);
			this.add(red);

			blue = new JButton("Blue");
			blue.setActionCommand("BluePlate");
			blue.addActionListener(this);
			this.add(blue);

			green = new JButton("Green");
			green.setActionCommand("GreenPlate");
			green.addActionListener(this);
			this.add(green);

			gold = new JButton("Gold");
			gold.setActionCommand("GoldPlate");
			gold.addActionListener(this);
			this.add(gold);
			
			back = new JButton("back");
			back.setActionCommand("Back");
			back.addActionListener(this);
			this.add(back);
			
			break;
		
		case "Back":
			if(back != null) {
				back.setVisible(false);
			}	
			sashimi_button.setVisible(true);
			nigiri_button.setVisible(true);
			roll_button.setVisible(true);
			back.setVisible(false);
			
			if(crab != null) {
				crab.setVisible(false);	
			}
			if(tuna != null) {
				tuna.setVisible(false);	
			}if(shrimp != null) {
				shrimp.setVisible(false);	
			}if(salmon != null) {
				salmon.setVisible(false);	
			}if(eel != null) {
				eel.setVisible(false);	
			}if(red != null) {
				red.setVisible(false);	
			}if(blue != null) {
				blue.setVisible(false);	
			}if(green != null) {
				green.setVisible(false);	
			}if(gold != null) {
				gold.setVisible(false);	
			}if(next != null) {
				next.setVisible(false);	
			}if(back != null) {
				back.setVisible(false);	
			}if(create != null) {
				create.setVisible(false);	
			}if(nearest != null) {
				nearest.setVisible(false);	
			}if(price != null) {
				price.setVisible(false);	
			}if(avocadopor != null) {
				avocadopor.setVisible(false);	
			}if(crabpor != null) {
				crabpor.setVisible(false);	
			}if(ricepor != null) {
				ricepor.setVisible(false);	
			}if(eelpor != null) {
				eelpor.setVisible(false);	
			}if(salmonpor != null) {
				salmonpor.setVisible(false);	
			}if(tunapor != null) {
				tunapor.setVisible(false);	
			}if(shrimppor != null) {
				shrimppor.setVisible(false);	
			}if(seaweedpor != null) {
				seaweedpor.setVisible(false);
			}if(avoamt != null) {
				avoamt.setVisible(false);	
			}if(crabamt != null) {
				crabamt.setVisible(false);	
			}if(eelamt != null) {
				eelamt.setVisible(false);	
			}if(riceamt != null) {
				riceamt.setVisible(false);	
			}if(salamt != null) {
				salamt.setVisible(false);	
			}if(seaamt != null) {
				seaamt.setVisible(false);	
			}if(shramt != null) {
				shramt.setVisible(false);	
			}if(tunaamt != null) {
				tunaamt.setVisible(false);	
			}if(nearestto != null) {
				nearestto.setVisible(false);	
			}if(pricelabel != null) {
				pricelabel.setVisible(false);	
			}
			break;
			
		case "Create":
			if(back != null) {
				back.setVisible(false);
			}
			if (type == 1) {
				if(sushitype == 1) {
					if(platetype == 1) {
						Sushi temp = new Sashimi(Sashimi.SashimiType.CRAB);
						makeRedPlateRequest(temp, nearest.getValue());
					}
					if(platetype == 2) {
						Sushi temp = new Sashimi(Sashimi.SashimiType.CRAB);
						makeBluePlateRequest(temp, nearest.getValue());
					}
					if(platetype == 3) {
						Sushi temp = new Sashimi(Sashimi.SashimiType.CRAB);
						makeGreenPlateRequest(temp, nearest.getValue());
					}
					if(platetype == 4) {
						Sushi temp = new Sashimi(Sashimi.SashimiType.CRAB);
						makeGoldPlateRequest(temp, nearest.getValue(), price.getValue());
					}

				} 
				if(sushitype == 2) {
					if(platetype == 1) {
						Sushi temp = new Sashimi(Sashimi.SashimiType.SALMON);
						makeRedPlateRequest(temp, nearest.getValue());
					}
					if(platetype == 2) {
						Sushi temp = new Sashimi(Sashimi.SashimiType.SALMON);
						makeBluePlateRequest(temp, nearest.getValue());
					}
					if(platetype == 3) {
						Sushi temp = new Sashimi(Sashimi.SashimiType.SALMON);
						makeGreenPlateRequest(temp, nearest.getValue());
					}
					if(platetype == 4) {
						Sushi temp = new Sashimi(Sashimi.SashimiType.SALMON);
						makeGoldPlateRequest(temp, nearest.getValue(), price.getValue());
					}
				} 
				if(sushitype == 3) {
					if(platetype == 1) {
						Sushi temp = new Sashimi(Sashimi.SashimiType.TUNA);
						makeRedPlateRequest(temp, nearest.getValue());
					}
					if(platetype == 2) {
						Sushi temp = new Sashimi(Sashimi.SashimiType.TUNA);
						makeBluePlateRequest(temp, nearest.getValue());
					}
					if(platetype == 3) {
						Sushi temp = new Sashimi(Sashimi.SashimiType.TUNA);
						makeGreenPlateRequest(temp, nearest.getValue());
					}
					if(platetype == 4) {
						Sushi temp = new Sashimi(Sashimi.SashimiType.TUNA);
						makeGoldPlateRequest(temp, nearest.getValue(), price.getValue());
					}
				} 
				if(sushitype == 4) {
					if(platetype == 1) {
						Sushi temp = new Sashimi(Sashimi.SashimiType.SHRIMP);
						makeRedPlateRequest(temp, nearest.getValue());
					}
					if(platetype == 2) {
						Sushi temp = new Sashimi(Sashimi.SashimiType.SHRIMP);
						makeBluePlateRequest(temp, nearest.getValue());
					}
					if(platetype == 3) {
						Sushi temp = new Sashimi(Sashimi.SashimiType.SHRIMP);
						makeGreenPlateRequest(temp, nearest.getValue());
					}
					if(platetype == 4) {
						Sushi temp = new Sashimi(Sashimi.SashimiType.SHRIMP);
						makeGoldPlateRequest(temp, nearest.getValue(), price.getValue());
					}
				} 
				if(sushitype == 5) {
					if(platetype == 1) {
						Sushi temp = new Sashimi(Sashimi.SashimiType.EEL);
						makeRedPlateRequest(temp, nearest.getValue());
					}
					if(platetype == 2) {
						Sushi temp = new Sashimi(Sashimi.SashimiType.EEL);
						makeBluePlateRequest(temp, nearest.getValue());
					}
					if(platetype == 3) {
						Sushi temp = new Sashimi(Sashimi.SashimiType.EEL);
						makeGreenPlateRequest(temp, nearest.getValue());
					}
					if(platetype == 4) {
						Sushi temp = new Sashimi(Sashimi.SashimiType.EEL);
						makeGoldPlateRequest(temp, nearest.getValue(), price.getValue());
					}
				} 

			}
			if (type == 2) {
				if(sushitype == 1) {
					if(platetype == 1) {
						Sushi temp = new Nigiri(Nigiri.NigiriType.CRAB);
						makeRedPlateRequest(temp, nearest.getValue());
					}
					if(platetype == 2) {
						Sushi temp = new Nigiri(Nigiri.NigiriType.CRAB);
						makeBluePlateRequest(temp, nearest.getValue());
					}
					if(platetype == 3) {
						Sushi temp = new Nigiri(Nigiri.NigiriType.CRAB);
						makeGreenPlateRequest(temp, nearest.getValue());
					}
					if(platetype == 4) {
						Sushi temp = new Nigiri(Nigiri.NigiriType.CRAB);
						makeGoldPlateRequest(temp, nearest.getValue(), price.getValue());
					}
				} 
				if(sushitype == 2) {
					if(platetype == 1) {
						Sushi temp = new Nigiri(Nigiri.NigiriType.SALMON);
						makeRedPlateRequest(temp, nearest.getValue());
					}
					if(platetype == 2) {
						Sushi temp = new Nigiri(Nigiri.NigiriType.SALMON);
						makeGreenPlateRequest(temp, nearest.getValue());
					}
					if(platetype == 3) {
						Sushi temp = new Nigiri(Nigiri.NigiriType.SALMON);
						makeBluePlateRequest(temp, nearest.getValue());
					}
					if(platetype == 4) {
						Sushi temp = new Nigiri(Nigiri.NigiriType.SALMON);
						makeGoldPlateRequest(temp, nearest.getValue(), price.getValue());
					}
				} 
				if(sushitype == 3) {
					if(platetype == 1) {
						Sushi temp = new Nigiri(Nigiri.NigiriType.TUNA);
						makeRedPlateRequest(temp, nearest.getValue());
					}
					if(platetype == 2) {
						Sushi temp = new Nigiri(Nigiri.NigiriType.TUNA);
						makeBluePlateRequest(temp, nearest.getValue());
					}
					if(platetype == 3) {
						Sushi temp = new Nigiri(Nigiri.NigiriType.TUNA);
						makeGreenPlateRequest(temp, nearest.getValue());
					}
					if(platetype == 4) {
						Sushi temp = new Nigiri(Nigiri.NigiriType.TUNA);
						makeGoldPlateRequest(temp, nearest.getValue(), price.getValue());
					}
				} 
				if(sushitype == 4) {
					if(platetype == 1) {
						Sushi temp = new Nigiri(Nigiri.NigiriType.SHRIMP);
						makeRedPlateRequest(temp, nearest.getValue());
					}
					if(platetype == 2) {
						Sushi temp = new Nigiri(Nigiri.NigiriType.SHRIMP);
						makeBluePlateRequest(temp, nearest.getValue());
					}
					if(platetype == 3) {
						Sushi temp = new Nigiri(Nigiri.NigiriType.SHRIMP);
						makeGreenPlateRequest(temp, nearest.getValue());
					}
					if(platetype == 4) {
						Sushi temp = new Nigiri(Nigiri.NigiriType.SHRIMP);
						makeGoldPlateRequest(temp, nearest.getValue(), price.getValue());
					}
				} 
				if(sushitype == 5) {
					if(platetype == 1) {
						Sushi temp = new Nigiri(Nigiri.NigiriType.EEL);
						makeRedPlateRequest(temp, nearest.getValue());
					}
					if(platetype == 2) {
						Sushi temp = new Nigiri(Nigiri.NigiriType.EEL);
						makeBluePlateRequest(temp, nearest.getValue());
					}
					if(platetype == 3) {
						Sushi temp = new Nigiri(Nigiri.NigiriType.EEL);
						makeGreenPlateRequest(temp, nearest.getValue());
					}
					if(platetype == 4) {
						Sushi temp = new Nigiri(Nigiri.NigiriType.EEL);
						makeGoldPlateRequest(temp, nearest.getValue(), price.getValue());
					}
				} 
				
			} 
			if (type == 3) {
				if(platetype == 1) {
					makeRedPlateRequest( rolly, nearest.getValue());
				}
				if(platetype == 2) {
					makeBluePlateRequest( rolly , nearest.getValue());
				}
				if(platetype == 3) {
					makeGreenPlateRequest( rolly , nearest.getValue());
				}
				if(platetype == 4) {
					makeGoldPlateRequest( rolly, nearest.getValue(), price.getValue());
				}
			}
			sashimi_button.setVisible(true);
			nigiri_button.setVisible(true);
			roll_button.setVisible(true);
			
			if(nearest != null) {
				nearest.setVisible(false);
			}

			if(create != null) {
				create.setVisible(false);
			}
			if(price != null) {
				price.setVisible(false);
			}
			if(pricelabel != null) {
				pricelabel.setVisible(false);
			}
			if(nearestto != null) {
				nearestto.setVisible(false);
			}
			
		}
	}

	@Override
	public void changed(ObservableValue<?> arg0, Object arg1, Object arg2) {

	}	
}

