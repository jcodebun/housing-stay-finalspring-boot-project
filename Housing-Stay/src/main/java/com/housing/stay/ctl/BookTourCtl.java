
package com.housing.stay.ctl;

import java.util.Date;
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

import com.housing.stay.dto.BookTourDTO;
import com.housing.stay.dto.TourPackageDTO;
import com.housing.stay.dto.UserDTO;
import com.housing.stay.exception.DuplicateRecordException;
import com.housing.stay.form.BookTourForm;
import com.housing.stay.service.BookTourServiceInt;
import com.housing.stay.service.HomeStayServiceInt;
import com.housing.stay.service.RoomServiceInt;
import com.housing.stay.service.TourPackageServiceInt;
import com.housing.stay.util.DataUtility;

@Controller

@RequestMapping("/ctl/bookTour")
public class BookTourCtl extends BaseCtl {

	@Autowired
	private BookTourServiceInt service;

	@Autowired
	private RoomServiceInt roomService;
	
	@Autowired
	private HomeStayServiceInt homeStayService;
	
	@Autowired
	private TourPackageServiceInt tourPackageService;

	@ModelAttribute
	public void preload(Model model) {
	}

	@GetMapping()
	public String display(@RequestParam(required = false) Long id, Long hId, @ModelAttribute("form") BookTourForm form,
			HttpSession session, Model model) {
		if (form.getId() > 0) {
			BookTourDTO bean = service.findBypk(id);
			form.populate(bean);
		}
		hId=DataUtility.getLong(String.valueOf(hId));
		if(hId>0) {
			session.setAttribute("tourId",hId);
		}
		return "bookTour";
	}

	@PostMapping
	public String submit(@Valid @ModelAttribute("form") BookTourForm form, BindingResult bindingResult,
			HttpSession session, Model model, HttpServletRequest request) {
		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/ctl/bookTour";
		}
		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
				if (bindingResult.hasErrors()) {
					return "bookTour";
				}
				BookTourDTO bean = (BookTourDTO) populateDTO(form.getDTO(), request);
				TourPackageDTO hDto=tourPackageService.findBypk(DataUtility.getLong(String.valueOf(session.getAttribute("tourId"))));
				bean.setBookingDate(new Date());
				bean.setBookingNo(DataUtility.getRandomBooking());
				bean.setTourPackage(hDto);
				bean.setTourId(hDto.getId());
				UserDTO uDto=(UserDTO)session.getAttribute("user");
				bean.setUser(uDto);
				bean.setUserId(uDto.getId());
				bean.setOwnerId(hDto.getUserId());
				if (bean.getId() > 0) {
					service.update(bean);
					model.addAttribute("success", "BookTour update Successfully!!!!");
				} else {
					service.add(bean);
					model.addAttribute("success", "BookTour Added Successfully!!!!");
				}
				return "bookTour";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "bookTour";
		}
		return "";
	}

	@RequestMapping(value = "/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") BookTourForm form,

			@RequestParam(required = false) String operation, Long hid, HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/bookTour/search";
		}

		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();

		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		} else if (OP_NEW.equals(operation)) {
			return "redirect:/ctl/bookTour";
		}

		pageNo = (pageNo < 1) ? 1 : pageNo;
		pageSize = (pageSize < 1) ? 10 : pageSize;

		if (OP_DELETE.equals(operation)) {
			pageNo = 1;
			if (form.getIds() != null) {
				for (long id : form.getIds()) {
					BookTourDTO dto = new BookTourDTO();
					dto.setId(id);
					service.delete(dto);
				}
				model.addAttribute("success", "Deleted Successfully!!!");
			} else {
				model.addAttribute("error", "Select at least one record");
			}
		}
		BookTourDTO dto = (BookTourDTO) form.getDTO();
		hid = DataUtility.getLong(String.valueOf(hid));

		if (hid > 0) {
			dto.setTourId(hid);
		}

		UserDTO uDto=(UserDTO)session.getAttribute("user");
		if(uDto.getRoleId()==2) {
			dto.setUserId(uDto.getId());
		}else if(uDto.getRoleId()==3) {
			dto.setOwnerId(uDto.getId());
		}
		
		List<BookTourDTO> list = service.search(dto);
		List<BookTourDTO> totallist = service.search(dto);
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
		return "bookTourList";
	}

}
