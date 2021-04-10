package de.starvalcity.system.generations;

import de.starvalcity.system.basepackage.Core;
import de.starvalcity.system.files.TimerConfiguration;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.scheduler.BukkitRunnable;

public class Timer {

    private boolean isRunning;
    private int time;

    public Timer() {
        FileConfiguration timerConfiguration = TimerConfiguration.getFile();
        this.isRunning = false;

        if (timerConfiguration.contains("timer.idn_recreation_time")) {
            this.time = timerConfiguration.getInt("timer.idn_recreation_time");
        } else {
            this.time = 0;
        }

        run();

    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void saveTimer() {
        FileConfiguration timerConfiguration = TimerConfiguration.getFile();
        timerConfiguration.set("timer.idn_recreation_time", time);
    }

    private void run() {
        new BukkitRunnable() {
            @Override
            public void run() {
                if (!isRunning()) {
                    return;
                }
                setTime(getTime() + 1);
            }
        }.runTaskTimer(Core.getPlugin(), 20, 20);
    }
}
