import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/map';
import { Customer } from './customer';
import { Orders } from './orders';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http : Http) { }

  validateCustomer(user : string, pwd : string) : Observable<string> {
    return this.
    http.get("http://localhost:8080/MLP192/api/customer/check/"+user+"/"+pwd).
    map((res : Response) => res.text());
  }
  findByCustomerName(user : string) : Observable<Customer> {
    return this.
    http.get("http://localhost:8080/MLP192/api/customer/viewcustomer/"+user).
    map((res : Response) => res.json());
  }
  orderHistory(cusId : number) : Observable<Orders[]> {
    return this.
    http.get("http://localhost:8080/MLP192/api/order/showOrders1/"+cusId).
    map((res : Response) => res.json());
  }
  orderidgetting(custId : number) : Observable<Orders[]> {
    return this.
    http.get("http://localhost:8080/MLP192/api/orders/getordid/"+custId).
    map((res : Response) => res.json());
  }
  pendingHistory(custId : number) : Observable<Orders[]> {
    return this.
    http.get("http://localhost:8080/MLP192/api/orderdetail/pendingcus/"+custId).
    map((res : Response) => res.json());
  }
  placeOrder(orders : Orders) : Observable<string> {
    return this.http.post("http://localhost:8080/MLP192/api/order/addOrder/",orders).
    map((res : Response) => res.text());
  }
  acceptOrder(ordId : number, cusId : number, status : String,) : Observable<string> {
    return this.http.post("http://localhost:8080/MLP192/api/orderdetail/cancelOrder/"+ordId + "/" +cusId+ "/" +status,null).
    map((res : Response) => res.text());
  }
  cancelOrder(tokenId : number, ordStatus : String) : Observable<String> {
    return this.
    http.get("http://localhost:8080/MLP192/api/order/cancelOrderStatus/"+tokenId + "/" +ordStatus,null).
    map((res : Response) => res.text());
  }
}
