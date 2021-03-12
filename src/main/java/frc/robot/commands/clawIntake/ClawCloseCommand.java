package frc.robot.commands.clawIntake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DualClawIntake;

public class ClawCloseCommand extends CommandBase {

    private final DualClawIntake intake;
    
    public ClawCloseCommand(DualClawIntake intake) {
        this.intake = intake;
        addRequirements(intake);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        intake.close();
    }

    @Override
    public void end(boolean interrupted) {
        
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
