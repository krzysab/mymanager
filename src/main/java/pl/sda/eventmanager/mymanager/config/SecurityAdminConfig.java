package pl.sda.eventmanager.mymanager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityAdminConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private DataSource dataSource;
//
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery("SELECT nick, password FROM users WHERE nick=?")
//                .authoritiesByUsernameQuery("SELECT nick, password FROM users WHERE nick=?");
//    }
//

    final UserDetailsService userDetailsService;

    public SecurityAdminConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers("/home").authenticated()
                //.antMatchers(HttpMethod.POST, "/test").authenticated()
                .antMatchers(HttpMethod.POST, "/test").permitAll()
                .antMatchers("/register").permitAll()
                .and().csrf().disable().cors().disable()
                .userDetailsService(userDetailsService).httpBasic();
    }

}
