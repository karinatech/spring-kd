import interfaces.Mentor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        BeanFactory container=new ClassPathXmlApplicationContext("config.xml");
        Mentor mentor= (Mentor) container.getBean("fullTimeMentor");
        Mentor mentor2= (Mentor) container.getBean("partTimeMentor",Mentor.class);
        mentor.createAccount();
        mentor2.createAccount();
    }
}
