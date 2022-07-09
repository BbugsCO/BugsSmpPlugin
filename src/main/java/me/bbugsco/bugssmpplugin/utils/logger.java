package me.bbugsco.bugssmpplugin.utils;

import me.bbugsco.bugssmpplugin.BugsSmpPlugin;
import org.bukkit.Bukkit;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class logger {

    BugsSmpPlugin plugin;

    public logger(BugsSmpPlugin plugin) {
        this.plugin = plugin;
    }

    public static void logToFile(String filename, String message) {

        try {
            File dataFolder = Bukkit.getServer().getPluginManager().getPlugin("BugsSmpPlugin").getDataFolder();
            if(!dataFolder.exists()) {
                dataFolder.mkdir();
            }

            String logFileName = filename + ".log";
            File saveTo = new File(Bukkit.getServer().getPluginManager().getPlugin("BugsSmpPlugin").getDataFolder(), logFileName);
            if (!saveTo.exists()) {
                saveTo.createNewFile();
            }


            FileWriter fw = new FileWriter(saveTo, true);

            PrintWriter pw = new PrintWriter(fw);

            Date now = new Date();
            SimpleDateFormat format = new SimpleDateFormat("MM-dd HH:mm:ss");
            String time = format.format(now);
            String datemessage = time + " " + message;

            pw.println(datemessage);

            pw.flush();

            pw.close();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }
}