Tinkerforge building blocks for IoT (Internet of Things)
========================================================

This project provides a minimum working example of a light sensor connected to an LCD screen to show a number representing the luminosity detected by the sensor.

The building blocks (or __bricks__ and __bricklets__ according to Tinkerforge terminology) are:

 - Master brick [http://www.tinkerforge.com/en/doc/Hardware/Bricks/Master_Brick.html](http://www.tinkerforge.com/en/doc/Hardware/Bricks/Master_Brick.html)
 - Ambient Light bricklet [http://www.tinkerforge.com/en/doc/Hardware/Bricklets/Ambient_Light.html](http://www.tinkerforge.com/en/doc/Hardware/Bricklets/Ambient_Light.html)
 - LCD bricklet [http://www.tinkerforge.com/en/doc/Hardware/Bricklets/LCD_20x4.html](http://www.tinkerforge.com/en/doc/Hardware/Bricklets/LCD_20x4.html)

The __Master brick__ connects and controls the other bricklets (the light sensor and the LCD display).


Setup
-----

Under Linux Debian/Ubuntu you need to install a couple of `deb` packages

 - The Brick daemon [http://download.tinkerforge.com/tools/brickd/linux/brickd-2.2.0_i386.deb](http://download.tinkerforge.com/tools/brickd/linux/brickd-2.2.0_i386.deb)
 - The Brick viewer [http://download.tinkerforge.com/tools/brickv/linux/brickv-2.2.1_all.deb](http://download.tinkerforge.com/tools/brickv/linux/brickv-2.2.1_all.deb)

These packages have dependencies on `libusb` and some other python related packages, make sure to install those dependencies as requested by the `dpkg` command. 

Tinkerforge components work on unique identifiers (cfr. the __UID__ in the project code).

Another intersting __brick__ is the __RED brick__, you need to plug it on top of the __Master brick__ (cfr. [http://www.tinkerforge.com/en/doc/Hardware/Bricks/RED_Brick.html](http://www.tinkerforge.com/en/doc/Hardware/Bricks/RED_Brick.html)). It contains a __Cortex A8__ processor with GPIO and a running Linux Operating System.
If you decide to develop your application using the RED brick, then you need to compile your source code for that architecture. This is really easy when using the Brick viewer.

In the following image you can see the Master brick on the left, controlling the LCD bricklet and the Ambient light bricklet. The Master brick then is attached to the laptop via a USB cable.

![The main setup](/doc/tinkerforge_setup.jpg)

Technologies
------------

Tinkerforge provides a really flexible environment with a lot of supported programming languages.

I decided to go for __Java 8__ with __Gradle__ to build the project.

On the command line:
```
$ # BUILD THE PROJECT
$ gradle clean fatJar
[...]
$ # RUN IT!
$ java -jar build/libs/TinkerForgeTestProject-fatJar-1.0.jar light
Illuminance: 60.6 Lux
Press key to exit

LCD Backlight turned off
Disconnected
$ 
```
Running the Java JAR then you can see the output on the command line. Please note that the illuminance information is displaied also on the LCD screen, after turning on the backlight, before turning it off.

Acknowledgment
--------------

A big thank you to Sven Ruppert who introduced these great toys during a Hack Lab organised by the London Java Community in January 2015.

