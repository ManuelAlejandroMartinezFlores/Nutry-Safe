import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * Genera un JFrame con un diagrama de barras con el histórico de calorías consumidas y objetivo.
 */
public class BarChart extends JFrame {

  private static final long serialVersionUID = 1L;

  public BarChart(String id) {
    super();

    // Create Dataset
    CategoryDataset dataset = createDataset(MongoDB.getHist(id));

    //Create chart
    JFreeChart chart=ChartFactory.createBarChart(
        "Histórico de calorias", //Chart Title
        "Día", // Category axis
        "Calorias", // Value axis
        dataset,
        PlotOrientation.VERTICAL,
        true,true,false
       );

    ChartPanel panel=new ChartPanel(chart);
    setContentPane(panel);
  }

  private CategoryDataset createDataset(Object[] data) {
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    HashMap<String, Integer> con_hist = (HashMap<String, Integer>) data[0];
    HashMap<String, Integer> obj_hist = (HashMap<String, Integer>) data[1];

    List<String> keys = new ArrayList<String>();

    for (String k : con_hist.keySet()){
      keys.add(k);
    }

    Collections.sort(keys);

    for (String k : keys){
        dataset.addValue(con_hist.get(k), "Calorias consumidas", k);
    }
    for (String k : keys){
      dataset.addValue(obj_hist.get(k), "Calorias objetivo", k);
  }

    return dataset;
  }

}
