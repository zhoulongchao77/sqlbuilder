package sample.util;

public class KnexSql implements BuilderSql {

    @Override
    public String builder(String str) {
        int splitIndex = str.indexOf("[");
        String sql = str.substring(0, splitIndex);
        String values = str.substring(splitIndex);
        values = values.substring(1, values.length() - 1);
        values = values.replaceAll("\n", "");
        String[] strings = values.split(",");
        for (int i = 0; i < strings.length; i++) {
            sql = sql.replaceFirst("\\?", strings[i].trim());
        }
        return BasicFormatter.format(sql);
    }
}
