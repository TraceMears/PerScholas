package mears.trace.stats_application.repositories.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import mears.trace.stats_application.models.Fighter;
import mears.trace.stats_application.repositories.FighterRepository;

@Repository
public class MariaDBFighterRepository implements FighterRepository {

	@Autowired
	private NamedParameterJdbcTemplate mariaDbJdbcTemplate;
	
	private final class FighterMapper implements RowMapper<Fighter> {
		@Override
		public Fighter mapRow(ResultSet rs, int rowNum) throws SQLException {
			Fighter f = new Fighter();
			f.setId(rs.getInt(1));
			f.setName(rs.getString(2));
			f.setSigLpm(rs.getDouble(3));
			f.setSigApm(rs.getDouble(4));
			f.setTdpF(rs.getDouble(5));
			f.setSubPF(rs.getDouble(6));
			f.setKoPF(rs.getDouble(7));
			f.setFinRate(rs.getDouble(8));
			return f;
		}
	}
	
	@Override
	public List<Fighter> showFighters() {
		String selectFighters = "SELECT * FROM fighter";
		List<Fighter> result = mariaDbJdbcTemplate.query(selectFighters, 
				new FighterMapper());
		return result;
	}

	@Override
	public Fighter retrieveFighter(Integer id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		String selectFighters = "SELECT * FROM fighter WHERE id= :id";
		List<Fighter> result = mariaDbJdbcTemplate.query(selectFighters, params,  
				new FighterMapper());
		return result.get(0);
	}

	@Override
	public List<Fighter> getFavoriteFighters(List<Integer> list) {
		
		List<Fighter> favList = new ArrayList<Fighter>();
		for(Integer i: list) {
			favList.add(retrieveFighter(i));
		}	
		return favList;
	}

	
	
}
