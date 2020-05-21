
package responsi;


public class MVCTiket {
    ViewTiket view = new ViewTiket();
    Model model = new Model();
   ControllerTiket controller = new ControllerTiket (model,view);
}
