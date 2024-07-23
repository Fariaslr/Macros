package com.mycompany.resources;

import java.awt.Image;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javax.swing.ImageIcon;

public class ImageCache {

        private final ConcurrentHashMap<String, Future<ImageIcon>> cache = new ConcurrentHashMap<>();
        private final ExecutorService executor = Executors.newCachedThreadPool();

        public ImageIcon getImage(String url) {
            Future<ImageIcon> future = cache.computeIfAbsent(url, this::loadImageAsync);
            try {
                return future.get();
            } catch (InterruptedException | ExecutionException e) {
                cache.remove(url);
                return null;
            }
        }

        private Future<ImageIcon> loadImageAsync(String url) {
            return executor.submit(() -> {
                try {
                    ImageIcon imageIcon = new ImageIcon(new URL(url));
                    Image image = imageIcon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
                    return new ImageIcon(image);
                } catch (Exception e) {
                    return null;
                }
            });
        }
    }
