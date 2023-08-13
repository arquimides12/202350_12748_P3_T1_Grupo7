package comple;
import java.util.ArrayList;
import java.util.List;
public class GrafoCafeteria {
	private int[][] matrizAdyacencia;
	private List<String> bebidas;
	// Constructor
	//Se inicializa la matriz de adyacencia y la lista de bebidas
	public GrafoCafeteria(int numBebidas) {
		matrizAdyacencia = new int[numBebidas][numBebidas];// Complejidad O(V^2)
		bebidas = new ArrayList<>();

		for (int i = 0; i < numBebidas; i++) {// Complejidad O(V)
			for (int j = 0; j < numBebidas; j++) { // Complejidad O(V)
				matrizAdyacencia[i][j] = 0; // Complejidad O(1)
			}
		}
	}
	//metodos
	//agregar una bebida a la lista.
	public void agregarBebida(String bebida) {
		bebidas.add(bebida); // Complejidad O(1)
	}
	//agregar una relación entre bebidas en la matriz de adyacencia
	public void agregarRelacion(int bebidaOrigen, int bebidaDestino) {
		matrizAdyacencia[bebidaOrigen][bebidaDestino] = 1; // Complejidad O(1)
	}
	//mostrar el menú de la cafetería con las relaciones.
	public String obtenerMenu() {
		StringBuilder menu = new StringBuilder("Menú de la cafetería:\n");
		for (int i = 0; i < bebidas.size(); i++) { // Complejidad O(V)
			menu.append(bebidas.get(i)).append(" tiene relación con: ");
			boolean tieneRelaciones = false;
			for (int j = 0; j < bebidas.size(); j++) { // Complejidad O(V)
				if (matrizAdyacencia[i][j] == 1) {// Complejidad O(1)

					if (tieneRelaciones) {
						menu.append(", ");
					}
					menu.append(bebidas.get(j));
					tieneRelaciones = true;
				}
			}
			if (!tieneRelaciones) {
				menu.append("ninguna");
			}
			menu.append("\n");
		}
		return menu.toString(); // Complejidad O(V^2)
	}
}
