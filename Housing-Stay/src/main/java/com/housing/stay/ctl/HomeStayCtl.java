package com.housing.stay.ctl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.housing.stay.dto.HomeStayDTO;
import com.housing.stay.dto.UserDTO;
import com.housing.stay.exception.DuplicateRecordException;
import com.housing.stay.form.HomeStayForm;
import com.housing.stay.service.HomeStayServiceInt;



@Controller
@RequestMapping("/ctl/homeStay")
public class HomeStayCtl extends BaseCtl {

	@Autowired
	private HomeStayServiceInt service;
	
	@ModelAttribute
	public void preload(Model model) {
		
	}

	@GetMapping()
	public String display(@RequestParam(required = false) Long id, Long pId, @ModelAttribute("form") HomeStayForm form,
			HttpSession session, Model model) {
		if (form.getId() > 0) {
			HomeStayDTO bean = service.findBypk(id);
			form.populate(bean);
		}
		return "homeStay";
	}
	

	@PostMapping
	public String submit(@Valid @ModelAttribute("form") HomeStayForm form, BindingResult bindingResult,
			HttpSession session, Model model,HttpServletRequest request) {
		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/ctl/homeStay";
		}
		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
				if (bindingResult.hasErrors()) {
					return "homeStay";
				}
				HomeStayDTO bean = (HomeStayDTO) populateDTO(form.getDTO(),request);
				UserDTO uDto=(UserDTO)session.getAttribute("user");
				bean.setUserId(uDto.getId());
				if (bean.getId() > 0) {
					service.update(bean);
					model.addAttribute("success", "HomeStay update Successfully!!!!");
				} else {
					service.add(bean);
					model.addAttribute("success", "HomeStay Added Successfully!!!!");
				}
				return "homeStay";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "homeStay";
		}
		return "";
	}

	@RequestMapping(value = "/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") HomeStayForm form,
			@RequestParam(required = false) String operation, Long vid, HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/homeStay/search";
		}

		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();

		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		} else if (OP_NEW.equals(operation)) {
			return "redirect:/ctl/homeStay";
		}

		pageNo = (pageNo < 1) ? 1 : pageNo;
		pageSize = (pageSize < 1) ? 10 : pageSize;

		if (OP_DELETE.equals(operation)) {
			pageNo = 1;
			if (form.getIds() != null) {
				for (long id : form.getIds()) {
					HomeStayDTO dto = new HomeStayDTO();
					dto.setId(id);
					service.delete(dto);
				}
				model.addAttribute("success", "Deleted Successfully!!!");
			} else {
				model.addAttribute("error", "Select at least one record");
			}
		}
		HomeStayDTO dto = (HomeStayDTO) form.getDTO();
		UserDTO uDto=(UserDTO)session.getAttribute("user");
		if(uDto.getRoleId()==3) {
			dto.setUserId(uDto.getId());
		}
		
		List<HomeStayDTO> list = service.search(dto, pageNo, pageSize);
		List<HomeStayDTO> totallist = service.search(dto);
		model.addAttribute("list", list);

		if (list.size() == 0 && !OP_DELETE.equalsIgnoreCase(operation)) {
			model.addAttribute("error", "Record not found");
		}

		int listsize = list.size();
		int total = totallist.size();
		int pageNoPageSize = pageNo * pageSize;

		form.setPageNo(pageNo);
		form.setPageSize(pageSize);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("listsize", listsize);
		model.addAttribute("total", total);
		model.addAttribute("pagenosize", pageNoPageSize);
		model.addAttribute("form", form);
		return "homeStayList";
	}
	
	
	

}
