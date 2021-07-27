
import lejos.nxt.*;
import lejos.robotics.Color; // Imports the lejos colours
import lejos.robotics.ColorDetector; // Imports the lejos colour detector
import lejos.util.Delay; //Imports the lejos delay system


public class Level_4 {

	
	public static void main(String[] args) { // The main method
		
		ColorSensor cs = new ColorSensor(SensorPort.S4); // Stores the colour sensor as the variable "cs"
		TouchSensor ts = new TouchSensor(SensorPort.S3); // Stores the ultrasonic sensor as the variable "ts"
		
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
				Delay.msDelay(400); // Delay of 0.4 seconds
								
			}
			
			else if (col == 0)  { // If the colour sensor does detect 0 (Red, the colour of the safety area)
				
				System.out.println(cs.getColorID());
				
				Delay.msDelay(400); // Delay of 0.4 seconds
				Motor.A.stop(); // Motor A stops
				Motor.C.stop(); // Motor C stops 
				Motor.B.rotate(-105); // Moves the claw arm back up
				Delay.msDelay(1000); // Delay of 1 second
				Motor.A.backward(); // Motor A moves backwards
				Motor.C.backward(); // Motor C moves backwards
				Delay.msDelay(400); // Delay of 0.4 seconds
				break; // Break from the for loop
				
			}
			
		}
        
      for (int c = 1; c < 100; c++) { // This for loop makes the touch sensor scan 100 times by increasing the value of "c" until it reaches 100
    	  
    	  
    	  while (!ts.isPressed()) { // While the touch sensor is not pressed
    	    	
    		Motor.A.setSpeed(400); // Sets the speed of motor A to 400
    		Motor.C.setSpeed(400); // Sets the speed of motor C to 400
    		Motor.A.backward(); // Motor A moves backwards
          	Motor.C.backward(); // Motor C moves backwards
          	
    	  }
    	      
       if (ts.isPressed()) { // If the touch sensor has been pressed
        	
        System.exit(c); //Stops the for loop and ends the program
        	
       } 
        	 
      }
	
	   Button.waitForAnyPress(); // Waits for a button to be pressed on the bloc so the program can be stopped

	}
	
}
