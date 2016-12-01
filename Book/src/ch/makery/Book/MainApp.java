package ch.makery.Book;

import java.io.IOException;

import ch.makery.Book.model.Book;
import ch.makery.Book.view.BookOverviewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Book");

		initRootLayout();

		showBookOverview();
	}

	/**
	 * Initializes the root layout.
	 */
	public void initRootLayout() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Shows the book overview inside the root layout.
	 */
	public void showBookOverview() {
		try {
			// Load book overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/BookOverview.fxml"));
			AnchorPane bookOverview = (AnchorPane) loader.load();

			// Set book overview into the center of root layout.
			rootLayout.setCenter(bookOverview);

			// give the controller accses to the main app.
			BookOverviewController controller = loader.getController();
			controller.setMainApp(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Returns the main stage.
	 * 
	 * @return
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}

	private ObservableList<Book> bookData = FXCollections.observableArrayList();

	/**
	 * Constructor to charge data
	 */
	public MainApp() {
		bookData.add(new Book("El lazarillo de Tormes", "Anónimo"));
		bookData.add(new Book("Don Quijote", "Miguel de Cervantes"));
		bookData.add(new Book("Don Juan Tenorio", "José Zorrilla"));
		bookData.add(new Book("Rimas", "Gustavo Adolfo Bécquer"));
		bookData.add(new Book("Soleadades", "Antonio Machado"));
		bookData.add(new Book("Luces de Bohemia", "Ramón María del Valle Inclán"));
		bookData.add(new Book("La casa de Bernarda Alba", "Federico García Lorca"));
		bookData.add(new Book("Nada", "Carmen Laforet"));
		bookData.add(new Book("El camino", "Miguel Delibes"));
		bookData.add(new Book("Cien años de soledad", "Gabriel García Márquez"));
	}

	/**
	 * Returns the data as an observable list of Books.
	 * 
	 * @return
	 */
	public ObservableList<Book> getBookData() {
		return bookData;
	}
}