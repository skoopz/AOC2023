package util.gui;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LineChart extends JFrame {

    private JFreeChart lineChart;

    public void generate(ArrayList<Long> array) {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (int i = 0; i < array.size(); i++) {
            dataset.addValue(array.get(i), "Value", "Element " + (i + 1));
        }

        lineChart = ChartFactory.createLineChart(
                "Array Values",
                "Element",
                "Value",
                dataset,
                PlotOrientation.VERTICAL,
                false, true, false);

        // Customizations
        lineChart.setBackgroundPaint(Color.lightGray);
        lineChart.setTitle("Runtime comparison");
        BarRenderer renderer = (BarRenderer) lineChart.getCategoryPlot().getRenderer();
        renderer.setSeriesPaint(0, Color.blue);

        ChartPanel chartPanel = new ChartPanel(lineChart);
        setContentPane(chartPanel);
        pack();
        setVisible(true);

    }

    public void close() {
        this.dispose();
    }

}
