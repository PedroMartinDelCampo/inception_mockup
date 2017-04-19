/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inceptionmockup;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

/**
 *
 * @author al342235
 */
public class FXMLController implements Initializable {
    
    private InceptionMockup mockup;

    public void setMockup(InceptionMockup mockup) {
        this.mockup = mockup;
    }
    
    @FXML
    private VBox frameOverviews;
    
    @FXML
    private MediaView mediaView;
    
    @FXML
    private VBox timelinesContainer;
    
    @FXML
    private Label nameLabel;
    
    @FXML
    private Label createdAtLabel;
    
    @FXML
    private void frameClicked(MouseEvent evt) {
        frameOverviews.getChildren().forEach((Node t) -> {
            t.getStyleClass().remove("selected-frame");
        });
        Node intersectedNode = evt.getPickResult().getIntersectedNode();
        intersectedNode.getStyleClass().add("selected-frame");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String source = "http://download.oracle.com/otndocs/products/javafx/oow2010-2.flv";
        Media media = new Media(source);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mediaView.setMediaPlayer(mediaPlayer);
    }
    
    @FXML
    private void addTimeline() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Timeline.fxml"));
            Parent timeline = loader.load();
            TimelineController controller = loader.getController();
            controller.setMockup(mockup);
            timelinesContainer.getChildren().add(timeline);
        } catch (IOException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(Timeline timeline) {
        if (timeline != null) {
            nameLabel.setText(timeline.getName());
            createdAtLabel.setText(timeline.getTime());
        } else {
            nameLabel.setText("");
            createdAtLabel.setText("");
        }
    }
    
}
