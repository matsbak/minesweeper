package matsbakketeig.application.game.controller;

import matsbakketeig.application.game.view.MinesweeperApp;

/**
 * The MainController class represents the main controller of the application. The controller
 * handles all actions related to the MinesweeperApp class.
 * 
 * @author  Mats Bakketeig
 * @version v1.0 (2024.01.07)
 */
public class MainController {
  // Class fields
  private MinesweeperApp minesweeperApp;

  /**
   * Constructs an instance of the MainController class.
   * 
   * @param minesweeperApp The application
   */
  public MainController(MinesweeperApp minesweeperApp) {
    this.minesweeperApp = minesweeperApp;
  }
}
