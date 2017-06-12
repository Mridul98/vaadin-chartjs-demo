package com.byteowls.vaadin.chartjs.demo.ui.charts;

import com.byteowls.vaadin.chartjs.ChartJs;
import com.byteowls.vaadin.chartjs.config.LineChartConfig;
import com.byteowls.vaadin.chartjs.data.LineDataset;
import com.byteowls.vaadin.chartjs.demo.ui.AbstractChartView;
import com.byteowls.vaadin.chartjs.demo.ui.DemoUtils;
import com.byteowls.vaadin.chartjs.options.InteractionMode;
import com.byteowls.vaadin.chartjs.options.Tooltips.PositionMode;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Component;

@UIScope
@SpringView
public class TooltipBorderChartView extends AbstractChartView {

    private static final long serialVersionUID = -1977315515493155463L;

    @Override
    public Component getChart() {
        LineChartConfig config = new LineChartConfig();
        config.data()
            .labels("January", "February", "March", "April", "May", "June", "July")
            .addDataset(new LineDataset().label("Dataset")
                .borderColor(DemoUtils.RGB_RED)
                .backgroundColor(DemoUtils.RGB_RED)
                .data(10d, 30d, 46d, 2d, 8d, 50d, 0d)
                .fill(false))
            .and()
            .options()
                .responsive(true)
                .title()
                    .display(true)
                    .text("Sample tooltip with border")
                .and()
                    .tooltips()
                        .position(PositionMode.NEAREST)
                        .mode(InteractionMode.INDEX)
                        .intersect(false)
                        .yPadding(10)
                        .xPadding(10)
                        .caretSize(8)
                        .caretPadding(10)
                        .backgroundColor("rgba(72, 241, 12, 1)")
                        .titleFontColor(DemoUtils.RGB_BLACK)
                        .bodyFontColor(DemoUtils.RGB_BLACK)
                        .borderColor("rgba(0,0,0,1)")
                        .borderWidth(4)
                    .and()
            .done();

        ChartJs chart = new ChartJs(config);
        chart.addStyleName("chart-container");
        chart.setJsLoggingEnabled(true);
        //chart.setWidth(500, Unit.PIXELS);

        return chart;
    }

}
