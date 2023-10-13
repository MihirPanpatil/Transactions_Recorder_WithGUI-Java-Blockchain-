import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
public class App extends Application{
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        BlockMethods blockMethods = new BlockMethods();

        blockMethods.createGenesisBlock();
        Parent root = FXMLLoader.load(getClass().getResource("Transaction_Recorder.fxml"));
        Scene scene = new Scene(root);

        Image icon = new Image("PiggyBank.jpg");

        primaryStage.setScene(scene);
        primaryStage.setTitle("Transaction Recorder(Using Blockchain)");
        primaryStage.getIcons().add(icon);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
