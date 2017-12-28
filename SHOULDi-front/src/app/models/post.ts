import { User } from "./user";


export class Post {
    _id         : number;
    poster      : User; // may replace with _posterId : number
    postDate    : Date;
    image       : string;
    occasion    : string;
    comments    : Comment[]; 
    likes       : number;
    dislikes    : number;
    isFlagged   : boolean;
}