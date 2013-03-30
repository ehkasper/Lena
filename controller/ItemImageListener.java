package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ItemImageListener implements ActionListener {

	private int index;
	
	public ItemImageListener(int index)
	{
		this.index = index;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		new ImagemProcessada( index );
		
	}	

	
}
