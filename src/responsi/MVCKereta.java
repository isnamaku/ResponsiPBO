
package responsi;


public class MVCKereta {
    ViewKereta viewpraktikum = new ViewKereta();
    Model modelpraktikum = new Model();
    ControllerKereta controllerpraktikum = new ControllerKereta (modelpraktikum,viewpraktikum);
}
