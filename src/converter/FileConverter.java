package converter;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public interface FileConverter {

    public Converter get_converter();

    public String get_Filename();

    public void set_converter(Converter converter);

    public void set_Filename(String filename);

    public void can_open() throws IOException;

    public void close_file();

    public void open_file() throws IOException;

    public String[] convert_line();

    public boolean has_next_line();
}
