package controller;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.util.Arrays;

import model.Imagem;

public class ImagemInformation {
	
	private int image[][];
	private double histograma[] = new double[256];
	private double imageInline[];
	private int media;
	private double mediana;
	private int moda;
	private int variancia;
	
	private BufferedImage imagem;
	
	private static ImagemInformation self;
	
	public static ImagemInformation getInstance()
	{
		if( self == null )
		{
			self = new ImagemInformation();
		}
		
		return self;
	}
	
	private ImagemInformation()
	{
		imagem 	   = Imagem.getBufferedImage();
		image  	   = new int[imagem.getWidth()][imagem.getHeight()];
		
		buildImage();
		makeHistograma();
		makeMedia();
		makeMediana();
		makeVariancia();
		makeModa();
	}

	private void buildImage()
	{
		imageInline = new double[imagem.getWidth() * imagem.getHeight()];
		int i = 0;
		
		try {
			Raster raster = imagem.getRaster();

			for (int w = 0; w < imagem.getWidth(); w++) 
			{
				for (int h = 0; h < imagem.getHeight(); h++) 
				{
					image[w][h]    = raster.getSample(w, h, 0);

					imageInline[i++] = image[w][h];				
				}
			}

		} catch( Exception e )
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	private void makeHistograma() 
	{
		
		for (int w = 0; w < imagem.getWidth(); w++) 
		{
			for (int h = 0; h < imagem.getHeight(); h++) 
			{
				histograma[image[w][h]]++;
			}
		}

	}


	private void makeMedia() 
	{
		int somaPixels = 0;

		for (int w = 0; w < imagem.getWidth(); w++) 
		{
			for (int h = 0; h < imagem.getHeight(); h++) 
			{
				somaPixels += image[w][h];
			}
		}
		
		media = somaPixels/( imagem.getWidth() * imagem.getHeight() );

	}

	
	private void makeMediana() 
	{
		double arrAux[] = imageInline;
		
		Arrays.sort( arrAux );
		mediana = arrAux[arrAux.length / 2];
	}

	
	public void makeModa() 
	{
		double aux = 0;
		for (int i = 0; i < this.histograma.length; i++) 
		{
			if (this.histograma[i] > aux)
			{
				aux = this.histograma[i];
				this.moda = i;
			}
		}
	}
	
	public void makeVariancia() 
	{
		int s = 0;
		
		for (int i = 0; i < imageInline.length; i++) 
		{
			s += (imageInline[i] - media) * (imageInline[i] - media);
		}
		
		variancia = s / (imagem.getWidth() * imagem.getWidth());
	}	

	
	public int getCountPixelsLessThan(int pixelValue) 
	{
		int s = 0;
		
		for (int i = 0; i < imageInline.length; i++) 
		{
			if( imageInline[i] < pixelValue )
			{
				s++;
			}
		}
		
		return s;
	}	

	
	public int getCountPixelsGreaterThan(int pixelValue) 
	{
		int s = 0;
		
		for (int i = 0; i < imageInline.length; i++) 
		{
			if( imageInline[i] > pixelValue )
			{
				s++;
			}
		}
		
		return s;
	}	

	
	public int getMedia()
	{
		return media;
	}
	
	
	public int getModa()
	{
		return moda;
	}
		
	public double getMediana()
	{
		return mediana;
	}
	
	public int getVariancia()
	{
		return variancia;
	}	
	
	public int[][] getImage()
	{
		return image;
	}
	
	public int getPixel(int x, int y)
	{
		return image[x][y];
	}
	
	public double[] getImageInline()
	{
		return imageInline;
	}

	public double[] getHistograma()
	{
		return histograma;
	}
//	public int getHistograma(int i)
//	{
//		return histograma[i];
//	}


}
