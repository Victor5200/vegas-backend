package com.barvegas.backend.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//Arquivo de configuração do Web Security
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.GET, "/").permitAll() //Raiz com permissão aberta
                .anyRequest().authenticated()//Qualquer outra requisição precisa de login
                .and().formLogin().permitAll()//Com essa notação qualquer usuario tem acesso ao formulário de login
                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));//A qualquer momento
                                                                  // quando chamado o Endpoint "/logout" encerra a sessão
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("vegas").password("1922").roles("ADMIN"); //Usuário/Senha/Controle de Acesso
    }

    @Override
    public void configure(WebSecurity web) throws Exception{
        web.ignoring().antMatchers("/materialize/**", "/style/**");//Não bloqueie as páginas estáticas
    }
}
