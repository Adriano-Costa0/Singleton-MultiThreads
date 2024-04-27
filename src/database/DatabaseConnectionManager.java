package database;

import classes.User;
import java.util.ArrayList;

public class DatabaseConnectionManager  {
  private ArrayList<User> users = new ArrayList<User>();
  private static DatabaseConnectionManager dbInstance;

  public DatabaseConnectionManager () {
    this.populateWithFixture();
  }

  public static synchronized DatabaseConnectionManager getInstance (){
    if (dbInstance == null) {
      dbInstance = new DatabaseConnectionManager();
    }

    return dbInstance;
  }

  public ArrayList<User> getUsers() {
    return users;
  }

  public User getUserByPk(String id){
    User find = null;
    for (User user : users) {
      if(user.getId() == id){
        find = user;
      }
    }
    return find;
  }

  public void deleteUserByPk(String id){
    for (User user : users) {
      if(user.getId() == id){
        users.remove(user);
      }
    }
  }

 

  private void populateWithFixture() {
    users.add(new User("1","Adriano", "adrianocosta@gmail.com", "adrianocosta", "senha123"));
    users.add(new User("2","Pedro Silva", "pedrosilva@gmail.com", "pedrosilva", "senha123"));
    users.add(new User("3","Angela Cardoso", "angelacardoso@gmail.com", "angelacardoso", "senha123"));
    users.add(new User("4","Marilia mendonça", "mariliamendonça@gmail.com", "mariliamendonça", "senha123"));
    users.add(new User("5","Antonio Silva", "antoniosilva@gmail.com", "antoniosilva", "senha123"));
    users.add(new User("6","Neco Peixoto", "necopeixoto@gmail.com", "necopeixoto", "senha123"));
  }
}
