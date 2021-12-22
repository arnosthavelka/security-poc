package com.github.aha.poc.security.config;

import static java.lang.String.format;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@Profile("USER_DETAIL_SERVICE")
@RequiredArgsConstructor
class UserDetailJdbcService implements UserDetailsService {

	private final JdbcTemplate jdbcTemplate;

	@Override
	public UserDetails loadUserByUsername(String username) {
		UserDTO user = jdbcTemplate.queryForObject("select id, username, passwd from u_principal where username = ?", 
				(rs, rowNum) -> new UserDTO(rs.getInt("id"), rs.getString("username"), rs.getString("passwd")), username);
		if (user == null) {
			throw new UsernameNotFoundException(format("username=%s", username));
		}
		return new User(user.username(), user.passwd(), loadAuthorities(user.id()));
	}

	private List<GrantedAuthority> loadAuthorities(int userId) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		List<Map<String, Object>> names = jdbcTemplate.queryForList("select name from u_role where user_id = :id", userId);
		for (Map<String, Object> item : names) {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + item.get("NAME")));
		}
		return authorities;
	}

	record UserDTO(int id, String username, String passwd) {
	}
}
