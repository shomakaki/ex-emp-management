package jp.co.sample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Administrator;

/**管理者情報をインサートや検索する。
 * 
 * @author kaki0
 *
 */
@Repository
public class AdministratorRepository {

	private static final RowMapper<Administrator> ADMINISTRATOR_ROW_MAPPER
		= new BeanPropertyRowMapper<>(Administrator.class);
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/** 管理者情報をインサートするメソッド
	 * @param administrator
	 */
	public void insert(Administrator administrator) {
		String insertsql = "INSERT INTO administrators(name,mail_address,password)"
				+ " VALUES(:name,:mailAddress,:password);";
		SqlParameterSource param = new BeanPropertySqlParameterSource(administrator);
	
		template.update(insertsql, param);
		System.out.println("insertよびだされたで");
	
	}
	public Administrator findByMailAdressAndPassword(String mailAddress,String password) {
		String findSql="SELECT * FROM administrators WHERE mail_address=:mailAddress AND password=:password;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("mailAddress", mailAddress).addValue("password", password);
		List<Administrator> administratorList = template.query(findSql, param,ADMINISTRATOR_ROW_MAPPER);
		if(administratorList.size() ==0) {
			return null;
		}
		System.out.println("findよびだされたで");
		return administratorList.get(0);
		
	
	}
	
}
