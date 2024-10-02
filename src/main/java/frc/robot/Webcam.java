package frc.robot;

import frc.robot.huskylib.src.RoboDevice;

public class Webcam extends RoboDevice {

    
    public Webcam(){
        super("Webcam Sub System");
    
      }
    
      public void Initialize(){
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
