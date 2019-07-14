package pl.sda.eventmanager.mymanager.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

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

    public SecurityAdminConfig(@Qualifier("userService") UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/youAreLoggedIn").authenticated()
                //.antMatchers(HttpMethod.POST, "/test").authenticated()
                .antMatchers(HttpMethod.POST, "/login").permitAll()
                .antMatchers("/register").permitAll()
                .and().csrf().disable().cors().disable()
                .userDetailsService(userDetailsService).httpBasic();
//
//        http.httpBasic();
//        http.authorizeRequests()
//                .antMatchers("/")
//                .permitAll()
//                .antMatchers(HttpMethod.GET, "login").authenticated()
//                .anyRequest().fullyAuthenticated();

//        http.formLogin()
//                .loginPage("login")
//                .failureForwardUrl("login")
//                .successForwardUrl("youAreLoggedIn");
//
//        http.logout()
//                .logoutUrl("youAreLoggedIn")
//                .logoutSuccessUrl("youAreLoggedOut")
//                .invalidateHttpSession(true)
//                .clearAuthentication(true)
//                .logoutSuccessHandler(handler());
    }

    private LogoutSuccessHandler handler() {
        return null;
    }


}
