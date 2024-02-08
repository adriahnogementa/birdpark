package com.birdpark.utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;

import com.birdpark.exception.UtilityException;

public class StackTraceUtilities {
    
   public static void printShortStackTrace(Throwable cause, int maxNumberOfStackLines) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        cause.printStackTrace(writer);
        writer.close();
        String string = stringWriter.getBuffer().toString();
        System.out.println(firstLinesOf(string, maxNumberOfStackLines + 1));
    }

    public static String firstLinesOf(String string, int maxNumberOfLines) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        try {
            BufferedReader reader = new BufferedReader(new StringReader(string));
            String line = null;
            for (int count = 0; (line = reader.readLine()) != null && count < maxNumberOfLines; count++) {
                writer.println(line);
            }
            writer.close();
            return stringWriter.getBuffer().toString();
        } catch (IOException exception) {
            throw new UtilityException("Shortened stacktrace can not be generated", exception);
        }
    }
}
