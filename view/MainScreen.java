package view;

import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import model.Imagem;
import controller.HistogramaListener;
import controller.ImagemInformation;
import controller.ItemImageListener;

@SuppressWarnings("serial")
public class MainScreen extends JFrame {
	
	ImagemInformation informacoes;
	private int width;
	private int height;
	
	private Container container;
	
	public MainScreen()
	{
		informacoes = ImagemInformation.getInstance();
		width 		= Imagem.getBufferedImage().getWidth();
		height 		= Imagem.getBufferedImage().getHeight();

		init();

		
		buildLabelInformation();

		buildActionButtons(); 

		buildMainImage();
		
		container.repaint();
	}


	private void init()
	{
		setTitle("Informações da Lena");
		setBounds(0, 0, 800, 512);
		
		setLayout(null);

		setLocationRelativeTo(null);

		setResizable( false );
		setVisible( true );
		setDefaultCloseOperation( EXIT_ON_CLOSE );

		container = getContentPane();
	}
	
	private void buildMainImage()
	{

		JLabel mainImageContent = new JLabel(new ImageIcon( Imagem.getBufferedImage() ));
		mainImageContent.setBounds(0, 0, width, height);

		container.add( mainImageContent );
	}

	
	private void buildLabelInformation() 
	{
		JLabel lblLargura = new JLabel("Dimensões: ");
		lblLargura.setBounds(520, 10, 250, 15);
		lblLargura.setLayout(null);

		JLabel lblLarguraCont = new JLabel( String.valueOf(width) + "px x " + String.valueOf(height) + "px" );
		lblLarguraCont.setBounds(520, 25, 250, 15);
		lblLarguraCont.setLayout(null);


		JLabel lblMedia = new JLabel("Média: ");
		lblMedia.setBounds(520, 50, 250, 15);
		
		JLabel lblMediaCont = new JLabel( String.valueOf( informacoes.getMedia() ) );
		lblMediaCont.setBounds(520, 65, 250, 15);
		
		
		JLabel lblMediana = new JLabel("Mediana: ");
		lblMediana.setBounds(520, 90, 250, 15);

		JLabel lblMedianaCont = new JLabel( String.valueOf( informacoes.getMediana() ) );
		lblMedianaCont.setBounds(520, 105, 250, 15);
		
		
		JLabel lblVariancia = new JLabel("Variância: ");
		lblVariancia.setBounds(520, 130, 250, 15);
		
		JLabel lblVarianciaCont = new JLabel( String.valueOf( informacoes.getVariancia() ) );
		lblVarianciaCont.setBounds(520, 145, 250, 15);
		

		JLabel lblPixelsMenor50 = new JLabel("Qtde. de Pixels Menor que 50: ");
		lblPixelsMenor50.setBounds(520, 170, 250, 15);
		
		JLabel lblPixelsMenor50Cont = new JLabel( String.valueOf( informacoes.getCountPixelsLessThan(50) ) );
		lblPixelsMenor50Cont.setBounds(520, 185, 250, 15);
		
		JLabel lblPixelsMaior200 = new JLabel("Qtde. de Pixels Maior que 200: ");
		lblPixelsMaior200.setBounds(520, 210, 250, 15);
		
		JLabel lblPixelsMaior200Cont = new JLabel( String.valueOf( informacoes.getCountPixelsGreaterThan(200) ) );
		lblPixelsMaior200Cont.setBounds(520, 225, 250, 15);

		JLabel lblModa = new JLabel("Moda: ");
		lblModa.setBounds(520, 245, 250, 15);
		
		JLabel lblModaCont = new JLabel( String.valueOf( informacoes.getModa() ) );
		lblModaCont.setBounds(520, 260, 250, 15);


		container.add(lblLargura);
		container.add(lblLarguraCont);

		container.add(lblMedia);
		container.add(lblMediaCont);

		container.add(lblMediana);
		container.add(lblMedianaCont);

		container.add(lblVariancia);
		container.add(lblVarianciaCont);
		
		container.add(lblModa);
		container.add(lblModaCont);
		
		container.add(lblPixelsMenor50);
		container.add(lblPixelsMenor50Cont);

		container.add(lblPixelsMaior200);
		container.add(lblPixelsMaior200Cont); 

	}
	

	private void buildActionButtons()
	{
		
		JButton btHistograma = new JButton("Ver Histograma");
		btHistograma.setBounds(520, 310, 270, 30);
		btHistograma.addActionListener(new HistogramaListener());
		container.add(btHistograma);

		JButton btA = new JButton("Média");
		btA.setBounds(520, 340, 270, 30);
		btA.addActionListener(new ItemImageListener(1));
		container.add(btA);

		JButton btB = new JButton("Moda");
		btB.setBounds(520, 370, 270, 30);
		btB.addActionListener(new ItemImageListener(2));
		container.add(btB);

		JButton btC = new JButton("Mediana");
		btC.setBounds(520, 400, 270, 30);
		btC.addActionListener(new ItemImageListener(3));
		container.add(btC);

		JButton btD = new JButton("Imagem mais escura");
		btD.setBounds(520, 430, 270, 30);
		btD.addActionListener(new ItemImageListener(4));
		container.add(btD);

		JButton btE = new JButton("PB");
		btE.setBounds(520, 460, 270, 30);
		btE.addActionListener(new ItemImageListener(5));
		container.add(btE);

		
	}
}
