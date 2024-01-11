/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package eieruhr;

import java.util.EventListener;

/**
 *
 * @author basti
 */
public interface ClockZeroListener extends EventListener{
    public void notifyClockZero(ClockZeroEvent evt);
}
