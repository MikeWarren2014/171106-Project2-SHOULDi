import { Component } from "@angular/core";
import { User } from "../../../models/user";

@Component({
    selector: "balance",
    templateUrl: "balance.component.html",
    styleUrls: ["balance.component.css"]
})

export class BalanceComponent{
    balance : number;
    data : any;

    constructor(){
        
    }
}