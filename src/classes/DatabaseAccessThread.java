package classes;

import database.DatabaseConnectionManager;

public class DatabaseAccessThread {
  DatabaseConnectionManager connection = DatabaseConnectionManager.getInstance();

  public DatabaseConnectionManager getConnection() {
    return connection;
  }

}