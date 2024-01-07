package matsbakketeig.application.game.view;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * The MinesweeperApp class represetns the main window of the application, used for interaction
 * with the user.
 * 
 * @author  Mats Bakketeig
 * @version v1.0 (2024.01.07)
 */
public class MinesweeperApp extends Application {
  private Stage primaryStage;

  private static final int WINDOW_WIDTH = 800;
  private static final int WINDOW_HEIGHT = 600;

  /**
   * Constructs an instance of the MinesweeperApp class.
   * 
   * <p>This class is not supposed to be instantiated.</p>
   */
  private MinesweeperApp() {
    // Intentionally left blank
  }

  /**
   * Starts the application by launching the GUI.
   */
  public void start(Stage primaryStage) throws Exception {
    this.primaryStage = primaryStage;

    primaryStage.setTitle("Minesweeper");
    primaryStage.show();
  }

  /**
   * Launches the application from the launcher.
   * 
   * @param args Additional arguments
   */
  public static void main(String[] args) {
    launch(args);
  }
}
