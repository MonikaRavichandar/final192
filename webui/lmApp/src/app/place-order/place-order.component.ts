import { Component, OnInit } from '@angular/core';
import { Orders } from '../orders';
import { Customer } from '../customer';
import { Menu } from '../menu';
import { Observable } from 'rxjs';
import { MenuService } from '../menu.service';
import { Vendor } from '../vendor';
import { VendorService } from '../vendor.service';
import { Wallet } from '../wallet';
import { WalletService } from '../wallet.service';
import { CustomerService } from '../customer.service';
@Component({
  selector: 'app-place-order',
  templateUrl: './place-order.component.html',
  styleUrls: ['./place-order.component.css']
})
export class PlaceOrderComponent implements OnInit {

  customer : Customer;
  menuList : Observable<Menu[]>;
  vendorList : Observable<Vendor[]>;
  walletList : Observable<Wallet[]>;
  result : string;
  //result2 : strin;
  menuFound : Menu;
  price : number;
  ordid : number;
  order : Orders;
  foodItemName: string;
  constructor(private _menuService : MenuService, private _vendorService : VendorService, private _walletService : WalletService, private _customerService : CustomerService) {
    this.customer = localStorage.getItem('customer')? JSON.parse(localStorage.getItem('customer')):[];
    this.model.cusId=this.customer.cusId;
    this.menuList = _menuService.showMenu();
    this.vendorList = _vendorService.showVendor();
    this.walletList=_walletService.showByWalletCustomerId(this.customer.cusId);
    this.menu.foodItemName="Dosa";
    //this.order =localSt;
   }
   showAmount() {
    //  alert("Hi");
    // alert(this.menu.menName);
  
   
    this.foodItemName= (this.menu.foodItemName);
    //console.log(foodId);
    this._menuService.searchMenu(this.foodItemName).subscribe(x => {
      this.menuFound = x;
      this.price=x.foodItemAmt;

    });
    // this.price = this.menuFound.menPrice;
   } 
   placeOrder() {
    
        console.log("cusid"+this.model.cusId);
        console.log("qua"+this.model.ordQty)
        console.log("foodItemname"+this.menu.foodItemName);
        console.log("date:"+this.model.ordDate);
        // console.log("modeL:" +this.model);
        // console.log("order id:"+this.model.tokenId);
        // console.log("ordCost:"+this.model.ordCost);

    // this.model.ordItemSel=(this.menu.foodItemName);
    //this.model.venId=parseInt(this.vendor.venName);
    //this.model.walType = this.wallet.walType;
    this._customerService.placeOrder(this.model).subscribe(x => {
      this.result= x;
    })
  /*   this._customerService.orderidgetting(this.model.cusId).subscribe(data => {
        console.log(data);
        //var myJSON = JSON.stringify(data);
        for (let x in data) {
          this.model.ordId = parseInt(data[x]);
        }
        localStorage.setItem("orid", this.model.ordId);
        console.log( this.model.ordId);
     
    }) */
   }


  model = new Orders();
  menu = new Menu();
  vendor = new Vendor();
  wallet = new Wallet();
  ngOnInit() {
  }

}
