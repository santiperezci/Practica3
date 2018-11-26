import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControladorRegistro {
	@FXML
	TextField Usuario;
	@FXML
	TextField password;
	@FXML
	TextField email;
	@FXML
	Button enviar;
	 boolean usuarioRegistrado;
	static Users usuarios;
	 @FXML
	  private void registrarUsuario(ActionEvent event) {
	     String stUsuario = Usuario.getText();
	     String stPassword = password.getText();
	     String stemail = email.getText();
	     
	     escribirPropiedades(stUsuario, stemail, stPassword);
	  }
	 @FXML
	  private void nuevaVentana(ActionEvent event) {
		 try {
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("bienvenido.fxml"));
		 Parent root = fxmlLoader.load();
		 Stage stage = new Stage();
		 stage.initModality(Modality.APPLICATION_MODAL);
		 stage.setOpacity(1);
		 stage.setTitle("My New Stage Title");
		 stage.setScene(new Scene(root, 850,850));
		 stage.showAndWait();
		 }
		 catch(IOException ioe) {
			 ioe.printStackTrace();
		 }
		 
	 }
	 public  void escribirPropiedades(String usuario, String email, String contrase�a) {
		 usuarios=new Users();
	 
		 Properties properties = new Properties();
		 properties.setProperty("username", usuario);
		 properties.setProperty("email", email);
		 properties.setProperty("password", contrase�a);
		 try {
			 properties.store(new FileWriter("Config"),"");
			 boolean a�adido=usuarios.addUsuario(usuario, email, contrase�a);
			 if(a�adido==true) {
				 usuarioRegistrado=true;
				 System.out.println("Bienvenido, �stos son dus datos");
				 System.out.println(email);
			     System.out.println(usuario);
			     System.out.println(contrase�a);
			 }
			 else {
				 System.out.println("Se ha producido un error al a�adir al usuario");
			 }
		 }
		 catch(IOException ioex) {
			 System.out.println(ioex.getMessage());
		 }
}
}
