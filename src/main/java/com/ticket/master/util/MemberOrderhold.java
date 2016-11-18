package com.ticket.master.util;

import java.util.Date;

import com.ticket.master.constants.Constants;
import com.ticket.master.entities.Orders;

public class MemberOrderhold {
	/**
	 * Member information needed to place an order
	 */
	public static Orders MemberInformationNeededToPlaceOnholdONBehalfOfCustomer() {
		Orders ord = new Orders();
		ord.setEventId(Constants.DEFAULT_EVENT_ID);
		ord.setMemberId(Constants.DEFAULT_MEMBER_ID);
		ord.setOrderStatus(Constants.DEFAULT_ORDER_STATUS);
		ord.setOrderDate(new Date());
		return ord;
	}

}
