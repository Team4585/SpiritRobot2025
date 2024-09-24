package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Timer;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import frc.robot.huskylib.src.RoboDevice;

public class CannonCompressor extends RoboDevice {
    private Timer m_Timer;

    private boolean isInitialized;
    private VictorSPX m_controller;
    
    
    public CannonCompressor(){
        super("Cannon Compressor Sub System");
    
        m_controller = new VictorSPX(WiringConnections.CANNON_COMPRESSOR_ID);
        //m_Slave1Controller = new BasicPID(WiringConnections.ARM_SLAVE_1_CONTROLLER_ID);

        m_Timer = new Timer();
        //m_Slave1Controller.setSlave(m_MasterController);
        //m_leftSlave2Controller.setSlave(m_leftMasterController);

        
        //System.out.println("Initialize in arm");
        //slaveShouldBePos = m_Slave1Controller.getPosition();
        
      }
    
      public void Initialize(){
      }

      public void compress(){
        
        m_controller.set(ControlMode.PercentOutput, 1);

      }

      public void stopCompress(){
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
