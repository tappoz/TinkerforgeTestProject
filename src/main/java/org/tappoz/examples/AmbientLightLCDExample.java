package org.tappoz.examples;

import com.tinkerforge.*;

import java.io.IOException;

public class AmbientLightLCDExample {

    private static final String HOST = "localhost";
    private static final int PORT = 4223;
    private static final String UID_BRICKLET_AMBIENT_LIGHT = "maT"; // Change to your UID according to Brick Viewer
    private static final String UID_BRICKLET_LCD = "odw"; // Change to your UID according to Brick Viewer

    public static void run() throws AlreadyConnectedException, IOException, TimeoutException, NotConnectedException {

        IPConnection ipcon = new IPConnection(); // Create IP connection

        BrickletAmbientLight al = new BrickletAmbientLight(UID_BRICKLET_AMBIENT_LIGHT, ipcon); // Create device object
        BrickletLCD20x4 lcd = new BrickletLCD20x4(UID_BRICKLET_LCD, ipcon); // Create device object

        ipcon.connect(HOST, PORT); // Connect to brickd
        // Don't use device before ipcon is connected

        // Get current illuminance (unit is Lux/10)
        int illuminance = al.getIlluminance(); // Can throw com.tinkerforge.TimeoutException

        String illuminanceMessage = "Illuminance: " + illuminance/10.0 + " Lux";

        // Turn LCD backlight on
        lcd.backlightOn();

        // Write to the LCD
        lcd.writeLine((short)0, (short)0, illuminanceMessage);
        System.out.println(illuminanceMessage);

        System.out.println("Press key to exit"); System.in.read();

        // Turn LCD backlight off
        lcd.backlightOff();
        System.out.println("LCD Backlight turned off");

        ipcon.disconnect();
        System.out.println("Disconnected");
    }
}
