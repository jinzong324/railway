package com.jin.railway.entity;

import java.io.File;

import javax.activation.DataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.MimeMessageHelper;

/**
 *
 * 包装了MimeMessageHelper
 *
 */
public class MailVO {

	/**
	 * 包装的MimeMessageHelper
	 */
	private MimeMessageHelper mimeMessageHelper;

	/** 邮件的主要属性 **/
	private String from = null;
	private String[] to = null;
	private String[] cc = null;
	private String[] bcc = null;
	private String subject = null;
	private String text = null;
	private boolean multipart = false;
	private boolean html = false;

	public MailVO(MimeMessage mimeMessage, boolean multipart, String encoding) throws MessagingException {
		this.multipart = multipart;
		mimeMessageHelper = new MimeMessageHelper(mimeMessage, multipart, encoding);
	}

	/**
	 * 添加附件（推荐使用该方法）
	 *
	 * @param attachmentFilename
	 *            附件显示名称
	 * @param file
	 *            文件名
	 * @throws MessagingException
	 */
	public void addAttachment(String attachmentFilename, File file) throws MessagingException {
		mimeMessageHelper.addAttachment(attachmentFilename, file);
	}

	/**
	 * 添加附件
	 *
	 * @param attachmentFilename
	 *            附件显示名称
	 * @param inputStreamSource
	 *            输入流Source
	 * @throws MessagingException
	 */
	public void addAttachment(String attachmentFilename, InputStreamSource inputStreamSource)
			throws MessagingException {
		mimeMessageHelper.addAttachment(attachmentFilename, inputStreamSource);
	}

	/**
	 * 添加附件
	 *
	 * @param attachmentFilename
	 *            附件显示名称
	 * @param inputStreamSource
	 *            输入流Source
	 * @param contentType
	 *            内容类型
	 * @throws MessagingException
	 */
	public void addAttachment(String attachmentFilename, InputStreamSource inputStreamSource, String contentType)
			throws MessagingException {
		mimeMessageHelper.addAttachment(attachmentFilename, inputStreamSource, contentType);
	}

	/**
	 * 添加附件
	 *
	 * @param attachmentFilename
	 *            附件显示名称
	 * @param dataSource
	 *            数据源
	 * @throws MessagingException
	 */
	public void addAttachment(String attachmentFilename, DataSource dataSource) throws MessagingException {
		mimeMessageHelper.addAttachment(attachmentFilename, dataSource);
	}

	/**
	 * 获得包装的mimeMessageHelper
	 *
	 * @return mimeMessageHelper
	 */
	public MimeMessageHelper getMimeMessageHelper() {
		return mimeMessageHelper;
	}

	/** 邮件的主要属性的getter setter **/

	public void setFrom(String from) throws MessagingException {
		this.from = from;
		mimeMessageHelper.setFrom(from);
	}

	public void setTo(String[] to) throws MessagingException {
		this.to = to;
		mimeMessageHelper.setTo(to);
	}

	public void setCc(String[] cc) throws MessagingException {
		this.cc = cc;
		mimeMessageHelper.setCc(cc);
	}

	public void setBcc(String[] bcc) throws MessagingException {
		this.bcc = bcc;
		mimeMessageHelper.setBcc(bcc);
	}

	public void setSubject(String subject) throws MessagingException {
		this.subject = subject;
		mimeMessageHelper.setSubject(subject);
	}

	public void setText(String text, boolean html) throws MessagingException {
		this.text = text;
		this.html = html;
		mimeMessageHelper.setText(text, html);
	}

	public String getFrom() {
		return from;
	}

	public String[] getTo() {
		return to;
	}

	public String[] getCc() {
		return cc;
	}

	public String[] getBcc() {
		return bcc;
	}

	public String getSubject() {
		return subject;
	}

	public String getText() {
		return text;
	}

	public boolean isHtml() {
		return html;
	}

	public boolean isMultipart() {
		return multipart;
	}
}
