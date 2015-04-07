package business.entityToDtoMapper;

import java.util.ArrayList;
import java.util.List;

import org.stamppyProject.model.business.Tshirt;
import org.stamppyProject.model.enumerations.ColorEnum;
import org.stamppyProject.model.enumerations.SizeEnum;

import business.DTO.ProductJsonDTO;
import business.DTO.ProductJsonDTO.AvailableColors;
import business.DTO.ProductJsonDTO.AvailableSizes;
import business.DTO.ProductJsonDTO.Product;

public class ProductJsonMapper {
	
	public static ProductJsonDTO convertToProductJsonDTO(List<Tshirt> tshirts){
		ProductJsonDTO ProductJsonDTO = new ProductJsonDTO();
		if(tshirts.size()>0){
			ProductJsonDTO.setTotal(tshirts.size());
			List<Product> products = new ArrayList<ProductJsonDTO.Product>();
			for(Tshirt tshirt:tshirts){
				Product product = ProductJsonDTO.new Product();
				product.setProductId(tshirt.getId());
				product.setName(tshirt.getName());
				product.setPrice(tshirt.getPrice());
				product.setAverageRating(tshirt.getRating()!=null? tshirt.getRating().getAverageRating():0);
				product.setRatings(tshirt.getRating()!=null? tshirt.getRating().getRatings():0);
				product.setShippingPrice(tshirt.getShippingPrice());
				product.setImgUrl(tshirt.getUrl());
				product.setKeyWords(tshirt.getKeyWords());
				List<AvailableColors> availableColors = new ArrayList<ProductJsonDTO.AvailableColors>();
				for(org.stamppyProject.model.business.AvailableColors ac : tshirt.getAvailableColors()){
					AvailableColors tmp = ProductJsonDTO.new AvailableColors();
					tmp.setName(ac.getColor().toString());
					availableColors.add(tmp);
				}
				product.setAvailableColors(availableColors);	
				List<AvailableSizes> availableSizes = new ArrayList<ProductJsonDTO.AvailableSizes>();
				for(org.stamppyProject.model.business.AvailableSizes as : tshirt.getAvailableSizes()){
					AvailableSizes tmp = ProductJsonDTO.new AvailableSizes();
					tmp.setName(as.getSize().toString());
					availableSizes.add(tmp);
				}
				product.setAvailableSizes(availableSizes);
				products.add(product);
			}
			ProductJsonDTO.setProducts(products);
		}
		return ProductJsonDTO;
	}
	
	public static List<Tshirt> convertToTshirts(ProductJsonDTO productJsonDTO){
		List<Tshirt> tshirts = new ArrayList<Tshirt>();
		for(Product product:productJsonDTO.getProducts()){
			Tshirt tshirt = new Tshirt();
			tshirt.setName(product.getName());
			tshirt.setPrice(product.getPrice());
			tshirt.setShippingPrice(product.getShippingPrice());
			tshirt.setUrl(product.getImgUrl());
			//TODO get user in session
			tshirt.setKeyWords(product.getKeyWords());
			List<org.stamppyProject.model.business.AvailableColors> availableColors 
				= new ArrayList<org.stamppyProject.model.business.AvailableColors>();
			for(AvailableColors ac : product.getAvailableColors()){
				org.stamppyProject.model.business.AvailableColors tmp = new org.stamppyProject.model.business.AvailableColors();
				if(ac.getName().equals(ColorEnum.BLACK.toString()))
					tmp.setColor(ColorEnum.BLACK);
				else if(ac.getName().equals(ColorEnum.BLUE.toString()))
					tmp.setColor(ColorEnum.BLUE);
				else if(ac.getName().equals(ColorEnum.GREEN.toString()))
					tmp.setColor(ColorEnum.GREEN);
				else if(ac.getName().equals(ColorEnum.WHITE.toString()))
					tmp.setColor(ColorEnum.WHITE);
				else if(ac.getName().equals(ColorEnum.RED.toString()))
					tmp.setColor(ColorEnum.RED);
				else if(ac.getName().equals(ColorEnum.YELLOW.toString()))
					tmp.setColor(ColorEnum.YELLOW);
				availableColors.add(tmp);
			}
			
			List<org.stamppyProject.model.business.AvailableSizes> availableSizes
				= new ArrayList<org.stamppyProject.model.business.AvailableSizes>();
			for(AvailableSizes as : product.getAvailableSizes()){
				org.stamppyProject.model.business.AvailableSizes tmp = new org.stamppyProject.model.business.AvailableSizes();
				if(as.getName().equals(SizeEnum.XS.toString()))
					tmp.setSize(SizeEnum.XS);
				else if(as.getName().equals(SizeEnum.M.toString()))
					tmp.setSize(SizeEnum.M);
				else if(as.getName().equals(SizeEnum.L.toString()))
					tmp.setSize(SizeEnum.L);
				else if(as.getName().equals(SizeEnum.S.toString()))
					tmp.setSize(SizeEnum.S);
				else if(as.getName().equals(SizeEnum.XL.toString()))
					tmp.setSize(SizeEnum.XL);
				availableSizes.add(tmp);
			}
			
			tshirt.setAvailableColors(availableColors);
			tshirt.setAvailableSizes(availableSizes);
			tshirts.add(tshirt);
		}
		return tshirts;
	}
}
