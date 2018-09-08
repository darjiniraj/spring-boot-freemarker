package in.niraj.spring.springbootfreemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class SpringBootFreemarkerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootFreemarkerApplication.class, args);
    }

    @Autowired
    private Configuration freemarkerConfiguration;

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootFreemarkerApplication.class);

    @Bean
    CommandLineRunner runner() {
        return args -> {
            LOGGER.info("Application started ..");
            Template t = freemarkerConfiguration.getTemplate("user.ftl");


            Map<String, String> model = prepareData();

            String convertedJsonString = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);

            LOGGER.info(convertedJsonString);

        };
    }

    private Map<String, String> prepareData() {
        Map<String, String> model = new HashMap<>();
        model.put("firstName", "Niraj");
        model.put("lastName", "Darji");
        return model;
    }


}
