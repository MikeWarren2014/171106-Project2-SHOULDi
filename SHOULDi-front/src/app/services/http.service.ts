import { Injectable } from "@angular/core";
import { Http } from "@angular/http";



@Injectable()
export class HttpService
{
    // the base url (including the port)
    ADDRESS = 'http://localhost';
    PORT    = 8084; // the port the REST API is on
    BASE_URL= this.ADDRESS + ':' + this.PORT;

    constructor(protected http : Http)
    {

    }
}
