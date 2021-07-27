
import lejos.nxt.*;
import lejos.robotics.Color; // Imports the lejos colours
import lejos.robotics.ColorDetector; // Imports the lejos colour detector
import lejos.util.Delay; //Imports the lejos delay system


public class Level_3 {

	
	public static void main(String[] args) {  // The main method 
		
		ColorSensor cs = new ColorSensor(SensorPort.S4); // Stores the colour sensor as the variable "cs"
		
		Button.waitForAnyPress(); // Waits for a button on the bloc to be pressed so the program can run
		
		Motor.A.setSpeed(200); // Sets the speed of motor A to 200
		Motor.B.setSpeed(200); // Sets the speed of motor A to 200
		Motor.C.setSpeed(200); // Sets the speed of motor C to 200
		
		Motor.A.forward(); // Motor A moves forward
		Motor.C.forward(); // Motor C moves forward
		Delay.msDelay(3000); // Delay of 3 seconds
		Motor.A.stop(); // Motor A stops
		Delay.msDelay(1800); // Delay of 1.8 seconds
		Motor.C.stop(); // Motor C stops
		
		Delay.msDelay(400); // Delay of 0.4 seconds
		
		Motor.A.forward(); // Motor A moves forward
		Motor.C.forward(); // Motor C moves forward
		Delay.msDelay(1200); // Delay of 1.2 seconds
		Motor.C.stop(); // Motor C stops
		Delay.msDelay(1900); // Delay of 1.9 seconds
		Motor.A.stop(); // Motor A stops
		
		Delay.msDelay(400); // Delay of 0.4 seconds
		
		Motor.A.forward(); // Motor A moves forward
		Motor.C.forward(); // Motor C moves forward
		Delay.msDelay(1300); // Delay of 1.3 seconds
		Motor.A.stop(); // Motor A stops
		Motor.C.stop(); // Motor C stops
		Delay.msDelay(400); // Delay of 0.4 seconds
		Motor.B.rotate(105); //Moves the claw arm downwards
		Motor.B.stop(); // Motor B stops
		
		Delay.msDelay(400); // Delay of 0.4 seconds
		
		Motor.A.forward(); // Motor A moves forward
		Delay.msDelay(600); // Delay of 0.6 seconds 
		Motor.A.forward(); // Motor A moves forward
		Motor.C.forward(); // Motor C moves forward
		Delay.msDelay(600); // Delay of 0.6 seconds
		Motor.A.stop(); // Motor A stops
		Motor.C.stop(); // Motor C stops
	
		
        for (int i = 1; i < 50; i++) { // This for loop makes the colour sensor scan 50 times by increasing the value of "i" until it reaches 50
			
			int col = cs.getColorID(); // Makes the colour sensor look for a colour and stores it in an integer variable called "col"
			
			if (col != 0) { // If the colour sensor does not detect 0 (Red, the colour of the safety area)
				
				System.out.println(cs.getColorID());
				
				Motor.A.forward(); // Motor A moves forward
				Motor.C.forward(); // Motor C moves forward
				Delay.msDelay(400); // Delay of 400 milliseconds
								
			}
			
			else if (col == 0)  { // If the colour sensor does detect 0 (Red, the colour of the safety area)
				
				System.out.println(cs.getColorID());
				
				Delay.msDelay(400); // Delay of 400 milliseconds
				Motor.A.stop(); // Motor A stops
				Motor.C.stop(); // Motor C stops 
				Motor.B.rotate(-105); // Moves the claw arm back up
				Delay.msDelay(1000); // Delay of 1000 milliseconds
				Motor.A.backward(); // Motor A moves backwards
				Motor.C.backward(); // Motor C moves backwards
				Delay.msDelay(400); // Delay of 400 milliseconds
				break; // Break from the for loop
				
			}
			
		}
			
			for (int a = 1; a < 50; a++) { // This for loop makes the colour sensor scan 50 times by increasing the value of "a" until it reaches 50
				
				int col2 = cs.getColorID(); // Makes the colour sensor look for a colour and stores it in an integer variable called "col2"
				
				if (col2 == 7) { // If the colour sensor does not detect 7 (Black, the colour of the starting line)
					
					System.out.println(cs.getColorID());
					
					Delay.msDelay(400); //Delay of 0.2 seconds
					Motor.A.backward(); // Motor A moves backwards
					Motor.C.backward(); // Motor C moves backwards
					Delay.msDelay(1000); // Delay of 1 second
					System.exit(a); // Stops the for loop
				
					
					
				}
				
				else { // if the colour sensor detects 7 (Black, the colour of the starting line)
					
					System.out.println(cs.getColorID());
					
					Delay.msDelay(330); // Delay of 0.4 seconds
					Motor.A.backward(); // Motor A moves backwards
					Motor.C.backward(); // Motor C moves backwards
					
					
				}
				
			}
			
			Button.waitForAnyPress(); // Waits for a button to be pressed on the bloc so the program can be stopped
				
			

	}

}

		
		
		
		
		