import java.util.Random;

import javax.swing.JOptionPane;

import classes.DatabaseAccessThread;
import classes.User;
import database.DatabaseConnectionManager;

public class Login {
  private static Login loginInstance;
  private static String loggedUserId;
  private static DatabaseConnectionManager connection;

  private Login() {
    connection = new DatabaseAccessThread().getConnection();
  }

  public static synchronized Login getInstance() {
    if (loginInstance == null) {
      loginInstance = new Login();
    }
    return loginInstance;
  }

  public static void showLoggedUser() {
    User loggedUser = connection.getUserByPk(loggedUserId);
    if (loggedUser == null) {
      System.out.println("Não ha usuario logado");
    } else {
      System.out.println("User: " + loggedUser.getNome());
      System.out.println("E-mail: " + loggedUser.getEmail());
      System.out.println("Created at: " + loggedUser.getCreatedAt()+ "\n");

    }

  }

  public static void login(String username, String password) {

    User findUser = null;
    for (User user : connection.getUsers()) {
      if (user.getUsername() == username) {
        findUser = user;
        break;
      }
    }

    Boolean passHasEqual = findUser.getPassword() == password;

    if (passHasEqual) {
      if (checkCaptcha()) {
        loggedUserId = findUser.getId();
      }
    } else if (!passHasEqual || findUser == null) {
      System.out.println("Usuario e/ou senha estão incorretos!");
    }

  }

  public static void logout() {
    if (loggedUserId != null) {
      loggedUserId = null;
    }
    System.out.println("...Logout \n");
  }

  private static boolean checkCaptcha() {
    Random generate = new Random();

    String captcha = "";

    for (int i = 0; i < 4; i++) {
      captcha += Character.toString((char) (generate.nextInt(74) + 48));
    }

    String response = JOptionPane.showInputDialog("Verificação, digite a sequencia: " + captcha);

    if (response.intern() == captcha.intern())
      return true;
    return false;

  }
}
