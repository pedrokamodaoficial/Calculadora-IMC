package com.kamoda.analisecurricular;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.InputMismatchException;

public class HelloController {
    Calculadora calculadora = (p, a) -> p / (a * a);

    @FXML
    private TextField campoPeso;
    @FXML
    private TextField campoAltura;
    @FXML
    private Label labelCalculo;
    @FXML
    private Label labelClassificacao;

    @FXML
    protected void onHelloButtonClick() {
        String peso = campoPeso.getText();
        String altura = campoAltura.getText();

       try {
           double calculo = calculadora.calculo(Double.parseDouble(peso), Double.parseDouble(altura));
           DecimalFormat df = new DecimalFormat("0.00");
           labelCalculo.setText("Seu IMC é: " + df.format(calculo));
           boolean passou = true;

           if (Double.parseDouble(altura) > 2){
               labelCalculo.setText("Insira sua altura em metros, exemplo: 1.80");
               passou = false;
           }

           if (Double.parseDouble(peso) > 200){
               labelClassificacao.setText("Peso inválido");
               passou = false;
           }

           if (passou){
               if (calculo < 18.5){
                   labelClassificacao.setText("Magreza");
               } else if (calculo < 24.9) {
                   labelClassificacao.setText("Normal");
               } else if (calculo < 29.9) {
                   labelClassificacao.setText("Sobrepeso");
               } else if (calculo < 34.9) {
                   labelClassificacao.setText("Obesidade grau 1");
               } else if (calculo < 39.9) {
                   labelClassificacao.setText("Obesidade grau 2");
               } else{
                   labelClassificacao.setText("Obesidade grau 3");
               }
           }

       } catch (NumberFormatException InvocationTargetException){
           labelClassificacao.setText("Preencha os campos primeiros ou insira valores válidos");
       }

    }
}
