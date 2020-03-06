import { Injectable } from '@angular/core';
import {Http, Response} from '@angular/http';
import {Observable} from 'rxjs';
import {Menu} from './menu';
import 'rxjs/add/operator/map';

@Injectable({
  providedIn: 'root'
})
export class MenuService {

  constructor(private http : Http) {}
  searchMenu(foodItemName : string) : Observable<Menu>{
    return this.
    http.get("http://localhost:8080/MLP192/api/menu/showAmt/"+foodItemName).
    map((res : Response)=> res.json());
}
  showMenu() : Observable<Menu[]>{
    return this.
    http.get("http://localhost:8080/MLP192/api/menu").
    map((res : Response)=> res.json());
}

}
