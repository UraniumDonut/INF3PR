/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eieruhr;

import java.util.concurrent.Flow;

/**
 *
 * @author basti
 */
public class Controller implements Flow.Subscriber<Integer>{
    private View view;
    private Model model;
    private Flow.Subscription sub;
    
    public Controller(View view, Model model){
        this.model = model;
        this.view = view;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        sub = subscription;
        sub.request(1);
    }

    @Override
    public void onNext(Integer item) {
        view.getjLabel1().setText(item.toString());
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
    
    public void initCtrl(){
        model.addSubscriber(this);
    }
}
