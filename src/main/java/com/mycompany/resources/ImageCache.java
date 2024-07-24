package com.mycompany.resources;

import java.awt.Image;
import java.net.URL;
import java.util.concurrent.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingWorker;

public class ImageCache {

    private final ConcurrentHashMap<String, ImageIcon> cache = new ConcurrentHashMap<>();

    public ImageIcon getImage(String url) {
        return cache.get(url);
    }

    public void loadImage(String url, JLabel label) {
        ImageIcon cachedImage = cache.get(url);
        if (cachedImage != null) {
            label.setIcon(cachedImage);
        } else {
            new SwingWorker<ImageIcon, Void>() {
                @Override
                protected ImageIcon doInBackground() {
                    try {
                        ImageIcon imageIcon = new ImageIcon(new URL(url));
                        Image image = imageIcon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
                        return new ImageIcon(image);
                    } catch (Exception e) {
                        return null;
                    }
                }

                @Override
                protected void done() {
                    try {
                        ImageIcon imageIcon = get();
                        if (imageIcon != null) {
                            cache.put(url, imageIcon);
                            label.setIcon(imageIcon);
                        } else {
                            label.setText("Imagem inválida");
                            label.setIcon(null); // Opcional: definir um ícone padrão de erro
                        }
                    } catch (Exception e) {
                        label.setText("Erro ao carregar imagem");
                        label.setIcon(null); // Opcional: definir um ícone padrão de erro
                    }
                }
            }.execute();
        }
    }
}
