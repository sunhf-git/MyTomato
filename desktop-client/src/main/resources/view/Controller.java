package app.view;

import app.MainActivity;

public abstract class  Controller {
    public MainActivity main;
    public void setMainAndInit(MainActivity main) {
        this.main = main;
    }

}
