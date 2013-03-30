package view;

import java.awt.event.WindowEvent;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import controller.ImagemInformation;

@SuppressWarnings("serial")
public class Histograma extends ApplicationFrame {

	ImagemInformation information;
	
	public Histograma() {
		
		super("Histograma da Lena");
		
		information = ImagemInformation.getInstance();
		
		final JFreeChart chart = createChart();

		final ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(800, 500));
		
		setContentPane(chartPanel);
		
		this.pack();
		RefineryUtilities.centerFrameOnScreen(this);
	}



	private JFreeChart createChart() 
	{
		HistogramDataset dataset = new HistogramDataset();
		
		dataset.addSeries("Pixels", information.getImageInline(), 256,0.0,256.0);

        JFreeChart chart = ChartFactory.createHistogram(
	        "Histograma", // chart title
	        "Pixels", // domain axis label
	        "Quantidade", // range axis label
	        dataset, // data
	        PlotOrientation.VERTICAL, // orientation
	        false, // include legend
	        false, // tooltips?
	        false // URLs?
        );
        return chart;
	        
	}

	public void windowClosing(final WindowEvent evt)
	{
		if(evt.getWindow() == this)
		{
			dispose();
		}
	}

}