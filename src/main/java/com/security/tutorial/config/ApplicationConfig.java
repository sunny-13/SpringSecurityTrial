package com.security.tutorial.config;

import com.security.tutorial.entity.Customer;
import com.security.tutorial.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;

import static java.util.Objects.isNull;

@Configuration
public class ApplicationConfig {
    @Autowired
    private CustomerRepository customerRepository;

    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                Customer customer = customerRepository.findByCustomerName(username).get();
                if(isNull(customer) ) return null;
                return new User(customer.getCustomerName(),customer.getCustomerPassword(), new ArrayList<GrantedAuthority>());
            }
        };

    }

}
