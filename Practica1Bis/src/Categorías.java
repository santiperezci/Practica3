import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;

public class Categor�as implements Organization{
	int numCategorias;
	Categoria [ ] nombresCategorias;
	public Categor�as() {
		nombresCategorias = new Categoria[40];
		int i=0;
		try {
			FileReader fr = new FileReader("Categorias.txt"); 
			BufferedReader br = new BufferedReader(fr);
			String categ=br.readLine();
			while(categ!=null) {		
				String[] parts = categ.split(",");
				String nombre = parts[0]; 
				String id = parts[1]; 
				nombresCategorias[i]=new Categoria(nombre,id);
				numCategorias++;
				categ=br.readLine();
				i++;
			}
			br.close();
		}
		catch(IOException iox) {
			System.out.println(iox.getMessage());
		}
		/*nombresCategorias =new Categoria[] {new Categoria("Alimentos","Al"),new Categoria("Moda","Mod"),new Categoria("Electr�nica","El"),
				new Categoria("Libros","lib")};*/
		try {
			String path = new File(".").getCanonicalPath()+ "\\Subcategorias\\";
			for(int j=0; j<numCategorias;j++) {
				FileReader fr=new FileReader(path+ nombresCategorias[j].getNombreCat()+".txt");
				BufferedReader br=new BufferedReader (fr);
				String [] nombresSubCats=new String[3];
				int n=0;
				String linea=br.readLine();
				while(linea!=null) {
					nombresSubCats[n]=linea;
					linea=br.readLine();
					n++;
				}
				nombresCategorias[j].setNombresSubCategorias(nombresSubCats);
			}
			
		}
		catch(IOException ioex) {
			
		}
		/*nombresCategorias[0].setNombresSubCategorias(new String[]{"Alimentos y bebidas", "productos eco", "bebidas alcoh�loicas"});
		nombresCategorias[1].setNombresSubCategorias(new String[] {"Mujer", "Hombre", "Beb�"});
		nombresCategorias[2].setNombresSubCategorias(new String[] {"Fotograf�a", "M�viles", "Inform�tica"});
		nombresCategorias[3].setNombresSubCategorias(new String[] {"Electr�nicos", "Infantiles", "Poes�a"});
		numCategorias=4;*/
	}
	public subCategorias encontrarSubCategoria(String idSubCat) {
		subCategorias sc=null;
		for(int i=0; i<numCategorias;i++) {
			for(int j=0;j<nombresCategorias[i].numSubCategorias;j++) {
				if(idSubCat.equals(nombresCategorias[i].nombresSubCategorias[j].getIdCat())) {
				sc= nombresCategorias[i].nombresSubCategorias[j];
				}
			}
		}
		return sc;
	}
	public void listar() {
		for(int i=0; i<numCategorias-1;i++) {
			
		nombresCategorias[i].getNombreCat();
		for(int j=0;j<nombresCategorias[i].numSubCategorias-1;j++) {
				//A MODIFICAR
				System.out.println(nombresCategorias[i].nombresSubCategorias[j].getNombreSubCat());
			}
		}	
	}
}
