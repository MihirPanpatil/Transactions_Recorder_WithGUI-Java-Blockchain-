import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller implements Initializable{

    BlockMethods blockMethods = new BlockMethods();

    @FXML private TextField getName;
    @FXML private TextField getData;
    
    @FXML private TableView<Block> table;
    @FXML private TableColumn<Block, Integer> index;
    @FXML private TableColumn<Block, String> name;
    @FXML private TableColumn<Block, String> data;
    @FXML private TableColumn<Block, String> hash;
    @FXML private TableColumn<Block, String> previousHash;

    public ObservableList<Block> list = FXCollections.observableArrayList(
        new Block(0, "System", "Genesis Block Generated", "0")
    );


    @FXML
    public void addItem()
    {
        blockMethods.addBlock(getName.getText(), getData.getText());
        list.add(new Block(blockMethods.getLatestBlock().getIndex(), blockMethods.getLatestBlock().getData(), blockMethods.getLatestBlock().getName(), null));
        getName.clear();
        getData.clear();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        index.setCellValueFactory(new PropertyValueFactory<Block, Integer>("Index"));
        name.setCellValueFactory(new PropertyValueFactory<Block, String>("Name"));
        data.setCellValueFactory(new PropertyValueFactory<Block, String>("Data"));
        hash.setCellValueFactory(new PropertyValueFactory<Block, String>("Hash"));
        table.setItems(list);
    }

}
