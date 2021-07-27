
import lejos.nxt.*;
import lejos.robotics.Color; // Imports the lejos colours
import lejos.robotics.ColorDetector; // Imports the lejos colour detector
import lejos.util.Delay; //Imports the lejos delay system

public class Level_1 {
		
		public static void main(String [] args) { // The main method 
	    
		ColorSensor cs = new ColorSensor(SensorPort.S4); // Stores the colour sensor as the variable "cs"
		
		
		Button.waitForAnyPress(); // Waits for a button on the bloc to be pressed so the program can run
			
		Motor.A.setSpeed(150); // Sets the speed of motor A to 150
		Motor.C.setSpeed(150); // Sets the speed of motor C to 150
		Motor.A.forward(); // Motor A moves forward
		Motor.C.forward(); // Motor C moves forward
			
		for (int i = 1; i < 50; i++) { // This for loop makes the colour sensor scan 50 times by increasing the value of "i" until it reaches 50
				
		int col = cs.getColorID(); // Makes the colour sensor look for a colour and stores it in an integer variable called "col"
		
		if (col != 0) { // If the colour sensor does not detect 0 (Red, the colour of the safety area)
			
			Motor.A.setSpeed(200); // Sets the speed of motor A to 200
			Motor.C.setSpeed(200); // Sets the speed of motor C to 200
			Motor.A.forward(); // Motor A moves forward
			Motor.C.forward(); // Motor C moves forward
			Delay.msDelay(400); // Delay of 0.4 seconds
							
		}
		
		else if (col == 0)  { // If the colour sensor does detect 0 (Red, the colour of the safety area)
			
			Motor.A.stop(); // Motor A stops
			Motor.C.stop(); // Motor C stops 
			Delay.msDelay(400); // Delay of 0.4 seconds
			Motor.A.backward(); // Motor A moves backwards
			Motor.C.backward(); // Motor C moves backwards
			Delay.msDelay(400); // Delay of 0.4 seconds
			break; // Break from the for loop
			
		}
		
		}
		
		for (int a = 1; a < 50; a++) { // This for loop makes the colour sensor scan 50 times by increasing the value of "a" until it reaches 50
			
			int col2 = cs.getColorID(); // Makes the colour sensor look for a colour and stores it in an integer variable called "col2"
			
			if (col2 != 7) { // If the colour sensor does not detect 7 (Black, the colour of the starting line)
				
				Delay.msDelay(200); // Delay of 0.2 seconds
				Motor.A.backward(); // Motor A moves backwards
				Motor.C.backward(); // Motor C moves backwards
				
			}
			
			else { // if the colour sensor detects 7 (Black, the colour of the starting line)
				
				Delay.msDelay(200); // Delay of 0.2 seconds
				Motor.A.backward(); // Motor A moves backwards
				Motor.C.backward(); // Motor C moves backwards
				Delay.msDelay(1000); // Delay of 1 second
				System.exit(a); // Stops the for loop
				
			}
			
		}
		
		Button.waitForAnyPress(); // Waits for a button to be pressed on the bloc so the program can be stopped
			
		}

		}
		
		
		
		
		
		

