package sushigame.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Comparator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import sushigame.model.Belt;
import sushigame.model.BeltEvent;
import sushigame.model.BeltObserver;
import sushigame.model.Chef;
import sushigame.model.SushiGameModel;

public class ScoreboardWidget extends JPanel implements BeltObserver, ActionListener {

	private SushiGameModel game_model;
	private JLabel display;
	private JButton but;
	private JButton but1;
	private JButton but2;
	private int type;
	
	public ScoreboardWidget(SushiGameModel gm) {
		game_model = gm;
		game_model.getBelt().registerBeltObserver(this);
		
		display = new JLabel();
		display.setVerticalAlignment(SwingConstants.TOP);
		setLayout(new BorderLayout());
		add(display, BorderLayout.CENTER);
		display.setText(makeScoreboardHTML());
		
		//formation of the first button balance
		JButton but3 = new JButton("");
		but =but3;
		but.setSize(150,50);
		but.setLocation(0,200);
		but.setText("Balance");
		but.addActionListener(this);
		display.add(but);
		//formation of the second button consumed
		JButton but4 = new JButton("");
		but1 =but4;
		but1.setSize(150,50);
		but1.setLocation(0,250); 
		but1.setText("Amount Consumed");
		but1.addActionListener(this);
		display.add(but1);
		//formation of the third button spoiled
		JButton but5 = new JButton("");
		but2 =but5;
		but2.setSize(150,50);
		but2.setLocation(0,300);
		but2.setText("Amount Spoiled");
		display.add(but2);
		but2.addActionListener(this);
		this.type = 0;
	}

	private String makeScoreboardHTML() {
		String sb_html = "<html>";
		sb_html += "<h1>Scoreboard</h1>";

		// Create an array of all chefs and sort by balance.
		Chef[] opponent_chefs= game_model.getOpponentChefs();
		Chef[] chefs = new Chef[opponent_chefs.length+1];
		chefs[0] = game_model.getPlayerChef();
		for (int i=1; i<chefs.length; i++) {
			chefs[i] = opponent_chefs[i-1];
		}
		
		if(type == 1|| type == 0) {
			Arrays.sort(chefs, new HighToLowBalanceComparator());
			for (Chef c : chefs) {
				sb_html += c.getName() + " ($" + Math.round(c.getBalance()*100.0)/100.0 + ") <br>";
			}
		} else if ( type == 2) {
			Arrays.sort( chefs, new HighToLowConsumedComparator2());
			for (Chef c : chefs) {
				sb_html += c.getName() + " (" + Math.round(c.getConsumed()*100.0)/100.0 + " oz) <br>";
			}
		} else if (type == 3) {
			Arrays.sort( chefs, new HighToLowSpoiledComparator());
			for (Chef c : chefs) {
				sb_html += c.getName() + " (" + Math.round(c.getSpoiled()*100.0)/100.0 + " oz) <br>";
			}
		}
	
		
		sb_html += "<h3>Sort by:<h3>";
		//type = 0;
		return sb_html;
	}
	

	public void refresh() {
		display.setText(makeScoreboardHTML());		
	}
	
	@Override
	public void handleBeltEvent(BeltEvent e) {
		if (e.getType() == BeltEvent.EventType.ROTATE) {
			refresh();
		}		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getSource().equals(but)) {
			type = 1;
		} 
		if ( arg0.getSource().equals(but1)) {
			type = 2;
		} 
		if (arg0.getSource().equals(but2)) {
			type = 3;
		}
		//makeScoreboardHTML();
		refresh();
	}

}
