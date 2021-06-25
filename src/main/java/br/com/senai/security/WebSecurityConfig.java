package br.com.senai.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@AllArgsConstructor
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private InplementUserDetailsService inplementUserDetailsService;

    private  static final String[] AUTH_LIST = {
      "/",
      "/pessoas",
      "/pessoas/{pessoaId}",
      "/role",
      "/pessoas/nome/{pessoaNome}",
      "/role/{roleUsuarioId}",
      "/pessoas/nome/containing/{nomeContaining}"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
        .authorizeRequests()
        .antMatchers(HttpMethod.GET, "/entregas").hasRole("ADMIN")
        .antMatchers(HttpMethod.GET, AUTH_LIST).permitAll()
        .antMatchers(HttpMethod.POST,AUTH_LIST ).permitAll()
        .antMatchers(HttpMethod.PUT,AUTH_LIST ).permitAll()
        .antMatchers(HttpMethod.DELETE,AUTH_LIST ).permitAll()
        .anyRequest().authenticated()
        .and().formLogin().permitAll()
        .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("Roberta").password("{noop}123456").roles("ADMIN");
        auth.userDetailsService(inplementUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/botstrap/**", "/style/**");
    }
}
