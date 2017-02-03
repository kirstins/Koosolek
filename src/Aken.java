import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by kirstin on 03/02/2017.
 */
public class Aken {
    Stage stage= new Stage();
    VBox vbox;
    Scene scene;
    TextField teema;
    TextField planeeritudAeg;
    Button button;
    Andmed andmed=new Andmed();
    VBox vbox2;
    Scene scene2;
    Label labelaeg;
    ChoiceBox kulunudAeg;
    Label labelotsus;
    ChoiceBox otsus;
    Button button2;
    String aeg;
    String tehtudotus;
    Label label1;
    Label label2;
    Label label3;
    Label label4;


    public Aken(){
        seadistaAken();
        lisaAndmed();
    }

    private void seadistaAken() {
        vbox=new VBox();
        scene=new Scene(vbox,500,500);
        stage.setScene(scene);
        stage.show();

        teema=new TextField();
        teema.setPromptText("Koosoleku teema");
        planeeritudAeg=new TextField();
        planeeritudAeg.setPromptText("Planeeritud aeg teema arutamiseks");
        button= new Button("Salvesta koosoleku teema ja planeeritud aeg");
        label1=new Label();
        label2=new Label();
        label3=new Label();
        label4=new Label();


        vbox.getChildren().addAll(teema, planeeritudAeg, button, label1, label2, label3, label4);

    }

    private void lisaAndmed() {
        button.setOnAction(event -> {
            andmed.lisaAndmed(teema.getText(), Integer.parseInt(planeeritudAeg.getText()));
            uusAken();
            kulunudAeg.getSelectionModel().selectedItemProperty().addListener((observable, oldvalue, newvalue)->{
                aeg=(String)newvalue;
                otsus.getSelectionModel().selectedItemProperty().addListener((observable1, oldvalue1,newvalue1)->{
                    tehtudotus=(String)newvalue1;
                    button2.setOnAction(event1 -> {
                        andmed.lisaKokkuvote(aeg, tehtudotus);
                        stage.setScene(scene);
                        teema.clear();
                        planeeritudAeg.clear();
                        lisaStatistika();

                    });
                });


            });

        });


    }

    private void lisaStatistika() {
        label1.setText(andmed.peetudKoosolekud());
        label2.setText(andmed.onnestunud(aeg, tehtudotus));
        label3.setText(andmed.efektiivsus());

    }
    public void uusAken(){
        vbox2=new VBox();
        scene2=new Scene(vbox2,500,500);
        labelaeg=new Label("Kui koosolek mahtus aega, vasta jah, vastasel juhul vasta ei.");
        kulunudAeg=new ChoiceBox(FXCollections.observableArrayList("jah", "ei"));
        labelotsus=new Label("Kui otsus võeti vastu , vasta jah, vastasel juhul vasta ei.");
        otsus=new ChoiceBox(FXCollections.observableArrayList("jah", "ei"));
        button2= new Button("Salvesta koosoleku kokkuvõte");
        vbox2.getChildren().addAll(labelaeg,kulunudAeg,labelotsus,otsus,button2);
        stage.setScene(scene2);
        stage.show();

    }
}
