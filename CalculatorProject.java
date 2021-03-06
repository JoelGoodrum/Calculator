//javafx imports
import javafx.application.Application; 
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.scene.paint.Color; 
import javafx.stage.Stage;  
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.*;
import java.io.*;

//main method
public class CalculatorProject extends Application {

	//launch program
	public static void main(String[] args){
		launch(args);
	}

	//display app
	@Override
	public void start(Stage primaryStage) throws Exception{

		//String on calc
		ArrayList<String> varList = new ArrayList<String>();
		
		//Vbox layout
		VBox vbox = new VBox();

		//text field obj
		TextField textField = new TextField();

		//get CSS


		//text field style
		textField.setPrefHeight(70);
		textField.setStyle("-fx-font-size:25px");

		//set text to textfield
		textField.setText(calcText(varList));
							

		//BTN OBJS1//
		Button btn7 = new Button("7");
		btn7.setId("button");
		btn7.getStylesheets().add("CalcStyle.css");
		btn7.setOnAction(actionEvent -> {
	        addVal(varList,"7");
	        textField.setText(calcText(varList));
		});

		Button btn8 = new Button("8");
		btn8.setId("button");
		btn8.getStylesheets().add("CalcStyle.css");
		btn8.setOnAction(actionEvent -> {
	        addVal(varList,"8");
	       	textField.setText(calcText(varList));
		});

		Button btn9 = new Button("9");
		btn9.setId("button");
		btn9.getStylesheets().add("CalcStyle.css");
		btn9.setOnAction(actionEvent -> {
	        addVal(varList,"9");
	       	textField.setText(calcText(varList));
		});

		Button btnMult = new Button("*");
		btnMult.setId("button");
		btnMult.getStylesheets().add("CalcStyle.css");
		btnMult.setOnAction(actionEvent -> {
	        addVal(varList,"*");
	       	textField.setText(calcText(varList));
		});
		//END BTN OBJS//

		//add buttons to hbox1
		HBox hbox1 = new HBox();
		hbox1.getChildren().addAll(btn7,btn8,btn9,btnMult);

		
		//BTN OBJS2//
		Button btn4 = new Button("4");
		btn4.setId("button");
		btn4.getStylesheets().add("CalcStyle.css");
		btn4.setOnAction(actionEvent -> {
	        addVal(varList,"4");
	       	textField.setText(calcText(varList));
		});

		Button btn5 = new Button("5");
		btn5.setId("button");
		btn5.getStylesheets().add("CalcStyle.css");
		btn5.setOnAction(actionEvent -> {
	        addVal(varList,"5");
	       	textField.setText(calcText(varList));
		});

		Button btn6 = new Button("6");
		btn6.setId("button");
		btn6.getStylesheets().add("CalcStyle.css");
		btn6.setOnAction(actionEvent -> {
	        addVal(varList,"6");
	       	textField.setText(calcText(varList));
		});

		Button btnDiv = new Button("/");
		btnDiv.setId("button");
		btnDiv.getStylesheets().add("CalcStyle.css");
		btnDiv.setOnAction(actionEvent -> {
	        addVal(varList,"/");
	       	textField.setText(calcText(varList));
		});
		//END BTN OBJS2//

		//add buttons to hbox2
		HBox hbox2 = new HBox();
		hbox2.getChildren().addAll(btn4,btn5,btn6,btnDiv);


		//BTN OBJS3//
		Button btn1 = new Button("1");
		btn1.setId("button");
		btn1.getStylesheets().add("CalcStyle.css");
		btn1.setOnAction(actionEvent -> {
	        addVal(varList,"1");
	       	textField.setText(calcText(varList));
		});

		Button btn2 = new Button("2");
		btn2.setId("button");
		btn2.getStylesheets().add("CalcStyle.css");
		btn2.setOnAction(actionEvent -> {
	        addVal(varList,"2");
	       	textField.setText(calcText(varList));
		});

		Button btn3 = new Button("3");
		btn3.setId("button");
		btn3.getStylesheets().add("CalcStyle.css");
		btn3.setOnAction(actionEvent -> {
	        addVal(varList,"3");
	       	textField.setText(calcText(varList));
		});

		Button btnPlus = new Button("+");
		btnPlus.setId("button");
		btnPlus.getStylesheets().add("CalcStyle.css");
		btnPlus.setOnAction(actionEvent -> {
	        addVal(varList,"+");
	       	textField.setText(calcText(varList));
		});
		//END BTN OBJS3//

		//add buttons to hbox3
		HBox hbox3 = new HBox();
		hbox3.getChildren().addAll(btn1,btn2,btn3,btnPlus);

		//button objs4
		Button btnDecimal = new Button(".");
		btnDecimal.setId("button");
		btnDecimal.getStylesheets().add("CalcStyle.css");
		btnDecimal.setOnAction(actionEvent -> {
	        addVal(varList,".");
	        textField.setText(calcText(varList));
		});

		Button btn0 = new Button("0");
		btn0.setId("button");
		btn0.getStylesheets().add("CalcStyle.css");
		btn0.setOnAction(actionEvent -> {
	        addVal(varList,"0");
	        textField.setText(calcText(varList));
		});

		Button btnClear = new Button("CL");
		btnClear.setId("button");
		btnClear.getStylesheets().add("CalcStyle.css");
		btnClear.setOnAction(actionEvent -> {
	        varList.removeAll(varList);
	        textField.setText(calcText(varList));
		});

		Button btnMinus = new Button("-");
		btnMinus.setId("button");
		btnMinus.getStylesheets().add("CalcStyle.css");
		btnMinus.setOnAction(actionEvent -> {
	        addVal(varList,"-");
	        textField.setText(calcText(varList));
		});


		//add buttons to hbox4
		HBox hbox4 = new HBox();
		hbox4.getChildren().addAll(btnDecimal,btn0,btnClear,btnMinus);

		//hbox 5
		HBox hbox5 = new HBox();
		Button btnEqual = new Button("=");
		btnEqual.setId("equal_button");
		btnEqual.getStylesheets().add("CalcStyle.css");
		btnEqual.setOnAction(actionEvent -> {
			System.out.println(varList);
			System.out.println(checkSyntax(varList));
			final String answer = solution(varList);
	       	textField.setText(answer);
	       	System.out.print(varList);
		});

		hbox5.getChildren().addAll(btnEqual);

		//add objects to vbox
		vbox.getChildren().addAll(textField,hbox1,hbox2,hbox3,hbox4,hbox5);

		//set title page
		primaryStage.setTitle("sample");

		//scene obj
		Scene scene = new Scene(vbox,300,445);
		

		//set scene to stage
		primaryStage.setScene(scene);

		//display the stage
		primaryStage.show();

	}

	//addNumbers properly to calcVar
	public static void addVal(ArrayList<String> arr, String input){
		if(arr.size() > 0){
			if(arr.get(0).equals("Error"))
			arr.removeAll(arr);
		}
		
		//if input is operator
		if(input.equals("*") || input.equals("/") ||
		   input.equals("+") || input.equals("-")){
			//add at the end
			arr.add(input);

		}

		//else
		else{

			//add numb to last val
			if(arr.size() == 0){
				//add numb
				arr.add(input);
			}

			else{

				//is prev variable is operator, add numb
				String prevVar = arr.get(arr.size() - 1);
				if(prevVar.equals("*") || prevVar.equals("/") ||
		  		   prevVar.equals("+") || prevVar.equals("-")){
					arr.add(input);		
				}

				else{ //make numb bigger
					String newVal = arr.get(arr.size() - 1) + input + "";
					arr.set(arr.size() - 1, newVal);
				}
			}
		}
	}


	//display text on calculator
	public String calcText(ArrayList<String> arr){
		String text = "";
		for(int i = 0; i < arr.size(); i++){
			text+= arr.get(i);
		}

		return text;
	}

	//checkSyntax
	public boolean checkSyntax(ArrayList<String> arr){

		if(arr.size() > 2){

			String firstVar = arr.get(0); //first val
			String lastVar = arr.get(arr.size()-1); //last val

			//if starts or end with opp return false
			if(firstVar.equals("*") || firstVar.equals("/") ||
			   firstVar.equals("+") || firstVar.equals("-") ||
			   lastVar.equals("*") || lastVar.equals("/") ||
			   lastVar.equals("+") || lastVar.equals("-")){
				return false;
			
			}
			   

			//if there are two opps in a row return false
			for(int i = 0; i < arr.size() - 1; i++){

				firstVar = arr.get(i);
				String secVar = arr.get(i + 1);

				if( (firstVar.equals("*") || firstVar.equals("/") ||
			   	   firstVar.equals("+") || firstVar.equals("-")) &&
				   (secVar.equals("*") || secVar.equals("/") ||
			   	   secVar.equals("+") || secVar.equals("-")) ){
					return false;
				}
			}

		} else{
			return false;
		}
	
		return true;
	}

	//solve arithmatic
	public String solution(ArrayList<String> arr){

		if(arr.size() == 1){
			return arr.get(0);
		}

		else if(checkSyntax(arr) == true){ //compute

			if(arr.contains("*")){
				int i = arr.indexOf("*");
				arr.set(i, operations(arr.get(i-1), arr.get(i + 1), arr.get(i)));
				arr.remove(i+1);
				arr.remove(i-1);
				return solution(arr);
			}

			else if(arr.contains("/")){
				int i = arr.indexOf("/");
				arr.set(i, operations(arr.get(i-1), arr.get(i + 1), arr.get(i)));
				arr.remove(i+1);
				arr.remove(i-1);
				return solution(arr);
			}

			else if(arr.contains("+")){
				int i = arr.indexOf("+");
				arr.set(i, operations(arr.get(i-1), arr.get(i + 1), arr.get(i)));
				arr.remove(i+1);
				arr.remove(i-1);
				return solution(arr);
			}

			else if(arr.contains("-")){
				int i = arr.indexOf("-");
				arr.set(i, operations(arr.get(i-1), arr.get(i + 1), arr.get(i)));
				arr.remove(i+1);
				arr.remove(i-1);
				return solution(arr);
			}
		
			else{
				throw new NoSuchElementException();
			}
			

		}

		//show Error message
		else{	
			arr.removeAll(arr);
			arr.add("Error");			
			return arr.get(0);
		}
		

	}

	//operation method
	public String operations(String A, String B, String opp){
		

		double a = Double.parseDouble(A);
		double b = Double.parseDouble(B);

		if(opp.equals("*")){
			return a * b + "";
		}

		else if(opp.equals("/")){
			return a / b + "";
		}

		else if(opp.equals("+")){
			return a + b + "";
		}

		else if(opp.equals("-")){
			return a - b + "";
		}

		else{
			throw new NoSuchElementException();
		}
	}


}

