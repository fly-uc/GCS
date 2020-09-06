package com.FlyUC.GUI.UIComponents;

import javax.swing.*;
import java.awt.*;

public class iconButton extends JComponent {
    private static final boolean IS_HIGH_QUALITY = true;
    private int buttonRadius;
    private int horizontalMargin;
    private int verticalMargin;
    private int fontSize;
    private boolean isHovering;
    private boolean isClicked;
    private boolean captionEnabled;
    private String caption;
    private Color primaryColor;
    private Color foreGroundColor;
    private Font buttonFont;
    private int buttonShadow;

    public iconButton(){

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(this.primaryColor);
        g2.setFont(this.buttonFont);
        if (IS_HIGH_QUALITY) {
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION,
                    RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
            g2.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_SPEED);
            g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        }
        if(isHovering){
            if(isClicked) {
                //Clicked
            }else{
                //Hovering, but not clicked
            }
        }else {
            //Normal State for the button
            int startX = (int)((getWidth()/2) - (this.buttonRadius/2));
            int startY = (int)((getHeight()/2) - (this.buttonRadius/2));
        }
    }
}
