package ggc.app;

import pt.tecnico.uilib.Dialog;
import pt.tecnico.uilib.menus.Menu;
import ggc.core.WarehouseManager;
import ggc.core.exception.ImportFileException;

public class App {

  public static void main(String[] args) {
    try (var ui = Dialog.UI) {
      WarehouseManager manager = new WarehouseManager();

      String datafile = System.getProperty("import");
      if (datafile != null) {
        try {
          manager.importFile(datafile);
        } catch (ImportFileException e) {
          // no behavior described: just present the problem
          e.printStackTrace();
        }
      }

      Menu menu = new ggc.app.main.Menu(manager);
      menu.open();
    }
  }

}
