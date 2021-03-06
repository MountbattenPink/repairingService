package com.glomozda.machinerepair;
import java.awt.List;
import java.security.Principal;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
 
import java.util.Map;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.glomozda.machinerepair.domain.client.Client;
import com.glomozda.machinerepair.domain.machines_serviceable.Machines_serviceable;
import com.glomozda.machinerepair.repository.client.ClientService;
import com.glomozda.machinerepair.repository.order.OrderService;
//import com.glomozda.machinerepair.repository.order.OrderService;
import com.glomozda.machinerepair.repository.repair_type.Repair_TypeService;
import com.glomozda.machinerepair.repository.user.UserService;
import com.glomozda.machinerepair.repository.userauthorization.UserAuthorizationService;
import com.glomozda.machinerepair.domain.machines_serviceable.Machines_serviceableService;
import com.glomozda.machinerepair.domain.order.Order;
//import com.glomozda.machinerepair.domain.order.Order;
//import com.glomozda.machinerepair.domain.order.Order;
import com.glomozda.machinerepair.domain.repair_type.Repair_Type;
import com.glomozda.machinerepair.domain.user.User;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 

@Controller
public class OrderHistoryController implements MessageSourceAware  {
	@Autowired
	private OrderService os;
	@Autowired
	private Machines_serviceableService mss;

	@Autowired
	private UserService userSvc;

	@Autowired
	private UserAuthorizationService userAuthorizationSvc;

	@Autowired
	private ClientService clientSvc;	

	@Autowired
	private Repair_TypeService rtSvc;	

	
	
	static Logger log = Logger.getLogger(AddMachineController.class.getName());
	private MessageSource messageSource;	
	
	@Override
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	

	 @RequestMapping(value = "/orderhistory")
	    public String viewdoneorders(Locale locale, Model model, final Principal principal) {
		  log.info("Here you can view done orders: "+ locale.toString());
	      //  log.info(rtSvc.fetchAllRepair_Type());
	      //  model.addAttribute("doneOrder",
	        ArrayList<OrderMachineRepair_Type> omr=new ArrayList<OrderMachineRepair_Type>();
	        	//	ArrayList<OrderMachineRepair_Type> ord= (ArrayList<Order>)
	        for (Order o:os.fetchAllUnpendedOrders()){
	        	omr.add(new OrderMachineRepair_Type(o, rtSvc.fetchAllRepair_TypeById(o.getType_id())));
	        }
	        
	        
	        
	        
	        
	        log.info("------"+omr);
	//        for (Order o: os.fetchAllNewOrderById(userSvc.getUserByLogin(principal.getName()).getClient().getClientId())){
	 //       	omr.add(o);}
	       
	   //     			model.addAttribute("tyre", os.getAll());
	        					//.selectAllDoneByClientId(userSvc.getUserByLogin(principal.getName()).getClient().getClientId()));
//	       for (Order o: ord){
//	    	   omr.add(new OrderMachineRepair_Type(o.getOrder_id(), o.getStart(), o.getStatus(), o.getClients_id(), o.getType_id(), o.getMachine_id(), rtSvc.fetchAllRepair_TypeById(o.getMachine_id()).getName(),
//	    			   rtSvc.fetchAllRepair_TypeById(o.getMachine_id()).getPrice(), 
//	    			   rtSvc.fetchAllRepair_TypeById(o.getMachine_id()).getDuration()));
	//    	  omr.add(new OrderMachineRepair_Type(o.getOrder_id(), o.getStart(), o.getStatus(), o.getClients_id(), o.getType_id(), o.getMachine_id(), rtSvc.fetchAllRepair_TypeById(o.getMachine_id()).getName(), rtSvc.fetchAllRepair_TypeById(o.getMachine_id()).getPrice(), rtSvc.fetchAllRepair_TypeById(o.getMachine_id()).getDuration()));
//	       }
	       model.addAttribute("orderMachineRepair",omr);
	     //   log.info(mss.fetchAllMachines_serviceable(11));
	       // log.info(os.fetchAllOrder());//fetchAllOrderDoneByClientId(userSvc.getUserByLogin(principal.getName()).getClient().getClientId()));
	        
	        
	    //    Date date = new Date();
	    //    DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
	         
	    //    String formattedDate = dateFormat.format(date);
	         
	    //    model.addAttribute("serverTime", formattedDate );
	         
	        return "orderhistory";
	    }
}
