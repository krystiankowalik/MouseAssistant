package com.github.krystiankowalik.mouseassistant

import java.awt.MouseInfo
import java.awt.Point
import java.awt.Robot
import java.time.LocalDateTime
import java.util.Objects
import java.util.Random

object MouseMover {

    val TIMEOUT = 120000L
    val MIN = -1
    val MAX = 1

    @JvmStatic
    fun run() {

        println("started!")

        val robot = Robot()
        var mouseLocation: Point
        var lastLocation = Point(0, 0)

        while (true) {

            mouseLocation = MouseInfo.getPointerInfo().location

            val xLocation = mouseLocation.getX().toInt()
            val yLocation = mouseLocation.getY().toInt()

            val xMove = getRandomFromRange(MIN, MAX)
            val yMove = getRandomFromRange(MIN, MAX)

            val xTarget = xLocation + xMove
            val yTarget = yLocation + yMove

            val shouldMove = mouseLocation == lastLocation

            /*
             * System.out.println("mouseLocation = " + mouseLocation );
             * System.out.println("lastLocation = " + lastLocation);
             */

            if (shouldMove) {
                robot.mouseMove(xTarget, yTarget)

                println(LocalDateTime.now().toString() + " mm: "
                        + "(" + xMove + ", " + yMove + "); " + "mm to: ("
                        + xTarget + ", " + yTarget + ")")
            }

            lastLocation = mouseLocation

            Thread.sleep(TIMEOUT)

        }

    }

    private fun getRandomFromRange(min: Int, max: Int): Int {
        val random = Random().nextInt(max - min + 1) + min
        return if (random == 0) 1 else random
        // return random;
    }

}
