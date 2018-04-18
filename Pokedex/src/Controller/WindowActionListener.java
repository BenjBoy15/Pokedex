package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Model.PokeList;
import View.*;

public class WindowActionListener implements ActionListener {
	private WindowMaker window;
	private TrainPokemon train = new TrainPokemon();

	public WindowActionListener(WindowMaker window) {
		this.window = window;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// up button
		if (ae.getSource() == window.getAllButtons()[0]) {
			if (window.getList().getFirstVisibleIndex() <= window.getList().getSelectedIndex() - 1) {
				SelectPokemon.selectPokemon(window.getList().getSelectedIndex() - 1);
				window.getList().setSelectedIndex(window.getList().getSelectedIndex() - 1);
				window.refreshView();
			}
		}

		// down button
		if (ae.getSource() == window.getAllButtons()[1]) {
			if (window.getList().getLastVisibleIndex() >= window.getList().getSelectedIndex() + 1) {
				SelectPokemon.selectPokemon(window.getList().getSelectedIndex() + 1);
				window.getList().setSelectedIndex(window.getList().getSelectedIndex() + 1);
				window.refreshView();
			}
		}

		if (ae.getSource() == window.getAllButtons()[2]) {

		}

		// exit button
		if (ae.getSource() == window.getAllButtons()[3]) {
			System.exit(0);
		}
		
		// train Pokemon button
		if (ae.getSource() == window.getAllButtons()[4]) {
			this.train.trainPokemon(window.getList().getSelectedIndex());
			window.refreshView();
		}
	}

}
