package data;

import suncertify.db.Data;
import suncertify.db.FieldInfo;

import java.io.IOException;

public interface DataBaseHandler {

    public Data create_database(String database_name) throws IOException;


}
