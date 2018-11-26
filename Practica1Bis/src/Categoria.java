
public class Categoria {
	private String idCat,nombreCategoria;
	public subCategorias [] nombresSubCategorias;
	public int numSubCategorias;
	public Categoria() {
		numSubCategorias=0;
	}
	public Categoria(String nombre, String id) {
		nombreCategoria=nombre;
		idCat=id;
		numSubCategorias=0;
	}
	public String getNombreCat() {
		return nombreCategoria;
	}
	public String getIdCat() {
		return idCat;
	}
	public void setNombresSubCategorias(String [] nombresSCat) {
		nombresSubCategorias=new subCategorias[nombresSCat.length];
		numSubCategorias=nombresSCat.length;
		for (int i=0; i<nombresSCat.length;i++) {
			try {
				nombresSubCategorias[i]=new subCategorias(nombresSCat[i], nombreCategoria.substring(0, 4) +Integer.toString(i), nombreCategoria) ;
				//nombresSubCategorias[i].setNombresProductos(nombresProds);
				if(i==0) {
					//A MODIFICAR
					System.out.println( nombresSubCategorias[i].getNombrePadre().toUpperCase());
				}
				System.out.println(nombresSubCategorias[i].getNombreSubCat()+ " "+ nombresSubCategorias[i].getIdCat());
				nombresSubCategorias[i].setNombresProductos(nombresSubCategorias[i].getIdCat());
				nombresSubCategorias[i].setNombresProductosOferta(nombresSubCategorias[i].getIdCat());
			}
			catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
	
	}
}
