package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarDaoImpl implements CarDao{

    private final SessionFactory sessionFactory;

    @Autowired
    public CarDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addCar(Car car) {sessionFactory.getCurrentSession().save(car); }

    @Override
    public User getUserCar(Car car) {
        String hql = "from User user where user.car=:car";
        return sessionFactory.getCurrentSession().createQuery(hql, User.class).setParameter("car", car).getSingleResult();
    }
}
