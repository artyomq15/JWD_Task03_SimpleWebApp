package by.tr.simplewebapp.dao.datasource;



public class DataSourceFactory {
    private static final DataSourceFactory instance = new DataSourceFactory();

    private final DataSource dataSource = new DataSource();

    private DataSourceFactory() {}

    public DataSource getDataSource(){
        return dataSource;
    }

    public static DataSourceFactory getInstance() {
        return instance;
    }
}
