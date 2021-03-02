package Util;


import org.hibernate.*;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.*;

public class HibernateUtil {
	//private static SessionFactory sessionFactory;
	
//	public static SessionFactory getSessionFactory() {    
//      	StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//					.configure("hibernate.cfg.xml").build();
//			Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
//			return metadata.getSessionFactoryBuilder().build();  
//	}
	
	
	private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml").build();
            Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
            return metadata.getSessionFactoryBuilder().build();

        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
