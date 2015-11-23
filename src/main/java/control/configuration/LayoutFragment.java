package control.configuration;

import analyse.AnalyseType;

/**
 * Created by FRudi on 20.11.2015.
 */
public class LayoutFragment {

    private double xStart;
    private double xEnd;

    private double yStart;
    private double yEnd;

    private AnalyseType type;

    public LayoutFragment(double xStart, double xEnd, double yStart, double yEnd, AnalyseType type) {
        this.xStart = xStart;
        this.xEnd = xEnd;
        this.yStart = yStart;
        this.yEnd = yEnd;
        this.type = type;
    }

    public double getxStart() {
        return xStart;
    }

    public void setxStart(double xStart) {
        this.xStart = xStart;
    }

    public double getxEnd() {
        return xEnd;
    }

    public void setxEnd(double xEnd) {
        this.xEnd = xEnd;
    }

    public double getyStart() {
        return yStart;
    }

    public void setyStart(double yStart) {
        this.yStart = yStart;
    }

    public double getyEnd() {
        return yEnd;
    }

    public void setyEnd(double yEnd) {
        this.yEnd = yEnd;
    }

    public AnalyseType getType() {
        return type;
    }

    public void setType(AnalyseType type) {
        this.type = type;
    }
}
