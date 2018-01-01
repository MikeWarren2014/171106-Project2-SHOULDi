import { Component } from '@angular/core';
import { Message } from '../../../../models/message';
import { MessageService } from '../../../../services/message.service';

@Component({
    selector: "my-messages",
    templateUrl: "my.messages.component.html",
    styleUrls: ["my.messages.component.css"]
})

export class MyMessagesComponent{
    messages : any[];
    currentMessage : any;

    constructor(private messageService : MessageService){

    }

    ngOnInit() {
        //Called after the constructor, initializing input properties, and the first call to ngOnChanges.
        this.messageService.getByRecipient().subscribe(data => {
            this.messages = data;
        });
    }

    deleteMessage(message : any){
        this.messageService.deleteMessage(message).subscribe();
        for(let msg in this.messages){
            if(msg === message){
                msg = null;
            }
        }
    }
}