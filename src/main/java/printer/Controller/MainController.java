package printer.Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import printer.Client.PrinterJobClient;
import printer.Model.UserModel;
import printer.Service.UserModelService;

@Controller
public class MainController {

	@Autowired
	private UserModelService userModelService;

	@RequestMapping("/")
	public String home() {
		return "index";
	}

	@RequestMapping(value = "processDoc", method = RequestMethod.POST)
	public String handleDoc(@RequestParam("fileUp") CommonsMultipartFile fileUpPath,
			@RequestParam(value = "instantPrint", defaultValue = "false") boolean instantPrint,
			@RequestParam(value = "isPrintedBefore", defaultValue = "false") boolean isPrintedBefore, HttpSession s,
			Model model) throws Exception {

		byte[] fileData = fileUpPath.getBytes();
		String fname = fileUpPath.getOriginalFilename();
		String path = s.getServletContext().getRealPath("/") + "WEB-INF" + File.separator + "resources" + File.separator
				+ "doc" + File.separator;

		System.out.println(path);

		/* To save the Document/File to WEB-INF/resources/doc location */
		try {
			FileOutputStream fos = new FileOutputStream(path + fname);
			fos.write(fileData);
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (!instantPrint) {
			instantPrint = false;
		} else {
			instantPrint = true;

			if (instantPrint == true) {
				System.out.println("going inside PrinterJobClient");
				PrinterJobClient printerJobClient = new PrinterJobClient();
				printerJobClient.printing(path, fname);
			}
		}

		System.out.println(instantPrint);

		/* Creating UserModel Object using Setter methods to send to database */
		UserModel user = new UserModel();

		/* Logic to check the document was printed before or not */

		System.out.println(isPrintedBefore);

		user.setFileName(fname);
		user.setFileUpPath(path);
		user.setInstantPrint(instantPrint);
		user.setPrintedBefore(isPrintedBefore);

		LocalDateTime ldt = LocalDateTime.now();
		String formattedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(ldt);
		System.out.println(formattedDate);
		user.setUploadDate(formattedDate);

		/* saving UserModel to database */
		int createdUser = this.userModelService.createUserModel(user);

		model.addAttribute("userModelMessage", "Successfully uploaded file with details");

		return "/success";
	}

}