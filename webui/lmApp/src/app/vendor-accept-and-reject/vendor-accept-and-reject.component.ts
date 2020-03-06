import { Component, OnInit } from '@angular/core';
import { VendorService } from '../vendor.service';
import { Vendor } from '../vendor';

@Component({
  selector: 'app-vendor-accept-and-reject',
  templateUrl: './vendor-accept-and-reject.component.html',
  styleUrls: ['./vendor-accept-and-reject.component.css']
})
export class VendorAcceptAndRejectComponent implements OnInit {
  cusId : number;
  orderId : number;
  ordStatus : string;
  result : String;

  constructor(private _vendorService : VendorService) { }
  acceptOrReject() {
    this._vendorService.acceptOrReject(this.cusId, this.ordStatus).subscribe(x => {
      this.result= x;
    })
  }

  ngOnInit() {
  }

}

