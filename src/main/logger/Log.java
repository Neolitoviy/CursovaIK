package main.logger;

import org.apache.log4j.Logger;

public class Log {
    public static void logInfo(Class<?> clazz, String message){
        Logger logger = Logger.getLogger(clazz);
        logger.info(message);
    }
    public static void logMail(String error){
        Logger.getLogger(Log.class).fatal(error);
    }
}