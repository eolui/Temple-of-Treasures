package com.gcu.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProductsMapper implements RowMapper<ProductsModel>
{

	@Override
	public ProductsModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductsModel order = new ProductsModel(
				rs.getString("name"),
				rs.getString("showMovies"),
				rs.getString("rarity"),
				rs.getInt("year"),
				rs.getString("category"),
				rs.getString("description"),
				rs.getLong("price"),
				rs.getString("imageURL"),
				rs.getLong("id")
				);
		return order;
	}

}
