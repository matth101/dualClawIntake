package frc.robot.commands.clawIntake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DualClawIntake;

public class ClawOpenCommand extends CommandBase {

    private final DualClawIntake intake;
    
    public ClawOpenCommand(DualClawIntake intake) {
        this.intake = intake;
        addRequirements(intake);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        intake.open();
    }

    @Override
    public void end(boolean interrupted) {
        
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
