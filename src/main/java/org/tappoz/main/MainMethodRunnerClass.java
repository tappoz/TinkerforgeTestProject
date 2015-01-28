package org.tappoz.main;

import org.tappoz.examples.AmbientLightLCDExample;

public class MainMethodRunnerClass {

    public static void main(String args[]) throws Exception {


        String command = args[0];

        if("light".equalsIgnoreCase(command)) {
            AmbientLightLCDExample.run();
        } else {
            System.out.println("The following command has not been recognized: " + command);
        }

    }
}