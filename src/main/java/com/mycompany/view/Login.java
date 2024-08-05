package com.mycompany.view;

import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Lucas
 */
public class Login extends JPanel {

    public Login() {
        init();
    }

    private void init() {
        setLayout(new MigLayout("fill, insets 20", "[center]", "[center]"));
        txtUserName = new JTextField();
        txtPassword = new JPasswordField();
        chRememberMe = new JCheckBox("Lembre de mim");
        cmdLogin = new JButton("Entrar");
        JPanel panel = new JPanel(new MigLayout("wrap,fillx,insets 35 45 30 45", "fill,250:280"));
        panel.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:20;"
                + "[light]background:darken(@background,3%);"
                + "[dark]background:lighten(@background,3%);"
        );

        txtPassword.putClientProperty(FlatClientProperties.STYLE, ""
                + "showRevealButton:true");

        txtUserName.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Enter your user or email");
        txtPassword.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Enter your password");

        JLabel labelTitle = new JLabel("Welcome back!");
        labelTitle.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:bold +10");
        JLabel labelDescription = new JLabel("Faça o login para acessar sua conta");
        labelDescription.putClientProperty(FlatClientProperties.STYLE, ""
                + "[light]foreground:lighten(@foreground,30%);"
                + "[dark]foreground:darken(@foreground,30%);");

        panel.add(labelTitle);
        panel.add(labelDescription);
        panel.add(new JLabel("Username"), "gapy 8");
        panel.add(txtUserName);
        panel.add(new JLabel("Senha"), "gapy 8");
        panel.add(txtPassword);
        panel.add(chRememberMe, "grow 0");
        panel.add(cmdLogin, "gapy 10");
        panel.add(createSignupLable(), "gapy 10");

        add(panel);

    }

    private Component createSignupLable() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
        panel.putClientProperty(FlatClientProperties.STYLE, ""
                + "background:null");
        JButton cmdRegister = new JButton("<html><a href=\"#\">Sign up<a/><html>");
        cmdRegister.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:3,3,3,3");
        cmdRegister.setContentAreaFilled(false);
        cmdRegister.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cmdRegister.addActionListener(e -> {
            System.out.println("Go Sign form");
            // Next update
        });
        
        JLabel label = new JLabel("Don't have an account?");
        label.putClientProperty(FlatClientProperties.STYLE, ""
                + "[light]foreground:lighten(@foreground,30%);"
                + "[dark]foreground:darken(@foreground,30%);");
        
        panel.add(label);
        panel.add(cmdRegister);
        
        return panel;
    }

    private JTextField txtUserName;
    private JPasswordField txtPassword;
    private JCheckBox chRememberMe;
    private JButton cmdLogin;

}
