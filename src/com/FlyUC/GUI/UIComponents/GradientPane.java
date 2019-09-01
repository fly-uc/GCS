package com.FlyUC.GUI.UIComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;

public class GradientPane extends JComponent {
    private double height;
    private double width;
    private Color startColor;
    private Color endColor;
    private int originX;
    private int originY;
    private float[] gradientDistribution;

    public GradientPane(Color color1, Color color2 ){
        this.height = 50; //this.getRootPane().getHeight();
        this.width = 50;//this.getRootPane().getWidth();
        this.startColor = color1;
        this.endColor = color2;
        this.originX = 20;
        this.originY = 20;
        this.setBackground(Color.black);
        this.gradientDistribution = new float[]{0.05f,.95f};
    }

    public void setWidth(double x){
        this.width = x;
    }

    public void setHeight(double y){
        this.height = y;
    }

    public void setOriginX(int x){
        this.originX = x;
    }

    public void setOriginY(int y){
        this.originY = y;
    }

    public void setGradientDistribution(float weight1, float weight2){
        this.gradientDistribution = new float[]{weight1, weight2};
    }

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);

        Color[] colors = {this.startColor,this.endColor};
        Point2D origin = new Point(this.originX,this.originY);
        Point2D focus = new Point(this.getWidth()/3,this.getHeight()/3);

        RadialGradientPaint backGroundGradient = new RadialGradientPaint(origin,
                (float)(3*Math.sqrt(this.width*this.width + this.height*this.height)/4),
                focus,this.gradientDistribution,colors,MultipleGradientPaint.CycleMethod.NO_CYCLE);

        g2.setColor(Color.black);
        g2.fillRect(0,0,(int)this.getRootPane().getWidth(),(int)this.getRootPane().getHeight());
        g2.setPaint(backGroundGradient);

        g2.fillRoundRect(0, 0, (int)this.getRootPane().getWidth(), this.getRootPane().getHeight(),
                40,40);
    }
}
