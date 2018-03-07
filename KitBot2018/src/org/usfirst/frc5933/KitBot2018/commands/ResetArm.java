package org.usfirst.frc5933.KitBot2018.commands;

import org.usfirst.frc5933.KitBot2018.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ResetArm extends Command {

    public ResetArm() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.arm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	SmartDashboard.putString("Current Command", "ResetArm");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.arm.moveArmVBus(0.2);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.arm.getArmSwitch() == 1;
    }

    // Called once after isFinished returns true
    protected void end() {
//    	Robot.arm.resetEncoder();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
//    	Robot.arm.moveArmVBus(0);
    }
}
