package com.fssa.rishi.utils;

import java.util.logging.Logger;

import java.util.logging.*;

public class ErrorLibraury {
    public static void main(String[] args) {
        LogManager.getLogManager().reset(); // Clear default configuration

        Logger logger = Logger.getLogger(ErrorLibraury.class.getName());

        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL); // Display all log levels
        logger.addHandler(consoleHandler);

        logger.setLevel(Level.ALL); // Set logger level to ALL

        logger.info("Info message.");
        logger.log(Level.FINE, "Debug message.");
        logger.log(Level.SEVERE, "Error message.");
    }
} 

