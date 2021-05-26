package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Baseballteam;

/**
 * teamsテーブルを操作するリポジトリ.
 * 
 * @author kairi.hashimoto
 *
 */
@Repository
public class BaseballteamRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	/**
	 * Baseballteamオブジェクトを生成するローマッパー.
	 */
	private static final RowMapper<Baseballteam> BASEBALLTEAM_ROW_MAPPER = (rs, i) -> {
		Baseballteam baseballteam = new Baseballteam();
		baseballteam.setId(rs.getInt("id"));
		baseballteam.setHeadquarters(rs.getString("league_name"));
		baseballteam.setTeamName(rs.getString("team_name"));
		baseballteam.setHeadquarters(rs.getString("headquarters"));
		baseballteam.setInauguration(rs.getString("inauguration"));
		baseballteam.setHistory(rs.getString("history"));
		return baseballteam;
	};

	/**
	 * 野球チーム一覧情報を発足日順で取得します.
	 * 
	 * @return 全球団一覧
	 */
	public List<Baseballteam> findAll() {
		String sql = "SELECT id,league_name,team_name,headquarters,inauguration,history FROM teams ORDER BY inauguration;";

		List<Baseballteam> baseballteamList = template.query(sql, BASEBALLTEAM_ROW_MAPPER);

		return baseballteamList;
	}

	/**
	 * 主キーから球団情報を取得します.
	 * 
	 * @param id ID
	 * @return 検索された球団情報
	 */
	public Baseballteam load(Integer id) {
		String sql = "SELECT id, league_name, team_name, headquarters, inauguration, history FROM teams WHERE id=:id;";

		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);

		Baseballteam baseballteam = template.queryForObject(sql, param, BASEBALLTEAM_ROW_MAPPER);

		return baseballteam;
	}

}
