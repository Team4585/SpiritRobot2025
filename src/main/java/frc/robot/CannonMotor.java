package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import frc.robot.huskylib.src.RoboDevice;

public class CannonMotor extends RoboDevice {

    private VictorSPX m_controller;
    
    
    public CannonMotor(){
        super("Cannon Motor Sub System");
    
        m_controller = new VictorSPX(WiringConnections.CANNON_VALVE_MOTOR_ID);

      }
    
      public void Initialize(){
      }

      public void open(){
        
        m_controller.set(ControlMode.PercentOutput, 0.1);

      }

      public void stop(){
        m_controller.set(ControlMode.PercentOutput, 0);
      }


      public void pickUp(){
        //m_MasterController.setRotations(pickUp);
      }

      public void lowDrop(){
          //m_MasterController.setRotations(low);
      }

      public void mediumDrop(){
        //m_MasterController.setRotations(medium);
      }
    
      @Override
      public void doGatherInfo() {
        super.doGatherInfo();
        //System.out.println(m_MasterEncoder.getPosition());
      }
    
      @Override
      public void doActions() {
        super.doActions();
      }
}
