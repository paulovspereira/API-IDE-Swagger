package br.com.alura.funcionarios.api.swagger.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.models.Contact;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Documentation;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//Configuração da documentação interativa 
//Essa classe configura swagger
@Configuration
@EnableSwagger2 //Ativa configuração do swagger
public class SwaggerConfiguration {

	@Bean //Um objeto em Java
	//Docket é um tipo de swagger
	public Docket api() {
		
		return new Docket(DocumentationType.SWAGGER_2)//Versão do swagger
				.select()//Construção dessa documentação interativa
				.apis(RequestHandlerSelectors.basePackage("br.com.alura.funcionarios.api"))//Define um pacote basico para documentação
				.build()
				.apiInfo(getApiInfo());//Configurar
	}

	private ApiInfo getApiInfo() {
		
		return new ApiInfoBuilder()
				.title("Funcionario API")
				.description("Esta API fas o cadastro, consulta, alteração e exclusão de funcionario")
				.version("1.0.0")
				.build();
	}
	
}
