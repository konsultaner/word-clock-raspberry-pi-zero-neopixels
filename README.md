Wordclock with neopixels
=========================

This is a project to construct and build a word clock using a raspberry pi zero and the adafruid neopixels.
This project is currently in progress. The repository will document the current work.

Parts list
==========

- [Raspberry Pi Zero (W)](https://www.raspberrypi.org/blog/raspberry-pi-zero-w-joins-family/)
- [XP Power ECE60US05](https://www.digikey.de/product-detail/de/xp-power/ECE60US05/1470-2590-ND/4809060) AC/DC converter 5V 60W
- [74AHCT125](https://www.adafruit.com/product/1787) Level Converter
- [Adafruit NeoPixel Digital RGBW](https://www.adafruit.com/product/2837) LED Strip

Wireing the PI
===============

The wiring is done how it is explained in the [adafruit guide](https://learn.adafruit.com/neopixels-on-raspberry-pi/wiring#level-converter-chip-wiring)
This is my result for the demo:

<img src="https://raw.githubusercontent.com/konsultaner/word-clock-raspberry-pi-zero-neopixels/master/img/wirePI1.jpg" width="300px" />
<img src="https://raw.githubusercontent.com/konsultaner/word-clock-raspberry-pi-zero-neopixels/master/img/wirePI2.jpg" width="300px" />

Setting up the PI
=================

1. Setup an evironment where the pi is accessible through ssh. There are several [guides](https://davidmaitland.me/2015/12/raspberry-pi-zero-headless-setup/) on the web that
explain how to setup the pi.
2. Assigning PWM0 and PWM1 pins to GPIO 18 and 13. The NeoPixel protocol will be controlled by the raspi's sound output.
To make the raspi ouput the signal to the GPIO 18 and 13, we need to digitally wire them up. These steps are copied from [this guide](https://learn.adafruit.com/adding-basic-audio-ouput-to-raspberry-pi-zero/pi-zero-pwm-audio)
    1. `sudo apt-get update`
    2. `sudo apt-get install git-core`
    3. `git clone git://git.drogon.net/wiringPi`
    4. `cd ~/wiringPi`
    5. `./build`
    6. test the installation with `gpio -v`
    7. Copy the gpio_alt.c code from this repo to your folder on the pi
    8. `gcc -o gpio_alt gpio_alt.c`
    8. `sudo chown root:root gpio_alt`
    9. `sudo chmod u+s gpio_alt`
    10. `sudo mv gpio_alt /usr/local/bin/`
    11. now the script to wire up the GPIO has been compiled and installed
    12. wire them up
    13. `gpio_alt -p 13 -f 0`
    14. `gpio_alt -p 18 -f 5`

3. Now the pi is setup to output your signals to the stripe. To test the wiring and setup clone the [rpi_ws281x repository](https://github.com/jgarff/rpi_ws281x) and run the test
    1. `sudo apt-get install scons`
    2. `https://github.com/jgarff/rpi_ws281x`
    3. `cd rpi_ws281x`
    3. `nano main.c` Change the strip height to `0` and the width to something like `100` and set the `STRIP_TYPE` to `SK6812_STRIP_RGBW`
    4. `scons` this runs the compiler
    5. `sudo ./test` you should see a running led snake
    
           