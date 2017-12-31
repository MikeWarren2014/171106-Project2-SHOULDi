import { Component } from '@angular/core';
import { Message } from '../../../../models/message';

@Component({
    selector: "my-messages",
    templateUrl: "my.messages.component.html",
    styleUrls: ["my.messages.component.css"]
})

export class MyMessagesComponent{
    messages : Message[];
    currentMessage : Message;
}