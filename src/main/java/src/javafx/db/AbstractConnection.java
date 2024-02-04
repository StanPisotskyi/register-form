package src.javafx.db;

abstract class AbstractConnection {
    protected String host;
    protected String port;
    protected String user;
    protected String password;
    protected String db;

    public AbstractConnection(String host, String port, String user, String password, String db) {
        this.host = host;
        this.port = port;
        this.user = user;
        this.password = password;
        this.db = db;
    }
}
