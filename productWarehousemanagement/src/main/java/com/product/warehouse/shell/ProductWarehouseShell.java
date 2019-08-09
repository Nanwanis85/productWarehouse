package com.product.warehouse.shell;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import com.product.warehouse.exception.ProductWarehouseException;
import com.product.warehouse.model.Product;
import com.product.warehouse.model.ProductWareHouseReciept;
import com.product.warehouse.model.Rack;
import com.product.warehouse.service.ProductRecieptWarehouseService;
import com.product.warehouse.service.ProductWarehouseService;
import com.product.warehouse.service.RackWarehouseService;

@ShellComponent
public class ProductWarehouseShell {
	
	@Autowired
	private RackWarehouseService rackWarehouseService;
	
	@Autowired
	private ProductWarehouseService productWarehouseService;
	
	@Autowired
	private ProductRecieptWarehouseService productRecieptWarehouseService;
	
    @ShellMethod("Add Racks to the warehouse")
    public String warehouse(int noOfRack) {
    	List<Rack> rackList = new ArrayList<>();
    	for(int i=0;i<noOfRack;i++) {
    		Rack rack = new Rack();
    		rack.setSlotNo(i+1);
    		rackList.add(rack);
    	}
    	rackWarehouseService.addRacks(rackList);
    	return "Created a warehouse with " +noOfRack+" slots";
    }
    
    @ShellMethod("Add Product to the warehouse")
    public String store(String productCode, String productColor) throws ProductWarehouseException {
    	Product product = new Product();
    	product.setProductCode(productCode);
    	product.setProductColor(productColor);
    	int slotNo = productWarehouseService.addProduct(product);
    	return "Allocated Slot number "+slotNo;
    }
    
    @ShellMethod("Sell Product from the warehouse")
    public String sell(int slotNo) {
    	productRecieptWarehouseService.emptyRack(slotNo);
    	return "Rack No "+slotNo+" is free";
    }
    
    @ShellMethod("Status of the warehouse")
    public void status() {
    	List<ProductWareHouseReciept> recieptList = productRecieptWarehouseService.getAllReciepts();
    	System.out.println("SlotNO\t\tProduct_Code   \t\tColor");
    	for (ProductWareHouseReciept productWareHouseReciept : recieptList) {
    		System.out.print(productWareHouseReciept.getRack().getSlotNo()+"\t\t"+productWareHouseReciept.getProduct().getProductCode()+"\t\t"+productWareHouseReciept.getProduct().getProductColor());
    		System.out.println();
    	}
    												
    }
    
    @ShellMethod("Search Product with particular color from the warehouse")
    public String slot_numbers_for_products_with_colour(String colorName) {
    	List<ProductWareHouseReciept> recieptList =  productRecieptWarehouseService.searchProductsSlotNoByColor(colorName);
    	List<String> slotNoList = new ArrayList<>();
    	for (ProductWareHouseReciept productWareHouseReciept : recieptList) {
    		slotNoList.add(Integer.toString(productWareHouseReciept.getRack().getSlotNo()));
		}
    	return slotNoList.toString();
    }
    
    @ShellMethod("search product using code")
    public int slot_number_for_product_code(String productCode) {
    	int slotNo = productRecieptWarehouseService.searchProductByCode(productCode);
    	return slotNo;
    }
    
    @ShellMethod("Search Product with particular color from the warehouse")
    public String product_codes_for_products_with_colour(String colorName) {
    	List<ProductWareHouseReciept> recieptList =  productRecieptWarehouseService.searchProductsSlotNoByColor(colorName);
    	List<String> slotNoList = new ArrayList<>();
    	for (ProductWareHouseReciept productWareHouseReciept : recieptList) {
    		slotNoList.add(productWareHouseReciept.getProduct().getProductCode());
		}
    	return slotNoList.toString();
    }
}
