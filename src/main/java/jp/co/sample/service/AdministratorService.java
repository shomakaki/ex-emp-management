package jp.co.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.sample.domain.Administrator;
import jp.co.sample.repository.AdministratorRepository;

/**管理者情報の業務処理を行うクラス
 * @author kaki0
 *
 */
@Service
@Transactional
public class AdministratorService {
	@Autowired
	private AdministratorRepository administratorRepository;
	
	/**　Repositoryのインサートメソッドを用いてインサート
	 * @param administrator
	 */
	public void insert(Administrator administrator) {
		administratorRepository.insert(administrator);
	}
	
}
