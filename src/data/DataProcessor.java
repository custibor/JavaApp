package data;

import converter.FileConverter;
import suncertify.db.Data;
import suncertify.db.DatabaseException;

import java.io.IOException;

public class DataProcessor {
    private Data database;
    private FileConverter file_converter;

    public DataProcessor(Data database, FileConverter converter){
        this.database = database;
        this.file_converter = converter;
    }

    public void add_to_database() throws IOException, DatabaseException {
        file_converter.open_file();
        while(file_converter.has_next_line()){
            String[] values = file_converter.convert_line();
            database.add(values);
        }
        file_converter.close_file();
    }

    public void close_database(){

    }


}
