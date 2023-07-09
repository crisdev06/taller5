module cl.ucn.disc.pa.taller_fx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;

    opens cl.ucn.disc.pa.taller_fx to javafx.fxml;
    exports cl.ucn.disc.pa.taller_fx;
}