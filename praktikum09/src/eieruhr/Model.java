/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eieruhr;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.SubmissionPublisher;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author basti
 */
public class Model implements Runnable{
    private SubmissionPublisher<Integer> pub;
    private int countValue;
    private Thread trd;
    
    public Model(){
        pub = new SubmissionPublisher<>();
        countValue = 0;
    }

    @Override
    public void run() {
        while(countValue > 0){
            countValue--;
            pub.submit(countValue);
            try {
                trd.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        trd = null;
    }
    
    public int getCountValue(){
        return countValue;
    }
    public void setCountValue(int value){
        countValue = value;
        pub.submit(countValue);
    }
    
    public void startCounter(){
        if(trd == null){
            trd = new Thread(this);
            trd.start();
        }
    }
    
    public void addSubscriber(Subscriber sub){
        pub.subscribe(sub);
    }
}
