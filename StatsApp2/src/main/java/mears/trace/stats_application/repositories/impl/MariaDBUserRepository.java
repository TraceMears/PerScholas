package mears.trace.stats_application.repositories.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import mears.trace.stats_application.models.Favorite;
import mears.trace.stats_application.models.User;
import mears.trace.stats_application.repositories.UserRepository;

@Repository
public class MariaDBUserRepository implements UserRepository {

	@Autowired
	private NamedParameterJdbcTemplate mariaDbJdbcTemplate;
	
	private final class UserMapper implements RowMapper<User> {
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User u = new User();
			u.setId(rs.getInt(1));
			u.setUsername(rs.getString(2));
			u.setPassword(rs.getString(3));
			u.setCount(rs.getInt(4));
			return u;
		}
	}
	
	private final class FavoriteMapper implements RowMapper<Favorite> {
		@Override
		public Favorite mapRow(ResultSet rs, int rowNum) throws SQLException {
			Favorite fav = new Favorite();
			fav.setUserId(rs.getInt(1));
			fav.setFighterId(rs.getInt(2));
			fav.setNumber(rs.getInt(3));
			return fav;
		}
	}
	
	@Override
	public User login(String user, String pass) {

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("u", user);
		String selectUser = "SELECT * FROM user where username = :u";
		List<User> result = mariaDbJdbcTemplate.query(selectUser, params,  
				new UserMapper());
		if(result.size() == 0) {
			return null;
		}
		if( pass.equals(result.get(0).getPassword()) ) {
			return result.get(0);
		}
		else {
			return null;
		}
	}
	
	@Override
	public User getUser(Integer uId) {

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("u", uId);
		String selectUser = "SELECT * FROM user where id = :u";
		List<User> result = mariaDbJdbcTemplate.query(selectUser, params,  
				new UserMapper());
		if(result.size() == 0) {
			return null;
		}		
		else {
			return result.get(0);
		}
	}

	@Override
	public User adminLogin(String user, String pass) {
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("u", user);
		String selectUser = "SELECT * FROM admin WHERE username = :u";
		User result = mariaDbJdbcTemplate.queryForObject(selectUser, params,  
				new UserMapper());
		if(result.getUsername() == null) {
			return null;
		}
		if( pass.equals(result.getPassword()) ) {
			return result;
		}
		else {
			return null;
		}
	}

	@Override
	public Integer createUser(User u) {
		Integer id = -1;
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("user", u.getUsername());
		params.addValue("pass", u.getPassword());
		String createUserQuery = "INSERT into user (username, password) VALUES "
				+ "(:user,:pass)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		Integer createResult = mariaDbJdbcTemplate.update(createUserQuery, 
				params, keyHolder);
		if (createResult > 0) {
			id = keyHolder.getKey().intValue();
		}
		return id;
	}

	@Override
	public Integer deleteUser(Integer uId) {
		Integer id = -1;
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", uId);
		String deleteUserQuery = "DELETE from user where id = :id";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		Integer deleteResult = mariaDbJdbcTemplate.update(deleteUserQuery, 
				params, keyHolder);
		if (deleteResult > 0) {
			return deleteResult;
		}
		return id;
	}

	@Override
	public Boolean updatePassword(User u) {
		Integer result;
		Map<String, Object> params = new HashMap<>();
		params.put("newPass", u.getPassword());
		params.put("id", u.getId());
		String updateSql = "UPDATE user SET password = :newPass where id = :id";
		result = mariaDbJdbcTemplate.update(updateSql, params);
		if (result > 0) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean addToFavorites(User u, Integer fId) {
		
		if(u.getCount() > 4) {
			return false;
		}
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("userId", u.getId());
		params.addValue("fighterId", fId);
		params.addValue("num", u.getCount() + 1);
		String addFavoriteQuery = "INSERT into favorites (userID, fighterID, number) VALUES "
				+ "(:userId,:fighterId,:num)";
		Integer createResult = mariaDbJdbcTemplate.update(addFavoriteQuery, 
				params);
		
		if (createResult > 0) {
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("addCount", u.getCount() + 1);
			parameters.put("uId", u.getId());
			String updateSql = "UPDATE user SET counter = :addCount WHERE id = :uId";
			Integer result = mariaDbJdbcTemplate.update(updateSql, parameters);
			if (result > 0) {
				return true;
			}
			return false;
		}	
		return false;
	}	

	@Override
	public Boolean removeFavorite(User u, Integer fId) {
		
		if(u.getCount() < 1) {
			return false;
		}
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("userId", u.getId());
		params.addValue("fighterId", fId);
			
		Integer num = retrieveFavoriteNum(u, fId);
		
		String addFavoriteQuery 
					= "DELETE FROM favorites WHERE userID = :userId AND fighterID = :fighterId";		

		Integer createResult = mariaDbJdbcTemplate.update(addFavoriteQuery, 
				params);
		
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("num", num);
		String selectUser = "SELECT * FROM favorites WHERE number > :num";
		List<Favorite> partialList = mariaDbJdbcTemplate.query(selectUser, param,  
				new FavoriteMapper());
		if(partialList == null) {
			return false;
		}
		for (Favorite fav: partialList) {
			fav.setNumber(fav.getNumber() - 1);
			updateFavoriteNumber(fav);
		}
				
		
		if (createResult > 0) {
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("subtractCount", u.getCount() - 1);
			parameters.put("uId", u.getId());
			String updateSql = "UPDATE user SET counter = :subtractCount WHERE id = :uId";
			Integer result = mariaDbJdbcTemplate.update(updateSql, parameters);
			if (result > 0) {
				return true;
			}
			return false;
		}	
		return false;
	}
	
	@Override
	public Boolean updateFavoriteNumber(Favorite f) {
		Integer result;
		Map<String, Object> params = new HashMap<>();
		params.put("newNum", f.getNumber());
		params.put("fId", f.getFighterId());
		params.put("uId", f.getUserId());
		String updateSql = "UPDATE favorites SET number = :newNum where userID = :uId AND fighterID = :fId";
		result = mariaDbJdbcTemplate.update(updateSql, params);
		if (result > 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<Favorite> getFavoriteList(User u) {
		if(u.getCount() == 0) {
			return new ArrayList<Favorite>();
		}
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("uId", u.getId());
		String getFavorites = "SELECT * FROM favorites where userID = :uId ORDER BY number ASC";
		List<Favorite> result = mariaDbJdbcTemplate.query(getFavorites, params,  
				new FavoriteMapper());
		return result;
		
	}
	
	@Override
	public Integer retrieveFavoriteNum(User u, Integer fId) {
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("userId", u.getId());
		params.addValue("fighterId", fId);
		
		String selectFav = "SELECT * FROM favorites WHERE userID = :userId AND fighterID = :fighterId";
		
		List<Favorite> result = mariaDbJdbcTemplate.query(selectFav, params,  
														new FavoriteMapper());
		return result.get(0).getNumber();
	}

	@Override
	public List<User> getAllUsers() {
		String selectUsers = "SELECT * FROM user";
		List<User> result = mariaDbJdbcTemplate.query(selectUsers, 
				new UserMapper());
		return result;
	}		
	
}
