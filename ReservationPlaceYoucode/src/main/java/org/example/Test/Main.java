package org.example.Test;

import org.example.DAO.*;
import org.example.DAO.RoleDaoImpl;
import org.example.Entity.*;
import org.example.Repostory.ReservationRepostory;
import org.example.service.UserService;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class Main {
//    private static final SessionFactory ourSessionFactory;
//
//    static {
//        try {
//            Configuration configuration = new Configuration();
//            configuration.configure();
//
//            ourSessionFactory = configuration.buildSessionFactory();
//        } catch (Throwable ex) {
//            throw new ExceptionInInitializerError(ex);
//        }
//    }
//
//    public static Session getSession() throws HibernateException {
//        return ourSessionFactory.openSession();
//    }
//
//    public static void main(final String[] args) throws Exception {
//        final Session session = getSession();
//        try {
//            System.out.println("querying all the managed entities...");
//            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
//            for (EntityType<?> entityType : metamodel.getEntities()) {
//                final String entityName = entityType.getName();
//                final Query query = session.createQuery("from " + entityName);
//                System.out.println("executing: " + query.getQueryString());
//                for (Object o : query.list()) {
//                    System.out.println("  " + o);
//                }
//            }
//        } finally {
//            session.close();
//        }
//    }

    @Autowired
    private static UserService userService;
public static void main(final String[] args) throws Exception {


//        final Session session = HibernateUtil.getSession();
//
//        //role
//
//    RoleDaoImpl roleDAO=new RoleDaoImpl();
//    roleDAO.addRole(new RoleEntity("nnn"));

    //Test Session

//    Session session1 = HibernateUtil.getSession();
//    session1.beginTransaction();
//    RoleEntity roleEntity1=session.get(RoleEntity.class,1);
//    System.out.println(roleEntity1);
//    UseradminEntity useradminEntity=new UseradminEntity("zahid","fatima","zahidmm12312@gmail.com","zahid123",12345,roleEntity1);
//    session1.persist(useradminEntity);
//    session1.getTransaction().commit();
//    System.out.println("add useradmin");
//
//    Session session2=HibernateUtil.getSession();
//    session2.beginTransaction();
//    StudentEntity studentEntity=new StudentEntity();
//    studentEntity.setReservationMax(1);
//    session2.persist(studentEntity);
//   session2.getTransaction().commit();
//    System.out.println("add apprenant");


    //TestAdmin



    //test Login

//    LoginRepostory loginRepostory=new LoginRepostory();
//    UseradminEntity useradminEntity=loginRepostory.getUserByEmailPassword("")



//Test Reservation

//    UserDaoImpl userDao=new UserDaoImpl();
//    UseradminEntity useradminEntity=userDao.getUserById(1);
//
//    ReservationDaoImpl reservationDao=new ReservationDaoImpl();
//
//    TypeResDaoImpl typeResDao=new TypeResDaoImpl();
//    TypereservationEntity typereservationEntity=typeResDao.getTypeResById(1);
//    reservationDao.addRes(new ReservationEntity(useradminEntity,"12-03-2021",typereservationEntity));

//TestSERvice User


//    UserDaoImpl userDao=new UserDaoImpl();
//    RoleDaoImpl roleDao=new RoleDaoImpl();
//    RoleEntity roleEntity=roleDao.getRoleById(1);
//    UseradminEntity user=new UseradminEntity("malak","errabib","malkcca@gmail.com","malk123",12344,roleEntity);
//    userService.addUser(user);

//    userDao.addUser(user);


//    ReservationDaoImpl reservationDao=new ReservationDaoImpl();
//    System.out.println(reservationDao.getResById(7));

    ReservationRepostory reservationRepostory=new ReservationRepostory();

    List<ReservationEntity> reservations= reservationRepostory.getAllReservationsById(7);

    for (ReservationEntity  res: reservations) {
			System.out.println("Année : " +res.getDateRes()+"  "+"Type : "+res.getTypeRes().getTypeRes());

		}




}
}