package mears.trace.classified_ads.repositories.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
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

import mears.trace.classified_ads.models.Item;
import mears.trace.classified_ads.repositories.ItemRepository;

@Repository
public class MariaDBItemRepository implements ItemRepository {

	@Autowired
	private NamedParameterJdbcTemplate mariaDbJdbcTemplate;
	
	private final class ItemMapper implements RowMapper<Item> {
		@Override
		public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
			Item item = new Item();
			item.setItemId(rs.getInt(1));
			item.setName(rs.getString(2));
			item.setPrice(rs.getInt(3));
			item.setStatus(rs.getInt(4));
			return item;
		}
	}
	
	@Override
	public List<Item> showItems() {
		String selectItems = "SELECT * FROM items";
		List<Item> result = mariaDbJdbcTemplate.query(selectItems, 
				new ItemMapper());
		return result;
	}

	@Override
	public Integer addItem(Item item) {
		Integer id = -1;
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", item.getName());
		params.addValue("price", item.getPrice());
		String createItemSql = "insert into items (name, price) values "
				+ "(:name,:price)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		Integer createResult = mariaDbJdbcTemplate.update(createItemSql, 
				params, keyHolder);
		if (createResult > 0) {
			id = keyHolder.getKey().intValue();
		}
		return id;
	}

	@Override
	public Boolean updateOrderStatus(Integer id, Integer status) {
		Integer result;
		Map<String, Object> params = new HashMap<>();
		params.put("status", status);
		params.put("id", id);
		String updateSql = "update items set purchase_status = :status where id = :id";
		result = mariaDbJdbcTemplate.update(updateSql, params);
		if (result > 0) {
			return true;
		}
		return false;		
	}	
}
