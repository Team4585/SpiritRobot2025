package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Timer;
import frc.robot.huskylib.src.RoboDevice;

public class CannonMotor extends RoboDevice {

    private VictorSPX m_controller;
    private Timer m_Timer;
    
    
    public CannonMotor(){
        super("Cannon Motor Sub System");
    
        m_controller = new VictorSPX(WiringConnections.CANNON_VALVE_MOTOR_ID);

        m_Timer = new Timer();
      }
    
      public void Initialize(){
      }


      public void open(){
        
        m_Timer.reset();
        m_Timer.start();
        while (!m_Timer.hasElapsed(0.5)) { 
         m_controller.set(ControlMode.PercentOutput, 1);
        }

        stop();

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
