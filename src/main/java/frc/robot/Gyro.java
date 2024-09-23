package frc.robot;

//import com.kauailabs.navx.frc.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.SerialPort.Port;
import frc.robot.huskylib.src.RoboDevice;


/**
 * The class that gets data from the NAVX gyro
 */
public class Gyro extends RoboDevice {
   // AHRS m_TheGyro = new AHRS(Port.kMXP);

   /*
  public double getHeading(){
    return m_TheGyro.getAngle();
  }
  */
   
  public void Initialize(){

  }

  
  public Gyro(){
    super("Gyro Sub System");
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

    

