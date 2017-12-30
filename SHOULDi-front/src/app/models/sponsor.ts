import { User } from './user'
import { UserRoles } from "./userRoles";

export class Sponsor extends User{
    _id     : number;
    balance : number;
    company : number;
    role = UserRoles.SPONSOR;
}