package converter;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * THis class reads a file and converts each line based on the given converter
 */
public class FlightFileConverter implements FileConverter{
    private Converter converter;
    private File file;
    private Scanner scanner;
    private String filename;

    private final String no_file_error = "ERROR: File does not exist";
    private final String read_error = "ERROR: cannot read file";

    /**
     *
     * @param filename the name of the file which contains the data needed to be converted
     * @throws IOException if the file does not exist or cannot be read throw an IOException error
     */
    public FlightFileConverter(String filename) throws IOException {
        this.filename = filename;
        this.file = new File(filename);
        this.converter = new Base_Converter("^");
        this.can_open();
    }

    /**
     *
     * @param filename the name of the file which contains data needed to be converted
     * @param converter the converter which will convert each line of data
     * @throws IOException if the file does not exist or cannot be read throw an IOException
     */
    public FlightFileConverter(String filename, Converter converter) throws IOException {
        this.filename = filename;
        this.file = new File(filename);
        this.converter = converter;
        this.can_open();
    }
    
    public Converter get_converter() {
        return converter;
    }

    public File get_File() {
        return file;
    }

    public Scanner get_scanner() {
        return scanner;
    }

    public String get_Filename() {
        return filename;
    }

    public void set_converter(Converter converter) {
        this.converter = converter;
    }

    public void set_File(File file) {
        this.file = file;
    }

    public void set_scanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public void set_Filename(String filename) {
        this.filename = filename;
    }

    /**
     * opens the file with the Scanner object
     * @throws IOException if the file does not exist or cannot be read throw a error
     */
    public void open_file()throws IOException {
        can_open();
        scanner = new Scanner(file);
    }

    /**
     * Checks if file has next line
     * @return boolean True if file has next line, false otherwise
     */
    public boolean has_next_line(){
        return scanner.hasNextLine();
    }

    /**
     * converts a line read from the file
     * @return String[] of elements converted
     */
    public String[] convert_line(){
        String line = scanner.nextLine();
        return converter.convert_string(line);
    }

    /**
     * closes scanner object and releases resources
     */
    public void close_file(){
        scanner.close();
    }

    /**
     * checks if the file can be opened
     * @throws IOException if the file does not exist or cannot be read throw a error
     *
     */
    public void can_open() throws IOException {
        if(!file.exists()){
            throw new IOException(no_file_error);
        }
        if(!file.canRead()){
            throw new IOException(read_error);
        }
    }
}
