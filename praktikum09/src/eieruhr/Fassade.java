/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eieruhr;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Flow;
import javax.swing.JComponent;

/**
 *
 * @author basti
 */
public class Fassade extends JComponent implements Flow.Subscriber<Integer>{
    View view;
    Model model;
    Controller ctrl;
    Flow.Subscription sub;
    int oldItem;
    private CopyOnWriteArrayList<ClockZeroListener> listenerList;
    
    public Fassade(){
        view = new View();
        model = new Model();
        ctrl = new Controller(view, model);
        ctrl.initCtrl();
        model.addSubscriber(this);
        oldItem = 0;
        this.setLayout(new BorderLayout());
        this.add(view, BorderLayout.CENTER);
        this.listenerList = new CopyOnWriteArrayList<>();
    }
    
    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        sub = subscription;
        sub.request(1);
    }

    @Override
    public void onNext(Integer item) {
        this.firePropertyChange("countValue", oldItem, (int)item);
        if(item == 0)
            this.fireClockZeroEvent(new ClockZeroEvent(this));
        oldItem = (int)item;
        sub.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void onComplete() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void startCounter(){
        model.startCounter();
    }
    
    public int getCountValue(){
        return model.getCountValue();
    }
    
    public void setCountValue(int value){
        model.setCountValue(value);
    }
    
    @Override
    public Dimension getPreferredSize(){
        return new Dimension(100, 100);
    }
    
    @Override
    public Dimension getMinimumSize(){
        return new Dimension(30, 30);
    }
    
    public synchronized void addClockZeroListener(ClockZeroListener horcher){
        listenerList.add(horcher);
    }
    
    public synchronized void removeClockZeroListener(ClockZeroListener horcher){
        listenerList.remove(horcher);
    }
    
    public void fireClockZeroEvent(ClockZeroEvent evt){
        listenerList.forEach(listener -> listener.notifyClockZero(evt));
    }
}
