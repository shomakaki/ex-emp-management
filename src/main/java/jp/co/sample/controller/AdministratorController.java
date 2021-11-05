package jp.co.sample.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Administrator;
import jp.co.sample.form.InsertAdministratorForm;
import jp.co.sample.form.LoginForm;
import jp.co.sample.service.AdministratorService;

/**管理者機能のコントローラー作成
 * 
 * @author kaki0
 *
 */
@Controller
@RequestMapping("/")
public class AdministratorController {
	@Autowired
	private AdministratorService administratorService;
	
	@ModelAttribute
	public InsertAdministratorForm setUpAdministratorForm() {
		InsertAdministratorForm  form = new InsertAdministratorForm();
		return form;
	}
	@RequestMapping("/toInsert")
	public String toInsert() {
		return "administrator/insert";
	}
	
	@RequestMapping("/insert")
	public String insert(InsertAdministratorForm form) {
		Administrator administrator = new Administrator();
		BeanUtils.copyProperties(form, administrator);
		administratorService.insert(administrator);
		return "redirect:/";
	}
	
	/**loginするためのメソッド
	 * @return
	 */
	@ModelAttribute
	public LoginForm setUpForm() {
		LoginForm login = new LoginForm();
		return login;
	}
	
	@RequestMapping("/")
	public String toLogin() {
	return "administrator/login";	
	}
	@Autowired
	private HttpSession session;
	
	@RequestMapping("/login")
	public String login(LoginForm form,Model model) {
		Administrator administrator = administratorService.login(form.getMailAddress(),form.getPassword());
		String message = "メールアドレスまたはパスワードが不正です。";
		if(administrator == null) {
			model.addAttribute("error",message);
			return "administrator/login";
		}else {
			session.setAttribute("administratorName",administrator.getName() );
		}
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaa!!!!!!!!!!");
	return "forward:/employee/showList";
	}
		
	
}
