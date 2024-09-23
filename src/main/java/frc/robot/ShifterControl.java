package frc.robot;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import frc.robot.huskylib.src.RoboDevice;

public class ShifterControl extends RoboDevice{
    Solenoid ShifterSolenoid = new Solenoid(0, PneumaticsModuleType.CTREPCM, 0);


    /**
     * Toggles the gear of the drivetrain
     * Depressurized is high gear (speedy)
     */
    public void toggleGear(){
      ShifterSolenoid.set(!ShifterSolenoid.get());
    }

    /**
     * Shifts into high gear (speedy)
     */
    public void shiftHighGear(){
      ShifterSolenoid.set(true);
    }

    /**
     * Shifts into low gear (powerful)
     */
    public void shiftLowGear(){
      ShifterSolenoid.set(false);
    }


    public ShifterControl(){
        super("Shifter Sub System");
    
      }
    
      public void Initialize(){
    
      }
    
      @Override
      public void doGatherInfo() {
        super.doGatherInfo();
    
      }
    
      @Override
      public void doActions() {
        super.doActions();
      }
}