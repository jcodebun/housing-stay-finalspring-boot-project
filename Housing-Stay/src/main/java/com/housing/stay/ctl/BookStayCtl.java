
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

import com.housing.stay.dto.BookStayDTO;
import com.housing.stay.dto.HomeStayDTO;
import com.housing.stay.dto.RoomDTO;
import com.housing.stay.dto.UserDTO;
import com.housing.stay.exception.DuplicateRecordException;
import com.housing.stay.form.BookStayForm;
import com.housing.stay.service.BookStayServiceInt;
import com.housing.stay.service.HomeStayServiceInt;
import com.housing.stay.service.RoomServiceInt;
import com.housing.stay.util.DataUtility;

@Controller

@RequestMapping("/ctl/bookStay")
public class BookStayCtl extends BaseCtl {

	@Autowired
	private BookStayServiceInt service;

	@Autowired
	private RoomServiceInt roomService;
	
	@Autowired
	private HomeStayServiceInt homeStayService;

	@ModelAttribute
	public void preload(Model model) {
		model.addAttribute("roomList", roomService.search(null));
	}

	@GetMapping()
	public String display(@RequestParam(required = false) Long id, Long hId, @ModelAttribute("form") BookStayForm form,
			HttpSession session, Model model) {
		if (form.getId() > 0) {
			BookStayDTO bean = service.findBypk(id);
			form.populate(bean);
		}
		hId=DataUtility.getLong(String.valueOf(hId));
		if(hId>0) {
			session.setAttribute("homeId",hId);
		}
		
		RoomDTO rDto=new RoomDTO();
		if(hId>0) {
			rDto.setHomeStayId(hId);
		}
		model.addAttribute("roomList", roomService.search(rDto));
		
		return "bookStay";
	}

	@PostMapping
	public String submit(@Valid @ModelAttribute("form") BookStayForm form, BindingResult bindingResult,
			HttpSession session, Model model, HttpServletRequest request) {
		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/ctl/bookStay";
		}
		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
				if (bindingResult.hasErrors()) {
					return "bookStay";
				}
				BookStayDTO bean = (BookStayDTO) populateDTO(form.getDTO(), request);
				HomeStayDTO hDto=homeStayService.findBypk(DataUtility.getLong(String.valueOf(session.getAttribute("homeId"))));
				bean.setBookingDate(new Date());
				bean.setBookingNo(DataUtility.getRandomBooking());
				bean.setHomeStay(hDto);
				bean.setHomeStayId(hDto.getId());
				bean.setRoomNo(roomService.findBypk(bean.getRoomId()).getRoomNo());
				UserDTO uDto=(UserDTO)session.getAttribute("user");
				bean.setUser(uDto);
				bean.setUserId(uDto.getId());
				bean.setOwnerId(hDto.getUserId());
				if (bean.getId() > 0) {
					service.update(bean);
					model.addAttribute("success", "BookStay update Successfully!!!!");
				} else {
					service.add(bean);
					model.addAttribute("success", "BookStay Added Successfully!!!!");
				}
				return "bookStay";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "bookStay";
		}
		return "";
	}

	@RequestMapping(value = "/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") BookStayForm form,

			@RequestParam(required = false) String operation, Long hid, HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/bookStay/search";
		}

		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();

		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		} else if (OP_NEW.equals(operation)) {
			return "redirect:/ctl/bookStay";
		}

		pageNo = (pageNo < 1) ? 1 : pageNo;
		pageSize = (pageSize < 1) ? 10 : pageSize;

		if (OP_DELETE.equals(operation)) {
			pageNo = 1;
			if (form.getIds() != null) {
				for (long id : form.getIds()) {
					BookStayDTO dto = new BookStayDTO();
					dto.setId(id);
					service.delete(dto);
				}
				model.addAttribute("success", "Deleted Successfully!!!");
			} else {
				model.addAttribute("error", "Select at least one record");
			}
		}
		BookStayDTO dto = (BookStayDTO) form.getDTO();
		hid = DataUtility.getLong(String.valueOf(hid));

		if (hid > 0) {
			dto.setHomeStayId(hid);
		}
		
		UserDTO uDto=(UserDTO)session.getAttribute("user");
		if(uDto.getRoleId()==2) {
			dto.setUserId(uDto.getId());
		}else if(uDto.getRoleId()==3) {
			dto.setOwnerId(uDto.getId());
		}
		

		List<BookStayDTO> list = service.search(dto);
		
		List<BookStayDTO> totallist = service.search(dto);
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
		return "bookStayList";
	}

}
