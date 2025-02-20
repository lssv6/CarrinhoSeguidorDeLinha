package br.ufpa.eletro.monitor;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;

public class DynamicChart{
    private JFreeChart chart;
    private CategoryDataset categoryDataset;

    public DynamicChart(String title, String categoryAxisLabel, String valueAxisLabel,CategoryDataset categoryDataset){
        this.categoryDataset = categoryDataset;
        this.chart = ChartFactory.createBarChart(
            title,
            categoryAxisLabel,
            valueAxisLabel,
            categoryDataset
        );
    }

    public static DynamicChart createDefaultDynamicChart(CategoryDataset categoryDataset){
        String title = "Valores dos sensores";
        String categoryAxisLabel = "Sensor";
        String valueAxisLabel = "Valor";
        return new DynamicChart(title, categoryAxisLabel, valueAxisLabel, categoryDataset);
    }

    public JFreeChart getChart(){return chart;}

    public CategoryDataset getCategoryDataset(){
        return categoryDataset;
    }
}
