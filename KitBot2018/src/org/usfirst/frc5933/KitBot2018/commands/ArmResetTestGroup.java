package org.usfirst.frc5933.KitBot2018.commands;

import org.usfirst.frc5933.KitBot2018.Robot;
import org.usfirst.frc5933.KitBot2018.subsystems.Arm.ArmPosition;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ArmResetTestGroup extends CommandGroup {

    public ArmResetTestGroup() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.

    	autonomousAMES2018();
    	// testResettingArm();
    }
    
    private void autonomousAMES2018() {
      	// read DIPs
    	int dips =     	Robot.roborio.readDips();

    	// testing
    	Command eject1 = new EjectCube(.01);
    	addParallel(eject1);
    	addSequential( new DriveStraightGyro( 100, 0.7, true));
    	addSequential(new WaitForCommand(eject1));
    	addSequential( new DriveStraightGyro( -50, -0.5, true));
    	addSequential( new DriveStraightGyro( 50, 0.3, true));

		SmartDashboard.putNumber("DDDDDDIIIIIIPPPPPPPs: ", dips);
    	// testing distances traveled compared to distances set, 12/12/18, in GTI hallway
    	// first test set, 36 desired: 49.5 traveled; second run 51; third 54; fourth 50. so multiply (desired inches)  by (36 / 50)
    	// second test set, 72 desired: 84 traveled; second run 87; third 85
    	// third test set, 240 desired: 256 traveled; second run 260; third 259 [five seconds]
    	// fourth: 28' tried as 28*12*240/258, 28' 6" traveled

		/*
		//
		// set of commands to deliver cube to alcove
		//
    	// drive 28+8.5+2' to take cube into alcove
    	// since the DriveStraight only seems to work every other time, hit the command twice
    	addSequential( new DriveStraightGyro( (28*12 +10.5*12)*240/258, 0.7, true)); 
    	addSequential( new DriveStraightGyro( (28*12 +10.5*12)*240/258, 0.7, true)); 
    	
    	// eject cube, parameter is # seconds to run the motors
    	addSequential( new EjectCube( 1.0));
    	
    	// back up 2' or so (twice due to bug)
    	addSequential( new DriveStraightGyro( -18, -0.7, true)); 
    	addSequential( new DriveStraightGyro( -18, -0.7, true)); 
    	//
    	// end deliver to alcove
    	//
    	*/
		
    	
		/*
    	// 
    	// set of commands to deliver cube to step
    	//
    	// drive 68*4 + (28*12-68*4)/2 to aim at step
    	addSequential( new DriveStraightGyro( (68*4 + (28*12-68*4)/2) *240 / 258, 0.7, true));
    	addSequential( new DriveStraightGyro( (68*4 + (28*12-68*4)/2) *240 / 258, 0.7, true));

    	// turn right
    	addSequential( new GyroTurn( 66, 0.7, 0.05));
    	
    	// drive into step
    	addSequential( new DriveStraightGyro( 24, 0.7, true));
    	
    	// drop cube
    	addSequential( new OpenTongs( true));
    	
    	// back up
    	addSequential( new DriveStraightGyro( -18, -0.7, true));
    	
    	// turn left
    	addSequential( new GyroTurn( 66, 0.7, 0.05));
    	
    	// drive past scoring line
    	addSequential( new DriveStraightGyro( 36, 0.7, true ));
    	//
    	// end of section to score in step
    	
      	// test turn 12/12/18: first test 63 for 90; 2nd test 8deg too short; 
    	addSequential( new GyroTurn( -66.0, 0.7, 0.05)); // negative turn to turn left

    	// drive into the sunset
    	// since the DriveStraight only seems to work every other time, hit the command twice
    	addSequential( new DriveStraightGyro( (28*12 +10.5*12)*240/258, 1.0, true)); 
    	addSequential( new DriveStraightGyro( (28*12 +10.5*12)*240/258, 1.0, true)); 
*/
    }
    
    private void testResettingArm() {
    	addSequential(new ResetArm(true));
    	
    	addSequential(new MoveArmToPos(ArmPosition.Scale, false));
    }
} 
