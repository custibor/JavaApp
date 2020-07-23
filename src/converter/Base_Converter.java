package converter;

/**
 * This class is used to split an input strings based on a split symbol
 */
public class Base_Converter implements Converter{
    private String split_symbol;
    private boolean strip_entry;


    public Base_Converter(){
        split_symbol = " ";
        strip_entry = true;
    }
    public Base_Converter(String split_symbol){
        this.split_symbol = split_symbol;
        strip_entry = true;
    }
    public Base_Converter(String split_symbol, boolean strip_entry){
        this.split_symbol = split_symbol;
        this. strip_entry = strip_entry;
    }
    @Override
    public void set_split_symbol(String split_symbol){
        this.split_symbol = split_symbol;
    }

    @Override
    public String get_split_symbol(){
        return split_symbol;
    }
    
    public void set_strip_entry(final boolean strip_entry){
        this.strip_entry = strip_entry;
    }
    
    public boolean get_strip_entry(){
        return strip_entry;
    }


    /**
     * This functions splits a given string based on the split_symbol
     * if strip_entry is true, leading and trailing whitespace will be removed
     * @param entry the string to split
     * @return String[] - string array of all split values of entry
     */
    @Override
    public String[] convert_string(String entry){
        String[] data;
        if(strip_entry){
            //entry = entry.strip();
        }
        data = entry.split("@");
        return data;
    }
}
