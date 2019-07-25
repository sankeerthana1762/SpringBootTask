package com.stackroute.config;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.service.TrackService;
import org.apache.catalina.servlets.WebdavServlet;
import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;

@Configuration
public class WebConfig {
    TrackService trackService;

    @Bean
    ServletRegistrationBean h2ServetRegistrationBean() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new WebServlet());
        servletRegistrationBean.addUrlMappings("/console/*");
        return servletRegistrationBean;
    }
    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("Spring Boot REST API")
                .description("Track Management REST API")
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("1.0.0")
                .build();
    }


    @EventListener
    public void handleContextRefreshEvent(ContextRefreshedEvent cfr) {
        try {
            trackService.saveTrack(new Track(1,"lungi dance","chennai express"));
            trackService.saveTrack(new Track(2,"kadalalle","Dearcomrade"));
            trackService.saveTrack(new Track(3,"Mandara","Bhagamathi"));
            System.out.println("Context Refreshed");
        } catch (TrackAlreadyExistsException e) {
            e.printStackTrace();
        }
    }
}


