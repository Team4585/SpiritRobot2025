package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Encoder;

import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.huskylib.src.RoboDevice;

public class CannonCompressor extends RoboDevice {
    
    private int pickUp = 0;
    private int low = 20;
    private int medium = 15;

    private double masterShouldBePos;
    private double slaveShouldBePos;
    private static double positionThreshold = 0.1;

    private boolean isInitialized;
    private CANSparkMax m_controller;
    
    
    public CannonCompressor(){
        super("Cannon Compressor Sub System");
    
        m_controller = new CANSparkMax(WiringConnections.ARM_MASTER_CONTROLLER_ID);
        //m_Slave1Controller = new BasicPID(WiringConnections.ARM_SLAVE_1_CONTROLLER_ID);

        masterShouldBePos = m_MasterController.getPosition();
        //m_Slave1Controller.setSlave(m_MasterController);
        //m_leftSlave2Controller.setSlave(m_leftMasterController);

        
        //System.out.println("Initialize in arm");
        masterShouldBePos = m_MasterController.getPosition();
        //slaveShouldBePos = m_Slave1Controller.getPosition();
        
      }
    
      public void Initialize(){
      }

      public void moveArm(double speed){
        if (isInitialized != true){
          masterShouldBePos = m_MasterController.getPosition();
          isInitialized = true;
        }else{
          masterShouldBePos = masterShouldBePos - speed / 5;

          
          //System.out.println("Current: " + m_MasterController.getPosition() + ", Target: " + masterShouldBePos);

          if (posIsCorrect(masterShouldBePos, m_MasterController.getPosition(), positionThreshold)){
            //System.out.println("Within bounds");
          }else{
            //System.out.println("Outside bounds");
            
          }
          
          m_MasterController.setRotations(masterShouldBePos);
          System.out.println(masterShouldBePos);
          //m_Slave1Controller.setRotations(slaveShouldBePos);
  
        }
      }

      private boolean posIsCorrect(double targetPos, double currentPos, double maxError){
        //System.out.println("CurrentPos: " + currentPos + " TargetPos: " + targetPos + " MathResult: " + Math.abs(Math.abs(currentPos) - Math.abs(targetPos)));

        if (Math.abs(Math.abs(currentPos) - Math.abs(targetPos)) < maxError){
          isWithinTarget = true;
          return true;
        }else{
          isWithinTarget = false;
          return false;
        }
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
