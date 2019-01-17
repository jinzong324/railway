package com.jin.railway.service;

import com.jin.railway.entity.MailVO;

public interface MailService {
	/**
	 *
	 * sendSimpleMail:发送简单格式邮件(非html). <br>
	 *
	 * @author Dawson
	 * @param subject
	 *            邮件标题
	 * @param mailTo
	 *            邮件接收人
	 * @param content
	 *            邮件内容
	 * @since 1.0
	 */
	void sendSimpleMail(String subject, String mailTo, String content);

	/**
	 *
	 * sendSimpleMail:发送简单格式邮件(非html). <br>
	 *
	 * @author Dawson
	 *
	 * @param subject
	 *            邮件标题
	 * @param mailTo
	 *            邮件接收人
	 * @param content
	 *            邮件内容
	 * @since 1.0
	 */
	void sendSimpleMail(String subject, String[] mailTo, String content);

	/**
	 * sendSimpleMail:发送简单格式邮件(非html)
	 *
	 * @param subject
	 *            邮件标题
	 * @param mailFrom
	 *            邮件发送人
	 * @param mailTo
	 *            邮件接收人
	 * @param mailCc
	 *            邮件抄送人
	 * @param mailBcc
	 *            邮件暗送人
	 * @param content
	 *            邮件内容
	 *
	 */
	void sendSimpleMail(String subject, String mailFrom, String[] mailTo, String[] mailCc, String[] mailBcc,
			String content);

	/**
	 * 发送简单格式邮件(非html)
	 *
	 * @param Mail
	 *            Mail这里主要用于附件处理
	 * @param content
	 *            邮件内容
	 */
	void sendSimpleMail(MailVO Mail, String content);

	/**
	 * sendHtmlMail:发送Html格式邮件
	 *
	 * @param subject
	 *            邮件标题
	 * @param mailTo
	 *            邮件接收人
	 * @param content
	 *            邮件内容
	 */
	void sendHtmlMail(String subject, String mailTo, String content);

	/**
	 * 发送Html格式邮件
	 *
	 * @param subject
	 *            邮件标题
	 * @param mailTo
	 *            邮件接收人
	 * @param content
	 *            邮件内容
	 */
	void sendHtmlMail(String subject, String[] mailTo, String content);

	/**
	 * sendHtmlMail:发送Html格式邮件
	 *
	 * @param subject
	 *            邮件标题
	 * @param mailFrom
	 *            邮件发送人
	 * @param mailTo
	 *            邮件接收人
	 * @param mailCc
	 *            邮件抄送人
	 * @param mailBcc
	 *            邮件暗送人
	 * @param content
	 *            邮件内容
	 */
	void sendHtmlMail(String subject, String mailFrom, String[] mailTo, String[] mailCc, String[] mailBcc,
			String content);

	/**
	 * sendHtmlMail:发送Html格式邮件
	 *
	 * @param Mail
	 *            Mail的方式这里主要用于附件
	 * @param content
	 *            邮件内容
	 */
	void sendHtmlMail(MailVO Mail, String content);

	/**
	 * getMail:获得Mail
	 *
	 * @param subject
	 *            邮件标题
	 * @param mailTo
	 *            邮件接收人
	 * @param isAttachment
	 *            是否含有附件
	 *
	 * @return Mail
	 */
	MailVO getMail(String subject, String mailTo, boolean isAttachment);

	/**
	 * getMail:获得Mail
	 *
	 * @param subject
	 *            邮件标题
	 * @param mailTo
	 *            邮件接收人
	 * @param isAttachment
	 *            是否含有附件
	 *
	 * @return Mail
	 */
	MailVO getMail(String subject, String[] mailTo, boolean isAttachment);

	/**
	 * getMail:获得Mail
	 *
	 * @param subject
	 *            邮件标题
	 * @param mailFrom
	 *            邮件发送人
	 * @param mailTo
	 *            邮件接收人
	 * @param mailCc
	 *            邮件抄送人
	 * @param mailBcc
	 *            邮件暗送人
	 * @param isAttachment
	 *            是否含有附件
	 *
	 * @return Mail
	 */
	MailVO getMail(String subject, String mailFrom, String[] mailTo, String[] mailCc, String[] mailBcc,
			boolean isAttachment);
}
