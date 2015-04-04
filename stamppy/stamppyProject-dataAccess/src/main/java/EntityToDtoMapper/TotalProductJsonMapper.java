package EntityToDtoMapper;

import java.util.ArrayList;
import java.util.List;

import org.stamppyProject.model.business.Tshirt;

import business.DTO.TotalProductJsonDTO;
import business.DTO.TotalProductJsonDTO.AvailableColors;
import business.DTO.TotalProductJsonDTO.AvailableSizes;
import business.DTO.TotalProductJsonDTO.Product;

public class TotalProductJsonMapper {
	
	public static TotalProductJsonDTO convert(List<Tshirt> tshirts){
		TotalProductJsonDTO totalProductJsonDTO = new TotalProductJsonDTO();
		if(tshirts.size()>0){
			totalProductJsonDTO.setTotal(tshirts.size());
			List<Product> products = new ArrayList<TotalProductJsonDTO.Product>();
			for(Tshirt tshirt:tshirts){
				Product product = totalProductJsonDTO.new Product();
				product.setProductId(tshirt.getId());
				product.setName(tshirt.getName());
				product.setPrice(tshirt.getPrice());
				product.setAverageRating(tshirt.getRating()!=null? tshirt.getRating().getAverageRating():0);
				product.setRatings(tshirt.getRating()!=null? tshirt.getRating().getRatings():0);
				product.setShippingPrice(tshirt.getShippingPrice());
				product.setImgUrl(tshirt.getUrl());
				product.setKeyWords(tshirt.getKeyWords());
				List<AvailableColors> availableColors = new ArrayList<TotalProductJsonDTO.AvailableColors>();
				for(org.stamppyProject.model.business.AvailableColors ac : tshirt.getAvailableColors()){
					AvailableColors tmp = totalProductJsonDTO.new AvailableColors();
					tmp.setName(ac.getColor().toString());
					availableColors.add(tmp);
				}
				product.setAvailableColors(availableColors);	
				List<AvailableSizes> availableSizes = new ArrayList<TotalProductJsonDTO.AvailableSizes>();
				for(org.stamppyProject.model.business.AvailableSizes as : tshirt.getAvailableSizes()){
					AvailableSizes tmp = totalProductJsonDTO.new AvailableSizes();
					tmp.setName(as.getSize().toString());
					availableSizes.add(tmp);
				}
				product.setAvailableSizes(availableSizes);
				products.add(product);
			}
			totalProductJsonDTO.setProducts(products);
		}
		return totalProductJsonDTO;
	}
}
