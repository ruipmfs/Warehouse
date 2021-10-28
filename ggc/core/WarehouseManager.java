package ggc.core;

//FIXME import classes (cannot import from pt.tecnico or ggc.app)

import java.io.Serializable;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.ObjectOutputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;

import ggc.core.exception.BadEntryException;
import ggc.core.exception.ImportFileException;
import ggc.core.exception.UnavailableFileException;
import ggc.core.exception.MissingFileAssociationException;
import ggc.core.exception.NonPositiveDateException;
import ggc.core.exception.SamePartnerKeyException;
import ggc.core.exception.NonExistentPartnerKeyException;

/** Façade for access. */
public class WarehouseManager {

  /** Name of file storing current warehouse. */
  private String _filename = "";
  private String _loadFile = new String();
  private boolean _changed = true;

  /** The warehouse itself. */
  private Warehouse _warehouse = new Warehouse();

  //FIXME define other attributes
  //FIXME define constructor(s)
  public WarehouseManager() {
  }
  //FIXME define other methods

  /**
   * @@throws IOException
   * @@throws FileNotFoundException
   * @@throws MissingFileAssociationException
   */

  public void open() throws ClassNotFoundException, IOException {
    try {
      ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(_filename)));
      _warehouse = (Warehouse) ois.readObject();
      ois.close();
    }
    catch (ClassNotFoundException cnfe) { throw cnfe; }
    catch (IOException e) { throw e; }

    _loadFile = _filename;
    _changed = true;
  }

  public void save() throws IOException, FileNotFoundException, MissingFileAssociationException {
    //FIXME implement serialization method
    if (_changed) {
      if (!hasLoadFile())
        setLoadFile(_filename);
      try {
        ObjectOutputStream oos = new ObjectOutputStream(
          new BufferedOutputStream(
            new FileOutputStream(getLoadFile())));
        oos.writeObject(_warehouse);
        oos.close();
      }
      catch (FileNotFoundException fnfe) { throw fnfe; }
      catch (IOException e) { throw e; }
      _changed = false;
    }
  }

  /**
   * @@param filename
   * @@throws MissingFileAssociationException
   * @@throws IOException
   * @@throws FileNotFoundException
   */
  public void saveAs(String filename) throws MissingFileAssociationException, FileNotFoundException, IOException {
    _filename = filename;
    save();
  }

  /**
   * @@param filename
   * @@throws UnavailableFileException
   */
  public void load(String filename) throws UnavailableFileException, ClassNotFoundException {
    //FIXME implement serialization method
    try {
      _filename = filename;
      open();
    }
    catch (ClassNotFoundException cnfe) {
      throw cnfe;
    }
    catch (IOException e) {
      throw new UnavailableFileException(_filename);
    }
  }

  /**
   * @param textfile
   * @throws ImportFileException
   */
  public void importFile(String textfile) throws ImportFileException {
    try {
      _warehouse.importFile(textfile);
    } catch (IOException | BadEntryException /* FIXME maybe other exceptions */ e) {
      throw new ImportFileException(textfile, e);
    }
  }

  public void setLoadFile(String loadFile) {
    _loadFile = loadFile;
  }

  public String getLoadFile() {
    return _loadFile;
  }

  public boolean hasLoadFile() {
    return !_loadFile.isEmpty();
  }

  public int currentDate() {
    return _warehouse.getDate();
  }

  public void requestDaysToAdvance(int days) throws NonPositiveDateException {
    try {
      _warehouse.advanceDays(days);
    } catch (NonPositiveDateException ide) { throw ide; }
  }

  // Gestão e consulta de dados da aplicação???

  public int currentBalance() {
    return _warehouse.getBalance();
  }

  public void registerPartner(String id, String name, String address) throws SamePartnerKeyException {
    try {
      _warehouse.registerPartner(id, name, address);
    } catch (SamePartnerKeyException spke) { throw spke; }
  }

  public String showPartner(String id) throws NonExistentPartnerKeyException{
    try {
      return _warehouse.showPartner(id);
    } catch (NonExistentPartnerKeyException nepk) { throw nepk; }
  }

  public String showPartners() {
    return _warehouse.showPartners();
  }

  public String allProductsToString() {
    return _warehouse.allProductsToString();
  }

  public String allBatchesToString() {
    return _warehouse.allBatchesToString();
  }

  /*public int contabilisticBalance() {
    return _warehouse.getContabilisticBalance(); //definir metodo
  }*/

  /*public String getAllProducts() {
    return _warehouse.getAllProducts(); // definir metodo
  }*/



}
