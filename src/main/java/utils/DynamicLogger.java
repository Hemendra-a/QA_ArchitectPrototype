package utils;

import Reader.PropertiesReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.builder.api.AppenderComponentBuilder;
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilder;
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilderFactory;
import org.apache.logging.log4j.core.config.builder.api.LayoutComponentBuilder;
import org.apache.logging.log4j.core.config.builder.impl.BuiltConfiguration;
import org.apache.logging.log4j.Level;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DynamicLogger {

    /**
     * Configures a logger with dynamic class name and batch number.
     *
     * @param batchNumber Batch number for the log file name.
     * @param dateTime    Current date-time for the log file name.
     * @return Logger instance configured for the calling class.
     */
    public static Logger configureLogger(String batchNumber, String insurer, LocalDateTime dateTime) {
        // Dynamically get the calling class name by scanning the stack trace.
        String className = getCallingClassName();

        // Extract date for directory
        LocalDate date = dateTime.toLocalDate();
        String dateStr = date.toString();

        // Create date-specific log directory
        String logDirectory = "logs/" + insurer + "/" + dateStr;
        try {
            Files.createDirectories(Paths.get(logDirectory));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to create log directory: " + logDirectory);
        }

        ConfigurationBuilder<BuiltConfiguration> builder = ConfigurationBuilderFactory.newConfigurationBuilder();

        // Console Appender
        AppenderComponentBuilder consoleAppender = builder.newAppender("Console", "CONSOLE")
                .addAttribute("target", "SYSTEM_OUT");
        LayoutComponentBuilder consoleLayout = builder.newLayout("PatternLayout")
                .addAttribute("pattern", "%d{yyyy-MM-dd HH:mm:ss.SSS} %-5p %C{1}.%M:%L - %msg%n");
        consoleAppender.add(consoleLayout);
        builder.add(consoleAppender);

        // File Appender
        AppenderComponentBuilder fileAppender = builder.newAppender("File", "FILE")
                .addAttribute("fileName", logDirectory + "/" + className + "_batch" + batchNumber + ".log")
                .addAttribute("append", true);
        LayoutComponentBuilder fileLayout = builder.newLayout("PatternLayout")
                .addAttribute("pattern", "%d{yyyy-MM-dd HH:mm:ss.SSS} %-5p %C{1}.%M:%L - %msg%n");
        fileAppender.add(fileLayout);
        builder.add(fileAppender);

        // Root Logger
        builder.add(builder.newRootLogger("debug")
                .add(builder.newAppenderRef("Console"))
                .add(builder.newAppenderRef("File")));

        LoggerContext ctx = Configurator.initialize(builder.build());
        return LogManager.getLogger(className);
    }


    /**
     * Finds the calling class name by analyzing the stack trace.
     *
     * @return The name of the calling class.
     */
    private static String getCallingClassName() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        for (StackTraceElement element : stackTrace) {
            if (!element.getClassName().equals(DynamicLogger.class.getName())) {
                return element.getClassName();
            }
        }
        return DynamicLogger.class.getName(); // Fallback to this class name if no other class is found.
    }


}