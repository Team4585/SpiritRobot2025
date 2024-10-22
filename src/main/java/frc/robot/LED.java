package frc.robot;


import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.Timer;

import frc.robot.huskylib.src.RoboDevice;

public class LED extends RoboDevice {
    
    private AddressableLED m_Led;
    private AddressableLEDBuffer m_LedBuffer;
    private Timer m_timer;
    private Boolean readyToFire;

    private CannonMotor m_CannonMotor;
    
    public LED(){
        super("LED Sub System");

        m_Led = new AddressableLED(1);
        
        m_timer = new Timer();
        m_CannonMotor = new CannonMotor();

        m_LedBuffer = new AddressableLEDBuffer(150);
        m_Led.setLength(m_LedBuffer.getLength());
        
      }
    
      public void Initialize(){
      }

      
      public void safetyOff(){
        readyToFire = true;
      }


      public void fireSequence() {

        if(readyToFire){

          readyToFire = false;

          for(var i = 0; i < m_LedBuffer.getLength(); i++){
            m_LedBuffer.setRGB(i, 255, 255,255);
          }
          m_Led.setData(m_LedBuffer);
          m_Led.start();
        
        
          double targetTime = 0.02;
        
         
          for(var i = 0; i < m_LedBuffer.getLength(); i++){
            m_timer.reset();
            m_timer.start();
            m_LedBuffer.setRGB(i, 0, 255,0 );
         
            m_Led.setData(m_LedBuffer);


            while (!m_timer.hasElapsed(targetTime)) {}

          }
        
          m_CannonMotor.open();
        }
      }



      public void Shine(){

        for(var i = 0; i < m_LedBuffer.getLength(); i++){

          m_LedBuffer.setRGB(i, 255,255, 255);
        }
        
        m_Led.setData(m_LedBuffer);
        m_Led.start();
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
