package com.FlyUC.GUI.UIComponents;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class cImageView extends JComponent {
    private static final boolean IS_HIGH_QUALITY = true;
    private int height;
    private int width;
    private int horizontalMargin;
    private int verticalMargin;
    BufferedImage myImage;
    String imagePath;

    public cImageView(String imageName){
        imageFromFileName(imageName);
        this.horizontalMargin = 0;
    }

    public void imageFromFileName(String imageName){

        this.imagePath =  "/resources/images/"+ imageName; //"src/com/FlyUC/Images/" +
        try{
            this.myImage = ImageIO.read(cImageView.class.getResourceAsStream(this.imagePath));
            this.width = this.myImage.getWidth();
            this.height = this.myImage.getHeight();
        }catch(IOException e){
            System.out.println(e);
        }
    }

    public void imageFromFilePath(String path){
        this.imagePath = path;
        try{
            this.myImage = ImageIO.read(new File(this.imagePath));
            this.width = this.myImage.getWidth();
            this.height = this.myImage.getHeight();
        }catch(IOException e){
            System.out.println(e);
        }
    }

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D)g;

        if(IS_HIGH_QUALITY){
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION,
                    RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
            g2.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_SPEED);
            g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        }
        AffineTransform defaultTransform = g2.getTransform();

        double scaleX =0;
        scaleX = (double)(getWidth() - (2*this.horizontalMargin))/this.myImage.getWidth();
        System.out.println("X total: " + (getWidth()-(2*this.horizontalMargin)) + "Width: " + this.myImage.getWidth());
        double scaleY = 0;

        scaleY = (double)(getHeight() - (2*this.verticalMargin))/this.myImage.getHeight();

        if(this.myImage.getWidth()*scaleY < getWidth() - (2*this.horizontalMargin)){
            if(scaleX <  scaleY) {
                scaleY = scaleX;
            }else{
                scaleX = scaleY;
            }
        }else if(this.myImage.getHeight()*scaleX < getHeight() - (2*this.verticalMargin)){
            if(scaleX >  scaleY) {
                scaleX = scaleY;
            } else{
                scaleY = scaleX;
            }
        }
        //(this.getWidth()/2)-(this.getButtonWidth()/2)
        int centerMarginX = (int)(((getWidth()/2)-(this.myImage.getWidth()*scaleX)/2));
        int centerMarginY = (int)(((getHeight()/2)-(this.myImage.getHeight()*scaleY)/2));
        System.out.println("Scale X: " + scaleX + "Scale Y: " + scaleY);
        AffineTransform at = AffineTransform.getScaleInstance(scaleX,scaleY);
        //g2.setTransform(at);
        //g2.drawImage(this.myImage,this.horizontalMargin,this.verticalMargin,null);
        AffineTransformOp scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
        g2.drawImage(this.myImage,scaleOp,centerMarginX,centerMarginY);
       //g2.setTransform((defaultTransform));
    }
}
