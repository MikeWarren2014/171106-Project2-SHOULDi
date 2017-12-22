import { Injectable } from "@angular/core";
import { Http, Response } from "@angular/http";

// import { User, Post } from '../models'; // TypeScript imports don't work like Java ones!
import { User } from "../models/user";


@Injectable()
export class MessageService 
{
    // TODO: get the endpoints
    constructor (private http : Http)
    {
        
    }
    getBySender(sender : User)
    {
        return this.http.get('/messages/senderId=' + sender._id).map((res : Response) => res.json());
    }
    getByRecipient(recipient : User)
    {
        return this.http.get('/messages/recipientId=' + recipient._id).map((res : Response) => res.json());
    }
    createBySender(sender : User)
    {
        return this.http.post('/messages/send', sender).map((res : Response) => res.json());
    }
    // TODO: write the rest of the CRUD operations
}