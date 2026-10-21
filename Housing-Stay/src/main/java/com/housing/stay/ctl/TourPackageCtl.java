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
import com.housing.stay.dto.TourPackageDTO;
import com.housing.stay.dto.UserDTO;
import com.housing.stay.exception.DuplicateRecordException;
import com.housing.stay.form.TourPackageForm;
import com.housing.stay.service.HomeStayServiceInt;
import com.housing.stay.service.TourPackageServiceInt;
import com.housing.stay.util.DataUtility;



@Controller
@RequestMapping("/ctl/tourPackage")
public class TourPackageCtl extends BaseCtl {

	@Autowired
	private TourPackageServiceInt service;
	
	@Autowired
	private HomeStayServiceInt homeStayService;
	
	@ModelAttribute
	public void preload(Model model) {
		model.addAttribute("homeStayList",homeStayService.list());
	}

	@GetMapping()
	public String display(@RequestParam(required = false) Long id, Long pId, @ModelAttribute("form") TourPackageForm form,
			HttpSession session, Model model) {
		if (form.getId() > 0) {
			TourPackageDTO bean = service.findBypk(id);
			form.populate(bean);
		}
		return "tourPackage";
	}
	

	@PostMapping
	public String submit(@Valid @ModelAttribute("form") TourPackageForm form, BindingResult bindingResult,
			HttpSession session, Model model,HttpServletRequest request) {
		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/ctl/tourPackage";
		}
		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
				if (bindingResult.hasErrors()) {
					return "tourPackage";
				}
				TourPackageDTO bean = (TourPackageDTO) populateDTO(form.getDTO(),request);
				HomeStayDTO homeDto=homeStayService.findBypk(bean.getHomeStayId());
				bean.setHomeStay(homeDto);
				UserDTO uDto=(UserDTO)session.getAttribute("user");
				bean.setUserId(uDto.getId());
				if (bean.getId() > 0) {
					service.update(bean);
					model.addAttribute("success", "TourPackage update Successfully!!!!");
				} else {
					service.add(bean);
					model.addAttribute("success", "TourPackage Added Successfully!!!!");
				}
				return "tourPackage";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "tourPackage";
		}
		return "";
	}

	@RequestMapping(value = "/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") TourPackageForm form,
			@RequestParam(required = false) String operation, Long hid, HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/tourPackage/search";
		}

		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();

		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		} else if (OP_NEW.equals(operation)) {
			return "redirect:/ctl/tourPackage";
		}

		pageNo = (pageNo < 1) ? 1 : pageNo;
		pageSize = (pageSize < 1) ? 10 : pageSize;

		if (OP_DELETE.equals(operation)) {
			pageNo = 1;
			if (form.getIds() != null) {
				for (long id : form.getIds()) {
					TourPackageDTO dto = new TourPackageDTO();
					dto.setId(id);
					service.delete(dto);
				}
				model.addAttribute("success", "Deleted Successfully!!!");
			} else {
				model.addAttribute("error", "Select at least one record");
			}
		}
		TourPackageDTO dto = (TourPackageDTO) form.getDTO();
			hid=DataUtility.getLong(String.valueOf(hid));
			
			if(hid>0) {
					dto.setHomeStayId(hid);
			}
			
			UserDTO uDto=(UserDTO)session.getAttribute("user");
			if(uDto.getRoleId()==3) {
				dto.setUserId(uDto.getId());
			}
			
		List<TourPackageDTO> list = service.search(dto, pageNo, pageSize);
		List<TourPackageDTO> totallist = service.search(dto);
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
		return "tourPackageList";
	}
	

}
