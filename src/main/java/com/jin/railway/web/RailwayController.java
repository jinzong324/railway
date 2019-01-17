package com.jin.railway.web;


import com.jin.railway.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({ "/railway" })
public class RailwayController {

	@Autowired
	private MailService mailService;

	@RequestMapping("/success")
	@ResponseBody
	public String success(String date, String from, String to, String pas) throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("订票人：").append(pas == null ? "" : pas);
		sb.append("\n");
		sb.append("订票日期：").append(date == null ? "" : date);
		sb.append("\n");
		sb.append("出发：").append(from == null ? "" : from);
		sb.append(" ———— ");
		sb.append("到达：").append(to == null ? "" : to);
		sb.append("\n");
		mailService.sendHtmlMail("订票成功了，该付款了！！", "328561514@qq.com", sb.toString());

		return "success";
	}
}
