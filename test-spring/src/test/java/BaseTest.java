import com.song.service.IDemoService;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @author songjianhua
 * @date 2019-12-24 14:55
 * @description:
 **/
public class BaseTest {
    @Test
    public void test() {
        /*ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-application.xml");
        IDemoService demoService = context.getBean("demoService", IDemoService.class);
        demoService.run();*/

        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("spring-application.xml"));
        IDemoService bean = (IDemoService) bf.getBean("demoService");
        bean.run();
    }
}
