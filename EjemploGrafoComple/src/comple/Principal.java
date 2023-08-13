package comple;
//import java.util.Scanner;
import javax.swing.JOptionPane;
public class Principal {
	public static void main(String[] args) {
		int numBebidas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de bebidas:"));
		GrafoCafeteria grafoCafeteria = new GrafoCafeteria(numBebidas);
		// nombres de bebidas y agregarlas al grafo
		for (int i = 0; i < numBebidas; i++) {
			String bebida = JOptionPane.showInputDialog("Ingrese el nombre de la bebida " + (i + 1) + ":");
			grafoCafeteria.agregarBebida(bebida);
		}
		int opcion;
		do {
			String menu = JOptionPane.showInputDialog("Elija una opción:\n" +
					"1. Agregar relación entre bebidas\n" +
					"2. Mostrar menú\n" +
					"3. Salir");
			opcion = Integer.parseInt(menu);
			switch (opcion) {
			case 1:
				// Solicitar información y agregar relación
				int origen = Integer.parseInt(JOptionPane.showInputDialog("Seleccione la bebida de origen:"));
				int destino = Integer.parseInt(JOptionPane.showInputDialog("Seleccione la bebida de destino:"));
				grafoCafeteria.agregarRelacion(origen - 1, destino - 1);
				break;
			case 2:
				// Mostrar menú de la cafetería
				JOptionPane.showMessageDialog(null, grafoCafeteria.obtenerMenu());
				break;
			}
		} while (opcion != 3);

		JOptionPane.showMessageDialog(null, "¡Gracias por visitar la cafetería ANDES!");
	}//
}
