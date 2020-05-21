/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author asus
 */
public class ControllerHome {
ViewHome view;
    ControllerHome(ViewHome view) {
        this.view = view;
     view.btnKereta.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed(ActionEvent ae) {
               view.setVisible(false);
               MVCKereta kereta = new MVCKereta();
            }  
        });
        
         view.btnTiket.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed(ActionEvent ae) {
                view.setVisible(false);
               MVCTiket tiket = new MVCTiket();
                
            }  
        });
    }
    
}
