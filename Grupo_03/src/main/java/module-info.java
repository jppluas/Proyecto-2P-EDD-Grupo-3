module grupo3.grupo_03 {
    requires javafx.controls;
    requires javafx.fxml;

    opens grupo3.grupo_03 to javafx.fxml;
    exports grupo3.grupo_03;
}
