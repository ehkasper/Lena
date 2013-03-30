package view;

import java.awt.Color;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import model.Imagem;

@SuppressWarnings("serial")
public class ImagensAlteradas extends JFrame {
//	http://www.guj.com.br/java/80358-escrever-em-imagem-jpg-resolvido  
	
	Container container;
	
	public ImagensAlteradas()
	{
		// configurações da janela
		
		setTitle("Imagem processada");
		setBounds(0, 0, Imagem.getBufferedImage().getWidth(), Imagem.getBufferedImage().getHeight());
		setLayout(null);

		setLocationRelativeTo(null); // dizendo que a janela deve ficar centralizada
		
		setResizable( false );
		setVisible( true );

		container = getContentPane();
		container.setBackground( Color.WHITE );
		
		// Fim configurações da janela
		
	}
	
	public void setImage(ImageIcon imagem)
	{
		JLabel lblImage = new JLabel(imagem);
		lblImage.setBounds(0, 0, Imagem.getBufferedImage().getWidth(), Imagem.getBufferedImage().getHeight());
		
		container.add(lblImage);
		
	}
}
