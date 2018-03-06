package content.negotiation.config;

import content.negotiation.view.PdfView;
import content.negotiation.view.XlsView;
import content.negotiation.view.XlsxView;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "content.negotiation")
public class WebConfig extends WebMvcConfigurerAdapter{


    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

        configurer.defaultContentType(MediaType.TEXT_HTML)
                .ignoreAcceptHeader(true);
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {

        registry.jsp("/WEB-INF/jsp/",".jsp").viewClass(JstlView.class);

        registry.enableContentNegotiation(new XlsView(), new XlsxView(),new PdfView());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/js/**").addResourceLocations("/ui/js/");
        registry.addResourceHandler("/css/**").addResourceLocations("/ui/css/");
    }
}
