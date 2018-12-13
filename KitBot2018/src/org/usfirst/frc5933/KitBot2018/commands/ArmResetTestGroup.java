package org.usfirst.frc5933.KitBot2018.commands;

import org.usfirst.frc5933.KitBot2018.subsystems.Arm.ArmPosition;

import edu.wpi.first.wpilibj.command.CommandGroup;

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

    	testHere();
    	// testResettingArm();
    }
    
    private void testHere() {
      	
    	// first test set, 36 desired: 49.5 traveled; second run 51; third 54; fourth 50. so multiply (desired inches)  by (36 / 50)
    	// second test set, 72 desired: 84 traveled; second run 87; third 85
    	// third test set, 240 desired: 256 traveled; second run 260; third 259 [five seconds]
    	// fourth: 28' tried as 28*12*240/258, 28' 6" traveled
    	
    	// drive 28+8.5+2' to take cube into alcove
    	addSequential( new DriveStraightGyro( (28*12 +10.5*12)*240/258, 0.7, true)); 

    	// back up 4' or so 
    //	addSequential( new DriveStraightGyro( -36, -0.7, true)); 
    	
      	// test turn: first test 63 for 90; 2nd test 8deg too short; 
    //	addSequential( new GyroTurn( -66.0, 0.7, 0.05));

    }
    
    private void testResettingArm() {
    	addSequential(new ResetArm(true));
    	
    	addSequential(new MoveArmToPos(ArmPosition.Scale, false));
    }
} 
