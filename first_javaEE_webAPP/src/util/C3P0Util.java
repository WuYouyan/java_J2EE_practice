package util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;

import javax.sql.DataSource;

public class C3P0Util {
    private static ComboPooledDataSource cpds=new ComboPooledDataSource();

    public static DataSource getDataSource(){
        return cpds;
    }

    public static void main(String[] args) {
        System.out.println(getDataSource());
    }
}
