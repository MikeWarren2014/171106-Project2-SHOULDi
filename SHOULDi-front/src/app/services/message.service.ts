import { Injectable } from "@angular/core";
import { Http, Response } from "@angular/http";

// import { User, Post } from '../models'; // TypeScript imports don't work like Java ones!
import { User } from "../models/user";
import { HttpService } from "./http.service";
import { TokenService } from "./token.service";
import { Message } from "../models/message";

@Injectable()
export class MessageService extends HttpService
{
    // TODO: get the endpoints

    getBySender(sender : User) // TODO: get the endpoint
    {
        return this.http.get(this.BASE_URL + '/api/messages/' + sender._id).map((res : Response) => res.json());
    }
    getByRecipient(recipient : User) // TODO: get the endpoint
    {
        return this.http.get(this.BASE_URL + '/api/messages/' + TokenService.getToken()).map((res : Response) => res.json());
    }
    createBySender(sender : User) // TODO: get the endpoint
    {
        return this.http.post(this.BASE_URL + '/api/messages/send', sender).map((res : Response) => res.json());
    }
    deleteMessage(message : Message){
        return this.http.delete(this.BASE_URL + '/api/messages/delete/' + message._id);
    }
    // TODO: write the rest of the CRUD operations
}