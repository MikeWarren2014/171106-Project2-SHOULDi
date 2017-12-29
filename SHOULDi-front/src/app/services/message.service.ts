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

    getBySender(user : User) // TODO: get the endpoint
    {
        return this.http.post(this.BASE_URL + '/api/messages', {
            token : TokenService.getToken(),
            userID : user._id
        }).map((res : Response) => res.json());
    }
    getByRecipient(user : User) // TODO: get the endpoint
    {
        return this.http.post(this.BASE_URL + '/api/messages', {
            token : TokenService.getToken(),
            userID : user._id
        }).map((res : Response) => res.json());
    }
    createBySender(user : User) // TODO: get the endpoint
    {
        return this.http.post(this.BASE_URL + '/api/messages/send', {
            token : TokenService.getToken(),
            user : user
        }).map((res : Response) => res.json());
    }
    deleteMessage(message : Message){
        return this.http.post(this.BASE_URL + '/api/messages/delete', {
            token : TokenService.getToken(),
            messageID : message._id
        }).map((res : Response) => res.json());
    }
    // TODO: write the rest of the CRUD operations
}