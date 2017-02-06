package com.rashika.mail;

import java.io.StringWriter;
import java.util.List;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import com.rashika.dao.UserInformationDAO;
import com.rashika.model.UserInformation;;

public class ProjectReportMailer {

	public static String getContent() {
		String templateName = "templates/report_table.vm";

		VelocityEngine ve = new VelocityEngine();
		ve.init();

		Template t = ve.getTemplate(templateName);

		VelocityContext context = new VelocityContext();

		UserInformationDAO dao = new UserInformationDAO();
		List<UserInformation> list = dao.listuserinformation();

		for (UserInformation u : list) {
			System.out.println(u);
		}
		// context.put("NAME", "Janai");
		context.put("ORDER_DETAILS", list);

		StringWriter writer = new StringWriter();

		t.merge(context, writer);
		return writer.toString();
	}

}