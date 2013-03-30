package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Histograma;

public class HistogramaListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Histograma h = new Histograma();
		h.setVisible(true);
	}

}
