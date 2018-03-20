package org.evertones.controller;

import org.evertones.model.service.Booking;
import org.evertones.persistence.modules.booking.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookingController extends BaseController {

    private BookingRepository bookingRepository;

    @Autowired
    public void setBookingRepository(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @RequestMapping(path = "/booking/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("booking", new Booking());

        return "/booking/edit";
    }

    @RequestMapping(path = "/add/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable(name = "id") Integer id) {
        Booking booking = bookingRepository.findOne(id);
        model.addAttribute("booking", booking);

        return "booking/edit";
    }

    @RequestMapping(path = "/booking/add", method = RequestMethod.POST)
    public String submit(Booking booking, RedirectAttributes attributes) {
        bookingRepository.save(booking);

        // TODO: 1) Get the default locale; 2) add values for CSS classes in an Enum
        attributes.addFlashAttribute("flashMessage", messageSource.getMessage("module.general.saveSuccess.message", null, DEFAULT_LOCALE));
        attributes.addFlashAttribute("cssClass", "alert alert-success");

        //return String.format("redirect:add/%s", client.getId().toString());
        return String.format("redirect:add/%s", booking.getId().toString());
    }

}
