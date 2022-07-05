package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);
      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      Car bmw = new Car("bmw", 7);
      bmw.setUser(user1);
      userService.addUser(user1);
      carService.addCar(bmw);
      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      Car mers = new Car("mers", 600);
      mers.setUser(user2);
      userService.addUser(user2);
      carService.addCar(mers);
      User user3 = new User("User3", "Lastname3", "user3@mail.ru");
      Car ford = new Car("ford", 150);
      ford.setUser(user3);
      userService.addUser(user3);
      carService.addCar(ford);
      User user4 = new User("User4", "Lastname4", "user4@mail.ru");
      Car mazda = new Car("mazda", 3);
      mazda.setUser(user4);
      userService.addUser(user4);
      carService.addCar(mazda);


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = "+user.getCar());
         System.out.println();
      }

      System.out.println(carService.getUserCar(mazda));


      context.close();
   }
}
