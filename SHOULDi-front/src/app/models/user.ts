import { UserRoles } from "./userRoles";

export class User
{
    _id             : number;
    username        : string;
    firstName       : string;
    lastName        : string;
    email           : string;
    password        : string;
    gender          : string;
    score           : number;
    role            : string   = UserRoles.BASE_USER;
    isModerator     : boolean;
    isLocked        : boolean;
    token           : string;
    
    constructor(username, firstName, lastName, email, score)
    {
        this.username = firstName;
        this.lastName = lastName;
        this.email    = email;
        this.score    = score;
    }
}