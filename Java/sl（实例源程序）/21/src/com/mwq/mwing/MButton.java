package com.mwq.mwing;

import java.awt.Insets;

import javax.swing.JButton;

public class MButton extends JButton {
    /**
     * 
     */
    private static final long serialVersionUID = 5677833057913201022L;
    
    public MButton() {
        setContentAreaFilled(false);
        setMargin(new Insets(0, 0, 0, 0));
        setBorderPainted(false);
        setFocusPainted(false);
    }
}
