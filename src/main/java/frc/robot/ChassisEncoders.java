package frc.robot;

import edu.wpi.first.wpilibj.Encoder;
import frc.robot.huskylib.src.RoboDevice;

/**
 * The encoders for the chassis (which are broken on Sparky), one on the left and on the right
 */
public class ChassisEncoders extends RoboDevice{
  Encoder m_LeftEncoder = new Encoder(2, 3);
  Encoder m_RightEncoder = new Encoder(0, 1);

  /**
   * Get the raw encoder value of the left wheels
   * This value is 1/3 of the total degrees the wheels have rotated
   * @return the encoder value, 1/3 of the degrees rotated by the wheels
   */
  public double GetLeftRawEncoderValue(){
    return m_LeftEncoder.getDistance();
  }

  /**
   * Get the raw encoder value of the right wheels
   * This value is 1/3 of the total degrees the wheels have rotated
   * @return the encoder value, 1/3 of the degrees rotated by the wheels
   */
  public double GetRightRawEncoderValue(){
    return m_RightEncoder.getDistance();
  }

  /**
   * Get the encoder value of the left wheels, compensated for the 1/3 discrepancy
   * This value is the total degrees the wheels have rotated
   * @return the number of degrees rotated by the wheels
   */
  public double GetLeftDegreesEncoderValue(){
    return m_LeftEncoder.getDistance() * 3;
  }

  /**
   * Get the encoder value of the right wheels, compensated for the 1/3 discrepancy
   * This value is the total degrees the wheels have rotated
   * @return the number of degrees rotated by the wheels
   */
  public double GetRightDegreesEncoderValue(){
    return m_RightEncoder.getDistance() * 3;
  }

  public ChassisEncoders(){
    super("Encoder Sub System");

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
