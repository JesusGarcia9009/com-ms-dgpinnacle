package com.ms.dgpinnacle.mail;

import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_END;
import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_START;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailService {

	private final JavaMailSender javaMailSender;
	private final TemplateEngine templateEngine;
	private final MailPropertiesFactory mailPropertiesFactory;

	public void sendMail(String email, String type, String pass) {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		try {
			// type solo puede ser "letter" o "realtor" si se agregan mas letters hay que
			// agregar mas propiedades
			AbstractMailProperties props = mailPropertiesFactory.getMailProperties(type);

			/// Crea el contexto
			Context context = new Context();

			// propiedades generales
			context.setVariable("subheading", props.getSubheading());
			context.setVariable("subtitle", props.getSubheading());
			context.setVariable("text", props.getSubheading());
			context.setVariable("pass", pass);

			// propiedades para realtor
			boolean condition = props instanceof MailRealtorProperties;
			context.setVariable("username", condition ? email : "");
			context.setVariable("passtext", condition ? ((MailRealtorProperties) props).getPass() : "");
			context.setVariable("recommend", condition ? ((MailRealtorProperties) props).getRecommend() : "");

			/// Procesa el template
			String process = templateEngine.process(props.getUrl(), context);
			javax.mail.internet.MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

			// Set Mail
			helper.setSubject(props.getSubject());
			helper.setText(process, true);
			helper.setTo(email);
			javaMailSender.send(mimeMessage);

		} catch (Exception e) {
			// error no debe mostrarse en el front
			e.printStackTrace();
		}

		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
	}

}
