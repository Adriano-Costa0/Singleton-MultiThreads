
public class Main {
  public static void main(String[] args) {
    Login instance1 = Login.getInstance();
    Login instance2 = Login.getInstance();
    Login instance3 = Login.getInstance();
    Login instance4 = Login.getInstance();
    Login instance5 = Login.getInstance();

    instance1.showLoggedUser();
    instance1.login("adrianocosta", "senha123");

    instance2.showLoggedUser();
    instance2.logout();
    instance3.showLoggedUser();
    instance4.showLoggedUser();
    instance3.login("mariliamendonça", "senha123");
    instance1.showLoggedUser();
    instance5.showLoggedUser();
  }
}