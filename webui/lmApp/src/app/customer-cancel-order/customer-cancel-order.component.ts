import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';

 @Component({
  selector: 'app-customer-cancel-order',
  templateUrl: './customer-cancel-order.component.html',
  styleUrls: ['./customer-cancel-order.component.css']
}) 
export class CustomerCancelOrderComponent implements OnInit {

  tokenId : number;
  ordId : number;
  ordStatus : string;
  result : String;

  constructor(private _customerService : CustomerService) { }
  cancel() {
    this._customerService.cancelOrder(this.tokenId, this.ordStatus).subscribe(x => {
      this.result=x;
    })
  }

  ngOnInit() {
  }
}
