package com.rajonweb;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.WatchService;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class UploaderMain {
    public static void main(String[] args) {
        UploaderMain um = new UploaderMain();
        Properties app_config = um.getConfig();
        if (null == app_config) {
            System.out.println("Error reading config");
            return;
        }
        try {
            List<String> watched_dirs = Arrays.asList(app_config.getProperty("watched_dirs").split(":"));


            WatchService watcher = FileSystems.getDefault().newWatchService();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Properties getConfig() {
        Properties app_config = new Properties();
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            app_config.load(classLoader.getResourceAsStream("app.cfg"));
            return app_config;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
