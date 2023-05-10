package com.imageviewer;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author 19par
 */
public class IvController implements Initializable {

    @FXML
    private ImageView imageView;
    @FXML
    private Button buttonOpenPicture;
    @FXML
    private Button buttonNext;

    private File file;
    private List<File> list;

    final String INITIALDIR = "C:\\Users\\19par\\Desktop";

    ArrayList<Image> slike = new ArrayList<>();

    private int counter = -1;
    @FXML
    private Button buttonOpenPictures;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        buttonNext.setOnKeyPressed((t) -> {
        });
    }

    @FXML
    private void openPictureClicked(MouseEvent event) throws IOException {

        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(INITIALDIR));
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All files", "*.*"),
                new FileChooser.ExtensionFilter("JPG files", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG files", "*.png"),
                new FileChooser.ExtensionFilter("GIF files", "*.gif")
        );
        file = fc.showOpenDialog(App.stage);

        if (file != null) {

            Image picture = new Image(file.getAbsolutePath());

            slike.add(picture);
            counter++;
            imageView.setPreserveRatio(true);
            imageView.setImage(slike.get(counter));

        }

    }

    @FXML
    private void buttonNextClicked(MouseEvent event) {
        if (counter < slike.size() - 1) {
            counter++;
            imageView.setPreserveRatio(true);
            imageView.setImage(slike.get(counter));
        }

    }

    @FXML
    private void buttonPrevious(MouseEvent event) {

        if (counter > 0) {
            counter--;
            imageView.setPreserveRatio(true);
            imageView.setImage(slike.get(counter));
        }

    }

    @FXML
    private void openPicturesClicked(MouseEvent event) {

        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(INITIALDIR));
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All files", "*.*"),
                new FileChooser.ExtensionFilter("JPG files", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG files", "*.png"),
                new FileChooser.ExtensionFilter("GIF files", "*.gif")
        );
        list = fc.showOpenMultipleDialog(App.stage);

        if (list != null) {
            for (File file : list) {
                Image picture = new Image(file.getAbsolutePath());
                slike.add(picture);
                counter++;

            }
            imageView.setPreserveRatio(true);
            imageView.setImage(slike.get(counter));
        }
    }

}
