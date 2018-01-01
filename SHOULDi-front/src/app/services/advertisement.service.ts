import { Injectable } from "@angular/core";
import { Http, Headers, RequestOptions, Response } from "@angular/http";
import { Advertisement } from "../models/advertisement";
import { HttpService } from "./http.service";
import { User } from "../models/user";
import { TokenService } from './token.service';
import 'rxjs/';

@Injectable()
export class AdvertisementService extends HttpService{

    getAllAdvertisementsByUser(user : User) // TODO: need to check endpoint
    {
        return this.http.post(this.BASE_URL + '/api/posts/ad/my/posts', {
            token   : TokenService.getToken()
        }).map((res : Response) => res.json());
    }

    create(advertisement: Advertisement){ // TODO: need to check endpoint
        return this.http.post(this.BASE_URL + '/api/posts/ad/post', 
        {
            token    : TokenService.getToken(),
            image    : advertisement.image,
            url : advertisement.url,
            amountToPay : advertisement.amount
        }).map((res : Response) => res.json());
    }

    deleteadvertisement(advertisement : Advertisement){ // TODO: need to check endpoint
        return this.http.post(this.BASE_URL + '/api/advertisements/delete', {
            token   : TokenService.getToken(),
            advertisementID  : advertisement._id
        }).map((res : Response) => res.json());
    }
}