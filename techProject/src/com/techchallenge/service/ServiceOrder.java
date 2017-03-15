package com.techchallenge.service;

import com.techchallenge.domain.Order;

import java.util.List;

import com.techchallenge.beans.Creator;
import com.techchallenge.beans.Items;
import com.techchallenge.dao.DaoOrderImpl;

public class ServiceOrder {
	
	public void saveOrder(com.techchallenge.beans.Order order,Creator creator){
		List<Items> items = order.getItems();
		
		Order domainOrder = new Order();
		domainOrder.setEditionCode(order.getEditionCode());
		domainOrder.setAddonOfferingCode(order.getAddonOfferingCode());
		domainOrder.setPricingDuration(order.getPricingDuration());
		
		if(items.size() > 0){
			Items item = items.get(0);
			domainOrder.setItemsUnit(item.getUnit());
			domainOrder.setItemsQuantity(item.getQuantity());
		}else{
			domainOrder.setItemsUnit(null);
			domainOrder.setItemsQuantity(null);
		}
		
		domainOrder.setCreatorUuid(creator.getUuid());
		DaoOrderImpl daoOrderImpl = new DaoOrderImpl();
		daoOrderImpl.save(domainOrder);
	}
	
	public void updateOrder(Order order){
		DaoOrderImpl daoOrderImpl = new DaoOrderImpl();
		daoOrderImpl.update(order);
	}
	
	public Order findByUuid(String uuid){
		DaoOrderImpl daoOrderImpl = new DaoOrderImpl();
		return daoOrderImpl.findByUuid(uuid);
	}
}
