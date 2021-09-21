package app.view;

import app.MainActivity;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class RootLayoutController  extends Controller{

    @FXML
    private BorderPane rootLayout;
    @FXML
    private MenuBar MenuBar;
    @FXML
    private Menu fileMenu;
    @FXML
    private MenuItem settingsMenuItem;


    @FXML
    private void handleSettingsMenuItem() {
        main.startSettingDialogAndWait();
    }

    @Override
    public void setMainAndInit(MainActivity main) {
        super.setMainAndInit(main);
        rootLayout.setCenter(main.getMainLayout());
    }

}
