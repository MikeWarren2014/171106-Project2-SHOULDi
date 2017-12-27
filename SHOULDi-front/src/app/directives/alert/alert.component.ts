import { Component,OnInit } from "@angular/core";
import { AlertService } from "../../services/alert.service";
import { AutoUnsubscribe } from "../../autoUnsubscribe";

@Component({
    selector    : 'alert',
    templateUrl : './alert.component.html'
})

@AutoUnsubscribe
export class AlertComponent
{
    message : any;

    constructor(private alertService : AlertService) 
    {

    }

    ngOnInit()
    {
        this.alertService.getMessage().subscribe(message => { this.message = message; });
    }
}