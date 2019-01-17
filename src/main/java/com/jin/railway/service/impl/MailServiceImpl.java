package com.jin.railway.service.impl;


import com.jin.railway.entity.MailVO;
import com.jin.railway.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;


@Component("mailService")
public class MailServiceImpl implements MailService {

	@Value("${email.username}")
	private String defaultMailFrom;

	@Autowired
	protected JavaMailSender sender;

	public void sendSimpleMail(String subject, String mailTo, String content) {
		sendSimpleMail(subject, new String[] { mailTo }, content);
	}

	public void sendSimpleMail(String subject, String[] mailTo, String content) {
		sendSimpleMail(subject, null, mailTo, null, null, content);
	}

	public void sendSimpleMail(String subject, String mailFrom, String[] mailTo, String[] mailCc, String[] mailBcc,
			String content) {
		sendMail(subject, mailFrom, mailTo, mailCc, mailBcc, content, false, false);
	}

	public void sendSimpleMail(MailVO Mail, String content) {
		sendMail(Mail, content, false);
	}

	public void sendHtmlMail(String subject, String mailTo, String content) {
		sendHtmlMail(subject, new String[] { mailTo }, content);
	}

	public void sendHtmlMail(String subject, String[] mailTo, String content) {
		sendHtmlMail(subject, null, mailTo, null, null, content);
	}

	public void sendHtmlMail(String subject, String mailFrom, String[] mailTo, String[] mailCc, String[] mailBcc,
			String content) {
		sendMail(subject, mailFrom, mailTo, mailCc, mailBcc, content, true, false);
	}

	public void sendHtmlMail(MailVO Mail, String content) {
		sendMail(Mail, content, true);
	}

	public MailVO getMail(String subject, String mailTo, boolean isAttachment) {
		return getMail(subject, new String[] { mailTo }, isAttachment);
	}

	public MailVO getMail(String subject, String[] mailTo, boolean isAttachment) {
		return getMail(subject, null, mailTo, null, null, isAttachment);
	}

	public MailVO getMail(String subject, String mailFrom, String[] mailTo, String[] mailCc, String[] mailBcc,
			boolean isAttachment) {
		try {
			MimeMessage msg = sender.createMimeMessage();

			MailVO Mail = new MailVO(msg, isAttachment, "utf-8");
			if (mailFrom != null) {
				Mail.setFrom(mailFrom);
			} else {
				Mail.setFrom(defaultMailFrom);
			}
			Mail.setTo(mailTo);
			if (mailCc != null) {
				Mail.setCc(mailCc);
			}
			if (mailBcc != null) {
				Mail.setBcc(mailBcc);
			}
			Mail.setSubject(subject);
			return Mail;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	protected void sendMail(MailVO Mail, String content, boolean isHtml) {
		try {
			Mail.setText(content, isHtml);
			sender.send(Mail.getMimeMessageHelper().getMimeMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void sendMail(String subject, String mailFrom, String[] mailTo, String[] mailCc, String[] mailBcc,
			String content, boolean isHtml, boolean isAttachment) {
		MailVO Mail = getMail(subject, mailFrom, mailTo, mailCc, mailBcc, isAttachment);
		sendMail(Mail, content, isHtml);
	}


}
