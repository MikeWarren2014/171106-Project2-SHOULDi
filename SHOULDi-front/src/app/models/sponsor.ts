import { User } from './user'

export class Sponsor extends User{
    _id     : number;
    email   : string;
    balance : number;
}