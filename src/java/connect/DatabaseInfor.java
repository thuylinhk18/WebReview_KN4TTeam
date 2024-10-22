/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connect;

/**
 *
 * @author bebet
 */
public interface DatabaseInfor {
     public static final String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static final String url = "jdbc:sqlserver://localhost:1433;databaseName=travel_review_website;encrypt=true;trustServerCertificate=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
    public static final String user = "sa";
    public static final String pass = "admin";
}
