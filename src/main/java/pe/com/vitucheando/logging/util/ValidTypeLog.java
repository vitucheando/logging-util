package pe.com.vitucheando.logging.util;

import java.util.logging.Level;
/**
 * Created by vitucheando on 26/11/2018.
 */
public enum ValidTypeLog {
    MESSAGE(Level.INFO), ERROR(Level.SEVERE), WARNING(Level.WARNING);
    private Level level;

    ValidTypeLog(Level level) {
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }
}
