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
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-application.xml");
        IDemoService demoService = context.getBean("demoService", IDemoService.class);
        demoService.run();

        /**
         * bean实例化过程
         * 1、读取xml配置文件，生成resource
         *resource封装inputstreansource,inputstreamsource返回inputstream对象，对应不同来源的文件都有相应的resource实现，以获取资源文件
         * 如：filesystemresource，classpathresource，urlresource等
         *
         * 2、beanfactory根据resource文件解析注册实例，返回bean工厂
         * DefaultListableBeanFactory是整个bean加载的核心部分
         *
         * 3、调用实例
         */

        /*BeanFactory bf = new XmlBeanFactory(new ClassPathResource("spring-application.xml"));
        IDemoService bean = (IDemoService) bf.getBean("demoService");
        bean.run();*/
    }
}
