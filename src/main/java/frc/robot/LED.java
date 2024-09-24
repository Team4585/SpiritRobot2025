package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.units.Time;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Timer;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.fasterxml.jackson.databind.deser.std.StackTraceElementDeserializer.Adapter;

import frc.robot.huskylib.src.RoboDevice;

public class LED extends RoboDevice {
    
    private AddressableLED m_Led;
    private AddressableLEDBuffer m_LedBuffer;
    private Timer m_timer;
    
    public LED(){
        super("LED Sub System");

        m_Led = new AddressableLED(1);
        
        m_timer = new Timer();

        m_LedBuffer = new AddressableLEDBuffer(150);
        m_Led.setLength(m_LedBuffer.getLength());
        
      }
    
      public void Initialize(){
      }

      public void Shine() {
        for(var i = 0; i < m_LedBuffer.getLength(); i++){
          m_LedBuffer.setRGB(i, 255, 255,255);
        }
        m_Led.setData(m_LedBuffer);
        m_Led.start();
        
        
        double targetTime = 0.02;
        
        boolean waited = false;
         
        for(var i = 0; i < m_LedBuffer.getLength(); i++){
          m_timer.reset();
          m_timer.start();
          m_LedBuffer.setRGB(i, 0, 255,0 );
         
          m_Led.setData(m_LedBuffer);


          while (!m_timer.hasElapsed(targetTime)) {}
        }
/* 
        m_LedBuffer.setRGB(0, 255, 0, 0);
        m_Led.setData(m_LedBuffer);
        m_Led.start();*/
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
