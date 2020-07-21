package converter;

public interface Converter {
    public String[] convert_string(String entry);
    public void set_split_symbol(String split_symbol);
    public String get_split_symbol();
}
