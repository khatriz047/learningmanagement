package mum.cs544.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import mum.cs544.dto.ChangePasswordDTO;
import mum.cs544.model.User;
import mum.cs544.service.UserService;
import mum.cs544.utils.FileMeta;

@Controller
@SessionAttributes("username")
public class MainController {

	@Autowired
	UserService userService;

	@Autowired
	ServletContext context;

	@RequestMapping("/")
	public String redirectRoot() {
		return "login";
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String userProfilePage(Model model, HttpSession session) {
		model.addAttribute("user", userService.findByUsername((String) session.getAttribute("username")));
		model.addAttribute("changePasswordDTO", new ChangePasswordDTO());

		return "profile";
	}

	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	// public String updateUserProfile(@Valid User user, BindingResult results,
	// RedirectAttributes redirectAttrs) {
	public String updateUserProfile(@Valid User user, BindingResult results) {
		if (!results.hasErrors()) {
			userService.updateUserProfile(user);
			user.setError(false);
			return "redirect:/profile";
		} else {
			user.setError(true);
			return "profile";
		}

	}

	@RequestMapping(value = "profile/savephoto", method = RequestMethod.POST)
	public String saveProfilePhoto(User user) {
		System.out.println(user.getId());
		userService.updateProfilePicture(user.getImageUrl(), user.getId());
		return "redirect:/profile";

	}

	@RequestMapping(value = "profile/upload", method = RequestMethod.POST)
	public @ResponseBody LinkedList<FileMeta> uploading(MultipartHttpServletRequest request,
			HttpServletResponse response) {

		LinkedList<FileMeta> files = new LinkedList<FileMeta>();
		FileMeta fileMeta = null;

		String FILE_URL = context.getRealPath("") + "resources/";

		/*
		 * String officialEmail ="SDS";// request.getParameter("officialEmail");
		 * if (StringUtils.isNotEmpty(officialEmail) &&
		 * officialEmail.contains("@")) { officialEmail =
		 * officialEmail.substring(0, officialEmail.indexOf('@')); }
		 */

		// 1. build an iterator
		Iterator<String> itr = request.getFileNames();
		MultipartFile mpf = null;

		// 2. get each file
		while (itr.hasNext()) {

			// 2.1 get next MultipartFile
			mpf = request.getFile(itr.next());
			System.out.println(mpf.getOriginalFilename() + " uploaded! " + files.size());

			// 2.2 if files > 10 remove the first from the list
			if (files.size() >= 10)
				files.pop();

			// 2.3 create new fileMeta
			fileMeta = new FileMeta();
			fileMeta.setFileName(mpf.getOriginalFilename());
			fileMeta.setFileSize(mpf.getSize() / 1024 + " Kb");
			fileMeta.setFileType(mpf.getContentType());
			fileMeta.setFileURL(FILE_URL + mpf.getOriginalFilename());

			try {
				fileMeta.setBytes(mpf.getBytes());

				File originalFile = new File(FILE_URL + mpf.getOriginalFilename());
				System.out.println("FILE_URL : " + FILE_URL);
				/*
				 * File renamedFile = new File(FILE_URL + officialEmail + "_" +
				 * mpf.getOriginalFilename()); if
				 * (originalFile.renameTo(renamedFile)) {
				 * System.out.println("Renamed"); } else { System.out.println(
				 * "Renaming failed"); }
				 */

				// copy file to local disk (make sure the path
				// "e.g. D:/temp/files" exists)
				FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream(originalFile));

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 2.4 add to files
			files.add(fileMeta);

		}

		// result will be like this
		// [{"fileName":"app_engine-85x77.png","fileSize":"8
		// Kb","fileType":"image/png"},...]
		return files;

	}

}