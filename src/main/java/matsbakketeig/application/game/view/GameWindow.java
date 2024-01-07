package matsbakketeig.application.game.view;

/**
 * The GameWindow class represents the game window of the application that allows the user to play
 * the game.
 * 
 * @author  Mats Bakketeig
 * @version v1.0 (2024.01.07)
 */
public class GameWindow {
  // Class fields
  private MinesweeperApp minesweeperApp;
  private final int windowWidth;
  private final int windowHeight;

  /**
   * Constructs an instance of the GameWindow class.
   * 
   * @param minesweeperApp The application
   * @param windowWidth The window width
   * @param windowHeight The window height
   */
  public GameWindow(MinesweeperApp minesweeperApp, int windowWidth, int windowHeight) {
    this.minesweeperApp = minesweeperApp;
    this.windowWidth = windowWidth;
    this.windowHeight = windowHeight;
    this.createScene();
  }

  /**
   * Creates the scene shown in the window.
   */
  public void createScene() {
  }
}
