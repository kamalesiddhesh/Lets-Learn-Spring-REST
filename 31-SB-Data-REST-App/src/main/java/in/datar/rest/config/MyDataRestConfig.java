package in.datar.rest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import in.datar.rest.entity.Book;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer{
	
	
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		HttpMethod[] unsupporteMethods = {HttpMethod.PUT,HttpMethod.DELETE};
		config.getExposureConfiguration()
			  .forDomainType(Book.class)
			  .withItemExposure((metadata,http)-> http.disable(unsupporteMethods))
			  .withCollectionExposure((metadata,http) -> http.disable(unsupporteMethods));
			  
	}
}
