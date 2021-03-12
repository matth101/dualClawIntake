package frc.robot.commands.clawIntake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DualClawIntake;

public class IntakeEjectCommand extends CommandBase {

    private final DualClawIntake intake;
    
    public IntakeEjectCommand(DualClawIntake intake) {
        this.intake = intake;
        addRequirements(intake);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        intake.eject();
    }

    @Override
    public void end(boolean interrupted) {
        intake.neutral();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
