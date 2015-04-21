package org.stamppyProject.businessLogic.reports;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.stamppyProject.businessLogic.business.stamp.mapper.StampJsonMapper;
import org.stamppyProject.businessLogic.reports.dto.SalesJson;
import org.stamppyProject.businessLogic.reports.dto.SalesJsonList;
import org.stamppyProject.dataAccess.business.product.IProductDAO;
import org.stamppyProject.model.business.Product;

@Stateless
public class SalesReportBean implements ISalesReport{
	
	@EJB
	private IProductDAO productDAO;
	
	@Override
	public SalesJsonList getSalesByArtist(Long artistId) {
		SalesJsonList slist = new SalesJsonList();
		List<Product> products = productDAO.getSalesByArtist(artistId);
		List<Long> tmp = new ArrayList<Long>();
		for(Product p:products){
			if(!tmp.contains(p.getStamp().getId())){
				tmp.add(p.getStamp().getId());
				SalesJson sj = new SalesJson();
				sj.setNumberSales(getNumberSales(p.getId(), products));
				sj.setStamp(StampJsonMapper.convertToStampJson(p.getStamp()));
				slist.getSales().add(sj);
			}
		}
		return slist;
	}
	
	@Override
	public SalesJsonList getSalesByPeriod(Date lowerBound, Date upperBound) {
		SalesJsonList slist = new SalesJsonList();
		List<Product> products = productDAO.getSalesByPeriod(lowerBound, upperBound);
		List<Long> tmp = new ArrayList<Long>();
		for(Product p:products){
			if(!tmp.contains(p.getStamp().getId())){
				tmp.add(p.getStamp().getId());
				SalesJson sj = new SalesJson();
				sj.setNumberSales(getNumberSales(p.getId(), products));
				sj.setStamp(StampJsonMapper.convertToStampJson(p.getStamp()));
				slist.getSales().add(sj);
			}
		}
		return slist;
	}
	
	private Integer getNumberSales(Long stampId, List<Product> products){
		int cont = 0;
		for(Product p:products){
			if(stampId.equals(p.getStamp().getId()))
				cont++;
		}
		return cont;
	}

}
