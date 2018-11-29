import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CategoriaTest {

	@Test
	void testNombreCategoria() {
		Categoria categoria1 = new Categoria("Alimentos", "Alim");
		/*assertEquals(Categoria.getNombreCat(), "Alimentos");*/
	}
	@Test
	void testIdCategoria() {
		Categoria categoria1 = new Categoria("Alimentos", "Alim");
		/*assertEquals(Categoria.getIdCat(), "Alim");*/
	}

}
