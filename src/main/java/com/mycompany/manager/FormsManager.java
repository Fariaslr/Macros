package com.mycompany.manager;

import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import com.mycompany.view.Application;
import java.awt.EventQueue;
import javax.swing.JComponent;

/**
 *
 * @author Lucas
 */
public class FormsManager {

    private Application application;
    private static FormsManager instance;

    public static FormsManager getInstance() {
        if (instance == null) {
            instance = new FormsManager();
        }
        return instance;
    }

    public void initApplication(Application application) {
        this.application = application;
    }

    public void showForm(JComponent form) {
        EventQueue.invokeLater(() -> {
            application.setContentPane(form);
            application.revalidate();
            application.repaint();
            FlatAnimatedLafChange.hideSnapshotWithAnimation();
        });
    }
}
