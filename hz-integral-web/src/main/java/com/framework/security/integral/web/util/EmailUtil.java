package com.framework.security.integral.web.util;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.net.URL;
import java.util.*;

/**
 *  emailUtil
 * <p>
 * May be the smallest mail send library.
 *
 * @author gaoxu
 * 2020/1/5
 */
public class EmailUtil {

    private static Session session;
    private static String user;

    private MimeMessage msg;
    private String text;
    private String html;
    private List<MimeBodyPart> attachments = new ArrayList<MimeBodyPart>();

    private EmailUtil() {
    }

    /**
     *  初始化配置
     * @param debug
     * @return
     */
    public static Properties defaultConfig(Boolean debug) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.debug", null != debug ? debug.toString() : "false");
        props.put("mail.smtp.timeout", "10000");
        props.put("mail.smtp.port", "465");
        return props;
    }

    /**
     * SMTP 企业qq
     *
     * @param debug
     * @return
     */
    public static Properties SMTP_ENT_QQ(boolean debug) {
        Properties props = defaultConfig(debug);
        props.put("mail.smtp.host", "smtp.exmail.qq.com");
        return props;
    }

    /**
     * smtp qq
     *
     * @param debug enable debug
     * @return
     */
    public static Properties SMTP_QQ(boolean debug) {
        Properties props = defaultConfig(debug);
        props.put("mail.smtp.host", "smtp.qq.com");
        return props;
    }

    /**
     * smtp 163
     *
     * @param debug enable debug
     * @return
     */
    public static Properties SMTP_163(Boolean debug) {
        Properties props = defaultConfig(debug);
        props.put("mail.smtp.host", "smtp.163.com");
        return props;
    }

    /**
     * 设置用户名和密码
     *
     * @param props    邮件的初始配置
     * @param username 鉴权用户名
     * @param password 鉴权密码
     */
    public static void config(Properties props, final String username, final String password) {
        props.setProperty("username", username);
        props.setProperty("password", password);
        config(props);
    }

    public static void config(Properties props) {
        final String username = props.getProperty("username");
        final String password = props.getProperty("password");
        user = username;
        session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
    }

    /**
     * 设置电子邮件主题
     *
     * @param subject 主题名称
     */
    public static EmailUtil subject(String subject) throws SendMailException {
        EmailUtil emailUtil = new EmailUtil();
        emailUtil.msg = new MimeMessage(session);
        try {
            emailUtil.msg.setSubject(subject, "UTF-8");
        } catch (Exception e) {
            throw new SendMailException(e);
        }
        return emailUtil;
    }

    /**
     * 设置来自的电子邮件
     *
     * @param nickName 来自昵称
     */
    public EmailUtil from(String nickName) throws SendMailException {
        return from(nickName, user);
    }

    /**
     * 设置电子邮件昵称并来自用户
     *
     * @param nickName 来自昵称
     * @param from     来自邮箱
     */
    public EmailUtil from(String nickName, String from) throws SendMailException {
        try {
            String encodeNickName = MimeUtility.encodeText(nickName);
            msg.setFrom(new InternetAddress(encodeNickName + " <" + from + ">"));
        } catch (Exception e) {
            throw new SendMailException(e);
        }
        return this;
    }

    public EmailUtil replyTo(String... replyTo) throws SendMailException {
        String result = Arrays.asList(replyTo).toString().replaceAll("(^\\[|\\]$)", "").replace(", ", ",");
        try {
            msg.setReplyTo(InternetAddress.parse(result));
        } catch (Exception e) {
            throw new SendMailException(e);
        }
        return this;
    }

    public EmailUtil replyTo(String replyTo) throws SendMailException {
        try {
            msg.setReplyTo(InternetAddress.parse(replyTo.replace(";", ",")));
        } catch (Exception e) {
            throw new SendMailException(e);
        }
        return this;
    }

    public EmailUtil to(String... to) throws SendMailException {
        try {
            return addRecipients(to, Message.RecipientType.TO);
        } catch (MessagingException e) {
            throw new SendMailException(e);
        }
    }

    public EmailUtil to(String to) throws SendMailException {
        try {
            return addRecipient(to, Message.RecipientType.TO);
        } catch (MessagingException e) {
            throw new SendMailException(e);
        }
    }

    public EmailUtil cc(String... cc) throws SendMailException {
        try {
            return addRecipients(cc, Message.RecipientType.CC);
        } catch (MessagingException e) {
            throw new SendMailException(e);
        }
    }

    public EmailUtil cc(String cc) throws SendMailException {
        try {
            return addRecipient(cc, Message.RecipientType.CC);
        } catch (MessagingException e) {
            throw new SendMailException(e);
        }
    }

    public EmailUtil bcc(String... bcc) throws SendMailException {
        try {
            return addRecipients(bcc, Message.RecipientType.BCC);
        } catch (MessagingException e) {
            throw new SendMailException(e);
        }
    }

    public EmailUtil bcc(String bcc) throws MessagingException {
        return addRecipient(bcc, Message.RecipientType.BCC);
    }

    private EmailUtil addRecipients(String[] recipients, Message.RecipientType type) throws MessagingException {
        String result = Arrays.asList(recipients).toString().replace("(^\\[|\\]$)", "").replace(", ", ",");
        msg.setRecipients(type, InternetAddress.parse(result));
        return this;
    }

    private EmailUtil addRecipient(String recipient, Message.RecipientType type) throws MessagingException {
        msg.setRecipients(type, InternetAddress.parse(recipient.replace(";", ",")));
        return this;
    }

    public EmailUtil text(String text) {
        this.text = text;
        return this;
    }

    public EmailUtil html(String html) {
        this.html = html;
        return this;
    }

    public EmailUtil attach(File file) throws SendMailException {
        attachments.add(createAttachment(file, null));
        return this;
    }

    public EmailUtil attach(File file, String fileName) throws SendMailException {
        attachments.add(createAttachment(file, fileName));
        return this;
    }

    public EmailUtil attachURL(URL url, String fileName) throws SendMailException {
        attachments.add(createURLAttachment(url, fileName));
        return this;
    }

    private MimeBodyPart createAttachment(File file, String fileName) throws SendMailException {
        MimeBodyPart attachmentPart = new MimeBodyPart();
        FileDataSource fds            = new FileDataSource(file);
        try {
            attachmentPart.setDataHandler(new DataHandler(fds));
            attachmentPart.setFileName(null == fileName ? MimeUtility.encodeText(fds.getName()) : MimeUtility.encodeText(fileName));
        } catch (Exception e) {
            throw new SendMailException(e);
        }
        return attachmentPart;
    }

    private MimeBodyPart createURLAttachment(URL url, String fileName) throws SendMailException {
        MimeBodyPart attachmentPart = new MimeBodyPart();

        DataHandler dataHandler = new DataHandler(url);
        try {
            attachmentPart.setDataHandler(dataHandler);
            attachmentPart.setFileName(null == fileName ? MimeUtility.encodeText(fileName) : MimeUtility.encodeText(fileName));
        } catch (Exception e) {
            throw new SendMailException(e);
        }
        return attachmentPart;
    }

    public void send() throws SendMailException {
        if (text == null && html == null) {
            throw new IllegalArgumentException("At least one context has to be provided: Text or Html");
        }

        MimeMultipart cover;
        boolean       usingAlternative = false;
        boolean       hasAttachments   = attachments.size() > 0;

        try {
            if (text != null && html == null) {
                // TEXT ONLY
                cover = new MimeMultipart("mixed");
                cover.addBodyPart(textPart());
            } else if (text == null && html != null) {
                // HTML ONLY
                cover = new MimeMultipart("mixed");
                cover.addBodyPart(htmlPart());
            } else {
                // HTML + TEXT
                cover = new MimeMultipart("alternative");
                cover.addBodyPart(textPart());
                cover.addBodyPart(htmlPart());
                usingAlternative = true;
            }

            MimeMultipart content = cover;
            if (usingAlternative && hasAttachments) {
                content = new MimeMultipart("mixed");
                content.addBodyPart(toBodyPart(cover));
            }

            for (MimeBodyPart attachment : attachments) {
                content.addBodyPart(attachment);
            }

            msg.setContent(content);
            msg.setSentDate(new Date());
            Transport.send(msg);
        } catch (Exception e) {
            throw new SendMailException(e);
        }
    }

    private MimeBodyPart toBodyPart(MimeMultipart cover) throws MessagingException {
        MimeBodyPart wrap = new MimeBodyPart();
        wrap.setContent(cover);
        return wrap;
    }

    private MimeBodyPart textPart() throws MessagingException {
        MimeBodyPart bodyPart = new MimeBodyPart();
        bodyPart.setText(text);
        return bodyPart;
    }

    private MimeBodyPart htmlPart() throws MessagingException {
        MimeBodyPart bodyPart = new MimeBodyPart();
        bodyPart.setContent(html, "text/html; charset=utf-8");
        return bodyPart;
    }

}