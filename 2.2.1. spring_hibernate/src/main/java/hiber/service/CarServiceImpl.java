package hiber.service;

import hiber.dao.CarDao;
import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarServiceImpl implements CarService{

    @Autowired
    private CarDao carDao;

    @Transactional
    @Override
    public void addCar(Car car) { carDao.addCar(car); }

    @Transactional
    @Override
    public User getUserCar(Car car) {return carDao.getUserCar(car); }

}
