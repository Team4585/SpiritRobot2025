package frc.robot.huskylib.src;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.*;


public class WestCoastDriveTrain extends RoboDevice{

  private double m_targSpeed = 0.0;
  private double m_targRotationSpeed = 0.0;
  private double m_currentSpeed = 0.0;
  private double m_currentRotationSpeed = 0.0;

  private int m_steeringPow = 3;
  private double m_steeringEngagePoint = .5;

  private VictorSPX m_leftMasterController;
  private VictorSPX m_leftSlave1Controller;
  private VictorSPX m_leftSlave2Controller;
  private VictorSPX m_rightMasterController;
  private VictorSPX m_rightSlave1Controller;
  private VictorSPX m_rightSlave2Controller;


  public WestCoastDriveTrain(int leftMasterID, int leftSlaveID1, int leftSlaveID2, int rightMasterID, int rightSlaveID1, int rightSlaveID2){
    super("WestCoastDriveTrain");

    m_leftMasterController = new VictorSPX(leftMasterID);
    m_leftSlave1Controller = new VictorSPX(leftSlaveID1);
    m_leftSlave2Controller = new VictorSPX(leftSlaveID2);
    m_rightMasterController = new VictorSPX(rightMasterID);
    m_rightSlave1Controller = new VictorSPX(rightSlaveID1);
    m_rightSlave2Controller = new VictorSPX(rightSlaveID2);

    m_leftSlave1Controller.follow(m_leftMasterController);
    m_leftSlave2Controller.follow(m_leftMasterController);
    m_rightSlave1Controller.follow(m_rightMasterController);
    m_rightSlave2Controller.follow(m_rightMasterController);
  }

  public void Initialize(){
  }

  public void setTargSpeed(double targSpeed){
    m_targSpeed = targSpeed;
  }

  public void setTargRotationSpeed(double targRotationSpeed){
    if (targRotationSpeed != 0) {
      if (targRotationSpeed > 0) { 
        m_targRotationSpeed = Math.pow(targRotationSpeed, m_steeringPow) + m_steeringEngagePoint;
      }else{
        m_targRotationSpeed = Math.pow(targRotationSpeed, m_steeringPow) - m_steeringEngagePoint;
      }
    }else{
      m_targRotationSpeed = 0;
    }
  }

  public double getTargSpeed(){
    return m_targSpeed;
  }

  public double getTargRotationSpeed(){
    return m_targRotationSpeed;
  }

  public double getCurrentSpeed(){
    return m_currentSpeed;
  }

  public double getCurrentRotationSpeed(){
    return m_currentRotationSpeed;
  }

  @Override
  public void doGatherInfo() {
    super.doGatherInfo();
  }

  @Override
  public void doActions() {
    super.doActions();

    m_leftMasterController.set(ControlMode.PercentOutput,  -m_targRotationSpeed -m_targSpeed);
    m_rightMasterController.set(ControlMode.PercentOutput, m_targRotationSpeed - m_targSpeed);

    // if(m_currentSpeed < m_targSpeed){
    //   m_currentSpeed += 0.01;
    // }
    // else if (m_currentSpeed > m_targSpeed) {
    //   m_currentSpeed -= 0.01;
    // }

    // if(m_currentRotationSpeed < m_targRotationSpeed){
    //   m_currentRotationSpeed += 0.01;
    // }
    // else if (m_currentRotationSpeed > m_targRotationSpeed) {
    //   m_currentRotationSpeed -= 0.01;
    // }

    if(debugModeOn()){
      System.out.println(getDeviceName() + "-- speed: " + m_currentSpeed + "  rotation: " + m_currentRotationSpeed);
    }

  }

}
