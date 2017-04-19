/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inceptionmockup;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 *
 * @author al342235
 */
public class TimelineController implements Initializable {
    
    private static int ID = 0;
    
    private int id;
    
    private InceptionMockup mockup;

    public void setMockup(InceptionMockup mockup) {
        this.mockup = mockup;
    }
    
    @FXML
    private void timelineClicked() {
        Timeline timeline = new Timeline();
        timeline.setName("Timeline " + id);
        timeline.setTime(LocalDate.now().format(DateTimeFormatter.ISO_DATE));
        mockup.update(timeline);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        id = ++ID;
    }
    
}
