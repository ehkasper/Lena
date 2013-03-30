package controller;

import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

import view.ImagensAlteradas;

import model.Imagem;

public class ImagemProcessada {
	BufferedImage imagem;
	ImagemInformation informacoes;

	
	public ImagemProcessada(int index)
	{

		imagem  	= Imagem.getBufferedImage();
		informacoes = ImagemInformation.getInstance();

		Color pixel;
		BufferedImage bufferImage = new BufferedImage(imagem.getWidth(), imagem.getHeight(), BufferedImage.TYPE_BYTE_GRAY);  

		for( int w = 0; w < imagem.getWidth(); w++ )
		{
			for( int h = 0; h < imagem.getHeight(); h++ )
			{
				switch(index)
				{
					case 1:
						pixel = getImageMoreThanMedia(informacoes.getPixel(w, h));
						break;
					case 2:
						pixel = getImageGreaterOrEqualThanModa(informacoes.getPixel(w, h));
						break;
					case 3:
						pixel = getImageGreaterOrEqualThanMediana(informacoes.getPixel(w, h));
						break;
					case 4:
						pixel = getImageLessThanMedia(informacoes.getPixel(w, h));
						break;
					default:
						pixel = getImageGreaterThenAndLessThan(informacoes.getPixel(w, h));
						
				}
				bufferImage.setRGB(w, h, pixel.getRGB());
			}
		}

		ImagensAlteradas ia = new ImagensAlteradas();
		ia.setImage(new ImageIcon( bufferImage ));
	}
	
	
	// a) Valores maiores ou iguais a média recebem 200
	private Color getImageMoreThanMedia(int pixelValue)
	{
		if(pixelValue >= informacoes.getMedia() )
		{
			return new Color(200, 200, 200);
		}
		else
		{
			return new Color(pixelValue, pixelValue, pixelValue);
		}
		
	}

	
	// b) Valores maiores ou iguais a moda recebem 200
	private Color getImageGreaterOrEqualThanModa( int pixelValue )
	{
		if(pixelValue >= informacoes.getModa() )
		{
			return new Color(200, 200, 200);
		}
		else
		{
			return new Color(pixelValue, pixelValue, pixelValue);
		}
	}

	
	// c) Valores maiores ou iguais a mediana recebem 200.
	private Color getImageGreaterOrEqualThanMediana(int pixelValue)
	{
		if(pixelValue >= informacoes.getMediana() )
		{
			return new Color(200,200,200);
		}
		else
		{
			return new Color(pixelValue, pixelValue, pixelValue);
		}
	}

	
	// d) Valores menores que a média recebem 50.
	private Color getImageLessThanMedia(int pixelValue)
	{

		if(pixelValue < informacoes.getMedia() )
		{
			return new Color(50, 50, 50);
		}
		else
		{
			return new Color(pixelValue, pixelValue, pixelValue);
		}

	}

	
	// e) Valores maiores que a média recebem 255 e menores que a média recebem 0. 
	private Color getImageGreaterThenAndLessThan(int pixelValue)
	{

		if(pixelValue > informacoes.getMedia() )
		{
			return new Color(255, 255, 255);
		}
		else if(pixelValue < informacoes.getMedia())
		{
			return new Color(0, 0, 0);
		}
		else
		{
			return new Color(pixelValue, pixelValue, pixelValue);
		}

	}



	
}
