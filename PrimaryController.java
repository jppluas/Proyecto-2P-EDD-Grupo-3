package grupo3.grupo_03;

import grupo3.grupo_03.treemap.ClasePrueba;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author mbravop
 */
public class PrimaryController{
    
    boolean tipoNodo = false;//false para VBox, true para HBox

    @FXML
    private FlowPane fpBase;
    
    
    ArrayList<ClasePrueba> listaPrueba = new ArrayList<>();

    
    public void initialize() {
        llenarLista();
        crearCuadrosRecursivo(fpBase,listaPrueba);
    }
    
    public void llenarLista(){
        
        ClasePrueba conHijos2 = new ClasePrueba("archivo2",300);
        ArrayList<ClasePrueba> hijos2do = new ArrayList<>();
        
        hijos2do.add(new ClasePrueba("archivo4",100));
        hijos2do.add(new ClasePrueba("archivo5",100));
        hijos2do.add(new ClasePrueba("archivo6",100));
        
        conHijos2.setHijos(hijos2do);
        
        ClasePrueba conHijos3 = new ClasePrueba("archivo3",500);
        ArrayList<ClasePrueba> hijos3er = new ArrayList<>();
        
        ClasePrueba conHijosHijos3 = new ClasePrueba("archivo8",150);
        ArrayList<ClasePrueba> hijos3er3er = new ArrayList<>();
        
        hijos3er3er.add(new ClasePrueba("archivo10",50));
        hijos3er3er.add(new ClasePrueba("archivo11",100));
        conHijosHijos3.setHijos(hijos3er3er);
        
        hijos3er.add(new ClasePrueba("archivo7",100));
        hijos3er.add(conHijosHijos3);
        hijos3er.add(new ClasePrueba("archivo9",250));
        
        conHijos3.setHijos(hijos3er);
        
        listaPrueba.add(new ClasePrueba("archivo1",100));
        listaPrueba.add(conHijos2);
        listaPrueba.add(conHijos3);
        
    }
    
    public double totalLista(ArrayList<ClasePrueba> listaHijos){
        double suma = 0;
        for(ClasePrueba c: listaHijos){
            suma += c.getTamano();
        }
        return suma;
    }
    
    public double porcentaje(ClasePrueba c, ArrayList<ClasePrueba> listaHijos){
        return (c.getTamano()*100)/totalLista(listaHijos);
    }
    
    public void crearCuadros(){
        ArrayList<Node> listaCuadros = new ArrayList<>();
        for(ClasePrueba c: listaPrueba){
            double tamano = (porcentaje(c,listaPrueba)*fpBase.getPrefWidth())/100;
            if(tipoNodo){
                HBox hNuevo = new HBox();
                hNuevo.setPrefWidth(tamano);
                hNuevo.setPrefHeight(fpBase.getPrefHeight());
                ponerBorde(hNuevo);
                listaCuadros.add(hNuevo);
            }else{
                VBox hNuevo = new VBox();
                hNuevo.setPrefWidth(tamano);
                hNuevo.setPrefHeight(fpBase.getPrefHeight());
                ponerBorde(hNuevo);

                listaCuadros.add(hNuevo);
            }
            /*
            if(c.tieneHijos()){
                listaCuadros.clear();
                if(tipoNodo){
                    HBox hNuevo = new HBox();
                    hNuevo.setPrefWidth(tamano);
                    hNuevo.setPrefHeight(fpBase.getPrefHeight());
                    ponerBorde(hNuevo);
                    listaCuadros.add(hNuevo);
                }else{
                    VBox hNuevo = new VBox();
                    hNuevo.setPrefWidth(tamano);
                    hNuevo.setPrefHeight(fpBase.getPrefHeight());
                    ponerBorde(hNuevo);

                    listaCuadros.add(hNuevo);
            }
            }*/ 
        }
        fpBase.getChildren().addAll(listaCuadros);
    }
    
    
    public void crearCuadrosRecursivo(Pane creador, ArrayList<ClasePrueba> listaDeHijos){
        int contador = 0;
        for(ClasePrueba c: listaDeHijos){
            contador++;
            System.out.println(c.getNombre());
            double tamano;
            Pane contenedorGeneral;
            if(!tipoNodo){
                contenedorGeneral = new VBox();
                tamano = (porcentaje(c,listaDeHijos)*creador.getPrefWidth())/100;
                contenedorGeneral.setPrefWidth(tamano);
                contenedorGeneral.setPrefHeight(creador.getPrefHeight());
            }else{
                contenedorGeneral = new HBox();
                tamano = (porcentaje(c,listaDeHijos)*creador.getPrefHeight())/100;
                contenedorGeneral.setPrefWidth(creador.getPrefWidth());
                contenedorGeneral.setPrefHeight(tamano);
                System.out.println(tamano);
                System.out.println(creador.getPrefWidth());
            }
            ponerBorde(contenedorGeneral);
            creador.getChildren().add(contenedorGeneral);
            
            if(!c.tieneHijos()){
                if(contador==listaDeHijos.size() && contenedorGeneral.getClass()==new VBox().getClass()) tipoNodo=true;
                if(contador==listaDeHijos.size() && contenedorGeneral.getClass()!=new VBox().getClass()) tipoNodo=false;
                System.out.println("sin hijos");
            }else{
                tipoNodo= !tipoNodo;
                //if(contador==listaDeHijos.size())tipoNodo=true;
                crearCuadrosRecursivo(contenedorGeneral,c.getHijos());
            }
        }
    }
    
    
    
    public void ponerBorde (Node xd){
        ArrayList<String> listaColores = new ArrayList<>(Arrays.asList("red",
                          "orange",
                          "blue","pink","brown","gray","lightblue"));
        
        Collections.shuffle(listaColores);
        
        xd.setStyle("-fx-border-style: solid inside;"
        + "-fx-border-width: 2;"
        + "-fx-border-radius: 5;" + "-fx-border-color: green;" + "-fx-background-color:"+listaColores.get(0)+"");
    }
    
}
