package by.tr.simplewebapp.dao.datasource;


import com.mysql.cj.jdbc.MysqlDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public final class DataSource {

    private final String FILE_PATH = "db.properties";
    private final InputStream UNIQUE_FILE_PATH = DataSource.class.getResourceAsStream(FILE_PATH);

    public MysqlDataSource getMysqlDataSource(){
        Properties properties = new Properties();
        MysqlDataSource mysqlDataSource;
        System.out.println(UNIQUE_FILE_PATH);
        try(InputStreamReader reader = new InputStreamReader(UNIQUE_FILE_PATH)) {
            properties.load(reader);
            mysqlDataSource = new MysqlDataSource();
            mysqlDataSource.setURL(properties.getProperty("MYSQL_DB_URL"));
            mysqlDataSource.setUser(properties.getProperty("MYSQL_DB_USERNAME"));
            mysqlDataSource.setPassword(properties.getProperty("MYSQL_DB_PASSWORD"));
        } catch (IOException ex){
            mysqlDataSource = null;
        }
        return mysqlDataSource;
    }
}
