package matsbakketeig.application.game.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import matsbakketeig.application.game.controller.MainController;

/**
 * The MinesweeperApp class represetns the main window of the application, used for interaction
 * with the user.
 * 
 * @author  Mats Bakketeig
 * @version v1.0 (2024.01.07)
 */
public class MinesweeperApp extends Application {
  // Class fields
  private MainController mainController;
  private Stage primaryStage;
  private GameWindow gameWindow;

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
   * Sets the main controller to the specified main controller.
   * 
   * @param mainController The specified main controller
   */
  public void setMainController(MainController mainController) {
    this.mainController = mainController;
  }

  /**
   * Sets the primary stage to the specified primary stage.
   * 
   * @param primaryStage The specified primary stage
   */
  public void setPrimaryStage(Stage primaryStage) {
    this.primaryStage = primaryStage;
  }

  /**
   * Changes the scene to a new game window scene.
   */
  public void changeToGameWindow() {
    this.gameWindow = new GameWindow(this, WINDOW_WIDTH, WINDOW_HEIGHT);
    this.changeToScene(this.gameWindow.getScene());
  }

  /**
   * Changes the scene shown in the primary stage to the specified scene.
   * 
   * @param scene The specified scene
   */
  private void changeToScene(Scene scene) {
    this.primaryStage.setScene(scene);
  }

  /**
   * Starts the application by launching the GUI.
   */
  public void start(Stage primaryStage) throws Exception {
    this.setMainController(new MainController(this));

    this.setPrimaryStage(primaryStage);

    primaryStage.setTitle("Minesweeper");
    this.changeToGameWindow();
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
