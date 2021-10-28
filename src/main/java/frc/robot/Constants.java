// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants { 

    // Connections to the RoboRio
    public static final class RoboRio {
        public final class PwmPort {

        }
        public final class DioPort {
            
        }
        public final class CanID {
            public static final int LeftsparkMax = 11;
            public static final int RightsparkMax = 12;
            public static final int PCM = 0;
        }
    }

    // Connections to the Drivers' Station Laptop
    public static final class Laptop {
        public final class UsbPorts {
            public static final int GamePad = 2;
            public static final int Joystick = 3;
        }
    }

    // Constants for the gamepad joysticks & buttons
    public static final class GamePad {
        // Joysticks and their axes
        public final class LeftStick {
            public static final int LeftRight = 0;
            public static final int UpDown = 1;
        }
        public final class RightStick {
            public static final int LeftRight = 4;
            public static final int UpDown = 5;
        }
        public final static int LeftToggle = 2;
        public final static int RightToggle = 3;
    
        public final class Button {
            public static final int A = 1;
            public static final int B = 2;
            public static final int X = 3;
            public static final int Y = 4;
            public static final int LB = 5;
            public static final int RB = 6;
            public static final int Back = 7;
            public static final int Start = 8;
            // public static final int LeftJoyStickClick = 9;
            // public static final int RightJoyStickClick = 10;
        }    
    }
    
    // 3D Joystick (rotating stick)
    public static final class Joystick3D{
        public final class Axis {
            public static final int LeftRight = 0;
            public static final int FightFlight = 1;
            public static final int TurnNeck = 2;
            public static final int Throttle = 3;
        }
    }
}
