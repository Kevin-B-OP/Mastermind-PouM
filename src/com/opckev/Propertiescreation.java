package com.opckev;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Propertiescreation {

    public static void main(int[] args) {
        try {
            FileOutputStream output = new FileOutputStream("config.properties");

            try {
                Properties prop = new Properties();
                prop.setProperty("nbcasesP", "4");
                prop.setProperty("nbtries", "5");
                prop.setProperty("maxcasesM", "10");
                prop.setProperty("mincasesM","4");
                prop.store(output, (String)null);
                System.out.println(prop);
            } catch (Throwable var5) {
                try {
                    output.close();
                } catch (Throwable var4) {
                    var5.addSuppressed(var4);
                }

                throw var5;
            }

            output.close();
        } catch (IOException var6) {
            var6.printStackTrace();
        }

    }
}

