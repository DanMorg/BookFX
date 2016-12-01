package ch.makery.Book.view;


import ch.makery.Book.MainApp;
import ch.makery.Book.model.Book;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class BookOverviewController {
	@FXML
	private TableView<Book> bookTable;
	@FXML
	private TableColumn<Book, String> titleColumn;
	@FXML
	private TableColumn<Book, String> typeColumn;

	@FXML
	private Label titleLabel;
	@FXML
	private Label typeLabel;
	@FXML
	private Label editorialLabel;
	@FXML
	private Label pageLabel;
	@FXML
	private Label authorLabel;
	@FXML
	private Label VersionLabel;

	// Reference to the main application.
	private MainApp mainApp;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public BookOverviewController() {
	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		// Initialize the person table with the two columns.
		titleColumn.setCellValueFactory(cellData -> cellData.getValue().getTitle());
		typeColumn.setCellValueFactory(cellData -> cellData.getValue().getType());

		// Clear person details
		showBookDetails(null);

		// Listen for selection and show the books deatis.
		bookTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showBookDetails(newValue));
	}

	/**
	 * Is called by the main application to give a reference back to itself.
	 * 
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

		// Add observable list data to the table
		bookTable.setItems(mainApp.getBookData());
	}

	private void showBookDetails(Book book) {
		if (book != null) {
			// Fill the labels with info from the person object.
			titleLabel.setText(book.getTitle().toString());
			typeLabel.setText(book.getType().toString());
			authorLabel.setText(book.getAuthor().toString());
			pageLabel.setText(book.getPages().toString());
			VersionLabel.setText(book.getVersion().toString());

			// TODO: We need a way to convert the birthday into a String!
			// birthdayLabel.setText(...);
		} else {
			// Person is null, remove all the text.
			titleLabel.setText("");
			typeLabel.setText("");
			authorLabel.setText("");
			pageLabel.setText("");
			VersionLabel.setText("");
		}
	}

//	/**
//	 * Called when the user clicks on the delete button.
//	 * 
//	 */
//	@FXML
//	private void handleDeleteBook() {
//		int selectedIndex = bookTable.getSelectionModel().getSelectedIndex();
//		bookTable.getItems().remove(selectedIndex);
//		if (selectedIndex >= 0) {
//			bookTable.getItems().remove(selectedIndex);
//		} else {
//			// Nothing selected.
//			Dialogs.create().title("No Selection").masthead("No Person Selected")
//					.message("Please select a person in the table.").showWarning();
//		}

	}
