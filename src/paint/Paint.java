package paint;

import java.util.ArrayList;
import java.util.List;

import effective_Java.chapter34.Operation;
import effective_Java.chapter34.PayrollDay;
import effective_Java.chapter75.Member;
import util.Order;
import util.ResponseDto;
import util.Status;

public class Paint {

	public static void main(String[] args) {
		int num = 0;
		int plus = 3;
		int index = 0;
		while(num < 1000000000) {
			num += plus;
			plus += 2;
			index++;
		}
		System.out.println("num : "+num);
		System.out.println("plus : "+plus);
		System.out.println("index : "+index);
		
		Order order = new Order(4L, "노트북", 490_000, "2023-06-23");
		
		List<Order> orderList = new ArrayList<>();
		orderList.add(new Order(1L, "종이컵", 100, "2023-05-17"));
		orderList.add(new Order(2L, "마우스", 5000, "2023-06-04"));
		orderList.add(new Order(3L, "키보드", 13000, "2023-07-01"));
		
		ResponseDto<Order> response = new ResponseDto<>(Status.OK.code(), Status.OK.message(), order);
		ResponseDto<List<Order>> responseList = new ResponseDto<>(Status.ERROR.code(), Status.ERROR.message(), orderList);
		
		System.out.println("response : " +response.getData().toString());
		System.out.println("resopnse code : " +response.getCode() + " response message : "+response.getMessage());
		System.out.println("responseList : " +responseList.getData().get(0).toString());
		System.out.println("responseList : " +responseList.getData().get(1).toString());
		System.out.println("responseList : " +responseList.getData().get(2).toString());
		System.out.println("responseList code : " +responseList.getCode() + " responseList message : "+responseList.getMessage());
		
		for(Status status : Status.values()) {
			System.out.println("status code : " +status.code() + " and its message : " +status.message());
		}
		
		double x = 100, y = 37;
		for(Operation op : Operation.values()) {
			System.out.printf("%f %s %f = %f\n",x,op,y,op.apply(x, y));
		}
		
		for(PayrollDay pr : PayrollDay.values()) {
			System.out.println(pr.pay(49, 7));
		}
		
		Member member = Member.create("영상",27,"ys2023");
	}

}
