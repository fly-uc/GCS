package com.FlyUC.GUI;

import com.FlyUC.GUI.UIComponents.GradientPane;
import com.FlyUC.GUI.UIComponents.cButton;
import com.FlyUC.GUI.UIComponents.cImageView;
import com.FlyUC.GUI.UIComponents.cSpacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class splashScreen extends JFrame implements MouseListener {
    Container container;
    cButton btnContinue;
    cImageView flyUcLogo;
    cImageView frontViewCraft;
    GradientPane backgroundGradient;
    public splashScreen(){

        backgroundGradient = new GradientPane(new Color(205, 70, 70),new Color(135, 78, 132));
        container = getContentPane();
        Dimension screenResolution = Toolkit.getDefaultToolkit().getScreenSize();
        backgroundGradient.setHeight(screenResolution.getHeight());
        backgroundGradient.setWidth(screenResolution.getWidth());
        GradientPane layoutManager = backgroundGradient;
        setSize(screenResolution);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setState(Frame.MAXIMIZED_BOTH);
        //setUndecorated(true);
        setVisible(true);
        //layoutManager.setLayout();
        layoutManager.setLayout(new GridBagLayout());
        btnContinue = new cButton("Continue");
        GridBagConstraints c = new GridBagConstraints();
        flyUcLogo = new cImageView("flyuc.png");
        frontViewCraft = new cImageView("perspectiveview.png");
        btnContinue = new cButton("Continue");
        btnContinue.setFontColor(new Color(255, 27, 58));
        btnContinue.setPrimaryColor(new Color(240, 240, 240));
        btnContinue.addMouseListener(this);
        layoutManager.setBackground(Color.black);

        c.gridx = 0;
        c.gridy = 0;
        c.weightx  = 1;

        c.weighty = .4;
        c.fill = GridBagConstraints.BOTH;
       // c.ipady = 50;

        layoutManager.add(flyUcLogo,c);
        //layoutManager.add(flyUcLogo);
        c.gridy = 1;
        c.weighty = .35;
        layoutManager.add(frontViewCraft,c);
        c.weighty = .1;
        c.weightx = 1;
        c.gridy = 2;
        layoutManager.add(btnContinue,c);
        c.weighty = .05;
        c.gridy = 3;
        layoutManager.add(new cSpacer(),c);

        container.add(layoutManager);
    }

    public void mousePressed(MouseEvent e) {
       // this.btnContinue.setIsHovering();
    }

    /* Empty method definition. */
    public void mouseReleased(MouseEvent e) {
     //   this.btnContinue.setIsHovering();
    }

    /* Empty method definition. */
    public void mouseEntered(MouseEvent e) {
        this.btnContinue.setIsHovering();
    }
    /* Empty method definition. */
    public void mouseExited(MouseEvent e) {
        this.btnContinue.setIsHovering();
    }

    public void mouseClicked(MouseEvent e) {
        this.btnContinue.setIsClicked();
    }

}
