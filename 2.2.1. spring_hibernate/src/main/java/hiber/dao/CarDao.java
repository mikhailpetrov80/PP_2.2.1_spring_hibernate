package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public interface CarDao {

    void addCar(Car car);

    User getUserCar(Car car);
}
