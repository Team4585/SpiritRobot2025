package frc.robot;

import frc.robot.huskylib.devices.HuskyJoystick;

public class SpiritRobotJoystick extends HuskyJoystick{
  private static final int FRC2023_JOYSTICK_PORT = 0;
 
  private static final int TRIGGER_BUTTON = 0;

  //Dead zone is how much you have to move the joystick for values to be read
  //Live zone is the input range that actually sends input to the rest of the code
  private static final double FB_DEAD_ZONE = 0.1;
  private static final double FB_LIVE_ZONE = 1.0 - FB_DEAD_ZONE;

  private static final double SS_DEAD_ZONE = 0.2;
  private static final double SS_LIVE_ZONE = 1.0 - SS_DEAD_ZONE;

  private static final double ROT_DEAD_ZONE = 0.1;
  private static final double ROT_LIVE_ZONE = 1.0 - ROT_DEAD_ZONE;


  /**
   * Wheeee construct the joystick, sending the port number to the parent class
   */
  public SpiritRobotJoystick(){
      super(FRC2023_JOYSTICK_PORT);
  }


  /**
   * Returns the forward/back value of the joystick, computing the deadzone and (currently nonexistent) input curve
   * @return the forward/back value of the joystick
   */
  public double getForwardBackwardValue(){
    double RetVal = 0.0;
    double RawVal = getAxisValue(HuskyJoystick.AXIS_FORWARD_BACKWARD);
    double RawMagVal = Math.abs(RawVal);  // work with positive numbers

    if(RawMagVal > FB_DEAD_ZONE){
      RetVal = RawMagVal - FB_DEAD_ZONE;  // distance past dead zone
      RetVal /= FB_LIVE_ZONE;             // scale to full range of live zone
      RetVal = RetVal * RetVal;           // square it to make the line a curve rather than straight
      if(RawVal > 0.0){
        RetVal = -RetVal;                 // Fix the sign, note that we're reversing the sign from the
                                          // raw joystick reading.
      }
    }
    
    RetVal = RetVal * Math.abs(RetVal); // Input curve
        
    //if(RawVal != 0.0){
    //  System.out.println("FBRawVal -> " + RawVal + "    FBRetVal -> " + RetVal);
    //}

    return RetVal;
  }

  /**
   * Returns the side-to-side value of the joystick, computing the deadzone and input curve
   * @return the side-to-sid value of the joystick
   */
  public double getSideToSideValue(){
    double RetVal = 0.0;
    double RawVal = getAxisValue(HuskyJoystick.AXIS_SIDE_TO_SIDE);
    double RawMagVal = Math.abs(RawVal);  // work with positive numbers

    if(RawMagVal > SS_DEAD_ZONE){
      RetVal = RawMagVal - SS_DEAD_ZONE;  // distance past dead zone
      RetVal /= SS_LIVE_ZONE;             // scale to full range of live zone
      RetVal = RetVal * RetVal;           // square it to make the line a curve rather than straight
      if(RawVal < 0.0){
        RetVal = -RetVal;                 // Fix the sign
      }
    }
    
    RetVal = RetVal * Math.abs(RetVal); // Input curve to the power of 2

    //if(RawVal != 0.0){
    //  System.out.println("SSRawVal -> " + RawVal + "    SSRetVal -> " + RetVal);
    //}

    return RetVal;
  }


  /**
   * Returns the twist value of the joystick, computing the deadzone and input curve
   * @return the twist value of the joystick
   */
  public double getTwistValue(){
    double RetVal = 0.0;
    double RawVal = getAxisValue(HuskyJoystick.AXIS_TWIST);
    double RawMagVal = Math.abs(RawVal);   // work with positive numbers

    if(RawMagVal > ROT_DEAD_ZONE){
      RetVal = RawMagVal - ROT_DEAD_ZONE;  // distance past dead zone
      RetVal /= ROT_LIVE_ZONE;             // scale to full range of live zone
      if(RawVal < 0.0){
        RetVal = -RetVal;                  // Fix the sign
      }
    }
        
    RetVal = RetVal * Math.abs(RetVal) * Math.abs(RetVal) * Math.abs(RetVal); // Input curve to the power of 4
    //if(RawVal != 0.0){
    //  System.out.println("RotRawVal -> " + RawVal + "    RotRetVal -> " + RetVal);
    //}

    return RetVal;
  }


  /**
   * Is the trigger pulled?
   * @return CONTINUALLY returns true if pulled, false if released
   */
  public Boolean triggerPushed(){
    return isButtonPushed(TRIGGER_BUTTON);
  }

  /**
   * Fires when the trigger is pulled (not reliable)
   * @return true only once when pulled
   */
  public Boolean triggerPressEvent(){
    return buttonPressEvent(TRIGGER_BUTTON);
  }
    
  /**
   * Fires when the trigger is released. More reliable than PressEvent
   * @return true only once when released
   */
  public Boolean triggerReleaseEvent(){
    return buttonReleaseEvent(TRIGGER_BUTTON);
  }

  /**
   * Fires when the button 2 is released
   * @return true only once when released
   */
  public Boolean button2ReleaseEvent(){
    return buttonReleaseEvent(1);
  }

  /**
   * Fires when the button 3 is released
   * @return true only once when released
   */
  public Boolean button3ReleaseEvent(){
    return buttonReleaseEvent(2);
  }

  public Boolean button3PressEvent(){
    return buttonPressEvent(2);
  }

  /**
   * Fires when the button 4 is released
   * @return true only once when released
   */
  public Boolean button4ReleaseEvent(){
    return buttonReleaseEvent(3);
  }

  public Boolean button4PressEvent(){
    return buttonReleaseEvent(3);
  }

  /**
   * Fires when the button 5 is released
   * @return true only once when released
   */
  public Boolean button5ReleaseEvent(){
    return buttonReleaseEvent(4);
  }

  public Boolean button5PressEvent(){
    return buttonReleaseEvent(4);
  }

  /**
   * Fires when the button 6 is released
   * @return true only once when release
   */
  public Boolean button6ReleaseEvent(){
    return buttonReleaseEvent(5);
  }

  
  public Boolean button6PressEvent(){
    return buttonPressEvent(5);
  }

  /**
   * Fires when the button 7 is released
   * @return true only once when release
   */
  public Boolean button7ReleaseEvent(){
    return buttonReleaseEvent(6);
  }
  
  /**
   * Fires when the button 8 is released
   * @return true only once when release
   */
  public Boolean button8ReleaseEvent(){
    return buttonReleaseEvent(7);
  }

  /**
   * Is button 5 pressed?
   * @return returns CONTINUALLY true if pulled, false if released
   */
  public Boolean button5Pushed(){
    return isButtonPushed(4);
  }
  
  /**
   * Is button 4 pressed?
   * @return returns CONTINUALLY true if pulled, false if released
   */
  public Boolean button4Pushed(){
    return isButtonPushed(3);
  }
  
  /**
   * Is button 3 pressed?
   * @return returns CONTINUALLY true if pulled, false if released
   */
  public Boolean button3Pushed(){
    return isButtonPushed(2);
  }

  /**
   * Is button 6 pressed?
   * @return returns CONTINUALLY true if pulled, false if released
   */
  public Boolean button6Pushed(){
    return isButtonPushed(5);
  }

  //public Boolean button11PressEvent(){
    //return isButtonPushed(10);
 // }
}
