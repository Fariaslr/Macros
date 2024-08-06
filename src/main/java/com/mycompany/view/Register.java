package com.mycompany.view;

import com.formdev.flatlaf.FlatClientProperties;
import com.mycompany.manager.FormsManager;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.PopupMenu;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Lucas
 */
public class Register extends JPanel {

    public Register() {
        init();
    }

    private void init() {
        setLayout(new MigLayout("fill,insets 20", "[center]", "[center]"));
        txtFirstName = new JTextField();
        txtLastName = new JTextField();
        txtUserName = new JTextField();
        txtPassword = new JPasswordField();
        txtConfirmPassword = new JPasswordField();
        cmdRegister = new JButton("Cadastrar");

        JPanel panel = new JPanel(new MigLayout("wrap,fillx,insets 35 44 30 45", "[fill,360]"));
        panel.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:20;"
                + "[light]background:darken(@background,3%);"
                + "[dark]background:lighten(@background,3%)");
        
        txtFirstName.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Nome");
        txtLastName.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Sobrenome");
        txtUserName.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Usuario ou email");
        txtPassword.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Senha");
        txtConfirmPassword.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Confirme a senha");
        txtPassword.putClientProperty(FlatClientProperties.STYLE, ""
                + "showRevealButton:true");
        txtConfirmPassword.putClientProperty(FlatClientProperties.STYLE, ""
                + "showRevealButton:true");
        
        cmdRegister.putClientProperty(FlatClientProperties.STYLE, ""
                + "[light]background:darken(@background,10%);"
                + "[dark]background:lighten(@background,10%);"
                + "borderWidth:0;"
                + "focusWidth:0;"
                + "innerFocusWidth:0");
        
        JLabel lbTitle = new JLabel("Bem-vindo ao Macros!");

        lbTitle.putClientProperty(FlatClientProperties.STYLE,
                "font:bold +10");
        JLabel labelDescription = new JLabel("Cadastre-se e acompanhe o seu desempenho, entre e use agora.");

        labelDescription.putClientProperty(FlatClientProperties.STYLE, ""
                + "[light]foreground:lighten(@foreground,30%);"
                + "[dark]foreground:darken(@foreground,30%);");

        panel.add(lbTitle);
        panel.add(labelDescription);
        panel.add(new JLabel("Nome completo"), "gapy 10");
        panel.add(txtFirstName, "split 2");
        panel.add(txtLastName);
        panel.add(new JLabel("Gender"), "gapy 8");
        panel.add(createGenderPanel());
        panel.add(new JSeparator(),"gapy 5 5");
        panel.add(new JLabel("Usuario ou Email"));
        panel.add(txtUserName);
        panel.add(new JLabel("Senha"),"gapy 8");
        panel.add(txtPassword);
        panel.add(new JLabel("Confirmar Senha"),"gapy 8");
        panel.add(txtConfirmPassword);
        panel.add(cmdRegister,"gapy 20");
        panel.add(createLoginLabel(),"gapy 10");
        
        add(panel);
    }

    private JTextField txtFirstName;
    private JTextField txtLastName;
    private JRadioButton jrMale;
    private JRadioButton jrFemale;
    private JTextField txtUserName;
    private JPasswordField txtPassword;
    private JPasswordField txtConfirmPassword;
    private ButtonGroup groupGender;
    private JButton cmdRegister;

    private Component createGenderPanel() {
        JPanel panel = new JPanel(new MigLayout("insets 0"));
        panel.putClientProperty(FlatClientProperties.STYLE, ""
                + "background:null");
        jrMale = new JRadioButton("Masculino");
        jrFemale = new JRadioButton("Feminino");
        groupGender = new ButtonGroup();
        groupGender.add(jrMale);
        groupGender.add(jrFemale);
        panel.add(jrMale);
        panel.add(jrFemale);
        return panel;
    }
    
    private Component createLoginLabel(){
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        panel.putClientProperty(FlatClientProperties.STYLE, "" + "background:null");
        JButton cmdRegister = new JButton("<html><a href=\"#\">Faça o login<a/><html>");
        cmdRegister.putClientProperty(FlatClientProperties.STYLE, "" + "border:3,3,3,3");
        cmdRegister.setContentAreaFilled(false);
        cmdRegister.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cmdRegister.addActionListener(e -> {
            FormsManager.getInstance().showForm(new Login());
        });

        JLabel label = new JLabel("Possui conta?");
        label.putClientProperty(FlatClientProperties.STYLE, ""
                + "[light]foreground:lighten(@foreground,30%);"
                + "[dark]foreground:darken(@foreground,30%);");

        panel.add(label);
        panel.add(cmdRegister);

        return panel;
    }
}
