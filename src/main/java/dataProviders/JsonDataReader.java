package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import managers.FileReaderManager;

import testDataTypes.Customer;


public class JsonDataReader {
	//private final String customerFilePath = FileReaderManager.getInstance().getConfigReader().getTestDataResourcePath() + "Customer.json";

	private final String customerFilePath = FileReaderManager.getInstance().getConfigReader().getTestDataResourcesPath() + "\\Customer.json"; 
	private List <Customer> customerList;
	
	public JsonDataReader() {
		customerList= getCustomerData();
	}
	
	private List<Customer> getCustomerData()  {
		System.out.println("JsonDataReader -- executing getCustomerData");
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		
			try {
				System.out.println("JsonDataReader -- customerFilePath " + customerFilePath);
				bufferReader = new BufferedReader(new FileReader(customerFilePath));
				Customer[] customers = gson.fromJson(bufferReader, Customer[].class);
				System.out.println("JsonDataReader -- Customer length = " + customers.length);
				return Arrays.asList(customers);
			} catch (FileNotFoundException e) {
				throw new RuntimeException("Json file not found at path : " + customerFilePath);
				//e.printStackTrace();
			}
		finally {
			try { if(bufferReader != null) bufferReader.close();}
			catch (IOException ignore) {}
		}
	}
	
	/*
	public final Customer getCustomerByName(String customerName) {
		return customerList.stream().filter(x -> x.firstName.equalsIgnoreCase(customerName)).findAny().get();
	}
	*/
	
	public final Customer getCustomerByName(String customerName){
		System.out.println("JsonDataReader -- getCustomerByName =" + customerName);
		for(Customer customer : customerList) {
			System.err.println("JsonDataReader -- getCustomerByName -- customer = " + customer.firstName + "," + customer.lastName);
			if(customer.firstName.equalsIgnoreCase(customerName)) return customer;
		}
		return null;
	}

}
