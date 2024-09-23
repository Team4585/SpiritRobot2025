package frc.robot;

import java.sql.Time;

import com.revrobotics.AnalogInput;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.huskylib.src.RoboDevice;

/**
 * This class controls the pneumatic compressor on Sparky
 */
public class PneumaticsCompressor extends RoboDevice{
  private final int LOW_PRESSURE_THRESHOLD = 45;
  private final int HIGH_PRESSURE_THRESHOLD = 50;

  private boolean compShouldBeOn;

  Compressor shifterCompressor = new Compressor(0, PneumaticsModuleType.CTREPCM);

  /*
  private Timer m_Timer = new Timer();

  public void enableAfterShift(){
    shifterCompressor.enableAnalog(60, 85);
    System.out.println("Compressor on");

    m_Timer.reset();
    m_Timer.start();

    while (m_Timer.hasElapsed(1.5) != true){}

    shifterCompressor.disable();
  }
  */

  /**
   * Turns the compressor on or off
   * Should not be used, as the compressor automatically shuts off at 120 psi
   */
  /*public void toggleCompressor(){
    if (shifterCompressor.() == false){
      //shifterPCM.enableCompressorAnalog(LOW_PRESSURE_THRESHOLD, HIGH_PRESSURE_THRESHOLD);
      shifterCompressor.enableDigital();
    }
    else{
      shifterCompressor.disable();
    }
  }
*/

    public PneumaticsCompressor(){
        super("PneumaticsCompressor Sub System");
    
      }
    
      public void Initialize(){
        shifterCompressor.disable();
      }
    
      @Override
      public void doGatherInfo() {
        super.doGatherInfo();

        
        //System.out.println(shifterCompressor.getAnalogVoltage());
      }
    
      @Override
      public void doActions() {
        super.doActions();
      }
}