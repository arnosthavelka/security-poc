package com.github.aha.poc.security.config;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@Profile("USER_DETAIL_SERVICE")
class UserDetailsJdbcService implements UserDetailsService {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public UserDetailsJdbcService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public UserDetails loadUserByUsername(String username) {
		// load user details
		UserDTO user = jdbcTemplate.queryForObject("select id, username, passwd from u_principal where username = ?", new UserMapper(), username);

		if (user == null) {
			throw new UsernameNotFoundException(String.format("userma=%s", username));
		}
		// load authorities
		List<GrantedAuthority> authorities = new ArrayList<>();
		List<Map<String, Object>> data = jdbcTemplate.queryForList("select name from u_role where user_id = :id", user.getId());
		for (Map<String, Object> item : data) {
			var role = "ROLE_" + item.get("NAME");
			authorities.add(new SimpleGrantedAuthority(role));
		}

		return new User(user.getUsername(), user.getPasswd(), authorities);
	}

	class UserMapper implements RowMapper<UserDTO> {

		@Override
		public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new UserDTO(rs.getInt("id"), rs.getString("username"), rs.getString("passwd"));
		}

	}

	class UserDTO {

		public UserDTO(int id, String username, String passwd) {
			super();
			this.id = id;
			this.username = username;
			this.passwd = passwd;
		}

		private int id;

		private String username;

		private String passwd;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPasswd() {
			return passwd;
		}

		public void setPasswd(String passwd) {
			this.passwd = passwd;
		}

	}
}
