import { Injectable } from "@angular/core";
import { Http, Response } from "@angular/http";

// import { User, Post } from '../models'; // TypeScript imports don't work like Java ones!
import { User } from "../models/user";
import { HttpService } from "./http.service";


@Injectable()
export class MessageService extends HttpService
{
    // TODO: get the endpoints
    getBySender(sender : User)
    {
        return this.http.get(this.BASE_URL + '/api/messages/senderId=' + sender._id).map((res : Response) => res.json());
    }
    getByRecipient(recipient : User)
    {
        return this.http.get(this.BASE_URL + '/api/messages/recipientId=' + recipient._id).map((res : Response) => res.json());
    }
    createBySender(sender : User)
    {
        return this.http.post(this.BASE_URL + '/api/messages/send', sender).map((res : Response) => res.json());
    }
    // TODO: write the rest of the CRUD operations
}