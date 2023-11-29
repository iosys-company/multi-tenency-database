package my.work.multitenencydatabase.tenant;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.teams.web.service.TeamsService;

@Configuration
public class TeamsSetviceConfig {

    @Bean
    @ConfigurationProperties(prefix = "teams")
    public TeamsService teamsService() {
        return new TeamsService();
    }
}
