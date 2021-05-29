package be.webtechie.test;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    private final Logger logger = LoggerFactory.getLogger(Main.class);

    private List<Screen> screens;
    private List<Group> groups = new ArrayList<>();

    public void start(Stage stage) {
        Rectangle2D bounds = Screen.getPrimary().getBounds();
        logger.info("Screen bounds: {}", bounds);

        screens = Screen.getScreens();
        logger.info("Number of screens found: {}", screens.size());

        var width = new double[screens.size()];
        var height = new double[screens.size()];
        var offsetX = new double[screens.size()];
        var offsetY = new double[screens.size()];

        for (var i = 0; i < screens.size(); i++) {
            logger.info("Parsing screen: {}", screens.get(i));

            width[i] = screens.get(i).getBounds().getWidth();
            height[i] = screens.get(i).getBounds().getHeight();
            offsetX[i] = screens.get(i).getBounds().getMinX();
            offsetY[i] = screens.get(i).getBounds().getMinY();

            Group g = createChess(width[i], height[i], (i == 0) ? Color.RED : Color.GREEN );
            groups.add(g);

            var scene = new Scene(g);
            var myStage = new Stage();
            myStage.setTitle("Screen " + (i + 1));
            myStage.setX(offsetX[i]);
            myStage.setY(offsetY[i]);
            myStage.setWidth(width[i]);
            myStage.setScene(scene);
            myStage.show();
        }
    }

    public Group createChess (double w, double h, Color color) {
        var g = new Group();
        for (var i = 0; i < 10; i++)  {
            for (var j = 0; j < 10; j ++) {
                double w0 = w * j/10;
                double h0 = h * i/10;
                boolean filled = (i%2 == j%2);
                boolean dbg = (i%4 == j%4);
                if (filled) {
                    var r = new Rectangle(w0, h0, w/10, h/10);
                    r.setFill(color);
                    r.setStrokeWidth(4);
                    r.setStroke(Color.BLACK);
                    r.setOnMousePressed(e -> showClicked(w0, h0, w/10, h/10));
                    g.getChildren().addAll(r);
                    if (dbg) {
                        var l = new Label("(" + w0 + ", " + h0+")");
                        l.setTranslateX(w0+w/20);
                        l.setTranslateY(h0+h/20);
                        g.getChildren().add(l);
                    }
                }
            }
        }
        return g;
    }

    public void showClicked(double x, double y, double width, double height) {
        System.out.println("Clicked box on " + x + "/" + y);
        var r = new Rectangle(x, y, width, height);
        r.setFill(Color.ORANGE);
        r.setStrokeWidth(4);
        r.setStroke(Color.BLACK);

        for (var i = 0; i < groups.size(); i++) {
            groups.get(i).getChildren().add(r);
        }
    }

    /**
     * Small example application which combines Pi4J and JavaFX.
     *
     * @param args an array of {@link java.lang.String} objects.
     */
    public static void main(String[] args) {
        // Start the JavaFX application
        launch();
    }
}
