package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.ElectricalLayout;
import static frc.robot.Constants.Intake;

public class DualClawIntake extends SnailSubsystem {

	private CANSparkMax intakeMotor;

	private DoubleSolenoid leftSolenoid;
	private DoubleSolenoid rightSolenoid;

	public enum IntakeState {
		INTAKING,
		NEUTRAL,
		EJECTING
	}
	private IntakeState intakeState = IntakeState.NEUTRAL;

	public enum ClawState {
		OPEN,
		CLOSED
	}
	private ClawState clawState = ClawState.CLOSED;

	public DualClawIntake() {
		intakeMotor = new CANSparkMax(ElectricalLayout.INTAKE_MOTOR_ID, MotorType.kBrushless);
		intakeMotor.restoreFactoryDefaults();
		intakeMotor.setSmartCurrentLimit(20);
		intakeMotor.setIdleMode(IdleMode.kBrake);
		
		leftSolenoid = new DoubleSolenoid(ElectricalLayout.CLAW_LEFT_SOLENOID_FORWARD_ID, ElectricalLayout.CLAW_LEFT_SOLENOID_REVERSE_ID);
		rightSolenoid = new DoubleSolenoid(ElectricalLayout.CLAW_RIGHT_SOLENOID_FORWARD_ID, ElectricalLayout.CLAW_RIGHT_SOLENOID_REVERSE_ID);
	}

	@Override
	public void update() {
		switch (intakeState) {
			case INTAKING:
				intakeMotor.set(Intake.ROLLER_INTAKE_SPEED);
				break;
			case NEUTRAL:
				intakeMotor.set(Intake.ROLLER_NEUTRAL_SPEED);
				break;
			case EJECTING:
				intakeMotor.set(Intake.ROLLER_EJECT_SPEED);
				break;
		}

		switch (clawState) {
			case OPEN:
				leftSolenoid.set(Value.kForward);
				rightSolenoid.set(Value.kForward);
				break;
			case CLOSED: // CASE CLOSED. haha
				leftSolenoid.set(Value.kReverse);
				rightSolenoid.set(Value.kReverse);
				break;
		}
	}

	// States
	public void intake() {
		intakeState = IntakeState.INTAKING;
	}

	public void neutral() {
		intakeState = IntakeState.NEUTRAL;
	}
  
	public void eject() {
		intakeState = IntakeState.EJECTING;
	}

	public void open() {
		clawState = ClawState.OPEN;
	}

	public void close() {
		clawState = ClawState.CLOSED;
	}

	public IntakeState getIntakeState() {
		return intakeState;
	}

	public ClawState getClawState() {
		return clawState;
	}
  
	@Override
	public void simulationPeriodic() {
	
	}

	@Override
	public void outputValues() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setUpConstantTuning() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getConstantTuning() {
		// TODO Auto-generated method stub

	}
}
