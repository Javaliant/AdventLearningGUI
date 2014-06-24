import java.util.Scanner;
import javax.swing.JFileChooser;

public class FirstFileChooser {
	public static void main(String[] args) throws Exception {
		JFileChooser fileChooser = new JFileChooser();
		if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			// get the selected file
			java.io.File file = fileChooser.getSelectedFile();

			Scanner input = new Scanner(file);

			while (input.hasNext()) { System.out.println(input.nextLine()); }

			input.close(); // close the file
		}
		else { System.out.println("No file selected."); }
	}
}
