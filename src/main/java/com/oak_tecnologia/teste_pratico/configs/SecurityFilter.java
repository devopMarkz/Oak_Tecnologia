package com.oak_tecnologia.teste_pratico.configs;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Classe de configuração responsável pela configuração de filtros de segurança.
 * Define as regras de segurança para a aplicação, incluindo permissões e desabilitação de CSRF.
 */
@Configuration
public class SecurityFilter {

    /**
     * Configuração de filtro de segurança específico para o console H2.
     * Essa configuração é ativada somente no perfil "test" e desabilita CSRF e as opções de frame.
     *
     * @param http objeto HttpSecurity utilizado para configurar a segurança.
     * @return uma instância configurada de SecurityFilterChain para o console H2.
     * @throws Exception em caso de erro na configuração de segurança.
     */
    @Bean
    @Profile("test")
    @Order(1)
    public SecurityFilterChain h2SecurityFilterChain(HttpSecurity http) throws Exception {
        http.securityMatcher(PathRequest.toH2Console())
                .csrf(csrf -> csrf.disable())
                .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()));
        return http.build();
    }

    /**
     * Configuração geral do filtro de segurança.
     * Desabilita CSRF e permite todas as requisições sem restrições de autenticação.
     *
     * @param http objeto HttpSecurity utilizado para configurar a segurança.
     * @return uma instância configurada de SecurityFilterChain para a aplicação.
     * @throws Exception em caso de erro na configuração de segurança.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
                .build();
    }

}