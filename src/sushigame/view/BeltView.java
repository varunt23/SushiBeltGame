package sushigame.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import sushi.Plate;
import sushigame.model.Belt;
import sushigame.model.BeltEvent;
import sushigame.model.BeltObserver;

public class BeltView extends JPanel implements BeltObserver, ActionListener {

	private Belt belt;
	private JLabel[] belt_labels;
	private JButton[] buttons;
	private TextField text = new TextField(100);
	
	public BeltView(Belt b) {
		this.belt = b;
		belt.registerBeltObserver(this);
		setLayout(new GridLayout(belt.getSize(), 1));
		belt_labels = new JLabel[belt.getSize()];
		buttons = new JButton[belt.getSize()];
		for (int i = 0; i < belt.getSize(); i++) {
			JLabel plabel = new JLabel("");
			plabel.setMinimumSize(new Dimension(300, 20));
			plabel.setPreferredSize(new Dimension(300, 20));
			plabel.setOpaque(true);
			plabel.setBackground(Color.CYAN);
			add(plabel);
			belt_labels[i] = plabel;
			JButton but = new JButton("");
			but.setSize(100, 20);
		//	but.setVisible(false);
			but.setText("Info");
			buttons[i] = but;
			but.addActionListener(this);
			plabel.add(but);
		}
		refresh();
	}

	@Override
	public void handleBeltEvent(BeltEvent e) {	
		refresh();
	}

	private void refresh() {
		for (int i=0; i<belt.getSize(); i++) {
			Plate p = belt.getPlateAtPosition(i);
			JLabel plabel = belt_labels[i];
			
			if (p == null) {
				plabel.setText(""+i);
				plabel.setBackground(Color.GRAY);
				buttons[i].setVisible(false);
			} else {
				plabel.setText("            " + p.toString());
				switch (p.getColor()) {
				case RED:
					buttons[i].setVisible(true);
					plabel.setBackground(Color.RED); break;
				case GREEN:
					buttons[i].setVisible(true);
					plabel.setBackground(Color.GREEN); break;
				case BLUE:
					buttons[i].setVisible(true);
					plabel.setBackground(Color.BLUE); break;
				case GOLD:
					buttons[i].setVisible(true);
					plabel.setBackground(Color.YELLOW); break;
				}
			}
		}
	}

	public void actionPerformed(ActionEvent arg0) {

		for(int i = 0; i < belt.getSize() ; i++) {
			Plate p = belt.getPlateAtPosition(i);
			if (!(p == null)) {
				if(arg0.getSource().equals(buttons[i])) {
					PlateInfo plateinfo = new PlateInfo(belt, i);
				}
			}
		}
	}
}
