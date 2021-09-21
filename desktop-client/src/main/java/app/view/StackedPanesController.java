package app.view;

import app.MainActivity;
import app.control.mytomato.StackedPanes;
import app.model.TomatoTask;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class StackedPanesController extends Controller {


//--------------------------------------- Field

    private StackedPanes stackedPanes;

//--------------------------------------- Getter Setter
//--------------------------------------- Method

    public StackedPanesController() {

    }

    @Override
    public void setMainAndInit(MainActivity main) {
        super.setMainAndInit(main);
        stackedPanes.setItemsMap(MainActivity.getTomatoTasksMap());
        writeWhenItemsChange();
        stackedPanes.setStackedPanesController(this);
    }

    private void writeWhenItemsChange() {
        stackedPanes.getItemsMap().addListener(new MapChangeListener<LocalDate, ObservableList<TomatoTask>>() {
            @Override
            public void onChanged(Change<? extends LocalDate, ? extends ObservableList<TomatoTask>> change) {
                main.getTomatoTaskDataMapJson().write();
            }
        });
        stackedPanes.titledPaneItemsChangeProperty().addListener((observable, oldChange, newChange) -> {
            main.getTomatoTaskDataMapJson().write();
        });
    }

    public StackedPanes createScrollPane() {
        stackedPanes = new StackedPanes();
        return stackedPanes;
    }


}