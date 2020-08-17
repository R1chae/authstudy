package Infrastructure;




import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RichardDumser
 */
@Configuration
public class Mapping {
    @Bean(name = "infraBean")
    public IInfrastructure infrastructure(){
        return new Infrastructure();
    }
}
