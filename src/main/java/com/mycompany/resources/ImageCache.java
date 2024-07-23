package com.mycompany.resources;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import javax.swing.ImageIcon;

public class ImageCache {
    private final Map<String, ImageIcon> cache = new HashMap<>();

    public ImageIcon getImage(String url) {
        if (cache.containsKey(url)) {
            return cache.get(url);
        } else {
            try {
                ImageIcon imageIcon = new ImageIcon(new URL(url));
                cache.put(url, imageIcon);
                return imageIcon;
            } catch (MalformedURLException e) {
                return null;
            }
        }
    }
}
