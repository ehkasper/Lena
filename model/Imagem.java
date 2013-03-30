package model;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Imagem {

	private static BufferedImage bufferedImage;
	
	public static BufferedImage getBufferedImage()
	{
		
		if (bufferedImage != null)
		{
			return bufferedImage;
		}
		
		try {
			bufferedImage = ImageIO.read( Imagem.class.getClassLoader().getResourceAsStream("img/lena.bmp") );

		} catch( IOException e ) {
			System.out.println(e.getMessage());
		}
		
		return bufferedImage;
	}

	
}
