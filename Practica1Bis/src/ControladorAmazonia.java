import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControladorAmazonia implements Initializable {
	static User usuario;
	static Users usuarios;
	static boolean usuarioRegistrado;
	static Categorías amazonia;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		usuarioRegistrado=false;
		//System.out.println("Bienvenido a nuestra web, again");
		leerPropiedades();
		usuarios=new Users();
		if(usuarios.verificar(usuario)==false) {
			System.out.println("Usuario no registrado");
			registrarUsuarioW();
		}
		else {
			usuarioRegistrado=true;
			
		}
		amazonia=new Categorías();
	}
	private static void registrarUsuarioW() {
		// TODO Auto-generated method stub
		
	}
	public static void leerPropiedades() {
		String email="", username="", password="";
	
		try(FileReader reader =  new FileReader("config")) {
	        Properties properties = new Properties();
	        properties.load(reader);
	        email = properties.getProperty("email");
	        username = properties.getProperty("username");
	        password = properties.getProperty("password");
		}
	        catch (Exception e) {
	       e.printStackTrace();
	       }
	        if(email!=null && username!=null && password!=null) {
	        	usuario=new User(username, email, password);
	        	//@FXML
	        	/*try {
	        		FXMLLoader fxmlLoader = new FXMLLoader(ControladorAmazonia.class.getClass().getClassLoader().getResource("registro.fxml"));
		        	 Parent root = fxmlLoader.load();
		       		 Stage stage = new Stage();
		       		 stage.initModality(Modality.APPLICATION_MODAL);
		       		 stage.setOpacity(1);
		       		 stage.setTitle("My New Stage Title");
		       		 stage.setScene(new Scene(root, 850,850));
		       		 stage.showAndWait();*/
	       		/* }
	       		 catch(IOException ioe) {
	       			 ioe.printStackTrace();
	       		 
	        	System.out.println(usuario.email);
		        System.out.println(usuario.name);
		        System.out.println(usuario.password);*/
	       		 }
	        
	        }
	}

