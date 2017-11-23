package by.tr.simplewebapp.dao.datasource;


import com.mysql.cj.jdbc.MysqlDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public final class DataSource {

    private final String FILE_PATH = "db.properties";
    private final InputStream UNIQUE_FILE_PATH = DataSource.class.getResourceAsStream(FILE_PATH);

    private final String URL_ATTR_NAME = "MYSQL_DB_URL";
    private final String USERNAME_ATTR_NAME = "MYSQL_DB_USERNAME";
    private final String PASSWORD_ATTR_NAME = "MYSQL_DB_PASSWORD";

    public MysqlDataSource getMysqlDataSource(){
        Properties properties = new Properties();
        MysqlDataSource mysqlDataSource;
        System.out.println(UNIQUE_FILE_PATH);
        try(InputStreamReader reader = new InputStreamReader(UNIQUE_FILE_PATH)) {
            properties.load(reader);
            mysqlDataSource = new MysqlDataSource();
            mysqlDataSource.setURL(properties.getProperty(URL_ATTR_NAME));
            mysqlDataSource.setUser(properties.getProperty(USERNAME_ATTR_NAME));
            mysqlDataSource.setPassword(properties.getProperty(PASSWORD_ATTR_NAME));
        } catch (IOException ex){
            mysqlDataSource = null;// если берешь где-то код - обрабатывай его
            // мы проходили, что надоделать с исключениями
        }
        return mysqlDataSource;
    }
}
