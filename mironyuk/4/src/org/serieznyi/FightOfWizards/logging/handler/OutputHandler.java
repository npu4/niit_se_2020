package org.serieznyi.FightOfWizards.logging.handler;

import org.serieznyi.FightOfWizards.logging.Handler;

public class OutputHandler implements Handler {
    private static class Ansi
    {
        public static final String RED = "\u001B[0;31m";
        public static final String GREEN = "\u001B[0;32m";
        public static final String YELLOW = "\u001B[0;33m";
        public static final String BLUE = "\u001B[0;34m";
        public static final String MAGENTA = "\u001B[0;35m";
        public static final String CYAN = "\u001B[0;36m";
        public static final String WHITE = "\u001B[0;97m";
        public static final String GRAY = "\u001B[0;37m";
        public static final String ANSI_NORMAL = "\u001b[0m";

        public static String green(String message) {
            return GREEN + message + ANSI_NORMAL;
        }

        public static String orange(String message) {
            return YELLOW + message + ANSI_NORMAL;
        }

        public static String red(String message) {
            return RED + message + ANSI_NORMAL;
        }

        public static String gray(String message) {
            return GRAY + message + ANSI_NORMAL;
        }

        public static String white(String message) {
            return WHITE + message + ANSI_NORMAL;
        }

        public static String none(String message) {
            return message;
        }
    }

    @Override
    public void success(String message) {
        System.out.println(Ansi.green(message));
    }

    @Override
    public void warning(String message) {
        System.out.println(Ansi.orange(message));
    }

    @Override
    public void dangerous(String message) {
        System.out.println(Ansi.red(message));
    }

    @Override
    public void info(String message) {
        System.out.println(Ansi.none(message));
    }

    @Override
    public void debug(String message) {
        System.out.println(Ansi.gray(message));
    }
}
