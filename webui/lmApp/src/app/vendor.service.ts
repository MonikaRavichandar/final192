import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/map';
import { Vendor } from './vendor';
import { Orders } from './orders';
@Injectable({
  providedIn: 'root'
})
export class VendorService {

  constructor(private http : Http) { }

  validateVendor(user : string, pwd : string) : Observable<string> {
    return this.
    http.get("http://localhost:8080/MLP192/api/vendor/loginVendor/"+user+"/"+pwd).
    map((res : Response) => res.text());
  }
  findByVendorName() : Observable<Vendor[]> {
    return this.
    http.get("http://localhost:8080/MLP192/api/vendor").
    map((res : Response) => res.json());
  }
  showOrders()  : Observable<Orders[]> {
    return this.
    http.get("http://localhost:8080/MLP192/api/order/").
    map((res : Response) => res.json());
  } 
pendingHistory(vendId : number) : Observable<Orders[]> {
  return this.
  http.get("http://localhost:8080/MLP192/api/order").
  map((res : Response) => res.json());
}
  searchVendor(venName : number) : Observable<Vendor>{
    return this.
    http.get("http://localhost:8080/MLP192/api/vendor/VendorName/"+venName).
    map((res : Response)=> res.json());
}
showVendor() : Observable<Vendor[]>{
  return this.
  http.get("http://localhost:8080/MLP192/api/vendor").
  map((res : Response)=> res.json());
}
acceptOrReject(cusId : number, ordStatus : String) : Observable<String> {
  return this.
  http.get("http://localhost:8080/MLP192/api/order/updateOrderStatus/"+cusId + "/" +ordStatus,null).
  map((res : Response) => res.text());
}

}