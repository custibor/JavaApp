package data;

import suncertify.db.Data;
import suncertify.db.FieldInfo;

import java.io.IOException;

/**
 * This class simplifies the creation of the flight database
 */
public class FlightDataBaseHandler implements DataBaseHandler{
    private final static  String[] field_names = {"Flight number","Origin airport","Destination airport","Carrier","Price",
            "Day","Time","Duration","Available seats"};
    private final static int[]    field_sizes = {5,3,3,50,20,20,20,20,5};

    public FlightDataBaseHandler(String database_name) throws IOException {
        Data db;
        try{
            db = new Data(database_name);
        } catch (IOException e) {
            db = create_database(database_name);
        }

    }

    /**
     * Creates a database using the FieldInfo class and field_names, field_size
     * Created specificaly for the flight database
     * @param database_name the name of the created database
     * @return Data the created database
     * @throws IOException
     */
    public Data create_database(String database_name) throws IOException {
        FieldInfo[] finfos = new FieldInfo[field_names.length];

        for(int i = 0; i < field_names.length; i++){
            finfos[i] = new FieldInfo(field_names[i],field_sizes[i]);
        }
        return new Data(database_name,finfos);
    }

    /**
     * OReturns the specified databases
     * @param filename the name of the database
     * @return Data the database specified
     * @throws IOException if the database does not exist or it cannot be obent throw an IOException
     */
    public Data get_database(String filename) throws IOException {
        return new Data(filename);
    }

}
