import { Component } from '@angular/core';
import { Message } from '../../../../models/message';
import { MessageService } from '../../../../services/message.service';

@Component({
    selector: "create-messages",
    templateUrl: "create.messages.component.html",
    styleUrls: ["create.messages.component.css"]
})

export class CreateMessagesComponent{
    message : Message;
    constructor(private messageService : MessageService){

    }
    createMessage(){
        this.messageService.createBySender(this.message).subscribe();
    }
}
